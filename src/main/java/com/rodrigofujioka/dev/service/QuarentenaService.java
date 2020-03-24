package com.rodrigofujioka.dev.service;

import com.rodrigofujioka.dev.repository.QuarentenaRepository;
import com.rodrigofujioka.dev.service.dto.CrudService;
import com.rodrigofujioka.dev.web.domain.Quarentena;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuarentenaService implements CrudService<Quarentena> {

    @Autowired
    private QuarentenaRepository quarentenaRepository;
    //private String[] listaEstadoSemCorona = {"PB"};

    @Override
    public Quarentena salvar(Quarentena quarentena) {https://github.com/rodrigofujioka/programacaoweb/commit/798765c050f5256d573552e9669a54d12fe52fbc

        if (quarentena.getUf().equalsIgnoreCase("PB")) {
            throw new RuntimeException("Estado não possui teste");
        }
        return quarentenaRepository.save(quarentena);
    }

    public List<Quarentena> getQuarentenaByUf(String uf) {
        return quarentenaRepository.findQuarentenaByUf(uf);

    }

    @Override
    public List<Quarentena> getQuarentena() {
        return quarentenaRepository.findAll();

    }

    @Override
    public Quarentena getQuarentenaById(Long id) {

        return quarentenaRepository.findById(id).get();
    }

    @Override
    public Quarentena atualizar(Quarentena quarentena) {
        if (quarentena!=null) {
            return quarentenaRepository.save(quarentena);
        }
        throw new RuntimeException("ID precisa ser informado!");
    }

    public void deleteById(Long id) {
        quarentenaRepository.deleteById(id);
    }




}
