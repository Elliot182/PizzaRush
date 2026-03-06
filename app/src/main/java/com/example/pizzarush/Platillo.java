package com.example.pizzarush;

public class Platillo {

    private String emoji;
    private String nombre;
    private String descripcion;
    private String precio;

    public Platillo(String emoji, String nombre, String descripcion, String precio) {
        this.emoji       = emoji;
        this.nombre      = nombre;
        this.descripcion = descripcion;
        this.precio      = precio;
    }

    public String getEmoji()       { return emoji; }
    public String getNombre()      { return nombre; }
    public String getDescripcion() { return descripcion; }
    public String getPrecio()      { return precio; }
}
