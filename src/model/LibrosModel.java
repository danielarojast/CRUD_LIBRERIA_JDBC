package model;

import dataBase.CRUD;
import dataBase.ConfigDB;
import entity.Autores;
import entity.Libro;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibrosModel implements CRUD{

    public Object insert (Object obj){
        //1. Abrir la conexion
        Connection objConnection = ConfigDB.openConnection();
        // 2. convertir el objeto que llego a libro;
        Libro objLibro = (Libro) obj;

        try{
            //3. Ecribri codigo sql
            String sql = "INSERT INTO libro(titulo, año_publicacion, precio, id_autor) VALUES (?,?,?,?)";

            //4. Preparar el statement, ademas agregamos la propiedad RETURN GENERATE KEYS, que hace que la sentencia SQL retorno los id generado por la base de datos.
            PreparedStatement objPrepare= objConnection.prepareStatement(sql,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            //5. llenar los datos ?,?,?
            objPrepare.setString(1, objLibro.getTitulo());
            objPrepare.setString(2, objLibro.getAño_publicaicon());
            objPrepare.setDouble(3,objLibro.getPrecio());
            objPrepare.setInt(4, objLibro.getId_autor());

            //6. ejecuto el query
            objPrepare.execute();

            //7. obtener el resultado con el id o lleves generadas
            ResultSet objRest= objPrepare.getGeneratedKeys();

            //8. Iterar mientras  haya un registro
            while (objRest.next()){
                objLibro.setId(objRest.getInt(1));
            }

            JOptionPane.showMessageDialog(null, "Libro insertion was successful");

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        //Cerrar Conexion
        ConfigDB.closeConnection();
        return objLibro;

    }

    public List<Object> findAll() {
        //1. Crear lista para guardar lo que nos devuelve la base de datos
        List<Object> listLibros = new ArrayList<>();

        //2. Abrir conexion
        Connection objConnection = ConfigDB.openConnection();

        try{
            //3. Escribir el codigo SQL;
            String sql= "SELECT * FROM libro INNER JOIN autores ON autores.id = libro.id_autor ;";

            //4. Usar el prepareStatement
            PreparedStatement objprepare= objConnection.prepareStatement(sql);

            //5. Ejecutar el query y obtener el resultado(ResueltSet)

            ResultSet objResult= objprepare.executeQuery();

            //6. Mientras haya un resultado siguiente hacer:
            while(objResult.next()) {
                //6.1 Crear un coder
                Libro objLibro = new Libro();
                Autores objAutores = new Autores();

                //6.2 Llenar el objero con la informacion de la base de datos
                objLibro.setTitulo(objResult.getString("titulo"));
                objLibro.setAño_publicaicon(objResult.getString("año_publicacion"));
                objLibro.setPrecio(objResult.getDouble("precio"));
                objLibro.setId_autor(objResult.getInt("id_autor"));

                objLibro.setObjAutor(objAutores);
                //6.3 Agregamos el libro a la lista
                listLibros.add(objLibro);
            }

        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        //7. Cerrar la conexion.
        ConfigDB.closeConnection();
        return listLibros;
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