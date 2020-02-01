package guru.springframework.spring5webappRam.controllers;

import guru.springframework.spring5webappRam.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//Registration of the class in Spring. Spring is going to detect as a Spring bean and create class for us and wire into Spring Context.
@Controller
public class BookController {

    private BookRepository bookRepository;

    //Spring will auto-wire for us and we will get an instance of that.
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //Pass Model and it gets invoked when we call /books
    //Request gets in for the books URL
    //Spring MVC will pass in an instance of the Model
    @RequestMapping("/books")
    public String getBooks(Model model) {
        //Add an attribute called books to the model and we will get a list of books out of the book repository.
        //book repository underneath is using spring data JPA and is going to use hibernate to get list of books from our database.
        //get list of books coming from the BookRespository
        model.addAttribute("books", bookRepository.findAll());
        //returning the string called "books" which will tell Spring MVC to associate this with a view called "books"
        return "books";
    }
}
