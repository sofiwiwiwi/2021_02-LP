#lang scheme
(define f '())

(define (transformacion funcion1 funcion2 numeros)
  (cond
    ((empty? numeros)f)
    (else(cond
           [(> (funcion2 (funcion1 (first numeros))) (funcion1 (funcion2 (first numeros))))
            (append f(list (funcion2 (funcion1 (first numeros))))(transformacion funcion1 funcion2 (rest numeros)))]
           [else (append f(list (funcion1 (funcion2 (first numeros))))(transformacion funcion1 funcion2 (rest numeros)))]
           )
         )
    )
  )