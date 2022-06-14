import java.util.ArrayList;
import java.util.List;

abstract class Jugador{
    private String nombre;
    private int vida;
    private int xp;
    private int fuerza;
    private int inteligencia;
    private int energia;
    private int mana;
    private int nivel;
    private int vida_maxima;
    private int energia_maxima;
    private int mana_maximo;
    public List <Mision> lista_misiones;


    /* 
    Estos son los getters y setters de los atributos del jugador
    */
    public void setNombre(String Nombre){
        this.nombre = Nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setVida(int Vida){
        if(Vida > this.getVidaMaxima()){
            this.vida = this.getVidaMaxima();
        }
        else if (Vida < 0){
            this.vida = 0;
        }
        else{
            this.vida = Vida;
        }
    }

    public int getVida(){
        return this.vida;
    }

    public void setXP(int XP){
        this.xp = XP;
    }

    public int getXP(){
        return this.xp;
    }

    public void setFuerza(int Fuerza){
        this.fuerza = Fuerza;
    }

    public int getFuerza(){
        return this.fuerza;
    }


    public void setInteligencia(int Inteligencia){
        this.inteligencia = Inteligencia;
    }

    public int getInteligencia(){
        return this.inteligencia;
    }

    public void setEnergia(int Energia){
        if(Energia > this.getEnergiaMaxima()){
            this.energia = this.getEnergiaMaxima();
        }
        else if (Energia < 0){
            this.energia = 0;
        }
        else{
            this.energia = Energia;
        }
    }

    public int getEnergia(){
        return this.energia;
    }

    public void setMana(int Mana){
        if(Mana > this.getManaMaximo()){
            this.mana = this.getManaMaximo();
        }
        else if (Mana < 0){
            this.mana = 0;
        }
        else{
            this.mana = Mana;
        }
    }

    public int getMana(){
        return this.mana;
    }

    public void setNivel(int XP){
        if(XP < 10){
            this.nivel = 1;
        }
        else if(XP < 25){
            this.nivel = 2;
        }
        else if(XP < 50){
            this.nivel = 3;
        }
        else if(XP < 100){
            this.nivel = 4;
        }
        else if(XP < 200){
            this.nivel = 5;
        }
        else if(XP < 350){
            this.nivel = 6;
        }
        else if(XP < 600){
            this.nivel = 7;
        }
        else {
            this.nivel = 8;
        }
    }

    public int getNivel(){
        return this.nivel;
    }

    public void setVidaMaxima(int VidaMaxima){
        this.vida_maxima = VidaMaxima;
    }

    public int getVidaMaxima(){
        return this.vida_maxima;
    }

    public void setEnergiaMaxima(int EnergiaMaxima){
        this.energia_maxima = EnergiaMaxima;
    }

    public int getEnergiaMaxima(){
        return this.energia_maxima;
    }

    public void setManaMaximo(int ManaMaximo){
        this.mana_maximo = ManaMaximo;
    }

    public int getManaMaximo(){
        return this.mana_maximo;
    }

    public void setMisiones(){
        this.lista_misiones = new ArrayList<Mision>();
    }

    public void anadirMisiones(Mision mision){
        this.lista_misiones.add(mision);
    }

    public abstract int ataque();

    public abstract int hechizo();

    public abstract void subir_experiencia(int cantidad_a_sumar);

}