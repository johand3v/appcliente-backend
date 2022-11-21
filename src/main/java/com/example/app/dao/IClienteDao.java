package com.example.app.dao;

import com.example.app.entity.Cliente;
import com.example.app.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//@Repository
public interface IClienteDao extends JpaRepository<Cliente, Integer> {

    @Query("from Region")
    List<Region> listarRegion();
}
