
package com.emergentes.modelo;


public class libro {
    private int id;
    private String titulo;
    private String autor;
    private String disponible;
    private String categoria;

    public libro() {
        this.titulo = "";
        this.disponible = "";
        this.categoria = "";
        this.autor = "";
    }

    public libro(int id, String titulo,String autor, String disponible, String categoria) {
        this.id = id;
        this.titulo = titulo;
        this.disponible = disponible;
        this.categoria = categoria;
        this.autor = autor;
    }

     
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

    public String getDisponible() {
        return disponible;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
   
}
