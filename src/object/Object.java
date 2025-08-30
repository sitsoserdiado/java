package object;

class Circle {
	// 필드
	public int radius;
	public String color;
	
	// 메소드
	public double getArea() {
		return 3.14 * radius * radius;
	}
}

public class Object {

	public static void main(String[] args) {
		// 참조 변수 선언 및 객체 생성
		Circle obj = new Circle();
		
		// 객체의 필드 접근
		obj.radius = 100;
		obj.color = "blue";
		
		// 객체 메소드 접근
		double area = obj.getArea();
		
		System.out.println("원의 면적: " + area);
	}

}
