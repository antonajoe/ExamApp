
package examapp;
/**
 *
 * @author Joe
 */
import java.util.ArrayList;

public class Student {
    
        private ArrayList<Exam> studentExams;
        private String idStudent;
        private String firstName;
        private String lastName;

        public String getIdStudent() {
            return idStudent;
        }
        
        public void setIdStudent(String idStudent) {
            this.idStudent = idStudent;
        }
        
        public String getFirstName() {
            return firstName;
        }
        
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
        
        public String getLastName() {
            return lastName;
        }
        
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public ArrayList<Exam> getStudentExams() {
            return studentExams;     
        }
        
        public void setStudentExams(Student student) {
            for(Exam exam : ExamApp.database.getExamList()){
                if (exam.getStudent().equals(student.getIdStudent())){
                    studentExams.add(exam);
                } 
            }   
        }

}
