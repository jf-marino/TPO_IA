(deftemplate MAIN::escena
   (slot cantidad_victimas)
   (slot curioso_presente (allowed-values si no))
   (slot seguridad (allowed-values segura peligro_derrumbe olor_extranio transito humo fuego otro))
   (slot acceso_victima (allowed-values facil dificil))
   (slot DEA (allowed-values no_presente presente_cargado presente_descargado)))

(deftemplate MAIN::victima
	(slot edad (allowed-values bebe ninio adulto))
	(slot conciencia (allowed-values alerta responde_a_estimulo_verbal responde_a_estimulo_doloroso inconciente))
	(slot respiracion (allowed-values no_respira respira_rapido respira_normal respira_lento))
	(slot temperatura (allowed-values hipotermia normal hipertermia))
	(slot epilepsia (allowed-values si no))
	(slot obstruccion_via_aerea (allowed-values habla tose no_respira))
	(slot comio (allowed-values si no))
	(slot diabetes (allowed-values si no))
	(slot insulino_dependiente (allowed-values si_y_aplico_insulina si_y_no_aplico_insulina no))
	(slot crisis_diabetica (allowed-values si no)))
	
(deftemplate MAIN::lesion
	(slot tipo (allowed-values quemadura lesion_osteo_articular obstruccion_via_aerea lesion_corto_punzante))
	(slot ubicacion (allowed-values no_tiene piernas brazos torso espalda cabeza manos_o_pies genitales)))
	
(deftemplate MAIN::quemadura
	(slot profundidad (allowed-values superficial profunda))
	(slot tejido_necroso (allowed-values si no))
	(slot dolor (allowed-values indoloro dolor_leve dolor_grave dolor_moderado))
	(slot inflamacion (allowed-values si no))
	(slot tamanio (allowed-values pequenia media extensa))
	(slot tipo (allowed-values externa interna))
	(slot zona (allowed-values riesgosa no_riesgosa)))
	
(deftemplate MAIN::lesion_osteo_muscular
	(slot clase (allowed-values fractura fisura esguince calambre desgarro torcedura))
	(slot afeccion_partes_blandas (allowed-values hematoma inflamacion no))
	(slot afeccion_partes_oseas (allowed-values fractura_expuesta fractura_cerrada))
	(slot zona (allowed-values riesgosa no_riesgosa)))
	
(deftemplate MAIN::via_aerea
	(slot estado (allowed-values no_obstruida semi_obstruida obstruida))
	(slot cianosis (allowed-values si no)))
	
(deftemplate MAIN::sangrado
	(slot clase_herida (allowed-values cortante punzante laceracion contucion arma_de_fuego raspadura))
	(slot profundidad (allowed-values superficial moderado profundo))
	(slot objeto_extranio (allowed-values si no))
	(slot tamanio (allowed-values pequenia media extensa))
	(slot amputacion (allowed-values si no))
	(slot tipo (allowed-values sin_sangrado_visible sangrado_lento sangrado_abundante sangrado_interno))
	(slot zona (allowed-values riesgosa no_riesgosa)))
	
(deftemplate MAIN::convulsion
	(slot estado (allowed-values si no se_detuvo))
	(slot epilepsia (allowed-values si no))
	(slot duracion)
	(slot ciclica (allowed-values si no))
	(slot medicacion (allowed-values tomo no_tomo no_usa))
	(slot fiebre (allowed-values si no)))

	
	
	
	
; Reglas de escena

(defrule MAIN::escena_1
   (escena (cantidad_victimas ?x&:(> ?x 1)))
   =>
   ; TODO
   (printout escenaTarget "" crlf))

(defrule MAIN::escena_2
   (or  (escena (seguridad peligro_derrumbe))
        (escena (seguridad olor_extranio)))
   =>
   (printout escenaTarget "1" crlf))

(defrule MAIN::escena_3
   (escena (seguridad transito))
   =>
   ; TODO
   (printout escenaTarget "" crlf))

