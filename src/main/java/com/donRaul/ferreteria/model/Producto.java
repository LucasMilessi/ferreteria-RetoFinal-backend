package com.donRaul.ferreteria.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document(collection = "productos")
public class Producto {

    @Id
    private String productoId = UUID.randomUUID().toString().substring(0, 10);

    private String nombreProducto;

    private double precio;

    private int cantidad;

    private Proveedor proveedor;


    public Producto() {}

    public Producto(String productoId, String nombreProducto, double precio, int cantidad, Proveedor proveedor) {
        this.productoId = productoId;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.proveedor = proveedor;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public String getProductoId() {
        return productoId;
    }

    public void setProductoId(String productoId) {
        this.productoId = productoId;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Double.compare(producto.precio, precio) == 0 && cantidad == producto.cantidad && Objects.equals(productoId, producto.productoId) && Objects.equals(nombreProducto, producto.nombreProducto) && Objects.equals(proveedor, producto.proveedor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productoId, nombreProducto, precio, cantidad, proveedor);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "productoId='" + productoId + '\'' +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                ", proveedor=" + proveedor +
                '}';
    }
}
