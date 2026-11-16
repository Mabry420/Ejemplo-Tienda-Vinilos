package com.tiendavinilos.model;

/**
 * Representa un vinilo en la tienda.
 * Contiene la información básica de un disco: título, artista, precio y año.
 */
public class Vinilo {

    private int id;
    private String titulo;
    private String artista;
    private double precio;
    private int anio;
    private String genero;

    public Vinilo() {
    }

    public Vinilo(int id, String titulo, String artista, double precio, int anio, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
        this.precio = precio;
        this.anio = anio;
        this.genero = genero;
    }

    // --- Getters y Setters ---

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

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return titulo + " - " + artista;
    }
}
