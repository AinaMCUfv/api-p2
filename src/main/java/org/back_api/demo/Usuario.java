package org.back_api.demo;

public class Usuario {
    private int id;
    private String nombre;
    private String departamento;
    private String tel;
    private String email;
    private String ubicacion;

    public Usuario(int id, String nombre, String departamento, String tel, String email, String ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.departamento = departamento;
        this.tel = tel;
        this.email = email;
        this.ubicacion = ubicacion;
    }

    public Usuario() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", departamento='" + departamento + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }
}
