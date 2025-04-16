package com.clical.client.controller;

import com.clical.client.dto.ProfissionalDTO;
import com.clical.client.exception.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.clical.client.service.ProfissionalService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/profissionais")
public class ProfissionalController {

    @Autowired
    private ProfissionalService profissionalService;

    @PostMapping
    public ResponseEntity<ProfissionalDTO> saveProfissional(@RequestBody @Valid ProfissionalDTO profissional) {
        ProfissionalDTO response = profissionalService.saveProfissional(profissional);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{cpfProfissional}")
    public ResponseEntity<ProfissionalDTO> updateProfissional(@PathVariable String cpfProfissional, @RequestBody @Valid ProfissionalDTO profissionalDTO) {
        if (!cpfProfissional.equals(profissionalDTO.getCpfProfissional())) {
            throw new IllegalArgumentException("O CPF deve ser igual ao do corpo da requisição.");
        }
        ProfissionalDTO updated = profissionalService.updateProfissional(profissionalDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }


    @GetMapping("/{cpfProfissional}")
    public ResponseEntity<ProfissionalDTO> getOneProfissional(@Valid @PathVariable(value="cpfProfissional") String cpfProfissional) {
        ProfissionalDTO response = profissionalService.getByIdProfissional(cpfProfissional);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/nome")
    public ResponseEntity<?> getForNome(@RequestParam @Valid String nome) {
        List<ProfissionalDTO> resultado = profissionalService.getProfissionalPorNome(nome);

        return ResponseEntity.status(HttpStatus.OK).body(resultado);
    }

    @GetMapping("/especializacao")
    public ResponseEntity<?> getForEspecialidade(@RequestParam @Valid String especializacao) {
        List<ProfissionalDTO> resultado = profissionalService.getProfissionalPorEspecialidade(especializacao);

        return ResponseEntity.status(HttpStatus.OK).body(resultado);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> getAllProfissionais() {
        List<ProfissionalDTO> profissionaisDTO = profissionalService.getAllProfissionais();

        return ResponseEntity.status(HttpStatus.OK).body(profissionaisDTO);
    }

    @DeleteMapping("/{cpfProfissional}")
    public ResponseEntity<String> deleteProfissionalById(@PathVariable(value="cpfProfissional") String cpfProfissional) {
        profissionalService.deleteProfissionalById(cpfProfissional);

        return ResponseEntity.status(HttpStatus.OK).body("Profissional excluído com sucesso!");
    }
}
