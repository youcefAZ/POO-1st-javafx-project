package sample;

import java.util.ArrayList;

public class Specialite  {

    public String nom,filliere,anneé;
    public ArrayList<sample.Etudiant> etudiants= new ArrayList<sample.Etudiant>();
    public ArrayList<sample.Enseignant> enseignants= new ArrayList<>();

    public ArrayList<sample.Etudiant> getEtudiants() {
        return etudiants;
    }

    public ArrayList<sample.Enseignant> getEnseignants() {
        return enseignants;
    }

    public Specialite(String nom, String filliere, String anneé) {
        this.nom = nom;
        this.filliere = filliere;
        this.anneé = anneé;
    }

    public Specialite(String nom) {
        this.nom = nom;
    }

    public void inscrireEnseignant(sample.Enseignant enseignant){
        enseignants.add(enseignant);
    }

    public void inscrireEtudiant(sample.Etudiant etudiant){
        etudiants.add(etudiant);
    }


    public ArrayList<sample.Enseignant> rechercheParNomEns(String nom){
        ArrayList<sample.Enseignant> etud=new ArrayList<sample.Enseignant>();
        int i=0;
        while(i<enseignants.size()){
            if(enseignants.get(i).getNom().equals(nom)){
                etud.add(enseignants.get(i));
            }
            i++;
        }
        return etud;
    }

    public ArrayList<sample.Enseignant> rechercheParPrenomEns(String prenom){
        ArrayList<sample.Enseignant> etud=new ArrayList<sample.Enseignant>();
        int i=0;
        while(i<enseignants.size()){
            if(enseignants.get(i).getPrenom().equals(prenom)){
                etud.add(enseignants.get(i));
            }
            i++;
        }
        return etud;
    }

    public ArrayList<sample.Enseignant> rechercheParDateEns(sample.Date date){
        ArrayList<sample.Enseignant> etud=new ArrayList<sample.Enseignant>();
        int i=0;
        while(i<enseignants.size()){
            if(enseignants.get(i).getNaissance().getJour()==date.getJour()&&enseignants.get(i).getNaissance().getMois()==date.getMois()&&enseignants.get(i).getNaissance().getAnneé()==date.getAnneé() ){
                etud.add(enseignants.get(i));
            }
            i++;
        }
        return etud;
    }
    public void modifierEtudiant(int pos,Etudiant etudiant){
        etudiants.set(pos,etudiant);
    }

    public void deleteEtudiant(int pos){
        etudiants.remove(pos);
    }


    public sample.Etudiant rechercheMat(int matricule){
        int i=0;
        while(i<etudiants.size()){
            if(etudiants.get(i).getMat()==matricule){
                return etudiants.get(i);
            }
            i++;
        }
        return null;
    }

    public ArrayList<sample.Etudiant> rechercheParNom(String nom){
        ArrayList<sample.Etudiant> etud=new ArrayList<sample.Etudiant>();
        int i=0;
        while(i<etudiants.size()){
            if(etudiants.get(i).getNom().equals(nom)){
                etud.add(etudiants.get(i));
            }
            i++;
        }
        return etud;
    }

    public ArrayList<sample.Etudiant> rechercheParPrenom(String prenom){
        ArrayList<sample.Etudiant> etud=new ArrayList<sample.Etudiant>();
        int i=0;
        while(i<etudiants.size()){
            if(etudiants.get(i).getPrenom().equals(prenom)){
                etud.add(etudiants.get(i));
            }
            i++;
        }
        return etud;
    }

    public ArrayList<sample.Etudiant> rechercheParDate(sample.Date date){
        ArrayList<sample.Etudiant> etud=new ArrayList<sample.Etudiant>();
        int i=0;
        while(i<etudiants.size()){
            if(etudiants.get(i).getNaissance().getJour()==date.getJour()&&etudiants.get(i).getNaissance().getMois()==date.getMois()&&etudiants.get(i).getNaissance().getAnneé()==date.getAnneé() ){
                etud.add(etudiants.get(i));
            }
            i++;
        }
        return etud;
    }


    public void print(){
        System.out.println("you have "+etudiants.size()+" students in this speciality.");
        for(int i=0;i<etudiants.size();i++){
            System.out.println(etudiants.get(i));
        }
    }

    @Override
    public String toString() {
        return nom+filliere;
    }
}
