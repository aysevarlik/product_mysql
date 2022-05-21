package aysevarlik;

import lombok.Data;

@Data
public class DatabaseInformation {
    //database'le bağlantı kurabilmek için bilmemiz gereken yapılar:
    private String url;
    private String userName;
    private String userPassword;
    private String forNameData;

    public DatabaseInformation() {
        this.url = "jdbc:mysql://localhost:3306/product_database";
        this.userName = "root";
        this.userPassword = "root";
        this.forNameData = "com.mysql.cj.jdbc.Driver";
    }
}
