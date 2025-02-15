package fi.haagahelia.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;

@RestController
public class BookRestController {
    private final BookRepository bookRepository;

    public BookRestController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // RESTful service to get all books
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> bookListRest() {
        return (List<Book>) bookRepository.findAll();
    }

    // RESTful service to get book by id
    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long id) {
        return bookRepository.findById(id);
    }

    // RESTful service to save new book
    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public @ResponseBody Book saveNewBookRest(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    // RESTful service to delete book
    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void deleteBookRest(@PathVariable("id") Long id) {
        bookRepository.deleteById(id);
    }
}
