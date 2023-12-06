import java.sql.*;
import java.util.*;

public class CreateCRUD {
    public static void main(String[] args) {
        String status = "Nada aconteceu";
        try {
            Connection conn = App.conectar();
            String strSqlCreate = "CREATE TABLE `teste`.`tbl_usuarios` (`id` INT NOT NULL AUTO_INCREMENT,`usuario` VARCHAR(255) NULL,`senha` VARCHAR(255) NULL,PRIMARY KEY (`id`));";
            Statement stmSql = null;
            stmSql = conn.createStatement();
            stmSql.addBatch(strSqlCreate);
            stmSql.executeBatch();
            status = "Ok! Tabela criada.";
            stmSql.close();
        } catch (SQLException e) {
            status = "Erro SQLException: " + e;
        } catch (Exception e) {
            status = "Erro Exception: " + e;
        }
        System.out.println(status);
    }
}
