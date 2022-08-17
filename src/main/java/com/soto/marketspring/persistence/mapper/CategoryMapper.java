package com.soto.marketspring.persistence.mapper;

import com.soto.marketspring.domain.Category;
import com.soto.marketspring.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring" )
public interface CategoryMapper {

    @Mappings(
            {@Mapping(source = "categoriaId",target = "categoryId"),
            @Mapping(source = "descripcion",target = "category"),
            @Mapping(source = "estado",target = "active")}
    )
    Category toCategory(Categoria categoria);

    @InheritInverseConfiguration
    @Mapping(target = "listaProducto", ignore = true)
    Categoria toCategoria(Category category);
}
