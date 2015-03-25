package friendsofmine

import grails.transaction.Transactional

@Transactional
class InscriptionService {

    /**
     * Insert ou update une inscription
     * @param inscription
     * @return l'inscription
     */
    Inscription insertOrUpdateInscription(Inscription inscription) {
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
