import re

'''
comando_dir

------------------------------------------

fila_actual: entero
columna_actual: entero
dir: string
valor: entero
matriz: lista de listas de enteros
n: entero

-----------------------------------------

la funcion, mueve la posicion actual hacia donde le dice
dir y valor. Para que la matriz sea ciclica, se aplica modulo
en los casos donde la posicion queda fuera de la matriz.
retorna una tupla con la fila y la columna luego de moverse
'''
def comando_dir(fila_actual, columna_actual, dir, valor, matriz, n):
    if dir == "U":
        fila_actual -= valor
    elif dir == "D":
        fila_actual += valor
    elif dir == "<":
        columna_actual -= valor
    elif dir == ">":
        columna_actual += valor

    if columna_actual > n-1:
        columna_actual = (valor%n)-1
    elif columna_actual < 0:
        columna_actual = (columna_actual%n)
    if fila_actual > n-1:
        fila_actual = (valor%n)-1
    elif fila < 0:
        fila_actual = (fila_actual%n)

    return (fila_actual,columna_actual)

'''
sumador_valores

------------------------------------------

fila_actual: entero
columna_actual: entero
matriz: lista de listas de enteros
comando: string
n: entero

-----------------------------------------

la funcion, dependiendo del comando, realiza una operacion 
sobre el valor de la posicion actual dentro de la matriz.
no tiene retorno
'''
def sumador_valores(fila_actual, columna_actual, matriz, comando, n):
    if comando == "A":
        matriz[fila_actual][columna_actual] += 1
    elif comando == "B":
        matriz[fila_actual][columna_actual] -= 1
    elif comando == "R":
        matriz[fila_actual][columna_actual] = 0
    elif comando == "Z":
        for i in range(0,n):
            for j in range (0,n):
                matriz[i][j] = 0

'''
multiplicador_valores

------------------------------------------

operacion: string
fila_deseada: entero
columna_deseada: entero
fila_actual: entero
columna_actual: entero
matriz: lista de listas de enteros

-----------------------------------------

la funcion, multiplica el valor de la posicion actual dentro de la matriz
por el valor encontrado en la posicion indicada por fila_deseada 
y columna_deseada.
no tiene retorno
'''
def multiplicador_valores(operacion, fila_deseada, columna_deseada, fila_actual, columna_actual, matriz, n):
    a = matriz[fila_deseada][columna_deseada]
    if operacion == "X":
        matriz[fila_actual][columna_actual] *= a
    elif operacion == "Y":
        if a == 0:
            return
        else:
            matriz[fila_actual][columna_actual] /= a

'''
mostrador

------------------------------------------

comando: string
fila_actual: entero
columna_actual: entero
x: string
matriz: lista de listas de enteros
n:entero

-----------------------------------------

la funcion, imprime la version caracter o la version entero del valor
en la posicion actual de la matriz, o de la matriz entera, dependiendo
de lo indicado por comando y por x.
no tiene retorno.
'''
def mostrador(comando, fila_actual, columna_actual, x, matriz,n):
    if comando == "L":
        if x == "c" and  matriz[fila_actual][columna_actual]>= 32 and matriz[fila_actual][columna_actual] <= 127:
            print(chr(matriz[fila_actual][columna_actual]))
        elif x == "e":
            print(matriz[fila_actual][columna_actual], end="")
    elif comando == "S":
        if x == "c":
            for i in range(0,n):
                for j in range(0,n):
                    if matriz[i][j]>= 32 and matriz[i][j] <= 127:
                        print(chr(matriz[i][j]),end="")
                
        elif x == "e":
            for i in range(0,n):
                for j in range(0,n):
                    print(matriz[i][j],end="")

'''
condicional

------------------------------------------

fila_deseada: entero
columna_deseada: entero
fila_actual: entero
columna_actual: entero
operacion: string
matriz: lista de listas de enteros
n: entero

-----------------------------------------

si es que el valor de la posicion indicada por fila_deseada 
y columna_deseada es mayor a 0, se llama la funcion correspondiente
indicada por operacion.
no retorna nada
'''
def condicional(fila_deseada, columna_deseada, fila_actual, columna_actual, operacion, matriz,n):
    if matriz[fila_deseada][columna_deseada] > 0:
        if re.fullmatch(r"A|B|R|Z", operacion):
            sumador_valores(fila_actual, columna_actual, matriz, operacion, n)
        elif re.fullmatch(r"L[c|e]|S[c|e]", operacion):
            mostrador(operacion[0], fila, columna, operacion[1], matriz, n)
        elif re.fullmatch(r"[X|Y][U|D|<|>][0-9]+[U|D|<|>]*[0-9]*", operacion):
            comando = re.fullmatch(r"[X|Y][U|D|<|>][0-9]+[U|D|<|>]*[0-9]*", match)[0]
            operacion = a = re.search(r"X|Y", comando)[0]
            direcciones = re.findall(r"[U|D|<|>][0-9]+", comando)
            fila_deseada, columna_deseada = fila, columna
            for direccion in direcciones:
                dir = re.search(r"U|D|<|>", direccion)
                valor = int(re.search(r"[0-9][0-9]*", direccion)[0])
                fila_deseada, columna_deseada = comando_dir(fila_deseada, columna_deseada, dir, valor, matriz, n)
            multiplicador_valores(operacion, fila_deseada, columna_deseada, fila, columna, matriz, n)
            
              
