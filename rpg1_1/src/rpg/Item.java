package rpg;

public class Item {
	static final int WEAPON = 1;
	static final int ARMOR = 2;
	static final int RING = 3;
	private int kind;
	private String name;
	private int power;
	private int price;
	
	public Item(int kind, String name, int power, int price) {
		this.kind = kind;
		this.name = name;
		this.power = power;
		this.price = price;
	}

	public int getKind() {
		return kind;
	}

	public void setKind(int kind) {
		this.kind = kind;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		String data = String.format("[이름 : %s] [공격력 : %d] [가격 : %d]",name,power,price);
		return data;
	}
	
}
