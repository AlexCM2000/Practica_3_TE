
package com.emergentes.modelo;


public class categoria {
    private int id;
    private String categoria;

    public categoria() {
        this.categoria="";
    }

    public categoria(int id,String categoria) {
        this.id = id;
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
