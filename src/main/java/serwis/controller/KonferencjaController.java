package serwis.controller;

import org.springframework.web.bind.annotation.*;
import serwis.model.Konferencja;
import serwis.service.KonferencjaService;

@RestController
@RequestMapping("/api")
public class KonferencjaController {
    public final KonferencjaService konferencjaService;
    public KonferencjaController(KonferencjaService konferencjaService){this.konferencjaService=konferencjaService;}
    @GetMapping("/plan")
    Iterable<Konferencja> getKonferencja(){
        return konferencjaService.getKonferencja();
    }
    @GetMapping("/wyklady")
    @ResponseBody
    String getPrelekcje(){
        return konferencjaService.getWyklady();
    }
    @GetMapping("/temat")
    @ResponseBody
    String getSciezka(){
        return konferencjaService.getTemat();
    }
}
