package com.jrg.fornecedor.fornecedor;

public record FornecedorRequestDTO(String nome, String cnpj, String endereco, String telefone, String email, String contatoPrincipal) {
}
