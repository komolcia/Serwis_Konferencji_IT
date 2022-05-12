package serwis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import serwis.model.Konferencja;
import serwis.model.Prelekcja;
import serwis.model.Sciezka;
import serwis.model.Uzytkownik;
import serwis.repository.KonferencjaRepository;
import serwis.repository.PrelekcjaRepository;
import serwis.repository.UzytkownikRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class KonferencjaServiceImpl implements KonferencjaService{
    @Autowired
    UzytkownikRepository uzytkownikRepository;
    @Autowired
    PrelekcjaRepository prelekcjaRepository;
    public KonferencjaRepository konferencjaRepository;
    public  KonferencjaServiceImpl(KonferencjaRepository konferencjaRepository){this.konferencjaRepository= konferencjaRepository;}
    @Override
    public Iterable<Konferencja> getKonferencja() {
        return konferencjaRepository.findAll();
    }

    @Override
    public String getWyklady() {
        String zestawienie=new String();
        long ile=uzytkownikRepository.count();
        if( ile == 0)
        {
            return "Nie ma zapisanych";
        }
        Iterable<Konferencja>  konferencja=konferencjaRepository.findAll();
        for(Konferencja konferencja1: konferencja){
            Iterable<Sciezka> sciezkas=  konferencja1.getSciezka();
            for(Sciezka sciezka: sciezkas){

                Iterable<Prelekcja> prelekcjas= sciezka.getPrelekcja();
                for (Prelekcja prelekcja: prelekcjas){
                    Iterable<Uzytkownik> uzytkowniks=prelekcja.getUzytkownik();
                    long ileChodzi=0;
                    for(Uzytkownik uzytkownik: uzytkowniks){
                        ileChodzi+=1;
                    }
                    zestawienie+="Na prelekcje od "+prelekcja.getDataRozpoczecia()+" do "+prelekcja.getDataZakonczenia()+ " o temacie "+ sciezka.getTemat()+ " ma zestawienie "+(ileChodzi*100/ile)+"%.\n";
                }
            }
        }
        return zestawienie;
    }

    @Override
    public String getTemat() {
        String zestawienie=new String();
        long ile=uzytkownikRepository.count();
        if( ile == 0)
        {
            return "Nie ma zapisanych";
        }
        Iterable<Konferencja>  konferencja=konferencjaRepository.findAll();
        for(Konferencja konferencja1: konferencja){
            Iterable<Sciezka> sciezkas=  konferencja1.getSciezka();

            for(Sciezka sciezka: sciezkas){
                long ileChodzi=0;
                Iterable<Prelekcja> prelekcjas= sciezka.getPrelekcja();
                for (Prelekcja prelekcja: prelekcjas){
                    Iterable<Uzytkownik> uzytkowniks=prelekcja.getUzytkownik();

                    for(Uzytkownik uzytkownik: uzytkowniks){
                        ileChodzi+=1;
                    }

                }
                zestawienie+="Na  sciezke o temacie "+ sciezka.getTemat()+ " ma zestawienie "+(ileChodzi*100/ile)+" procent.\n";
            }
        }
        return zestawienie;
    }
}
