package friendsofmine

class Musee {

    String nomMusee
    String telMusee
    String accesMetro
    String accesBus
    String horairesMusee

    Gestionnaire gestionnaire

    Adresse adresseMusee

    String toString() {
        "Nom : $nomMusee "
    }

    static constraints = {
        nomMusee blank:false ,nullable:false
        telMusee blank:false ,nullable:false
        accesMetro blank:false ,nullable:false
        accesBus blank:false ,nullable:false
        horairesMusee blank:false ,nullable:false
        gestionnaire nullable: false
    }
}
