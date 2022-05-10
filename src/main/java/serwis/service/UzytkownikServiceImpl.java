package serwis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import serwis.model.Konferencja;
import serwis.model.Prelekcja;
import serwis.model.Sciezka;
import serwis.model.Uzytkownik;
import serwis.repository.KonferencjaRepository;
import serwis.repository.PrelekcjaRepository;
import serwis.repository.SciezkaRepository;
import serwis.repository.UzytkownikRepository;

import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class UzytkownikServiceImpl implements  UzytkownikService {
    @Autowired
    SciezkaRepository sciezkaRepository;
    @Autowired
    KonferencjaRepository konferencjaRepository;
    @Autowired
    PrelekcjaRepository prelekcjaRepository;
   public UzytkownikRepository uzytkownikRepository;
   public UzytkownikServiceImpl(UzytkownikRepository uzytkownikRepository){this.uzytkownikRepository=uzytkownikRepository;}
    @Override
    public Uzytkownik addUzytkownik(Uzytkownik uzytkownik) {
       Uzytkownik uzytkownik1=getUzytkownikByLogin(uzytkownik.getLogin());
       Uzytkownik uzytkownik2= new Uzytkownik();
       if(uzytkownik== uzytkownik1){
           return uzytkownik2;
       }
        return uzytkownikRepository.save(uzytkownik);
    }

    @Override
    public Uzytkownik getUzytkownikByLogin(String login) {
       Uzytkownik found=new Uzytkownik();
        Iterable<Uzytkownik> uzytkowniks=uzytkownikRepository.findAll();
        for( Uzytkownik uzytkownik: uzytkowniks){
            if(uzytkownik.getLogin()==login){
                found=uzytkownik;
            }
        }
        return found;
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
      LocalDateTime data1= LocalDateTime.parse("2021-06-01T00:00:00");
        LocalDateTime data2= LocalDateTime.parse("2021-06-01T10:00:00");
        LocalDateTime data3= LocalDateTime.parse("2021-06-01T11:45:00");
        LocalDateTime data4= LocalDateTime.parse("2021-06-02T12:00:00");
        LocalDateTime data5= LocalDateTime.parse("2021-06-01T13:45:00");
        LocalDateTime data6= LocalDateTime.parse("2021-06-02T14:00:00");
        LocalDateTime data7= LocalDateTime.parse("2021-06-01T15:45:00");
        LocalDateTime data8= LocalDateTime.parse("2021-06-02T00:00:00");
        Set<Uzytkownik> uzytkownik= new HashSet<>();
        Prelekcja prelekcja1 = new Prelekcja(data2,data3);
        Prelekcja prelekcja2 = new Prelekcja(data4,data5);
        Prelekcja prelekcja3 = new Prelekcja(data6,data7);
        Set<Prelekcja> prelekcjaSet= new HashSet<>();
        prelekcjaSet.add(prelekcja1);
        prelekcjaSet.add(prelekcja2);
        prelekcjaSet.add(prelekcja3);
        Sciezka sciezka1=new Sciezka("Java",prelekcjaSet);
        Sciezka sciezka2=new Sciezka("Dot Net",prelekcjaSet);
        Sciezka sciezka3=new Sciezka("C++",prelekcjaSet);
        Set<Sciezka> sciezkaSet=new HashSet<>();
        sciezkaSet.add(sciezka1);
        sciezkaSet.add(sciezka2);
        sciezkaSet.add(sciezka3);
        Konferencja konferencja=new Konferencja(data1,data8,sciezkaSet);
        prelekcjaRepository.save(prelekcja1);
        prelekcjaRepository.save(prelekcja2);
        prelekcjaRepository.save(prelekcja3);
        sciezkaRepository.save(sciezka1);
        sciezkaRepository.save(sciezka2);
        sciezkaRepository.save(sciezka3);
        konferencjaRepository.save(konferencja);

    }

}