matriz = []
codigos = open("codigos.txt", 'r')
errores = open("errores.txt", "w")

n = int(codigos.readline())
    
for i in range(0,n):
    matriz.append([])
    for j in range(0,n):
        matriz[i].append(0)

#inicia en posición (0,0)
fila = 0
columna = 0

cant_errores = 0

l = 0
for linea in codigos:
    l+=1
    linea_copy = linea
    
    parentesis = re.findall(r"\([?<>0-9A-Za-z]+\)", linea_copy)
    #checkeo de parentesis
    if len(parentesis) != 0:
        linea = ""
        while len(parentesis) != 0:
            for match in parentesis:
                linea_copy = linea_copy.replace(match, "")
                linea += match
            parentesis = re.findall(r"\([?<>0-9A-Za-z]+\)", linea_copy) 
        linea += linea_copy
    
    linea_copy2 = linea.replace("\n", "")
    matches = re.findall(r"[ABRZ]|[LS][ce]|[UD><][1-9][0-9]*|[XY][UD<>][1-9][0-9]*[UD<>][1-9][0-9]*|\?[UD<>][1-9][0-9]*A|B|R|Z|[LS][ce]", linea)
    for match in matches:
        if match in linea_copy2:
            linea_copy2 = linea_copy2.replace(match, "")
        
    linea_copy2 = linea_copy2.replace("()", "")
    if len(linea_copy2) == 0:
        for match in matches:
            #check condicionales
            if re.fullmatch(r"\?[UD<>](0|[1-9][0-9]*)[ABRZ|L[ce]|S[ce]]", match):
                comando =  re.fullmatch(r"\?[U|D|<|>][1-9][0-9]*A|B|R|Z|L[c|e]|S[c|e]",match)[0]
                dir = re.search(r"U|D|<|>", comando)[0]
                valor = int(re.search(r"[0-9][0-9]*", comando)[0])
                operacion = re.search(r"A|B|R|Z|L[c|e]|S[c|e]",comando)[0]
                fila_deseada, columna_deseada = comando_dir(fila, columna, dir, valor, matriz, n)
                condicional(fila_deseada, columna_deseada, fila, columna, operacion, matriz, n)
                
        #check direcciones 
            if re.fullmatch(r"[UD<>][0-9][0-9]*", match):
                comando = re.fullmatch(r"[U|D|<|>][0-9]+", match)[0]
                dir =  re.search(r"U|D|<|>", comando)[0]
                valor = int(re.search(r"[0-9][0-9]*", comando)[0])
                fila, columna = (comando_dir(fila, columna, dir, valor, matriz,n))
            
            #check sumar/restar
            elif re.fullmatch(r"[ABRZ]",match):
                comando = re.fullmatch(r"[ABRZ]",match)[0]
                sumador_valores(fila, columna, matriz, comando, n)
    
            #check weas que imprimen
            elif re.fullmatch(r"[LS][ce]", match):
                comando = re.fullmatch(r"[LS][ce]", match)[0]
                a = re.search(r"L|S", comando)[0]
                x = re.search(r"c|e", comando)[0]
                mostrador(a, fila, columna, x, matriz, n)

            #check weas que multiplican/dividen
            elif re.fullmatch(r"[XY][UD<>][0-9]+[UD<>]*[0-9]*", match):
                comando = re.fullmatch(r"[XY][UD<>][0-9]+[UD<>]*[0-9]*", match)[0]
                operacion = a = re.search(r"X|Y", comando)[0]
                direcciones = re.findall(r"[U|D|<|>][0-9]+", comando)
                fila_deseada, columna_deseada = fila, columna
                for direccion in direcciones:
                    dir = re.search(r"U|D|<|>", direccion)
                    valor = int(re.search(r"[0-9][0-9]*", direccion)[0])
                    fila_deseada, columna_deseada = comando_dir(fila_deseada, columna_deseada, dir, valor, matriz, n)
                multiplicador_valores(operacion, fila_deseada, columna_deseada, fila, columna, matriz, n)
    elif len(matches) == 0 or len(linea_copy2)!= 0:
        errores.write(str(l)+"\t"+linea)
        cant_errores += 1

if cant_errores == 0:
    errores.write("No hay errores!")

if cant_errores == l:
    print("No hay lineas correctas :c")
                                 	                
codigos.close()
errores.close()