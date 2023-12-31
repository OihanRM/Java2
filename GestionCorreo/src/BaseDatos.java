import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BaseDatos {
    //DATOS DE LA BD
    Connection cn;
    String cadenaConex="jdbc:mysql://localhost:3306/correos"; 

    public  BaseDatos()
    {

    }
    //CONECTARBBDD
    public void connectDatabase()
    {
        try 
        {
            cn=DriverManager.getConnection(cadenaConex, "root", "");
        } catch (SQLException e) 
        { 
            System.err.println("ERROR AL CONECTAR DATABASE");
            System.out.println(e.getMessage());
        }
    }
    //DISCONNECTBBDD
    public void disconectDatabase()
    {
        try {
            cn.close();
        } catch (SQLException e) {
            System.err.println("ERROR AL DESCONECTAR DATABASE");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    //GUARDAR DATOS (INSERT)
    public int insertSQL(Persona insert)
    {
        String strSent;
        PreparedStatement sentencia;
        if(insert.getClass()==Persona.class)
        {
            strSent= "INSERT INTO personas VALUES (NULL, ?, ?, ?, ?)";
            try {
                sentencia=cn.prepareStatement(strSent, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                sentencia.setString(1, insert.getNombre());
                sentencia.setString(2, insert.getApellido());
                sentencia.setString(3, insert.getCorreo());
                sentencia.setString(4, insert.getWeb());
                return(sentencia.executeUpdate());
            } catch (SQLException e) {
                System.err.println("FALLO EN LA PREPARE INSERT");
                e.printStackTrace();
            }
        }
        if(insert.getClass()==Empleado.class)
        {
            strSent= "INSERT INTO empleados VALUES (NULL, ?, ?, ?, ?, ?, ?, ?)";
        }
        return -1;
    }
    //OBTENER DATOS (SELECT)

    public Persona selectSQL()
    {
        Persona item=null;
        String strSent;
        strSent="SELECT * FROM personas";
         
        return item;
    }
}
  