package friendsofmine

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(DemandeVisite)
class DemandeVisiteSpec extends Specification {

    @Unroll
    void "test la validite d'une demande de visite valide"(Date unDebut, Date unFin, int unNbpersonnes, String unCodeDemande) {

        given: "une demande de visite initialise correctement"
        DemandeVisite demandeVisite = new DemandeVisite(debut: unDebut, fin: unFin, nbPersonnes: unNbpersonnes, codeDemande: unCodeDemande)

        expect: "la demande de visite est valide"
        demandeVisite.validate() == true

        where:
        unDebut          | unFin           | unNbpersonnes        | unCodeDemande
        Mock(Date)       | Mock(Date)      | 5                    | "200A"

    }

    @Unroll
    void "test l'invalidite d'une demande de visite non valide"(Date unDebut, Date unFin, int unNbpersonnes, String unCodeDemande) {

        given: "une demande de visite initialise de maniere non valide"
        DemandeVisite demandeVisite = new DemandeVisite(debut: unDebut, fin: unFin, nbPersonnes: unNbpersonnes, codeDemande: unCodeDemande)

        expect: "la demande de visite est invalide"
        demandeVisite.validate() == false

        where:
        unDebut                     | unFin                      | unNbpersonnes        | unCodeDemande
        null                        | Mock(Date)                 | 5                    | "200A"
        Mock(Date)                  | null                       | 5                    | "200A"
        Mock(Date)                  | Mock(Date)                 | 0                    | "200A"
        Mock(Date)                  | Mock(Date)                 | 7                    | "200A"
        Mock(Date)                  | Mock(Date)                 | 7                    | ""
        Mock(Date)                  | Mock(Date)                 | 7                    | null
    }
}
