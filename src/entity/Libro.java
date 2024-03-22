package entity;

public class Libro {

    private int id;
    private String titulo;
    private String año_publicaicon;
    private double precio;
    private int id_autor;

    //Constructor
    public Libro(int id, String titulo, String año_publicaicon, double precio, int id_autor) {
        this.id = id;
        this.titulo = titulo;
        this.año_publicaicon = año_publicaicon;
        this.precio = precio;
        this.id_autor = id_autor;
    }

    //Setter y getter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAño_publicaicon() {
        return año_publicaicon;
    }

    public void setAño_publicaicon(String año_publicaicon) {
        this.año_publicaicon = año_publicaicon;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    //toString

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", año_publicaicon='" + año_publicaicon + '\'' +
                ", precio=" + precio +
                ", id_autor=" + id_autor +
                '}';
    }
}