package serwis.service;

import serwis.model.Uzytkownik;

import java.io.IOException;
import java.util.Optional;

public interface UzytkownikService {
    String addUzytkownik(Uzytkownik uzytkownik);
    Uzytkownik getUzytkownikById(long id);
    Uzytkownik getUzytkownikByLogin(String login);
    Iterable<Uzytkownik> getUzytkownik();
    void deleteUzytkownik(long id);
    void updateUzytkownik(String login,String email);
    Uzytkownik addPrelekcja(long id, String login,String email) throws IOException;
    Uzytkownik deletePrelekcja(long id,String login);

}
