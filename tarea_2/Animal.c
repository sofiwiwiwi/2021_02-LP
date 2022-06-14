#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "Animal.h"


void ReproduccionSimple(Animal* padre1, Animal* padre2, Animal* hijo){
    int comparacion = Comparar(padre1, padre2);
    if (comparacion == 0)
        hijo = padre1;
    else
        hijo = padre2;  
};

void ReproduccionCruzada(Animal* padre1, Animal* padre2, Animal* hijo){
    int comparacion = Comparar(padre1, padre2);
    if(comparacion == 0){
        hijo->tipo_fuerza = padre1->tipo_fuerza;
        hijo->fuerza = padre1->fuerza;
        hijo->tipo_velocidad = padre1->tipo_velocidad;
        hijo->velocidad = padre1->velocidad;
        hijo->reproduccion = padre1->reproduccion;
        hijo->tipo_resistencia = padre2->tipo_resistencia;
        hijo->resistencia = padre2->resistencia;
        hijo->comerHuir = padre2->comerHuir;
    }
    else{
        hijo->tipo_fuerza = padre2->tipo_fuerza;
        hijo->fuerza = padre2->fuerza;
        hijo->tipo_velocidad = padre2->tipo_velocidad;
        hijo->velocidad = padre2->velocidad;
        hijo->reproduccion = padre2->reproduccion;
        hijo->tipo_resistencia = padre1->tipo_resistencia;
        hijo->resistencia = padre1->resistencia;
        hijo->comerHuir = padre1->comerHuir;

    }
};

void CrearAnimal(Animal* a){
    char f, v, r;
    int funcR, funcC;
    void* fuerza_real; 
    void* velocidad_real;
    void* resistencia_real;

    printf("Ingrese el tipo de dato para la fuerza (e para entero, c para caracter, f para flotante): \n");
    scanf("%c", &f);
    scanf("%c", &f);
    a->tipo_fuerza = f;
    switch(f){
        case 'e':
            fuerza_real = malloc(sizeof(int));
            printf("Ingrese el valor entero de la fuerza: \n");
            scanf("%d", (int*)fuerza_real);
            a->fuerza = fuerza_real;
            break;
        case 'c':
            fuerza_real = malloc(1);
            printf("Ingrese el caracter de la fuerza: \n");
            scanf("%c", (char*)fuerza_real);
            scanf("%c", (char*)fuerza_real);
            a->fuerza = fuerza_real;
            break;
        case 'f':
            fuerza_real = malloc(sizeof(float));
            printf("Ingrese el valor flotante de la fuerza: \n");
            scanf("%f", (float*)fuerza_real);
            a->fuerza = fuerza_real;
            break;
    }

    printf("Ingrese el tipo de dato para la velocidad (e para entero, c para caracter, f para flotante): \n");
    scanf("%c", &v);
    scanf("%c", &v);
    a->tipo_velocidad = v;
    switch(v){
        case 'e':
            velocidad_real = malloc(sizeof(int));
            printf("Ingrese el valor entero de la velocidad: \n");
            scanf("%d", (int*)velocidad_real);
            a->velocidad = velocidad_real;
            break;
        case 'c':
            velocidad_real = malloc(1);
            printf("Ingrese el caracter de la velocidad: \n");
            scanf("%c", (char*)velocidad_real);
            scanf("%c", (char*)velocidad_real);
            a->velocidad = velocidad_real;
            break;
        case 'f':
            velocidad_real = malloc(sizeof(float));
            printf("Ingrese el valor flotante de la fuerza: \n");
            scanf("%f", (float*)velocidad_real);
            a->velocidad = velocidad_real;
            break;
    }

    printf("Ingrese el tipo de dato de la resistencia (e para entero, c para caracter, f para flotante): \n");
    scanf("%c", &r);
    scanf("%c", &r);
    a->tipo_resistencia = r;
    switch(r){
        case 'e':
            resistencia_real = malloc((sizeof(int)));
            printf("Ingrese el valor entero de la resistencia: \n");
            scanf("%d", (int*)resistencia_real);
            a->resistencia = resistencia_real;
            break;
        case 'c':
            resistencia_real = malloc(1);
            printf("Ingrese el caracter de la resistencia: \n");
            scanf("%c", (char*)resistencia_real);
            scanf("%c", (char*)resistencia_real);
            a->resistencia = resistencia_real;
            break;
        case 'f':
            resistencia_real = malloc(sizeof(float));
            printf("Ingrese el valor flotante de la resistencia: \n");
            scanf("%f", (float*)resistencia_real);
            a->resistencia = resistencia_real;
            break;
    }
    printf("Ingrese el tipo de reproduccion que desea:\n\t1. Reproduccion Simple\n\t2. Reproduccion Cruzada \n");
    scanf("%d", &funcR);
    switch(funcR){
        case 1:
            a->reproduccion = ReproduccionSimple;
            break;
        case 2:
            a->reproduccion = ReproduccionCruzada;
            break;
    }

    printf("Ingrese la funcion ComerHuir que desea:\n\t1. ComerSiempre\n\t2. HuirSiempre\n\t3. ComerAleatorio\n");
    scanf("%d", &funcC);
    switch(funcC){
        case 1:
            a->comerHuir = ComerSiempre;
            break;
        case 2:
            a->comerHuir = HuirSiempre;
            break;
        case 3:
            a->comerHuir = ComerAleatorio;
            break;
    }
};

