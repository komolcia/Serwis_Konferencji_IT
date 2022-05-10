package serwis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import serwis.model.Uzytkownik;

@Repository
public interface UzytkownikRepository extends CrudRepository<Uzytkownik,Long> {
}
