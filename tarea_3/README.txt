Nombre: Sofía Riquelme Flores
ROL: 202073615-4

Para compilar todos los archivos y correrlos usar el siguiente comando en la carpeta
de la tarea:
    make run
Si se desea borrar los archivos .class para compilarlos de nuevo usar el siguiente 
comando:
    make clean
    
Notas:

Se usó la versión 17 de javac

Se agregaron los siguientes atributos a la clase jugador: 
    - nivel: entero que representa el nivel actual en el que se encuentra el jugador
    - vida_maxima: entero que representa la vida máxima que puede tener el jugador
    - energia_maxima: entero que representa la energía máxima que puede tener el jugador
    - mana_maximo: entero que representa el maná máximo que puede tener el jugador

También, en jugador se agegró el método anadirmisiones, para anadir una mision a la lista
de misiones al jugador.

También se agregó el atributo mision al NPC neutro, que consiste en el objeto misión que 
el NPC otorgará al jugador.

Corrí todo en la consola de WSL y los tildes junto con las ñ de los print se veían bien,
pero puede que ese no siempre sea el caso.