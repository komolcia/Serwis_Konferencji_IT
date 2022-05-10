package serwis.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "prelekcja")
public class Prelekcja {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private LocalDate dataRozpoczecia;
    @NotNull
    private LocalDate dataZakonczenia;
    @OneToMany(fetch = FetchType.EAGER,  cascade = CascadeType.ALL,mappedBy = "prelekcja")

    public Set<Uzytkownik> uzytkownik = new HashSet<Uzytkownik>(0);
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sciezka_id", referencedColumnName = "id")

    public Sciezka sciezka;
    public Prelekcja(){}
    public Prelekcja(LocalDate dataRozpoczecia,LocalDate dataZakonczenia,Set<Uzytkownik> uzytkownik){
        this.dataRozpoczecia=dataRozpoczecia;
        this.dataZakonczenia=dataZakonczenia;
        this.uzytkownik=uzytkownik;
    }
    public void setSciezka(Sciezka sciezka) {
        this.sciezka = sciezka;
    }

    public void setDataZakonczenia(LocalDate dataZakonczenia) {
        this.dataZakonczenia = dataZakonczenia;
    }

    public void setDataRozpoczecia(LocalDate dataRozpoczecia) {
        this.dataRozpoczecia = dataRozpoczecia;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDataZakonczenia() {
        return dataZakonczenia;
    }

    public long getId() {
        return id;
    }
}
