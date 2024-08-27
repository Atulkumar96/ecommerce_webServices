package com.ecom.ecom_productservice;

import com.ecom.ecom_productservice.models.Category;
import com.ecom.ecom_productservice.models.Order;
import com.ecom.ecom_productservice.models.Product;
import com.ecom.ecom_productservice.repositories.CategoryRepository;
import com.ecom.ecom_productservice.repositories.OrderRepository;
import com.ecom.ecom_productservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EcomProductServiceApplication { //implements CommandLineRunner {
//	private final OrderRepository orderRepository;
//	private ProductRepository productRepository;
//	private CategoryRepository categoryRepository;
//
//	public EcomProductServiceApplication(ProductRepository productRepository, CategoryRepository categoryRepository, OrderRepository orderRepository) {
//			this.productRepository = productRepository;
//			this.categoryRepository = categoryRepository;
//			this.orderRepository = orderRepository;
//	}

	public static void main(String[] args) {
		SpringApplication.run(EcomProductServiceApplication.class, args);
		System.out.println("Hey! My Ecom Website");
	}

	//@Override
//	public void run(String... args) throws Exception {
//		//created a category and saved using categoryRepository.save(category);
//		Category category = new Category();
//		category.setCategory_name("Clothing");
//
//		categoryRepository.save(category);
//
//		//created a product and saved using productRepository.save(category);
//		Product product = new Product();
//		product.setTitle("T-shirt");
//		product.setDescription("Polo");
//		product.setPrice(100.0);
//		product.setCategory(category);
//		product.setImageURL(null);
//
//		Product product1 = new Product();
//		product1.setTitle("Denim");
//		product1.setDescription("Spykar");
//		product1.setPrice(150.0);
//		product1.setCategory(category);
//		product1.setImageURL(null);
//
//		productRepository.save(product);
//		productRepository.save(product1);
//
//		//created an order and saved using orderRepository.save(category);
//		Order order = new Order();
//
//		List<Product> products = new ArrayList<>();
//		products.add(product);
//		products.add(product1);
//
//		order.setProducts(products);
//
//		orderRepository.save(order);
//
//		//JPA Queries called
//		List<Product> productsFromJPA = productRepository.findByTitle("Samsung");
//
//		System.out.println(productsFromJPA);
//
//		//Native Query called
//		List<Product> productsByCategoryName = productRepository.findAllByCategory_Category_name("Clothing");
//		System.out.println(productsByCategoryName);
//
//	}

}

//1. @SpringBootApplication
// is a convenience annotation that adds all of the following:

//@Configuration: Tags the class as a source of bean definitions for the application context.

//@EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings, other beans,
//and various property settings. For example, if spring-webmvc is on the classpath, this annotation flags the application
// as a web application and activates key behaviors, such as setting up a DispatcherServlet.

//@ComponentScan: Tells Spring to look for other components, configurations, and services in the com/example package,
//letting it find the controllers.

//2. Spring ApplicationContext (ApplicationContext ~ IoC Container ~ contains beans/objects)
// represents the Spring IoC container
// and is responsible for instantiating, configuring, and assembling the aforementioned beans
