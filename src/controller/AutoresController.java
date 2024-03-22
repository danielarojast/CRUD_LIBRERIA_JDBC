package controller;

import entity.Autores;
import model.AutoresModel;

import javax.swing.*;

public class AutoresController {
    //1. get All
    public static void getAll(){
        AutoresModel objModel = new AutoresModel();
        String listAutores= "AUTOR LIST \n";

        for(Object iterador: objModel.findAll()){
            //Convertir el object a Coder
            Autores objAutores= (Autores) iterador;
            listAutores += objAutores.toString() + "\n";

        }
        JOptionPane.showMessageDialog(null, listAutores);
    }

    // 3. sobre escribir el get all pasa usarlo solo en delete y en upDate.
    public static String getAllString(){
        AutoresModel objModel = new AutoresModel();
        String listAutores= "CODER LIST \n";

        for(Object iterador: objModel.findAll()){
            //Convertir el object a Coder
            Autores objAutores= (Autores) iterador;
            listAutores += objAutores.toString() + "\n";

        }
        return listAutores;
    }

    //2. create
    public static void create () {
        //Usamos el modelo
        AutoresModel objAutoresModel = new AutoresModel();

        //Pedimos los datos al usuario
        String nombre = JOptionPane.showInputDialog("Insert nombre");
        String nacionalidad = JOptionPane.showInputDialog("Insert nacionalidad");

        Autores objAutores = new Autores();
        objAutores.setNombre(nombre);
        objAutores.setNacionalidad(nacionalidad);

        //Llamos al metodo de inserccion y guardamos el objeto que retorna en el coder
        // previamente instanciado.
        objAutores = (Autores) objAutoresModel.insert(objAutores);

        JOptionPane.showMessageDialog(null, objAutores.toString());
    }
}
