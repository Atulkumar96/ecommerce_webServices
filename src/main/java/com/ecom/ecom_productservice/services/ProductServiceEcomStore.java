package com.ecom.ecom_productservice.services;

import com.ecom.ecom_productservice.dtos.GenericProductDto;
import com.ecom.ecom_productservice.models.Category;
import com.ecom.ecom_productservice.models.Product;
import com.ecom.ecom_productservice.repositories.CategoryRepository;
import com.ecom.ecom_productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

//@Primary
@Service
public class ProductServiceEcomStore implements ProductService{
    private final CategoryRepository categoryRepository;
    private ProductRepository productRepository;

    public ProductServiceEcomStore(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for(Product product : products){
             genericProductDtos.add(convertProductToGenericProductDto(product));
        }
        return genericProductDtos;
    }

    public GenericProductDto getProductById(int id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            return convertProductToGenericProductDto(product.get());
        }
        else{
            return null;
        }

        //return product.map(this::convertProductToProductDto).orElse(null);
    }

    @Override
    public GenericProductDto addProduct(GenericProductDto genericProduct) {
        Product savedProduct = productRepository.save(convertGenericProductToProduct(genericProduct));
        return convertProductToGenericProductDto(savedProduct);
    }

    @Override
    public GenericProductDto updateProduct(GenericProductDto genericProductDto, int id) {
        Optional<Product> productToUpdate = productRepository.findById(genericProductDto.getProductId());
        if(productToUpdate.isPresent()){
            Product product = productToUpdate.get();

            product.setId(genericProductDto.getProductId());
            product.setTitle(genericProductDto.getTitle());
            product.setDescription(genericProductDto.getDescription());
            product.setPrice(genericProductDto.getPrice());
            product.setImageURL(genericProductDto.getImageURL());

            Category categoryAssigned = product.getCategory();
            //categoryAssigned != categoryInDto = means new Category is needed to be created
            if(!Objects.equals(categoryAssigned.getCategoryName(), genericProductDto.getCategory())){
                Category category = new Category(); //new Category
                category.setCategoryName(genericProductDto.getCategory());

                Category categorySaved = categoryRepository.save(category);

                product.setCategory(categorySaved); //new Category
            }

            Product savedProduct = productRepository.save(product);
            return convertProductToGenericProductDto(savedProduct);
        }
        else{
            return null;
        }
    }

    @Override
    public GenericProductDto deleteProduct(int id) {
        if(productRepository.existsById(id)){
            productRepository.deleteById(id);
        }
        return null;
    }

    public GenericProductDto convertProductToGenericProductDto(Product product) {
        GenericProductDto genericProductDto = new GenericProductDto();

        genericProductDto.setProductId(product.getId());
        genericProductDto.setTitle(product.getTitle());
        genericProductDto.setDescription(product.getDescription());
        genericProductDto.setPrice(product.getPrice());
        genericProductDto.setImageURL(product.getImageURL());
        Category category = product.getCategory();
        genericProductDto.setCategory(category.getCategoryName());

        return genericProductDto;
    }

    public Product convertGenericProductToProduct(GenericProductDto genericProductDto) {
        Product product = new Product();

        product.setTitle(genericProductDto.getTitle());
        product.setDescription(genericProductDto.getDescription());
        product.setPrice(genericProductDto.getPrice());
        product.setImageURL(genericProductDto.getImageURL());

        //Check if the Category is Present or not
        Optional<Category> o_category = categoryRepository.findByCategoryName(genericProductDto.getCategory());

        if(o_category.isPresent()){
            //Category is Present then directly set that Category in Product
            product.setCategory(o_category.get());
        }
        else{
            //create a Category - save the Category in Db - set the Saved Category in Product
            Category category = new Category();
            //category.setId(1);
            category.setCategoryName(genericProductDto.getCategory());
            Category categorySaved = categoryRepository.save(category);

            product.setCategory(categorySaved);
        }


        return product;
    }
}
