abstract class Tierra {
    private float probabilidad_enemigo;
    private Monstruo monstruo;
    private JefeFinal jefe_final;
    private NPC npc;

    /* 
    Estos son los getters y setters de los atributos de la tierra
    */
    public void setProbabilidadEnemigo(float Probabilidad){
        this.probabilidad_enemigo = Probabilidad;
    }

    public float getProbabilidadEnemigo(){
        return this.probabilidad_enemigo;
    }

    public void setMonstruo(Monstruo Monstruo){
        this.monstruo = Monstruo;
    }

    public Monstruo getMonstruo(){
        return this.monstruo;
    }

    public void setJefeFinal(JefeFinal JefeFinal){
        this.jefe_final = JefeFinal;
    }

    public JefeFinal getJefeFinal(){
        return this.jefe_final;
    }

    public void setNPC(NPC NPC){
        this.npc = NPC;
    }

    public NPC getNPC(){
        return this.npc;
    }

    /* 
    Es un método abstracto que está implementado en Montana.java,
    Bosque.java y Planicie.java

    recibe un objeto Jugador y retorna un booleano
    */
    public abstract boolean accion (Jugador jugador);
}
