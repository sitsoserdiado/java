# 패키지
패키지는 관련있는 클래스들을 하나로 묶은 것이다.  
패키지는 두 가지 종류로 나눌 수 있다.  
1. 자바에서 기본적으로 제공하는 패키지
2. 사용자가 정의하는 패키지

<br><br>

## 왜 패키지가 필요할까
1. 서로 관련된 클래스들을 하나의 단위로 모을 수 있다.  
유사한 클래스들이 패키지로 묶여 있으면 **유지 관리가 쉬워진다.**
2. **세밀한 접근 제어**를 구현할 수 있다.
3. 원칙적으로 모든 클래스는 서로 다른 이름을 가져야 한다.  
따라서 이러한 이름 충돌을 방지할 방법이 필요한데 패키지는 이런 경우에 사용할 수 있는 중요한 도구이다.  
패키지만 다르면 **동일한 클래스 이름을 사용할 수 있다.**

<br><br>

## 패키지 선언하기
소스 파일을 패키지에 넣으려면 소스 파일의 맨 처음에 "**package 패키지이름;**"을 넣으면 된다.

```java
package 패키지이름;
```

패키지 선언문은 반드시 소스 파일 첫 번째 문장이어야 한다.  
여러 개의 소스 파일에 동일한 패키지 선언문을 넣을 수 있다.  
<br>
일반적으로 패키지는 계층 구조가 될 수 있다. 예를 들어 pkg1 패키지 안에 pkg2 패키지를 넣고 싶은 경우에는 다음과 같이 패키지를 선언하면 된다.

```java
package pkg1.pkg2;
```

<br><br>

## 패키지 사용하기
1. 완전한 이름으로 참조
    - 외부 패키지에 있는 클래스를 사용하려면 원칙적으로는 앞에 패키지를 붙인 정식 클래스 이름을 써주어야 한다.
        ```java
        graphics.Rectangle myRect = new graphics.Rectangle();
        ```
        자주 사용하지 않는 클래스인 경우에는 위의 방식도 괜찮다.  
        그러나 반복적으로 많이 사용되는 클래스인 경우에는, 읽기도 힘들고 입력하기도 불편하다.  
        따라서 이런 경우에는 import를 사용하여서 해당 클래스나 패키지를 포함하는 것이 좋다.  
        <br>
2. 원하는 패키지 멤버만 포함
    - 외부 패키지의 특정한 멤버를 import하려면 다음과 같은 문장을 사용한다.
        ```java
        import graphics.Reactangle;
        ```
        클래스가 포함되었으면 이제부터는 클래스 이름만 사용해서 참조가 가능하다.
        ```java
        Rectangle myRect = new Rectangle();
        ```
        만약 외부 패키지에서 몇 개의 클래스만을 사용하는 경우라면 이 방법도 괜찮다.  
        하지만 외부 패키지에서 많은 클래스를 사용한다면 전체 패키지를 포함하는 것이 낫다.  
        <br>
3. 전체 패키지를 포함한다.
    - 별표 문자(*)를 사용하면 된다.
        ```java
        import graphics.*; // 패키지의 모든 클래스 포함
        ```
        패키지 전체가 포함되면 패키지 이름을 생략하고 클래스 이름으로만 참조할 수 있다.
        ```java
        Rectangle myRect = new Rectangle();
        ```

<br>

### 계층 구조의 패키지 포함하기
계층적으로 구성된 패키지의 경우, 주의해야 할 사항이 있다. 예를 들어서 java.awt.*를 포함시키면 java.awt 아래에 있는 패키지, 즉 java.awt.font와 같은 패키지가 자동으로 포함될 거라고 생각하기 쉽다. 그러나 java.awt.font 패키지는 자동으로 포함되지 않는다. 다음과 같이 별도로 포함하여야 한다.
```java
import java.awt.*; // java.awt 패키지의 클래스 포함
import java.awt.font.*; // java.awt.font 패키지의 클래스 포함
```

<br><br>

## Object 클래스
자바에서는 클래스를 정의할 때 명시적으로 부모 클래스를 선언하지 않으면 Object 클래스가 부모 클래스가 된다. Object 클래스는 java.lang 패키지에 들어 있으며, 자바 클래스 계층 구조에서 맨 위에 위치하는 클래스이다.  
<br>
Object 안에 정의되어 있는 메소드는 다음과 같다.
- public boolean equals(Object obj): obj가 이 객체와 같은지를 검사한다.
- public String toString(): 객체의 문자열 표현을 반환한다.
- protected Object clone(): 객체 자신의 복사본을 생성하여 반환한다.
- public int hashCode(): 객체에 대한 해쉬 코드를 반환한다.
- protected void finalize(): 가비지 컬렉터에 의하여 호출된다.
- public final Class getClass(): 객체의 클래스 정보를 반환한다.

<br><br>

## 랩퍼 클래스
랩퍼 클래스는 여러 가지 유용한 메소드를 제공한다. 특히 저장된 값을 다른 자료형으로 변환하는 메소드를 제공한다. 예를 들어서 integer 클래스가 제공하는 메소드 중 일부를 살펴보면 다음과 같다.
| 메소드                                 | 반환형       | 설명                                      |
| ----------------------------------- | --------- | --------------------------------------- |
| `intValue()`                        | `int`     | `Integer` 객체에 저장된 값을 기본형 `int`로 반환      |
| `parseInt(String s)`                | `int`     | 문자열을 기본형 `int`로 변환                      |
| `parseInt(String s, int radix)`     | `int`     | 지정한 진법(`radix`)의 문자열을 `int`로 변환         |
| `valueOf(int i)`                    | `Integer` | 기본형 `int` 값을 `Integer` 객체로 반환           |
| `valueOf(String s)`                 | `Integer` | 문자열을 `Integer` 객체로 변환                   |
| `valueOf(String s, int radix)`      | `Integer` | 지정한 진법(`radix`)의 문자열을 `Integer` 객체로 변환  |
| `toString()`                        | `String`  | `Integer` 객체의 값을 문자열로 반환                |
| `toString(int i)`                   | `String`  | 기본형 `int` 값을 문자열로 변환 (정적 메소드)           |
| `toString(int i, int radix)`        | `String`  | `int` 값을 지정한 진법(`radix`)의 문자열로 변환       |
| `compare(int x, int y)`             | `int`     | 두 `int` 값을 비교 (같으면 0, 작으면 음수, 크면 양수 반환) |
| `compareTo(Integer anotherInteger)` | `int`     | 현재 `Integer` 객체와 다른 `Integer` 객체를 비교    |
| `equals(Object obj)`                | `boolean` | 두 `Integer` 객체의 값이 같은지 비교               |

만약 정수 100을 문자열로 변환하고 싶다면 Integer 클래스의 toString() 메소드를 이용한다.
```java
String s = Integer.toString(100); // s는 "100"
```

이번에는 반대로 문자열 "100"을 정수 100으로 변환하려면 Integer 클래스의 parseInt() 메소드를 사용한다.
```java
int i = Integer.parseInt("100");
```