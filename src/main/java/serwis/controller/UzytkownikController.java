package serwis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import serwis.exception.UzytkownikNotFoundException;
import serwis.model.Konferencja;
import serwis.model.Uzytkownik;
import serwis.service.UzytkownikService;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class UzytkownikController {
    private final UzytkownikService uzytkownikService;
    public UzytkownikController(@Autowired @Valid UzytkownikService uzytkownikService){this.uzytkownikService=uzytkownikService;}
    @PostMapping("/uzytkownik")
    String addUzytkownik(@RequestBody @Valid Uzytkownik uzytkownik){ return uzytkownikService.addUzytkownik(uzytkownik);}
    @GetMapping("/uzytkownik")
    Iterable<Uzytkownik> getAll(){return uzytkownikService.getUzytkownik();}
    @GetMapping("/uzytkownik/{id}")
    Uzytkownik getUzytkownikById(@PathVariable long id){
        Uzytkownik found=uzytkownikService.getUzytkownikById(id);
        if( found == null){
            throw new UzytkownikNotFoundException();
        }return uzytkownikService.getUzytkownikById(id);
    }
    @GetMapping("/{login}")
    Uzytkownik getUzytkownikByLogin(@PathVariable String login){
        Uzytkownik found=uzytkownikService.getUzytkownikByLogin(login);
        if( found == null){
            throw new UzytkownikNotFoundException();
        }return uzytkownikService.getUzytkownikByLogin(login);
    }
    @DeleteMapping("/uzytkownik/{id}")
    void deleteUzytkownik(@PathVariable long id){
        Uzytkownik found=uzytkownikService.getUzytkownikById(id);
        if( found == null){
            throw new UzytkownikNotFoundException();
        }
        uzytkownikService.deleteUzytkownik(id);
    }
    @GetMapping("/{login}/{email}")
    void updateStudent(@PathVariable String login,@PathVariable String email){
        uzytkownikService.updateUzytkownik(login,email);
    }
    @GetMapping("/{login}/{email}/{id}")
    Uzytkownik addPrelekcja(@PathVariable String login,@PathVariable String email,@PathVariable long id) throws IOException {
        return uzytkownikService.addPrelekcja(id,login,email);
    }
    @GetMapping("/{login}/usun/{id}")
    Uzytkownik deletePrelekcja(@PathVariable String login,@PathVariable long id){
        return uzytkownikService.deletePrelekcja(id,login);
    }

}
