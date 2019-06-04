package edu.ntut.eatogo.dbfactory.factory;

import edu.ntut.eatogo.dbfactory.persistence.domain.Food;
import edu.ntut.eatogo.dbfactory.persistence.domain.FoodType;
import edu.ntut.eatogo.dbfactory.persistence.domain.Store;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomFoodFactory {
	private Food generatedFood;
	private StringBuilder food_prefix;
	private StringBuilder food_suffix;
	private Random random;
	
	public RandomFoodFactory() {
		random = new Random();
	}
	
	public Food generateRandomFood(Integer food_store) {
		generatedFood = new Food();
		food_prefix = new StringBuilder();
		food_suffix = new StringBuilder();
		String food_type = generateFoodType();
		
		generatedFood.setFoodType(new FoodType(food_type));
		generatedFood.setFood_name(generateFoodNameByType(food_type));
		generatedFood.setFood_price(generateFoodPriceByType(food_type));
		generatedFood.setStore(new Store(food_store));
		generatedFood.setFood_status("selling");
//		generatedFood.setFood_review_count(generateRandomReviewCounts());
		
		return generatedFood;
	}

	private String generateFoodType() {
		return foodTypes.get(random.nextInt(foodTypes.size()));
	}
	
	private String generateFoodNameByType(String food_type) {
		switch (food_type) {
		case "chinese":
			food_prefix = generatePrefixByFoodTypes(chineseFoodPrefixes);
			food_suffix = generateSuffixByFoodType(chineseFoodSuffixes);
			break;
		case "japanese":
			food_prefix = generatePrefixByFoodTypes(japaneseFoodPrefixes);
			food_suffix = generateSuffixByFoodType(japaneseFoodSuffixes);
			break;
		case "american":
			food_prefix = generatePrefixByFoodTypes(americanFoodPrefixes);
			food_suffix = generateSuffixByFoodType(americanFoodSuffixes);
			break;
		case "thailand":
			food_prefix = generatePrefixByFoodTypes(thaiFoodPrefixes);
			food_suffix = generateSuffixByFoodType(thaiFoodSuffixes);
			break;
		case "korean":
			food_prefix = generatePrefixByFoodTypes(koreanFoodPrefixes);
			food_suffix = generateSuffixByFoodType(koreanFoodSuffixes);
			break;
		case "italian":
			food_prefix = generatePrefixByFoodTypes(italianFoodPrefixes);
			food_suffix = generateSuffixByFoodType(italianFoodSuffixes);
			break;
		case "hongkong":
			food_prefix = generatePrefixByFoodTypes(hongkongFoodPrefixes);
			food_suffix = generateSuffixByFoodType(hongkongFoodSuffixes);
			break;
		case "beverage":
			food_prefix = generatePrefixByFoodTypes(beveragePrefixes);
			food_suffix = generateSuffixByFoodType(beverageSuffixes);
			break;
		}
		return food_prefix.append(food_suffix.toString()).toString();
	}
	
	private StringBuilder generatePrefixByFoodTypes(List<String> foodPrefixes) {
		int numberOfPrefix = random.nextInt(3) + 1;
		for (int index = 0; index < numberOfPrefix; index++) {
			food_prefix.append(foodPrefixes.get(random.nextInt(foodPrefixes.size())));
		}
		return food_prefix;
	}
	
	private StringBuilder generateSuffixByFoodType(List<String> foodSuffixes) {
		return food_suffix.append(foodSuffixes.get(random.nextInt(foodSuffixes.size())));
	}
	
	private int generateFoodPriceByType(String food_type) {
		int food_price = 0;
		switch (food_type) {
		case "chinese":
			food_price = generatePriceBetween(100, 600);
			break;
		case "japanese":
			food_price = generatePriceBetween(150, 1500);
			break;
		case "american":
			food_price = generatePriceBetween(200, 2000);
			break;
		case "thailand":
			food_price = generatePriceBetween(80, 400);
			break;
		case "korean":
			food_price = generatePriceBetween(120, 800);
			break;
		case "italian":
			food_price = generatePriceBetween(400, 3000);
			break;
		case "hongkong":
			food_price = generatePriceBetween(60, 700);
			break;
		case "beverage":
			food_price = generatePriceBetween(40, 350);
			break;
		}
		return food_price;
	}
	
	private Integer generatePriceBetween(int lowerBound, int upperBound) {
		return (int) (Math.random() * (upperBound - lowerBound)) + lowerBound;
	}
	
	private Long generateRandomReviewCounts() {
		return (long) (Math.random() * 30000) + 1;
	}
	
	private List<String> foodTypes = new ArrayList<>(Arrays.asList("chinese", "japanese", "american", "thailand", "korean", "italian", "hongkong", "beverage"));
	private List<String> chineseFoodPrefixes = new ArrayList<>(Arrays.asList("", "", "", ""));
	private List<String> chineseFoodSuffixes = new ArrayList<>(Arrays.asList("瓜絲兒", "山雞丁兒", "拌海蜇", "龍鬚菜", "熗冬筍", "玉蘭片", "澆鴛鴦", "燒魚頭", "燒檳子", "燒百合", "炸豆腐", "炸麵筋", "糖熘兒", "拔絲山藥", "糖燜蓮子", "釀山藥", "杏仁酪", "小炒螃蟹", "氽大甲", "什錦葛仙米", "蛤蟆魚", "扒帶魚", "海鯽魚", "黃花魚", "扒海參", "扒燕窩", "扒雞腿兒", "扒雞塊兒", "扒肉", "扒麵筋", "扒三樣兒", "油潑肉", "醬潑肉", "炒蝦黃兒", "熘蟹黃兒", "炒子蟹", "佛手海參", "炒芡子米", "奶湯", "翅子湯", "三絲湯", "熏斑鳩", "鹵斑鳩", "海白米", "燴腰丁兒", "火燒茨菰", "炸鹿尾兒", "燜魚頭", "拌皮渣兒", "氽肥腸兒", "清拌粉皮兒", "木須菜", "烹丁香", "烹大肉", "烹白肉", "麻辣野雞", "鹹肉絲兒", "白肉絲兒", "荸薺", "一品鍋", "素熗春不老", "清燜蓮子", "酸黃菜", "燒蘿蔔", "燴銀耳", "炒銀枝兒", "八寶榛子醬", "黃魚鍋子", "白菜鍋子", "什錦鍋子", "湯圓子鍋", "菊花鍋子", "煮餑餑鍋子", "肉丁辣醬", "炒肉兒", "炒肉片", "燴酸菜", "燴白菜", "燴豌豆", "燜扁豆", "氽毛豆"));
	private List<String> japaneseFoodPrefixes = new ArrayList<>(Arrays.asList("和風", "綜合", "日式", "鮑魚", "蘆筍", "明蝦", "章魚", "軟絲", "蘆筍", "鰻魚", "牛蒡", "蝦卵", "海膽", "紅蟳", "土瓶", "炒", "香菇", "鍋燒", "月見", "烏龍", "抹茶", "蕎麥", "味噌", "豬肉", "雞肉", "櫻花", "牛肉", "", "", "", "", "", "", "", "", "", "", "", ""));
	private List<String> japaneseFoodSuffixes = new ArrayList<>(Arrays.asList("沙拉", "手卷", "蒸", "蒸蛋", "牛肉", "魚標", "紅蟳", "肉絲", "香菇", "蛤仔", "干貝", "天婦羅", "唐揚", "蔬菜", "豆腐", "豬排", "烏龍麵", "涼麵", "味噌湯", "火鍋", "壽喜燒"));
	private List<String> americanFoodPrefixes = new ArrayList<>(Arrays.asList("頂級", "特級", "BBQ", "烤", "煎", "香草", "美國", "丁骨", "菲力", "香蒜", "", "", "", "", ""));
	private List<String> americanFoodSuffixes = new ArrayList<>(Arrays.asList("牛排", "漢堡", "豬排", "雞翅", "牛肉", "牛小排", "馬鈴薯"));
	private List<String> thaiFoodPrefixes = new ArrayList<>(Arrays.asList("泰式", "打拋", "酸辣", "咖哩", "烤", "蒸", "鹽", "炒", "炸", "魚露", "辣醬", "香辣", "椰汁", "蝦醬", "青檸", "綠", "炭燒", "涼拌", "", "", "", "", "", "", "", "", "", "", "", ""));
	private List<String> thaiFoodSuffixes = new ArrayList<>(Arrays.asList("河粉", "粿仔條", "丸", "飯", "魚", "蝦餅", "湯", "冬陰功", "雞", "海鮮", "粉絲", "沙拉", "牛肉", "辣肉"));
	private List<String> koreanFoodPrefixes = new ArrayList<>(Arrays.asList("大醬", "泡菜", "部隊", "雪濃", "辣炒", "煎", "烤", "韓式", "排骨", "炸", "紫菜包", "豬肉", "咖哩", "烤肉", "石鍋", "", "", "", "", "", "", "", "", "", "", "", "", "", ""));
	private List<String> koreanFoodSuffixes = new ArrayList<>(Arrays.asList("鍋", "包飯", "麵", "年糕", "拌飯", "湯", "蓋飯"));
	private List<String> italianFoodPrefixes = new ArrayList<>(Arrays.asList("普羅旺斯", "佐", "地中海", "初榨橄欖油", "米蘭", "燉肉末", "羅勒葉", "酸豆", "奶油", "燻鮭魚", "義式", "卡布里", "番茄", "乳酪", "炭烤", "凱薩", "松子", "箘菇", "煙燻", "莫札瑞拉", "拿坡里", "熱亞納", "帕米加諾", "西西里", "威尼斯", "奶油", "松露", "", "", "", "", "", "", "", "", "", ""));
	private List<String> italianFoodSuffixes = new ArrayList<>(Arrays.asList("嫩春雞", "牛排", "牛小排", "牛肉丸", "細麵", "管麵", "貝殼麵", "吸管麵", "墨魚麵", "筆尖麵", "細扁麵", "櫻桃鴨", "沙拉", "燉飯"));
	private List<String> hongkongFoodPrefixes = new ArrayList<>(Arrays.asList("", "", "", ""));
	private List<String> hongkongFoodSuffixes = new ArrayList<>(Arrays.asList("魚蛋", "魚蛋粉", "沙律", "吉列海班飯", "魚春壽司", "菠蘿油", "菜遠雞粒飯", "三文治", "公司通粉", "肉絲炆米", "西多士", "帶子雞扒", "燒鵝飯", "公仔麵", "野菌忌廉湯", "油菜", "牛脷撈麵", "烏冬", "豬扒飽", "吉利海班兩麵黃"));
	private List<String> beveragePrefixes = new ArrayList<>(Arrays.asList("", "", "", ""));
	private List<String> beverageSuffixes = new ArrayList<>(Arrays.asList("海尼根啤酒", "沛綠雅", "香檳啤酒", "錫蘭紅茶", "美式咖啡", "玫瑰香露", "蜜桃冰釀茶", "水果茶", "檸檬汁", "柳橙汁", "蘋果汁", "蜂蜜檸檬香柚茶", "義式濃縮咖啡", "美式咖啡", "歐蕾可可", "卡布奇諾", "拿鐵", "焦糖拿鐵", "瑪琪雅朵", "斯里蘭卡紅茶", "黃金烏龍", "綠茶", "四季青", "蜜茶", "蜂蜜綠茶", "爵士奶綠", "珍珠奶茶", "冬瓜茶", "蜂蜜檸檬蘆薈"));

}