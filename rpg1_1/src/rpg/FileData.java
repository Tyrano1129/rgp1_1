package rpg;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileData {
	private static Scanner scan = new Scanner(System.in);
	private static final String CUR_PATH = System.getProperty("user.dir") +"\\src\\"+  new FileData().getClass().getPackageName() + "\\";
	private static Random rd = new Random();
	
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
	public static String getValueString(String msg) {
		System.out.println(msg);
		String name = scan.next();
		if(!namePattern(name)) {
			return null;
		}
		return name;
	}
	public static int randomint() {
		return rd.nextInt(8)+2;
	}
}
