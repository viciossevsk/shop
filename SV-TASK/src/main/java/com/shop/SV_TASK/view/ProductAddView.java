package com.shop.SV_TASK.view;

import com.shop.SV_TASK.domain.Product;
import com.shop.SV_TASK.service.ProductService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.textfield.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ProductAddView extends Dialog {

    ProductService productService;

    TextField name = new TextField("Наименование продукта");

    Button save = new Button("Сохранить");
    Button cancel = new Button("Отменить");

    @Autowired
    public ProductAddView(ProductService productService) {
        this.productService = productService;
        this.add(name);
        this.getFooter().add(save, cancel);
        name.focus();

        cancel.addClickListener(e -> close());
        save.addClickListener(e -> {
            Product product = new Product();
            product.setName(name.getValue());
            this.productService.save(product);
            this.close();
        });
    }
}
