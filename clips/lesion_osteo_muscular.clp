(deftemplate MAIN::lesion_osteo_muscular
	(slot clase (allowed-values fractura fisura esguince calambre desgarro torcedura))
	(slot afeccion_partes_blandas (allowed-values hematoma inflamacion no))
	(slot afeccion_partes_oseas (allowed-values fractura_expuesta fractura_cerrada))
	(slot zona (allowed-values riesgosa no_riesgosa)))
	

(defrule MAIN::lesion_osteo_muscular_1
	(lesion_osteo_muscular (clase fractura) (afeccion_partes_blandas inflamacion) (afeccion_partes_oseas fractura_expuesta) (zona no_riesgosa))
	=>
	(printout lesionesTarget "Controlar el sangrado e inmovilizar la zona"))


(defrule MAIN::lesion_osteo_muscular_2
	(lesion_osteo_muscular (clase fractura) (afeccion_partes_oseas fractura_cerrada) (zona riesgosa))
	=>
	(printout lesionesTarget "Llamar al 107 e inmovilizar la zona"))


(defrule MAIN::lesion_osteo_muscular_3
	(lesion_osteo_muscular (clase fractura) (afeccion_partes_oseas fractura_cerrada) (afeccion_partes_blandas inflamacion) (zona riesgosa))
	=>
	(printout lesionesTarget "Inmovilizar la zona y llevarlo a un médico"))


(defrule MAIN::lesion_osteo_muscular_4
	(lesion_osteo_muscular (clase fisura|esguince) (afeccion_partes_oseas fractura_cerrada) (afeccion_partes_blandas inflamacion) (zona no_riesgosa))
	=>
	(printout lesionesTarget "Aplicar hielo, inmovilizar la zona y llevarlo al médico"))


(defrule MAIN::lesion_osteo_muscular_5
	(lesion_osteo_muscular (clase fisura|esguince) (afeccion_partes_oseas fractura_cerrada) (afeccion_partes_blandas inflamacion) (zona riesgosa))
	=>
	(printout lesionesTarget "Aplicar hielo, inmovilizar la zona y llamar a un médico"))


(defrule MAIN::lesion_osteo_muscular_6
	(lesion_osteo_muscular (clase fisura|esguince) (afeccion_partes_oseas fractura_cerrada) (afeccion_partes_blandas no) (zona riesgosa))
	=>
	(printout lesionesTarget "Inmovilizar la zona y llamar a un médico"))


(defrule MAIN::lesion_osteo_muscular_7
	(lesion_osteo_muscular (clase desgarro|torcedura) (afeccion_partes_oseas fractura_cerrada) (afeccion_partes_blandas inflamacion) (zona no_riesgosa))
	=>
	(printout lesionesTarget "Aplicar hielo, inmovilizar la zona y llevarlo a un médico"))


(defrule MAIN::lesion_osteo_muscular_8
	(lesion_osteo_muscular (clase calambre))
	=>
	(printout lesionesTarget "Elongar el músculo y hacer masajes"))

