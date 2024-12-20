package com.shop.SV_TASK.view;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class HomeView extends VerticalLayout {

    public HomeView() {

        add(new H1("Приложение Shop"));

        Anchor addProductLink = new Anchor("http://localhost:8080/shop/product", "Просмотр списка продуктов");
        addProductLink.setTarget("_blank");
        add(addProductLink);

        Anchor addSupplierLink = new Anchor("http://localhost:8080/shop/supplier", "Просмотр списка поставщиков");
        addSupplierLink.setTarget("_blank");
        add(addSupplierLink);

        Anchor addPriceLink = new Anchor("http://localhost:8080/shop/price", "Просмотр прайс-листа");
        addPriceLink.setTarget("_blank");
        add(addPriceLink);









    }
}
