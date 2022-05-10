package serwis.service;

import serwis.model.Uzytkownik;

public interface UzytkownikService {
    Uzytkownik addUzytkownik(Uzytkownik uzytkownik);
    Uzytkownik getUzytkownikById(long id);
    Uzytkownik getUzytkownikByLogin(String login);
    Iterable<Uzytkownik> getUzytkownik();
    void deleteUzytkownik(long id);
    void updateUzytkownik(Uzytkownik uzytkownik);
}
