package com.soto.marketspring.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer categoriaId;
    private String  descripcion;
    private Boolean estado;
}
