/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectardbsql2012;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author Jair Parra
 */
public class ConexionDB {

    public static Connection GetConnection() {
        Connection conexion = null;

        try {

            String url = "jdbc:sqlserver://PCJ;databaseName=CanaproAp;user=sa;password=123456;";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            System.out.println(url);             
            conexion = DriverManager.getConnection(url);
            Statement sentencia = conexion.createStatement();
            ResultSet rs = sentencia.executeQuery("select * from AsociadosCarnet order by 1");
            int size = 0;
            while (rs.next()) {
                System.out.println(rs.getBigDecimal("nit") + " - " + rs.getString("nombreasociado"));
                size++;
            }
            System.out.println("Numero de registro: " + size);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error1 en la Conexión con la BD " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error2 en la Conexión con la BD " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Error3 en la Conexión con la BD " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
        } finally {
            return conexion;
        }
    }
}
