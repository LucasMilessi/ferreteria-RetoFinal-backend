package com.donRaul.ferreteria.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Document(collection = "volantes")
public class Volante {

    @Id
    private String volanteId = UUID.randomUUID().toString().substring(0, 10);

    private Proveedor nombreProveedor;

    private List<Producto> productos;

    private Date Fecha;

    private Proveedor cedula;

    public Volante() {
    }

    public Volante(Proveedor nombreProveedor, List<Producto> productos, Date fecha, Proveedor cedula) {
        this.nombreProveedor = nombreProveedor;
        this.productos = productos;
        Fecha = fecha;
        this.cedula = cedula;
    }

    public String volanteId() {
        return volanteId;
    }

    public void setVolanteId(String volanteId) {
        this.volanteId = volanteId;
    }

    public Proveedor nombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(Proveedor nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public List<Producto> productos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Date fecha() {
        return Fecha;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    public Proveedor cedula() {
        return cedula;
    }

    public void setCedula(Proveedor cedula) {
        this.cedula = cedula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Volante volante = (Volante) o;
        return Objects.equals(volanteId, volante.volanteId) && Objects.equals(nombreProveedor, volante.nombreProveedor) && Objects.equals(productos, volante.productos) && Objects.equals(Fecha, volante.Fecha) && Objects.equals(cedula, volante.cedula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(volanteId, nombreProveedor, productos, Fecha, cedula);
    }

    @Override
    public String toString() {
        return "Volante{" +
                "volanteId='" + volanteId + '\'' +
                ", nombreProveedor=" + nombreProveedor +
                ", productos=" + productos +
                ", Fecha=" + Fecha +
                ", cedula=" + cedula +
                '}';
    }
}
