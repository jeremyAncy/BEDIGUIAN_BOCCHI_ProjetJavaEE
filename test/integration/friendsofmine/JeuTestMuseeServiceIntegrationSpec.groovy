package friendsofmine

import spock.lang.*

/**
 * Created by Max on 15/04/2015.
 */

class JeuTestMuseeServiceIntegrationSpec extends Specification {

    JeuTestMuseeService jeuTestMuseeService

    void "test creation jeu de tests pour musées"() {

        given: "une base ne contenant pas de musées"
        Musee.count() == 0

        when: "on crée le jeu de test pour les musées"
        jeuTestMuseeService.createJeuTestFoMusee()

        then: "3 nouveaux musées ont été crées en base"
        Musee.count() == 3


        when: " des musées exitent deja dans la base"
        Musee.count() == 3

        and: "on déclenche à nouveau la création du jeu de test pour musée"
        jeuTestMuseeService.createJeuTestFoMusee()

        then: "aucune nouvelle activité n'est crée"
        Musee.count() == 3

    }
}