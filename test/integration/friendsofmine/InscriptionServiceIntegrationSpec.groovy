package friendsofmine


import spock.lang.*

/**
 *
 */
class InscriptionServiceIntegrationSpec extends Specification {

    Activite uneActivite
    Utilisateur unUtilisateur

    ActiviteService activiteService
    InscriptionService inscriptionService

    def setup() {
        // l'activité
        uneActivite = new Activite(titre: "act1")
        Utilisateur unResponsable = new Utilisateur(nom: "Dupont", prenom: "Jeanne", sexe: "F", email: "j@j.com")
        activiteService.insertOrUpdateActiviteForResponsable(uneActivite, unResponsable)

        // l'utilisateur
        unUtilisateur = new Utilisateur(nom: "Durand", prenom: "paul", sexe: "M", email: "p@j.com").save()
    }

    void "test la création ou la mise à jour d'une inscription"() {

        given: "une inscription"
        Inscription uneInscription = new Inscription(activite: uneActivite, utilisateur: unUtilisateur)


        when: "on insert ou met à jour l'inscription"
        Inscription resInscription = inscriptionService.insertOrUpdateInscription(uneInscription)

        then: "l'inscription isérée est bien celle retournée"
        resInscription == uneInscription

        and:"l'inscription a bien un id"
        uneInscription.id != null

        and:"elle est valide"
        uneInscription.validate()

        and:"elle est bien stockée en base"
        Inscription.findById(uneInscription.id) != null

        and :"les propriétes sont mises à jours comme attendues"
        uneInscription.activite == uneActivite
        uneInscription.utilisateur == unUtilisateur
        uneInscription.dateInscription != null
    }

    void "test de la suppression d'une inscription"() {

        given:"une inscription existante en base"
        Inscription uneInscription = new Inscription(activite: uneActivite, utilisateur: unUtilisateur)
        inscriptionService.insertOrUpdateInscription(uneInscription)

        when:"on déclenche la suppression de l'inscription"
        inscriptionService.deleteInscription(uneInscription)

        then:"l'inscription est supprimée de la base"
        Inscription.findById(uneInscription.id) == null

        and:"ni l'activité, ni l'utilisateur ne sont supprimés"
        Activite.findById(uneActivite.id) != null
        Utilisateur.findById(unUtilisateur.id) != null

    }
}
