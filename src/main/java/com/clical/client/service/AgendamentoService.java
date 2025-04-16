package com.clical.client.service;


import com.clical.client.dto.AgendamentoDTO;
import com.clical.client.model.Agendamento;
import com.clical.client.model.Client;
import com.clical.client.model.Servico;
import com.clical.client.producers.AgendamentoProducer;
import com.clical.client.repository.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProfissionalRepository profissionalRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private ProfissionalClienteRepository profissionalClienteRepository;

    @Autowired
    private ProfissionalServicoRepository profissionalServicoRepository;

    @Autowired
    private AgendamentoProducer agendamentoProducer;


    @Transactional
    public AgendamentoDTO saveAgendamento(AgendamentoDTO dto) {
        Agendamento agendamento = toAgendamento(dto);

        Client client = clientRepository.findById(dto.getCpfClient())
                .orElseThrow(() -> new EntityNotFoundException("Cliente com CPF " + dto.getCpfClient() + " não encontrado"));
        Servico servico = servicoRepository.findById(dto.getServicoId())
                .orElseThrow(() -> new EntityNotFoundException("Serviço com ID " + dto.getServicoId() + " não encontrado"));

        agendamento.setDateTime(LocalDateTime.now());
        agendamento = agendamentoRepository.save(agendamento);

        agendamentoProducer.publishMassegeEmail(agendamento, client, servico);

        return toAgendamentoDTO(agendamento);
    }
//    @Transactional
//    public Agendamento saveAgendamento(Agendamento agendamento, Client client, Servico servico) {
//        agendamento = agendamentoRepository.save(agendamento);
//        agendamentoProducer.publishMassegeEmail(agendamento, client, servico);
//
//        return agendamento;
//    }

    // Ver todos os agendamentos
    // Ver os agendamentos por cliente
    // Ver todos os agendamentos por profissional
    // Editar o profissional do agendamento - permissão apenas para user
    // Deletar o agendamento

    // Metodo para converter o objeto Model em objeto DTO
    private Agendamento toAgendamento(AgendamentoDTO dto) {
        var agendamento = new Agendamento();

        agendamento.setIdAgendamento(dto.getIdAgendamento());
        agendamento.setServicoId(dto.getServicoId());
        agendamento.setCpfClient(dto.getCpfClient());
        agendamento.setIdAgenda(dto.getIdAgenda());
        agendamento.setDateTime(dto.getDateTime());
        return agendamento;
    }

    // Metodo para converter o objeto DTO em objeto Model
    private AgendamentoDTO toAgendamentoDTO(Agendamento agendamento) {
        var dto = new AgendamentoDTO();

        dto.setIdAgendamento(agendamento.getIdAgendamento());
        dto.setServicoId(agendamento.getServicoId());
        dto.setCpfClient(agendamento.getCpfClient());
        dto.setIdAgenda(agendamento.getIdAgenda());
        dto.setDateTime(agendamento.getDateTime());
        return dto;
    }

}
