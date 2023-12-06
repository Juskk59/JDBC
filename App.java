import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Conectando ao banco de dados...");
        conectar();
    }

    public static Connection conectar() {
        String mysqlHost = "localhost";
        String mysqlPort = "3306";
        String mysqlNamespace = "teste";
        String mysqlUser = "root";
        String mysqlPass = "senac@02"; // pode colocar vazio (sem senha)
        String getVars = "useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String mysqlUrl = "jdbc:mysql://" + mysqlHost + ":" + mysqlPort + "/" + mysqlNamespace + "?" + getVars;
        String status = "Nada aconteceu";
        Connection conn = null;
        String strSqlTeste;
        Statement stmSql = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(mysqlUrl, mysqlUser, mysqlPass);
            status = "Connection opened";
            strSqlTeste = "CREATE TABLE `teste`.`tbl_teste` (`id` INT NOT NULL AUTO_INCREMENT,`nome` VARCHAR(255) NULL,PRIMARY KEY (`id`));"; // texto
                                                                                                                                              // corrido
            stmSql = conn.createStatement();
            stmSql.addBatch(strSqlTeste);
            stmSql.executeBatch();
            System.out.println("Ok! Tabela criada.");
            stmSql.close();
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