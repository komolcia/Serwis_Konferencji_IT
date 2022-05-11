package serwis.service;

import serwis.model.Uzytkownik;

import java.io.IOException;
import java.util.Optional;

public interface UzytkownikService {
    Uzytkownik addUzytkownik(Uzytkownik uzytkownik);
    Uzytkownik getUzytkownikById(long id);
    Uzytkownik getUzytkownikByLogin(String login);
    Iterable<Uzytkownik> getUzytkownik();
    void deleteUzytkownik(long id);
    void updateUzytkownik(Uzytkownik uzytkownik);
    Uzytkownik addPrelekcja(long id, String login) throws IOException;
    Uzytkownik deletePrelekcja(long id,String login);

}
