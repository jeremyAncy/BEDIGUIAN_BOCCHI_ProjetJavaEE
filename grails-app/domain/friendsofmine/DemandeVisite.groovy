package friendsofmine

class DemandeVisite {

    Date debut
    Date fin
    int nbPersonnes
    String codeDemande

    static constraints = {
        nbPersonnes min:1, max:6
        debut nullable: false
        fin nullable: false
        codeDemande blank: false, nullable: false
    }
}
