package jdbc._02_manageData.dataGenerator;

import hibernate._00_init.schemas.food.FOODS;

public class RandomFoodGenerator {
	private FOODS generatedFood = null;
	private String food_type = null;
	private String food_suffix = "";
	private StringBuilder food_prefix = new StringBuilder(food_suffix);
	private Integer food_price = null;
	
	public RandomFoodGenerator() {
		generatedFood = new FOODS();
	}
	
	public FOODS generateRandomFood(Integer food_store) {
		food_type = generateFoodType();
		generatedFood.setFood_type(food_type);
		generatedFood.setFood_name(generateFoodNameByType(food_type));
		generatedFood.setFood_price(generateFoodPriceByType(food_type));
		generatedFood.setFood_store(food_store);
		generatedFood.setFood_status("selling");
		generatedFood.setFood_review_count(generateRandomReviewCounts());
		return generatedFood;
	}

	private String generateFoodType() {
		return randomizeStringArray(foodTypes)[0];
	}
	
	private String[] randomizeStringArray(String[] array) {
		for (int index = 0; index < array.length; index++) {
			int randomIndex = (int) (Math.random() * array.length);
			String temp = array[randomIndex];
			array[randomIndex] = array[index];
			array[index] = temp;
		}
		return array;
	}
	
	private String generateFoodNameByType(String food_type) {
		switch (food_type) {
		case "chinese":
			food_prefix = generatePrefixByFoodType(chineseFoodPrefixes);
			food_suffix = generateSuffixByFoodType(chineseFoodSuffixes);
			break;
		case "japanese":
			food_prefix = generatePrefixByFoodType(japaneseFoodPrefixed);
			food_suffix = generateSuffixByFoodType(japaneseFoodSuffixes);
			break;
		case "american":
			food_prefix = generatePrefixByFoodType(americanFoodPrefixed);
			food_suffix = generateSuffixByFoodType(americanFoodSuffixes);
			break;
		case "thailand":
			food_prefix = generatePrefixByFoodType(thaiFoodPrefixed);
			food_suffix = generateSuffixByFoodType(thaiFoodSuffixes);
			break;
		case "korean":
			food_prefix = generatePrefixByFoodType(koreanFoodPrefixed);
			food_suffix = generateSuffixByFoodType(koreanFoodSuffixes);
			break;
		case "italian":
			food_prefix = generatePrefixByFoodType(italianFoodPrefixed);
			food_suffix = generateSuffixByFoodType(italianFoodSuffixes);
			break;
		case "hongkong":
			food_prefix = generatePrefixByFoodType(hongkongFoodPrefixed);
			food_suffix = generateSuffixByFoodType(hongkongFoodSuffixes);
			break;
		case "beverage":
			food_prefix = generatePrefixByFoodType(beveragePrefixed);
			food_suffix = generateSuffixByFoodType(beverageSuffixes);
			break;
		}
		return food_prefix + food_suffix;
	}
	
	private StringBuilder generatePrefixByFoodType(String[] foodPrefixes) {
		int numberOfPrefix = (int) (Math.random() * 4) + 1;
		randomizeStringArray(foodPrefixes);
		for (int index = 0; index < numberOfPrefix; index++) {
			if (foodPrefixes[index] != null) {
				food_prefix = food_prefix.append(foodPrefixes[index]);
			}
		}
		return food_prefix;
	}
	
	private String generateSuffixByFoodType(String[] foodSuffixes) {
		return randomizeStringArray(foodSuffixes)[0];
	}
	
