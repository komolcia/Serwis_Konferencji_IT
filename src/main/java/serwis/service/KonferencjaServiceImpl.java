package serwis.service;

import serwis.model.Konferencja;
import serwis.repository.KonferencjaRepository;


public class KonferencjaServiceImpl implements KonferencjaService{
    public KonferencjaRepository konferencjaRepository;
    public  KonferencjaServiceImpl(KonferencjaRepository konferencjaRepository){this.konferencjaRepository= konferencjaRepository;}
    @Override
    public Iterable<Konferencja> getKonferencja() {
        return konferencjaRepository.findAll();
    }
}
