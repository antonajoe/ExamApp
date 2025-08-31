
package examapp;
/**
 *
 * @author Joe
 */
public class AccessStudent {
        String idStudent;
        ExamDatabaseModel database = ExamApp.database;

        
	public AccessStudent(String idStudent) {
            this.idStudent = idStudent;
        }

	public Student getStudent() {
               Student student1 = null; 
               for (Student student2 : database.getList()){
                    if (student2.getIdStudent().equals(this.idStudent)) {
                        student1 = student2; 
                    }    
                }
               return student1;
        }    

}
