package friendsofmine

import org.hibernate.SessionFactory

//import grails.transaction.Transactional
import org.springframework.transaction.annotation.Transactional

@Transactional
class ActiviteService {

    SessionFactory sessionFactory

    /**
     * Cree une nouvelle activite
     * @param unResponsable le responsable de l'activité
     * @param unTitre le titre
     * @param unDescriptif le descriptif
     * @return l'activité créée
     */
    Activite insertOrUpdateActiviteForResponsable(Activite uneActivite, Utilisateur unResponsable) {
        uneActivite.responsable = unResponsable
        uneActivite.save()
        uneActivite
    }
}
