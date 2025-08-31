package inheritance;

class Base {
	public Base() {
		System.out.println("Base 생성자()");
	}
}

class Derived extends Base {
	public Derived() {
		super(); // 명시해도 되고 묵시해도 됨.
		System.out.println("Derived 생성자()");
	}
}

public class Constructor1 {

	public static void main(String[] args) {
		Derived obj = new Derived();
	}

}
