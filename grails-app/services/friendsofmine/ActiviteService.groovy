package friendsofmine

import org.hibernate.SessionFactory

//import grails.transaction.Transactional
import org.springframework.transaction.annotation.Transactional

@Transactional
class ActiviteService {

    /**
     * Cree une nouvelle activite
     * @param unResponsable le responsable de l'activité
     * @param unTitre le titre
     * @param unDescriptif le descriptif
     * @return l'activité créée
     */
    Activite insertOrUpdateActiviteForResponsable(Activite uneActivite, Utilisateur unResponsable) {
        unResponsable.addToActivites(uneActivite)
        unResponsable.save()
        uneActivite
    }

    /**
     * Supprime une activité
     * @param uneActivite l'activite à supprimer
     */
    void deleteActivite(Activite uneActivite) {
        uneActivite.responsable.removeFromActivites(uneActivite)
        uneActivite.delete()
    }
}
