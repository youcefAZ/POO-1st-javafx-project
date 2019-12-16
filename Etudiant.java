package sample;

public class Etudiant extends sample.Personne {
    private int mat;
    private static int matricule=0000;
    public String spec;

    public Etudiant(String nom, String prenom, Date naisssance, String specialite) {
        super(nom, prenom, naisssance);
        matricule++;
        mat=matricule;
        spec= specialite;
    }

    public Etudiant(String nom, String prenom, String jour, String mois, String anneé, String specialite) {
        super(nom, prenom, jour, mois, anneé);
        matricule++;
        mat=matricule;
        spec=specialite;
    }


    public String getSpec() {
        return spec;
    }

    public int getMat() {
        return mat;
    }

    @Override
    public String getNom() {
        return super.getNom();
    }

    @Override
    public String getPrenom() {
        return super.getPrenom();
    }

    @Override
    public Date getNaissance() {
        return super.getNaissance();
    }

    @Override
    public String toString() {
        return super.toString() +
                " matricule=" + mat+", Section : "+spec+"\n" ;
    }

    public void afficher(){
        System.out.println(this);
    }

}
