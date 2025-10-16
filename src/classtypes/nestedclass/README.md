# 중첩 클래스
자바에서는 클래스 안에서 클래스를 정의할 수 있다.  
내부에 클래스를 가지고 있는 클래스를 외부 클래스라고 한다.  
클래스 내부에 포함되는 클래스를 **중첩 클래스**(nested class)라고 한다.

```java
class OuterClass {
    class NestedClass {

    }
}
```

<br><br>

## 중첩 클래스의 종류
- 정적 중첩 클래스: 앞에 static이 붙어서 내장되는 클래스
- 비정적 중첩 클래스: static이 붙지 않은 일반적인 중첩 클래스
    - **내부 클래스**(inner class): 클래스의 멤버처럼 선언되는 중첩 클래스
    - **지역 클래스**(local class): 메소드의 몸체 안에서 선언되는 중첩 클래스
    - **익명 클래스**(anonymous class): 수식의 중간에서 선언되고 바로 객체화되는 클래스

<br><br>

## 내부 클래스
클래스 안에 클래스를 선언하는 경우이다.  
내부 클래스의 접근 지정자는 public, private, protected 또는 package(default)일 수 있다.  
내부 클래스는 외부 클래스의 인스턴스 변수와 메소드를 전부 사용할 수 있다.  
private으로 선언되어 있어도 접근이 가능하다.  
이것이 내부 클래스의 최대 장점이다.

```java
class OuterClass {
    private int value = 10;

    class InnerClass {
        public void myMethod() {
            System.out.println("외부 클래스의 private 변수 값: " + value);
        }
    } // 이게 내부 클래스. 내부 클래스 안에서는 외부 클래스의 private 변수들을 참조할 수 있다.

    OuterClass() {
        InnerClass obj = new InnerClass(); // 내부 클래스를 사용한다.
        obj.myMethod();
    }
}

public class InnerClassTest {
    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
    }
}

실행 결과: 외부 클래스의 private 변수 값: 10
```

<br><br>

## 지역 클래스
지역 클래스는 메소드 안에 정의되는 클래스이다.  
이 메소드는 접근 제어 지정자를 가질 수 없다.  
지역 클래스는 abstract 또는 final로만 지정할 수 있다.

```java
class LocalInner {
    private int data = 30;
    void display() {
        final String msg = "현재의 데이터값은 ";

        class Local {
        /**
         * 메소드 display() 안에 클래스 Local이 정의되어 있다.
         * 지역 클래스는 메소드 안에서만 사용 가능하다.
         * 외부 클래스의 private 변수에 접근할 수 있다.
         **/
            void printMsg() {
                System.out.println(msg + data);
            }
        }
        
         Local obj = new Local();
         obj.printMsg();
    }
}

public class LocalInnerTest {
    public static void main(String args[]) {
        LocalInner obj = new LocalInner();
        obj.display();
    }
}

실행 결과: 현재의 데이터값은 30
```

지역 클래스는 외부 클래스의 인스턴스 변수뿐만 아니라 메소드의 지역 변수에도 접근할 수 있다.  
하지만 지역 변수는 반드시 final로 선언되어야 한다.  
이것은 지역 클래스 인스턴스가 메소드 호출보다 더 오랜 기간 동안 존재할 수도 있기 때문이다.  
메소드가 종료되어도 지역 클래스 인스턴스는 존재할 수도 있기 때문이다.  
그래서 변수의 자체 복사본을 필요로 하고 반드시 final로 선언되어야 한다.

<br><br>

## 익명 클래스
클래스 몸체는 정의되지만 이름이 없는 클래스이다.  
익명 클래스는 클래스를 정의하면서 동시에 객체를 생성하게 된다.  
이름이 없기 때문에 한 번만 사용이 가능하다.  
익명 클래스는 부모 클래스에서 상속을 받아서 작성하거나 인터페이스를 구현하여서 작성할 수 있다.  
new 키워드 다음에 부모 클래스 이름이나 인터페이스 이름을 적어주면 된다.  
부모 클래스 이름을 적으면 그 부모 클래스에서 상속을 받는다는 의미이고, 인터페이스 이름인 경우에는 그 인터페이스를 구현하는 클래스라는 의미이다.  

```java
부모클래스 참조변수 = new 부모클래스() {
    // 클래스 구현
}; // 익명 클래스는 단순한 클래스 정의문이 아니라, new 키워드를 이용한 객체 생성 식이다. 따라서 세미콜론을 붙여야 한다.
```

```java
public interface RemoteControl {
    void turnOn();
    void turnOff();
}

public class AnonymousClassTest {
    public static void main(String args[]) {
        RemoteControl ac = new RemoteControl() {
            public void turnOn() {
                System.out.println("TV turnOn()");
            }
            public void turnOff() {
                System.out.println("TV turnOff()");
            }
        }; // 익명 클래스가 정의되면서 동시에 객체도 생성된다. 그렇기 때문에 세미 콜론을 붙여야 한다.
        
        ac.turnOn();
        ac.turnOff();
    }
}

실행 결과:
TV turnOn()
TV turnOff()
```

익명 클래스도 내부 클래스와 같이 필드와 다른 메소드들을 정의할 수 있다.  
다만 메소드 안에 정의되는 지역 변수 중에서는 Java 7까지는 final로 선언된 변수만 사용 가능하고, Java 8부터는 값이 변경되지 않는 'effectively final' 변수라면 final을 명시하지 않아도 사용이 가능하다.   
익명 클래스는 주로 그래픽 사용자 인터페이스의 이벤트 처리기를 구현하는 경우에 많이 사용되는데, 이벤트 처리 객체는 하나만 생성되면 되기 때문이다. 구태여 클래스 이름을 붙일 필요가 없는 것이다.