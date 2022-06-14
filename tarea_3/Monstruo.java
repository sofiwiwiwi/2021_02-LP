import java.util.Scanner;

public class Monstruo implements Enemigo{
    private int vida;
    private int dano;

    /* 
    Estos son los getters y setters de los atributos del monstruo
    */
    public void setVida(int Vida){
        this.vida = Vida;
    }

    public int getVida(){
        return this.vida;
    }

    public void setDano(int Dano){
        this.dano = Dano;
    }

    public int getDano(){
        return this.dano;
    }

    /* 
    Nombre método:
        combate

    Parámetros que recibe:
        Jugador jugador

    Descripción:
        el jugador y el monstruo se van turnando para hacerse daño hasta que
        alguno de los dos muera.
    Retorno:
        ninguno.
    */
    public void combate(Jugador jugador){
        System.out.println("Oh no! Hay un monstruo en esta casilla, prepárate para el combate!!!");
        int dano_monstruo = this.getDano();
        Scanner scanner = new Scanner(System.in);

        while((jugador.getVida() > 0) && (this.getVida()) > 0){
            //turno jugador
            System.out.println("Es tu turno! Escoge que tipo de ataque quieres hacer!");
            System.out.println("\t1. Ataque\n\t2. Hechizo\n");
            int ataque = scanner.nextInt();
            if(ataque == 1){
                this.setVida(this.getVida() - jugador.ataque());
            }
            else{
                this.setVida(this.getVida() - jugador.hechizo());
            }
            if(this.getVida() > 0){
                System.out.printf("Ahora el monstruo tiene %d de vida!!", this.getVida());

            }

            //turno monstruo
            jugador.setVida(jugador.getVida() - dano_monstruo);
            if(jugador.getVida()> 0){
                System.out.printf("Es el turno del monstruo! Oh no! Te hizo %d de daño! Ahora te queda %d de vida\n", dano_monstruo, jugador.getVida());
            }
            
        }
        if(jugador.getVida() > 0){
            System.out.println("Sobreviviste el combate, qué crack :D");
        }
               
    }

    /* 
    Este es el constructor del Monstruo. Recibe la vida que tendrá y 
    el daño que realizará     
    */
    public Monstruo(int Vida, int Dano){
        this.setVida(Vida);
        this.setDano(Dano);
    }

}
