package Dao;

import com.example.brief7.Connect;
import com.example.brief7.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Dao_Impl implements Dao {


    @Override
    public boolean insert(Student stu) {
        Connection cn=null;
        Connect cnx =new Connect();
        cn =cnx.getConnection();

        try {
            String query = "Insert into candidat values (?,?,?, ?, ?,?,?)";
            PreparedStatement preparedStmt = cn.prepareStatement(query);
            preparedStmt.setInt(1,stu.getId_cd());
            preparedStmt.setString (2, stu.getNom());
            preparedStmt.setString (3, stu.getPrenom());
            preparedStmt.setString (4, stu.getMail());
            preparedStmt.setString (5, stu.getAdresse());
            preparedStmt.setString (6, stu.getVille());
            preparedStmt.setString (7, stu.getPays());

            int i = preparedStmt.executeUpdate();
            if (i == 1){
                return true;
            }

            //cn.close();


        } catch (Exception e) {
            e.printStackTrace ();
        }
        return false;
    }

    @Override
    public void delete(Student stu) {
        Connection cn;
        Connect cnx =new Connect();
        cn =cnx.getConnection();

        try {
            String query = "delete from candidat where id_cd=?";
            PreparedStatement preparedStmt = cn.prepareStatement(query);


            preparedStmt.setInt(1, stu.getId_cd());
            preparedStmt.execute();
            // cn.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Student stu) {
        Connection cn = null;
        Connect cnx =new Connect();
        cn =cnx.getConnection();

        try {
            String query = "Update candidat set nom =?,prenom=?,mail=?,adresse=?,ville=?,pays=? where id_cd=?;";
            PreparedStatement preparedStmt = cn.prepareStatement(query);


            preparedStmt.setString(1, stu.getNom());
            preparedStmt.setString(2, stu.getPrenom());
            preparedStmt.setString(3, stu.getMail());
            preparedStmt.setString(4, stu.getAdresse());
            preparedStmt.setString(5, stu.getVille());
            preparedStmt.setString(6, stu.getPays());
            preparedStmt.setInt(7, stu.getId_cd());
            preparedStmt.execute();
            // cn.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public ObservableList<Student> getStudentList(){
        ObservableList<Student> studentList = FXCollections.observableArrayList();
        Connect cnx =new Connect();
        Connection cn = cnx.getConnection();
        String query="select * from candidat";
        Statement st;
        ResultSet rs;
        try{
            st=cn.createStatement();
            rs=st.executeQuery(query);
            Student student;
            while(rs.next()){
                student =new Student(rs.getInt("id_cd"),rs.getString("nom"),rs.getString("prenom"),rs.getString("mail"),rs.getString("adresse"),rs.getString("ville"),rs.getString("pays"));
                studentList.add(student);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return studentList;
    }
}
