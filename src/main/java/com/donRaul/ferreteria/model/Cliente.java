package com.donRaul.ferreteria.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document(collection = "clientes")
public class Cliente {

    @Id
    private String clienteId = UUID.randomUUID().toString().substring(0, 10);

    private String nombre;

    private String celular;

    private String cedula;


    public Cliente() {}

    public Cliente(String cedula, String nombre, String celular) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.celular = celular;
    }


    public String clienteId() {
        return clienteId;
    }

    public String nombre() {
        return nombre;
    }

    public String celular() {
        return celular;
    }

    public String cedula() {
        return cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(clienteId, cliente.clienteId) && Objects.equals(nombre, cliente.nombre) && Objects.equals(celular, cliente.celular) && Objects.equals(cedula, cliente.cedula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clienteId, nombre, celular, cedula);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "clienteId='" + clienteId + '\'' +
                ", nombre='" + nombre + '\'' +
                ", celular='" + celular + '\'' +
                ", cedula='" + cedula + '\'' +
                '}';
    }
}
