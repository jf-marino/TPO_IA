(deftemplate MAIN::lesion
	(slot tipo (allowed-values quemadura lesion_osteo_articular obstruccion_via_aerea lesion_corto_punzante))
	(slot ubicacion (allowed-values piernas brazos torso espalda cabeza manos_o_pies genitales)))
	

(defrule MAIN::lesion_1
	(lesion (tipo lesion_osteo_articular|lesion_corto_punzante) (ubicacion brazos|piernas|manos_o_pies))
	=>
	(lesion_osteo_muscular (zona riesgosa)))


(defrule MAIN::lesion_2
	(lesion (tipo lesion_osteo_articular|lesion_corto_punzante) (ubicacion cabeza|torso|espalda|genitales))
	=>
	(lesion_osteo_muscular (zona riesgosa)))


(defrule MAIN::lesion_3
	(lesion (tipo quemadura) (ubicacion manos_o_pies|genitales|cabeza|torso|espalda))
	=>
	(quemadura (zona riesgosa)))


(defrule MAIN::lesion_4
	(lesion (tipo quemadura) (ubicacion brazos|piernas))
	=>
	(quemadura (zona no_riesgosa)))

