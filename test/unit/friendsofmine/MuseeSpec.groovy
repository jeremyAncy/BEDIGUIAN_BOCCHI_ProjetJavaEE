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
    void "test la validite d'un musée valide"( String unNomMusee,String untelMusee,String unaccesMetro,String unaccesBus,String unhorairesMusee){

        given: "un musée initialise avec un nom,un telephone,une adresse,un accesMetro,un accesBus, un horaire et un gestionnaire"
        Musee musee = new Musee(nomMusee: unNomMusee, telMusee: untelMusee, accesMetro:unaccesMetro, accesBus:unaccesBus, horairesMusee:unhorairesMusee)

        expect: "le musée est valide"
        musee.validate() == true

        where:
        unNomMusee    | untelMusee | unaccesMetro | unaccesBus | unhorairesMusee
        "Musee" | "0505050505" | "unaccesMetro" | "unaccesBus" | "10:00"

    }

    @Unroll
    void "test l'invalidite d'un musée non valide"(String unNomMusee,String untelMusee,String unaccesMetro,String unaccesBus,String unhorairesMusee) {

        given: "un musée initialise de maniere non valide"
        Musee musee = new Musee(nom: unNomMusee, telMusee: untelMusee, accesMetro:unaccesMetro, accesBus:unaccesBus, horairesMusee:unhorairesMusee)

        expect: "le musée est invalide"
        musee.validate() == false

        where:
        unNomMusee    | untelMusee | unaccesMetro | unaccesBus | unhorairesMusee
        null     | "untelMusee"  | "unaccesMetro" | "unaccesBus" | "unhorairesMusee"
        ""       | "untelMusee"  | "unaccesMetro" | "unaccesBus" | "unhorairesMusee"
        "unNomMusee" | null      | "unaccesMetro" | "unaccesBus" | "unhorairesMusee"
        "unNomMusee" | ""        | "unaccesMetro" | "unaccesBus" | "unhorairesMusee"
        "unNomMusee" | "untelMusee" | ""  | "unaccesBus" | "unhorairesMusee"
        "unNomMusee" | "untelMusee" | null        | "unaccesBus" | "unhorairesMusee"
        "unNomMusee" | "untelMusee" | "unaccesMetro" | "" | "unhorairesMusee"
        "unNomMusee" | "untelMusee" | "unaccesMetro" | null | "unhorairesMusee"
        "unNomMusee"| "untelMusee"  | "unaccesMetro" | "unaccesBus" | null
        "unNomMusee"| "untelMusee"  | "unaccesMetro" | "unaccesBus" | ""



    }
}
