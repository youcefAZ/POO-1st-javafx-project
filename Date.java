package sample;

public class Date {

    private String jour,mois,anneé;

    public Date(String jour, String mois, String anneé) {
        this.jour = jour;
        this.mois = mois;
        this.anneé = anneé;
    }

    public String getJour() {
        return jour;
    }

    public String getMois() {
        return mois;
    }

    public String getAnneé() {
        return anneé;
    }

    @Override
    public String toString() {
        return
                jour+"/"+mois+"/"+anneé;
    }

    public void afficher(){
        System.out.println(this);
    }
}
