package hibernate._00_init.schemas.review;

import java.sql.Clob;
import java.util.Date;

public class REVIEWS {
	private Integer review_id;
	private Integer review_user;
	private Integer review_order;
	private Integer review_food;
	private Date review_time;
	private Clob review_comment;
	
	public REVIEWS() {
		super();
	}

	public REVIEWS(Integer review_id, Integer review_user, Integer review_order, Integer review_food, Date review_time,
			Clob review_comment) {
		super();
		this.review_id = review_id;
		this.review_user = review_user;
		this.review_order = review_order;
		this.review_food = review_food;
		this.review_time = review_time;
		this.review_comment = review_comment;
	}

	public Integer getReview_id() {
		return review_id;
	}

	public void setReview_id(Integer review_id) {
		this.review_id = review_id;
	}

	public Integer getReview_user() {
		return review_user;
	}

	public void setReview_user(Integer review_user) {
		this.review_user = review_user;
	}

	public Integer getReview_order() {
		return review_order;
	}

	public void setReview_order(Integer review_order) {
		this.review_order = review_order;
	}

	public Integer getReview_food() {
		return review_food;
	}

	public void setReview_food(Integer review_food) {
		this.review_food = review_food;
	}

	public Date getReview_time() {
		return review_time;
	}

	public void setReview_time(Date review_time) {
		this.review_time = review_time;
	}

	public Clob getReview_comment() {
		return review_comment;
	}

	public void setReview_comment(Clob review_comment) {
		this.review_comment = review_comment;
	}
	
}
