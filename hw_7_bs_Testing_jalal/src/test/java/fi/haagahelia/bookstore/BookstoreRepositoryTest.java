package fi.haagahelia.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;
import fi.haagahelia.bookstore.domain.Category;
import fi.haagahelia.bookstore.domain.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = BookstoreApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // if you are using a real database
public class BookstoreRepositoryTest {

    // Field injection is used for test cases
    @Autowired
    private BookRepository repository;

    @Autowired
    private CategoryRepository drepository;

    @Test
    public void findByAuthorShouldReturnBook() {
        // Assuming the CommandLineRunner has inserted a book by "George Orwell" (title:
        // "1984")
        List<Book> books = repository.findByAuthor("George Orwell");

        assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle()).isEqualTo("1984");
    }

    @Test
    public void createNewBook() {
        // Create and save a new category similar to the "BITE" department in
        // StudentRepositoryTest
        Category category = new Category("BITE");
        drepository.save(category);
        // Create a new book with sample data
        Book book = new Book("Mouse", "Mickey", 2025, "dummy-isbn", 12.34, category);
        repository.save(book);
        assertThat(book.getId()).isNotNull();
    }

    @Test
    public void deleteNewBook() {
        // Find an existing book by author "George Orwell" and delete it
        List<Book> books = repository.findByAuthor("George Orwell");
        Book book = books.get(0);
        repository.delete(book);
        List<Book> newBooks = repository.findByAuthor("George Orwell");
        assertThat(newBooks).hasSize(0);
    }
}