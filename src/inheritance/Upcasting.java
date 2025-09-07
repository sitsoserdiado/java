package inheritance;

class Shape2 {
	protected int x, y;
	
	public void draw() {
		System.out.println("Shape Draw");
	}
}

class Rectangle2 extends Shape2 {
	@SuppressWarnings("unused") // 컴파일러 경고 무시 어노테이션
	private int width, height;
	
	public void draw() {
		System.out.println("Rectangle Draw");
	}
}

class Triangle2 extends Shape2 {
	@SuppressWarnings("unused") // 컴파일러 경고 무시 어노테이션
	private int base, height;
	
	public void draw() {
		System.out.println("Triangle Draw");
	}
}

class Circle2 extends Shape2 {
	@SuppressWarnings("unused") // 컴파일러 경고 무시 어노테이션
	private int radius;
	
	public void draw() {
		System.out.println("Circle Draw");
	}
}

public class Upcasting {

	public static void main(String[] args) {
		@SuppressWarnings("unused") // 컴파일러 경고 무시 어노테이션
		Shape2 s1, s2;
		
		s1 = new Shape2(); // 당연히 됨.
		
		s2 = new Rectangle2();
		/**
		 * 부모 클래스 변수로 자식 클래스 객체를 참조할 수 있다. 이것을 업캐스팅이라고 한다.
		 * 자식 클래스 중에서 부모 클래스로부터 상속받은 부분만 s2를 통해 사용할 수 있다.
		 * 즉, s2.width = 100; 은 컴파일 오류가 발생한다.
		 * 
		 * 어떤 멤버를 사용할 수 있느냐는 변수의 타입에 의하여 결정된다.
		 * 객체의 타입에 의해 결정되는 것은 아니다.
		 * 부모 클래스 변수를 가지고 자식 클래스의 객체를 참조하는 경우에는 부모 클래스에서 정의된 부분만을 사용할 수 있다.
		 * 부모 클래스는 자식 클래스가 무엇을 추가하였는지 알 방법이 없기 때문이다.
		 */
	}

}
