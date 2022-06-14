public class Montana extends Tierra {
    /* 
    Nombre método:
        accion

    Parámetros que recibe:
        un jugador de clase Jugador

    Descripción:
        primero verifica si es que el jugador puede llegar a la montaña, y si 
        es que puede le resta la energía correspondiente.
        Luego, si es que hay un NPC realiza la interacción que corresponde, y fi-
        nalmente si es que hay un enemigo, realizan el combate.

    Retorno:
        si es que logra llegar y sobrevive, retorna el booleano true y en caso
        contrario retorna false.
    */
    public boolean accion(Jugador jugador){
        System.out.println("Estás en la Montaña");
        boolean llego = false;
        boolean sobrevivio = true;
        if(jugador.getEnergia() == 0){
            System.out.println("No puedes llegar a la montaña! :c");
        }
        else{
            llego = true;
            jugador.setEnergia(jugador.getEnergia() - 3);
            if(this.getNPC() != null){
                this.getNPC().interaccion(jugador);
            }

            if(this.getProbabilidadEnemigo() > 0.5){
                sobrevivio = false;
                if(this.getMonstruo() != null){
                    this.getMonstruo().combate(jugador);
                }
                else{
                    this.getJefeFinal().combate(jugador);
                }
                if(jugador.getVida() > 0){
                    sobrevivio = true;
                }
            }
        }
        if(llego && sobrevivio){
            return true;
        }
        else{
            return false;
        }

    }

    /* 
    Los siguientes corresponden a los constructores de la montaña. Hay uno por si
    el enemigo es un monstruo y otro por si es un jefe final.

    Ambos reciben un float que corresponde a la probabilidad de que aparezca un 
    enemigo, un objeto NPC que corresponde al NPC de esa tierra, y en el primer
    constructor recibe un objeto Monstruo que corresponde al monstruo que puede
    aparecer con la probabilidad anterior. El segundo constructor recibe al final
    un objeto JefeFinal que corresponde al jefe final que puede aparecer en esa
    tierra.
    */
    public Montana(float ProbabilidadEnemigo, NPC npc, Monstruo monstruo){
        this.setProbabilidadEnemigo(ProbabilidadEnemigo);
        this.setMonstruo(monstruo);
        this.setNPC(npc);
    }

    public Montana(float ProbabilidadEnemigo, NPC npc, JefeFinal JefeFinal){
        this.setProbabilidadEnemigo(ProbabilidadEnemigo);
        this.setJefeFinal(JefeFinal);
        this.setNPC(npc);
    }

    public Montana(){}
}
