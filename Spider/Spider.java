class Artropod {
	public void printName(double n) {
		System.out.println("Artropod");
	}
}

public class Spider extends Artropod {
	public void printName(int n) {
		System.out.println("Spider");
	}
	public static void main(String... args) {
		Spider spider = new Spider();
		spider.printName(4);
		spider.printName(5.0);
	}
}