(defrule MAIN::escena_4
   (and (or  (escena (seguridad humo))
             (escena (seguridad fuego))))
   (escena (acceso_victima facil))
   =>
   (printout escenaTarget "1" crlf))

(defrule MAIN::escena_5
   (and (or  (escena (seguridad humo))
             (escena (seguridad fuego))))
   (escena (acceso_victima dificil))
   =>
   (printout escenaTarget "1" crlf))
   
(defrule MAIN::escena_6
   (escena (seguridad segura))
   =>
   (printout escenaTarget "" crlf))

   
   
   
   
   
   
; Reglas de victima

(defrule MAIN::victima_15
	(victima (temperatura hipertermia))
	=>
	(printout victimaTarget "21" crlf))

(defrule MAIN::victima_16
	(victima (temperatura hipotermia))
	=>
	(printout victimaTarget "20" crlf))

(defrule MAIN::victima_1
	(victima (diabetes si))
	=>
	(printout victimaTarget "19" crlf))

(defrule MAIN::victima_2
	(victima (diabetes si) (conciencia inconciente) (comio no) (crisis_diabetica si))
	=>
	(printout victimaTarget "19" crlf))

(defrule MAIN::victima_3
	(victima (diabetes si) (conciencia alerta|responde_a_estimulo_verbal) (insulino_dependiente si_y_no_aplico_insulina) (crisis_diabetica si) (comio si))
	=>
	(printout victimaTarget "19" crlf))


(defrule MAIN::victima_4
	(victima (diabetes si) (conciencia inconciente))
	=>
	(printout victimaTarget "19" crlf))


(defrule MAIN::victima_5
	(victima (conciencia inconciente) (respiracion no_respira) (edad adulto))
	(escena (curioso_presente no))
	=>
	(printout victimaTarget "2" crlf)
	(printout victimaTarget "5" crlf))


(defrule MAIN::victima_6
	(victima (conciencia inconciente) (respiracion no_respira) (edad adulto))
	(escena (curioso_presente si))
	=>
	(printout victimaTarget "2" crlf)
	(printout victimaTarget "5" crlf))


(defrule MAIN::victima_7
	(victima (conciencia inconciente) (respiracion no_respira) (edad adulto))
	(escena (curioso_presente no) (DEA presente_cargado))
	=>
	(printout victimaTarget "2" crlf)
	(printout victimaTarget "5" crlf))


(defrule MAIN::victima_8
	(victima (conciencia inconciente) (respiracion no_respira) (edad adulto))
	(escena (curioso_presente si) (DEA presente_cargado))
	=>
	(printout victimaTarget "2" crlf)
	(printout victimaTarget "5" crlf))


(defrule MAIN::victima_9
	(victima (conciencia inconciente) (respiracion no_respira) (edad bebe))
	(escena (curioso_presente no))
	=>
	(printout victimaTarget "4" crlf))


(defrule MAIN::victima_10
	(victima (conciencia inconciente) (respiracion no_respira) (edad bebe))
	(escena (curioso_presente si))
	=>
	(printout victimaTarget "4" crlf))


(defrule MAIN::victima_11
	(victima (conciencia inconciente) (respiracion no_respira) (edad ninio))
	(escena (curioso_presente si))
	=>
	(printout victimaTarget "3" crlf))


(defrule MAIN::victima_12
	(victima (conciencia inconciente) (respiracion no_respira) (edad ninio))
	(escena (curioso_presente no))
	=>
	(printout victimaTarget "3" crlf)
	(printout victimaTarget "5" crlf))


(defrule MAIN::victima_13
	(victima (conciencia inconciente) (respiracion no_respira) (edad ninio))
	(escena (curioso_presente si) (DEA presente_cargado))
	=>
	(printout victimaTarget "3" crlf)
	(printout victimaTarget "5" crlf))


