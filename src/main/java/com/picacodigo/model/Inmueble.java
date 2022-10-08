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
@Table(name = "inmueble")
public class Inmueble implements Serializable{
	 private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(name = "idinmueble")
	    private Integer idinmueble;
	    @Basic(optional = false)
	    @Column(name = "descripcion")
	    private int descripcion;
	    @Basic(optional = false)
	    @Column(name = "valor")
	    private double valor;
	   
	    @JoinColumn(name = "idconjunto", referencedColumnName = "idconjunto")
	    @ManyToOne
	    private Conjunto idconjunto;
	    
	    @JoinColumn(name = "idpropietario", referencedColumnName = "idpersona")
	    @ManyToOne
	    private Persona idpropietario;
	    

	    public Integer getIdinmueble() {
	        return idinmueble;
	    }

	    public void setIdinmueble(Integer idinmueble) {
	        this.idinmueble = idinmueble;
	    }

	    public int getDescripcion() {
	        return descripcion;
	    }

	    public void setDescripcion(int descripcion) {
	        this.descripcion = descripcion;
	    }

	    public double getValor() {
	        return valor;
	    }

	    public void setValor(double valor) {
	        this.valor = valor;
	    }

	    public Conjunto getIdconjunto() {
	        return idconjunto;
	    }

	    public void setIdconjunto(Conjunto idconjunto) {
	        this.idconjunto = idconjunto;
	    }

	    public Persona getIdpropietario() {
	        return idpropietario;
	    }

	    public void setIdpropietario(Persona idpropietario) {
	        this.idpropietario = idpropietario;
	    }
}
