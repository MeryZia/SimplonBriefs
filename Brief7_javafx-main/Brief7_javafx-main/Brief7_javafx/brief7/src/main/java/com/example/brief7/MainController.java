package com.example.brief7;

import Dao.Dao;
import Dao.Dao_Impl;
import ErrorMessage.MessageError;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.sql.*;
import java.util.Scanner;


public class MainController implements Initializable {

    @FXML
    private static TextField txtID;
    @FXML
    public static TextField txtFirstN;

    @FXML
    public static TextField txtFamilyN;
    @FXML
    public static TextField txtEmail;
    @FXML
    public static TextField txtAddr;
    @FXML
    public static TextField txtCity;
    @FXML
    public static TextField txtCountry;

    @FXML
    private Button btnInsert;
    @FXML
    private Button btnEdit;
    @FXML
    private Button btnDelete;

    @FXML
    private TableView<Student> View;
    @FXML
    private TableColumn <Student,String>  CEmail;
    @FXML
    private TableColumn <Student,String> CCountry;
    @FXML
    private TableColumn <Student,String> CFirstN;
    @FXML
    private TableColumn <Student,String> CAddr;
    @FXML
    private TableColumn <Student,String> CFamilyN;
    @FXML
    private TableColumn <Student,String> CCity;
    @FXML
    private TableColumn <Student,Integer> CID;
    @FXML
    private Label testId;


    @Deprecated
    protected void OnClickButton() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ShowStudents();
    }

    public void ShowStudents(){
        Dao_Impl di=new Dao_Impl();
        ObservableList<Student> list = di.getStudentList();
        CID.setCellValueFactory(new PropertyValueFactory<Student,Integer>("id_cd"));
        CFamilyN.setCellValueFactory(new PropertyValueFactory<Student,String>("nom"));
        CFirstN.setCellValueFactory(new PropertyValueFactory<Student,String>("prenom"));
        CEmail.setCellValueFactory(new PropertyValueFactory<Student,String>("mail"));
        CAddr.setCellValueFactory(new PropertyValueFactory<Student,String>("adresse"));
        CCity.setCellValueFactory(new PropertyValueFactory<Student,String>("ville"));
        CCountry.setCellValueFactory(new PropertyValueFactory<Student,String>("pays"));
        View.setItems(list);
    }

    @FXML
    public void InsertOnClick(ActionEvent event) {
       Dao_Impl di=new Dao_Impl();
        try {

            int Id = Integer.parseInt(txtID.getText());

            Student stu = new Student(Id, txtFamilyN.getText(), txtFirstN.getText(), txtEmail.getText(), txtAddr.getText()
                    , txtCity.getText(), txtCountry.getText());
            di.insert(stu);


            ShowStudents();
        } catch (Exception e) {

           e.printStackTrace();
        }

    }
    @FXML
    public void EditOnClick(ActionEvent actionEvent) {

        Dao_Impl di = new Dao_Impl();


        try {
            int Id = Integer.parseInt(txtID.getText());
            Student stu = new Student(Id);

            stu.setNom(txtFamilyN.getText());
            stu.setPrenom(txtFirstN.getText());
            stu.setMail(txtEmail.getText());
            stu.setAdresse(txtAddr.getText());
            stu.setVille(txtCity.getText());
            stu.setPays(txtCountry.getText());
            di.update(stu);
            ShowStudents();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        @FXML
    public void DeleteOnClick(ActionEvent actionEvent) {
        Student stu;
        Dao_Impl di=new Dao_Impl();

       try {


            int id = Integer.parseInt(txtID.getText());
            stu = new Student(id);
            di.delete(stu);
            ShowStudents();
        } catch (Exception e) {
           MessageError.message_box(e,"Not working");
        }

    }
/*    private Student getStudent() {
        Student stu = new Student();
        int id=Integer.parseInt(txtID.getText());
        System.out.println(id);
        stu.setId_cd(id);
        stu.setNom(txtFamilyN.getText());
        stu.setPrenom(txtFirstN.getText());
        stu.setMail(txtEmail.getText());
        stu.setAdresse(txtAddr.getText());
        stu.setVille(txtCity.getText());
        stu.setPays(txtCountry.getText());
        return stu;
    }*/
}