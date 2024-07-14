package com.jeanlucasbs.proposta_app.services;

import com.jeanlucasbs.proposta_app.dto.PropostaRequestDTO;
import com.jeanlucasbs.proposta_app.dto.PropostaResponseDTO;
import com.jeanlucasbs.proposta_app.entities.Proposta;
import com.jeanlucasbs.proposta_app.mapper.PropostaMapper;
import com.jeanlucasbs.proposta_app.repositories.PropostaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropostaService {

    private PropostaRepository repository;

    NotificacaoService notificacaoService;

    private String exchange;

    public PropostaService(PropostaRepository repository,
                           NotificacaoService notificacaoService,
                           @Value("${rabbitmq.propostapendente.exchange}") String exchange) {
        this.repository = repository;
        this.notificacaoService = notificacaoService;
        this.exchange = exchange;
    }

    public PropostaResponseDTO criar(PropostaRequestDTO requestDTO){
        Proposta proposta = PropostaMapper.INSTANCE.convertDtoToProposta(requestDTO);
        repository.save(proposta);

        notificarRabbitMQ(proposta);

        return PropostaMapper.INSTANCE.convertEntityToDto(proposta);
    }

    private void notificarRabbitMQ(Proposta proposta){
        try {
            notificacaoService.notificar(proposta, exchange);
        } catch (RuntimeException ex){
            proposta.setIntegrada(false);
            repository.save(proposta);
        }


    }

    public List<PropostaResponseDTO> obterProposta() {
        return PropostaMapper.INSTANCE.convertListEntityToListDto(repository.findAll());
    }
}
