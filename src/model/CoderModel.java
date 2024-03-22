package model;

public class CoderModel {


}

/*  @Override
    public Object insert(Object obj) {

        //1. Abrir la conexion
        Connection objConnection = ConfigDB.openConnection();

        //2. Convertir el obj que llego a coder
        coder objCoder=(coder) obj;

        try{
            //3. Escribir SQL
            String sql = "INSERT INTO coder(name, age, clan) VALUES (?,?,?)";

            //4. Preparar el statement, ademas agregamos la propiedad RETURN GENERATE KEYS, que hace que la sentencia SQL retorno los id generado por la base de datos.
            PreparedStatement objPrepare= objConnection.prepareStatement(sql,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            //5. Asignar valor a los ?,?,?
            objPrepare.setString(1,objCoder.getName());
            objPrepare.setInt(2,objCoder.getAge());
            objPrepare.setString(3,objCoder.getClan());

            //6. Ejecutar el query
            objPrepare.execute();

            //7. Obtener el resultado con los id o llaves generadas

            ResultSet objRest= objPrepare.getGeneratedKeys();

            //8. Iterar mientras  haya un registro
            while (objRest.next()){
                objCoder.setId(objRest.getInt(1));
            }

            JOptionPane.showMessageDialog(null, "Coder insertion was successful");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

        //7. Cerrar la conexion a la vase de datos
        ConfigDB.closeConnection();
        return objCoder;
    }*/