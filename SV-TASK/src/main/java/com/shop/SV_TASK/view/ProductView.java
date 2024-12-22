package com.shop.SV_TASK.view;

import com.shop.SV_TASK.domain.Product;
import com.shop.SV_TASK.security.MainLayout;
import com.shop.SV_TASK.service.ProductService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.security.PermitAll;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.ApplicationContext;

/// # Страница создания продуктов


@PermitAll
@RequiredArgsConstructor
@Route(value = "Product", layout = MainLayout.class)
@PageTitle("Product | Shop")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductView extends VerticalLayout {

   ApplicationContext context;

   ProductService productService;

   Button addProduct = new Button(VaadinIcon.PLUS_CIRCLE_O.create());
   Button refreshGrid = new Button(VaadinIcon.REFRESH.create());
   Grid<Product> productsGrid = new Grid<>(Product.class, false);

   @PostConstruct
   public void init() {
      this.setSizeFull();
      HorizontalLayout productWrapper = new HorizontalLayout();
      productWrapper.setWidthFull();
      HorizontalLayout space = new HorizontalLayout();
      space.setWidthFull();
      productsGrid.setSizeFull();
      productsGrid.addColumn(Product::getName).setHeader("Наименование");
      HorizontalLayout gridTools = new HorizontalLayout(productsGrid, addProduct, refreshGrid);
      gridTools.setWidthFull();
      this.add(productWrapper, gridTools, productsGrid);
      addProduct.addClickListener(event -> this.context.getBean(ProductAddView.class).open());
      refreshGrid.addClickListener(event -> {
         this.productsGrid.setItems(productService.getAll());
      });

      productsGrid.setItems(productService.getAll());


   }


}
