import com.core.controller.StudentController;
import com.core.factory.StudentControllerFactory;


public class Main {
    public static void main(String[] args) {
        StudentController studentController= StudentControllerFactory.getStudentController();

        String status1=studentController.addStudent();
        System.out.println(status1);
        System.out.println();



        String status2=studentController.searchStudent();
        System.out.println(status2);
        System.out.println();



        String status3=studentController.updateStudent();
        System.out.println(status3);
        System.out.println();

        String status4=studentController.deleteStudent();
        System.out.println(status4);
        System.out.println();



    }
}