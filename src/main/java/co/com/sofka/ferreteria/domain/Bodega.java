package co.com.sofka.ferreteria.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bodegas")
public class Bodega {
    @Id
    private String IdProducto;
    private Producto producto;
    private Integer stock;

    public Bodega() {
    }

    public Bodega(String idProducto, Producto producto, Integer stock) {
        IdProducto = idProducto;
        this.producto = producto;
        this.stock = stock;
    }

    public String getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(String idProducto) {
        IdProducto = idProducto;
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
                "IdProducto='" + IdProducto + '\'' +
                ", producto=" + producto +
                ", stock=" + stock +
                '}';
    }
}
