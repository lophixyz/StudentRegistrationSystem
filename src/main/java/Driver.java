import com.github.lophixyz.Course;
import com.github.lophixyz.Module;
import com.github.lophixyz.Student;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

public class Driver {

  public static void main(String[] args) {
    Course computerScience = new Course("Computer Science and Information Technology", DateTime.parse("2021-09-06"), DateTime.parse("2022-05-07"));
    Module softwareEngineering = new Module("CT417", "Software Engineering III");
    Module advancedProfessionalSkills = new Module("CT436", "Advanced Professional Skills");
    Module informationRetrieval = new Module("CT4100", "Information Retrieval");
    Module machineLearning = new Module("CT4101", "Machine Learning");
    addModuleToCourse(softwareEngineering, computerScience);
    addModuleToCourse(advancedProfessionalSkills, computerScience);
    addModuleToCourse(informationRetrieval, computerScience);
    addModuleToCourse(machineLearning, computerScience);

    Student johnSmith = new Student( "John", "Smith", 22, DateTime.parse("1999-01-01"));
    registerStudentForCourse(johnSmith, computerScience);
    registerStudentForModule(johnSmith, softwareEngineering);
    registerStudentForModule(johnSmith, advancedProfessionalSkills);
    registerStudentForModule(johnSmith, informationRetrieval);

    Student marySue = new Student("Mary", "Sue", 21, DateTime.parse("2000-12-15"));
    registerStudentForCourse(marySue, computerScience);
    registerStudentForModule(marySue, softwareEngineering);
    registerStudentForModule(marySue, informationRetrieval);
    registerStudentForModule(marySue, machineLearning);

    System.out.printf("Course: %s\n", computerScience.getName());
    System.out.printf("%s's Modules: \n", computerScience.getName());
    System.out.format("\t\t%10s %40s\n", "Module ID", "Module Name");
    for (Module module: computerScience.getModules()) {
      System.out.format("\t\t%10s %40s\n", module.getId(), module.getName());
    }
    System.out.println("Students:");
    System.out.format("\t\t%3s %15s %50s\n", "ID", "Username", "Course");
    for (Student student: computerScience.getStudents()) {
      System.out.format("\t\t%3s %15s %50s\n", student.getStudentID(), student.getUsername(), student.getCourse().getName());
    }
    for (Student student: computerScience.getStudents()) {
      System.out.printf("%s's Registered Modules:\n", student.getUsername());
      System.out.format("\t\t%10s %40s\n", "Module ID", "Module Name");
      for (Module module : student.getModules()) {
        System.out.format("\t\t%10s %40s\n", module.getId(), module.getName());
      }
    }
  }

  public static void registerStudentForModule(Student student, Module module) {
    module.registerStudent(student);
    student.addModule(module);
  }

  public static void registerStudentForCourse(Student student, Course course) {
    course.registerStudent(student);
    student.setCourse(course);
  }

  public static void addModuleToCourse(Module module, Course course) {
    course.addModule(module);
    module.addCourse(course);
  }

}
