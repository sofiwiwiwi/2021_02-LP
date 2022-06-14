#ifndef Animal_h
#define Animal_h

typedef struct Animal{
    void* fuerza;
    char tipo_fuerza;
    void* velocidad;
    char tipo_velocidad;
    void* resistencia;
    char tipo_resistencia;
    void (*reproduccion)(struct Animal*, struct Animal*, struct Animal*);
    void (*comerHuir)(struct Animal*, struct Animal*);
} Animal;

/*
CrearAnimal
    recibe la ubicacion de memoria donde se creara el animal y pide los atributos por consola
*/
void CrearAnimal(Animal* a);

/*
Borrar
    recibe la ubicacion de memoria de un animal y lo elimina, dejando la casilla libre para ser ocupada nuevamente
*/
void Borrar(Animal* a);

/*
MostrarAnimal
    recibe la ubicacion de memoria de un animal y muestra sus atributos por pantalla
*/
void MostrarAnimal(Animal* a);

/*
Reproducir
    reproduce dos animales usando la funcion de alguno de ellos. La funcion a utilizar se determina aleatoriamente. Los parametros que 
    recibe son los animales padres y el animal hijo que se crea a partir de la reproduccion
*/
void Reproducir(Animal* padre1, Animal* padre2, Animal* hijo);

/*
ComerOHuir
    recibe dos animales y realiza aleatoriamente la funcion de alguno de ellos.
*/
void ComerOHuir(Animal* a1, Animal* a2);

/*
Comparar
    recibe dos animales y compara cada uno de sus atributos. En caso de que el animal 1 tenga mayor cantidad de atributos mayores que 
    el animal 2, devuelve el entero 0, y en caso de que no devuelve el entero 1
*/
int Comparar(Animal* a1, Animal* a2);

/*
BorrarMundo
    recibe el mundo y lo borra
*/
void BorrarMundo(Animal** Mundo);

/*
Mostrar Mundo
    recibe el mundo y muestra los atributos de todos los animales dentro de el
*/
void MostrarMundo(Animal** Mundo);

/*
ReproduccionSimple
    recibe dos animales padres y un animal hijo. La funcion compara los padres usando la funcion Comparar. Dependiendo del resultado se crea el 
    animal hijo con todos los atributos del padre 1 o todos los atributos del padre 2
*/
void ReproduccionSimple(Animal* padre1, Animal* padre2, Animal* hijo);

/*
ReproduccionCruzada
    recibe dos animales padres y un animal hijo. La funcion compara los padres usando la funcion Comparar. Dependiendo del resultado se crea el 
    animal hijo con diferentes atributos de cada padre.
*/
void ReproduccionCruzada(Animal* padre1, Animal* padre2, Animal* hijo);

/*
ComerSiempre
    recibe dos animales y comapra la fuerza del primero y la compara con la resistencia del segundo.
    Dependiendo de los resultados un animal se muere
*/
void ComerSiempre(Animal* a1, Animal* a2);

/*
HuirSiemre
    recibe dos animales y se comparan sus velocidades. Dependiendo de los resultados un animal vive y
    se mueve y el otro muere
*/
void HuirSiempre(Animal* a1, Animal* a2);

/*
ComerAleatorio
    recibe dos animales y compara sus atributos al azar. Dependiendo de los resultados uno
    se muere 
*/
void ComerAleatorio(Animal* a1, Animal* a2);
#endif
;