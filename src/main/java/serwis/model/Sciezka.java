package serwis.model;

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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "konferencja_id", referencedColumnName = "id")

    public Konferencja konferencja;

    @OneToMany(fetch = FetchType.EAGER,  cascade = CascadeType.ALL,mappedBy = "sciezka")

    public Set<Prelekcja> prelekcja = new HashSet<Prelekcja>(0);


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
