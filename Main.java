package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Optional;

public class Main extends Application {

    Label username,password;
    TextField usernameField;
    PasswordField passwordField;
    Button login,EtButton,EnsButton,cancelButton1,cancelCL1,cancelCL2,AjoutEtu;
    TableView tabEtu,tabEns;
    Scene mainMenuScene,loginScene,EtScene,EnsScene,ajoutEtuScene,ajouteEnsScene,rechercheEtScene;


    Specialite spec= new Specialite("ISIL","B","2019");
     Specialite spec2=new Specialite("ACAD","B","2019");

    Etudiant item1 = new Etudiant("Azouaoui","Youcef","20","10","1999","ISIL");
    Etudiant item2 = new Etudiant("Bacha","Yassine","10","9","1999","ISIL");
    Etudiant item3 = new Etudiant("Ziani","Ryad","15","2","2000","ISIL");
    Etudiant item4= new Etudiant("Benzeghiba","MohammedTayeb","17","8","1999","ACAD");

    Date date1= new Date("10","10","1970");
    Date date2= new Date("20","1","1964");


    sample.Enseignant e1= new sample.Enseignant("Belmadi","Djamal",date1,"Sport","Coach","ISIL");
    Enseignant e2= new Enseignant("Benali","Rafik",date2,"O.Rad","Professeur","ACAD");

