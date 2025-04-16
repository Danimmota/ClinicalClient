package com.clical.client.service;

import com.clical.client.dto.ServicoDTO;
import com.clical.client.model.Servico;
import com.clical.client.repository.ProfissionalServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clical.client.repository.ServicoRepository;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private ProfissionalServicoRepository profissionalServicoRepository;


    //Buscar servico pelo Id
    public ServicoDTO getByIdServico(Integer idServico) {
        Servico servico = servicoRepository.findById(idServico).orElse(null);
        return servico != null ? toServicoDTO(servico) : null;
    }
    // Criar o servico
    // Ver todos os servicos
    // Ver os servicos por profissional
    // Ver os servicos agendados por cliente
    // Editar os servicos
    // Deletar o servico

    // Metodo para converter o objeto Model em objeto DTO
    private Servico toServico(ServicoDTO dto) {
        var servico = new Servico();

        servico.setIdServico(dto.getIdServico());
        servico.setNome(dto.getNome());
        servico.setDescricao(dto.getDescricao());
        return servico;
    }

    // Metodo para converter o objeto DTO em objeto Model
    private ServicoDTO toServicoDTO(Servico servico) {
        var dto = new ServicoDTO();

        dto.setIdServico(servico.getIdServico());
        dto.setNome(servico.getNome());
        dto.setDescricao(servico.getDescricao());
        return dto;
    }
}
