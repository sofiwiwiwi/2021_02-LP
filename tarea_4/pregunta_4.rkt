#lang scheme
(define (sacar_ultimo_numero lista)
  (cond
    ((null? lista)lista)
    (else(reverse (rest(reverse lista))))
    )
  )

(define (vida h arbol)
  (let ([izq (first(rest arbol))][der (first(rest (rest arbol)))][raiz (first arbol)][retorno '()])
    (cond
      ((empty? arbol)'())
      ((eq? h raiz)retorno)
      (else(cond
             ((not(null? izq))(append retorno(list raiz)(vida h izq)))
             ((not(null? der))(append retorno(list raiz)(vida h der)))
             (else (sacar_ultimo_numero retorno))
             )
           )
      )
    )
  )