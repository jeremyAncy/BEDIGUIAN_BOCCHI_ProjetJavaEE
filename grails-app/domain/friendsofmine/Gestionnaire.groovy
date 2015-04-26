package friendsofmine

class Gestionnaire {

    String nomGestionnaire

    static hasMany = [musees:Musee]

    static constraints = {
        nomGestionnaire blank: false, nullable: false
    }

    String toString() {
        "$nomGestionnaire"
    }
}
