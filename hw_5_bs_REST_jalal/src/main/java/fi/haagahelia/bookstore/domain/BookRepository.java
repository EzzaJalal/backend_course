package fi.haagahelia.bookstore.domain;

import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);

    // List<Book> findByIsbn(String isbn);

    @Query("SELECT b FROM Book b WHERE b.title LIKE 'T%'")
    List<Book> findBooksWithTitleStartingWithT();
}
