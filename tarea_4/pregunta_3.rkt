#lang scheme

(define (zeta_simple i s)
  (if(= 1 i)1(+(/ 1 (expt i s))(zeta_simple (- i 1) s)))
  )

(define (zeta_aux i s n_hasta_ahora)
  (if(= 1 i)n_hasta_ahora
     (zeta_aux (- i 1)s (+ (/ (expt i s)) n_hasta_ahora))
     )
  )
(define (zeta_cola i s)
  (zeta_aux i s 1)
  )