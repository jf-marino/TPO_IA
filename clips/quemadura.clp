(deftemplate MAIN::quemadura
	(slot profundidad (allowed-values superficial profunda))
	(slot tejido_necroso (allowed-values si no))
	(slot dolor (allowed-values indoloro dolor_leve dolor_grave dolor_moderado))
	(slot inflamacion (allowed-values si no))
	(slot tamanio (allowed-values pequenia media extensa))
	(slot tipo (allowed-values externa interna))
	(slot zona (allowed-values riesgosa no_riesgosa)))
	

(defrule MAIN::quemadura_1
	(lesion (tipo quemadura))
	(quemadura (inflamacion si))
	=>
	(printout lesionesTarget "Aflojar la ropa, quitar las joyas que tenga y enfriar la zona"))


(defrule MAIN::quemadura_2
	(lesion (tipo quemadura))
	(quemadura (tipo externa) (tejido_necroso si))
	=>
	(printout lesionesTarget "Llamar a un médico y templar la zona"))


(defrule MAIN::quemadura_3
	(lesion (tipo quemadura))
	(quemadura (tipo interna))
	=>
	(printout lesionesTarget "Llamar a un médico y controlar los signos vitales de la víctima"))


(defrule MAIN::quemadura_4
	(lesion (tipo quemadura))
	(quemadura (tipo externa) (tejido_necroso no) (tamanio extensa) (zona riesgosa) (profundidad profunda) (dolor indoloro))
	=>
	(printout lesionesTarget "Llamar a un médico"))


(defrule MAIN::quemadura_5
	(lesion (tipo quemadura))
	(quemadura (tipo externa) (tejido_necroso no) (tamanio extensa) (zona no_riesgosa) (profundidad profunda) (dolor indoloro))
	=>
	(printout lesionesTarget "Llamar a un médico y enfriar la zona"))


(defrule MAIN::quemadura_6
	(lesion (tipo quemadura))
	(quemadura (tipo externa) (tejido_necroso no) (tamanio media|pequenia) (profundidad profunda) (dolor indoloro))
	=>
	(printout lesionesTarget "Llamar a un médico y enfriar la zona"))


(defrule MAIN::quemadura_7
	(lesion (tipo quemadura))
	(quemadura (tipo externa) (tejido_necroso no) (tamanio extensa) (profundidad superficial) (dolor dolor_grave) (zona riesgosa))
	=>
	(printout lesionesTarget "Enfriar la zona y llamar a un médico"))


(defrule MAIN::quemadura_8
	(lesion (tipo quemadura))
	(quemadura (tamanio extensa) (tipo externa) (zona no_riesgosa) (profundidad superficial) (tejido_necroso no) (dolor dolor_grave))
	=>
	(printout lesionesTarget "Enfríe la zona y llevelo al médico"))


(defrule MAIN::quemadura_9
	(lesion (tipo quemadura))
	(quemadura (tamanio media|pequenia) (tipo externa) (profundidad superficial) (tejido_necroso no) (dolor dolor_moderado))
	=>
	(printout lesionesTarget "Enfriar la zona"))

