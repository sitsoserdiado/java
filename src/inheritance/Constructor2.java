package inheritance;

// 기본 생성자가 정의되어 있지 않은 경우
class Base2 {
	public Base2(int i) {
		System.out.println("Base 생성자(int i)");
	}
}


class Derived2 extends Base2 {
	public Derived2() {
		// 명시적으로 자식 클래스의 생성자 첫 부분에 부모 클래스의 생성자를 호출해주거나 부모 클래스에 기본 생성자를 만들면 된다.
		super(100);
		System.out.println("Derived2 생성자()");
	}
}

public class Constructor2 {

	public static void main(String[] args) {
		new Derived2();
	}

}
