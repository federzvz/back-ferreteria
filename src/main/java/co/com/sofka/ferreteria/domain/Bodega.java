package co.com.sofka.ferreteria.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bodegas")
public class Bodega {
    @Id
    private String id;
    private Producto producto;
    private Integer stock;

    public Bodega() {
    }

    public Bodega(String id, Producto producto, Integer stock) {
        this.id = id;
        this.producto = producto;
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Bodega{" +
                "id='" + id + '\'' +
                ", producto=" + producto +
                ", stock=" + stock +
                '}';
    }
}
