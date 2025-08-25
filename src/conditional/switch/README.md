# 조건문 (switch-case)

`switch-case`는 **여러 값 중 하나와 일치하는 경우를 선택하여 실행하는 조건문**입니다. 주로 값이 명확하게 나뉘는 경우에 사용됩니다.

---

기본 구조:

```java
switch (변수) {
    case 값1:
        // 변수 값이 값1과 일치할 때 실행
        break;
    case 값2:
        // 변수 값이 값2와 일치할 때 실행
        break;
    default:
        // 어느 case와도 일치하지 않을 때 실행
        break;
}
```

- `break`는 해당 case 실행 후 switch문을 종료
- `default`는 생략 가능하지만, 없으면 일치하는 값이 없을 경우 아무 것도 실행되지 않음

---

중첩은 일반적으로 권장되지 않지만, case 안에서 다른 switch를 사용할 수 있음:

```java
int x = 2;
switch (x) {
    case 1:
        System.out.println("One");
        break;
    case 2:
        switch (x % 2) {
            case 0:
                System.out.println("Even");
                break;
            default:
                System.out.println("Odd");
                break;
        }
        break;
    default:
        System.out.println("Other");
        break;
}
```

- 위 예제에서 `x = 2`이면 "Even" 출력

---

주의 사항:
- break를 빼면 **fall-through** 현상 발생 (다음 case까지 실행)
- case 값은 **정수, 문자열, enum** 등 제한적
- 조건이 범위에 따라 달라지는 경우는 if-else가 더 적합
