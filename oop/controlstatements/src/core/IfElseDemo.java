package core;

public class IfElseDemo {

	public static void main(String[] args) {
		int amountOfMoney = 100;
		int itemPrice = 179;

		if (amountOfMoney < itemPrice) {
			System.out.println("You don' t have enough money on your account to purchase this item.");
		} else {
			System.out.println("Item is purchased");
		}

		amountOfMoney += 350;
		if (amountOfMoney < itemPrice) {
			System.out.println("You don' t have enough money on your account to purchase this item.");
		} else {
			System.out.println("Item is purchased");
		}

		int i1 = 3;
		int i2 = 2;
		int i3 = 10;

		if (i1 > i2) {
			if (i1 > i3)
				System.out.println("i1 is more than i2 and i3");
			else
				System.out.println("i1 is more than i2 but less than i3");
		}

		int orderPrice = 1000;

		if (orderPrice > 0 && orderPrice < 100)
			System.out.println("You have 5% discount for this order");
		else if (orderPrice >= 100 && orderPrice < 500)
			System.out.println("You have 10% discout for this order");
		else if (orderPrice >= 500 && orderPrice < 5000)
			System.out.println("You have 15% discount for this order");
	}

}
