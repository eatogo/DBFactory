# DBFactory 專案

此為一Maven專案，專門用來替Eatogo專案產生統一的schema以及測試用資料

# 專案適用環境

- Tomcat 8.0
- Eclipse Oxygen EE
  - Maven: Eclipse Oxygen EE內建版本
- MySQL 5.0
- Java 1.8

# 使用方法

1. Clone或Pull到本地端；若下載zip檔，請先解壓縮
2. 打開Eclipse並import專案。建議用Project from Folder or Archive選項來import專案，避免失去Git監控而不能方便更新
3. 直接運行專案Run As -> Run on Server
4. 輸入本地端MySQL使用者名稱及密碼；使用者名稱必填，密碼為optional，依各人設定
5. 按下「一鍵(重)建立Eatogo資料庫」按鈕，即可重新建立完整eatogodb的schema及測試資料

# 注意事項

- 因是Maven專案，請確保操作過程全程連網
- 若運行專案使用不是Eclipse內建瀏覽器，請務必確定使用的瀏覽器不可禁用Javascript
- 若本地端原本就有eatogodb或eatogodb已有資料，請注意按下「一鍵(重)建立Eatogo資料庫」按鈕會將整個eatogo資料庫刪除後重建

# 進階修改

因採用JDBC方式連接資料庫，若有需要修改Schema或測試資料，可直接修改位於src/main/resources資料夾內的sql檔

但請務必在Command Line或MySQL圖形介面軟體測試過SQL敘述正確後，再修改sql檔

另外修改過後，要push到Github之前，請務必在Commit內寫清楚修改內容
