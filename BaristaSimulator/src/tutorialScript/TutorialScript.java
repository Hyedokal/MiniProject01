package tutorialScript;

public class TutorialScript {
	private static final String a = "바리스타 시뮬레이터입니다.";
	private static final String b = "손님이 원하는 커피를 정확하고 빠르게 만들어 주세요!";
	private static final String c = "순이익이 10000원이 넘으면 게임이 종료됩니다.";
	private static final String d = "손님이 원하지 않는 커피를 만들어 줄 경우 돈을 받지 못하니 주의하세요!";
	private static final String e = "그럼, 시작합니다.";
	private static final String f = "카페 문을 열었습니다.";
	
	public static void script() {
		try {
		System.out.println(a);
		Thread.sleep(1500);
		System.out.println(b);
		Thread.sleep(1500);
		System.out.println(c);
		Thread.sleep(1500);
		System.out.println(d);
		Thread.sleep(1500);
		System.out.println(e);
		Thread.sleep(1500);
		System.out.println(f);
		Thread.sleep(1000);
		} catch (Exception e){
			System.out.println("스크립트를 불러 오던 중 오류 발생");
		}
	}
}
