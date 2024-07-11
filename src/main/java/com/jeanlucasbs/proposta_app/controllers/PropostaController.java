package com.jeanlucasbs.proposta_app.controllers;

import com.jeanlucasbs.proposta_app.dto.PropostaRequestDTO;
import com.jeanlucasbs.proposta_app.dto.PropostaResponseDTO;
import com.jeanlucasbs.proposta_app.services.PropostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/proposta")
public class PropostaController {
    @Autowired
    private PropostaService propostaService;
    @PostMapping
    public ResponseEntity<PropostaResponseDTO> criar(@RequestBody PropostaRequestDTO requestDto){
        PropostaResponseDTO response = propostaService.criar(requestDto);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                             .path("{id}")
                             .buildAndExpand(response.getId())
                             .toUri()).build();
    }

    @GetMapping
    public ResponseEntity<List<PropostaResponseDTO>> findAll(){
        return ResponseEntity.ok(propostaService.obterProposta());
    }


}
