package serwis.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    private Date dataRozpoczecia;
    @NotNull
    private Date dataZakonczenia;
    @OneToMany(fetch = FetchType.EAGER,  cascade = CascadeType.ALL,mappedBy = "konferencja")

    public Set<Sciezka> sciezka = new HashSet<Sciezka>(0);
    public Konferencja(){}
    public Konferencja(Date dataRozpoczecia,Date dataZakonczenia,Set<Sciezka> sciezka){
        this.dataRozpoczecia=dataRozpoczecia;
        this.dataZakonczenia=dataZakonczenia;
        this.sciezka=sciezka;
    }
    public long getId() {
        return id;
    }

    public Date getDataRozpoczecia() {
        return dataRozpoczecia;
    }

    public Date getDataZakonczenia() {
        return dataZakonczenia;
    }

    public Set<Sciezka> getSciezka() {
        return sciezka;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDataRozpoczecia(Date dataRozpoczecia) {
        this.dataRozpoczecia = dataRozpoczecia;
    }

    public void setDataZakonczenia(Date dataZakonczenia) {
        this.dataZakonczenia = dataZakonczenia;
    }

    public void setSciezka(Set<Sciezka> sciezka) {
        this.sciezka = sciezka;
    }
}
