package rpg;

public class Unit {
	private String name;
	private int level;
	private int hp;
	private int maxHp;
	private int att;
	private int def;
	private int exp;
	private boolean party;
	private Item weapon;
	private Item armor;
	private Item ring;
	
	public Unit(String name, int level, int hp, int maxHp, int att, int def, int exp) {
		this.name = name;
		this.level = level;
		this.hp = hp;
		this.maxHp = maxHp;
		this.att = att;
		this.def = def;
		this.exp = exp;
		this.party = false;
		this.weapon = null;
		this.armor = null;
		this.ring = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Item getWeapon() {
		return weapon;
	}

	public void setWeapon(Item weapon) {
		this.weapon = weapon;
	}

	public Item getArmor() {
		return armor;
	}

	public void setArmor(Item armor) {
		this.armor = armor;
	}

	public Item getRing() {
		return ring;
	}

	public void setRing(Item ring) {
		this.ring = ring;
	}

	@Override
	public String toString() {
		String data = String.format("[이름 : %s] [레벨 : %d] [Hp : %d / %d] [공격력 : %d] [방어력 : %d] [경험치 : %d]%n",name,level,hp,maxHp,att,def,exp);
		data += String.format("[무기 : %s] ",weapon == null? "" : weapon.getName() + " : " + weapon.getPower());
		data += String.format("[방어구 : %s] ",armor == null? "" : armor.getName() + " : " + armor.getPower());
		data += String.format("[반지 : %s] ",ring == null? "" : ring.getName() + " : " + ring.getPower());
		
		return data;
	}

	
}
