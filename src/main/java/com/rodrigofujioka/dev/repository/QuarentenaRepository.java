package com.rodrigofujioka.dev.repository;

import com.rodrigofujioka.dev.web.domain.Quarentena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuarentenaRepository extends JpaRepository<Quarentena, Long> {

    //select * from quarentena where uf
    public List<Quarentena> findQuarentenaByUf(String uf);

}
