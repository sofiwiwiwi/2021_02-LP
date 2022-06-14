all: exec

exec: Animal.o simulacion.o
	gcc -o exec Animal.o simulacion.o

simulacion.o: simulacion.c
	gcc -c simulacion.c -Wall

Animal.o: Animal.c Animal.h
	gcc -c Animal.c Animal.h -Wall

clean:
	rm Animal.o simulacion.o animal.h.gch exec

run:
	./exec