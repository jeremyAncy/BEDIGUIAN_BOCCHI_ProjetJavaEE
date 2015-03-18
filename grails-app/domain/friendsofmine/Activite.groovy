package friendsofmine

class Activite {

    String titre
    String descriptif

    Utilisateur responsable

    static constraints = {
        titre blank: false
        descriptif nullable: true
    }
}
