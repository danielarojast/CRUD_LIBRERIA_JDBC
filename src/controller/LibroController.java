package controller;

import entity.Autores;
import entity.Libro;
import model.AutoresModel;
import model.LibrosModel;

import javax.swing.*;

public class LibroController {
    //1. get All
    public static void getAll(){
        LibrosModel objModel = new LibrosModel();
        String listLibro= "LIBRO LIST \n";

        for(Object iterador: objModel.findAll()){
            //Convertir el object a Coder
            Libro objLibro= (Libro) iterador;
            listLibro += objLibro.toString() + "\n";

        }
        JOptionPane.showMessageDialog(null, listLibro);
    }

    // 3. sobre escribir el get all pasa usarlo solo en delete y en upDate.
    public static String getAllString(){
        LibrosModel objModel = new LibrosModel();
        String listLibro= "Libro LIST \n";

        for(Object iterador: objModel.findAll()){
            //Convertir el object a Coder
            Libro objLibro= (Libro) iterador;
            listLibro += objLibro.toString() + "\n";

        }
        return listLibro;
    }

    //2. create
    public static void create () {
        //Usamos el modelo
        LibrosModel objLibro = new LibrosModel();

        //Pedimos los datos al usuario
        String titulo = JOptionPane.showInputDialog("Insert nombre");
        String año_publicacion = JOptionPane.showInputDialog("Insert año de publicacion");
        double precio = JOptionPane.showInputDialog("Insert precio");

        Libro objLibro = new Libro();
        objLibro.setTitulo(titulo);
        objLibro.setAño_publicacion(año_publicacion);
        objLibro.setPrecio(precio);

        //Llamos al metodo de inserccion y guardamos el objeto que retorna en el coder
        // previamente instanciado.
        objLibro = (Libro) objLibroModel.insert(objLibro);

        JOptionPane.showMessageDialog(null, objLibro.toString());
    }
}
