package friendsofmine

import grails.transaction.Transactional

@Transactional
class JeuTestService {

    ActiviteService activiteService

    def createJeuTestFoActivite() {
        if (Activite.count() == 0) {
            Utilisateur unResponsable = new Utilisateur(
                    nom: "Dufrene",
                    prenom: "Isabelle",
                    sexe: "F",
                    email: "df@df.org"
            )
            activiteService.insertOrUpdateActiviteForResponsable(new Activite(titre: "Act1"), unResponsable)
            activiteService.insertOrUpdateActiviteForResponsable(new Activite(titre: "Act2"), unResponsable)
            activiteService.insertOrUpdateActiviteForResponsable(new Activite(titre: "Act3"), unResponsable)
        }
    }
}