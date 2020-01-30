package guru.springframework.spring5webappRam.repositories;

import guru.springframework.spring5webappRam.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
