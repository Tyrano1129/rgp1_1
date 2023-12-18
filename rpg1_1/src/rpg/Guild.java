package rpg;

import java.util.ArrayList;

public class Guild { 
	private final int prtySize = 4;
	private ArrayList<Unit> guildList;
	private ArrayList<Unit> prtyList;
	public Guild() {
		guildList = new ArrayList<Unit>();
		prtyList = new ArrayList<Unit>();
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
		for(int i = 0; i < prtySize; i+=1) {
			System.out.printf("[%d] %s%n",i+1,guildList.get(i));
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
		int hpmax = hp;
		int att = FileData.randomint() + 1;
		int def = FileData.randomint()/2 +1;
		guildList.add(new Unit(name,0,hp,hpmax,att,def,0));
	}
	// 파티 삭제
	private void prtyOneRemove(Unit u) {
		for(int i = 0; i < prtySize; i+=1) {
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
		if(prtyList.size() >= 4) {
			guildListNumberPrint();
			int idx2 = FileData.getValue("파티에 들어갈 길드원 번호 선택 : ",1,guildList.size())-1;
			prtyListPrint();
			int idx1 = FileData.getValue("교체할 길드원 번호 선택 : ",1,guildList.size())-1;
			prtyList.set(idx1,guildList.get(idx2));
		}else {
			guildListNumberPrint();
			int idx2 = FileData.getValue("파티에 들어갈 길드원 번호 선택 : ",1,guildList.size())-1;
			int idx1 = FileData.getValue("넣을위치 길드원 번호 선택 : ",1,guildList.size())-1;
			prtyList.add(idx1,guildList.get(idx2));
		}
	}
}