(defrule MAIN::victima_14
	(victima (conciencia inconciente) (respiracion no_respira) (edad ninio))
	(escena (curioso_presente no) (DEA presente_cargado))
	=>
	(printout victimaTarget "3" crlf)
	(printout victimaTarget "5" crlf))
	
	
	
	
	
	
	
; Reglas lesion

(defrule MAIN::lesion_1
	(lesion (tipo lesion_osteo_articular|lesion_corto_punzante) (ubicacion brazos|piernas|manos_o_pies))
	=>
	(assert (zona riesgosa)))


(defrule MAIN::lesion_2
	(lesion (tipo lesion_osteo_articular|lesion_corto_punzante) (ubicacion cabeza|torso|espalda|genitales))
	=>
	(assert (zona riesgosa)))


(defrule MAIN::lesion_3
	(lesion (tipo quemadura) (ubicacion manos_o_pies|genitales|cabeza|torso|espalda))
	=>
	(assert (zona riesgosa)))


(defrule MAIN::lesion_4
	(lesion (tipo quemadura) (ubicacion brazos|piernas))
	=>
	(assert (zona no_riesgosa)))
	
	
	
	
	
	
	
; Reglas convulsiones

(defrule MAIN::convulsion_1
	(convulsion (estado si))
	=>
	(printout victimaTarget "18" crlf))


(defrule MAIN::convulsion_2
	(convulsion (estado se_detuvo) (epilepsia si) (medicacion tomo))
	(victima (edad adulto))
	=>
	(printout victimaTarget "5" crlf))


(defrule MAIN::convulsion_3
	(convulsion (estado se_detuvo) (fiebre no))
	(victima (edad ninio))
	=>
	(printout victimaTarget "5" crlf))


(defrule MAIN::convulsion_4
	(convulsion (estado se_detuvo) (fiebre si))
	(victima (edad ninio))
	=>
	; TODO
	(printout victimaTarget "" crlf))


(defrule MAIN::convulsion_5
	(convulsion (estado si) (ciclica si))
	(victima (edad adulto))
	=>
	(printout victimaTarget "18" crlf))


(defrule MAIN::convulsion_6
	(convulsion (estado se_detuvo) (duracion ?d&:(>= ?d 2)))
	(victima (edad adulto))
	=>
	(printout lesionesTarget "18" crlf))
	
	
	

	
; Reglas via aerea

(defrule MAIN::via_aerea_9
	(via_aerea (estado semi_obstruida))
	(victima (edad adulto))
	=>
	(printout viaAereaTarget "9" crlf))
	
(defrule MAIN::via_aerea_10
	(via_aerea (estado semi_obstruida))
	(victima (edad ninio))
	=>
	(printout viaAereaTarget "10" crlf))

(defrule MAIN::via_aerea_1
	(via_aerea (estado semi_obstruida))
	(victima (edad adulto|ninio))
	=>
	; TODO
	(printout viaAereaTarget "" crlf))


(defrule MAIN::via_aerea_2
	(via_aerea (estado semi_obstruida))
	(victima (edad bebe))
	=>
	(printout lesionesTarget "Estimular al beb� a toser" crlf))


(defrule MAIN::via_aerea_3
	(via_aerea (estado obstruida) (cianosis si))
	(victima (edad adulto) (conciencia alerta))
	=>
	(printout viaAereaTarget "6" crlf)
	(printout viaAereaTarget "2" crlf)
	(printout viaAereaTarget "5" crlf))


(defrule MAIN::via_aerea_4
	(via_aerea (estado obstruida) (cianosis si))
	(victima (conciencia inconciente) (edad adulto))
	=>
	(printout viaAereaTarget "2" crlf)
	(printout viaAereaTarget "5" crlf))


(defrule MAIN::via_aerea_5
	(via_aerea (estado obstruida) (cianosis si))
	(victima (conciencia alerta) (edad ninio))
	=>
	(printout viaAereaTarget "7" crlf)
	(printout viaAereaTarget "3" crlf)
	(printout viaAereaTarget "5" crlf))


