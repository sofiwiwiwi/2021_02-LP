#include <stdio.h>
#include <stdlib.h>
#include "Animal.h"

int main(){
    //creacion del mundo
    Animal** Mundo = (Animal**)malloc(sizeof(Animal*)*1000);
    for(int i = 0; i<1000; i++){
        Mundo[i] = (Animal*)malloc(sizeof(Animal)*1000);
    }
    //se inicializan con un tipo_fuerza = a, para posteriormente poder saber si el lugar de la matriz esta ocupado.
    for(int i = 0; i<1000; i++){
        for(int j = 0; j<1000; j++){
            Mundo[i][j].tipo_fuerza = 'a';
        }
    }

    int flag = 1, eleccion = 0;
    printf("Bienvenido a la simulacion :D\n");
    while(flag){
        printf("Seleccione una de las siguientes opicones:\n");
        printf("\t1. Crear animal\n\t2. Borrar animal\n\t3. Mostrar Mundo\n\t4. Reproducir dos animales\n\t5. Terminar simulacion\nSu eleccion(ingresar numero): \n");
        scanf("%d",&eleccion);
        
        //crear animal
        if(eleccion == 1){
            int fila, columna;
            printf("Ingrese la fila donde desea crear el animal: \n");
            scanf("%d", &fila);
            printf("Ingrese la columna donde desea crear el animal: \n");
            scanf("%d", &columna);
            //se revisa si el lugar esta ocupado
            if(*(char*)(&(Mundo[fila][columna]).tipo_fuerza) == 'a'){
                CrearAnimal(&(Mundo[fila][columna]));
            }
            else{
                printf("El lugar elegido esta ocupado :c\n");
            }
        }
        
        //borrar animal
        else if(eleccion == 2){
            int fila, columna;
            printf("Ingrese la fila del animal que desea borrar: \n");
            scanf("%d", &fila);
            printf("Ingrese la columna del animal que desea borrar: \n");
            scanf("%d", &columna);
            Borrar(&(Mundo[fila][columna]));
            //se vuelve a poner el tipo_fuerza = 'a' para que el lugar quede marcado como libre
            Mundo[fila][columna].tipo_fuerza = 'a';
            
        }

        //mostar mundo
        else if(eleccion == 3){
            MostrarMundo(Mundo);
        }

        //reproducir dos animales
        else if(eleccion == 4){
            int columna1, fila1, columna2, fila2, hijo1, hijo2;
            printf("Ingrese la fila donde se encuentra el padre 1: \n");
            scanf("%d", &fila1);
            printf("Ingrese la columna donde se encuentra el padre 1: \n");
            scanf("%d", &columna1);
            if(*(char*)(&(Mundo[fila1][columna1]).tipo_fuerza) == 'a'){
                printf("No hay animal ahi :c");
            }
            printf("Ingrese la fila donde se encuentra el padre 2: \n");
            scanf("%d", &fila2);
            printf("Ingrese la columna donde se encuentra el padre 2: \n");
            scanf("%d", &columna2);
            if(*(char*)(&(Mundo[fila2][columna2]).tipo_fuerza) == 'a'){
                printf("No hay animal ahi :c");
            }

            printf("Ingrese la fila donde se creara el hijo: \n");
            scanf("%d",&hijo1);
            printf("Ingrese la columna donde se creara el hijo: \n");
            scanf("%d", &hijo2);
            if(*(char*)(&(Mundo[hijo1][hijo2]).tipo_fuerza) == 'a'){
                Reproducir(&(Mundo[fila1][columna1]), &(Mundo[fila2][columna2]), &(Mundo[hijo1][hijo2]));
            }
            else{
                printf("Ese lugar esta ocuapdo :c\n");
            }
        }

        //terminar simulacion
        else if(eleccion == 5){
            flag = 0;
            BorrarMundo(Mundo);
            printf("Simulacion terminada :D\n");
        }

        else{
            printf("Su eleccion no es valida :c\n");
        }
    }    
    return 0;
}