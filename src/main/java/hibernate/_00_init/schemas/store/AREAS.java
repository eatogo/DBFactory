package hibernate._00_init.schemas.store;

public class AREAS {
	private Integer area_id;
	private String area_description;
	private String area_city;

	public AREAS() {
	}

	public AREAS(Integer area_id, String area_description, String area_city) {
		this.area_id = area_id;
		this.area_description = area_description;
		this.area_city = area_city;
	}

	public Integer getArea_id() {
		return area_id;
	}

	public void setArea_id(Integer area_id) {
		this.area_id = area_id;
	}

	public String getArea_description() {
		return area_description;
	}

	public void setArea_description(String area_description) {
		this.area_description = area_description;
	}

	public String getArea_city() {
		return area_city;
	}

	public void setArea_city(String area_city) {
		this.area_city = area_city;
	}

}
