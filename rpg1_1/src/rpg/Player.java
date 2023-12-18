package rpg;


public class Player {
	private static int money;
	
	public Player() {
		money = 100000;
	}

	public static int getMoney() {
		return money;
	}

	public static void setMoney(int money) {
		Player.money = money;
	}
	
	
}
