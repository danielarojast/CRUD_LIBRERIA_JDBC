package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
    // atributo con el estado de la coneccion.
    public static Connection objConnection = null;

    //Metodo para conectar la BD
    public static Connection openConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url= "jdbc://bl0untjmxhmisdcibegy-mysql.services.clever-cloud.com/bl0untjmxhmisdcibegy";
            String user= "ubutcni48p63r1fj";
            String password= "GJ8cvlomEHhkbZO83NbA";

            //Establecer conexion.
            objConnection= (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("Me conecte perfectamente");

        }catch (ClassNotFoundException error){
            System.out.println("ERROR >> Driver no instalado" + error.getMessage());
        }catch (SQLException error){
            System.out.println("ERROR >> error al conectar la base de datos" + error.getMessage());
        }
        return objConnection;
    }

    // Metodo para cerrar la conexion
    public static void closeConnection(){
        try{
            // condicional para saber si hay conecion activa
            if(objConnection != null) objConnection.close();
            System.out.println("Se finalizo la conexion con exito.");
        }catch (SQLException e){
            System.out.println("Error: "+ e.getMessage());
        }
    }
}