(defrule MAIN::via_aerea_6
	(via_aerea (estado obstruida) (cianosis si))
	(victima (conciencia inconciente) (edad ninio))
	=>
	(printout viaAereaTarget "3" crlf)
	(printout viaAereaTarget "5" crlf))


(defrule MAIN::via_aerea_7
	(via_aerea (estado obstruida) (cianosis si))
	(victima (conciencia alerta) (edad bebe))
	=>
	(printout viaAereaTarget "8" crlf)
	(printout viaAereaTarget "4" crlf)
	(printout viaAereaTarget "5" crlf))


(defrule MAIN::via_aerea_8
	(via_aerea (estado obstruida) (cianosis si))
	(victima (conciencia inconciente) (edad bebe))
	=>
	(printout viaAereaTarget "4" crlf)
	(printout viaAereaTarget "5" crlf))
	
	
	

	
	
	
; Reglas sangrado

(defrule MAIN::sangrado_1
	(sangrado (clase_herida ?x) (amputacion si))
	=>
	; TODO media 17 �?
	(printout sangradoTarget "17" crlf))


(defrule MAIN::sangrado_2
	(sangrado (clase_herida arma_de_fuego))
	(zona riesgosa)
	=>
	; TODO
	(printout sangradoTarget "" crlf))


(defrule MAIN::sangrado_3
	(sangrado (clase_herida arma_de_fuego) (tipo sangrado_lento))
	(zona no_riesgosa)
	=>
	; TODO
	(printout sangradoTarget "" crlf))


(defrule MAIN::sangrado_4
	(sangrado (clase_herida laceracion) (profundidad profundo|moderado) (objeto_extranio no) (tamanio media|extensa))
	=>
	; TODO media 17 �?
	(printout sangradoTarget "17" crlf))


(defrule MAIN::sangrado_5
	(sangrado (clase_herida laceracion) (profundidad superficial) (tamanio pequenia) (objeto_extranio no))
	(zona no_riesgosa)
	=>
	; TODO media 17 �?
	(printout sangradoTarget "17" crlf))


(defrule MAIN::sangrado_6
	(sangrado (clase_herida laceracion) (profundidad moderado|profundo) (tamanio pequenia) (objeto_extranio no))
	(zona riesgosa)
	=>
	; TODO media 17 �?
	(printout sangradoTarget "17" crlf))


(defrule MAIN::sangrado_7
	(sangrado (clase_herida laceracion) (objeto_extranio no))
	=>
	; TODO media 17 �?
	(printout sangradoTarget "17" crlf))


(defrule MAIN::sangrado_8
	(sangrado (clase_herida punzante) (tamanio media) (tipo sangrado_interno|sin_sangrado_visible) (objeto_extranio si))
	(zona riesgosa)
	=>
	; TODO
	(printout sangradoTarget "" crlf))


(defrule MAIN::sangrado_9
	(sangrado (clase_herida punzante) (tamanio pequenia) (tipo sangrado_interno|sin_sangrado_visible) (objeto_extranio si))
	(zona no_riesgosa)
	=>
	; TODO
	(printout sangradoTarget "" crlf))


(defrule MAIN::sangrado_10
	(sangrado (clase_herida punzante) (tamanio pequenia) (tipo sangrado_interno|sin_sangrado_visible) (objeto_extranio si))
	(zona riesgosa)
	=>
	; TODO
	(printout sangradoTarget "" crlf))


(defrule MAIN::sangrado_11
	(sangrado (clase_herida punzante) (tamanio pequenia) (tipo sangrado_interno|sin_sangrado_visible) (objeto_extranio no))
	=>
	(printout sangradoTarget "13" crlf))


