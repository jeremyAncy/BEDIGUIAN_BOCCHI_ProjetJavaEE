import friendsofmine.Adresse
import friendsofmine.Gestionnaire
import friendsofmine.JeuTestMuseeService
import friendsofmine.JeuTestService
import friendsofmine.Musee
import friendsofmine.Utilisateur

class BootStrap {

    JeuTestService jeuTestService
    JeuTestMuseeService jeuTestMuseeService

    def init = { servletContext ->

        jeuTestService.createJeuTestForUtilisateurs()
        jeuTestService.createJeuTestFoActivite()
        jeuTestService.createJeuTestForInscription()
        jeuTestMuseeService.createJeuTestFoMusee()

    }
    def destroy = {
    }
}
