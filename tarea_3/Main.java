
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static boolean termino = false;
    public static void main(String args[]){
        System.out.println("Bienvenido a The Legend of Morio");
        Scanner scanner = new Scanner(System.in);
        boolean DM = true;
        int tamano = 0;
        List<Tierra> mundo = new ArrayList<Tierra>();
        //turno DM
        while(DM){
            System.out.println("DM! Ingrese el tamaño del mundo: ");
            tamano = scanner.nextInt();
            Tierra mundo_en_casilla;
            
            for(int i = 0; i<tamano; i++){
                
                System.out.printf("Ahora debe ingresar todo lo que debe haber en la casilla %d", i+1);
                System.out.printf("\nIngrese el tipo de tiera que quiere en la casilla numero %d", i+1);
                System.out.println("\n\t1. Montaña\n\t2. Planicie\n\t3. Bosque");
                int tipo_tierra = scanner.nextInt();
                if(tipo_tierra == 1){
                    mundo_en_casilla = new Montana();
                }
                else if(tipo_tierra == 2){
                    mundo_en_casilla = new Planicie();
                }
                else{
                    mundo_en_casilla = new Bosque();
                }
                
                System.out.println("Ingrese la probabilidad de que un enemigo aparezca: ");
                float probabilidad_enemigo = scanner.nextFloat();
                mundo_en_casilla.setProbabilidadEnemigo(probabilidad_enemigo);

                System.out.println("Ingrese el enemigo que podría aparecer:");
                System.out.println("\t1. Monstruo\n\t2. Jefe Final");
                int tipo_enemigo = scanner.nextInt();
                scanner.nextLine();
                if(tipo_enemigo == 1){
                    System.out.println("Ingrese la cantidad de vida del monstruo");
                    int vida_monstruo = scanner.nextInt();
                    System.out.println("Ingrese la cantidad de daño que realizará el monstruo:");
                    int dano_monstruo = scanner.nextInt();

                    Monstruo enemigo = new Monstruo(vida_monstruo, dano_monstruo);
                    mundo_en_casilla.setMonstruo(enemigo);
                    mundo_en_casilla.setJefeFinal(null);
                    
                }
                else if(tipo_enemigo == 2){
                    System.out.println("Ingrese el nombre del Jefe Final:");
                    String nombre_jefe_final = scanner.nextLine();
                    System.out.println("Ingrese la cantidad de vida del Jefe Final");
                    int vida_jefe_final = scanner.nextInt();
                    System.out.println("Ingrese el daño base que realizará el Jefe Final");
                    int dano_base_jefe_final = scanner.nextInt();

                    JefeFinal enemigo = new JefeFinal(nombre_jefe_final, vida_jefe_final, dano_base_jefe_final);
                    mundo_en_casilla.setJefeFinal(enemigo);
                    mundo_en_casilla.setMonstruo(null);
                }

                System.out.println("¿Habrá un NPC en esta casilla?");
                System.out.println("\t1. Sí\n\t2. No");
                int habra_npc = scanner.nextInt();
                scanner.nextLine();
                NPC npc;
                if(habra_npc == 1){
                    String atributo_npc;
                    System.out.println("¿Qué tipo de NPC sera?");
                    System.out.println("\t1. Bueno\n\t2. Malo\n\t3. Neutro");
                    int tipo_npc = scanner.nextInt();
                    scanner.nextLine();
                    if(tipo_npc == 1){
                        System.out.println("Ingrese el nombre del NPC");
                        String nombre_npc = scanner.nextLine();
                        System.out.println("Ingrese el atributo del jugador que mejorará el NPC");
                        System.out.println("\t1. Vida\n\t2. Mana\n\t3. Energia\n\t4. XP");
                        int atributo = scanner.nextInt();
                        scanner.nextLine();
                        if(atributo == 1){
                            atributo_npc = "vida";
                        }
                        else if(atributo == 2){
                            atributo_npc = "mana";
                        }
                        else if(atributo == 3){
                            atributo_npc = "energia";
                        }
                        else{
                            atributo_npc = "xp";
                        }
                        System.out.printf("Ingrese la cantidad en que se mejorara el atributo elegido: \n");
                        int cantidad_atributo = scanner.nextInt();

                        npc = new NPC_Bueno(nombre_npc, atributo_npc, cantidad_atributo);
                        mundo_en_casilla.setNPC(npc);
                    }
                    else if(tipo_npc == 2){
                        System.out.println("Ingrese el nombre del NPC");
                        String nombre_npc = scanner.nextLine();
                        System.out.println("Ingrese la cantidad de energía que el NPC le bajará al jugador:");
                        int cantidad_energia = scanner.nextInt();
                        System.out.println("Ingrese la cantidad de maná que el NPC le bajará al jugador:");
                        int cantidad_mana = scanner.nextInt();

                        npc = new NPC_Malo(nombre_npc, cantidad_energia, cantidad_mana);
                        mundo_en_casilla.setNPC(npc);
                    }
                    else{
                        System.out.println("Ingrese el nombre del NPC");
                        String nombre_npc = scanner.nextLine();
                        System.out.println("Ingrese el requisito de la misión que ofrecerá el NPC al jugador (debe ingresar 'v' o 'm'): ");
                        char requisito_mision = scanner.next().charAt(0);
                        if(requisito_mision == 'v'){
                            System.out.println("Ingrese la casilla a la que debe llegar el jugador para cumplir la misión:");
                            int casilla = scanner.nextInt();
                            System.out.println("Ingrese la cantidad de XP que recibirá el jugador por completar la misión:");
                            int cantidad_xp = scanner.nextInt();
                            Mision mision = new Mision(requisito_mision, casilla, 0, cantidad_xp);
                            boolean ya_dio_mision = false;
                            npc = new NPC_Neutro(nombre_npc, mision, ya_dio_mision);
                            mundo_en_casilla.setNPC(npc);
                        }
                        else{
                            System.out.println("Ingrese la cantidad de monstruos que deberá matar el jugador para cumplir la misión:");
                            int cantidad_monstruos = scanner.nextInt();
                            System.out.println("Ingrese la cantidad de XP que recibirá el jugador por completar la mision:");
                            int cantidad_xp = scanner.nextInt();
                            Mision mision = new Mision(requisito_mision, cantidad_monstruos, 0, cantidad_xp);   
                            boolean ya_dio_mision = false;
                            npc = new NPC_Neutro(nombre_npc, mision, ya_dio_mision);
                            mundo_en_casilla.setNPC(npc);
                        }    
                    }
                }
                else{
                    mundo_en_casilla.setNPC(null);
                }
                mundo.add(mundo_en_casilla);
                mundo.set(i, mundo_en_casilla);
            }
            DM = false;
        }
        System.out.println("Finalmente, ingresa el numero de casilla en la que quieres que parta el jugador: (enumeradas desde el 1 hasta el tamaño que escogio anteriromente)");
        int posicion = scanner.nextInt() - 1;
        scanner.nextLine();
        System.out.println("Ahora es el turno del jugador :D");
        
        //comienza a jugar el jugador 
        boolean juego_termino = false;
        boolean jugador_murio = false;
        Jugador jugador;
        System.out.println("Bienvenido Jugador!! Es hora de crear tu personaje");
        System.out.println("Primero, ingresa el nombre de tu personaje: ");
        String nombre_jugador = scanner.nextLine();

        System.out.println("Ahora, ingresa la clase que quieres ser: ");
        System.out.println("\t1. Mago\n\t2. Guerrero\n\t3. Druida");

        int clase_jugador = scanner.nextInt();
        if(clase_jugador == 1){
            jugador = new Mago(nombre_jugador);
        }
        else if(clase_jugador == 2){
            jugador = new Guerrero(nombre_jugador);
        }
        else{
            jugador = new Druida(nombre_jugador);
        }
        int eleccion_menu;
        int movimiento;
        while(!juego_termino){

            System.out.printf("%s: Bienvenido, ahora comienza tu aventura! Estás en la casilla %d del mundo", jugador.getNombre(), posicion + 1);
            while(!jugador_murio){
                System.out.println("\n--------------MENU--------------");
                System.out.println("¿Que deseas hacer?");
                System.out.println("\t1. Ver stats\n\t2. Mover al jugador");
                eleccion_menu = scanner.nextInt();
                scanner.nextLine();
                if(eleccion_menu == 1){
                    System.out.println("--------Stats actuales--------");
                    System.out.printf("\tVida:\t\t%d/%d\n", jugador.getVida(), jugador.getVidaMaxima());
                    System.out.printf("\tEnergia:\t%d/%d\n", jugador.getEnergia(), jugador.getEnergiaMaxima());
                    System.out.printf("\tMana:\t\t%d/%d\n", jugador.getMana(), jugador.getManaMaximo());
                }
                else{
                    System.out.println("¿Desea mover al jugador a la derecha o a la izquierda?");
                    System.out.println("\t1. A la derecha\n\t2. A la izquierda");
                    movimiento = scanner.nextInt();
                    scanner.nextLine();
                    if(movimiento == 1){
                        posicion = posicion + 1;
                    }
                    else{
                        posicion = posicion - 1;
                    }
                    if(posicion < 0){
                        posicion = posicion + tamano;
                    }
                    else if(posicion > tamano){
                        posicion = posicion % tamano;
                        System.out.println(posicion);
                    }
                    System.out.println("Ahora estás en la casilla "+ posicion);
                    boolean logrado = mundo.get(posicion).accion(jugador);
                    if(!logrado){
                        jugador_murio = true;
                        System.out.println("Pucha la lesera, te moriste D: Lamentablemente tendrás que empezar todo de nuevo");
                    }
                    else{
                        if(mundo.get(posicion).getJefeFinal() == null){
                            mundo.get(posicion).setJefeFinal(null);
                        }
                        else{
                            mundo.get(posicion).setMonstruo(null);
                        }
                    }
                }
            }
            juego_termino = true;
            
        }
        scanner.close();
    }
}