(defrule MAIN::sangrado_12
	(sangrado (clase_herida punzante) (tamanio pequenia) (tipo sangrado_lento|sangrado_abundante) (objeto_extranio no))
	=>
	(printout sangradoTarget "13" crlf))


(defrule MAIN::sangrado_13
	(sangrado (clase_herida cortante) (profundidad profundo) (tipo sangrado_abundante) (objeto_extranio no) (tamanio media|extensa))
	(zona riesgosa)
	=>
	(printout sangradoTarget "13" crlf))


(defrule MAIN::sangrado_14
	(sangrado (clase_herida cortante) (profundidad profundo) (tipo sangrado_abundante) (objeto_extranio no) (tamanio media|extensa))
	(zona no_riesgosa)
	=>
	(printout sangradoTarget "13" crlf)
	(printout sangradoTarget "17" crlf))


(defrule MAIN::sangrado_15
	(sangrado (clase_herida cortante) (profundidad profundo) (tipo sangrado_abundante) (objeto_extranio no) (tamanio pequenia))
	=>
	(printout sangradoTarget "13" crlf))


(defrule MAIN::sangrado_16
	(sangrado (clase_herida cortante) (profundidad superficial) (tipo sangrado_abundante) (objeto_extranio no) (tamanio pequenia))
	=>
	(printout sangradoTarget "13" crlf)
	(printout sangradoTarget "17" crlf))


(defrule MAIN::sangrado_17
	(sangrado (clase_herida cortante) (tipo sangrado_lento) (objeto_extranio no) (tamanio pequenia|media))
	=>
	(printout sangradoTarget "13" crlf))


(defrule MAIN::sangrado_18
	(sangrado (clase_herida raspadura) (tipo sangrado_lento|sin_sangrado_visible) (objeto_extranio no) (tamanio pequenia|media))
	=>
	(printout sangradoTarget "13" crlf))


(defrule MAIN::sangrado_19
	(sangrado (clase_herida raspadura) (tipo sangrado_lento|sin_sangrado_visible) (objeto_extranio no) (tamanio extensa))
	=>
	(printout sangradoTarget "13" crlf))


(defrule MAIN::sangrado_20
	(sangrado (clase_herida contucion) (tipo sin_sangrado_visible) (tamanio pequenia))
	=>
	; TODO
	(printout sangradoTarget "" crlf))


(defrule MAIN::sangrado_21
	(sangrado (clase_herida contucion) (tipo sin_sangrado_visible) (tamanio extensa))
	(zona riesgosa)
	=>
	; TODO
	(printout sangradoTarget "" crlf))


(defrule MAIN::sangrado_22
	(sangrado (clase_herida contucion) (tipo sin_sangrado_visible) (tamanio extensa))
	(zona no_riesgosa)
	=>
	; TODO
	(printout sangradoTarget "" crlf))
	
	
	
	
	
	
	
	
; Reglas quemaduras
	
(defrule MAIN::quemadura_1
	(lesion (tipo quemadura))
	(quemadura (inflamacion si))
	=>
	; TODO
	(printout quemadurasTarget "" crlf))


(defrule MAIN::quemadura_2
	(lesion (tipo quemadura))
	(quemadura (tipo externa) (tejido_necroso si))
	=>
	; TODO
	(printout quemadurasTarget "" crlf))


(defrule MAIN::quemadura_3
	(lesion (tipo quemadura))
	(quemadura (tipo interna))
	=>
	; TODO
	(printout quemadurasTarget "" crlf))


(defrule MAIN::quemadura_4
	(lesion (tipo quemadura))
	(quemadura (tipo externa) (tejido_necroso no) (tamanio extensa) (profundidad profunda) (dolor indoloro))
	(zona riesgosa)
	=>
	; TODO
	(printout quemadurasTarget "" crlf))


(defrule MAIN::quemadura_5
	(lesion (tipo quemadura))
	(quemadura (tipo externa) (tejido_necroso no) (tamanio extensa) (profundidad profunda) (dolor indoloro))
	(zona no_riesgosa)
	=>
	; TODO
	(printout quemadurasTarget "" crlf))


