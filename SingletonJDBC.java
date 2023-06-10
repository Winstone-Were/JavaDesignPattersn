
import java.sql.*;
public class JDBC_Connector {

    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://localhost:3306/drugdispensary";
    static final String USER = "root";
    static final String PASS = "123pass";
    private static JDBC_Connector ConnectorClass = null;

    static Connection Conn = null;

    static  {
        try{
            Conn = DriverManager.getConnection(DB_URL,USER,PASS);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static Connection GetConnection() {

            try{
                if(Conn == null){
                    Conn = DriverManager.getConnection(DB_URL,USER,PASS);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }

            return Conn;
    }

}

