package com.shop.SV_TASK.view;

import com.shop.SV_TASK.domain.Supplier;
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

/// # Страница создания поставщиков
/// **url = http://localhost:8080/shop/supplier**


@Route("/supplier")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SupplierView extends VerticalLayout {

    TextField supplierName = new TextField("Наименование поставщика");
    Button addSupplier = new Button(VaadinIcon.PLUS_CIRCLE_O.create());
    Grid<Supplier> suppliersGrid = new Grid<>(Supplier.class, true);

    @PostConstruct
    public void init(){
        this.setSizeFull();
        HorizontalLayout supplierWrapper = new HorizontalLayout();
        supplierWrapper.setWidthFull();
        supplierWrapper.add(supplierName, addSupplier);
        suppliersGrid.setSizeFull();

        this.add(supplierWrapper, suppliersGrid);
    }
}
