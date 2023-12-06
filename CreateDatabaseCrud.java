import java.sql.*;
import java.util.*;

public class CreateDatabaseCrud {
    public static void main(String[] args) {
        String status = "Nada aconteceu";
        try {
            Connection conn = Conector.conectar();
            String strSqlCreate = "CREATE DATABASE `teste2`;";
            Statement stmSql = null;
            stmSql = conn.createStatement();
            stmSql.addBatch(strSqlCreate);
            stmSql.executeBatch();
            status = "Ok! Database criada.";
            stmSql.close();
        } catch (SQLException e) {
            status = "Erro SQLException: " + e;
        } catch (Exception e) {
            status = "Erro Exception: " + e;
        }
        System.out.println(status);
    }
}
