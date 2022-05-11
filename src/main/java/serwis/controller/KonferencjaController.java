package serwis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import serwis.model.Konferencja;
import serwis.service.KonferencjaService;

@RestController
@RequestMapping("/api")
public class KonferencjaController {
    public final KonferencjaService konferencjaService;
    public KonferencjaController(KonferencjaService konferencjaService){this.konferencjaService=konferencjaService;}
    @GetMapping("/plan/{id}")
    Iterable<Konferencja> getKonferencja(@PathVariable long id){
        return konferencjaService.getKonferencja();
    }
    @GetMapping("/zestawienie/wyklady")
    String getPrelekcje(){
        return konferencjaService.getWyklady();
    }
    @GetMapping("/zestawienie/temat")
    String getSciezka(){
        return konferencjaService.getTemat();
    }
}
