package com.springboot.chapter15.mapper;

import com.springboot.chapter15.pojo.ProductPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: jianglei
 * @date: 2020/2/2 22:57
 */
@Mapper
public interface ProductMapper {
    ProductPo getProduct(Long id);

    int decreaseProduct(@Param("id") Long id, @Param("quantity") int quantity, @Param("version") int version);

    int decreaseProduct(@Param("id") Long id, @Param("quantity") int quantity);
}
