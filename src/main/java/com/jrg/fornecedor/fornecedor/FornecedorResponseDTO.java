package com.jrg.fornecedor.fornecedor;

public record FornecedorResponseDTO(Long id, String nome, String cnpj, String endereco, String telefone, String email, String contatoPrincipal) {
    public FornecedorResponseDTO(Fornecedor fornecedor) {
    this(fornecedor.getId(), fornecedor.getNome(), fornecedor.getCnpj(), fornecedor.getEndereco(), fornecedor.getTelefone(), fornecedor.getEmail(), fornecedor.getContatoPrincipal());
    }
}
