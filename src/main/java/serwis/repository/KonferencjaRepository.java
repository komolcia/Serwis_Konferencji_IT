package serwis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import serwis.model.Konferencja;

@Repository
public interface KonferencjaRepository extends CrudRepository <Konferencja,Long> {
}
