package fi.haagahelia.bookstore;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseLoader {
    @Bean
    CommandLineRunner initDatabase(BookRepository repository) {
        return args -> {
            repository.save(new Book("The Alchemist", "Paulo Coelho", 1988, "978-0061122415", 10.99));
            repository.save(new Book("1984", "George Orwell", 1949, "978-0451524935", 8.99));
            repository.save(new Book("To Kill a Mockingbird", "Harper Lee", 1960, "978-0061120084", 12.50));
        };
    }
}

/*
 * import fi.haagahelia.bookstore.domain.Category;
 * import fi.haagahelia.bookstore.domain.CategoryRepository;
 * 
 * @Configuration
 * public class DatabaseLoader {
 * 
 * @Bean
 * public CommandLineRunner categoryDemo(CategoryRepository repository) {
 * return (args) -> {
 * repository.save(new Category("Fiction"));
 * repository.save(new Category("Non-Fiction"));
 * repository.save(new Category("Science"));
 * repository.save(new Category("History"));
 * };
 * }
 * 
 * }
 */