void Borrar(Animal* a){
    free(a->fuerza);
    free(a->velocidad);
    free(a->resistencia);
};

void MostrarAnimal(Animal* a){
    
    if(a->tipo_fuerza == 'c')
        printf("\tfuerza: %c\n", *(char*)(a->fuerza));
    else if(a->tipo_fuerza == 'e')
        printf("\tfuerza: %d\n", *(int*)(a->fuerza));
    else if(a->tipo_fuerza == 'f')
        printf("\tfuerza: %f\n", *(float*)(a->fuerza));

    if(a->tipo_velocidad == 'c')
        printf("\tvelocidad: %c\n", *(char*)(a->velocidad));
    else if(a->tipo_velocidad == 'e')
        printf("\tvelocidad: %d\n", *(int*)(a->velocidad));
    else if(a->tipo_velocidad == 'f')
        printf("\tvelocidad: %f\n", *(float*)(a->velocidad));

    if(a->tipo_resistencia == 'c')
        printf("\tresistencia: %c\n", *(char*)a->resistencia);
    else if(a->tipo_resistencia == 'e')
        printf("\tresistencia: %d\n", *(int*)a->resistencia);
    else if(a->tipo_resistencia == 'f')
        printf("\tresistencia: %f\n", *(float*)(a->resistencia));    

};

void Reproducir(Animal* padre1, Animal* padre2, Animal* hijo){
    float prob = (float)rand()/(float)RAND_MAX;
    if(prob > 0.5){
        padre1->reproduccion(padre1, padre2, hijo);
        printf("Se uso la funcion del primer animal:\n");
        MostrarAnimal(padre1);
    }
    else{
        padre2->reproduccion(padre2, padre1, hijo);
        printf("Se uso la funcion del segundo animal:\n");
        MostrarAnimal(padre2);
    }
};

void ComerOHuir(Animal* a1, Animal* a2){
    float prob = (float)rand()/(float)RAND_MAX;
    if(prob > 0.5){
        a1->comerHuir(a1,a2);
        printf("Se uso la funcion del primer animal:\n");
        MostrarAnimal(a1);
    }
    else{
        a2->comerHuir(a2,a1);
        printf("Se uso la funcion del segundo animal:\n");
        MostrarAnimal(a2);
    }
};

int Comparar(Animal* a1, Animal* a2){
    int valor_fuerza1, valor_fuerza2, valor_velocidad1, valor_velocidad2, valor_resistencia1, valor_resistencia2;
    int atributos_mayores_1 = 0, atributos_mayores_2 = 0;
    
    if(a1->tipo_fuerza == 'e'){
        valor_fuerza1 = *(int*)a1->fuerza;
    }
    else if (a1->tipo_fuerza == 'c'){
        valor_fuerza1 = *(int*)(a1->fuerza)/4;
    }
    else if(a1->tipo_fuerza == 'f'){
        valor_fuerza1 = *(int*)(a1->fuerza);
    }

    if(a2->tipo_fuerza == 'e'){
        valor_fuerza2 = *(int*)a2->fuerza;
    }
    else if (a2->tipo_fuerza == 'c'){
        valor_fuerza2 = *(int*)(a2->fuerza)/4;
    }
    else if(a2->tipo_fuerza == 'f'){
        valor_fuerza2 = *(int*)(a2->fuerza);
    }


    if(a1->tipo_velocidad == 'e'){
        valor_velocidad1 = *(int*)a1->velocidad;
    }
    else if (a1->tipo_velocidad == 'c'){
        valor_velocidad1 = *(int*)(a1->velocidad)/4;
    }
    else if(a1->tipo_velocidad == 'f'){
        valor_velocidad1 = *(int*)(a1->velocidad);
    }

    if(a2->tipo_velocidad == 'e'){
        valor_velocidad2 = *(int*)a2->velocidad;
    }
    else if (a2->tipo_velocidad == 'c'){
        valor_velocidad2 = *(int*)(a2->velocidad)/4;
    }
    else if(a2->tipo_velocidad == 'f'){
        valor_velocidad2 = *(int*)(a2->velocidad);
    }


    if(a1->tipo_resistencia == 'e'){
        valor_resistencia1 = *(int*)a1->resistencia;
    }
    else if (a1->tipo_resistencia == 'c'){
        valor_resistencia1 = *(int*)(a1->resistencia)/4;
    }
    else if(a1->tipo_resistencia == 'f'){
        valor_resistencia1 = *(int*)(a1->resistencia);
    }

    if(a2->tipo_resistencia == 'e'){
        valor_resistencia2 = *(int*)a2->resistencia;
    }
    else if (a2->tipo_resistencia == 'c'){
        valor_resistencia2 = *(int*)(a2->resistencia)/4;
    }
    else if(a2->tipo_velocidad == 'f'){
        valor_resistencia2 = *(int*)(a2->resistencia);
    }

    if(valor_fuerza1 > valor_fuerza2){
        atributos_mayores_1 ++;
    }
    else if(valor_fuerza2 > valor_fuerza1){
        atributos_mayores_2 ++;
    }
    if(valor_velocidad1 > valor_velocidad2){
        atributos_mayores_1 ++;
    }
    else if(valor_velocidad2 > valor_velocidad1){
        atributos_mayores_2 ++;
    }
    if(valor_resistencia1 > valor_resistencia2){
        atributos_mayores_1 ++;
    }
    else if(valor_resistencia2 > valor_resistencia1){
        atributos_mayores_2 ++;
    }
    if(atributos_mayores_1 > atributos_mayores_2){
        return 0;
    }
    else{
        return 1;
    }

    
};

