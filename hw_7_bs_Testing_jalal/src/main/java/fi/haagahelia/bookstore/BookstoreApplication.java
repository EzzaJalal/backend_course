package fi.haagahelia.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.bookstore.domain.AppUser;
import fi.haagahelia.bookstore.domain.AppUserRepository;
import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;
import fi.haagahelia.bookstore.domain.Category;
import fi.haagahelia.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository,
			CategoryRepository categoryRepository,
			AppUserRepository userRepository) {
		return (args) -> {
			log.info("save a couple of books and categories");

			// Create and save sample categories
			categoryRepository.save(new Category("Fiction"));
			categoryRepository.save(new Category("Non-Fiction"));
			categoryRepository.save(new Category("Science"));

			// Retrieve saved categories
			Category fiction = categoryRepository.findByName("Fiction").get(0);
			Category nonFiction = categoryRepository.findByName("Non-Fiction").get(0);
			Category science = categoryRepository.findByName("Science").get(0);

			// Create and save sample books
			bookRepository.save(new Book("The Alchemist", "Paulo Coelho", 1988, "978-0061122415", 10.99, fiction));
			bookRepository.save(new Book("1984", "George Orwell", 1949, "978-0451524935", 8.99, nonFiction));
			bookRepository
					.save(new Book("To Kill a Mockingbird", "Harper Lee", 1960, "978-0061120084", 12.50, science));

			// Create sample users using hardcoded password hashes (matching
			// StudentListApplication style)
			AppUser USER = new AppUser("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			AppUser ADMIN = new AppUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C",
					"ADMIN");
			userRepository.save(USER);
			userRepository.save(ADMIN);

			log.info("fetch all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
