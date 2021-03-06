package friendsofmine

class Adresse {

    String numero
    String rue
    String codePostal
    String ville

    static constraints = {
        numero nullable: false, blank: false
        rue nullable: false, blank: false
        codePostal nullable: false
        ville nullable: false, blank: false
    }

    String toString() {
        "$numero $rue"
    }
}
