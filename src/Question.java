/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examapp;
/**
 *
 * @author Joe
 */
import java.util.ArrayList;

public class Question {

        private String examId;
        private String questionText;
        private int questionOrder;
        private String idQuestion;
        private ArrayList<Answer> answers = new ArrayList<>();
        private String correctAnswer;

        
        public String getIdQuestion() {
            return idQuestion;
        }
        
        public void setIdQuestion(String idQuestion) {
            this.idQuestion = idQuestion;
        }
        
        public String getExamId() {
            return examId;
        }
        
        public void setExamId(String examId) {
            this.examId = examId;
        }
        
        public String getQuestionText() {
            return questionText;
        }
        
        public void setQuestionText(String questionText) {
            this.questionText = questionText;
        }        

        public int getQuestionOrder() {
            return questionOrder;
        }
        
        public void setQuestionOrder(int questionOrder) {
            this.questionOrder = questionOrder;
        }
        
        public ArrayList<Answer> getAnswers() {
            return answers;
        }

        public void setAnswers(ArrayList<Answer> answers) {
            this.answers = answers;
        }  
        
        public void setAnswer(Answer answer) {
            answers.add(answer);
        }    
        
        public String getAnswer() {
            return correctAnswer;
        }

        public void setCorrectAnswer(String text) {
            correctAnswer = text;
        }
}
