package com.example.User.Service.services;

import com.example.User.Service.entities.Address;
import com.example.User.Service.entities.Category;
import com.example.User.Service.entities.Product;
import com.example.User.Service.entities.User;
import com.example.User.Service.repositories.*;
import com.example.User.Service.repositories.specifications.productSpec;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@AllArgsConstructor
@Service
public class userService {
    private final userRepository userRepository;
    private final EntityManager entityManager;
    private final addressRepository addressRepository;
    private final categoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final profileRepository profileRepository;

    @Transactional
    public void showEntityStates(){
        var user = User.builder()
                .name("von")
                .email("von@mail.com")
                .password("passcode")
                .build();

        if(entityManager.contains(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient / Detached");

        userRepository.save(user);

        if(entityManager.contains(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient / Detached");
    }

    public void showRelatedEntity(){

       var address = addressRepository.findById(1L).orElseThrow();
        System.out.println(address.getCity());
    }

    public void saveRelatedEntities(){
        var user = User.builder()
                .name("von neumann")
                .email("von@mail.com")
                .password("passcode")
                .build();

        var address = Address.builder()
                .zip("zip")
                .state("tate")
                .city("tity")
                .street("treet")
                .build();

        user.addAddress(address);
        userRepository.save(user);
    }

    @Transactional
    public void deleteRelatedEntity(){
    var user = userRepository.findById(9L).orElseThrow();
    var address = user.getAddresses().getFirst();

    user.removeAddress(address);
    userRepository.save(user);
    }

    @Transactional
    public void productToCategory(){
        var category = categoryRepository.findById(4L).orElseThrow();
//        System.out.println(category.getName());

        var product = Product.builder()
                .name("dell")
                .price(BigDecimal.valueOf(221.22))
                .category(category)
                .build();

        productRepository.save(product);

    }

    @Transactional
    public void fetchProducts(){
        var products = productRepository.findProducts(BigDecimal.valueOf(110), BigDecimal.valueOf(150));
        products.forEach(System.out::println);
    }

    public void findProductsByCriteria(){
        var products = productRepository.findProductsByCriteria(null, BigDecimal.valueOf(130), BigDecimal.valueOf(150));
        products.forEach(System.out::println);
    }

    public void findProductsBySpecification(String name, BigDecimal minPrice, BigDecimal maxPrice){
        Specification<Product> spec = Specification.where(null);

        if(name != null){
            spec = spec.and(productSpec.hasName(name));
        }
        if(minPrice != null){
            spec = spec.and(productSpec.hasPriceGreaterThanOrEqualTo(minPrice));
        }
        if(maxPrice != null){
            spec = spec.and(productSpec.hasPriceLessThanOrEqualTo(maxPrice));
        }

        productRepository.findAll(spec).forEach(System.out::println);
    }

    @Transactional
    public void updateProductPrice(){
        productRepository.updatePriceByCategory(BigDecimal.valueOf(134.21), BigDecimal.valueOf(4L));
    }

    public void findProducts(){
        var product = new Product();
        product.setName("product");
        var matcher = ExampleMatcher.matching()  //Example matcher object for customizing matching behavior
                .withIncludeNullValues()
                .withIgnorePaths("id", "description")
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        var example = Example.of(product, matcher);
        var products = productRepository.findAll(example);
        products.forEach(System.out::println);
    }

    public void findProfiles(){
        var profiles = profileRepository.findProfilesByLoyaltyPointsOrderByEmail(2);
        profiles.forEach(p -> System.out.println(p.getId() + " " + p.getUser().getEmail()));
    }

    public void fetchSortedProducts(){
       var sort = Sort.by("name").and(
                Sort.by("price").descending()  //ascending by default
        );

//       simply could be Sort.by("name", "Price").descending();


        productRepository.findAll(sort).forEach(System.out::println);
    }

    public void fetchPaginatedProducts(int pageNumber, int size){
        PageRequest pageRequest = PageRequest.of(pageNumber,size);
       Page<Product> page = productRepository.findAll(pageRequest); // return a page

       var products = page.getContent(); // get all products from that page
       products.forEach(System.out::println);

       var totalPages = page.getTotalPages(); //total pages of products in db
       var totalElements = page.getTotalElements(); //total products in db

        System.out.println("Total pages: " + totalPages);
        System.out.println("Total elements: " + totalElements);
    }
}
