package serwis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import serwis.model.Prelekcja;

@Repository
public interface PrelekcjaRepository extends CrudRepository<Prelekcja,Long> {
    Prelekcja findById(long id);
}
