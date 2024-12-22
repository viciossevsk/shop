package com.shop.SV_TASK.view;

import com.shop.SV_TASK.domain.Product;
import com.shop.SV_TASK.security.MainLayout;
import com.shop.SV_TASK.service.ProductService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinServletRequest;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.security.PermitAll;
import jakarta.servlet.ServletException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/// # Страница создания продуктов


@PermitAll
@RequiredArgsConstructor
@Route(value = "Product", layout = MainLayout.class)
@PageTitle("Product | Shop")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductView extends VerticalLayout {

   ApplicationContext context;

   ProductService productService;

 TextField productName = new TextField("Наименование продукта");
    Button addProduct = new Button(VaadinIcon.PLUS_CIRCLE_O.create());
 Grid<Product> productsGrid = new Grid<>(Product.class, true);

//    @PostConstruct
//    public void init(){
//    this.setSizeFull();
//    HorizontalLayout productWrapper = new HorizontalLayout();
//    productWrapper.setWidthFull();
//    productWrapper.add(productName, addProduct);
//    productsGrid.setSizeFull();
//
//    this.add(productWrapper, productsGrid);
//}

   @PostConstruct
   public void init() {
      this.setSizeFull();
      HorizontalLayout plantWrapper = new HorizontalLayout();
      plantWrapper.setWidthFull();
      HorizontalLayout space = new HorizontalLayout();
      space.setWidthFull();
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//      Text username;
//      if(authentication.getPrincipal() instanceof User u) {
//         username = new Text(u.getUsername());
//      } else {
//         username = new Text(authentication.getPrincipal().toString());
//      }
      Button logoutButton = new Button(VaadinIcon.SIGN_OUT.create());
      logoutButton.addClickListener(e -> {
         try {
            VaadinServletRequest.getCurrent().logout();
         } catch (ServletException ex) {
            throw new RuntimeException(ex);
         }
      });
      productsGrid.setSizeFull();
      productsGrid.addColumn(Product::getName).setHeader("Наименование");
      HorizontalLayout gridTools = new HorizontalLayout(productsGrid, addProduct);
      gridTools.setWidthFull();
      this.add(plantWrapper, gridTools, productsGrid);
      addProduct.addClickListener(event -> this.context.getBean(ProductAddView.class).open());

   //   productsGrid.setItems(productService.getAllProducts());
//      this.plants.addValueChangeListener(event -> {
//         this.productsGrid.setItems(productionService.getAll(event.getValue()));
//      });
   }


}
