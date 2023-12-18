package rpg;

import java.util.ArrayList;

public class Inventory {
	private ArrayList<Item> itemList; 
	
	public Inventory() {
		itemList = new ArrayList<Item>();
	}
	
	public void inventoryOneAdd(Item temp) {
		itemList.add(temp);
	}
	private void itemListprint() {
		for(int i =0; i < itemList.size(); i+=1) {
			System.out.printf("[%d] %s%n",i+1,itemList.get(i));
		}
	}
	// 착용
	public void guildOneWearing(Guild guild) {
		guild.guildListNumberPrint();
		int idx1 = FileData.getValue("착용할 길드원 선택 : ",1,guild.getGuildList().size())-1;
		itemListprint();
		int idx2 = FileData.getValue("착용할 아이템 선택 : ",1,itemList.size())-1;
		if(itemList.get(idx2).getKind() == Item.ARMOR) {
			guild.getGuildList().get(idx1).setArmor(itemList.get(idx2));
		}else if(itemList.get(idx2).getKind() == Item.RING) {
			guild.getGuildList().get(idx1).setRing(itemList.get(idx2));
		}else if(itemList.get(idx2).getKind() == Item.WEAPON) {
			guild.getGuildList().get(idx1).setWeapon(itemList.get(idx2));
		}
	}
	// 판매
	public void invenItemSale() {
		itemListprint();
		int idx = FileData.getValue("판매할 아이템 선택 : ",1,itemList.size())-1;
		Player.setMoney(Player.getMoney() + itemList.get(idx).getPrice());
		itemList.remove(idx);
	}
}
