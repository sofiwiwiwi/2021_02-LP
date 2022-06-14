import java.util.Scanner;

public class JefeFinal implements Enemigo{
    private String nombre;
    private int vida;
    private int dano_base;

    /* 
    Estos son los getters y setters de los atributos del jefe
    final
    */
    public void setNombre(String Nombre){
        this.nombre = Nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setVida(int Vida){
        this.vida = Vida;
    }

    public int getVida(){
        return this.vida;
    }

    public void setDanoBase(int DanoBase){
        this.dano_base = DanoBase;
    }

    public int getDanoBase(){
        return this.dano_base;
    }

    /* 
    Nombre método:
        combate

    Parámetros que recibe:
        Jugador jugador

    Descripción:
        el jugador y el jefe final se van turnando para hacerse daño hasta que
        alguno de los dos muera.
    Retorno:
        ninguno.
    */
    public void combate(Jugador jugador){
        System.out.println("Oh no! Hay un jefe final en esta casilla, prepárate para el combate con " + this.getNombre());
        int vida_inicial_jefe = this.getVida();
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
            
            int fase;
            if(this.getVida() <= (vida_inicial_jefe/2)){
                fase = 1;
            }
            else{
                fase = 2;
            } 
            //turno monstruo
            int dano_jefe = this.getDanoBase() + 2 * fase;
            System.out.printf("Es el turno de %s! Oh no! Te hizo %d de daño!\n", this.getNombre(), dano_jefe);
            jugador.setVida(jugador.getVida() - dano_jefe);

        }
        if(jugador.getVida() > 0){
            System.out.println("Sobreviviste el combate, qué crack :D");
        }
        scanner.close();
    }

    /* 
    Este es el constructor del Jefe Final. Recibe el nombre
    del jefe, la vida que tendrá y el daño base que realizará     
    */
    public JefeFinal(String Nombre, int Vida, int DanoBase){
        this.setNombre(Nombre);
        this.setVida(Vida);
        this.setDanoBase(DanoBase);
    }

    
}
