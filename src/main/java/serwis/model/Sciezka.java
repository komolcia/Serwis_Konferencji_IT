package serwis.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sciezka")
public class Sciezka {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private String temat;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "konferencja_id")

    private Konferencja konferencja;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name="sciezka_prelekcja")
    private Set<Prelekcja> prelekcja = new HashSet<Prelekcja>(0);
    public Sciezka(){}
    public Sciezka(String temat,Set<Prelekcja> prelekcja){
        this.prelekcja=prelekcja;
        this.temat=temat;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTemat() {
        return temat;
    }

    public void setTemat(String temat) {
        this.temat = temat;
    }

    public Set<Prelekcja> getPrelekcja() {
        return prelekcja;
    }

    public void setPrelekcja(Set<Prelekcja> prelekcja) {
        this.prelekcja = prelekcja;
    }
}
