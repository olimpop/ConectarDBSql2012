/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectardbsql2012;
import java.sql.Connection;
import javax.swing.JOptionPane;
/**
 *
 * @author Jair Parra
 */
public class ConectarDBSql2012 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection miConexion;
        miConexion=ConexionDB.GetConnection();
     
        if(miConexion!=null)
        {
            JOptionPane.showMessageDialog(null, "Conexión Realizada Correctamente");
        }
    }
    
}
