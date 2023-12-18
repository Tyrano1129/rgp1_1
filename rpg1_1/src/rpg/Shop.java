package rpg;

import java.util.ArrayList;


public class Shop {
	private ArrayList<Item> itemList;
	public Shop() {
		itemList = new ArrayList<Item>();
		
		Item temp = new Item(Item.WEAPON,"나무검",3,1000);
		itemList.add(temp);

		temp = new Item(Item.WEAPON,"철검",5,2000);
		itemList.add(temp);

		temp = new Item(Item.WEAPON,"레이피어",7,2500);
		itemList.add(temp);

		temp = new Item(Item.ARMOR,"티셔츠",1,300);
		itemList.add(temp);

		temp = new Item(Item.ARMOR,"가죽갑옷",4,800);
		itemList.add(temp);

		temp = new Item(Item.ARMOR,"강철갑옷",7,1500);
		itemList.add(temp);

		temp = new Item(Item.RING,"은반지",7,3000);
		itemList.add(temp);

		temp = new Item(Item.RING,"금반지",17,6000);
		itemList.add(temp);

		temp = new Item(Item.RING,"다이아반지",35,20000);
		itemList.add(temp);
	}
	
	// 아이템 종류 가지고오기
	public ArrayList<Item> temp(int val){
		ArrayList<Item> temp = new ArrayList<Item>();
		for(int i = 0; i < itemList.size(); i+=1) {
			if(itemList.get(i).getKind() == val) {
				temp.add(itemList.get(i));
			}
		}
		return temp;
	}
	// 템프
	public void tempPrint(ArrayList<Item> temp) {
		int idx = 1;
		for(Item item : temp) {
			System.out.printf("[%d번] %s%n",idx++,item);
		}
	}
	// 구입
	public void Shopbuy(int value,Inventory Inven) {
		String name = value == 1? "[무기]" : value == 2? "[방어구]" : "[반지]";
		ArrayList<Item> temp = temp(value);
		while(true) {
			System.out.println(name);
			tempPrint(temp);
			String data = String.format("%s 선택 : (0 : 뒤로가기)",name);
			int idx = FileData.getValue(data,1,temp.size())-1;
			if(idx == -1) {
				System.out.println("뒤로가기....");
				return;
			}
			Inven.inventoryOneAdd(temp.get(idx));
		}
	}
	
}
