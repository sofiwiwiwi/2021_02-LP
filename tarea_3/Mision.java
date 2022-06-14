public class Mision {
    private char requisito;
    private int valor;
    private int cantidad;
    private int recompensa;

    /* 
    Estos son los getters y setters de los atributos de una mision
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

    public void setCantidad(int Cantidad){
        this.cantidad = Cantidad;
    }

    public int getCantidad(){
        return this.cantidad;
    }

    public void setRecompensa(int Recompensa){
        this.recompensa = Recompensa;
    }

    public int getRecompensa(){
        return this.recompensa;
    }

    /* 
    Nombre método:
        interaccion

    Parámetros que recibe:
        int valor
        int cantidad
        char requisito

    Descripción:
        a partir del requisito, el valor y la cantidad de la mision, chequea
        si se cumplió la misión o no.
    Retorno:
        un booleano que es verdadero si se cumplen todos los requistos y 
        falso en caso contrario.
    */
    public boolean verificar_requisito(int Valor, int Cantidad, char Requisito){
        if(Requisito == 'v'){
            if(Cantidad == Valor){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            if(Cantidad >= Valor){
                return true;
            }
            else
                return false;
        }
    }

    public Mision(char Requisito, int Valor, int Cantidad, int Recompensa){
        this.setRequisito(Requisito);
        this.setValor(Valor);
        this.setCantidad(Cantidad);
        this.setRecompensa(Recompensa);
    }
}

