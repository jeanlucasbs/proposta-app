package com.jeanlucasbs.proposta_app.repositories;

import com.jeanlucasbs.proposta_app.entities.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta,Long> {

    List<Proposta> findAllByIntegradaIsFalse();
}
