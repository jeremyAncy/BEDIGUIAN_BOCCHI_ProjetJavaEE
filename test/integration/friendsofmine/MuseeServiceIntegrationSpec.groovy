package friendsofmine


import spock.lang.*

/**
 * Created by JeremyBocchi on 09/04/2015.
 */
class MuseeServiceIntegrationSpec extends Specification {

    MuseeService museeService
    JeuTestMuseeService jeuTestMuseeService

    void "test insertion ou mise à jour d'un musee avec gestionnaire"() {

        given: "un musee"
        Adresse adresse = new Adresse(numero: "03", rue: "Grande Rue", codePostal: "31400", ville: "Toulouse")
        adresse.save()
        Musee unMusee = new Musee(nomMusee: "Musée 1", telMusee: "05.05.05.05.05", accesMetro: "Jean Jaures", accesBus: "Jean Jaures", horairesMusee: "10:00,19:00", adresseMusee: adresse)

        and: "un gestionnaire"
        Gestionnaire unGestionnaire = new Gestionnaire(nomGestionnaire: "Dupont")

        when: "on tente de répercuter en base la création ou la modification du musée"
        Musee resultMusee = museeService.insertOrUpdateMuseeForGestionnaire(unMusee, unGestionnaire)

        then: "le musée resultante pointe sur le musée initale"
        resultMusee == unMusee

        and: "le musée résultante n'a pas d'erreur"
        !resultMusee.hasErrors()

        and: "le musée résultante a un id"
        resultMusee.id

        and: "le musée est bien presente en base"
        Musee.findById(resultMusee.id) != null

        and: "le musée a pour gestionnaire le gestionnaire passé en paramètre"
        resultMusee.gestionnaire == unGestionnaire

        and: "le gestionnaire a dans sa liste de musée le musée passé en paramètre"
        unGestionnaire.musees.contains(resultMusee)
    }

    void "test suppression d'un musée"() {

        given: "un musée existante en base"
        Adresse adresse = new Adresse(numero: "03", rue: "Grande Rue", codePostal: "31400", ville: "Toulouse")
        adresse.save()
        Musee unMusee = new Musee(nomMusee: "Musée 1",telMusee:"05050505",accesMetro:"Jean Jaures",accesBus:"Jean Jaures" ,horairesMusee:"10:00,19:00", adresseMusee: adresse)
        Gestionnaire unGestionnaire = new Gestionnaire(nomGestionnaire: "Dupont")
        unMusee = museeService.insertOrUpdateMuseeForGestionnaire(unMusee,unGestionnaire)
        when:"on tente de supprimer l'activité"
        museeService.deleteMusee(unMusee)

        then:"l'activite n'existe plus en base"
        Musee.findById(unMusee.id) == null

        and:"le responsable n'a plus l'activite dans sa liste d'activité"
        !unGestionnaire.musees.contains(unMusee)
    }

    void "test du moteur de recherche sur les musee"() {

        given:"les adresses, les gestionnaires et les musées fournis par le jeu de test "
        jeuTestMuseeService

        when:"on cherche les musées qui contient 'de' dans son nom "
        List<Musee> res = museeService.searchMusees("de",null,null)

        then:"on récupère uniquement les musée 1 et 2"
        res.size() == 2
        res*.id.contains(jeuTestMuseeService.musee1.id)
        res*.id.contains(jeuTestMuseeService.musee2.id)

        when:"on cherche les inscriptions dont le code postal contient 31"
        res = museeService.searchMusees(null,'314',null)

        then:"on récupère uniquement le musee 2"
        res.size() == 1
        res*.id.contains(jeuTestMuseeService.musee2.id)

        when:"on cherche les musées dans lesquels le nom de la rue contient 'etz' "
        res = museeService.searchMusees(null,null,'etz')

        then:"on recupère le musée 1"
        res.size() == 1
        res*.id.contains(jeuTestMuseeService.musee1.id)

        and:"elle sont ordonnées suivant le  nom des musées"
        res*.nomMusee == [jeuTestMuseeService.musee1.nomMusee]

        when:"on cherche les musées dont le code postal contient 310 et donc le nom de la rue contient etz  "
        res = museeService.searchMusees(null,'310','etz')

        then:"on récupère uniquement le musée 1"
        res.size() == 1
        res*.id.contains(jeuTestMuseeService.musee1.id)

        when:"on cherche les musées dont le nom du musée contient 'xor'"
        res = museeService.searchMusees("xor",null,null)

        then: "on ne récupère aucun musée"
        res.size() == 0

        when:"on positionne tous les critères à null"
        res = museeService.searchMusees(null, null, null)

        then: "on récupère tout les musées"
        res.size() == 3

        and:"ils sont ordonnés dans l ordre d initialisation des musées"
        res*.nomMusee == [jeuTestMuseeService.musee1.nomMusee, jeuTestMuseeService.musee2.nomMusee, jeuTestMuseeService.musee3.nomMusee]
    }

    void "test de l'ajout en favoris d'un musée"() {
        given:"la liste des musées favoris et un musée"
        Adresse adresseMusee = new Adresse(numero: 20, rue: "lis Pompidou", codePostal: "81000", ville: "Albi")
        adresseMusee.save()
        Musee unMusee = new Musee(nom: "UnMuséeFav", horairesOuverture: "10:00, 19:00", telephone: "05.63.45.63.36", accesMetro: "Jean Jaurès", accesBus: "Capitole", adresse: adresseMusee)
        List<Musee> ListFav = museeService.museeFav

        when:"on ajoute le musée a cette liste"
        listFav = museeService.addMuseeToFav(unMusee)

        then:"le musée est bien ajouté dans la liste"
        listFav.contains(unMusee)
    }

}
