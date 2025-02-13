package fi.haagahelia.bookstore;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;
import fi.haagahelia.bookstore.domain.Category;
import fi.haagahelia.bookstore.domain.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseLoader {

    @Bean
    CommandLineRunner initDatabase(BookRepository bookRepository, CategoryRepository categoryRepository) {
        return args -> {
            // Create and save categories first
            Category fiction = new Category("Fiction");
            Category nonFiction = new Category("Non-Fiction");
            Category science = new Category("Science");

            categoryRepository.save(fiction);
            categoryRepository.save(nonFiction);
            categoryRepository.save(science);

            // Now create and save books with proper categories
            bookRepository.save(new Book("The Alchemist", "Paulo Coelho", 1988, "978-0061122415", 10.99, fiction));
            bookRepository.save(new Book("1984", "George Orwell", 1949, "978-0451524935", 8.99, nonFiction));
            bookRepository
                    .save(new Book("To Kill a Mockingbird", "Harper Lee", 1960, "978-0061120084", 12.50, science));

            // Add more categories and books as needed
        };
    }
}