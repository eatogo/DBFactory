USE eatogodb;
DROP TABLE IF EXISTS `USERS`;
CREATE TABLE `USERS` (user_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, user_password VARCHAR(50) NOT NULL, user_cellphone VARCHAR(20) NOT NULL, user_name VARCHAR(50) NOT NULL, user_email VARCHAR(50), user_avatar VARCHAR(255) DEFAULT 'default.png', user_create_time DATETIME NOT NULL, user_status VARCHAR(20) NOT NULL DEFAULT 'unverified');
DROP TABLE IF EXISTS `USER_STATUSES`;
CREATE TABLE `USER_STATUSES` (status_type VARCHAR(20) PRIMARY KEY NOT NULL, status_description VARCHAR(20) NOT NULL);
DROP TABLE IF EXISTS `AUTHENTICATIONS`;
CREATE TABLE `AUTHENTICATIONS` (user_id INT PRIMARY KEY NOT NULL, user_uuid VARCHAR(36) NOT NULL);
DROP TABLE IF EXISTS `STORES`;
CREATE TABLE `STORES` (store_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, store_owner_id INT NOT NULL, store_name VARCHAR(50) NOT NULL, store_address VARCHAR(255) NOT NULL, store_phone VARCHAR(30) NOT NULL, store_email VARCHAR(50), store_logo VARCHAR(255) NOT NULL DEFAULT 'store_default.png', store_open_hour VARCHAR(100), store_intro TEXT, store_latitude DOUBLE NOT NULL, store_longitude DOUBLE NOT NULL, store_area INT NOT NULL, store_operate_type VARCHAR(20) NOT NULL DEFAULT 'wholeday', store_status VARCHAR(10) NOT NULL DEFAULT 'rest');
DROP TABLE IF EXISTS `STORE_AUTHORIZATIONS`;
CREATE TABLE `STORE_AUTHORIZATIONS` (store_auth_id INT NOT NULL, store_auth_user INT NOT NULL, store_auth VARCHAR(20), CONSTRAINT PK_STORE_AUTHORIZATIONS PRIMARY KEY (store_auth_id, store_auth_user));
DROP TABLE IF EXISTS `IDENTITIES`;
CREATE TABLE `IDENTITIES` (identity_type VARCHAR(20) PRIMARY KEY NOT NULL, identity_description VARCHAR(20) NOT NULL);
DROP TABLE IF EXISTS `OPERATE_TYPES`;
CREATE TABLE `OPERATE_TYPES` (operate_type VARCHAR(20) PRIMARY KEY NOT NULL, operate_type_description VARCHAR(20) NOT NULL, operate_rest_mode VARCHAR(20), operate_period VARCHAR(26) NOT NULL);
DROP TABLE IF EXISTS `PERIODS`;
CREATE TABLE `PERIODS` (period_id CHAR PRIMARY KEY NOT NULL, period_description VARCHAR(20), period_start TIME NOT NULL, period_end TIME NOT NULL);
DROP TABLE IF EXISTS `AREAS`;
CREATE TABLE `AREAS` (area_id INT PRIMARY KEY NOT NULL, area_description VARCHAR(50) NOT NULL, area_city VARCHAR(50) NOT NULL);
DROP TABLE IF EXISTS `FOODS`;
CREATE TABLE `FOODS` (food_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, food_name VARCHAR(50) NOT NULL, food_price MEDIUMINT, food_intro VARCHAR(50), food_pic_hdpi VARCHAR(255), food_pic_ldpi VARCHAR(255), food_pic_mdpi VARCHAR(255), food_pic VARCHAR(255), food_limit INT NOT NULL DEFAULT '1000', food_type VARCHAR(20) NOT NULL, food_store INT NOT NULL, food_status VARCHAR(20) NOT NULL DEFAULT 'logging', food_review_count BIGINT NOT NULL DEFAULT '0');
DROP TABLE IF EXISTS `FOOD_TYPES`;
CREATE TABLE `FOOD_TYPES` (food_type VARCHAR(20) PRIMARY KEY NOT NULL, food_description VARCHAR(50) NOT NULL);
DROP TABLE IF EXISTS `ORDERS`;
CREATE TABLE `ORDERS` (order_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, order_user INT NOT NULL, order_note VARCHAR(100), order_time DATETIME NOT NULL, order_reserve_date DATE, order_store INT NOT NULL, order_confirm_user INT, order_confirm_time DATETIME, order_takeout_period CHAR, order_status VARCHAR(20) NOT NULL DEFAULT 'ordered', order_finished_time DATETIME);
DROP TABLE IF EXISTS `ORDER_DETAILS`;
CREATE TABLE `ORDER_DETAILS` (order_detail_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, order_id INT NOT NULL, order_food INT NOT NULL, order_quantity INT NOT NULL DEFAULT '1');
DROP TABLE IF EXISTS `FAVORITES`;
CREATE TABLE `FAVORITES` (favorite_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, favorite_food INT NOT NULL, favorite_user INT NOT NULL);
DROP TABLE IF EXISTS `REVIEWS`;
CREATE TABLE `REVIEWS` (review_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, review_user INT NOT NULL, review_order INT NOT NULL, review_food INT, review_time DATETIME NOT NULL, review_comment TEXT);