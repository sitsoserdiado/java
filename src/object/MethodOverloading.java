package object;

class Add {
	int add(int x, int y) {
		return x + y;
	}
	
	int add(int x, int y, int z) {
		return x + y + z;
	}
}

public class MethodOverloading {

	public static void main(String[] args) {
		Add obj = new Add();
		System.out.println(obj.add(10, 20));
		System.out.println(obj.add(10, 20, 30));
	}

}
