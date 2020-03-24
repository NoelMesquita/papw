package com.rodrigofujioka.dev.web.rest;


import com.rodrigofujioka.dev.repository.QuarentenaRepository;
import com.rodrigofujioka.dev.service.QuarentenaService;
import com.rodrigofujioka.dev.web.domain.Quarentena;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class QuarentenaRest {

    @Autowired
    private QuarentenaService quarentenaService;

    //private QuarentenaRepository quarentenaRepository;

    @PostMapping("/quarentena")
    public Quarentena salvar(@RequestBody @Valid Quarentena quarentena) {
        Quarentena quarentenaSalva = quarentenaService.salvar(quarentena);
        return  quarentenaSalva;

    }


    @GetMapping("/quarentena/{estado}")
    public List<Quarentena> getQuarentena(@PathVariable String estado) {
        return quarentenaService.getQuarentenaByUf(estado);

    }

    @GetMapping ("/quarentena/{id}")
    public Quarentena findById(@PathVariable Long id) {

        return quarentenaService.getQuarentenaById(id);
    }

    @GetMapping("/quarentena")
    public List<Quarentena> getQuarentena() {
        return quarentenaService.getQuarentena();

    }

    @PutMapping("/quarentena")
    public Quarentena atualizar(
            @RequestBody @Valid Quarentena quarentena) {

        Quarentena quarentenaSalva = quarentenaService.salvar(quarentena);
        return quarentenaService.atualizar(quarentena);
    }


    @DeleteMapping("/quarentena/{id}")
    public ResponseEntity<Quarentena> deleteById(@RequestParam Long id) {
        quarentenaService.deleteById(id);
        return ResponseEntity.ok().build();
    }



    //Implementar busca por ID, Exclusão e Atualização;


}
