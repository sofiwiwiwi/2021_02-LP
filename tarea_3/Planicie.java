public class Planicie extends Tierra {
    /* 
    Nombre método:
        accion

    Parámetros que recibe:
        un jugador de clase Jugador

    Descripción:
        si es que hay un NPC realiza la interacción que corresponde, y fi-
        nalmente si es que hay un enemigo, realizan el combate.

    Retorno:
        si es que logra llegar y sobrevive, retorna el booleano true y en caso
        contrario retorna false.
    */
    public boolean accion(Jugador jugador){
        System.out.println("Estás en la Planicie");
        boolean sobrevivio = true;

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

        if(sobrevivio){
            return true;
        }
        else{
            return false;
        }

    }
    
    /* 
    Los siguientes corresponden a los constructores de la planicie. Hay uno por si
    el enemigo es un monstruo y otro por si es un jefe final.

    Ambos reciben un float que corresponde a la probabilidad de que aparezca un 
    enemigo, un objeto NPC que corresponde al NPC de esa tierra, y en el primer
    constructor recibe un objeto Monstruo que corresponde al monstruo que puede
    aparecer con la probabilidad anterior. El segundo constructor recibe al final
    un objeto JefeFinal que corresponde al jefe final que puede aparecer en esa
    tierra.
    */
    public Planicie(float ProbabilidadEnemigo, NPC npc, Monstruo monstruo){
        this.setProbabilidadEnemigo(ProbabilidadEnemigo);
        this.setMonstruo(monstruo);
        this.setNPC(npc);
    }

    public Planicie(float ProbabilidadEnemigo, NPC npc, JefeFinal JefeFinal){
        this.setProbabilidadEnemigo(ProbabilidadEnemigo);
        this.setJefeFinal(JefeFinal);
        this.setNPC(npc);
    }

    public Planicie(){}
    
}
