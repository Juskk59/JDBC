import java.sql.*;

public class Conector {
    public static void main(String[] args) throws Exception {
        System.out.println("Conectando ao banco de dados...");
        conectar();
    }

    public static Connection conectar() {
        String mysqlHost = "localhost";
        String mysqlPort = "3306";
        String mysqlUser = "root";
        String mysqlPass = "senac@02"; // pode colocar vazio (sem senha)
        String getVars = "useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String mysqlUrl = "jdbc:mysql://" + mysqlHost + ":" + mysqlPort + "/" + "?" + getVars;
        String status = "Nada aconteceu";
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(mysqlUrl, mysqlUser, mysqlPass);
            status = "Connection opened";
        } catch (SQLException e) {
            status = "Erro SQLException: " + e;
        } catch (ClassNotFoundException e) {
            status = "Erro ClassNotFoundException: " + e;
        } catch (Exception e) {
            status = "Erro Exception: " + e;
        }
        System.out.println(status);
        return conn;
    }
}