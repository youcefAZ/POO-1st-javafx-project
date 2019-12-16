package sample;

public class Enseignant extends sample.Personne {

    private String module,grade;
    public String spec;

    public Enseignant(String nom, String prenom, sample.Date naissance, String module, String grade, String spec) {
        super(nom, prenom,naissance);
        this.module = module;
        this.grade = grade;
        this.spec = spec;
    }

    public String getModule() {
        return module;
    }

    public String getGrade() {
        return grade;
    }

    public String getSpec() {
        return spec;
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
    public sample.Date getNaissance() {
        return super.getNaissance();
    }

    @Override
    public String toString() {
        return super.toString() +
                "module='" + module + '\'' +
                ", grade='" + grade + '\'' +
                ", spec=" + spec;
    }

    public void afficher(){
        System.out.println(this);
    }

}
