package serwis.service;

import serwis.model.Konferencja;


public interface KonferencjaService {

    public Iterable<Konferencja> getKonferencja();
    public String getWyklady();
    public String getTemat();
}
