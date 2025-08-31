
package examapp;

/**
 *
 * @author Joe
 */
public class Answer {
    
        private String examId;
        private String idQuestion;
        private int isCorrect;
        private String idAnswer;
        private String answerText;  

        public Answer(){
            this.examId = new String();
            this.idQuestion = new String();
            this.isCorrect = 0;
            this.answerText = new String();
            this.idAnswer = new String();
        }
        
        public Answer(String examId, String idQuestion, int isCorrect, String idAnswer, String answerText) {
            this.examId = examId;
            this.idQuestion = idQuestion;
            this.isCorrect = isCorrect;
            this.answerText = answerText;
            this.idAnswer = idAnswer;
            
        }
        public String getIdQuestion() {
            return idQuestion;
        }
        
        public void setIdQuestion(String idQuestion) {
            this.idQuestion = idQuestion;
        }
        
        public String getExamId() {
            return examId;
        }
        
        public void setExamId(String examName) {
            this.examId = examName;
        }
        
        public String getAnswerText() {
            return answerText;
        }
        
        public void setAnswerText(String answerText) {
            this.answerText = answerText;
        }        

        public String getIdAnswer() {
            return idAnswer;
        }
        
        public void setIdAnswer(String idAnswer) {
            this.idAnswer = idAnswer;
        }
        
        public int getIsCorrect() {
            return isCorrect;
        }
        
        public void setIsCorrect(int isCorrect) {
            this.isCorrect = isCorrect;
        }    
        
    
}
