package com.donRaul.ferreteria.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Document(collection = "inventario")
public class Inventario {

    private String inventarioId = UUID.randomUUID().toString().substring(0, 10);

    private List<Producto> listaDeProductos;

    public Inventario() {
    }

    public Inventario(List<Producto> listaDeProductos) {
        this.listaDeProductos = listaDeProductos;
    }

    public String inventarioId() {
        return inventarioId;
    }

    public void setInventarioId(String inventarioId) {
        this.inventarioId = inventarioId;
    }

    public List<Producto> listaDeProductos() {
        return listaDeProductos;
    }

    public void setListaDeProductos(List<Producto> listaDeProductos) {
        this.listaDeProductos = listaDeProductos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventario that = (Inventario) o;
        return Objects.equals(inventarioId, that.inventarioId) && Objects.equals(listaDeProductos, that.listaDeProductos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventarioId, listaDeProductos);
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "inventarioId='" + inventarioId + '\'' +
                ", listaDeProductos=" + listaDeProductos +
                '}';
    }
}
