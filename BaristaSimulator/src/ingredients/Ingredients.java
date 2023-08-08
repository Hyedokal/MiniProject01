package ingredients;

//재료 클래스
public class Ingredients {
	public String name;
	public int price;
	
	//이름과 원가
	private Ingredients(String name, int price) {
		this.price = price;
		this.name = name;
	}
	
	public static final Ingredients ESPRESSO = new Ingredients("에스프레소", 500);
	public static final Ingredients WATER = new Ingredients("물", 100);
	public static final Ingredients ICE = new Ingredients("얼음", 150);
	public static final Ingredients MILK = new Ingredients("우유", 200);
	public static final Ingredients CHOCOLATE = new Ingredients("초콜릿", 400);
}
