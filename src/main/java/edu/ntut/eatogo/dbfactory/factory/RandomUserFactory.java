package edu.ntut.eatogo.dbfactory.factory;

import edu.ntut.eatogo.dbfactory.persistence.entity.User;
import edu.ntut.eatogo.dbfactory.persistence.entity.UserStatus;

import java.util.*;

public class RandomUserFactory {
	
	private User generatedUser;
	private String firstName, lastName;
	private Map<String, String> lastNameWords = new TreeMap<>();
	private List<String> lastNameWordsKeyList = new ArrayList<>();
	{
		lastNameWords.put("陳", "cheng");
		lastNameWords.put("林", "ling");
		lastNameWords.put("黃", "huang");
		lastNameWords.put("張", "chang");
		lastNameWords.put("李", "li");
		lastNameWords.put("王", "wang");
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
		lastNameWordsKeyList.addAll(lastNameWords.keySet());
	}
	
	public RandomUserFactory() {
		generatedUser = new User();
	}
	
	public User generateRandomUser() {
		generatedUser.setUser_cellphone(generateCellphone());
		// 預設密碼等同手機號碼
		generatedUser.setUser_password(generatedUser.getUser_cellphone());
		generatedUser.setUser_name(generateName());
		// 用"名"+"姓"當email前綴字
		generatedUser.setUser_email(generateEmail());
		generatedUser.setUser_create_time(new Date(System.currentTimeMillis()));
		generatedUser.setUserStatus(new UserStatus("normal"));
		return generatedUser;
	}
	
	private String generateCellphone() {
		StringBuilder cellphone = new StringBuilder("09");
		for (int i = 1; i <= 9; i++) {
			if (i == 3) cellphone.append("-");
			else cellphone.append((int)(Math.random() * 10));
		}
		return cellphone.toString();
	}
	
	private String generateName() {
		lastName = lastNameWordsKeyList.get((int) (Math.random() * lastNameWords.size()));
		firstName = lastNameWordsKeyList.get((int) (Math.random() * lastNameWords.size()));
		return lastName + firstName;
	}

	private String generateEmail() {
		return lastNameWords.get(firstName) + lastNameWords.get(lastName) + "@gmail.com";
	}
	
}
