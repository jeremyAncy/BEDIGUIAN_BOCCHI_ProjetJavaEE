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
    void "test la validite d'un musée valide"( String unNomMusee,String untelMusee,String uneadresseMusee,String unaccesMetro,String unaccesBus,String unhorairesMusee,String ungestionnaireMusee){

        given: "un musée initialise avec un nom,un telephone,une adresse,un accesMetro,un accesBus, un horaire et un gestionnaire"
        Musee musee = new Musee(nom: unNomMusee, telMusee: untelMusee, adresseMusee: uneadresseMusee, accesMetro:unaccesMetro, accesBus:unaccesBus, horairesMusee:unhorairesMusee,gestionnaireMusee:ungestionnaireMusee)

        expect: "le musée est valide"
        musee.validate() == true

        where:
        unNomMusee    | untelMusee | uneadresseMusee | unaccesMetro | unaccesBus | unhorairesMusee | ungestionnaireMusee
        null            | _
        ""              | _
        "un descriptif" | _

    }

    @Unroll
    void "test l'invalidite d'un musée non valide"(String unNomMusee,String untelMusee,String uneadresseMusee,String unaccesMetro,String unaccesBus,String unhorairesMusee,String ungestionnaireMusee) {

        given: "un musée initialise de maniere non valide"
        Musee musee = new Musee(nom: unNomMusee, telMusee: untelMusee, adresseMusee: uneadresseMusee, accesMetro:unaccesMetro, accesBus:unaccesBus, horairesMusee:unhorairesMusee,gestionnaireMusee:ungestionnaireMusee)

        expect: "le musée est invalide"
        musee.validate() == false

        where:
        unNom    | unPrenom  | unEmail     | unSexe
        null     | "Jeanne"  | "jd@jd.com" | "F"
        ''       | "Jeanne"  | "jd@jd.com" | "F"
        "Dupont" | null      | "jd@jd.com" | "F"
        "Durand" | ""        | "jd@jd.com" | "M"
        "Durand" | "Jacques" | "jdjd.com"  | "M"
        "Durand" | "Jacques" | null        | "M"
        "Durand" | "Jacques" | "jd@jd.com" | "Z"
        "Durand" | "Jacques" | "jd@jd.com" | null


    }
}
