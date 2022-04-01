package co.com.sofka.ferreteria.DTOs;

public class CarritoDTO {
    private String id = UUID.randomUUID().toString().substring(0, 20);
    private LocalDate Fecha;
    private ClienteDTO cliente;
    private String nombreEmpleado;
    private List<ProductoDTO> productosComprados;
    private Integer precioTotalAPagar;

    public CarritoDTO() {
    }

    public CarritoDTO(LocalDate fecha, ClienteDTO cliente, String nombreEmpleado, List<ProductoDTO> productosComprados, Integer precioTotalAPagar) {
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

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
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
