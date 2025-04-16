package com.clical.client.repository;

import com.clical.client.model.ProfissionalClient;
import com.clical.client.model.ProfissionalClientId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfissionalClienteRepository extends JpaRepository<ProfissionalClient, ProfissionalClientId> {
}
