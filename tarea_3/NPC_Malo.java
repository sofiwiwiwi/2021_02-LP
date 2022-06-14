import java.util.Random;

public class NPC_Malo extends NPC {
    private int cantidad_energia;
    private int cantidad_mana;

    /* 
    Estos son los getters y setters de los atributos del NPC
    bueno
    */
    public void setCantidadEnergia(int CantidadEnergia){
        this.cantidad_energia = CantidadEnergia;
    }

    public int getCantidadEnergia(){
        return this.cantidad_energia;
    }

    public void setCantidadMana(int CantidadMana){
        this.cantidad_mana = CantidadMana;
    }

    public int getCantidadMana(){
        return this.cantidad_mana;
    }

    /* 
    Nombre método:
        interaccion

    Parámetros que recibe:
        Jugador jugador

    Descripción:
        genera un numero entre 1 y 10 al azar y si es menor a 6 le 
        disminuye la energia al jugador y si es mayor a 6 le disminuye
        el mana al jugador
    Retorno:
        ninguno.
    */
    public void interaccion(Jugador jugador){
        System.out.println("Oh no! Hay un NPC malo en esta casilla! Su nombre es " + this.getNombre());
        System.out.printf("%s: SOY MALO TE VOY A DISMINUIR TU ENERGÍA Y TU MANÁ EN %d y %d", jugador.getNombre(), this.getCantidadEnergia(), this.getCantidadMana());
        Random random = new Random();
        int azar_1 = random.nextInt(9) + 1;
        int azar_2 = random.nextInt(9) + 1;

        if(azar_1 <= 6){
            jugador.setEnergia(jugador.getEnergia() - this.getCantidadEnergia());
        }
        if(azar_2 <= 6){
            jugador.setMana(jugador.getMana() - this.getCantidadMana());
        }
    }

    /* 
    Este es el constructor del NPC neutro. Recibe el nombre
    del NPC, la mision que ofrecera al jugador y si ya dio la mision
    el jugador o no.     
    */
    public NPC_Malo(String nombre, int CantidadEnergia, int CantidadMana){
        this.setCantidadEnergia(CantidadEnergia);
        this.setCantidadMana(CantidadMana);
        this.setNombre(nombre);
    }
    
}
