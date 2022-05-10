package serwis.service;

import org.springframework.stereotype.Service;
import serwis.model.Prelekcja;
import serwis.model.Uzytkownik;
import serwis.repository.UzytkownikRepository;
@Service
public class UzytkownikServiceImpl implements  UzytkownikService {
   public UzytkownikRepository uzytkownikRepository;
   public UzytkownikServiceImpl(UzytkownikRepository uzytkownikRepository){this.uzytkownikRepository=uzytkownikRepository}
    @Override
    public Uzytkownik addUzytkownik(Uzytkownik uzytkownik) {
        return uzytkownikRepository.save(uzytkownik);
    }

    @Override
    public Uzytkownik getUzytkownikById(long id) {
        return uzytkownikRepository.findById(id);
    }

    @Override
    public Iterable<Uzytkownik> getUzytkownik() {
        return uzytkownikRepository.findAll();
    }

    @Override
    public void deleteUzytkownik(long id) {
        uzytkownikRepository.deleteById(id);
    }

    @Override
    public void updateUzytkownik(Uzytkownik uzytkownik) {
        uzytkownikRepository.save(uzytkownik);
    }
    public void makeKonferencja(){
       Prelekcja prelekcja1 = new Prelekcja()
    }

}
