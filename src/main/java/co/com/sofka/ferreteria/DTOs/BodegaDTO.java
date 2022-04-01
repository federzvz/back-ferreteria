package co.com.sofka.ferreteria.DTOs;

public class BodegaDTO {
    private String id;
    private ProductoDTO producto;
    private Integer stock;

    public BodegaDTO() {
    }

    public BodegaDTO(String id, ProductoDTO producto, Integer stock) {
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

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
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
