    package com.jrg.fornecedor.fornecedor;

    import jakarta.persistence.*;
    import lombok.*;

    import java.time.LocalDateTime;

    @Table(name = "fornecedor")
    @Entity(name = "fornecedor")
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode(of="id")
    public class Fornecedor {

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nome;
        @Column(unique = true, nullable = false)
        private String cnpj;
        private String endereco;
        private String telefone;
        private String email;
        private String contatoPrincipal;
        @Column(name= "created_at")
        private LocalDateTime createdAt;
        @Column(name= "updatedAt")
        private LocalDateTime updatedAt;

        public Fornecedor(FornecedorRequestDTO data) {
            this.nome = data.nome();
            this.cnpj = data.cnpj();
            this.endereco = data.endereco();
            this.telefone = data.telefone();
            this.email = data.email();
            this.contatoPrincipal = data.contatoPrincipal();
        }
    }
