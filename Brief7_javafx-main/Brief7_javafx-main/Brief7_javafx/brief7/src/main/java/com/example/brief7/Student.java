package com.example.brief7;

public class Student {
    private int id_cd;
    private String nom;
    private String prenom;
    private String mail;
    private String adresse;
    private String ville;
    private String pays;

    public Student() {
       super();
    }
    public Student(int id_cd){

        this.id_cd=id_cd;
}
    public Student(int id_cd, String nom, String prenom, String mail, String adresse, String ville, String pays) {
        this.id_cd = id_cd;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.adresse = adresse;
        this.ville = ville;
        this.pays = pays;
    }
    public Student( String nom, String prenom, String mail, String adresse, String ville, String pays) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.adresse = adresse;
        this.ville = ville;
        this.pays = pays;
    }
    public int getId_cd() {

        return id_cd;
    }

    public void setId_cd(int id_cd) {

        this.id_cd = id_cd;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {

        this.nom = nom;
    }

    public String getPrenom() {

        return prenom;
    }

    public void setPrenom(String prenom) {

        this.prenom = prenom;
    }

    public String getMail() {

        return mail;
    }

    public void setMail(String mail) {

        this.mail = mail;
    }

    public String getAdresse() {

        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id_cd=" + id_cd +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", mail='" + mail + '\'' +
                ", adresse='" + adresse + '\'' +
                ", ville='" + ville + '\'' +
                ", pays='" + pays + '\'' +
                '}';
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
}
