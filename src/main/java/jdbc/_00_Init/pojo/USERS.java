package jdbc._00_Init.pojo;

import java.util.Date;

public class USERS {

	private Integer user_id;
	private String user_password;
	private String user_cellphone;
	private String user_name;
	private String user_email;
	private String user_avatar;
	private Date user_create_time;
	private String user_status;

	public USERS() {
	}

	public USERS(Integer user_id, String user_password, String user_cellphone, String user_name, String user_email,
			String user_avatar, Date user_create_time, String user_status) {
		this.user_id = user_id;
		this.user_password = user_password;
		this.user_cellphone = user_cellphone;
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_avatar = user_avatar;
		this.user_create_time = user_create_time;
		this.user_status = user_status;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_cellphone() {
		return user_cellphone;
	}

	public void setUser_cellphone(String user_cellphone) {
		this.user_cellphone = user_cellphone;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_avatar() {
		return user_avatar;
	}

	public void setUser_avatar(String user_avatar) {
		this.user_avatar = user_avatar;
	}

	public Date getUser_create_time() {
		return user_create_time;
	}

	public void setUser_create_time(Date user_create_time) {
		this.user_create_time = user_create_time;
	}

	public String getUser_status() {
		return user_status;
	}

	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}

}