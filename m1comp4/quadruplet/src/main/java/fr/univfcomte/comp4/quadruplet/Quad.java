package fr.univfcomte.comp4.quadruplet;

public class Quad{
    private String id;
    private Valeur val; 
    private Objet obj;
    private Sorte type;
  
    public Quad(String id, Valeur val, Objet obj, Sorte type){
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

    public void setObj(Objet obj) {
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

    public Objet getObj() {
        return obj;
    }

    public Sorte getType() {
        return type;
    }
    
    public boolean equals(Object q)
    {
    	if(q instanceof Quad && q!= null)
    	{
    		Quad q1 = (Quad) q;
    		return (this.id.equals(q1.id) && this.val.equals(q1.val) && this.obj.equals(q1.obj) && this.type.equals(q1.type));
    	}else
    	{
    		return false;
    	}
    }
}
