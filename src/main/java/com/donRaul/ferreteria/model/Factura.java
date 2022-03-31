package com.donRaul.ferreteria.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Document(collection = "facturas")
public class Factura {

    @Id
    private String facturaId = UUID.randomUUID().toString().substring(0, 10);

    private long consecutivo;

    private Date fecha;

    private String nombreCliente;

    private String clienteAtendidoPor;

    private List<Producto> productos;

    private double totalPagar;


    public Factura() {}

    public Factura(long consecutivo, Date fecha, String nombreCliente, String clienteAtendidoPor, List<Producto> productos, double totalPagar) {
        this.consecutivo = consecutivo;
        this.fecha = fecha;
        this.nombreCliente = nombreCliente;
        this.clienteAtendidoPor = clienteAtendidoPor;
        this.productos = productos;
        this.totalPagar = totalPagar;
    }

    public String getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(String facturaId) {
        this.facturaId = facturaId;
    }

    public long getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(long consecutivo) {
        this.consecutivo = consecutivo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getClienteAtendidoPor() {
        return clienteAtendidoPor;
    }

    public void setClienteAtendidoPor(String clienteAtendidoPor) {
        this.clienteAtendidoPor = clienteAtendidoPor;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Factura factura = (Factura) o;
        return consecutivo == factura.consecutivo && Double.compare(factura.totalPagar, totalPagar) == 0 && Objects.equals(facturaId, factura.facturaId) && Objects.equals(fecha, factura.fecha) && Objects.equals(nombreCliente, factura.nombreCliente) && Objects.equals(clienteAtendidoPor, factura.clienteAtendidoPor) && Objects.equals(productos, factura.productos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facturaId, consecutivo, fecha, nombreCliente, clienteAtendidoPor, productos, totalPagar);
    }

    @Override
    public String toString() {
        return "Factura{" +
                "facturaId='" + facturaId + '\'' +
                ", consecutivo=" + consecutivo +
                ", Fecha=" + fecha +
                ", nombreCliente=" + nombreCliente +
                ", clienteAtendidoPor='" + clienteAtendidoPor + '\'' +
                ", productos=" + productos +
                ", totalPagar=" + totalPagar +
                '}';
    }
}
