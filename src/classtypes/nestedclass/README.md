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