import friendsofmine.Adresse
import friendsofmine.Gestionnaire
import friendsofmine.JeuTestMuseeService
import friendsofmine.JeuTestService
import friendsofmine.Musee
import friendsofmine.Utilisateur

class BootStrap {

    JeuTestMuseeService jeuTestMuseeService

    def init = { servletContext ->

        jeuTestMuseeService.createJeuTestFoMusee()

    }
    def destroy = {
    }
}
