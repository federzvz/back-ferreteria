package co.com.sofka.ferreteria.DTOs;

public class ClienteDTO {
    private String documento;
    private String nombre;
    private String celular;

    public ClienteDTO() {
    }

    public ClienteDTO(String documento, String nombre, String celular) {
        this.documento = documento;
        this.nombre = nombre;
        this.celular = celular;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "documento='" + documento + '\'' +
                ", nombre='" + nombre + '\'' +
                ", celular='" + celular + '\'' +
                '}';
    }
}
