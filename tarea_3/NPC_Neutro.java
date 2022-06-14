import java.util.Scanner;

public class NPC_Neutro extends NPC {
    private char requisito;
    private int valor;
    private int recompensa;
    private boolean ya_dio_mision;
    private Mision mision;

    /* 
    Estos son los getters y setters de los atributos del NPC
    neutro
    */
    public void setRequisito(char Requisito){
        this.requisito = Requisito;
    }

    public char getRequisito(){
        return this.requisito;
    }

    public void setValor(int Valor){
        this.valor = Valor;
    }

    public int getValor(){
        return this.valor;
    }

    public void setRecompensa(int Recompensa){
        this.recompensa = Recompensa;
    }

    public int getRecompensa(){
        return this.recompensa;
    }

    public void setYaDioMision(boolean YaDioMision){
        this.ya_dio_mision = YaDioMision;
    }

    public boolean getYaDioMision(){
        return this.ya_dio_mision;
    }

    public void setMision(Mision Mision){
        this.mision = Mision; 
    }

    public Mision getMision(){
        return this.mision;
    }

    /* 
    Nombre método:
        interaccion

    Parámetros que recibe:
        Jugador jugador

    Descripción:
        ofrece una mision al jugador. si el jugador la acepta se
        agrega a su lista de misiones.
    Retorno:
        ninguno.
    */
    public void interaccion(Jugador jugador){
        System.out.println("Hay un NPC neutro en esta casilla! Su nombre es " + this.getNombre());
        if (!this.ya_dio_mision){
            Scanner scanner = new Scanner(System.in);
            if(this.requisito == 'v'){
                System.out.printf("%s: Hola, ¿quieres cumplir esta misión? Deberás llegar a %d del mundo y recibirás %d de xp.\n", jugador.getNombre(), this.getValor(), this.getRecompensa());
                System.out.println("¿Aceptas o rechazas la mision? (Ingrese 'A' para aceptar o 'R' para rechazar)");
                System.out.println("\t1. Acepto\n\t2. Rechazo");
                int decision = scanner.nextInt();
                if (decision == 1){
                    jugador.anadirMisiones(this.mision);
                }
                else{
                    this.ya_dio_mision = true;
                }
            }
            else{
                System.out.printf("%s: Hola, ¿quieres cumplir esta misión? Deberás matar %d de Monstruos y recibiras %d de xp.\n", jugador.getNombre(), this.getValor(), this.getRecompensa());
                System.out.println("¿Aceptas o rechazas la mision? (Ingrese 'A' para aceptar o 'R' para rechazar)");
                System.out.println("\t1. Acepto\n\t2. Rechazo");
                int decision = scanner.nextInt();
                scanner.close();
                if (decision == 1){
                    jugador.anadirMisiones(this.mision);
                }
                else{
                    this.ya_dio_mision = true;
                }
            }

        }

        else{
            System.out.println(jugador.getNombre() + ": ya te di misión, saludos");
        }
    }

    /* 
    Este es el constructor del NPC neutro. Recibe el nombre
    del NPC, la mision que ofrecera al jugador y si ya dio la mision
    el jugador o no.     
    */
    public NPC_Neutro(String nombre, Mision mision, boolean YaDioMision){
        this.setNombre(nombre);
        this.setRecompensa(mision.getRecompensa());
        this.setRequisito(mision.getRequisito());
        this.setValor(mision.getValor());
        this.setYaDioMision(YaDioMision);
        this.setMision(mision);
    }

    
}
