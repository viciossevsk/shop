package com.shop.SV_TASK.view;

import com.shop.SV_TASK.domain.Product;
import com.shop.SV_TASK.domain.Supplier;
import com.shop.SV_TASK.security.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.security.PermitAll;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

/// # Страница просмотра продуктов
/// **url = http://localhost:8080/shop/price**


@PermitAll
@Route(value="", layout = MainLayout.class)
@PageTitle("Price | Shop")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PriceView extends VerticalLayout {

    ComboBox<Supplier> suppliers = new ComboBox<>();
    Button addSupplier = new Button(VaadinIcon.PLUS_CIRCLE_O.create());
    Grid<Product> productsGrid = new Grid<>(Product.class, false);
    Button addProduct = new Button(VaadinIcon.PLUS_CIRCLE_O.create());

    @PostConstruct
    public void init(){
        this.setSizeFull();
        HorizontalLayout productPriceWrapper = new HorizontalLayout();
        productPriceWrapper.setWidthFull();
        productPriceWrapper.add(suppliers, addSupplier);
        productsGrid.setSizeFull();

        this.add(productPriceWrapper, addProduct, productsGrid);
    }
}
