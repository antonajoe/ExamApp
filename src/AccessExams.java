
package examapp;
/**
 *
 * @author Joe
 */

public class AccessExams {
    String examId ;
    ExamDatabaseModel database = ExamApp.database;

    
    public AccessExams(String examId) {  
        this.examId = examId;
    }   
            
    public Exam getExam() {
            Exam exam1 = null; 
            for (Exam exam : database.getExamList()){
                System.out.println(exam.getExamId());
                if (exam.getExamId().equals(this.examId)) {
                    exam1 = exam; 
                }    
            }
            return exam1;
    }

}
