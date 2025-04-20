package com.clical.client.service;

import com.clical.client.dto.ProfissionalDTO;
import com.clical.client.exception.ResourceNotFoundException;
import com.clical.client.model.Profissional;
import com.clical.client.repository.ProfissionalClienteRepository;
import com.clical.client.repository.ProfissionalServicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clical.client.repository.ProfissionalRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProfissionalService {

    @Autowired
    private ProfissionalRepository profissionalRepository;

    @Autowired
    private ProfissionalClienteRepository profissionalClienteRepository;

    @Autowired
    private ProfissionalServicoRepository profissionalServicoRepository;


    /* Criar o profissional
    Tratado: campo obrigatório e salvar o profissional duplamente */
    @Transactional
    public ProfissionalDTO saveProfissional(ProfissionalDTO profissionaisDTO){
        if (profissionaisDTO.getCpfProfissional() == null || profissionaisDTO.getCpfProfissional().isBlank()) {
            throw new IllegalArgumentException("O CPF do profissional é obrigatório.");
        }
        if (profissionalRepository.existsById(profissionaisDTO.getCpfProfissional())) {
            throw new IllegalArgumentException("Já existe um profissional cadastrado com esse CPF.");
        }

        Profissional profissional = profissionalRepository.save(toProfissinal(profissionaisDTO));

        return toProfissionalDTO(profissional);
    }

    /* Atualiza o profissional;
    Tratado com erro 404 (Not Found) e Campo obrigatório */
    @Transactional
    public ProfissionalDTO updateProfissional(ProfissionalDTO profissionaisDTO) {
        if (profissionaisDTO.getCpfProfissional() == null || profissionaisDTO.getCpfProfissional().isBlank()) {
            throw new IllegalArgumentException("CPF do profissional é obrigatório para atualização.");
        }

        Profissional existente = profissionalRepository.findById(profissionaisDTO.getCpfProfissional())
                .orElseThrow(() -> new ResourceNotFoundException("Profissional não encontrado para o CPF informado."));

        Profissional atualizado = toProfissinal(profissionaisDTO);

        // CPF não muda, garante que seja o mesmo
        atualizado.setCpfProfissional(existente.getCpfProfissional());

        return toProfissionalDTO(profissionalRepository.save(atualizado));
    }

    /* Buscar profissional pelo Id(cpf);
     Tratado com erro 404 (Not Found) e 500 (INTERNAL_SERVER_ERROR) */
    public ProfissionalDTO getByIdProfissional(String cpfProfissional) {
        try {
            Profissional profissional = profissionalRepository.findById(cpfProfissional)
                    .orElseThrow(() -> new ResourceNotFoundException("Profissional com CPF " + cpfProfissional + " não encontrado."));
            return toProfissionalDTO(profissional);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar o profissional!" + e.getMessage());
        }

    }

    /* Buscar o profissional pelo nome;
    Tratado com erro 404 (Not Found) e 500 (INTERNAL_SERVER_ERROR) */
    public List<ProfissionalDTO> getProfissionalPorNome(String nome) {
        try {
            List<Profissional> profissionais = profissionalRepository.findAllByNomeContainingIgnoreCase(nome);

            if (profissionais.isEmpty()) {
                throw new ResourceNotFoundException("Profissional com nome " + nome + "não encontrado.");
            }

            return profissionais.stream()
                    .map(this::toProfissionalDTO)
                    .collect(Collectors.toList());

        } catch (ResourceNotFoundException ex){
            throw ex;
        }
        catch (Exception e) {
            throw new RuntimeException("Erro ao buscar o profissional!" + e.getMessage());
        }
    }

    /* Buscar profissionais por especialidade;
    Tratado com erro 404 (Not Found) e 500 (INTERNAL_SERVER_ERROR) */
    public List<ProfissionalDTO> getProfissionalPorEspecialidade(String especializacao) {
        try {
            List<Profissional> profissionais = profissionalRepository.findAllByEspecializacaoContainingIgnoreCase(especializacao);

            if(profissionais.isEmpty()){
                throw new ResourceNotFoundException("Nenhum profissional encontrado para a especialidade fornecida: " + especializacao);
            }

            return profissionais.stream()
                    .map(this::toProfissionalDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar profissionais pela especialidade fornecida!" + e.getMessage());
        }

    }

    /* Buscar todos os profissionais
    Tratado com erro 500 (INTERNAL_SERVER_ERROR) */
    public List<ProfissionalDTO> getAllProfissionais() {
        try {
            List<Profissional> profissionais = profissionalRepository.findAll();

            return profissionais.stream()
                    .map(this::toProfissionalDTO)
                    .toList();
        }catch (Exception ex) {
            throw new RuntimeException("Erro ao listar profissionais. Por favor, tente novamente mais tarde." + ex.getMessage());
        }
    }

    /* Deletar o profissional pelo CPF
    Tratado com erro 404 (Not Found) */
    @Transactional
    public void deleteProfissionalById(String cpfProfissional) {
        Profissional profissional = profissionalRepository.findById(cpfProfissional)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário com CPF: " + cpfProfissional + " não encontrado."));

        profissionalRepository.delete(profissional);
    }

    // Metodo para converter o objeto Model em objeto DTO
    private Profissional toProfissinal(ProfissionalDTO dto) {
        Profissional profissional = new Profissional();

        profissional.setCpfProfissional(dto.getCpfProfissional());
        profissional.setNome(dto.getNome());
        profissional.setTelefone(dto.getTelefone());
        profissional.setRegistro(dto.getRegistro());
        profissional.setEspecializacao(dto.getEspecializacao());
        profissional.setRqe(dto.getRqe());
        profissional.setEmail(dto.getEmail());
        profissional.setEndereco(dto.getEndereco());
        return profissional;
    }

    // Metodo para converter o objeto DTO em objeto Model
    private ProfissionalDTO toProfissionalDTO(Profissional profissional) {
        ProfissionalDTO dto = new ProfissionalDTO();

        dto.setCpfProfissional(profissional.getCpfProfissional());
        dto.setNome(profissional.getNome());
        dto.setTelefone(profissional.getTelefone());
        dto.setRegistro(profissional.getRegistro());
        dto.setEspecializacao(profissional.getEspecializacao());
        dto.setRqe(profissional.getRqe());
        dto.setEmail(profissional.getEmail());
        dto.setEndereco(profissional.getEndereco());
        return dto;
    }
}
