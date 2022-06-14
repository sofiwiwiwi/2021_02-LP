#lang scheme
(define f '())

(define (mazo cartas divisor)
  (cond
    ((empty? cartas) f)
    (else (cond
            [(eq? (remainder (first cartas) divisor) 0) (append f (list (first cartas)) (mazo (rest cartas) divisor)) ]
            [else (append f(mazo (rest cartas) divisor))]
            )
          )
    )
  )

  