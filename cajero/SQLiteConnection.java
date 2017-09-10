package cajero;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
 
/**
 *
 * @author sqlitetutorial.net
 */
public class SQLiteConnection {
    
	private Connection conexion;

	public SQLiteConnection() {
		try {
            // db parameters
            String url = "jdbc:sqlite:C:/Users/LAE28/Downloads/SQLiteStudio/CajeroBD.db";
            // create a connection to the database
            this.conexion = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	
    public void crear_cliente(String numero_cuenta, String nombre_completo, String clave, Integer saldo) {
        String sql = "INSERT INTO cliente(numero_cuenta,nombre_completo,clave,saldo) VALUES(?,?,?,?)";
        try {
            PreparedStatement pstmt = this.conexion.prepareStatement(sql);
            pstmt.setString(1, numero_cuenta);
            pstmt.setString(2, nombre_completo);
            pstmt.setString(3, clave);
            pstmt.setInt(4, saldo);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public Boolean actualizar_saldo(String numero_cuenta, Integer nuevo_saldo) {
    	String sql = "UPDATE cliente SET saldo=? WHERE numero_cuenta=?";
        try {
            PreparedStatement pstmt = this.conexion.prepareStatement(sql);
            pstmt.setInt(1, nuevo_saldo);
            pstmt.setString(2, numero_cuenta);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean actualizar_clave(String numero_cuenta, String nueva_clave) {
    	String sql = "UPDATE cliente SET clave=? WHERE numero_cuenta=?";
        try {
            PreparedStatement pstmt = this.conexion.prepareStatement(sql);
            pstmt.setString(1, nueva_clave);
            pstmt.setString(2, numero_cuenta);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Integer consultar_saldo(String numero_cuenta, String clave) {
    	String sql = "SELECT saldo FROM cliente WHERE numero_cuenta=? AND clave=?";
        try {
            PreparedStatement pstmt = this.conexion.prepareStatement(sql);
            pstmt.setString(1, numero_cuenta);
            pstmt.setString(2, clave);
            ResultSet rs  = pstmt.executeQuery();
            if (rs.next()) {
            	return rs.getInt("saldo");
            }else {
            	return -1;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }
    
    public String consultar_nombre_completo(String numero_cuenta, String clave) {
    	String sql = "SELECT nombre_completo FROM cliente WHERE numero_cuenta=? AND clave=?";
        try {
            PreparedStatement pstmt = this.conexion.prepareStatement(sql);
            pstmt.setString(1, numero_cuenta);
            pstmt.setString(2, clave);
            ResultSet rs  = pstmt.executeQuery();
            if (rs.next()) {
            	return rs.getString("nombre_completo");
            }else {
            	return "";
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return "";
        }
    }
    
}