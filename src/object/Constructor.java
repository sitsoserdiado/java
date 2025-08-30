package object;

class Pizza {
	int size;
	String type;
	
	// 기본 생성자
	public Pizza() {
		size = 12;
		type = "슈퍼슈프림";
	}
	
	// 매개 변수가 있는 생성자
	public Pizza(int size, String type) {
		// this 참조 변수
		this.size = size;
		this.type = type;
	}
}

public class Constructor {

	public static void main(String[] args) {
		Pizza obj1 = new Pizza();
		System.out.println(obj1.type + ", " + obj1.size);
		
		Pizza obj2 = new Pizza(24, "포테이토");
		System.out.println(obj2.type + ", " + obj2.size);
	}

}
