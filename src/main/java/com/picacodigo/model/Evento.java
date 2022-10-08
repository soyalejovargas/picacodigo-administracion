package com.picacodigo.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "evento")
public class Evento implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idevento")
	private Integer idevento;
	@Basic(optional = false)
	@Column(name = "descripcion")
	private String descripcion;
	@JoinColumn(name = "idconjunto", referencedColumnName = "idconjunto")
	@ManyToOne(optional = false)
	private Conjunto idconjunto;
	@JoinColumn(name = "idpersona", referencedColumnName = "idpersona")
	@ManyToOne(optional = false)
	private Persona idpersona;

	public Integer getIdevento() {
		return idevento;
	}

	public void setIdevento(Integer idevento) {
		this.idevento = idevento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Conjunto getIdconjunto() {
		return idconjunto;
	}

	public void setIdconjunto(Conjunto idconjunto) {
		this.idconjunto = idconjunto;
	}

	public Persona getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(Persona idpersona) {
		this.idpersona = idpersona;
	}

}
