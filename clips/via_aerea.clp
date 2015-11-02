(deftemplate MAIN::via_aerea
	(slot estado (allowed-values no_obstruida semi_obstruida obstruida))
	(slot cianosis (allowed-values si no)))
	

(defrule MAIN::via_aerea_1
	(via_aerea (estado semi_obstruida))
	(victima (edad adulto|ninio))
	=>
	(printout lesionesTarget "Dejarlo toser"))


(defrule MAIN::via_aerea_2
	(via_aerea (estado semi_obstruida))
	(victima (edad bebe))
	=>
	(printout lesionesTarget "Estimular al bebé a toser"))


(defrule MAIN::via_aerea_3
	(via_aerea (estado obstruida) (cianosis si))
	(victima (edad adulto) (conciencia alerta) (edad adulto))
	=>
	(printout lesionesTarget "Aplicar Heimlich y RCP para adulto"))


(defrule MAIN::via_aerea_4
	(via_aerea (estado obstruida) (cianosis si))
	(victima (conciencia inconciente) (edad adulto))
	=>
	(printout lesionesTarget "Realizar RCP para adulto"))


(defrule MAIN::via_aerea_5
	(via_aerea (estado obstruida) (cianosis si))
	(victima (conciencia alerta) (edad ninio))
	=>
	(printout lesionesTarget "Aplicar Heimlich y RCP para niño"))


(defrule MAIN::via_aerea_6
	(via_aerea (estado obstruida) (cianosis si))
	(victima (conciencia inconciente) (edad ninio))
	=>
	(printout lesionesTarget "Aplicar RCP para niño"))


(defrule MAIN::via_aerea_7
	(via_aerea (estado obstruida) (cianosis si))
	(victima (conciencia alerta) (edad bebe))
	=>
	(printout lesionesTarget "Aplicar Heimlich y RCP para bebe"))


(defrule MAIN::via_aerea_8
	(via_aerea (estado obstruida) (cianosis si))
	(victima (conciencia inconciente) (edad bebe))
	=>
	(printout lesionesTarget "Realizar RCP para bebé"))

