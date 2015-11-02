(deftemplate MAIN::victima
	(slot edad (allowed-values bebe ninio adulto))
	(slot posicion (allowed-values boca_abajo boca_arriba de_lado sentado parado posicion_lateral_de_seguridad))
	(slot conciencia (allowed-values alerta responde_a_estimulo_verbal responde_a_estimulo_doloroso inconciente))
	(slot respiracion (allowed-values no_respira respira_rapido respira_normal respira_lento))
	(slot temperatura (allowed-values hipotermia normal hipertermia))
	(slot epilepsia (allowed-values si no))
	(slot obstruccion_via_aerea (allowed-values habla tose no_respira))
	(slot comio (allowed-values si no))
	(slot diabetes (allowed-values si no))
	(slot insulino_dependiente (allowed-values si_y_aplico_insulina si_y_no_aplico_insulina no))
	(slot crisis_diabetica (allowed-values si no)))

	
(defrule MAIN::victima_1
	(victima (diabetes si))
	=>
	(printout victimaTarget "Evaluar síntomas de shock diabético"))

(defrule MAIN::victima_2
	(victima (diabetes si) (conciencia inconciente) (comio no) (crisis_diabetica si))
	=>
	(printout victimaTarget "Dele azucar debajo de la lengua"))

(defrule MAIN::victima_3
	(victima (diabetes si) (conciencia alerta|responde_a_estimulo_verbal) (insulino_dependiente si_y_no_aplico_insulina) (crisis_diabetica si) (comio si))
	=>
	(printout victimaTarget "Es posible que tenga hiperglucemia"))


(defrule MAIN::victima_4
	(victima (diabetes si) (conciencia inconciente))
	=>
	(printout victimaTarget "Llamar al 107"))


(defrule MAIN::victima_5
	(victima (conciencia inconciente) (respiracion no_respira) (edad adulto))
	(escena (curioso_presente no))
	=>
	(printout victimaTarget "Llamar al 107 y luego iniciar RCP para adulto"))


(defrule MAIN::victima_6
	(victima (conciencia inconciente) (respiracion no_respira) (edad adulto))
	(escena (curioso_presente si))
	=>
	(printout victimaTarget "Pedir que llamen al 107 e iniciar RCP para adulto"))


(defrule MAIN::victima_7
	(victima (conciencia inconciente) (respiracion no_respira) (edad adulto))
	(escena (curioso_presente no) (DEA presente_cargado))
	=>
	(printout victimaTarget "Llamar al 107 e iniciar RCP para adulto con DEA"))


(defrule MAIN::victima_8
	(victima (conciencia inconciente) (respiracion no_respira) (edad adulto))
	(escena (curioso_presente si) (DEA presente_cargado))
	=>
	(printout victimaTarget "Pedir que llamen al 107 e iniciar RCP para adulto con DEA"))


(defrule MAIN::victima_9
	(victima (conciencia inconciente) (respiracion no_respira) (edad bebe))
	(escena (curioso_presente no))
	=>
	(printout victimaTarget "Hacer un ciclo de rescate y llamar al 107, realizar RCP para bebé"))


(defrule MAIN::victima_10
	(victima (conciencia inconciente) (respiracion no_respira) (edad bebe))
	(escena (curioso_presente si))
	=>
	(printout victimaTarget "Pedir que llamen al 107 y realizar RCP para bebé"))


(defrule MAIN::victima_11
	(victima (conciencia inconciente) (respiracion no_respira) (edad ninio))
	(escena (curioso_presente si))
	=>
	(printout victimaTarget "Pedir que llamen al 107 e iniciar RCP para niño"))


(defrule MAIN::victima_12
	(victima (conciencia inconciente) (respiracion no_respira) (edad ninio))
	(escena (curioso_presente no))
	=>
	(printout victimaTarget "Hacer un ciclo de rescate y llamar al 107, realizar RCP para niño"))


(defrule MAIN::victima_13
	(victima (conciencia inconciente) (respiracion no_respira) (edad ninio))
	(escena (curioso_presente si) (DEA presente_cargado))
	=>
	(printout victimaTarget "Pedir que llamen al 107 e iniciar RCP con DEA"))


(defrule MAIN::victima_14
	(victima (conciencia inconciente) (respiracion no_respira) (edad ninio))
	(escena (curioso_presente no) (DEA presente_cargado))
	=>
	(printout victimaTarget "Hacer un ciclo de rescate y llamar al 107, realizar RCP para niño con DEA"))

