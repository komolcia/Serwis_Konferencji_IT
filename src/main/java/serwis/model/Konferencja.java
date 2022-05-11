package serwis.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "konferencja")
public class Konferencja {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private LocalDateTime dataRozpoczecia;
    @NotNull
    private LocalDateTime dataZakonczenia;
    @OneToMany(  cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name="konferencja_sciezka")
    private Set<Sciezka> sciezka = new HashSet<Sciezka>(0);
    public Konferencja(){}
    public Konferencja(LocalDateTime dataRozpoczecia,LocalDateTime dataZakonczenia,Set<Sciezka> sciezka){
        this.dataRozpoczecia=dataRozpoczecia;
        this.dataZakonczenia=dataZakonczenia;
        this.sciezka=sciezka;
    }
    public long getId() {
        return id;
    }

    public LocalDateTime getDataRozpoczecia() {
        return dataRozpoczecia;
    }

    public LocalDateTime getDataZakonczenia() {
        return dataZakonczenia;
    }

    public Set<Sciezka> getSciezka() {
        return sciezka;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDataRozpoczecia(LocalDateTime dataRozpoczecia) {
        this.dataRozpoczecia = dataRozpoczecia;
    }

    public void setDataZakonczenia(LocalDateTime dataZakonczenia) {
        this.dataZakonczenia = dataZakonczenia;
    }

    public void setSciezka(Set<Sciezka> sciezka) {
        this.sciezka = sciezka;
    }
}
