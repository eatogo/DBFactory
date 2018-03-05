USE eatogodb;
ALTER TABLE `USERS` DROP FOREIGN KEY USERS_user_status_FK;
ALTER TABLE `AUTHENTICATIONS` DROP FOREIGN KEY AUTHENTICATIONS_user_id_FK;
ALTER TABLE `STORES` DROP FOREIGN KEY STORES_store_owner_id_FK
ALTER TABLE `STORES` DROP FOREIGN KEY STORES_store_operate_type_FK;
ALTER TABLE `STORES` DROP FOREIGN KEY STORES_store_area_FK;
ALTER TABLE `STORE_AUTHORIZATIONS` DROP FOREIGN KEY STORE_AUTHORIZATIONS_store_auth_id_FK;
ALTER TABLE `STORE_AUTHORIZATIONS` DROP FOREIGN KEY STORE_AUTHORIZATIONS_store_auth_user_FK;
ALTER TABLE `STORE_AUTHORIZATIONS` DROP FOREIGN KEY STORE_AUTHORIZATIONS_store_auth_FK;
ALTER TABLE `FOODS` DROP FOREIGN KEY FOODS_food_type_FK;
ALTER TABLE `FOODS` DROP FOREIGN KEY FOODS_food_store_FK;
ALTER TABLE `ORDERS` DROP FOREIGN KEY ORDERS_order_user_FK;
ALTER TABLE `ORDERS` DROP FOREIGN KEY ORDERS_order_store_FK;
ALTER TABLE `ORDERS` DROP FOREIGN KEY ORDERS_order_confirm_user_FK;
ALTER TABLE `ORDERS` DROP FOREIGN KEY ORDERS_order_takeout_period_FK;
ALTER TABLE `ORDER_DETAILS` DROP FOREIGN KEY ORDER_DETAILS_order_id_FK;
ALTER TABLE `ORDER_DETAILS` DROP FOREIGN KEY ORDER_DETAILS_order_food_FK;
ALTER TABLE `FAVORITES` DROP FOREIGN KEY FAVORITES_favorite_food_FK;
ALTER TABLE `FAVORITES` DROP FOREIGN KEY FAVORITES_favorite_user_FK;
ALTER TABLE `REVIEWS` DROP FOREIGN KEY REVIEWS_review_user_FK;
ALTER TABLE `REVIEWS` DROP FOREIGN KEY REVIEWS_review_order_FK;
ALTER TABLE `REVIEWS` DROP FOREIGN KEY REVIEWS_review_food_FK;