(defrule MAIN::quemadura_6
	(lesion (tipo quemadura))
	(quemadura (tipo externa) (tejido_necroso no) (tamanio media|pequenia) (profundidad profunda) (dolor indoloro))
	=>
	; TODO
	(printout quemadurasTarget "" crlf))


(defrule MAIN::quemadura_7
	(lesion (tipo quemadura))
	(quemadura (tipo externa) (tejido_necroso no) (tamanio extensa) (profundidad superficial) (dolor dolor_grave))
	(zona riesgosa)
	=>
	; TODO
	(printout quemadurasTarget "" crlf))


(defrule MAIN::quemadura_8
	(lesion (tipo quemadura))
	(quemadura (tamanio extensa) (tipo externa) (profundidad superficial) (tejido_necroso no) (dolor dolor_grave))
	(zona no_riesgosa)
	=>
	; TODO
	(printout quemadurasTarget "" crlf))


(defrule MAIN::quemadura_9
	(lesion (tipo quemadura))
	(quemadura (tamanio media|pequenia) (tipo externa) (profundidad superficial) (tejido_necroso no) (dolor dolor_moderado))
	=>
	; TODO
	(printout quemadurasTarget "" crlf))
	
	
	
	
	
	
; Reglas lesion osteo-muscular

(defrule MAIN::lesion_osteo_muscular_1
	(lesion_osteo_muscular (clase fractura) (afeccion_partes_blandas inflamacion) (afeccion_partes_oseas fractura_expuesta))
	(zona no_riesgosa)
	=>
	; TODO
	(printout lesionOsteoMuscularTarget "" crlf))


(defrule MAIN::lesion_osteo_muscular_2
	(lesion_osteo_muscular (clase fractura) (afeccion_partes_oseas fractura_cerrada))
	(zona riesgosa)
	=>
	; TODO
	(printout lesionOsteoMuscularTarget "" crlf))


(defrule MAIN::lesion_osteo_muscular_3
	(lesion_osteo_muscular (clase fractura) (afeccion_partes_oseas fractura_cerrada) (afeccion_partes_blandas inflamacion))
	(zona riesgosa)
	=>
	; TODO
	(printout lesionOsteoMuscularTarget "" crlf))


(defrule MAIN::lesion_osteo_muscular_4
	(lesion_osteo_muscular (clase fisura|esguince) (afeccion_partes_oseas fractura_cerrada) (afeccion_partes_blandas inflamacion))
	(zona no_riesgosa)
	=>
	; TODO
	(printout lesionOsteoMuscularTarget "" crlf))


(defrule MAIN::lesion_osteo_muscular_5
	(lesion_osteo_muscular (clase fisura|esguince) (afeccion_partes_oseas fractura_cerrada) (afeccion_partes_blandas inflamacion))
	(zona riesgosa)
	=>
	; TODO
	(printout lesionOsteoMuscularTarget "" crlf))


(defrule MAIN::lesion_osteo_muscular_6
	(lesion_osteo_muscular (clase fisura|esguince) (afeccion_partes_oseas fractura_cerrada) (afeccion_partes_blandas no))
	(zona riesgosa)
	=>
	; TODO
	(printout lesionOsteoMuscularTarget "" crlf))


(defrule MAIN::lesion_osteo_muscular_7
	(lesion_osteo_muscular (clase desgarro|torcedura) (afeccion_partes_oseas fractura_cerrada) (afeccion_partes_blandas inflamacion))
	(zona no_riesgosa)
	=>
	; TODO
	(printout lesionOsteoMuscularTarget "" crlf))


(defrule MAIN::lesion_osteo_muscular_8
	(lesion_osteo_muscular (clase calambre))
	=>
	; TODO
	(printout lesionOsteoMuscularTarget "" crlf))






