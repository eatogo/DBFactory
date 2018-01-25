package hibernate._00_init.schemas.favorite;

public class FAVORITES {
	private Integer favorite_id;
	private Integer favorite_food;
	private Integer favorite_user;
	
	public FAVORITES() {
		super();
	}

	public FAVORITES(Integer favorite_id, Integer favorite_food, Integer favorite_user) {
		super();
		this.favorite_id = favorite_id;
		this.favorite_food = favorite_food;
		this.favorite_user = favorite_user;
	}

	public Integer getFavorite_id() {
		return favorite_id;
	}

	public void setFavorite_id(Integer favorite_id) {
		this.favorite_id = favorite_id;
	}

	public Integer getFavorite_food() {
		return favorite_food;
	}

	public void setFavorite_food(Integer favorite_food) {
		this.favorite_food = favorite_food;
	}

	public Integer getFavorite_user() {
		return favorite_user;
	}

	public void setFavorite_user(Integer favorite_user) {
		this.favorite_user = favorite_user;
	}
	
}
