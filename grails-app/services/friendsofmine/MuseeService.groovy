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

    /**
     * Cherche les inscriptions correspondant aux critères
     * @param inTitreAct chaîne de caractère présente dans le titre de l'activité
     * @param inNomPrenonResp chaîne de caractère presente dans le nom/prenom du resp
     * @param inNomPrenomUtilisateur chaîne de caractère presente dans le nom/prenom de l'inscrit
     * @return
     */
    List<Musee> searchMusees(String nomM, String codeP, String nomAd) {
        def criteria = Musee.createCriteria()
        List<Musee> res = criteria.list {
            if (nomM) {
                like 'nomMusee', "%${nomM}%"

            }
            if (nomAd) {
                adresse {
                    or {
                        like 'rue', "%${codeP}%"
                    }
                }
            }
            if (codeP) {
                adresse {
                        like 'codePostal', "%${nomAd}%"
                }
            }
            res
        }
    }

}
