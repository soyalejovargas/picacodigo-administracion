package com.picacodigo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "factura")
public class Factura implements Serializable{

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfactura")
    private Integer idfactura;
    @Basic(optional = false)
    @Column(name = "mes")
    private String mes;
    @Basic(optional = false)
    @Column(name = "fecha_limite")
    private String fechaLimite;
    @Basic(optional = false)
    @Column(name = "total")
    private double total;
    @JoinColumn(name = "idinmueble", referencedColumnName = "idinmueble")
    @ManyToOne(optional = false)
    private Inmueble idinmueble;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idfactura")
    private List<Pago> pagoList;

    public Integer getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(Integer idfactura) {
        this.idfactura = idfactura;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(String fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Inmueble getIdinmueble() {
        return idinmueble;
    }

    public void setIdinmueble(Inmueble idinmueble) {
        this.idinmueble = idinmueble;
    }

    public List<Pago> getPagoList() {
        return pagoList;
    }

    public void setPagoList(List<Pago> pagoList) {
        this.pagoList = pagoList;
    }
}
