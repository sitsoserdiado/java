# 인터페이스
인터페이스는 클래스들이 따라야 할 규칙(약속, 계약) 을 정의하는 일종의 설계도이다.  
즉, 무엇을 할 수 있는지(메서드 시그니처)만 정의하고, 어떻게 할지(구현) 는 강제하지 않는다.
<br>
인터페이스는 추상 메소드들과 디폴트 메소드들로 이루어진다.  
인터페이스 안에서 필드(변수)는 선언될 수 없다.  
상수는 정의할 수 있다.


```java
public interface RemoteControl {
    void turnOn();
    void turnOff();
}
```

메소드들은 모두 이름과 매개 변수만 존재하고, 몸체가 없으며 세미콜론으로 종료되는 점에 유의하여야 한다.  
이너페이스 안에서 선언되는 메소드들은 모두 묵시적으로 public abstract이다.  
따라서 public이나 abstract 수식어는 없어도 된다.  
<br>
인터페이스 앞에도 public이 붙을 수 있으며 public이 붙으면 어떤 패키지의 어떤 클래스도 사용할 수 있다.  
인터페이스도 extends 키워드를 붙여서 다른 인터페이스를 상속받을 수 있다.
<br>
인터페이스는 다른 클래스에 의하여 **구현**(implement)될 수 있다.  
인터페이스를 구현한다는 말은 인터페이스에 정의된 추상 메소드의 몸체를 정의한다는 의미이다.  
클래스가 인터페이스를 구현하기 위해서는 **implements** 키워드를 사용한다.

```java
class Television implements RemoteControl {
    boolean on;
    void turnOn() {
        on = true;
        System.out.println("TV가 켜졌습니다.");
    }
    void turnOff() {
        on = false;
        System.out.println("TV가 꺼졌습니다.");

    }
}
```

인터페이스를 어떤 클래스가 사용하기 위해서는 인터페이스에 포함된 모든 추상 메소드를 구현하여야 한다.

<br><br>

## 인터페이스 vs 추상 클래스
둘 다 객체화할 수 없고 주로 구현이 안 된 메소드들로 이루어진다.  
하지만 추상 클래스에서는 일반적인 필드도 선언할 수 있으며, 일반적인 메소드도 정의할 수 있다.  
인터페이스에서 모든 메소드는 public abstract가 된다. 추가적으로 자바에서는 하나의 클래스만 상속받을 수 있지만 여러 개 인터페이스를 동시에 구현할 수 있다.  
<br>
그렇다면 추상 클래스와 인터페이스는 언제 사용해야 하는가?  
다음과 같은 경우에는 추상 클래스를 사용한다.
- 만약 관련된 클래스들 사이에서 코드를 공유하고 싶다면 추상 클래스를 사용하는 것이 좋다.
- 공통적인 필드나 메소드의 수가 많은 경우, 또는 public 이외의 접근 지정자를 사용해야 하는 경우에 추상 클래스를 사용한다.
- 정적이 아닌 필드나 상수가 아닌 필드를 선언하기를 원할 때 사용한다.
<br>

인터페이스는 다음과 같은 경우에 사용한다.
- 관련 없는 클래스들이 동일한 동작을 구현하기를 원할 때 사용한다.
- 특정한 자료형의 동작을 지정하고 싶지만 누가 구현하든지 신경쓸 필요가 없을 때 사용한다.
- 다중 상속이 필요할 때 사용한다.

<br><br>

## 인터페이스를 이용한 다중 상속
인터페이스끼리도 상속이 가능하다.  
<br>
**다중 상속**(Multiple inheritance)은 하나의 클래스가 여러 개의 부모 클래스를 가지는 것이다.  
다중 상속은 애매모호한 상황을 만들 수 있기 때문에 자바에서는 금지되어 있다.  
하지만 부모 클래스를 하나만 허용하는 것은 너무 엄격하다. 때에 따라서는 다중 상속이 필요한 것이다.  
자바에서는 인터페이스를 이용하여서 다중 상속과 비슷한 효과를 낼 수 있다.  
하나의 클래스로부터 상속을 받으면서 동시에 여러 개의 인터페이스도 구현하면 다중 상속과 비슷해진다.  
<br>
첫 번째 방법은 여러 개의 인터페이스를 동시에 구현하는 것이다.

```java
interface Drivable {
    void drive();
}

interface Flyable {
    void fly();
}

public class FlyingCar1 implements Drivable, Flyable {
    public void drive() {
        System.out.println("driving");
    }
    public void fly() {
        System.out.println("flying");
    }

    public static void main(String args[]) {
        FlyingCar1 obj = new FlyingCar1();
        obj.drive();
        obj.fly();
    }
}

실행 결과:
        driving
        flying
```

두 번째 방법은 하나의 클래스를 상속받고 또 하나의 인터페이스를 구현하는 것이다.

```java
interface Flyable {
    void fly();
}

class Car {
    int speed;
    void setSpeed(int speed) {
        this.speed = speed;
    }
}

public class FlyingCar2 extends Car implements Flyable {
    public void fly() {
        System.out.println("flying");
    }

    public static void main(String args[]) {
        FlyingCar2 obj = new FlyingCar2();
        obj.setSpeed(300);
        obj.fly();
    }
}

실행 결과:
        flying
```

## 상수 정의
인터페이스에는 상수를 정의할 수 있다. 인터페이스에서 정의된 변수는 자동적으로 public static final이 되어서 상수가 된다.

```java
public interface MyConstants {
    int NORTH = 1;
    int EAST = 2;
    int SOUTH = 3;
    int WEST = 4;
}
```

MyConstants.EAST와 같이 상수를 참조할 수 있다. 만약 클래스가 MyConstants 인터페이스를 구현한다면 단순히 EAST라고 써주어도 된다.