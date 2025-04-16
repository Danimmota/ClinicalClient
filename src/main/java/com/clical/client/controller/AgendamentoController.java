package com.clical.client.controller;

import com.clical.client.dto.AgendamentoDTO;
import com.clical.client.dto.ProfissionalDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.clical.client.service.AgendamentoService;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<AgendamentoDTO> saveAgendamento(@RequestBody @Valid AgendamentoDTO agendamento) {
        AgendamentoDTO response = agendamentoService.saveAgendamento(agendamento);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
