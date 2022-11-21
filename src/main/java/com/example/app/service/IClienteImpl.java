package com.example.app.service;

import com.example.app.dao.IClienteDao;
import com.example.app.entity.Cliente;
import com.example.app.entity.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IClienteImpl implements IClienteService{

    @Autowired
    private IClienteDao clienteDao;

    @Override
    public List<Cliente> findAll() {
        return  (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Cliente> paginador(Pageable pageable) {
        return clienteDao.findAll(pageable);
    }

    @Override
    public Cliente findById(Integer id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteDao.save(cliente);
    }

    @Override
    public void delete(Integer id) {
            clienteDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Region> listarRegion() {
        return clienteDao.listarRegion();
    }

}
