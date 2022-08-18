package com.soto.marketspring.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "compras_productos")
public class ComprasProducto {

    @EmbeddedId
    private ComprasProductoPK comprasProductoPK;
    private Integer cantidad;
    private Integer total;
    private Boolean estado;

    @ManyToOne
    @MapsId("compraId")
    @JoinColumn(name = "id_compra",insertable = false,updatable = false)
    private Compra compras;

    @ManyToOne
    @JoinColumn(name = "id_producto",insertable = false,updatable = false)
    private Producto productos;
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

    public Compra getCompras() {
        return compras;
    }

    public void setCompras(Compra compras) {
        this.compras = compras;
    }

    public Producto getProductos() {
        return productos;
    }

    public void setProductos(Producto productos) {
        this.productos = productos;
    }
}
