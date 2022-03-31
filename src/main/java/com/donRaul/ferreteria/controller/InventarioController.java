package com.donRaul.ferreteria.controller;

import com.donRaul.ferreteria.service.IInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class InventarioController {

    @Autowired
    IInventarioService inventarioService;


}
