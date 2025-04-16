package com.clical.client.service;

import com.clical.client.dto.ClientDTO;
import com.clical.client.model.Client;
import com.clical.client.repository.ProfissionalClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clical.client.repository.ClientRepository;

import java.util.UUID;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProfissionalClienteRepository profissionalClienteRepository;


    // Criar o cliente ou atualizar o cliente
    @Transactional
    public ClientDTO saveClient(ClientDTO clientsDTO){
        if (clientsDTO.getCpfClient() == null) {
            clientsDTO.setCpfClient(UUID.randomUUID().toString());
        }

        Client client = clientRepository.save(toClient(clientsDTO));

        return toClientDTO(client);
    }

    // Buscar o cliente pelo Id(cpf)
    public ClientDTO getClientById(String cpfClient) {
        Client client = clientRepository.findById(cpfClient).orElse(null);
        return client != null ? toClientDTO(client) : null;
    }

//    // Buscar todos os clientes pelo Id do médico(cpf), irá resultar em uma lista de ClientDTO
//    public List<ClientDTO> getClientsby(List<String> cpflist) {
//        List<Client> clients = clientRepository.findAllById(cpflist);
//        return clients.stream()
//                .map(this::toClientDTO)
//                .collect(Collectors.toList());
//    }

    // Deletar o cliente
    @Transactional
    public void deleteClientById(String cpfClient) {
        clientRepository.deleteById(cpfClient);
       // profissionalClienteRepository.deleteById(profissionalClientId);
    }

    // Metodo para converter o objeto Model em objeto DTO
    private Client toClient(ClientDTO dto) {
        Client client = new Client();
        client.setCpfClient(dto.getCpfClient());
        client.setNome(dto.getNome());
        client.setDataNascimento(dto.getDataNascimento());
        client.setCep(dto.getCep());
        client.setCidade(dto.getCidade());
        client.setEstado(dto.getEstado());
        client.setEndereco(dto.getEndereco());
        client.setComplemento(dto.getComplemento());
        client.setTelefone(dto.getTelefone());
        client.setEmail(dto.getEmail());
        return client;
    }

    // Metodo para converter o objeto DTO em objeto Model
    private ClientDTO toClientDTO(Client client) {
        ClientDTO dto = new ClientDTO();
        dto.setCpfClient(client.getCpfClient());
        dto.setNome((client.getNome()));
        dto.setDataNascimento(client.getDataNascimento());
        dto.setCep(client.getCep());
        dto.setCidade(client.getCidade());
        dto.setEstado(client.getEstado());
        dto.setEndereco(client.getEndereco());
        dto.setComplemento(client.getComplemento());
        dto.setTelefone(client.getTelefone());
        dto.setEmail(client.getEmail());
        return dto;
    }

}
