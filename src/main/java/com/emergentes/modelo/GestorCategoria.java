
package com.emergentes.modelo;

import java.util.ArrayList;
import java.util.Iterator;


public class GestorCategoria {
    private ArrayList<categoria> lista;

    public GestorCategoria() {
        lista = new ArrayList<categoria>();
    }

    public ArrayList<categoria> getLista() {
        return lista;
    }

    public void setLista(ArrayList<categoria> lista) {
        this.lista = lista;
    }
    
    public void insertarTarea(categoria item){
        lista.add(item);
    }
    
    public void modificarTarea(int pos, categoria item){
        lista.set(pos, item);
    }
    
    public void eliminarTarea(int pos){
        lista.remove(pos);
    }
    
    public int obtieneId(){
        int idaux = 0;
        for (categoria item : lista) {
            idaux = item.getId();
        }
        return idaux + 1;
    }
    
    public int ubicarTarea(int id){
        int pos = -1;
        Iterator<categoria> it = lista.iterator();
        
        while (it.hasNext()) {
            ++pos;
            categoria aux = it.next();
            
            if (aux.getId()==id) {
                break;
            }
        }
        return pos;
    }
}