	String[] foodTypes = {"chinese", "japanese", "american", "thailand", "korean", "italian", "hongkong", "beverage"};
	String[] chineseFoodPrefixes = {"", "", "", ""};
	String[] chineseFoodSuffixes = {"瓜絲兒", "山雞丁兒", "拌海蜇", "龍鬚菜", "熗冬筍", "玉蘭片", "澆鴛鴦", "燒魚頭", "燒檳子", "燒百合", "炸豆腐", "炸麵筋", "糖熘兒", "拔絲山藥", "糖燜蓮子", "釀山藥", "杏仁酪", "小炒螃蟹", "氽大甲", "什錦葛仙米", "蛤蟆魚", "扒帶魚", "海鯽魚", "黃花魚", "扒海參", "扒燕窩", "扒雞腿兒", "扒雞塊兒", "扒肉", "扒麵筋", "扒三樣兒", "油潑肉", "醬潑肉", "炒蝦黃兒", "熘蟹黃兒", "炒子蟹", "佛手海參", "炒芡子米", "奶湯", "翅子湯", "三絲湯", "熏斑鳩", "鹵斑鳩", "海白米", "燴腰丁兒", "火燒茨菰", "炸鹿尾兒", "燜魚頭", "拌皮渣兒", "氽肥腸兒", "清拌粉皮兒", "木須菜", "烹丁香", "烹大肉", "烹白肉", "麻辣野雞", "鹹肉絲兒", "白肉絲兒", "荸薺", "一品鍋", "素熗春不老", "清燜蓮子", "酸黃菜", "燒蘿蔔", "燴銀耳", "炒銀枝兒", "八寶榛子醬", "黃魚鍋子", "白菜鍋子", "什錦鍋子", "湯圓子鍋", "菊花鍋子", "煮餑餑鍋子", "肉丁辣醬", "炒肉兒", "炒肉片", "燴酸菜", "燴白菜", "燴豌豆", "燜扁豆", "氽毛豆"};
	String[] japaneseFoodPrefixed = {"和風", "綜合", "日式", "鮑魚", "蘆筍", "明蝦", "章魚", "軟絲", "蘆筍", "鰻魚", "牛蒡", "蝦卵", "海膽", "紅蟳", "土瓶", "炒", "香菇", "鍋燒", "月見", "烏龍", "抹茶", "蕎麥", "味噌", "豬肉", "雞肉", "櫻花", "牛肉", "", "", "", "", "", "", "", "", "", "", "", ""};
	String[] japaneseFoodSuffixes = {"沙拉", "手卷", "蒸", "蒸蛋", "牛肉", "魚標", "紅蟳", "肉絲", "香菇", "蛤仔", "干貝", "天婦羅", "唐揚", "蔬菜", "豆腐", "豬排", "烏龍麵", "涼麵", "味噌湯", "火鍋", "壽喜燒"};
	String[] americanFoodPrefixed = {"頂級", "特級", "BBQ", "烤", "煎", "香草", "美國", "丁骨", "菲力", "香蒜", "", "", "", "", ""};
	String[] americanFoodSuffixes = {"牛排", "漢堡", "豬排", "雞翅", "牛肉", "牛小排", "馬鈴薯"};
	String[] thaiFoodPrefixed = {"泰式", "打拋", "酸辣", "咖哩", "烤", "蒸", "鹽", "炒", "炸", "魚露", "辣醬", "香辣", "椰汁", "蝦醬", "青檸", "綠", "炭燒", "涼拌", "", "", "", "", "", "", "", "", "", "", "", ""};
	String[] thaiFoodSuffixes = {"河粉", "粿仔條", "丸", "飯", "魚", "蝦餅", "湯", "冬陰功", "雞", "海鮮", "粉絲", "沙拉", "牛肉", "辣肉"};
	String[] koreanFoodPrefixed = {"大醬", "泡菜", "部隊", "雪濃", "辣炒", "煎", "烤", "韓式", "排骨", "炸", "紫菜包", "豬肉", "咖哩", "烤肉", "石鍋", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
	String[] koreanFoodSuffixes = {"鍋", "包飯", "麵", "年糕", "拌飯", "湯", "蓋飯"};
	String[] italianFoodPrefixed = {"普羅旺斯", "佐", "地中海", "初榨橄欖油", "米蘭", "燉肉末", "羅勒葉", "酸豆", "奶油", "燻鮭魚", "義式", "卡布里", "番茄", "乳酪", "炭烤", "凱薩", "松子", "箘菇", "煙燻", "莫札瑞拉", "拿坡里", "熱亞納", "帕米加諾", "西西里", "威尼斯", "奶油", "松露", "", "", "", "", "", "", "", "", "", ""};
	String[] italianFoodSuffixes = {"嫩春雞", "牛排", "牛小排", "牛肉丸", "細麵", "管麵", "貝殼麵", "吸管麵", "墨魚麵", "筆尖麵", "細扁麵", "櫻桃鴨", "沙拉", "燉飯"};
	String[] hongkongFoodPrefixed = {"", "", "", ""};
	String[] hongkongFoodSuffixes = {"魚蛋", "魚蛋粉", "沙律", "吉列海班飯", "魚春壽司", "菠蘿油", "菜遠雞粒飯", "三文治", "公司通粉", "肉絲炆米", "西多士", "帶子雞扒", "燒鵝飯", "公仔麵", "野菌忌廉湯", "油菜", "牛脷撈麵", "烏冬", "豬扒飽", "吉利海班兩麵黃"};
	String[] beveragePrefixed = {"", "", "", ""};
	String[] beverageSuffixes = {"海尼根啤酒", "沛綠雅", "香檳啤酒", "錫蘭紅茶", "美式咖啡", "玫瑰香露", "蜜桃冰釀茶", "水果茶", "檸檬汁", "柳橙汁", "蘋果汁", "蜂蜜檸檬香柚茶", "義式濃縮咖啡", "美式咖啡", "歐蕾可可", "卡布奇諾", "拿鐵", "焦糖拿鐵", "瑪琪雅朵", "斯里蘭卡紅茶", "黃金烏龍", "綠茶", "四季青", "蜜茶", "蜂蜜綠茶", "爵士奶綠", "珍珠奶茶", "冬瓜茶", "蜂蜜檸檬蘆薈"};

	private Integer generateFoodPriceByType(String food_type) {
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
		return (int) (Math.random() * upperBound) + lowerBound;
	}
	
	private Long generateRandomReviewCounts() {
		return (long) (Math.random() * 30000) + 1;
	}
}