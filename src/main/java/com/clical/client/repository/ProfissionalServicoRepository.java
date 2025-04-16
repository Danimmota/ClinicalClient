package com.clical.client.repository;

import com.clical.client.model.ProfissionalServico;
import com.clical.client.model.ProfissionalServicoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfissionalServicoRepository extends JpaRepository<ProfissionalServico, ProfissionalServicoId> {
    List<ProfissionalServico> findAllByProfissionalServicoId_ServicoId(Integer servicoId);
}
