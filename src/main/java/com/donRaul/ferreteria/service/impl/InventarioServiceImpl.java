package com.donRaul.ferreteria.service.impl;

import com.donRaul.ferreteria.repository.IInventarioRepository;
import com.donRaul.ferreteria.service.IInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventarioServiceImpl implements IInventarioService {

    @Autowired
    IInventarioRepository inventarioRepository;


}
