package friendsofmine

import grails.transaction.Transactional

@Transactional
class MuseeService {

    /**
     *
     * @param unMusee
     * @param unGestionnaire
     * @return un Musee
     */
    Musee insertOrUpdateMuseeForGestionnaire(Musee unMusee, Gestionnaire unGestionnaire) {
        unGestionnaire.save()
        unGestionnaire.addToMusees(unMusee)
        unMusee.save()
        unMusee
    }

    /**
     * Supprime une musée
     * @param uneActivite l'activite à supprimer
     */
    void deleteMusee(Musee unMusee) {
        unMusee.gestionnaire.removeFromMusees(unMusee)
        unMusee.delete()
    }

}
