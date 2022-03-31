package com.donRaul.ferreteria.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document(collection = "proveedores")
public class Proveedor {

    @Id
    private String proveedoresId = UUID.randomUUID().toString().substring(0, 10);

    private String cedula;

    private String nombre;

    private String celular;


    public Proveedor() {}


    public Proveedor(String cedula, String nombre, String celular) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.celular = celular;
    }

    public String proveedoresId() {
        return proveedoresId;
    }

    public void setProveedoresId(String proveedoresId) {
        this.proveedoresId = proveedoresId;
    }

    public String cedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String nombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String celular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proveedor proveedor = (Proveedor) o;
        return Objects.equals(proveedoresId, proveedor.proveedoresId) && Objects.equals(cedula, proveedor.cedula) && Objects.equals(nombre, proveedor.nombre) && Objects.equals(celular, proveedor.celular);
    }

    @Override
    public int hashCode() {
        return Objects.hash(proveedoresId, cedula, nombre, celular);
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "proveedoresId='" + proveedoresId + '\'' +
                ", cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", celular='" + celular + '\'' +
                '}';
    }
}
