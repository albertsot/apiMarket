package com.soto.marketspring.persistence.mapper;

import com.soto.marketspring.domain.PurchaseItem;
import com.soto.marketspring.persistence.entity.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring",uses ={ProductMapper.class} )
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping( source = "comprasProductoPK.productoId",target = "productId"),
            @Mapping( source = "cantidad",target = "quantity"),
            @Mapping( source = "estado",target ="active" ),

    })
    PurchaseItem toPurchaseItem(ComprasProducto comprasProducto);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping( target = "compras",ignore = true),
            @Mapping( target = "productos",ignore = true),
            @Mapping( target = "comprasProductoPK.compraId",ignore = true)
    })
    ComprasProducto toComprasProducto(PurchaseItem purchaseItem);
}
