package friendsofmine


import spock.lang.*

/**
 * Created by JeremyBocchi on 09/04/2015.
 */
class MuseeServiceIntegrationSpec extends Specification {

    MuseeService museeService

    void "test insertion ou mise à jour d'un musee avec gestionnaire"() {

        given:"un musee"
        Musee unMusee = new Musee(nomMusee: "Musée 1",telMusee:"05.05.05.05.05",accesMetro:"Jean Jaures",accesBus:"Jean Jaures" ,horairesMusee:"10:00,19:00")

        and: "un gestionnaire"
        Gestionnaire unGestionnaire = new Gestionnaire(nomGestionnaire: "Dupont")

        when: "on tente de répercuter en base la création ou la modification du musée"
        Musee resultMusee = museeService.insertOrUpdateActiviteForResponsable(unMusee,unGestionnaire)

        then: "le musée resultante pointe sur le musée initale"
        resultMusee == unMusee

        and:"le musée résultante n'a pas d'erreur"
        !resultMusee.hasErrors()

        and:"le musée résultante a un id"
        resultMusee.id

        and:"le musée est bien presente en base"
        Musee.findById(resultMusee.id) != null

        and: "le musée a pour gestionnaire le gestionnaire passé en paramètre"
        resultMusee.gestionnaire == unGestionnaire

        and:"le gestionnaire a dans sa liste de musée le musée passé en paramètre"
        unGestionnaire.musees.contains(resultMusee)
    }
/*
    void "test suppression d'un musée"() {

        given: "un musée existante en base"
        Musee unMusee = new Musee(nomMusee: "Musée 1",telMusee:"05050505",accesMetro:"Jean Jaures",accesBus:"Jean Jaures" ,horairesMusee:"10:00,19:00")
        Gestionnaire unGestionnaire = new Gestionnaire(nomGestionnaire: "Dupont")
        unMusee = museeService.insertOrUpdateActiviteForResponsable(unMusee,unGestionnaire)

        when:"on tente de supprimer l'activité"
        museeService.deleteMusee(unMusee)

        then:"l'activite n'existe plus en base"
        Musee.findById(unMusee.id) == null

        and:"le responsable n'a plus l'activite dans sa liste d'activité"
        !unGestionnaire.musees.contains(unMusee)
    }
*/
}
