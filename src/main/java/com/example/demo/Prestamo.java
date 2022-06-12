package com.example.demo;

public class Prestamo {
    private int id;
    private int idUsuario;
    private int idEquipo;
    private String fini;
    private String ffin;
    private String freald;
    private String comentarios;

    public Prestamo(int id, int idUsuario, int idEquipo, String fini, String ffin, String freald, String comentarios) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idEquipo = idEquipo;
        this.fini = fini;
        this.ffin = ffin;
        this.freald = freald;
        this.comentarios = comentarios;
    }

    public Prestamo() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getFini() {
        return fini;
    }

    public void setFini(String fini) {
        this.fini = fini;
    }

    public String getFfin() {
        return ffin;
    }

    public void setFfin(String ffin) {
        this.ffin = ffin;
    }

    public String getFreald() {
        return freald;
    }

    public void setFreald(String freald) {
        this.freald = freald;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public String toString() {
        return "PrestamoUsu{" +
                "id=" + id +
                ", idUsuario=" + idUsuario +
                ", idEquipo=" + idEquipo +
                ", fini='" + fini + '\'' +
                ", ffin='" + ffin + '\'' +
                ", freald='" + freald + '\'' +
                ", comentarios='" + comentarios + '\'' +
                '}';
    }
}
