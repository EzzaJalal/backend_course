package fi.haagahelia.bookstore.web;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {
    private final BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/booklist")
    public String showBookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

    @GetMapping("/add")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute Book book) {
        repository.save(book);
        return "redirect:/booklist";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return "redirect:/booklist";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
        Book book = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        model.addAttribute("book", book);
        return "editbook";
    }

    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable("id") Long id, @ModelAttribute Book book) {
        book.setId(id);
        repository.save(book);
        return "redirect:/booklist";
    }
}

/*
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.stereotype.Controller;
 * import org.springframework.ui.Model;
 * import org.springframework.web.bind.annotation.RequestMapping;
 * import org.springframework.web.bind.annotation.RequestMethod;
 * 
 * import fi.haagahelia.bookstore.domain.Book;
 * import fi.haagahelia.bookstore.domain.BookRepository;
 * import fi.haagahelia.bookstore.domain.CategoryRepository;
 * 
 * @Controller
 * public class BookController {
 * 
 * @Autowired
 * private BookRepository repository;
 * 
 * @Autowired
 * private CategoryRepository categoryRepository;
 * 
 * @RequestMapping(value = "/addbook")
 * public String addBook(Model model) {
 * model.addAttribute("book", new Book());
 * model.addAttribute("categories", categoryRepository.findAll());
 * return "addbook";
 * }
 * 
 * @RequestMapping(value = "/save", method = RequestMethod.POST)
 * public String saveBook(Book book) {
 * repository.save(book);
 * return "redirect:/booklist";
 * }
 * }
 */
