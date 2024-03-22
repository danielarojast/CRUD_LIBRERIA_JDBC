package model;

import dataBase.ConfigDB;
import entity.Autores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dataBase.CRUD;

import javax.swing.*;
public class AutoresModel implements CRUD{

    public Object insert(Object obj){
        //1. Abrir la conexion
        Connection objConnection = ConfigDB.openConnection();

        // 2. convertir el objeto que llego a autor;
        Autores objAutores = (Autores) obj;

        try{
            //3. Ecribri codigo sql
            String sql = "INSERT INTO autores(nombre, nacionalidad) VALUES (?,?)";

            //4. Preparar el statement, ademas agregamos la propiedad RETURN GENERATE KEYS, que hace que la sentencia SQL retorno los id generado por la base de datos.
            PreparedStatement objPrepare= objConnection.prepareStatement(sql,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            //5. Dar los valores a los ?,?,?
            objPrepare.setString(1, objAutores.getNombre());
            objPrepare.setString(2, objAutores.getNacionalidad());

            //6. ejecuto el query
            objPrepare.execute();

            //7. obtener el resultado con el id o lleves generadas
            ResultSet objRest= objPrepare.getGeneratedKeys();

            //8. Iterar mientras  haya un registro
            while (objRest.next()){
                objAutores.setId(objRest.getInt(1));
            }

            JOptionPane.showMessageDialog(null, "Autor insertion was successful");

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        //Cerrar conexion
        ConfigDB.closeConnection();

        return objAutores;
    }

    @Override
    public List<Object> findAll() {
        //1. Crear lista para guardar lo que nos devuelve la base de datos
        List<Object> listAutores = new ArrayList<>();

        //2. Abrir conexion
        Connection objConnection = ConfigDB.openConnection();

        try{
            //3. Escribir el codigo SQL;
            String sql= "SELECT * FROM autores;";

            //4. Usar el prepareStatement
            PreparedStatement objprepare= objConnection.prepareStatement(sql);

            //5. Ejecutar el query y obtener el resultado(ResueltSet)

            ResultSet objResult= objprepare.executeQuery();

            //6. Mientras haya un resultado siguiente hacer:
            while(objResult.next()){
                //6.1 Crear un coder
                Autores objAutores= new Autores();

                //6.2 Llenar el objero con la informacion de la base de datos
                objAutores.setNombre(objResult.getString("nombre"));
                objAutores.setNacionalidad(objResult.getString("nacionalidad"));

                //6.3 Agregamos el coder a la lista
                listAutores.add(objAutores);
            }

        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        //7. Cerrar la conexion.
        ConfigDB.closeConnection();
        return listAutores;
    }

    @Override
    public boolean update(Object obj) {
        return false;
    }

    @Override
    public boolean delete(Object obj) {
        return false;
    }
}
