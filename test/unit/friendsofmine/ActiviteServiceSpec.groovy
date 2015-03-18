package friendsofmine

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(ActiviteService)
@Mock(Activite)
class ActiviteServiceSpec extends Specification {

    ActiviteService activiteService = new ActiviteService()

    void "test insert ou update d'une activite pour un responsable"() {

        given: "un responsable et une activite"
        Utilisateur unResponsable = Mock(Utilisateur)
        Activite uneActivite = Mock(Activite)

        when: "on insert ou met à jour l'activité pour le responsable"
        Activite resultActivite = activiteService.insertOrUpdateActiviteForResponsable(uneActivite,unResponsable)

        then: "l'activité modifiée est retournée"
        resultActivite == uneActivite

        and: "le responsable est bien affecté à l'activité"
        1 * uneActivite.setResponsable(unResponsable)

        and: "la methode save() sur l'activite a bien été invoquée"
        1 * uneActivite.save()

    }
}
