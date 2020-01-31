package guru.springframework.spring5webappRam.repositories;

import guru.springframework.spring5webappRam.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
