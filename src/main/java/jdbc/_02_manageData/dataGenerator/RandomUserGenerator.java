package jdbc._02_manageData.dataGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import jdbc._00_Init.pojo.USERS;

public class RandomUserGenerator {
	
	private USERS generatedUser = null;
	private String firstName = "";
	private String lastName = "";
	
	public RandomUserGenerator() {
		generatedUser = new USERS();
		firstName = "";
		lastName = "";
	}
	
	public USERS generateRandomUser() {
		generatedUser.setUser_cellphone(generateCellphone());
		// 預設密碼等同手機號碼
		generatedUser.setUser_password(generatedUser.getUser_cellphone());
		generatedUser.setUser_name(generateName());
		// 用名稱當email前綴字
		generatedUser.setUser_email(generateEmail());
		generatedUser.setUser_create_time(new Date(System.currentTimeMillis()));
		generatedUser.setUser_status("normal");
		return generatedUser;
	}
	
	private String generateCellphone() {
		StringBuilder cellphone = new StringBuilder("09");
		for (int i = 1; i <= 9; i++) {
			if (i == 3) {
				cellphone.append("-");
			} else {
				cellphone.append((int)(Math.random() * 10));
			}
		}
		return cellphone.toString();
	}
	
	private String generateName() {
		Set<String> lastNameWordsKeySet = lastNameWords.keySet();
		List<String> lastNameWordsKeyList =  new ArrayList<>();
		lastNameWordsKeyList.addAll(lastNameWordsKeySet);
		Collections.shuffle(lastNameWordsKeyList);
		lastName = lastNameWordsKeyList.get((int) (Math.random() * lastNameWords.size()));
		firstName = lastNameWordsKeyList.get((int) (Math.random() * lastNameWords.size()));
		return new StringBuilder(lastName + firstName).toString();
	}

	private String generateEmail() {
		return new StringBuilder(lastNameWords.get(firstName) + lastNameWords.get(lastName) + "@gmail.com").toString();
	}
	
	Map<String, String> lastNameWords = new TreeMap<>();
	{
		lastNameWords.put("陳", "cheng");
		lastNameWords.put("林", "ling");
		lastNameWords.put("黃", "huang");
		lastNameWords.put("張", "chang");
		lastNameWords.put("李", "li");
		lastNameWords.put("王", "wang");
		lastNameWords.put("陳", "cheng");
		lastNameWords.put("吳", "wu");
		lastNameWords.put("劉", "liu");
		lastNameWords.put("蔡", "tsai");
		lastNameWords.put("楊", "yang");
		lastNameWords.put("許", "hsu");
		lastNameWords.put("鄭", "cheng");
		lastNameWords.put("謝", "hsieh");
		lastNameWords.put("郭", "guo");
		lastNameWords.put("洪", "hung");
		lastNameWords.put("邱", "chiu");
		lastNameWords.put("曾", "tseng");
		lastNameWords.put("廖", "liao");
	}
}
