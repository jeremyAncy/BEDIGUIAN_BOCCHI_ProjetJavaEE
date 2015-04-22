package friendsofmine

import grails.transaction.Transactional

@Transactional
class MuseeService {

    List<Musee> museeFav = new ArrayList<Musee>()

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
            if (codeP) {
                adresseMusee {
                    like 'codePostal', "%${codeP}%"
                }
            }
            if (nomAd) {
                adresseMusee {
                    like 'rue', "%${nomAd}%"
                }
            }
        }
        res

    }

    def List<Musee> removeMuseeToFav(Musee musee) {
        def fav = museeFav.iterator()

        while(fav.hasNext()) {
            if(musee.id == fav.next().id)
                fav.remove()
        }

        museeFav.sort {it.nomMusee}
    }

    def List<Musee> addMuseeToFav(Musee musee) {
        museeFav.add(musee)
        museeFav.sort {it.nomMusee}
    }

}
