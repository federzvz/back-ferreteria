package co.com.sofka.ferreteria.DTOs;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class FacturaDTO {
    private String id = UUID.randomUUID().toString().substring(0, 20);
    private LocalDate Fecha;
    private String nombreCliente;
    private String nombreEmpleado;
    private List<ProductoDTO> productosComprados;
    private Integer precioTotalAPagar;

    public FacturaDTO() {
    }

    public FacturaDTO(LocalDate fecha, String nombreCliente, String nombreEmpleado, List<ProductoDTO> productosComprados, Integer precioTotalAPagar) {
        this.Fecha = fecha;
        this.nombreCliente = nombreCliente;
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

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public List<ProductoDTO> getProductosComprados() {
        return productosComprados;
    }

    public void setProductosComprados(List<ProductoDTO> productosComprados) {
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
        return "Factura{" +
                "id='" + id + '\'' +
                ", Fecha=" + Fecha +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", nombreEmpleado='" + nombreEmpleado + '\'' +
                ", productosComprados=" + productosComprados +
                ", precioTotalAPagar=" + precioTotalAPagar +
                '}';
    }
}
