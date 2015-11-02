(deftemplate MAIN::sangrado
	(slot clase_herida (allowed-values cortante punzante laceracion contucion arma_de_fuego raspadura))
	(slot profundidad (allowed-values superficial moderado profundo))
	(slot objeto_extranio (allowed-values si no))
	(slot tamanio (allowed-values pequenia media extensa))
	(slot amputacion (allowed-values si no))
	(slot tipo (allowed-values sin_sangrado_visible sangrado_lento sangrado_abundante sangrado_interno))
	(slot zona (allowed-values riesgosa no_riesgosa)))
	

(defrule MAIN::sangrado_1
	(sangrado (clase_herida ?x) (amputacion si))
	=>
	(printout lesionesTarget "Llamar a una ambulancia y controlar el sangrado, aplicar vendaje compresivo. Luego recupere la parte y pongala en hielo"))


(defrule MAIN::sangrado_2
	(sangrado (clase_herida arma_de_fuego) (zona riesgosa))
	=>
	(printout lesionesTarget "Llamar a una ambulancia y atender el arma de fuego en la zona riesgosa"))


(defrule MAIN::sangrado_3
	(sangrado (clase_herida arma_de_fuego) (zona no_riesgosa) (tipo sangrado_lento))
	=>
	(printout lesionesTarget "Llamar a una ambulancia y atender el arma de fuego en la zona no riesgosa"))


(defrule MAIN::sangrado_4
	(sangrado (clase_herida laceracion) (profundidad profundo|moderado) (objeto_extranio no) (tamanio media|extensa))
	=>
	(printout lesionesTarget "Contener el sangrado, realizar un vendaje y llamar a una ambulancia"))


(defrule MAIN::sangrado_5
	(sangrado (clase_herida laceracion) (profundidad superficial) (tamanio pequenia) (objeto_extranio no) (zona no_riesgosa))
	=>
	(printout lesionesTarget "Limpiar la herida y realizar un vendaje"))


(defrule MAIN::sangrado_6
	(sangrado (clase_herida laceracion) (profundidad moderado|profundo) (tamanio pequenia) (objeto_extranio no) (zona riesgosa))
	=>
	(printout lesionesTarget "Limpiar la herida, realizar un vendaje y llamar a una ambulancia"))


(defrule MAIN::sangrado_7
	(sangrado (clase_herida laceracion) (objeto_extranio no))
	=>
	(printout lesionesTarget "Fijar el objeto, controlar el sangrado y realizar un vendaje"))


(defrule MAIN::sangrado_8
	(sangrado (clase_herida punzante) (tamanio media) (tipo sangrado_interno|sin_sangrado_visible) (objeto_extranio si) (zona riesgosa))
	=>
	(printout lesionesTarget "Fijar el objeto y llamar a un médico"))


(defrule MAIN::sangrado_9
	(sangrado (clase_herida punzante) (tamanio pequenia) (tipo sangrado_interno|sin_sangrado_visible) (objeto_extranio si) (zona no_riesgosa))
	=>
	(printout lesionesTarget "Fijar el objeto y lleva a la víctima a un médico"))


(defrule MAIN::sangrado_10
	(sangrado (clase_herida punzante) (tamanio pequenia) (tipo sangrado_interno|sin_sangrado_visible) (objeto_extranio si) (zona riesgosa))
	=>
	(printout lesionesTarget "Fijar el objeto y lleva a la víctima a un médico"))


(defrule MAIN::sangrado_11
	(sangrado (clase_herida punzante) (tamanio pequenia) (tipo sangrado_interno|sin_sangrado_visible) (objeto_extranio no))
	=>
	(printout lesionesTarget "Limpiar la herida y llevar a la víctima a un médico"))


(defrule MAIN::sangrado_12
	(sangrado (clase_herida punzante) (tamanio pequenia) (tipo sangrado_lento|sangrado_abundante) (objeto_extranio no))
	=>
	(printout lesionesTarget "Contener el sangrado y llamar a un médico"))


(defrule MAIN::sangrado_13
	(sangrado (clase_herida cortante) (profundidad profundo) (tipo sangrado_abundante) (objeto_extranio no) (tamanio media|extensa) (zona riesgosa))
	=>
	(printout lesionesTarget "Controlar el sangrado y llamar a un médico"))


(defrule MAIN::sangrado_14
	(sangrado (clase_herida cortante) (profundidad profundo) (tipo sangrado_abundante) (objeto_extranio no) (tamanio media|extensa) (zona no_riesgosa))
	=>
	(printout lesionesTarget "Controlar el sangrado, vendar y llamar a un médico"))


(defrule MAIN::sangrado_15
	(sangrado (clase_herida cortante) (profundidad profundo) (tipo sangrado_abundante) (objeto_extranio no) (tamanio pequenia))
	=>
	(printout lesionesTarget "Controlar el sangrado y llamar a un médico"))


(defrule MAIN::sangrado_16
	(sangrado (clase_herida cortante) (profundidad superficial) (tipo sangrado_abundante) (objeto_extranio no) (tamanio pequenia))
	=>
	(printout lesionesTarget "Controlar el sangrado, limpiar la herida y vendar"))


(defrule MAIN::sangrado_17
	(sangrado (clase_herida cortante) (tipo sangrado_lento) (objeto_extranio no) (tamanio pequenia|media))
	=>
	(printout lesionesTarget "Limpiar herida"))


(defrule MAIN::sangrado_18
	(sangrado (clase_herida raspadura) (tipo sangrado_lento|sin_sangrado_visible) (objeto_extranio no) (tamanio pequenia|media))
	=>
	(printout lesionesTarget "Limpiar la herida"))


(defrule MAIN::sangrado_19
	(sangrado (clase_herida raspadura) (tipo sangrado_lento|sin_sangrado_visible) (objeto_extranio no) (tamanio extensa))
	=>
	(printout lesionesTarget "Limpiar la herida y llamar a un médico"))


(defrule MAIN::sangrado_20
	(sangrado (clase_herida contucion) (tipo sin_sangrado_visible) (tamanio pequenia))
	=>
	(printout lesionesTarget "Aplicar hielo y controlar la herida"))


(defrule MAIN::sangrado_21
	(sangrado (clase_herida contucion) (tipo sin_sangrado_visible) (tamanio extensa) (zona riesgosa))
	=>
	(printout lesionesTarget "Llamar a un médico"))


(defrule MAIN::sangrado_22
	(sangrado (clase_herida contucion) (tipo sin_sangrado_visible) (tamanio extensa) (zona no_riesgosa))
	=>
	(printout lesionesTarget "Llamar a un médico"))

