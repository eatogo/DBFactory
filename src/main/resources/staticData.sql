USE eatogodb;
INSERT INTO `IDENTITIES` VALUES ('consumer', '消費者');
INSERT INTO `IDENTITIES` VALUES ('owner', '店家負責人');
INSERT INTO `IDENTITIES` VALUES ('manager', '店家管理員');
INSERT INTO `USER_STATUSES` VALUES ('unregistered', '終止、未驗證');
INSERT INTO `USER_STATUSES` VALUES ('normal', '正常狀態');
INSERT INTO `USER_STATUSES` VALUES ('warning', '警告狀態');
INSERT INTO `USER_STATUSES` VALUES ('blacklisted', '黑名單');
INSERT INTO `FOOD_TYPES` VALUES ('chinese', '中式');
INSERT INTO `FOOD_TYPES` VALUES ('japanese', '日式');
INSERT INTO `FOOD_TYPES` VALUES ('american', '美式');
INSERT INTO `FOOD_TYPES` VALUES ('thailand', '泰式');
INSERT INTO `FOOD_TYPES` VALUES ('korean', '韓式');
INSERT INTO `FOOD_TYPES` VALUES ('italian', '義式');
INSERT INTO `FOOD_TYPES` VALUES ('hongkong', '港式');
INSERT INTO `FOOD_TYPES` VALUES ('beverage', '茶飲類');
INSERT INTO `PERIODS` VALUES ('A', '0000-0100', '00:00:00', '00:59:59');
INSERT INTO `PERIODS` VALUES ('B', '0100-0200', '01:00:00', '01:59:59');
INSERT INTO `PERIODS` VALUES ('C', '0200-0300', '02:00:00', '02:59:59');
INSERT INTO `PERIODS` VALUES ('D', '0300-0400', '03:00:00', '03:59:59');
INSERT INTO `PERIODS` VALUES ('E', '0400-0500', '04:00:00', '04:59:59');
INSERT INTO `PERIODS` VALUES ('F', '0500-0600', '05:00:00', '05:59:59');
INSERT INTO `PERIODS` VALUES ('G', '0600-0700', '06:00:00', '06:59:59');
INSERT INTO `PERIODS` VALUES ('H', '0700-0800', '07:00:00', '07:59:59');
INSERT INTO `PERIODS` VALUES ('I', '0800-0900', '08:00:00', '08:59:59');
INSERT INTO `PERIODS` VALUES ('J', '0900-1000', '09:00:00', '09:59:59');
INSERT INTO `PERIODS` VALUES ('K', '1000-1100', '10:00:00', '10:59:59');
INSERT INTO `PERIODS` VALUES ('L', '1100-1200', '11:00:00', '11:59:59');
INSERT INTO `PERIODS` VALUES ('M', '1200-1300', '12:00:00', '12:59:59');
INSERT INTO `PERIODS` VALUES ('N', '1300-1400', '13:00:00', '13:59:59');
INSERT INTO `PERIODS` VALUES ('O', '1400-1500', '14:00:00', '14:59:59');
INSERT INTO `PERIODS` VALUES ('P', '1500-1600', '15:00:00', '15:59:59');
INSERT INTO `PERIODS` VALUES ('Q', '1600-1700', '16:00:00', '16:59:59');
INSERT INTO `PERIODS` VALUES ('R', '1700-1800', '17:00:00', '17:59:59');
INSERT INTO `PERIODS` VALUES ('S', '1800-1900', '18:00:00', '18:59:59');
INSERT INTO `PERIODS` VALUES ('T', '1900-2000', '19:00:00', '19:59:59');
INSERT INTO `PERIODS` VALUES ('U', '2000-2100', '20:00:00', '20:59:59');
INSERT INTO `PERIODS` VALUES ('V', '2100-2200', '21:00:00', '21:59:59');
INSERT INTO `PERIODS` VALUES ('W', '2200-2300', '22:00:00', '22:59:59');
INSERT INTO `PERIODS` VALUES ('X', '2300-0000', '23:00:00', '23:59:59');
INSERT INTO `OPERATE_TYPES` VALUES ('wholeday', '全日營業型', 'null', 'LMNRSTU');
INSERT INTO `OPERATE_TYPES` VALUES ('noon', '中午營業', 'null', 'LMN');
INSERT INTO `OPERATE_TYPES` VALUES ('evening', '傍晚營業', 'null', 'RSTU');
INSERT INTO `AREAS` VALUES ('100', '中正區', '台北市');
INSERT INTO `AREAS` VALUES ('103', '大同區', '台北市');
INSERT INTO `AREAS` VALUES ('104', '中山區', '台北市');
INSERT INTO `AREAS` VALUES ('105', '松山區', '台北市');
INSERT INTO `AREAS` VALUES ('106', '大安區', '台北市');
INSERT INTO `AREAS` VALUES ('108', '萬華區', '台北市');
INSERT INTO `AREAS` VALUES ('110', '信義區', '台北市');
INSERT INTO `AREAS` VALUES ('111', '士林區', '台北市');
INSERT INTO `AREAS` VALUES ('112', '北投區', '台北市');
INSERT INTO `AREAS` VALUES ('114', '內湖區', '台北市');
INSERT INTO `AREAS` VALUES ('115', '南港區', '台北市');
INSERT INTO `AREAS` VALUES ('116', '文山區', '台北市');
INSERT INTO `AREAS` VALUES ('207', '萬里區', '新北市');
INSERT INTO `AREAS` VALUES ('208', '金山區', '新北市');
INSERT INTO `AREAS` VALUES ('220', '板橋區', '新北市');
INSERT INTO `AREAS` VALUES ('221', '汐止區', '新北市');
INSERT INTO `AREAS` VALUES ('222', '深坑區', '新北市');
INSERT INTO `AREAS` VALUES ('223', '石碇區', '新北市');
INSERT INTO `AREAS` VALUES ('224', '瑞芳區', '新北市');
INSERT INTO `AREAS` VALUES ('226', '平溪區', '新北市');
INSERT INTO `AREAS` VALUES ('227', '雙溪區', '新北市');
INSERT INTO `AREAS` VALUES ('228', '貢寮區', '新北市');
INSERT INTO `AREAS` VALUES ('231', '新店區', '新北市');
INSERT INTO `AREAS` VALUES ('232', '坪林區', '新北市');
INSERT INTO `AREAS` VALUES ('233', '烏來區', '新北市');
INSERT INTO `AREAS` VALUES ('234', '永和區', '新北市');
INSERT INTO `AREAS` VALUES ('235', '中和區', '新北市');
INSERT INTO `AREAS` VALUES ('236', '土城區', '新北市');
INSERT INTO `AREAS` VALUES ('237', '三峽區', '新北市');
INSERT INTO `AREAS` VALUES ('238', '樹林區', '新北市');
INSERT INTO `AREAS` VALUES ('239', '鶯歌區', '新北市');
INSERT INTO `AREAS` VALUES ('241', '三重區', '新北市');
INSERT INTO `AREAS` VALUES ('242', '新莊區', '新北市');
INSERT INTO `AREAS` VALUES ('243', '泰山區', '新北市');
INSERT INTO `AREAS` VALUES ('244', '林口區', '新北市');
INSERT INTO `AREAS` VALUES ('247', '蘆洲區', '新北市');
INSERT INTO `AREAS` VALUES ('248', '五股區', '新北市');
INSERT INTO `AREAS` VALUES ('249', '八里區', '新北市');
INSERT INTO `AREAS` VALUES ('251', '淡水區', '新北市');
INSERT INTO `AREAS` VALUES ('252', '三芝區', '新北市');
INSERT INTO `AREAS` VALUES ('253', '石門區', '新北市');