package store;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import customer.Customer;
import ingredients.Ingredients;

//싱글톤
public class Store {
	//필드
	int sum = 0;
	boolean flag;
	Scanner sc = new Scanner(System.in);
	private static Store myStore = new Store(0, true);
	//생성자
	private Store(int sum, boolean flag){
		this.sum = 0;
		this.flag = flag;
	};
	
	//메서드
	public static Store getInstance() {
		return myStore;
	}
	public int getSum() {
		return sum;
	}
	//음료 제조하는 메서드
	public int[] makeDrink() {
		ArrayList<Integer> tray = new ArrayList<>();
		ArrayList<Integer> drink = new ArrayList<>();
		System.out.println("======================================== 음료 제조를 시작합니다. ========================================");
		System.out.print("[" + "1. 에스프레소 샷 추가  |  2. 물 추가  |  3. 얼음 추가  |  4. 우유 추가  |  5. 초콜릿 추가  |  9: 음료 완성 후 쟁"
				+ "반에 담기  |  0: 서빙하기]:  ");
		//System.out.println();
		while(flag) {
			int i = sc.nextInt();
			switch(i) {
			case 1: 
				System.out.println(" -> 에스프레소 샷을 추가했습니다.");
				sum -= Ingredients.ESPRESSO.price;
				drink.add(1);
				break;
			case 2: 
				System.out.println(" -> 물을 추가했습니다.");
				sum -= Ingredients.WATER.price;;
				drink.add(2);
				break;
			case 3: 
				System.out.println(" -> 얼음을 추가했습니다.");
				sum -= Ingredients.ICE.price;
				drink.add(3);
				break;
			case 4: 
				System.out.println(" -> 우유를 추가했습니다.");
				sum -= Ingredients.MILK.price;
				drink.add(4);
				break;
			case 5: 
				System.out.println(" -> 초콜릿을 추가했습니다.");
				sum -= Ingredients.CHOCOLATE.price;
				drink.add(5);
				break;
			case 9: 
				int[] result = drink.stream().mapToInt(Integer::intValue).toArray();
				Arrays.sort(result);
				String cup = "";
				for(int k:result) {
					cup += String.valueOf(k);
				}
				tray.add(Integer.parseInt(cup));
				drink.clear();
				System.out.println("제조 완료! 트레이에 음료를 올렸습니다.");
				System.out.println("다음 음료를 만들어 주세요.");
				break;
			case 0:
				System.out.println("손님께 서빙합니다.");
				flag  = !flag;
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}
		}
		int[] result = tray.stream().mapToInt(Integer::intValue).toArray();
		Arrays.sort(result);
		flag = !flag;
		return result;
	}
	
	//주문내역과 제조한 음료내역이 같은지 확인
	public void checkReceipt(int[] order, int[] makeDrink) {
		if(Arrays.equals(order, makeDrink)) {
			System.out.println("성공!");
			this.sum += Customer.money(order);
		} else {
			System.out.println("손님이 주문 내역과 다르다고, 돈을 내지 않고 나가버렸습니다.");
		}
		System.out.println("현재 순이익 : " + this.sum);
		System.out.println("===================================================================================================");
	}
	
	
	
	
	
	
	public void doorClose(){
		try {
			Thread.sleep(500);
			System.out.println("영업 종료! 오늘도 고생 많았습니다!");
		} catch (InterruptedException e) {}
		
	}
	
}
