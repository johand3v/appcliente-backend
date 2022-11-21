package com.example.app.service;

import com.example.app.entity.Cliente;
import com.example.app.entity.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IClienteService {
    List<Cliente> findAll();

    Page<Cliente> paginador(Pageable pageable);
    Cliente findById(Integer id);
    Cliente save(Cliente cliente);
    void delete(Integer id);

    List<Region> listarRegion();


}
