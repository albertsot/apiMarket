package com.soto.marketspring.persistence.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "compras_productos")
public class ComprasProducto {

    @EmbeddedId
    private ComprasProductoPK comprasProductoPK;
    private Integer cantidad;
    private Integer total;
    private Boolean estado;

    public ComprasProductoPK getComprasProductoPK() {
        return comprasProductoPK;
    }

    public void setComprasProductoPK(ComprasProductoPK comprasProductoPK) {
        this.comprasProductoPK = comprasProductoPK;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
