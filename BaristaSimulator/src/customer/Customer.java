package customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

import recipes.Recipe;

public class Customer {
	//필드
	static String[] menus = new String[] {"에스프레소", "따뜻한 아메리카노", "아아", "따뜻한 카페라떼", "카페라떼 아이스", "카페모카 따뜻하게", "카페모카 아이스"};
	static int MIN_ROWS = 1;	//주문종류 최소
	static int MAX_ROWS = 2;    //주문종류 최대
	static int MAX_KINDS = 6;	//주문커피 종류 번호
	static int MIN_GLASS = 1;	//주문량 최소
	static int MAX_GLASS = 2;	//주문량 최대
	Random random = new Random();
	
	//생성자
	public Customer(){};
	
	
	//메소드
	
	//주문 리스트 만들기
	private int[][] orderList(){
		//1~2행의 int[][] 리턴
		int rows = random.nextInt(MAX_ROWS - MIN_ROWS + 1) + MIN_ROWS;
		return new int[rows][2];
	}
	
	//주문
	public int[] order() {
		int[][] orderList = this.orderList();
		HashSet<Integer> kindSet = new HashSet<Integer>();
		//주문 생성
		while(kindSet.size() < orderList.length) {
			kindSet.add( random.nextInt(MAX_KINDS + 1) );
		}
		int[] uniqueKinds = new int[kindSet.size()];
		int idx = 0;
		for(int num : kindSet) {
			uniqueKinds[idx++] = num;
		}
		//주문하기
		for(int i=0; i<orderList.length; i++) {
            orderList[i][0] = uniqueKinds[i]; 
			orderList[i][1] = random.nextInt(MAX_GLASS - MIN_GLASS + 1) + MIN_GLASS;
			System.out.println(menus[orderList[i][0]] + " " + orderList[i][1] + "잔, ");
		}
		System.out.println("주세요.");
		
		//주문내역 생성 (일종의 영수증 받기)
		ArrayList<Integer> drinks = new ArrayList<>();
		for(int i=0; i<orderList.length; i++) {
			for(int j=0; j<orderList[i][1]; j++) {
				switch(orderList[i][0]) {
				case 0: drinks.add(Recipe.ESPRESSO_HOT); break;
				case 1: drinks.add(Recipe.AMERICANO_HOT); break;
				case 2: drinks.add(Recipe.AMERICANO_ICED); break;
				case 3: drinks.add(Recipe.CAFELATTE_HOT); break;
				case 4: drinks.add(Recipe.CAFELATTE_ICED); break;
				case 5: drinks.add(Recipe.CAFEMOCHA_HOT); break;
				case 6: drinks.add(Recipe.CAFEMOCHA_ICED); break;
				}
			}
		}
		int[] result = drinks.stream().mapToInt(Integer::intValue).toArray();
		Arrays.sort(result);
		return result;	
	}
	
	public static int money(int[] drinks) {
		int payment=0;
		for(int a : drinks) {
			if(a == Recipe.ESPRESSO_HOT) payment += 1500;
			else if(a == Recipe.AMERICANO_HOT) payment += 2000;
			else if(a == Recipe.AMERICANO_ICED) payment += 2500;
			else if(a == Recipe.CAFELATTE_HOT) payment += 3000;
			else if(a == Recipe.CAFELATTE_ICED) payment += 3500;
			else if(a == Recipe.CAFEMOCHA_HOT) payment += 3500;
			else if(a == Recipe.CAFEMOCHA_ICED) payment += 4000;
		}  
		return payment;
	}
	
}
