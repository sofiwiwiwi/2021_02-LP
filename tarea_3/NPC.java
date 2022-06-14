abstract class NPC {
    private String nombre;

    /* 
    Estos son los getters y setters de los atributos del NPC
    */
    public void setNombre(String Nombre){
        this.nombre = Nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    /* 
    Es un método abstracto que está implementado en NPC_Bueno.java,
    NPC_Malo.java y NPC_Neutro.java

    recibe un objeto Jugador y no retrona nada
    */
    public abstract void interaccion(Jugador jugador);
}
