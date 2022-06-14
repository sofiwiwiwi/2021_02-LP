public class Druida extends Jugador{
    /* 
    Nombre método:
        ataque

    Parámetros que recibe:
        niguno

    Descripción:
        primero verifica si es que el druida tiene suficiente energia para atacar,
        si es que no tiene no hace daño. Luego, calcula el daño correspondiente
        a la clase Druida.
    Retorno:
        retorna el int daño que hace.
    */
    public int ataque(){
        int dano;
        if(this.getEnergia() == 0){
            dano = 0;
        }
        else{
            if(this.getEnergia()/2 > this.getMana()/3){
                dano = (this.getFuerza()+this.getInteligencia())/3 * (this.getEnergia()/2);
            }
            else{
                dano = (this.getFuerza()+this.getInteligencia())/3 * (this.getMana()/3);
            }
            this.setEnergia(this.getEnergia() - 3);
        }
        return dano;
    }

    /* 
    Nombre método:
        hechizo

    Parámetros que recibe:
        niguno

    Descripción:
        primero verifica si es que el druida tiene suficiente maná para el hechizo,
        si es que no tiene no hace daño mágico. Luego, calcula el daño mágico
        correspondiente a la clase Druida.
    Retorno:
        retorna el int daño mágico que hace.
    */
    public int hechizo(){
        int dano_magico;
        if(this.getMana() == 0){
            dano_magico = 0;
        }
        else{
            if(this.getEnergia()/3 > this.getMana()/2){
                dano_magico = (this.getFuerza()+this.getInteligencia())/3 * (this.getEnergia()/3);
            }
            else{
                dano_magico = (this.getFuerza()+this.getInteligencia())/3 * (this.getMana()/2);
            }
            this.setMana(this.getMana() - 3);
        }
        return dano_magico;
    }

    /* 
    Nombre método:
        subir_experiencia

    Parámetros que recibe:
        int cantidad_a_sumar

    Descripción:
        dependiendo de cuánta experiencia se le sume al jugador, verifica si sube
        de nivel y mejora los atributos correspondientes.
    Retorno:
        ninguno
    */
    public void subir_experiencia(int cantidad_a_sumar){
        int xp_actual = this.getXP();
        int nuevo_xp = xp_actual += cantidad_a_sumar;
        int nivel_actual = this.getNivel();
        this.setNivel(nuevo_xp);
        int nuevo_nivel = this.getNivel();

        if(nuevo_nivel > nivel_actual){
            this.setVidaMaxima(this.getVidaMaxima() + this.getNivel());
            this.setFuerza(this.getFuerza() + this.getNivel());
            this.setInteligencia(this.getInteligencia() + this.getNivel());
            this.setEnergiaMaxima(this.getEnergiaMaxima() + this.getNivel());
            this.setManaMaximo(this.getManaMaximo()+ this.getNivel());
        }
    }

    /* 
    Este es el constructor del jugador de clase Druida. Recibe el nombre
    del jugador e inicializa todos sus atributos con los correspondientes
    de su clase
    */
    public Druida(String Nombre){
        this.setNombre(Nombre);
        this.setVidaMaxima(15);
        this.setVida(15);
        this.setFuerza(5);
        this.setEnergiaMaxima(5);
        this.setEnergia(5);
        this.setManaMaximo(5);
        this.setMana(5);
        this.setXP(0);
        this.setNivel(this.getXP());
    }
}
