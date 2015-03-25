package friendsofmine

import grails.transaction.Transactional

@Transactional
class InscriptionService {

    /**
     * Insert ou update une inscription
     * @param uneActivite une activite
     * @param unUtilisateur un utilsateur
     * @return l'inscription
     */
    Inscription insertOrUpdateInscriptionForActiviteAndUtilisateur(Activite uneActivite, Utilisateur unUtilisateur) {
        Inscription inscription = new Inscription(activite: uneActivite, utilisateur: unUtilisateur)
        inscription.dateInscription = new Date()
        inscription.save(flush: true)
        inscription
    }

    /**
     * Supprime une inscription
     * @param uneInscription l'inscription à supprimer
     */
    void deleteInscription(Inscription uneInscription) {
        uneInscription.delete()
    }
}
