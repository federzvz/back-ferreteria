package co.com.sofka.ferreteria.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Document(collection = "volantes")
public class Volante {

    @Id
    private String id = UUID.randomUUID().toString().substring(0, 20);
    private String nombreProveedor;
    private List<Producto> productoListAIngresar;
    private LocalDate fecha;
    private String documentoProveedor;

    public Volante() {
    }

    public Volante(String nombreProveedor, List<Producto> productoListAIngresar, LocalDate fecha, String documentoProveedor) {
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

    public List<Producto> getProductoListAIngresar() {
        return productoListAIngresar;
    }

    public void setProductoListAIngresar(List<Producto> productoListAIngresar) {
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
