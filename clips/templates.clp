(deftemplate MAIN::escena
   (slot cantidad_victimas)
   (slot curioso_presente (allowed-values si no))
   (slot seguridad (allowed-values segura peligro_derrumbe olor_extranio transito humo fuego otro))
   (slot acceso_victima (allowed-values facil dificil))
   (slot DEA (allowed-values no_presente presente_cargado presente_descargado)))
   
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
	
(deftemplate MAIN::lesion
	(slot tipo (allowed-values quemadura lesion_osteo_articular obstruccion_via_aerea lesion_corto_punzante))
	(slot ubicacion (allowed-values piernas brazos torso espalda cabeza manos_o_pies genitales)))
	
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