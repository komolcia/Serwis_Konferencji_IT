package serwis.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "uzytkownik")
public class Uzytkownik {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    @Size(min=2,max=20,message = "Nazwa pomiędzy 2 do 20 znaków")
    private String login;
    @NotNull
    private String email;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "uzytkownik_prelekcje",
            joinColumns = @JoinColumn(name = "uzytkownik_id"),
            inverseJoinColumns = @JoinColumn(name = "prelekcje_id")
    )
    Set<Prelekcja> prelekcja = new HashSet<Prelekcja>(0);


    public Set<Prelekcja> getPrelekcja() {
        return prelekcja;
    }

    public void setPrelekcja(Set<Prelekcja> prelekcja) {
        this.prelekcja = prelekcja;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
