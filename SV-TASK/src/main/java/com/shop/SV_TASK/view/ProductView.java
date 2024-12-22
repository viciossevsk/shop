package com.shop.SV_TASK.view;

import com.shop.SV_TASK.domain.Product;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

/// # Страница создания продуктов
/// **url = http://localhost:8080/shop/product**


@Route("/product")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductView extends VerticalLayout {

 TextField productName = new TextField("Наименование продукта");
    Button addProduct = new Button(VaadinIcon.PLUS_CIRCLE_O.create());
 Grid<Product> productsGrid = new Grid<>(Product.class, true);

    @PostConstruct
    public void init(){
    this.setSizeFull();
    HorizontalLayout productWrapper = new HorizontalLayout();
    productWrapper.setWidthFull();
    productWrapper.add(productName, addProduct);
    productsGrid.setSizeFull();

    this.add(productWrapper, productsGrid);
}


}
