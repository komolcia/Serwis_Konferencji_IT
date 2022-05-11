package serwis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "prelekcja")
@JsonIgnoreProperties({ "uzytkownik" })
public class Prelekcja {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private LocalDateTime dataRozpoczecia;
    @NotNull
    private LocalDateTime dataZakonczenia;

    @ManyToMany(mappedBy = "prelekcja")
    private Set<Uzytkownik> uzytkownik = new HashSet<Uzytkownik>(0);
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sciezka_id", referencedColumnName = "id")

    private Sciezka sciezka;
    public Prelekcja(){}
    public Prelekcja(LocalDateTime dataRozpoczecia,LocalDateTime dataZakonczenia){
        this.dataRozpoczecia=dataRozpoczecia;
        this.dataZakonczenia=dataZakonczenia;

    }


    public Set<Uzytkownik> getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(Set<Uzytkownik> uzytkownik) {
        this.uzytkownik = uzytkownik;
    }

    public void setSciezka(Sciezka sciezka) {
        this.sciezka = sciezka;
    }

    public LocalDateTime getDataRozpoczecia() {
        return dataRozpoczecia;
    }

    public void setDataZakonczenia(LocalDateTime dataZakonczenia) {
        this.dataZakonczenia = dataZakonczenia;
    }

    public void setDataRozpoczecia(LocalDateTime dataRozpoczecia) {
        this.dataRozpoczecia = dataRozpoczecia;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDataZakonczenia() {
        return dataZakonczenia;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Prelekcja{" +
                "id=" + id +
                ", dataRozpoczecia=" + dataRozpoczecia +
                ", dataZakonczenia=" + dataZakonczenia +
                ", uzytkownik=" + uzytkownik +
                ", sciezka=" + sciezka +
                '}';
    }
}
