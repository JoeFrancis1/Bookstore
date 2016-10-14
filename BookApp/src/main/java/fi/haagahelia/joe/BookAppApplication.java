package fi.haagahelia.joe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.joe.BookAppApplication;
import fi.haagahelia.joe.domain.Book;
import fi.haagahelia.joe.domain.BookRepository;

@SpringBootApplication
public class BookAppApplication {
	private static final Logger log = LoggerFactory.getLogger(BookAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookAppApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return (args) -> {
			
			log.info("save a couple of books");
			repository.save(new Book(1234, "A Book", "Someone", 1998, 31.00));
			repository.save(new Book(1212, "B Book", "Whoever", 2001, 15.00));	
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}