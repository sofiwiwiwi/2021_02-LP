#lang scheme
(define f '())

(define (contagio grafo n d)
  (cond
    ((eq? d 0)f)
    (else (cond
            ((eq? (first (first grafo))n)(append f(list(first (first grafo))(rest (first grafo)))(contagio grafo (first (first grafo))(- d 1))))
            (else (contagio (rest grafo)n d))
            )
          )
    )
  )
