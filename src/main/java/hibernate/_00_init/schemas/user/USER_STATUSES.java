package hibernate._00_init.schemas.user;

public class USER_STATUSES {
	private String status_type;
	private String status_description;
	
	public USER_STATUSES() {
		super();
	}

	public USER_STATUSES(String status_type, String status_description) {
		super();
		this.status_type = status_type;
		this.status_description = status_description;
	}

	public String getStatus_type() {
		return status_type;
	}

	public void setStatus_type(String status_type) {
		this.status_type = status_type;
	}

	public String getStatus_description() {
		return status_description;
	}

	public void setStatus_description(String status_description) {
		this.status_description = status_description;
	}
	
	
}
