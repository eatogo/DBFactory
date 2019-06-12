package edu.ntut.eatogo.dbfactory.factory;

import com.google.common.collect.Lists;
import edu.ntut.eatogo.dbfactory.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@Component
public class RandomUserFactory {
	
	private UserDto generatedUser;
	private Entry<String, String> firstName;
	private Entry<String, String> lastName;
	final private Map<String, String> nameWords = new HashMap<>();
	{
		nameWords.put("陳", "cheng");
		nameWords.put("林", "ling");
		nameWords.put("黃", "huang");
		nameWords.put("張", "chang");
		nameWords.put("李", "li");
		nameWords.put("王", "wang");
		nameWords.put("吳", "wu");
		nameWords.put("劉", "liu");
		nameWords.put("蔡", "tsai");
		nameWords.put("楊", "yang");
		nameWords.put("許", "hsu");
		nameWords.put("鄭", "cheng");
		nameWords.put("謝", "hsieh");
		nameWords.put("郭", "guo");
		nameWords.put("洪", "hung");
		nameWords.put("邱", "chiu");
		nameWords.put("曾", "tseng");
		nameWords.put("廖", "liao");
	}
	
	public RandomUserFactory() {
		generatedUser = new UserDto();
	}
	
	public UserDto generateRandomUser() {
		generatedUser.setUserCellphone(generateRandomCellphone());
		generatedUser.setUserPassword(generatedUser.getUserCellphone()); // 預設密碼等同手機號碼
		generatedUser.setUserName(generateRandomName());
		generatedUser.setUserEmail(generateEmail()); // 用"名"+"姓"當email前綴字
		generatedUser.setUserCreateTime(new Date(System.currentTimeMillis()));
		generatedUser.setUserStatusType("normal");
		return generatedUser;
	}
	
	private String generateRandomCellphone() {
		StringBuilder cellphone = new StringBuilder("09");
		for (int i = 1; i <= 9; i++) {
			if (i == 3) cellphone.append("-");
			else cellphone.append((int)(Math.random() * 10));
		}
		return cellphone.toString();
	}
	
	private String generateRandomName() {
		List<Entry<String, String>> words = Lists.newArrayList(nameWords.entrySet());
		lastName = words.get((int) (Math.random() * nameWords.size()));
		firstName = words.get((int) (Math.random() * nameWords.size()));
		return lastName.getKey() + firstName.getKey();
	}

	private String generateEmail() {
		return nameWords.get(firstName.getKey()) + nameWords.get(lastName.getKey()) + "@gmail.com";
	}
}
