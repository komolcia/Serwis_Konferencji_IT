package serwis.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "prelekcja_id", referencedColumnName = "id")

    public Prelekcja prelekcja;

    public void setPrelekcja(Prelekcja prelekcja) {
        this.prelekcja = prelekcja;
    }

    public Prelekcja getPrelekcja() {
        return prelekcja;
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
