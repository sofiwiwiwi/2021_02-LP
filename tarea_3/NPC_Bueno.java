public class NPC_Bueno extends NPC {
    private String atributo;
    private int cantidad;

    /* 
    Estos son los getters y setters de los atributos del NPC
    neutro
    */
    public void setAtributo(String Atributo){
        this.atributo = Atributo;        
    }

    public String getAtributo(){
        return this.atributo;
    }

    public void setCantidad(int Cantidad){
        this.cantidad = Cantidad;
    }

    public int getCantidad(){
        return this.cantidad;
    }

    /* 
    Nombre método:
        interaccion

    Parámetros que recibe:
        Jugador jugador

    Descripción:
        le sube un atributo en especifico al jugador
    Retorno:
        ninguno.
    */
    public void interaccion(Jugador jugador){
        System.out.println("Hay un NPC bueno en esta casilla! Su nombre es " + this.getNombre());
        System.out.printf("%s: Creo que necesitas un poco de ayuda, te subiré %d a tu %s\n", jugador.getNombre(), this.getCantidad(), this.getAtributo());

        if(this.getAtributo() == "vida"){
            jugador.setVida(jugador.getVida() + this.getCantidad());
        }
        else if(this.getAtributo() == "xp"){
            jugador.setXP(jugador.getXP() + this.getCantidad());
        }
        else if(this.getAtributo() == "energia"){
            jugador.setEnergia(jugador.getEnergia() + this.getCantidad());
        }
        else if(this.getAtributo() == "mana"){
            jugador.setMana(jugador.getMana() + this.getCantidad());
        }
    }

    /* 
    Este es el constructor del NPC bueno. Recibe el nombre
    del NPC, el atributo que le mejorará al jugador y la 
    cantidad en la que se mejorará dicho atributo.     
    */
    public NPC_Bueno(String nombre, String atributo, int cantidad){
        this.setAtributo(atributo);
        this.setNombre(nombre);
        this.setCantidad(cantidad);
    }
    
}
