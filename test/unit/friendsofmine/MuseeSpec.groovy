package friendsofmine

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Musee)
class MuseeSpec extends Specification {

    @Unroll
    void "test la validite d'un musee valide"(String unTitre, String unDescriptif) {

        given: "une activite initialise avec un titre non vide et un descriptif"
        Activite activite = new Activite(titre: unTitre, descriptif: unDescriptif)

        expect: "l'activite est valide"
        activite.validate() == true

        where:
        unTitre    | unDescriptif
        "un titre" | null
        "un titre" | ""
        "un titre" | "un descriptif"

    }
}
