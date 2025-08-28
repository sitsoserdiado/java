# for
for 문은 정해진 횟수만큼 반복할 때 사용하는 반복 구조이다. for 루프(loop)라고도 한다. for 문은 반복 구조 중에서 가장 많이 사용되는데 그 이유는 많은 장점이 있기 때문이다.

```java
for (int i = 0; i < 10; i++) {
	System.out.println("Hello");
}
```
여기서 i = 0은 초기식, i < 10은 조건식, i++은 증감식이다.  
**초기식**은 반복 루프를 시작하기 전에 한 번만 실행된다. 제어 변수를 선언하고 초기화하는 용도로 많이 사용된다.  
**조건식**은 반복의 조건을 검사하는 수식이다. 이 수식의 값이 true이면 반복이 계속되고 false가 되면 반복이 중단된다.  
**증감식**은 한 번의 반복 루프가 끝나면 증감식이 실행된다.

<br>

# while
while 문은 어떤 조건을 정해놓고 반복을 하는 구조이다.

```java
int i = 0;
while (i < 10) {
	System.out.println("Hello");
	i++;
}
```
i < 10이 **조건식**인데 조건식이 참이면 문장을 반복실행한다.

<br>

## break
break 문은 반복문을 벗어날 때 사용한다. break 문이 실행되면 현재의 반복문을 벗어나게 된다.

```java
for (int i = 0; i < 6; i++) {
	if (i == 4) {
		break;
	}
	System.out.print(i);
}

실행결과: 0123
```

<br>

## continue
continue 문은 반복문에서 현재의 반복을 건너뛰어서 다음 반복으로 넘어가게 한다.

```java
for (int i = 0; i < 6; i++) {
	if (i == 4) {
		continue;
	}
	System.out.print(i);
}

실행결과: 01235
```