    @Override
    public void start(Stage primaryStage) throws Exception{

        spec.inscrireEtudiant(item1);
        spec.inscrireEtudiant(item2);
        spec.inscrireEtudiant(item3);
        spec.inscrireEtudiant(item4);

        spec.inscrireEnseignant(e2);
        spec.inscrireEnseignant(e1);

        username=new Label("Username: ");
        password=new Label("Password: ");
        usernameField=new TextField();
        usernameField.setPromptText("Utilisateur");
        passwordField=new PasswordField();
        passwordField.setPromptText("Mot de passe");
        login=new Button("login");



        HBox hBox1=new HBox();
        HBox hBox2=new HBox();
        HBox hBox3=new HBox();
        hBox1.setAlignment(Pos.CENTER);
        hBox2.setAlignment(Pos.CENTER);
        hBox3.setAlignment(Pos.CENTER);
        hBox1.setSpacing(20);
        hBox2.setSpacing(20);
        hBox3.setSpacing(80);

        hBox1.getChildren().addAll(username,usernameField);
        hBox2.getChildren().addAll(password,passwordField);
        hBox3.getChildren().addAll(login);

        VBox loginLayout=new VBox();
        loginLayout.getChildren().addAll(hBox1,hBox2,hBox3);
        loginLayout.setAlignment(Pos.CENTER);
        loginLayout.setPadding(new Insets(15,15,15,15));
        loginLayout.setSpacing(10);
        loginScene=new Scene(loginLayout,400,175);
        loginScene.getStylesheets().clear();
        loginScene.getStylesheets().add(getClass().getResource("something.css").toExternalForm());

        primaryStage.setTitle("POO project");
        primaryStage.setScene(loginScene);
        primaryStage.show();


        login.setOnAction(e -> {
            if(usernameField.getText().equals("azouaoui") && passwordField.getText().equals("youcef")){

                primaryStage.setScene(mainMenuScene);
            }
            else{
                System.out.println("Wrong boi");
            }

        });



        EtButton=new Button("Gerer Etudiants");
        EnsButton=new Button("Gerer Enseignants");

        cancelButton1= new Button("disconnect");


        EtButton.setOnAction(e -> {
            primaryStage.setScene(EtScene);
        });
        EnsButton.setOnAction(e -> {
            primaryStage.setScene(EnsScene);
        });


        cancelButton1.setOnAction(e -> {
            primaryStage.setScene(loginScene);
        });


        VBox mainMenuLayout=new VBox();
        mainMenuLayout.setAlignment(Pos.CENTER);
        mainMenuLayout.setSpacing(10);
        mainMenuLayout.setPadding(new Insets(15,15,15,15));
        mainMenuLayout.getChildren().addAll(EtButton,EnsButton,cancelButton1);
        //mainMenuScene.getStylesheets().clear();
        mainMenuLayout.getStylesheets().add(getClass().getResource("something.css").toExternalForm());
        mainMenuScene=new Scene(mainMenuLayout,500,300);



        cancelCL1=new Button("Cancel");
        AjoutEtu= new Button("Ajouter");
        Button rechercheEt=new Button("Rechercher");




        tabEtu=new TableView<>();

        TableColumn<Etudiant,Integer> Matcolumn=new TableColumn<>("Matricule");
        Matcolumn.setMinWidth(150);
        Matcolumn.setCellValueFactory(new PropertyValueFactory<>("mat"));

        TableColumn<Personne,String> nomColumn=new TableColumn<>("nom");
        nomColumn.setMinWidth(150);
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));


        TableColumn<Personne,String> prenomColumn=new TableColumn<>("Prenom");
        prenomColumn.setMinWidth(150);
        prenomColumn.setCellValueFactory(new PropertyValueFactory<>("prenom"));

        TableColumn<Personne, Date> dateNColumn=new TableColumn<>("Date naissance");
        dateNColumn.setMinWidth(150);
        dateNColumn.setCellValueFactory(new PropertyValueFactory<>("naissance"));

        TableColumn<Etudiant, String> specialiteEt=new TableColumn<>("Specialité");
        specialiteEt.setMinWidth(150);
        specialiteEt.setCellValueFactory(new PropertyValueFactory<>("spec"));


        tabEtu.getColumns().addAll(Matcolumn,nomColumn,prenomColumn,dateNColumn,specialiteEt);

        tabEtu.getItems().setAll(spec.etudiants);

        HBox Horiz= new HBox(10);
        Horiz.setAlignment(Pos.CENTER);
        Horiz.setPadding(new Insets(15,15,15,15));
        Horiz.getChildren().addAll(cancelCL1,AjoutEtu,rechercheEt);


        VBox eCL1Layout=new VBox(10);
        eCL1Layout.setAlignment(Pos.CENTER);
        eCL1Layout.setPadding(new Insets(15,15,15,15));
        eCL1Layout.getChildren().addAll(tabEtu,Horiz);
        EtScene=new Scene(eCL1Layout,800,300);
        EtScene.getStylesheets().add(getClass().getResource("something.css").toExternalForm());



        Button rechercheEns= new Button("Rechercher");
        Button ajouEtud=new Button("Ajouter");
        Button CancelAjoutEt= new Button("Cancel");
        Label ajoutName= new Label("Nom : ");
        Label ajoutPrenom=new Label("Prenom :");
        Label ajoutNaissance= new Label("Date de naissance:");
        Label ajoutSpecialite= new Label("Specialté : ");

        TextField nameEt= new TextField();
        TextField prenomEt= new TextField();
        TextField jourEt= new TextField();
        jourEt.setMaxWidth(50);
        TextField moisEt= new TextField();
        moisEt.setMaxWidth(50);
        TextField anneeEt= new TextField();
        anneeEt.setMaxWidth(50);
        TextField specialiteAjoutEt = new TextField();

        HBox date= new HBox(5);
        date.setAlignment(Pos.CENTER);
        date.setPadding(new Insets(15,15,15,15));
        date.getChildren().addAll(jourEt,moisEt,anneeEt);

        HBox h1= new HBox(10);
        h1.setAlignment(Pos.CENTER);
        h1.setPadding(new Insets(15,15,15,15));
        h1.getChildren().addAll(ajoutName,nameEt);

        HBox h2= new HBox(10);
        h2.setAlignment(Pos.CENTER);
        h2.setPadding(new Insets(15,15,15,15));
        h2.getChildren().addAll(ajoutPrenom,prenomEt);

        HBox h3= new HBox(10);
        h3.setAlignment(Pos.CENTER);
        h3.setPadding(new Insets(15,15,15,15));
        h3.getChildren().addAll(ajoutNaissance,date);

        HBox h4= new HBox(10);
        h4.setAlignment(Pos.CENTER);
        h4.setPadding(new Insets(15,15,15,15));
        h4.getChildren().addAll(ajoutSpecialite,specialiteAjoutEt);


        HBox lastAjout= new HBox(10);
        lastAjout.setAlignment(Pos.CENTER);
        lastAjout.setPadding(new Insets(15,15,15,15));
        lastAjout.getChildren().addAll(CancelAjoutEt,ajouEtud);


        VBox generalVAjout=new VBox(10);
        generalVAjout.setAlignment(Pos.CENTER);
        generalVAjout.setPadding(new Insets(15,15,15,15));
        generalVAjout.getChildren().addAll(h1,h2,h3,h4,lastAjout);

        ajoutEtuScene= new Scene(generalVAjout,1000,400);
        ajoutEtuScene.getStylesheets().clear();
        ajoutEtuScene.getStylesheets().add(getClass().getResource("something.css").toExternalForm());


        cancelCL1.setOnAction(e -> {
            primaryStage.setScene(mainMenuScene);
        });

        AjoutEtu.setOnAction(e -> {
            jourEt.setText("");
            moisEt.setText("");
            anneeEt.setText("");
            specialiteAjoutEt.setText("");
            nameEt.setText("");
            prenomEt.setText("");
            primaryStage.setScene(ajoutEtuScene);
        });

        rechercheEt.setOnAction(e -> {
                    primaryStage.setScene(rechercheEtScene);
                }
        );



        CancelAjoutEt.setOnAction(e -> {
            primaryStage.setScene(EtScene); }
        );


        ajouEtud.setOnAction(e -> {
                    if(jourEt.getText().equals("")||moisEt.getText().equals("")||anneeEt.getText().equals("")||specialiteAjoutEt.getText().equals("")||nameEt.getText().equals("")||prenomEt.getText().equals("")){
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Alert");
                        alert.setHeaderText("You didnt enter all the infos.");
                        alert.setContentText("Please re-enter all the infos.");
                        Optional<ButtonType> result = alert.showAndWait();
                    }
                    else{
                        Date date3= new Date(jourEt.getText(),moisEt.getText(),anneeEt.getText());
                        String specialite=specialiteAjoutEt.getText();
                        Etudiant etudiant= new Etudiant(nameEt.getText(),prenomEt.getText(),date3,specialite);
                        spec.inscrireEtudiant(etudiant);
                        tabEtu.getItems().setAll(spec.etudiants);
                        primaryStage.setScene(EtScene);
                    }

                }
        );


        Label labCEtu= new Label("Rechercher : ");
        ComboBox combo= new ComboBox(options1);
        Label labREt= new Label("Donneé recherché :");
        TextField labREtField= new TextField();
        Button buRecEt1= new Button("Cancel");
        Button buRecEt2= new Button("Proceed");

        HBox rechEt0= new HBox(10);
        rechEt0.setAlignment(Pos.CENTER);
        rechEt0.setPadding(new Insets(15,15,15,15));
        rechEt0.getChildren().addAll(labCEtu,combo);

        HBox rechEt1= new HBox(10);
        rechEt1.setAlignment(Pos.CENTER);
        rechEt1.setPadding(new Insets(15,15,15,15));
        rechEt1.getChildren().addAll(labREt,labREtField);

        HBox rechEt2= new HBox(10);
        rechEt2.setAlignment(Pos.CENTER);
        rechEt2.setPadding(new Insets(15,15,15,15));
        rechEt2.getChildren().addAll(buRecEt1,buRecEt2);

        VBox rechET3= new VBox(10);
        rechET3.setAlignment(Pos.CENTER);
        rechET3.setPadding(new Insets(15,15,15,15));
        rechET3.getChildren().addAll(rechEt0,rechEt1,rechEt2);

        rechercheEtScene= new Scene(rechET3,500,250);
        rechercheEtScene.getStylesheets().add(getClass().getResource("something.css").toExternalForm());


        buRecEt1.setOnAction(e -> {
            primaryStage.setScene(EtScene); }
        );


        buRecEt2.setOnAction(e -> {
                    if(combo.getValue()=="Par Matricule"){
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Search per Matricule");
                        alert.setHeaderText("The student with this matricule : ");

                        int research = Integer.parseInt(labREtField.getText());

                        alert.setContentText(spec.rechercheMat(research).toString());
                        Optional<ButtonType> result = alert.showAndWait();
                    }

                    else if(combo.getValue()=="Par Nom"){
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

                        alert.setTitle("Search per Nom");
                        alert.setHeaderText("The students with this name : ");

                        String everithing="";
                        String research= labREtField.getText();
                        ArrayList<Etudiant> lul= spec.rechercheParNom(research);
                        if(lul.size()==0){
                            alert.setContentText("There is no such data on our table.");
                            Optional<ButtonType> result = alert.showAndWait();
                        }
                        for(int i=0;i<lul.size();i++){
                            everithing+=(lul.get(i).toString());
                            }
                        alert.setContentText(everithing);
                        Optional<ButtonType> result = alert.showAndWait();

                    }

                    else if(combo.getValue()=="Par Prenom"){
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Search per Prenom");
                        alert.setHeaderText("The students with this prenom :");

                        String everithing="";
                        String research= labREtField.getText();
                        ArrayList<Etudiant> lul= spec.rechercheParPrenom(research);
                        if(lul.size()==0){
                            alert.setContentText("There is no such data on our table.");
                            Optional<ButtonType> result = alert.showAndWait();
                        }
                        for(int i=0;i<lul.size();i++){
                            everithing+=lul.get(i).toString();
                            }
                        alert.setContentText(everithing);
                        Optional<ButtonType> result = alert.showAndWait();
                    }

                    else if(combo.getValue().equals("Par Enseignant")){
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Search per Enseignant");

                        String everything="";
                        Enseignant enseignant=null;
                        String research= labREtField.getText();
                        for(int i=0;i<spec.enseignants.size();i++){
                            if(spec.enseignants.get(i).nom.equals(research)){
                                enseignant=spec.enseignants.get(i);
                            }
                        }
                        if(enseignant==null){
                            alert.setContentText("Enseignant doesnt exist.");
                            Optional<ButtonType> result = alert.showAndWait();
                        }
                        alert.setHeaderText("Students of this Enseignant: ");
                        for(int i=0;i<spec.etudiants.size();i++){
                            if(enseignant.spec.equals(spec.etudiants.get(i).spec)){
                                everything+=spec.etudiants.get(i).toString();
                            }
                        }
                        alert.setContentText(everything);
                        Optional<ButtonType> result = alert.showAndWait();
                    }

                    else if(combo.getValue().equals("Par Specialite")){
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Search per Prenom");
                        alert.setHeaderText("The students of this speciality : ");

                        String everything="";
                        String research= labREtField.getText();
                        for(int i=0;i<spec.etudiants.size();i++){
                            if(spec.etudiants.get(i).spec.equals(research)){
                                everything+=spec.etudiants.get(i).toString();
                            }
                        }
                        alert.setContentText(everything);
                        Optional<ButtonType> result = alert.showAndWait();
                    }

                    else{
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Search");
                        alert.setHeaderText("you didnt specify the way of research.");

                        Optional<ButtonType> result = alert.showAndWait();
                    }
                }

        );







        tabEns=new TableView<>();


        TableColumn<Personne,String> nomColumnE=new TableColumn<>("Nom");
        nomColumnE.setMinWidth(150);
        nomColumnE.setCellValueFactory(new PropertyValueFactory<>("nom"));


        TableColumn<Personne,String> prenomColumnE=new TableColumn<>("Prenom");
        prenomColumnE.setMinWidth(150);
        prenomColumnE.setCellValueFactory(new PropertyValueFactory<>("prenom"));

        TableColumn<Personne, Date> dateColumnE=new TableColumn<>("Date naissance");
        dateColumnE.setMinWidth(150);
        dateColumnE.setCellValueFactory(new PropertyValueFactory<>("naissance"));


        TableColumn<sample.Enseignant,String> module=new TableColumn<>("Module");
        module.setMinWidth(150);
        module.setCellValueFactory(new PropertyValueFactory<>("module"));


        TableColumn<sample.Enseignant,String> grade=new TableColumn<>("Grade");
        grade.setMinWidth(150);
        grade.setCellValueFactory(new PropertyValueFactory<>("grade"));


        TableColumn<Enseignant,String> specialite=new TableColumn<>("Specialite");
        specialite.setMinWidth(150);
        specialite.setCellValueFactory(new PropertyValueFactory<>("spec"));

        tabEns.getColumns().addAll(nomColumnE,prenomColumnE,dateColumnE,module,grade,specialite);

        tabEns.getItems().setAll(spec.enseignants);

        cancelCL2= new Button("Cancel");
        Button ajoutEns= new Button("Ajouter");

        HBox ajEns=new HBox(10);
        ajEns.setAlignment(Pos.CENTER);
        ajEns.setPadding(new Insets(15,15,15,15));
        ajEns.getChildren().addAll(cancelCL2,ajoutEns);

        VBox EnsLayout=new VBox(10);
        EnsLayout.setAlignment(Pos.CENTER);
        EnsLayout.setPadding(new Insets(15,15,15,15));
        EnsLayout.getChildren().addAll(tabEns,ajEns);

        EnsScene=new Scene(EnsLayout,950,300);
        EnsScene.getStylesheets().add(getClass().getResource("something.css").toExternalForm());



        Button ajouEns=new Button("Ajouter");
        Button CancelAjoutEns= new Button("Cancel");
        Label ajoutNameEns= new Label("Nom : ");
        Label ajoutPrenomEns=new Label("Prenom :");
        Label ajoutNaissanceEns= new Label("Date de naissance:");
        Label ajoutSpecialiteEns= new Label("Specialté : ");
        Label ajoutModule=new Label("Module :");
        Label ajoutGrade= new Label("Grade :");

        TextField nameEns= new TextField();
        TextField prenomEns= new TextField();
        TextField jourEns= new TextField();
        TextField moisEns= new TextField();
        TextField anneeEns= new TextField();
        TextField specialiteAjoutEns = new TextField();
        TextField moduleEns=new TextField();
        TextField gradeEns= new TextField();

        HBox dateEns= new HBox(10);
        dateEns.setAlignment(Pos.CENTER);
        dateEns.setPadding(new Insets(15,15,15,15));
        dateEns.getChildren().addAll(jourEns,moisEns,anneeEns);

        HBox h1Ens= new HBox(10);
        h1Ens.setAlignment(Pos.CENTER);
        h1Ens.setPadding(new Insets(15,15,15,15));
        h1Ens.getChildren().addAll(ajoutNameEns,nameEns);

        HBox h2Ens= new HBox(10);
        h2Ens.setAlignment(Pos.CENTER);
        h2Ens.setPadding(new Insets(15,15,15,15));
        h2Ens.getChildren().addAll(ajoutPrenomEns,prenomEns);

        HBox h3Ens= new HBox(10);
        h3Ens.setAlignment(Pos.CENTER);
        h3Ens.setPadding(new Insets(15,15,15,15));
        h3Ens.getChildren().addAll(ajoutNaissanceEns,dateEns);

        HBox h4Ens= new HBox(10);
        h4Ens.setAlignment(Pos.CENTER);
        h4Ens.setPadding(new Insets(15,15,15,15));
        h4Ens.getChildren().addAll(ajoutSpecialiteEns,specialiteAjoutEns);


        HBox h5Ens= new HBox(10);
        h5Ens.setAlignment(Pos.CENTER);
        h5Ens.setPadding(new Insets(15,15,15,15));
        h5Ens.getChildren().addAll(ajoutModule,moduleEns);


        HBox h6Ens= new HBox(10);
        h6Ens.setAlignment(Pos.CENTER);
        h6Ens.setPadding(new Insets(15,15,15,15));
        h6Ens.getChildren().addAll(ajoutGrade,gradeEns);


        HBox lastAjoutEns= new HBox(10);
        lastAjoutEns.setAlignment(Pos.CENTER);
        lastAjoutEns.setPadding(new Insets(15,15,15,15));
        lastAjoutEns.getChildren().addAll(CancelAjoutEns,ajouEns);


        VBox generalVAjoutEns=new VBox(10);
        generalVAjoutEns.setAlignment(Pos.CENTER);
        generalVAjoutEns.setPadding(new Insets(15,15,15,15));
        generalVAjoutEns.getChildren().addAll(h1Ens,h2Ens,h3Ens,h4Ens,h5Ens,h6Ens,lastAjoutEns);

        ajouteEnsScene= new Scene(generalVAjoutEns,1000,600);
        ajouteEnsScene.getStylesheets().clear();
        ajouteEnsScene.getStylesheets().add(getClass().getResource("something.css").toExternalForm());



        cancelCL2.setOnAction(e -> {
            primaryStage.setScene(mainMenuScene);
        });

        ajoutEns.setOnAction(e -> {
            jourEns.setText("");
            moisEns.setText("");
            anneeEns.setText("");
            specialiteAjoutEns.setText("");
            nameEns.setText("");
            prenomEns.setText("");
            moduleEns.setText("");
            gradeEns.setText("");
            primaryStage.setScene(ajouteEnsScene);
        });

        CancelAjoutEns.setOnAction(e -> {
            primaryStage.setScene(EnsScene); }
        );



        ajouEns.setOnAction(e -> {
                    if(jourEns.getText().equals("")||moisEns.getText().equals("")||anneeEns.getText().equals("")||specialiteAjoutEns.getText().equals("")||nameEns.getText().equals("")||prenomEns.getText().equals("")||moduleEns.getText().equals("")|| gradeEns.getText().equals(""))
                    {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Alert");
                        alert.setHeaderText("You didnt enter all the infos.");
                        alert.setContentText("Please re-enter all the infos.");
                        Optional<ButtonType> result = alert.showAndWait();
                    }
                    else{
                        Date date3= new Date(jourEns.getText(),moisEns.getText(),anneeEns.getText());
                        String specialiteEns= specialiteAjoutEns.getText();
                        Enseignant enseignant= new Enseignant(nameEns.getText(),prenomEns.getText(),date3,moduleEns.getText(),gradeEns.getText(),specialiteEns);
                        spec.inscrireEnseignant(enseignant);
                        tabEns.getItems().setAll(spec.enseignants);
                        primaryStage.setScene(EnsScene);

                    }

                }
        );

    }


    ObservableList<String> options1 =
            FXCollections.observableArrayList(
                    "Par Matricule","Par Nom",
                    "Par Prenom","Par Enseignant","Par Specialite"
            );

    public static void main(String[] args) {
        launch(args);
    }
}
