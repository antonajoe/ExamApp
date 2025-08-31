
package examapp;
/**
 *
 * @author Joe
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ExamDatabaseModel {
    private ArrayList<Student> students = new ArrayList();
    private ArrayList<Exam> exams = new ArrayList();
    private ArrayList<Question> questions = new ArrayList();
    private Connection connection;
    private Statement statement;
    
    public ExamDatabaseModel(){}

    public ArrayList<Student> getStudents() throws SQLException {
        String query = "SELECT * FROM student;";
        Student student = null;
        ResultSet rs = null;
        try {
            connection = SingleConnection.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                student = new Student();
                student.setIdStudent(rs.getString("idStudent"));
                student.setFirstName(rs.getString("firstName"));
                student.setLastName(rs.getString("lastName"));               
                students.add(student);
            }
        } finally {
            DbUtil.close(rs);
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
        return students; 
    }
    
    public ArrayList<Exam> getExams() throws SQLException, NullPointerException {
        String query = "SELECT * FROM exam;";
        Exam exam = null;
        ResultSet rs = null;
        try {
            connection = SingleConnection.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                exam = new Exam();
                exam.setExamId(rs.getString("examId"));
                exam.setDescription(rs.getString("description"));
                exam.setPassingScore(rs.getInt("passingScore"));
                exam.setMaxScore(rs.getInt("maxScore"));
                exam.setRules(rs.getString("rules"));
                exam.setIsRegistered(rs.getInt("isRegistered"));
                exam.setStudent(rs.getString("idStudent"));
                exam.setTime(rs.getInt("time"));
                exams.add(exam);
            }
        }
        finally {
            DbUtil.close(rs);
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
        return exams;
    }
    
    public void updateStudent(String idStudent, String firstName, String lastName) {
        UpdateDatabase update = new UpdateDatabase();
        String query = new String("INSERT INTO student \n" +
            "VALUES("+ idStudent + "," + "'" + firstName + "'" + "," + "'" + lastName + "'" + ");");
        update.setQuery(query);
        try{
            update.update(query);
            ExamApp.database.getStudents();
        }catch(SQLException e){}   
    }
    
    public void updateExam(String examId, String description, int passingScore, int maxScore, String rules, int isRegistered, int time) {
        UpdateDatabase update = new UpdateDatabase();
        String query = new String("INSERT INTO exam (examId, description, passingScore, maxScore, rules, isRegistered, idStudent, time) \n" +
            "VALUES("+ "'" + examId + "'" + ", " + "'" + description + "'" + ", " + passingScore + ", " + maxScore + ", " + "'" + rules + "'" + ", " + isRegistered + ", " + 0 + ", " + time + ");");
        update.setQuery(query);
        try{
            update.update(query);
            Exam exam1 = new Exam();
            exam1.setExamId(examId);
            exam1.setDescription(description);
            exam1.setPassingScore(passingScore);
            exam1.setMaxScore(maxScore);
            exam1.setRules(rules);
            exam1.setIsRegistered(isRegistered);
            exam1.setTime(time);
            exam1.setStudent("0");
            ExamApp.database.exams.add(exam1);
        }catch(SQLException e){}  
    }

    public void updateExam(Exam exam) {
        UpdateDatabase update = new UpdateDatabase();
        System.out.println(exam.getExamId() + "'" + ", " + "'" + exam.getDescription() + "'" + ", " + exam.getPassingScore() + ", " + exam.getMaxScore() + ", " + "'" + exam.getRules() + "'" + ", " + exam.getIsRegistered() + ", " + exam.getStudent() + ", " + exam.getTime() + ");");
        String query = new String("INSERT INTO exam (examId, description, passingScore, maxScore, rules, isRegistered, idStudent, time) \n" +
            "VALUES("+ "'" + exam.getExamId() + "'" + ", " + "'" + exam.getDescription() + "'" + ", " + exam.getPassingScore() + ", " + exam.getMaxScore() + ", " + "'" + exam.getRules() + "'" + ", " + exam.getIsRegistered() + ", " + exam.getStudent() + ", " + exam.getTime() + ");");
        System.out.println(exam.getTime());
        update.setQuery(query);
        try{
            update.update(query);
            ExamApp.database.exams.add(exam);
        }catch(SQLException e){}  
    }     
    
    public ArrayList<Student> getList(){
        return students;
    }
    
    public ArrayList<Exam> getExamList(){
        return exams;
    }

    public ArrayList<Question> getQuestions(Exam exam) throws SQLException, NullPointerException {
        String query = "SELECT * FROM questions where examId = " + "'" + exam.getExamId() + "'" + ";";
        Question question = null;
        ResultSet rs = null;
        try {
            connection = SingleConnection.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                question = new Question();
                question.setExamId(rs.getString("examId"));
                question.setQuestionText(rs.getString("questionText"));
                question.setQuestionOrder(rs.getInt("questionOrder"));
                question.setIdQuestion(rs.getString("idQuestion"));;
                questions.add(question);
                exam.setQuestion(question);
            }
        }
        finally {
            DbUtil.close(rs);
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
        return questions;
    }
    
    public void updateAnswers(Answer answer) throws SQLException, NullPointerException {
        UpdateDatabase update = new UpdateDatabase();
        String query = "insert into answers(idQuestion, idAnswer, isCorrect, answerText, examId) values(" + "'" + answer.getIdQuestion() + "', '" + answer.getIdAnswer() +"', " + answer.getIsCorrect() + ", '" + answer.getAnswerText() + "','" + answer.getExamId() + "'" + ");";
        System.out.println(query);
        update.setQuery(query);
        try{
            update.update(query);
        }catch(SQLException e){}

        }
    
    public void updateQuestions(Question quest) throws SQLException, NullPointerException {
        UpdateDatabase update = new UpdateDatabase();
        String query = "insert into questions(examId, questionText, questionOrder, idQuestion, answer) values(" + "'" + quest.getExamId() + "', '" + quest.getQuestionText() +"', " + quest.getQuestionOrder() + ", '" + quest.getIdQuestion() + "','" + quest.getAnswer()+ "'" + ");";
        System.out.println(query);
        update.setQuery(query);
        try{
            update.update(query);
        }catch(SQLException e){}

        }
    
    public ArrayList<Exam> getStudentExams(String idStudent) throws SQLException, NullPointerException {
        String query = "SELECT * FROM exam where idStudent =" + " '" + idStudent + "'" + ";";
        Exam exam1 = null;
        ArrayList<Exam> exams1 = new ArrayList();
        ResultSet rs = null;
        try {
            connection = SingleConnection.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                exam1 = new Exam();
                exam1.setExamId(rs.getString("examId"));
                exam1.setDescription(rs.getString("description"));
                exam1.setPassingScore(rs.getInt("passingScore"));
                exam1.setMaxScore(rs.getInt("maxScore"));
                exam1.setRules(rs.getString("rules"));
                exam1.setIsRegistered(rs.getInt("isRegistered"));
                exam1.setStudent(rs.getString("idStudent"));
                exam1.setTime(rs.getInt("time"));
                exams1.add(exam1);
            }
        }
        finally {
            DbUtil.close(rs);
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
        return exams1;
    }

    public void registerStudent(String examId, String idStudent) {
        String query = "UPDATE exam SET isRegistered = 1 WHERE idStudent =" + "' " + idStudent + "' AND examId =" + " '" + examId + "';";
        UpdateDatabase update = new UpdateDatabase();
        try{
        update.update(query);
        }catch (SQLException e){}
        finally {
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
    }
    
    public ArrayList<Answer> getQuestAnswers(String idQuestion)throws SQLException, NullPointerException{
        String query = "SELECT * FROM answers WHERE idQuestion = " + "'" + idQuestion + "'" + ";";
        Answer answer = null;
        ArrayList<Answer> answers = new ArrayList();
        ResultSet rs = null;
        try {
            connection = SingleConnection.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                answer = new Answer();
                answer.setExamId(rs.getString("examId"));
                answer.setIdQuestion(rs.getString("idQuestion"));
                answer.setIsCorrect(rs.getInt("isCorrect"));
                answer.setAnswerText(rs.getString("answerText"));
                answer.setIdAnswer(rs.getString("idAnswer"));
                answers.add(answer);
            }
        }
        finally {
            DbUtil.close(rs);
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
        return answers;    
    }
}      

