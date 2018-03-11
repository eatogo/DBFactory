package jdbc.utils;

import jdbc.model.pojo.STORE_AUTHORIZATIONS;

public class RandomStoreAuthFactory {
	
	private STORE_AUTHORIZATIONS generatedAuth;
	
	public RandomStoreAuthFactory() {
		generatedAuth = new STORE_AUTHORIZATIONS();
	}
	
	public STORE_AUTHORIZATIONS generateRandomAuth(Integer store_id) {
		generatedAuth.setStore_auth_id(store_id);
		generatedAuth.setStore_auth_user((int) (Math.random() * 72) + 28);
		generatedAuth.setStore_auth("manager");
		return generatedAuth;
	}

}
