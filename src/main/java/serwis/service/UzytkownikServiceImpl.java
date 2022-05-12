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

import javax.transaction.Transactional;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
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
   @Autowired
   public UzytkownikServiceImpl(UzytkownikRepository uzytkownikRepository){this.uzytkownikRepository=uzytkownikRepository;}
    @Override
    @Transactional
    public String addUzytkownik(Uzytkownik uzytkownik) {
       Uzytkownik uzytkownik1=getUzytkownikByLogin(uzytkownik.getLogin());

       if(uzytkownik.getLogin().equals( uzytkownik1.getLogin())==true){
           return "W bazie danych istnieje już użytkownik o danym loginie";
       }
        uzytkownikRepository.save(uzytkownik);
       return "Udało się!";
    }

    @Override
    public Uzytkownik getUzytkownikByLogin(String login) {
       Uzytkownik found=new Uzytkownik();
        Iterable<Uzytkownik> uzytkowniks=uzytkownikRepository.findAll();
        for( Uzytkownik uzytkownik: uzytkowniks){
            if(uzytkownik.getLogin().equals(login)==true){
                found=uzytkownik;
            }
        }
        return found;
    }
    @Override
    @Transactional
    public Uzytkownik getUzytkownikById(long id) {
        return uzytkownikRepository.findById(id);
    }

    @Override
    @Transactional
    public Iterable<Uzytkownik> getUzytkownik() {
        return uzytkownikRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteUzytkownik(long id) {
       Uzytkownik uzytkownik=getUzytkownikById(id);
        Set<Prelekcja> prelekcjaSet= uzytkownik.getPrelekcja();
        for(Prelekcja prelekcja: prelekcjaSet) {
            prelekcja.getUzytkownik().remove(uzytkownik);
        }
       uzytkownikRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateUzytkownik(String login,String email) {
        Uzytkownik uzytkownik= getUzytkownikByLogin(login);
        uzytkownik.setEmail(email);

       uzytkownikRepository.save(uzytkownik);
    }

    @Override
    public Uzytkownik addPrelekcja(long id,String login,String email) throws IOException {
        Prelekcja prelekcja= prelekcjaRepository.findById(id);
        Set<Uzytkownik> uzytkownikSet=prelekcja.getUzytkownik();
        Uzytkownik uzytkownik= getUzytkownikByLogin(login);

        if (uzytkownikSet.size()>=5){
            return uzytkownik;
        }

        if(uzytkownik.getEmail().equals(email)==true){

        }else{
            return uzytkownik;
        }
        Set<Prelekcja> prelekcjaSet= uzytkownik.getPrelekcja();
        for( Prelekcja prelekcja1: prelekcjaSet){
            if(prelekcja1.getDataZakonczenia().equals(prelekcja.getDataZakonczenia())==true && prelekcja1.getDataRozpoczecia().equals(prelekcja.getDataRozpoczecia())==true){
                return uzytkownik;
            }
        }
        FileWriter myWriter = new FileWriter("powiadomienia.txt",true);
        myWriter.write("Data wysłania: "+ LocalDateTime.now()+". Zapisałeś się na prelekcje. Do "+uzytkownik.getEmail()+"\n");
        myWriter.close();
        prelekcjaSet.add(prelekcja);



        uzytkownik.setPrelekcja(prelekcjaSet);
        uzytkownikSet.add(uzytkownik);
        prelekcja.setUzytkownik(uzytkownikSet);
        prelekcjaRepository.save(prelekcja);
        return uzytkownikRepository.save(uzytkownik);


    }

    @Override
    public Uzytkownik deletePrelekcja(long id,String login) {
        Prelekcja prelekcja= prelekcjaRepository.findById(id);
        Uzytkownik uzytkownik= getUzytkownikByLogin(login);
        Set<Prelekcja> prelekcjaSet= uzytkownik.getPrelekcja();
        prelekcjaSet.remove(prelekcja);

        uzytkownik.getPrelekcja().remove(prelekcja);
       Set<Uzytkownik> uzytkowniks=  prelekcja.getUzytkownik();
       uzytkowniks.remove(uzytkownik);
       prelekcja.getUzytkownik().remove(uzytkownik);
       prelekcjaRepository.save(prelekcja);
        return uzytkownikRepository.save(uzytkownik);
    }
    @Transactional
    public void makeKonferencja(){
      LocalDateTime data1= LocalDateTime.parse("2021-06-01T00:00:00");
        LocalDateTime data2= LocalDateTime.parse("2021-06-01T10:00:00");
        LocalDateTime data3= LocalDateTime.parse("2021-06-01T11:45:00");
        LocalDateTime data4= LocalDateTime.parse("2021-06-02T12:00:00");
        LocalDateTime data5= LocalDateTime.parse("2021-06-01T13:45:00");
        LocalDateTime data6= LocalDateTime.parse("2021-06-02T14:00:00");
        LocalDateTime data7= LocalDateTime.parse("2021-06-01T15:45:00");
        LocalDateTime data8= LocalDateTime.parse("2021-06-02T00:00:00");

        Prelekcja prelekcja1 = new Prelekcja(data2,data3);
        Prelekcja prelekcja2 = new Prelekcja(data4,data5);
        Prelekcja prelekcja3 = new Prelekcja(data6,data7);
        Prelekcja prelekcja4= new Prelekcja(data2,data3);
        Prelekcja prelekcja5 = new Prelekcja(data4,data5);
        Prelekcja prelekcja6 = new Prelekcja(data6,data7);
        Prelekcja prelekcja7 = new Prelekcja(data2,data3);
        Prelekcja prelekcja8 = new Prelekcja(data4,data5);
        Prelekcja prelekcja9 = new Prelekcja(data6,data7);

        Set<Prelekcja> prelekcjaSet= new HashSet<>();
        Set<Prelekcja> prelekcjaSet2= new HashSet<>();
        Set<Prelekcja> prelekcjaSet3= new HashSet<>();
        prelekcjaRepository.save(prelekcja1);
        prelekcjaRepository.save(prelekcja2);
        prelekcjaRepository.save(prelekcja3);
        prelekcjaRepository.save(prelekcja4);
        prelekcjaRepository.save(prelekcja5);
        prelekcjaRepository.save(prelekcja6);
        prelekcjaRepository.save(prelekcja7);
        prelekcjaRepository.save(prelekcja8);
        prelekcjaRepository.save(prelekcja9);
        prelekcjaSet.add(prelekcja1);
        prelekcjaSet.add(prelekcja2);
        prelekcjaSet.add(prelekcja3);
        prelekcjaSet2.add(prelekcja4);
        prelekcjaSet2.add(prelekcja5);
        prelekcjaSet2.add(prelekcja6);
        prelekcjaSet3.add(prelekcja7);
        prelekcjaSet3.add(prelekcja8);
        prelekcjaSet3.add(prelekcja9);
        Sciezka sciezka1=new Sciezka("Java",prelekcjaSet);
        Sciezka sciezka2=new Sciezka("Dot Net",prelekcjaSet2);
        Sciezka sciezka3=new Sciezka("C++",prelekcjaSet3);
        Set<Sciezka> sciezkaSet=new HashSet<>();
        sciezkaSet.add(sciezka1);
        sciezkaSet.add(sciezka2);
        sciezkaSet.add(sciezka3);
        sciezkaRepository.save(sciezka1);
        sciezkaRepository.save(sciezka2);
        sciezkaRepository.save(sciezka3);
        Konferencja konferencja=new Konferencja(data1,data8,sciezkaSet);


        konferencjaRepository.save(konferencja);

    }

}
