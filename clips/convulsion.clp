(deftemplate MAIN::convulsion
	(slot estado (allowed-values si no se_detuvo))
	(slot epilepsia (allowed-values si no))
	(slot duracion)
	(slot ciclica (allowed-values si no))
	(slot medicacion (allowed-values tomo no_tomo no_usa))
	(slot fiebre (allowed-values si no)))


(defrule MAIN::convulsion_1
	(convulsion (estado si))
	=>
	(printout lesionesTarget "Atender las convulsiones"))


(defrule MAIN::convulsion_2
	(convulsion (estado se_detuvo) (epilepsia si) (medicacion tomo))
	(victima (edad adulto))
	=>
	(printout lesionesTarget "Colocar a la victima en posición lateral de seguridad y esperar que se recupere"))


(defrule MAIN::convulsion_3
	(convulsion (estado se_detuvo) (fiebre no))
	(victima (edad ninio))
	=>
	(printout lesionesTarget "Colocar a la victima en posición lateral de seguridad y llamar a una ambulancia"))


(defrule MAIN::convulsion_4
	(convulsion (estado se_detuvo) (fiebre si))
	(victima (edad ninio))
	=>
	(printout lesionesTarget "Bajarle la temperatura a la víctima y llamar a una ambulancia"))


(defrule MAIN::convulsion_5
	(convulsion (estado si) (ciclica si))
	(victima (edad adulto))
	=>
	(printout lesionesTarget "Llamar a una ambulancia"))


(defrule MAIN::convulsion_6
	(convulsion (estado se_detuvo) (duracion ?d&:(> ?d 1)))
	(victima (edad adulto))
	=>
	(printout lesionesTarget "Llamar a una ambulancia"))

