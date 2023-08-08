package main;

import customer.Customer;
import store.Store;
import tutorialScript.TutorialScript;

public class Main {
		
	public static void main(String[] args) {
		Store myStore = Store.getInstance();
		
		TutorialScript.script();
		while(myStore.getSum() < 10000) {
			try {Thread.sleep(500);} catch (InterruptedException e) {}
			Customer c = new Customer();
			int[] order = c.order();
			int[] madeDrinks = myStore.makeDrink();
			myStore.checkReceipt(order, madeDrinks);
		}
			myStore.doorClose();
		
	}

}
