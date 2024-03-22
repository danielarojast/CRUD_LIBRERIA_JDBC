import controller.AutoresController;
import entity.Autores;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String option= "";
        String option1= "";
        String option2= "";

        do{
            option = JOptionPane.showInputDialog("""
                    1. Autores. 
                    2. Libros. 
                    3. Cerrar. 
                    choose an option: """);

            switch (option1){
                case "1":
                    option1 = JOptionPane.showInputDialog("""
                    1. List Autores. 
                    2. Insert Autores. 
                    3. Update Autores. 
                    4. Delete Autores.
                    choose an option: """);

                    switch (option1){
                        case "2":
                            AutoresController.create();
                            break;


                        break;
                case "2":
                    option2 = JOptionPane.showInputDialog("""
                    1. List Libro. 
                    2. Insert Libro. 
                    3. Update Libro. 
                    4. Delete Libro.
                    choose an option: """);

                    switch (option2){
                        case "2":
                            LibroController.create();
                            break;
                    break;

            }

        }while(!option.equals("3"));
    }
}
