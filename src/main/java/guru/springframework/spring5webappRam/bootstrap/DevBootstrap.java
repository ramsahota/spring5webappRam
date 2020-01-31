package guru.springframework.spring5webappRam.bootstrap;

import guru.springframework.spring5webappRam.model.Author;
import guru.springframework.spring5webappRam.model.Book;
import guru.springframework.spring5webappRam.model.Publisher;
import guru.springframework.spring5webappRam.repositories.AuthorRepository;
import guru.springframework.spring5webappRam.repositories.BookRepository;
import guru.springframework.spring5webappRam.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

//Class gets created and managed by Spring Framework
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    //Author and Book Repositories that we get from Spring Data JPA get auto-wired into here via Depedency Injection.
    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        //Eric
        Author eric = new Author("Eric", "Evans");
        Publisher harperCollins = new Publisher("Harper Collins", "123 Fake Street");
        Book ddd = new Book("Domain Driven Design", "1234", harperCollins);

        //Book to Author Relationship
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        publisherRepository.save(harperCollins);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher worx = new Publisher("Worx", "456 ABC Street");
        Book noEJB = new Book("J2EE Development without EJB", "23444", worx);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        publisherRepository.save(worx);
        bookRepository.save(noEJB);
    }
}
