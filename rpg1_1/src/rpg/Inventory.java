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
			if(guild.getGuildList().get(idx1).getArmor() != null) {
				Item item = guild.getGuildList().get(idx1).getArmor();
				guild.getGuildList().get(idx1).setArmor(itemList.get(idx2));
				itemList.set(idx2, item);
				return;
			}
			guild.getGuildList().get(idx1).setArmor(itemList.get(idx2));
			itemList.remove(idx2);
		}else if(itemList.get(idx2).getKind() == Item.RING) {
			if(guild.getGuildList().get(idx1).getRing() != null) {
				Item item = guild.getGuildList().get(idx1).getRing();
				guild.getGuildList().get(idx1).setRing(itemList.get(idx2));
				itemList.set(idx2, item);
				return;
			}
			guild.getGuildList().get(idx1).setRing(itemList.get(idx2));
			itemList.remove(idx2);
		}else if(itemList.get(idx2).getKind() == Item.WEAPON) {
			if(guild.getGuildList().get(idx1).getWeapon() != null) {
				Item item = guild.getGuildList().get(idx1).getWeapon();
				guild.getGuildList().get(idx1).setWeapon(itemList.get(idx2));
				itemList.set(idx2, item);
				return;
			}
			guild.getGuildList().get(idx1).setWeapon(itemList.get(idx2));
			itemList.remove(idx2);
		}
	}
	// 판매
	public void invenItemSale() {
		itemListprint();
		int idx = FileData.getValue("판매할 아이템 선택 : (판매액 50%)",1,itemList.size())-1;
		Player.setMoney(Player.getMoney() + (itemList.get(idx).getPrice()/2));
		itemList.remove(idx);
	}
	// 저장
	public String dataList() {
		String data = "";
		for(Item item : itemList) {
			data += item.getKind() + "/" + item.getName() + "/" + item.getPower() + "/" + item.getPrice() + "\n";
		}
		return data;
	}
	// 로드
	public void dataLoad(String data) {
		String[] temp = data.split("\n");
		for(int i = 0; i < temp.length; i+=1) {
			String[] info = temp[i].split("/");
			
			itemList.add(new Item(Integer.parseInt(info[0]),info[1],Integer.parseInt(info[2]),Integer.parseInt(info[3])));
		}
	}
}
