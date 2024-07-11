package com.jeanlucasbs.proposta_app.services;

import com.jeanlucasbs.proposta_app.dto.PropostaRequestDTO;
import com.jeanlucasbs.proposta_app.dto.PropostaResponseDTO;
import com.jeanlucasbs.proposta_app.entities.Proposta;
import com.jeanlucasbs.proposta_app.mapper.PropostaMapper;
import com.jeanlucasbs.proposta_app.repositories.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropostaService {

    @Autowired
    private PropostaRepository repository;

    public PropostaResponseDTO criar(PropostaRequestDTO requestDTO){
        Proposta proposta = PropostaMapper.INSTANCE.convertDtoToProposta(requestDTO);
        repository.save(proposta);
        return PropostaMapper.INSTANCE.convertEntityToDto(proposta);
    }

    public List<PropostaResponseDTO> obterProposta() {
        return PropostaMapper.INSTANCE.convertListEntityToListDto(repository.findAll());
    }
}
