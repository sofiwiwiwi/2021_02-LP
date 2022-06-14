public class Mago extends Jugador{
    /* 
    Nombre método:
        ataque

    Parámetros que recibe:
        niguno

    Descripción:
        primero verifica si es que el guerrero tiene suficiente energia para atacar,
        si es que no tiene no hace daño. Luego, calcula el daño correspondiente
        a la clase Guerrero.
    Retorno:
        retorna el int daño que hace.
    */
    public int ataque(){
        int dano;
        if(this.getEnergia() == 0){
            dano = 0;
        }
        else{
            dano = this.getFuerza() * (this.getInteligencia()/4) + this.getEnergia();
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
        primero verifica si es que el mago tiene suficiente maná para el hechizo,
        si es que no tiene no hace daño mágico. Luego, calcula el daño mágico
        correspondiente a la clase Mago.
    Retorno:
        retorna el int daño mágico que hace.
    */
    public int hechizo(){
        int dano_magico;
        if(this.getMana() == 0){
            dano_magico = 0;
        }
        else{
            dano_magico = this.getFuerza() * (this.getInteligencia()/4) + this.getMana();
        }
        this.setMana(this.getMana() - 5);
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
            this.setVidaMaxima(this.getVidaMaxima() + 2*this.getNivel());
            this.setFuerza(this.getFuerza() + 1);
            this.setEnergiaMaxima(this.getEnergiaMaxima() + 1);
            this.setManaMaximo(this.getManaMaximo() + 3*this.getNivel());
        }

    
    }

    /* 
    Este es el constructor del jugador de clase Mago. Recibe el nombre
    del jugador e inicializa todos sus atributos con los correspondientes
    de su clase
    */
    public Mago(String Nombre){
        this.setNombre(Nombre);
        this.setVidaMaxima(10);
        this.setVida(10);
        this.setXP(0);
        this.setInteligencia(10);
        this.setEnergiaMaxima(6);
        this.setEnergia(6);
        this.setManaMaximo(15); 
        this.setMana(15);
        this.setNivel(this.getXP());
    }
}
