package friendsofmine

class Activite {

    String titre
    String descriptif

    static constraints = {
        titre blank: false
        descriptif nullable: true
    }
}
