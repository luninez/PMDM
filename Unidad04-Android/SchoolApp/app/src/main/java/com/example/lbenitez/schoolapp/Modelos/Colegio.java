package com.example.lbenitez.schoolapp.Modelos;

import java.util.Objects;

public class Colegio {

  private String logotipo;
  private String nombre_colegio;
  private String etapas_educativas;
  private String direccion;

  public Colegio() { }

  public Colegio(String logotipo, String nombre_colegio, String etapas_educativas, String direccion) {
    this.logotipo = logotipo;
    this.nombre_colegio = nombre_colegio;
    this.etapas_educativas = etapas_educativas;
    this.direccion = direccion;
  }

  public String getLogotipo() {
    return logotipo;
  }

  public void setLogotipo(String logotipo) {
    this.logotipo = logotipo;
  }

  public String getNombre_colegio() {
    return nombre_colegio;
  }

  public void setNombre_colegio(String nombre_colegio) {
    this.nombre_colegio = nombre_colegio;
  }

  public String getEtapas_educativas() {
    return etapas_educativas;
  }

  public void setEtapas_educativas(String etapas_educativas) {
    this.etapas_educativas = etapas_educativas;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Colegio colegio = (Colegio) o;
    return Objects.equals(logotipo, colegio.logotipo) &&
      Objects.equals(nombre_colegio, colegio.nombre_colegio) &&
      Objects.equals(etapas_educativas, colegio.etapas_educativas) &&
      Objects.equals(direccion, colegio.direccion);
  }

  @Override
  public int hashCode() {

    return Objects.hash(logotipo, nombre_colegio, etapas_educativas, direccion);
  }

  @Override
  public String toString() {
    return "Colegio{" +
      "logotipo='" + logotipo + '\'' +
      ", nombre_colegio='" + nombre_colegio + '\'' +
      ", etapas_educativas='" + etapas_educativas + '\'' +
      ", direccion='" + direccion + '\'' +
      '}';
  }
}
