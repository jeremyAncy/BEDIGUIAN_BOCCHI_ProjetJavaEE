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
    void "test la validite d'un musée valide"( String unNomMusee,String untelMusee,String unaccesMetro,String unaccesBus,String unhorairesMusee,Gestionnaire unGestionnaire){

        given: "un musée initialise avec un nom,un telephone,une adresse,un accesMetro,un accesBus, un horaire"
        Musee musee = new Musee(nomMusee: unNomMusee, telMusee: untelMusee, accesMetro:unaccesMetro, accesBus:unaccesBus, horairesMusee:unhorairesMusee ,gestionnaire: unGestionnaire)

        expect: "le musée est valide"
        musee.validate() == true

        where:
        unNomMusee    | untelMusee | unaccesMetro | unaccesBus | unhorairesMusee | unGestionnaire
        "Musee" | "05.05.05.05.05" | "unaccesMetro" | "unaccesBus" | "10:00,19:00" | Mock(Gestionnaire)

    }

    @Unroll
    void "test l'invalidite d'un musée non valide"(String unNomMusee,String untelMusee,String unaccesMetro,String unaccesBus,String unhorairesMusee,Gestionnaire unGestionnaire) {

        given: "un musée initialise de maniere non valide"
        Musee musee = new Musee(nom: unNomMusee, telMusee: untelMusee, accesMetro:unaccesMetro, accesBus:unaccesBus, horairesMusee:unhorairesMusee, gestionnaire: unGestionnaire)

        expect: "le musée est invalide"
        musee.validate() == false

        where:
        unNomMusee    | untelMusee | unaccesMetro | unaccesBus | unhorairesMusee | unGestionnaire
        null     | "05.05.05.05.05"  | "unaccesMetro" | "unaccesBus" | "10:00,19:00" | Mock(Gestionnaire)
        ""       | "05.05.05.05.05"  | "unaccesMetro" | "unaccesBus" | "10:00,19:00" | Mock(Gestionnaire)
        "unNomMusee" | null      | "unaccesMetro" | "unaccesBus" | "10:00,19:00" | Mock(Gestionnaire)
        "unNomMusee" | ""        | "unaccesMetro" | "unaccesBus" | "10:00,19:00" | Mock(Gestionnaire)
        "unNomMusee" | "05.05.05.05.05" | ""  | "unaccesBus" | "10:00,19:00" | Mock(Gestionnaire)
        "unNomMusee" | "05.05.05.05.05" | null        | "unaccesBus" | "10:00,19:00" | Mock(Gestionnaire)
        "unNomMusee" | "05.05.05.05.05" | "unaccesMetro" | "" | "10:00,19:00" | Mock(Gestionnaire)
        "unNomMusee" | "05.05.05.05.05" | "unaccesMetro" | null | "10:00,19:00" | Mock(Gestionnaire)
        "unNomMusee"| "05.05.05.05.05"  | "unaccesMetro" | "unaccesBus" | null | Mock(Gestionnaire)
        "unNomMusee"| "05.05.05.05.05"  | "unaccesMetro" | "unaccesBus" | "" | Mock(Gestionnaire)
        "unNomMusee"| "05.05.05.05.05"  | "unaccesMetro" | "unaccesBus" | "10:00,19:00" | null



    }
}
