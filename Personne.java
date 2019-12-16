package sample;

public  abstract class Personne {
    public String nom,prenom;
    public Date naissance;

    public Personne(String nom, String prenom, Date naisssance) {
        this.nom = nom;
        this.prenom = prenom;
        this.naissance = naisssance;
    }

    public Personne(String nom, String prenom, String jour, String mois, String anneé) {
        this.nom = nom;
        this.prenom = prenom;
        naissance= new Date(jour,mois,anneé);
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getNaissance() {
        return naissance;
    }

    @Override
    public String toString() {
        return
                "-nom='" + nom + '\'' +
                        ", prenom='" + prenom + '\'' +
                        ", date de naissance: " + naissance ;
    }

    public void afficher(){
        System.out.println(this);
    }
}
