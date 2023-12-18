package rpg;

public class Game {
	private Guild guild;
	private Inventory inventory;
	private Shop shop;
	
	public Game() {
		guild = new Guild();
		inventory = new Inventory();
		shop = new Shop();
		run();
	}
	
	private void run() {
		while(true) {
			System.out.println("[메인메뉴]");
			System.out.println("[1.길드관리]");
			System.out.println("[2.상점]");
			System.out.println("[3.인벤토리]");
			System.out.println("[4.저장]");
			System.out.println("[5.로드]");
			System.out.println("[0.종료]");

			int sel = FileData.getValue("메뉴 선택 : ", 0, 5);

			if (sel == 1) {
				System.out.println("[길드관리]");
				guildMenu();
			} else if (sel == 2) {
				System.out.println("[상점]");
				shopMenu();
			} else if (sel == 3) {
				System.out.println("[인벤토리]");
				inventoryMenu();
			} else if (sel == 4) {
				System.out.println("[저장]");
				FileData.fileSave(guild, inventory);
			} else if (sel == 5) {
				System.out.println("[로드]");
				FileData.fileLoad(guild, inventory);
			} else if (sel == 0) {
				System.out.println("종료....");
				return;
			}
		}
	}
	// 길드 메뉴
	private void guildMenu() {
		while (true) {
			System.out.println("[1.길드 목록]");
			System.out.println("[2.길드원 추가]");
			System.out.println("[3.길드원 삭제]");
			System.out.println("[4.파티원 교체]");
			System.out.println("[0.뒤로가기]");
			
			int sel = FileData.getValue("메뉴 선택 : ",0,4);
			
			if(sel == 1) {
				System.out.println("[길드 목록]");
				guild.guildListPrint();
			}else if(sel == 2) {
				System.out.println("[길드원 추가]");
				guild.guildOneadd();
			}else if(sel == 3) {
				System.out.println("[길드원 삭제]");;
				guild.guildOneRemove();
			}else if(sel == 4) {
				System.out.println("[파티원 교체]");
				guild.guildprtyAddSet();
			}else if(sel == 0) {
				System.out.println("[뒤로가기]");
				return;
			}
		}
	}
	//상점
	private void shopMenu() {
		while (true) {
			System.out.println("[1.무기]");
			System.out.println("[2.방어구]");
			System.out.println("[3.반지]");
			System.out.println("[0.뒤로가기]");
			
			int sel = FileData.getValue("메뉴 선택 : ", 0, 3);
			
			if(sel == 1) {
				System.out.println("[무기 구입]");
				shop.Shopbuy(Item.WEAPON,inventory);
			}else if(sel == 2) {
				System.out.println("[방어구 구입]");
				shop.Shopbuy(Item.ARMOR,inventory);
			}else if(sel == 3) {
				System.out.println("[반지 구입]");
				shop.Shopbuy(Item.RING,inventory);
			}else if(sel == 0) {
				System.out.println("[뒤로가기]");
				return;
			}
		}
	}
	
	private void inventoryMenu() {
		while (true) {
			System.out.println("[1.착용]");
			System.out.println("[2.판매]");
			System.out.println("[0.뒤로가기]");
			int sel = FileData.getValue("메뉴 선택 : ",0,2);
			
			if(sel == 1) {
				inventory.guildOneWearing(guild);
			}else if(sel == 2) {
				inventory.invenItemSale();
			}else if(sel == 0) {
				System.out.println("뒤로 가기....");
				return;
			}
		}
	}
	
}
