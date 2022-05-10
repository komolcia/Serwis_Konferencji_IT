package serwis.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "prelekcja")
public class Prelekcja {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private Date dataRozpoczecia;
    @NotNull
    private Date dataZakonczenia;
    @OneToMany(fetch = FetchType.EAGER,  cascade = CascadeType.ALL,mappedBy = "prelekcja")

    public Set<Uzytkownik> uzytkownik = new HashSet<Uzytkownik>(0);
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sciezka_id", referencedColumnName = "id")

    public Sciezka sciezka;
    public Prelekcja(){}
    public Prelekcja(Date dataRozpoczecia,Date dataZakonczenia,Set<Uzytkownik> uzytkownik){
        this.dataRozpoczecia=dataRozpoczecia;
        this.dataZakonczenia=dataZakonczenia;
        this.uzytkownik=uzytkownik;
    }
    public void setSciezka(Sciezka sciezka) {
        this.sciezka = sciezka;
    }

    public void setDataZakonczenia(Date dataZakonczenia) {
        this.dataZakonczenia = dataZakonczenia;
    }

    public void setDataRozpoczecia(Date dataRozpoczecia) {
        this.dataRozpoczecia = dataRozpoczecia;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDataZakonczenia() {
        return dataZakonczenia;
    }

    public long getId() {
        return id;
    }
}
