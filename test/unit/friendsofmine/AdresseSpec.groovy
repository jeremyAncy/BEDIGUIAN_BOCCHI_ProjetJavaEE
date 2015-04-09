package friendsofmine

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Adresse)
class AdresseSpec extends Specification {

    @Unroll
    void "test la validite d'une adresse valide"(String unNum, String uneRue, String unCP, String uneVille) {

        given: "une adresse initialise correctement"
        Adresse adresse = new Adresse(numero: unNum, rue: uneRue, codePostal: unCP, ville: uneVille)

        expect: "l'adresse est valide"
        adresse.validate() == true

        where:
        unNum    | uneRue           | unCP        | uneVille
        "13"     | "Grande rue"     | "89160"     | "Toulouse"

    }

    @Unroll
    void "test l'invalidite d'une adresse non valide"(String unNum, String uneRue, String unCP, String uneVille) {

        given: "une adresse initialise de maniere non valide"
        Adresse adresse = new Adresse(numero: unNum, rue: uneRue, codePostal: unCP, ville: uneVille)

        expect: "l'adresse est invalide"
        adresse.validate() == false

        where:
        unNum    | uneRue       | unCP        | uneVille
        null     | "Jeanne"     | "89160"       | "Toulouse"
        ""       | "Jeanne"     | "89160"       | "Toulouse"
        "10"       | null         | "89160"       | "Toulouse"
        "10"       | ""           | "89160"       | "Toulouse"
        "10"       | "grande rue" | null        | "Toulouse"
        "10"       | "grande rue" | "jd@jd.com" | ""
        "10"       | "grande rue" | "jd@jd.com" | null

    }
}
