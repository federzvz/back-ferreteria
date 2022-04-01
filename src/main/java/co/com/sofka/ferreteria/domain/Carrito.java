package co.com.sofka.ferreteria.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Document(collection = "carritos")
public class Carrito {
    @Id
    private String id = UUID.randomUUID().toString().substring(0, 20);
    private LocalDate Fecha;
    private Cliente cliente;
    private String nombreEmpleado;
    private List<Producto> productosComprados;
    private Integer precioTotalAPagar;

    public Carrito() {
    }

    public Carrito(LocalDate fecha, Cliente cliente, String nombreEmpleado, List<Producto> productosComprados, Integer precioTotalAPagar) {
        Fecha = fecha;
        this.cliente = cliente;
        this.nombreEmpleado = nombreEmpleado;
        this.productosComprados = productosComprados;
        this.precioTotalAPagar = precioTotalAPagar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDate fecha) {
        Fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public List<Producto> getProductosComprados() {
        return productosComprados;
    }

    public void setProductosComprados(List<Producto> productosComprados) {
        this.productosComprados = productosComprados;
    }

    public Integer getPrecioTotalAPagar() {
        return precioTotalAPagar;
    }

    public void setPrecioTotalAPagar(Integer precioTotalAPagar) {
        this.precioTotalAPagar = precioTotalAPagar;
    }

    @Override
    public String toString() {
        return "Carrito{" +
                "id='" + id + '\'' +
                ", Fecha=" + Fecha +
                ", cliente=" + cliente +
                ", nombreEmpleado='" + nombreEmpleado + '\'' +
                ", productosComprados=" + productosComprados +
                ", precioTotalAPagar=" + precioTotalAPagar +
                '}';
    }
}
