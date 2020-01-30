package guru.springframework.spring5webappRam.repositories;

import guru.springframework.spring5webappRam.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
