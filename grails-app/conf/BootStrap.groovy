import friendsofmine.Utilisateur

class BootStrap {

    def init = { servletContext ->

        new Utilisateur(nom: "Dupond", prenom:"Jeanne", sexe:"F", email: "jd@jd.com",dateNaissance: new Date(1972,06,17)).save()
        new Utilisateur(nom: "Dupond", prenom:"Jacques", sexe:"M", email: "jad@jad.com",dateNaissance: new Date(1973,06,17)).save()
        new Utilisateur(nom: "Durand", prenom:"Viviana", sexe:"F", email: "viv@viv.com",dateNaissance: new Date(1990,06,17)).save()

    }
    def destroy = {
    }
}
