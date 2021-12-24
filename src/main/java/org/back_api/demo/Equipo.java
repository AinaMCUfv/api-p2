package org.back_api.demo;

public class Equipo {

    private int Id;
    private String tipo;

    private String marca;
    private String usoEquipo;

    private String nombreSO;
    private String versionSO;

    private String procesadorHardware;
    private String atriveloc;
    private String Velocidad;

    private String tipoDD;
    private String capacidad;

    private String diagonal;
    private String resolucion;

    private String nombreLP;
    private String versionLP;
    private String tipoLP;

    private String nombreLL;
    private String versionLL;

    public Equipo(int id, String tipo, String marca, String usoEquipo, String nombreSO, String versionSO, String procesadorHardware, String atriveloc, String velocidad, String tipoDD, String capacidad, String diagonal, String resolucion, String nombreLP, String versionLP, String tipoLP, String nombreLL, String versionLL) {
        Id = id;
        this.tipo = tipo;
        this.marca = marca;
        this.usoEquipo = usoEquipo;
        this.nombreSO = nombreSO;
        this.versionSO = versionSO;
        this.procesadorHardware = procesadorHardware;
        this.atriveloc = atriveloc;
        Velocidad = velocidad;
        this.tipoDD = tipoDD;
        this.capacidad = capacidad;
        this.diagonal = diagonal;
        this.resolucion = resolucion;
        this.nombreLP = nombreLP;
        this.versionLP = versionLP;
        this.tipoLP = tipoLP;
        this.nombreLL = nombreLL;
        this.versionLL = versionLL;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getUsoEquipo() {
        return usoEquipo;
    }

    public void setUsoEquipo(String usoEquipo) {
        this.usoEquipo = usoEquipo;
    }

    public String getNombreSO() {
        return nombreSO;
    }

    public void setNombreSO(String nombreSO) {
        this.nombreSO = nombreSO;
    }

    public String getVersionSO() {
        return versionSO;
    }

    public void setVersionSO(String versionSO) {
        this.versionSO = versionSO;
    }

    public String getProcesadorHardware() {
        return procesadorHardware;
    }

    public void setProcesadorHardware(String procesadorHardware) {
        this.procesadorHardware = procesadorHardware;
    }

    public String getAtriveloc() {
        return atriveloc;
    }

    public void setAtriveloc(String atriveloc) {
        this.atriveloc = atriveloc;
    }

    public String getVelocidad() {
        return Velocidad;
    }

    public void setVelocidad(String velocidad) {
        Velocidad = velocidad;
    }

    public String getTipoDD() {
        return tipoDD;
    }

    public void setTipoDD(String tipoDD) {
        this.tipoDD = tipoDD;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public String getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(String diagonal) {
        this.diagonal = diagonal;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public String getNombreLP() {
        return nombreLP;
    }

    public void setNombreLP(String nombreLP) {
        this.nombreLP = nombreLP;
    }

    public String getVersionLP() {
        return versionLP;
    }

    public void setVersionLP(String versionLP) {
        this.versionLP = versionLP;
    }

    public String getTipoLP() {
        return tipoLP;
    }

    public void setTipoLP(String tipoLP) {
        this.tipoLP = tipoLP;
    }

    public String getNombreLL() {
        return nombreLL;
    }

    public void setNombreLL(String nombreLL) {
        this.nombreLL = nombreLL;
    }

    public String getVersionLL() {
        return versionLL;
    }

    public void setVersionLL(String versionLL) {
        this.versionLL = versionLL;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "Id=" + Id +
                ", tipo='" + tipo + '\'' +
                ", marca='" + marca + '\'' +
                ", usoEquipo='" + usoEquipo + '\'' +
                ", nombreSO='" + nombreSO + '\'' +
                ", versionSO='" + versionSO + '\'' +
                ", procesadorHardware='" + procesadorHardware + '\'' +
                ", atriveloc='" + atriveloc + '\'' +
                ", Velocidad='" + Velocidad + '\'' +
                ", tipoDD='" + tipoDD + '\'' +
                ", capacidad='" + capacidad + '\'' +
                ", diagonal='" + diagonal + '\'' +
                ", resolucion='" + resolucion + '\'' +
                ", nombreLP='" + nombreLP + '\'' +
                ", versionLP='" + versionLP + '\'' +
                ", tipoLP='" + tipoLP + '\'' +
                ", nombreLL='" + nombreLL + '\'' +
                ", versionLL='" + versionLL + '\'' +
                '}';
    }
}
