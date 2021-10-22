import com.github.lophixyz.Course;
import com.github.lophixyz.Module;
import com.github.lophixyz.Student;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Driver {
  public static void main(String[] args) {
    Course computerScience = new Course("Computer Science and Information Technology", DateTime.parse("2021-09-06"), DateTime.parse("2022-05-07"));
    Module softwareEngineering = new Module("CT417", "Software Engineering III");
    Module advancedProfessionalSkills = new Module("CT436", "Advanced Professional Skills");
    Module informationRetrieval = new Module("CT4100", "Information Retrieval");
    Module machineLearning = new Module("CT4101", "Machine Learning");
    computerScience.addModule(softwareEngineering);
    softwareEngineering.addCourse(computerScience);
    computerScience.addModule(advancedProfessionalSkills);
    advancedProfessionalSkills.addCourse(computerScience);
    computerScience.addModule(informationRetrieval);
    informationRetrieval.addCourse(computerScience);
    computerScience.addModule(machineLearning);
    machineLearning.addCourse(computerScience);

    Student johnSmith = new Student( "John", "Smith", 22, DateTime.parse("1999-01-01"));
    computerScience.registerStudent(johnSmith);
    softwareEngineering.registerStudent(johnSmith);
    advancedProfessionalSkills.registerStudent(johnSmith);
    informationRetrieval.registerStudent(johnSmith);

    Student marySue = new Student("Mary", "Sue", 21, DateTime.parse("2000-12-15"));
    computerScience.registerStudent(marySue);
    softwareEngineering.registerStudent(marySue);
    advancedProfessionalSkills.registerStudent(marySue);
    machineLearning.registerStudent(marySue);

    System.out.printf("Course: %s\n", computerScience.getName());
    System.out.println("Modules:");
    for (Module module: computerScience.getModules()) {
      System.out.printf("%s - %s\n", module.getId(), module.getName());
    }
    System.out.println("Students:");
    System.out.format("%8s %15s %12s %12s %15s\n", "ID", "Username", "First Name", "Last Name", "Date of Birth");
    for (Student student: computerScience.getStudents()) {
      System.out.format("%8s %15s %12s %12s %15s\n", student.getStudentID(), student.getUsername(), student.getFirstName(), student.getLastName(), student.getDob().toString(
          DateTimeFormat.shortDate()));
    }
  }
}
