package co.com.sofka.ferreteria.DTOs;

import co.com.sofka.ferreteria.domain.Producto;

public class BodegaDTO {
    private String id;
    private Producto producto;
    private Integer stock;

    public BodegaDTO() {
    }

    public BodegaDTO(String id, Producto producto, Integer stock) {
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
        return this.producto;
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
