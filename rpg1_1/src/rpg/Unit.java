package rpg;

public class Unit {
	private String name;
	private int level;
	private int hp;
	private int maxHp;
	private int att;
	private int def;
	private int exp;
	private Item weapon;
	private Item armor;
	private Item ring;
	
	public Unit(String name, int level, int hp,int att, int def, int exp) {
		this.name = name;
		this.level = level;
		this.hp = hp;
		this.maxHp = hp;
		this.att = att;
		this.def = def;
		this.exp = exp;
		this.weapon = null;
		this.armor = null;
		this.ring = null;
	}

	public int getLevel() {
		return level;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public void setAtt(int att) {
		this.att = att;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public void setWeapon(Item weapon) {
		this.weapon = weapon;
	}

	public void setArmor(Item armor) {
		this.armor = armor;
	}

	public void setRing(Item ring) {
		this.ring = ring;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public int getAtt() {
		return att;
	}

	public int getDef() {
		return def;
	}

	public int getExp() {
		return exp;
	}

	public String getName() {
		return name;
	}
	public Item getWeapon() {
		return weapon;
	}

	public Item getArmor() {
		return armor;
	}
	public Item getRing() {
		return ring;
	}

	@Override
	public String toString() {
		int wep = 0;
		int ringp = 0;
		int armorp = 0;
		if(weapon != null) {
			wep = weapon.getPower();
		}
		if(ring != null) {
			ringp = ring.getPower();
		}
		if(armor != null) {
			armorp = armor.getPower();
		}
		String data = String.format("[이름 : %3s] [레벨 : %3d] [Hp : %3d / %3d] [공격력 : %3d] [방어력 : %3d] [경험치 : %d]%n",name,level,hp+ringp,maxHp+ringp,att+wep,def+armorp,exp);
		data += String.format("[무기 : %s] ",weapon == null? "" : weapon.getName() + " : " + weapon.getPower());
		data += String.format("[방어구 : %s] ",armor == null? "" : armor.getName() + " : " + armor.getPower());
		data += String.format("[반지 : %s] ",ring == null? "" : ring.getName() + " : " + ring.getPower());
		
		return data;
	}

	
}
