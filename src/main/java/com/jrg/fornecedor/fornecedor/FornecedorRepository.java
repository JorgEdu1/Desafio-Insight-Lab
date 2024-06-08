package com.jrg.fornecedor.fornecedor;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
    Optional<Fornecedor> findByCnpj(String cnpj);
    List<Fornecedor> findAllByOrderByIdDesc();

}
