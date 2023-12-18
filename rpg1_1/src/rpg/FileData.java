package rpg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileData {
	private static Scanner scan = new Scanner(System.in);
	private static final String CUR_PATH = System.getProperty("user.dir") +"\\src\\"+  new FileData().getClass().getPackageName() + "\\";
	private static Random rd = new Random();
	// 숫자 입력
	public static int getValue(String msg,int start,int end) {
		int num = 0;
		System.out.println(msg);
		while(true) {
			try {
				num = scan.nextInt();
				if(num < start || num > end) {
					System.out.println("[%d ~ %d] 입력 해주세요.");
					continue;
				}
				return num;
			}catch(Exception e) {
				System.out.println("숫자만 입력해주세요");
			} finally {
				scan.nextLine();
			}
		}
	}
	// 이름 패턴
	private static boolean namePattern(String name) {
		String namepattern = "^[a-z|A-Z|ㄱ-ㅎ|가-힣| ]*$";
		Pattern p = Pattern.compile(namepattern);
		Matcher m = p.matcher(name);
		if(m.matches()) {
			return true;
		}
		System.out.println("잘못입력하셧습니다.");
		return false;
	}
	// 문자입력
	public static String getValueString(String msg) {
		System.out.println(msg);
		String name = scan.next();
		if(!namePattern(name)) {
			return null;
		}
		return name;
	}
	// 랜덤값
	public static int randomint() {
		return rd.nextInt(8)+2;
	}
	// 저장 실행
	private static void save(String filename,String data) {
		try(FileWriter fw = new FileWriter(CUR_PATH+filename)){
			fw.write(data);
			System.out.printf("%s 저장 성공%n",filename);
		} catch (IOException e) {
			System.out.printf("%s 저장 실패%n",filename);
		}
	}
	// 파일있는지 없는지 확인
	private static boolean checkfile(String filename) {
		File file = new File(CUR_PATH+filename);
		if(file.exists()) {
			return true;
		}
		return false;
	}
	// 로드 실행
	private static String load(String filename) {
		String data = "";
		if(!checkfile(filename)) {
			System.out.printf("%s 파일이 없습니다.%n",filename);
			return null;
		}
		
		try(FileReader fr = new FileReader(CUR_PATH+filename);
			BufferedReader br = new BufferedReader(fr)){
			while(true) {
				String read = br.readLine();
				if(read == null) break;
				data += read + "\n";
			}
		} catch (IOException e) {
			System.out.printf("%s 로드 실패%n",filename);
		}
		if(data.equals("")) {
			System.out.printf("%s 데이터가 없습니다.%n",filename);
			return null;
		}
		System.out.printf("%s 로드 성공...%n",filename);
		return data;
	}
	//파일 세이브
	public static void fileSave(Guild guild,Inventory inven) {
		String guilddata = guild.dataList();
		String invendata = inven.dataList();
		
		save("guildData.txt",guilddata);
		save("invenData.txt",invendata);
	}
	// 파일 로드
	public static void fileLoad(Guild guild,Inventory inven) {
		String guilddata = load("guildData.txt");
		String invendata = load("invenData.txt");
		
		if(guilddata != null) {
			guild.dataLoad(guilddata);
		}
		if(invendata != null) {
			inven.dataLoad(invendata);
		}
	}
}
