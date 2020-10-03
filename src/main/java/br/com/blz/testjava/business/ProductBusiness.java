package br.com.blz.testjava.business;

import br.com.blz.testjava.domain.Product;
import br.com.blz.testjava.enums.ErrorEnum;
import br.com.blz.testjava.exception.SkuExistsException;
import br.com.blz.testjava.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class ProductBusiness {

    @Autowired
    private ProductService productService;

    public Product save(Product product) {
        if (Objects.nonNull(this.productService.findBySku(product.getSku())))
            throw new SkuExistsException(ErrorEnum.SKU_EXISTS.getDescription());
        return this.productService.save(product);
    }
}
