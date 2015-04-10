package friendsofmine

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Musee)
class MuseeSpec extends Specification {

    @Unroll
    void "test la validite d'un musée valide"( String unNomMusee,String untelMusee,String unaccesMetro,String unaccesBus,String unhorairesMusee, Adresse uneAdresse){

        given: "un musée initialise avec un nom,un telephone,une adresse,un accesMetro,un accesBus, un horaire et un gestionnaire"
        Musee musee = new Musee(nomMusee: unNomMusee, telMusee: untelMusee, accesMetro:unaccesMetro, accesBus:unaccesBus, horairesMusee:unhorairesMusee, adresseMusee: uneAdresse)

        expect: "le musée est valide"
        musee.validate() == true

        where:
        unNomMusee    | untelMusee | unaccesMetro | unaccesBus | unhorairesMusee | uneAdresse
        "Musee" | "0505050505" | "unaccesMetro" | "unaccesBus" | "10:00"         | Mock(Adresse)

    }

    @Unroll
    void "test l'invalidite d'un musée non valide"(String unNomMusee,String untelMusee,String unaccesMetro,String unaccesBus,String unhorairesMusee, Adresse uneAdresse) {

        given: "un musée initialise de maniere non valide"
        Musee musee = new Musee(nom: unNomMusee, telMusee: untelMusee, accesMetro:unaccesMetro, accesBus:unaccesBus, horairesMusee:unhorairesMusee, adresseMusee: uneAdresse)

        expect: "le musée est invalide"
        musee.validate() == false

        where:
        unNomMusee   | untelMusee    | unaccesMetro   | unaccesBus   |  unhorairesMusee       | uneAdresse
        null         | "untelMusee"  | "unaccesMetro" | "unaccesBus" | "unhorairesMusee"      | Mock(Adresse)
        ""           | "untelMusee"  | "unaccesMetro" | "unaccesBus" | "unhorairesMusee"      | Mock(Adresse)
        "unNomMusee" | null          | "unaccesMetro" | "unaccesBus" | "unhorairesMusee"      | Mock(Adresse)
        "unNomMusee" | ""            | "unaccesMetro" | "unaccesBus" | "unhorairesMusee"      | Mock(Adresse)
        "unNomMusee" | "untelMusee"  | ""             | "unaccesBus" | "unhorairesMusee"      | Mock(Adresse)
        "unNomMusee" | "untelMusee"  | null           | "unaccesBus" | "unhorairesMusee"      | Mock(Adresse)
        "unNomMusee" | "untelMusee"  | "unaccesMetro" | ""           | "unhorairesMusee"      | Mock(Adresse)
        "unNomMusee" | "untelMusee"  | "unaccesMetro" | null         | "unhorairesMusee"      | Mock(Adresse)
        "unNomMusee" | "untelMusee"  | "unaccesMetro" | "unaccesBus" |  null                  | Mock(Adresse)
        "unNomMusee" | "untelMusee"  | "unaccesMetro" | "unaccesBus" |  ""                    | Mock(Adresse)
        "unNomMusee" | "untelMusee"  | "unaccesMetro" | "unaccesBus" | "unhorairesMusee"      | null



    }
}
