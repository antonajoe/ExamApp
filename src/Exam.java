
package examapp;

import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Joe
 */
public class Exam{
    
        private String examId;
        private String description;
        private int passingScore;
        private int maxScore;
        private String rules;
        private String idStudent;
        private int isRegistered;
        private int time;
        private ArrayList<Question> questions = new ArrayList();        
        
        public Exam(){}
              
        public String getStudent() {
            return idStudent;
        }
        
        public void setStudent(String student) {
            this.idStudent = student;
        }
        
        public String getExamId() {
            return examId;
        }
        
        public void setExamId(String examId) {
            this.examId = examId;
        }
        
        public String getDescription() {
            return description;
        }
        
        public void setDescription(String description) {
            this.description = description;
        }        

        public int getPassingScore() {
            return passingScore;
        }
        
        public void setPassingScore(int passingScore) {
            this.passingScore = passingScore;
        }
        
        public int getMaxScore() {
            return maxScore;
        }
        
        public void setMaxScore(int maxScore) {
            this.maxScore = maxScore;
        }
        
        public int getIsRegistered() {
            return isRegistered;
        }
        
        public void setIsRegistered(int isRegistered) {
            this.isRegistered = isRegistered;
        }
        
        public String getRules() {
            return rules;
        }
        
        public void setRules(String rules) {
            this.rules = rules;
        }    

         public int getTime() {
            return time;
        } 
     
        public void setTime(int time) {
            this.time = time;
        }  

        public void setQuestion(Question quest)throws SQLException{
             this.questions.add(quest);
        }
        
        public ArrayList<Question> getQuestions()throws SQLException{
            return questions;
        }
        
}
