package rpg;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


public class Guild { 
	private final int prtySize = 4;
	private ArrayList<Unit> guildList;
	private ArrayList<Unit> prtyList;
	public Guild() {
		guildList = new ArrayList<Unit>();
		prtyList = new ArrayList<Unit>();
		/*Unit temp = new Unit("호랑이", 1, 100, 10, 5, 0);
		guildList.add(temp);
		temp = new Unit("강아지", 1, 80, 7, 3, 0);
		guildList.add(temp);
		temp = new Unit("사슴", 1, 50, 3, 1, 0);
		guildList.add(temp);
		temp = new Unit("두더지", 1, 70, 5, 2, 0);
		guildList.add(temp);
		temp = new Unit("돼지", 1, 200, 4, 8, 0);
		guildList.add(temp);
		temp = new Unit("사자", 1, 120, 11, 7, 0);
		guildList.add(temp);
		*/
	}
	public ArrayList<Unit> getGuildList() {
		return guildList;
	}

	public void setGuildList(ArrayList<Unit> guildList) {
		this.guildList = guildList;
	}

	// 이름 중복 찾기
	private int checkNameidx(String name) {
		for(int i =0; i < guildList.size(); i+=1) {
			if(guildList.get(i).getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	
	private void prtyListPrint() {
		for(int i = 0; i < prtyList.size(); i+=1) {
			System.out.printf("[%d] %s%n",i+1,prtyList.get(i));
		}
	}
	// 길드 리스트 출력
	public void guildListNumberPrint() {
		for(int i = 0; i < guildList.size(); i+=1) {
			System.out.printf("[%d] %s%n",i+1,guildList.get(i));
		}
	}
	// 길드원 목록
	public void guildListPrint() {
		if(guildList.size() == 0) {
			System.out.println("길드원이 없습니다.");
			return;
		}
		for(Unit guild : guildList) {
			System.out.println(guild);
		}
	}
	// 길드원 추가
	public void guildOneadd() {
		String name = FileData.getValueString("길드원 이름 입력 : ");
		if(name == null) {
			return;
		}
		int idx = checkNameidx(name);
		if(idx != -1) {
			System.out.println("이미 존재하는 이름입니다.");
			return;
		}
		int hp = FileData.randomint() + 10;
		int att = FileData.randomint() + 1;
		int def = FileData.randomint()/2 +1;
		guildList.add(new Unit(name,1,hp,att,def,0));
	}
	// 파티 삭제
	private void prtyOneRemove(Unit u) {
		if(prtyList.size() == 0) return;
		for(int i = 0; i < prtyList.size(); i+=1) {
			if(prtyList.get(i).getName().equals(u.getName())) {
				prtyList.remove(i);
			}
		}
	}
	// 길드원 삭제
	public void guildOneRemove() {
		if(guildList.size() == 0) {
			System.out.println("길드원이 없습니다.");
			return;
		}
		guildListNumberPrint();
		int idx = FileData.getValue("길드원 번호 선택 : ",1,guildList.size())-1;
		prtyOneRemove(guildList.get(idx));
		guildList.remove(idx);
	}
	
	// 파티 교체 및 추가
	public void guildprtyAddSet() {
		if(prtyList.size() >= prtySize) {
			guildListNumberPrint();
			int idx2 = FileData.getValue("파티에 들어갈 길드원 번호 선택 : ",1,guildList.size())-1;
			prtyListPrint();
			int idx1 = FileData.getValue("교체할 길드원 번호 선택 : ",1,prtyList.size())-1;
			Unit u = prtyList.get(idx1);
			prtyList.set(idx1,guildList.get(idx2));
			guildList.set(idx2,u);
		}else {
			guildListNumberPrint();
			int idx2 = FileData.getValue("파티에 들어갈 길드원 번호 선택 : ",1,guildList.size())-1;
			int idx1 = FileData.getValue("넣을위치 길드원 번호 선택 : ",1,prtyList.size())-1;
			prtyList.add(idx1,guildList.get(idx2));
			guildList.remove(idx2);
			prtyListPrint();
		}
	}
	// 저장
	public String dataList() {
		String data = "";
		for(Unit u : guildList) {
			data += u.getName() + "/" + u.getLevel() + "/" + u.getHp() + "/" + u.getAtt() + "/" + u.getDef() + "/" + u.getExp() + "/";
			data += u.getWeapon() == null? "null/": (u.getWeapon().getKind() + "," + u.getWeapon().getName() + "," + u.getWeapon().getPower() + "," + u.getWeapon().getPrice())+"/";
			data += u.getWeapon() == null? "null/": (u.getArmor().getKind() + "," + u.getArmor().getName() + "," + u.getArmor().getPower()+ "," + u.getArmor().getPrice())+"/";
			data += u.getWeapon() == null? "null\n": (u.getRing().getKind() + "," + u.getRing().getName() + "," + u.getRing().getPower()+ "," + u.getRing().getPrice())+"\n";
		}
		return data;
	}
	// gulid 로드
	public void dataLoad(String data) {
		String[] temp = data.split("\n");
		for(int i =0;i < temp.length; i+=1) {
			String[] info1 = temp[i].split("/");
			guildList.add(new Unit(info1[0],Integer.parseInt(info1[1]),Integer.parseInt(info1[2]),Integer.parseInt(info1[3]),Integer.parseInt(info1[4]),Integer.parseInt(info1[5])));
			if(!info1[6].equals("null")) {
				String[] info2 = info1[6].split(",");
				Item item = new Item(Integer.parseInt(info2[0]),info2[1],Integer.parseInt(info2[2]),Integer.parseInt(info2[3]));
				guildList.get(i).setWeapon(item);
			}
			if(!info1[7].equals("null")) {
				String[] info2 = info1[7].split(",");
				Item item = new Item(Integer.parseInt(info2[0]),info2[1],Integer.parseInt(info2[2]),Integer.parseInt(info2[3]));
				guildList.get(i).setArmor(item);
			}
			if(!info1[8].equals("null")) {
				String[] info2 = info1[8].split(",");
				Item item = new Item(Integer.parseInt(info2[0]),info2[1],Integer.parseInt(info2[2]),Integer.parseInt(info2[3]));
				guildList.get(i).setRing(item);
			}
		}
	}
}
