package Dao;

import com.example.brief7.Student;
import javafx.collections.ObservableList;

public interface Dao {

    public abstract boolean insert(Student stu);
    //delete a candidate
    public abstract void delete(Student stu);
    //Update candidate name based on id
    public abstract void update(Student stu);
    //Get an candidate by id
    public ObservableList<Student> getStudentList();
}
