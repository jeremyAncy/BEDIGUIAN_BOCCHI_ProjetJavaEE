import friendsofmine.JeuTestService
import friendsofmine.Utilisateur

class BootStrap {

    JeuTestService jeuTestService

    def init = { servletContext ->

        try {
            new Utilisateur(nom: "Dupond", prenom: "Jeanne", sexe: "F", email: "jd@jd.com", dateNaissance: new Date(1972, 06, 17)).save()
            new Utilisateur(nom: "Dupond", prenom: "Jacques", sexe: "M", email: "jad@jad.com", dateNaissance: new Date(1973, 06, 17)).save()
            throw new Exception("Exception in creation utilisateurs")
            new Utilisateur(nom: "Durand", prenom: "Viviana", sexe: "F", email: "viv@viv.com", dateNaissance: new Date(1990, 06, 17)).save()
        } catch(Exception e) {
            log.error(e.message)
        }

        try {
            jeuTestService.createJeuTestFoActivite()
        } catch (Exception e) {
            log.error(e.message)
        }

    }
    def destroy = {
    }
}
