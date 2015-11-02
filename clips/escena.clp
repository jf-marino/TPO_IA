(deftemplate MAIN::escena
   (slot cantidad_victimas)
   (slot curioso_presente (allowed-values si no))
   (slot seguridad (allowed-values segura peligro_derrumbe olor_extranio transito humo fuego otro))
   (slot acceso_victima (allowed-values facil dificil))
   (slot DEA (allowed-values no_presente presente_cargado presente_descargado)))

(deftemplate MAIN::numero
   (slot valor))


(defrule MAIN::escena_1
   (escena (cantidad_victimas ?x))
   =>
   (printout t "APLICAR TRIAGE = " (> ?x 1) crlf))

(defrule MAIN::escena_2
   (or  (escena (seguridad humo))
        (escena (seguridad olor_extranio)))
   =>
   (printout t "ESCENA INSEGURA - LLAMAR BOMBEROS (100)" crlf))

(defrule MAIN::escena_3
   (escena (seguridad transito))
   =>
   (printout t "ASEGURAR ESCENA" crlf))

(defrule MAIN::escena_6
   (escena (seguridad segura))
   =>
   (printout t "PUEDO VERIFICAR VICTIMA" crlf))

(defrule MAIN::escena_4
   (and (or  (escena (seguridad humo))
             (escena (seguridad fuego))))
   (escena (acceso_victima facil))
   =>
   (printout t "SACAR VICTIMA Y LLAMAR A LOS BOMBEROS (100)" crlf))

(defrule MAIN::escena_5
   (and (or  (escena (seguridad humo))
             (escena (seguridad fuego))))
   (escena (acceso_victima dificil))
   =>
   (printout t "LLAMAR A LOS BOMBEROS (100)" crlf))



