package com.jrg.fornecedor.controller;

import com.jrg.fornecedor.fornecedor.Fornecedor;
import com.jrg.fornecedor.fornecedor.FornecedorRepository;
import com.jrg.fornecedor.fornecedor.FornecedorResponseDTO;
import com.jrg.fornecedor.fornecedor.FornecedorRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public ResponseEntity<List<FornecedorResponseDTO>> getAll() {
        try {
            List<FornecedorResponseDTO> fornecedorList = repository.findAll().stream()
                    .map(FornecedorResponseDTO::new)
                    .toList();
            return new ResponseEntity<>(fornecedorList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Fornecedor> saveFornecedor(@RequestBody FornecedorRequestDTO data) {
        try {
            Fornecedor fornecedor = new Fornecedor(data);
            repository.save(fornecedor);
            return new ResponseEntity<>(fornecedor, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<FornecedorResponseDTO> getFornecedor(@PathVariable Long id) {
        try {
            Fornecedor fornecedor = repository.findById(id).orElseThrow(NoSuchElementException::new);
            FornecedorResponseDTO responseDTO = new FornecedorResponseDTO(fornecedor);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFornecedor(@PathVariable Long id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<FornecedorResponseDTO> updateFornecedor(@PathVariable Long id, @RequestBody FornecedorRequestDTO data) {
        try {
            Fornecedor fornecedor = repository.findById(id).orElseThrow(NoSuchElementException::new);
            fornecedor.setNome(data.nome());
            fornecedor.setCnpj(data.cnpj());
            fornecedor.setEndereco(data.endereco());
            fornecedor.setTelefone(data.telefone());
            fornecedor.setEmail(data.email());
            fornecedor.setContatoPrincipal(data.contatoPrincipal());
            repository.save(fornecedor);
            FornecedorResponseDTO responseDTO = new FornecedorResponseDTO(fornecedor);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
