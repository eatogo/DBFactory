package jdbc._00_Init.pojo;

public class STORE_AUTHORIZATIONS {

	private Integer store_auth_id;
	private Integer store_auth_user;
	private String store_au;

	public STORE_AUTHORIZATIONS() {
	}

	public STORE_AUTHORIZATIONS(Integer store_auth_id, Integer store_auth_user, String store_au) {
		this.store_auth_id = store_auth_id;
		this.store_auth_user = store_auth_user;
		this.store_au = store_au;
	}

	public Integer getStore_auth_id() {
		return store_auth_id;
	}

	public void setStore_auth_id(Integer store_auth_id) {
		this.store_auth_id = store_auth_id;
	}

	public Integer getStore_auth_user() {
		return store_auth_user;
	}

	public void setStore_auth_user(Integer store_auth_user) {
		this.store_auth_user = store_auth_user;
	}

	public String getStore_au() {
		return store_au;
	}

	public void setStore_au(String store_au) {
		this.store_au = store_au;
	}

}