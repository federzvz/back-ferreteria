package co.com.sofka.ferreteria.DTOs;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class VolanteDTO {
    private String id = UUID.randomUUID().toString().substring(0, 20);
    private String nombreProveedor;
    private List<ProductoDTO> productoListAIngresar;
    private LocalDate fecha;
    private String documentoProveedor;

    public VolanteDTO() {
    }

    public VolanteDTO(String nombreProveedor, List<ProductoDTO> productoListAIngresar, LocalDate fecha, String documentoProveedor) {
        this.nombreProveedor = nombreProveedor;
        this.productoListAIngresar = productoListAIngresar;
        this.fecha = fecha;
        this.documentoProveedor = documentoProveedor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public List<ProductoDTO> getProductoListAIngresar() {
        return productoListAIngresar;
    }

    public void setProductoListAIngresar(List<ProductoDTO> productoListAIngresar) {
        this.productoListAIngresar = productoListAIngresar;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDocumentoProveedor() {
        return documentoProveedor;
    }

    public void setDocumentoProveedor(String documentoProveedor) {
        this.documentoProveedor = documentoProveedor;
    }

    @Override
    public String toString() {
        return "Volante{" +
                "nombreProveedor='" + nombreProveedor + '\'' +
                ", productoListAIngresar=" + productoListAIngresar +
                ", fecha=" + fecha +
                ", documentoProveedor='" + documentoProveedor + '\'' +
                '}';
    }
}
