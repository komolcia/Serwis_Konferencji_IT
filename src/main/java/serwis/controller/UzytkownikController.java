package serwis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import serwis.exception.UzytkownikNotFoundException;
import serwis.model.Uzytkownik;
import serwis.service.UzytkownikService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/konferencja")
public class UzytkownikController {
    private final UzytkownikService uzytkownikService;
    public UzytkownikController(@Autowired @Valid UzytkownikService uzytkownikService){this.uzytkownikService=uzytkownikService;}
    @PostMapping()
    Uzytkownik addUzytkownik(@RequestBody @Valid Uzytkownik uzytkownik){ return uzytkownikService.addUzytkownik(uzytkownik);}
    @GetMapping()
    Iterable<Uzytkownik> getAll(){return uzytkownikService.getUzytkownik();}
    @GetMapping("{id}")
    Uzytkownik getUzytkownikById(@PathVariable long id){
        Uzytkownik found=uzytkownikService.getUzytkownikById(id);
        if( found == null){
            throw new UzytkownikNotFoundException();
        }return uzytkownikService.getUzytkownikById(id);
    }
    @DeleteMapping("{id}")
    void deleteUzytkownik(@PathVariable long id){
        Uzytkownik found=uzytkownikService.getUzytkownikById(id);
        if( found == null){
            throw new UzytkownikNotFoundException();
        }
        uzytkownikService.deleteUzytkownik(id);
    }
    @PutMapping()
    void updateStudent(@RequestBody @Valid Uzytkownik uzytkownik){
        uzytkownikService.updateUzytkownik(uzytkownik);
    }
}
