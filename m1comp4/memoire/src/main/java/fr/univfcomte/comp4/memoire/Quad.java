/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univfcomte.comp4.memoire;

/**
 *
 * @author Pierre
 */
public class Quad {
    private String id;
    private Valeur val; 
    private Object obj;
    private Sorte type;
  
    public Quad(String id, Valeur val, Object obj, Sorte type){
        this.id=id;
        this.val=val;
        this.type=type;
        this.obj=obj;
        
    }

    @Override
    public String toString() {
        return "Quad{" + "id=" + id + ", val=" + val + ", obj=" + obj + ", type=" + type + '}';
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setVal(Valeur val) {
        this.val = val;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public void setType(Sorte type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public Valeur getVal() {
        return val;
    }

    public Object getObj() {
        return obj;
    }

    public Sorte getType() {
        return type;
    }
    
}
