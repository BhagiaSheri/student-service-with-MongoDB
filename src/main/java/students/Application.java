package students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import students.domain.Address;
import students.domain.Student;
import students.repository.StudentRepository;

import java.util.List;


@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// create students
		Student student = new Student(101, "John doe", "johnd@acme.com", "0622341678");
		Address address = new Address(201, "1000 N 4th S", "Fairfield", "52557");
		student.setAddress(address);
		studentRepository.save(student);

		student = new Student(102, "John Jones", "jones@acme.com", "0624321234");
		address = new Address(202, "1000 S 5th S", "Iowa", "53445");
		student.setAddress(address);
		studentRepository.save(student);

		student = new Student(103, "James Johnson", "jj123@acme.com", "068633452");
		address = new Address(203, "1000 N 8th S", "Des Moines", "67543");
		student.setAddress(address);
		studentRepository.save(student);

		student = new Student(104, "Johnson", "jj@acme.com", "009633452");
		address = new Address(204, "1001 N 7th S", "Iowa", "78654");
		student.setAddress(address);
		studentRepository.save(student);

		student = new Student(105, "James John", "jjohn34566@acme.com", "009033452");
		address = new Address(205, "9000 N 6th S", "Des Moines", "66943");
		student.setAddress(address);
		studentRepository.save(student);

		//get students
		System.out.println("----------- Students By Id ----------------");
		System.out.println(studentRepository.findById(103).get());
		System.out.println(studentRepository.findById(101).get());

		System.out.println("-----------All Students ----------------");
		System.out.println(studentRepository.findAll());

		//update customer
		System.out.println("----------- Update Student Email ----------------");
		student = studentRepository.findById(101).get();
		student.setEmail("jd@gmail.com");
		studentRepository.save(student);

		System.out.println("----------- find by phone ----------------");
		System.out.println(studentRepository.findByPhone("0622341678"));

		System.out.println("----------- find by email ----------------");
		System.out.println(studentRepository.findStudentWithEmail("jj123@acme.com"));

		System.out.println("----------- find students with city ----------------");
		List<Student> students = studentRepository.findStudentWithCity("Iowa");
		for (Student s : students) {
			System.out.println(s);
		}

		System.out.println("-----------find by name ----------------");
		System.out.println(studentRepository.findByName("John doe"));


	}

}
