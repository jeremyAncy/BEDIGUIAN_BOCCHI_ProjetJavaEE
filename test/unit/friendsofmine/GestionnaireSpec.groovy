package friendsofmine

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Gestionnaire)
class GestionnaireSpec extends Specification {

    @Unroll
    void "test la validite d'un gestionnaire valide"(String unNomGestionnaire,  def _) {

        given: "un gestionnaire initialise avec un nom"
        Gestionnaire gestionnaire = new Gestionnaire(nomGestionnaire: unNomGestionnaire)

        expect: "le gestionnaire est valide"
        gestionnaire.validate() == true

        where:
        unNomGestionnaire | _
        "NomGestionnaire" | _
    }

    @Unroll
    void "test la validite d'un gestionnaire non valide"(String unNomGestionnaire, def _) {

        given: "un gestionnaire initialise avec un nom"
        Gestionnaire gestionnaire = new Gestionnaire(nomGestionnaire: unNomGestionnaire)

        expect: "le gestionnaire est invalide"
        gestionnaire.validate() == false

        where:
        unNomGestionnaire | _
        "" | _
        null | _
    }
}
