
package examapp;
/**
 *
 * @author Joe
 */
import java.sql.*;
import javax.swing.*;

public class ExamApp {
    static JFrame frame;
    static LoginPage login;
    static AdminPage admin;
    static ExamDatabaseModel database;  

    public ExamApp() {     
    
    this.admin = new AdminPage();
    this.login = new LoginPage();
    this.database = new ExamDatabaseModel();
    try{
    database.getStudents();
    database.getExams();
    }catch (SQLException e) {}
    this.frame = login;
    frame.setVisible(true);   
    }
    
    public static void main(String[] args) {      

        try {
        UIManager.setLookAndFeel(
        UIManager.getSystemLookAndFeelClassName());
        } 
        catch (UnsupportedLookAndFeelException |ClassNotFoundException  | InstantiationException | IllegalAccessException e) {}
        ExamApp examapp = new ExamApp();
    
        }    
    }
