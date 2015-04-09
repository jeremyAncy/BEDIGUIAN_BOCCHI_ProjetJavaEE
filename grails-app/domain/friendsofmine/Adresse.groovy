package friendsofmine

class Adresse {

    String numero
    String rue
    String codePostal
    String ville


    String toString() {
        "$numero, $rue, $codePostal, $ville"
    }

    static constraints = {
        numero nullable: false, blank: false
        rue nullable: false, blank: false
        codePostal nullable: false
        ville nullable: false, blank: false
    }
}