void BorrarMundo(Animal** Mundo){
    for(int i = 0; i<1000; i++){
        for(int j = 0; j<1000; j++){
            if(*(char*)(&(Mundo[i][j]).tipo_fuerza) != 'a'){
                Borrar(&(Mundo[i][j]));
            }
        }
        free(Mundo[i]);
    } 
    free(Mundo);
};

void MostrarMundo(Animal** Mundo){
    for(int i = 0; i < 1000; i++){
        for(int j = 0; j < 1000; j++){
            if(*(char*)(&(Mundo[i][j]).tipo_fuerza) != 'a'){
                printf("Animal en la fila %d, columna %d: \n", i,j);
                MostrarAnimal(&(Mundo[i][j]));
            }
        }
    }
};

void ComerSiempre(Animal* a1, Animal* a2){
    int valor_fuerza1, valor_resistencia2;
    if(a1->tipo_fuerza == 'c')
        valor_fuerza1 = *(int*)(a1->fuerza)/4;
    else if (a1->tipo_fuerza == 'f')
        valor_fuerza1 = *(int*)(a1->fuerza);

    if(a1->tipo_resistencia == 'c')
        valor_resistencia2 = *(int*)(a1->resistencia)/4;
    else if (a1->tipo_resistencia == 'f')
        valor_resistencia2 = *(int*)(a1->resistencia);
    
    if(valor_fuerza1 > valor_resistencia2)
        Borrar(a2);
    else
        Borrar(a1); 
};

void HuirSiempre(Animal* a1, Animal* a2){
    
};

void ComerAleatorio(Animal* a1, Animal* a2){
    srand(time(NULL));
    int random1 = rand()%3, random2 = rand()%3;
    int valor_atributo1;
    int valor_atributo2;

    if(random1 == 0){
        if(a1->tipo_fuerza == 'e' || a1->tipo_fuerza == 'f'){
            valor_atributo1 = *(int*)(a1->fuerza);
        }
        else if(a1->tipo_fuerza == 'c'){
            valor_atributo1 = *(int*)(a1->fuerza)/4;
        }
    }

    else if(random1 == 1){
        if(a1->tipo_velocidad == 'e' || a1->tipo_velocidad == 'f'){
            valor_atributo1 = *(int*)(a1->velocidad);
        }
        else if(a1->tipo_velocidad == 'c'){
            valor_atributo1 = *(int*)(a1->velocidad)/4;
        }
    }

    else if(random1 == 2){
        if(a1->tipo_resistencia == 'e' || a1->tipo_resistencia == 'f'){
            valor_atributo1 = *(int*)(a1->resistencia);
        }
        else if(a1->tipo_resistencia == 'c'){
            valor_atributo1 = *(int*)(a1->resistencia)/4;
        }
    }


    if(random2 == 0){
        if(a2->tipo_fuerza == 'e' || a2->tipo_fuerza == 'f'){
            valor_atributo2 = *(int*)(a2->fuerza);
        }
        else if(a2->tipo_fuerza == 'c'){
            valor_atributo2 = *(int*)(a2->fuerza)/4;
        }
    }

    else if(random2 == 1){
        if(a2->tipo_velocidad == 'e' || a2->tipo_velocidad == 'f'){
            valor_atributo2 = *(int*)(a2->velocidad);
        }
        else if(a2->tipo_velocidad == 'c'){
            valor_atributo2 = *(int*)(a2->velocidad)/4;
        }
    }

    else if(random2 == 2){
        if(a2->tipo_resistencia == 'e' || a2->tipo_resistencia == 'f'){
            valor_atributo2 = *(int*)(a2->resistencia);
        }
        else if(a2->tipo_resistencia == 'c'){
            valor_atributo2 = *(int*)(a2->resistencia)/4;
        }
    }

    if(valor_atributo1 > valor_atributo2){
        Borrar(a2);
    }
    else{
        Borrar(a1);
    }

};