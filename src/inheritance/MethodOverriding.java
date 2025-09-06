package inheritance;

class Shape {
	public void draw() {
		System.out.println("Shape");
	}
	
	// 정적 메소드를 오버라이드하는 경우
	public static void A() {
		System.out.println("static method in Shape");
	}
}

class Circle extends Shape {
	@Override
	public void draw() {
		System.out.println("Circle");
	}
}

class Triangle extends Shape {
	@Override
	public void draw() {
		super.draw(); // 키워드 super. 부모 클래스의 draw() 호출.
		System.out.println("Triangle");
	}
}

class Rectangle extends Shape {
	public static void A() {
		System.out.println("static method in Rectangle");
	}
}

public class MethodOverriding {

	public static void main(String[] args) {
		// method overriding
		Circle c = new Circle();
		c.draw();
		
		// super
		Triangle t = new Triangle();
		t.draw();
		
		// static
		@SuppressWarnings("unused") // 컴파일러 경고 무시 어노테이션
		Shape s = new Rectangle();
		Rectangle.A();
		Shape.A(); // A()가 정적 메소드가 아니라 동적 메소드였다면 Rectangle에 있는 메소드가 실행됐을 것.
	}

}
