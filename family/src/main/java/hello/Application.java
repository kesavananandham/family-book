
package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private PersonRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		// save a couple of customers
		repository.save(new Person("3","Kesavan", "Anandham"));
		repository.save(new Person("4","Boominathan", "Anandham"));

		// fetch all customers
		System.out.println("Person found with findAll():");
		System.out.println("-------------------------------");
		for (Person person : repository.findAll()) {
			System.out.println(person);
		}
		System.out.println();



		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Person customer : repository.findByLastName("Smith")) {
			System.out.println(customer.getLastName());
		}

	}

}
