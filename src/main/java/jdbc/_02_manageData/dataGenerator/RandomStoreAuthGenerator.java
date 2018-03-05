package jdbc._02_manageData.dataGenerator;

import jdbc._00_Init.pojo.STORE_AUTHORIZATIONS;

public class RandomStoreAuthGenerator {
	
	private STORE_AUTHORIZATIONS generatedAuth = null;
	
	public RandomStoreAuthGenerator() {
		generatedAuth = new STORE_AUTHORIZATIONS();
	}
	
	public STORE_AUTHORIZATIONS generateRandomAuth(Integer store_id) {
		generatedAuth.setStore_auth_id(store_id);
		generatedAuth.setStore_auth_user((int) (Math.random() * 72) + 28);
		generatedAuth.setStore_au("manager");
		return generatedAuth;
	}

}
