package serwis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import serwis.model.Sciezka;

@Repository
public interface SciezkaRepository extends CrudRepository<Sciezka,Long> {
}
