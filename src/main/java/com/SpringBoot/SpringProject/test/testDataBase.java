package com.SpringBoot.SpringProject.test;

import com.SpringBoot.SpringProject.entities.Category;
import com.SpringBoot.SpringProject.entities.Order;
import com.SpringBoot.SpringProject.entities.Product;
import com.SpringBoot.SpringProject.entities.User;
import com.SpringBoot.SpringProject.entities.enums.OrderStatus;
import com.SpringBoot.SpringProject.repositories.CategoryRepository;
import com.SpringBoot.SpringProject.repositories.OrderRepository;
import com.SpringBoot.SpringProject.repositories.ProductRepository;
import com.SpringBoot.SpringProject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.Arrays;

@Configuration
public class testDataBase implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(null, "Kauan Araujo", "araujo@gmail", "9909099", "0000001");
        User user2 = new User(null, "Jose Generic", "jose@gmail", "8808088", "0000002");
        User user3 = new User(null, "Pedro Generic", "pedro@gmail", "7707077", "0000003");

        userRepository.saveAll(Arrays.asList(user1, user2, user3));

        Order order1 = new Order(null, Instant.now(), OrderStatus.WAITING_PAYMENT);
        Order order2 = new Order(null, Instant.now(), OrderStatus.PAID);
        Order order3 = new Order(null, Instant.now(), OrderStatus.DELIVERED);

        orderRepository.saveAll(Arrays.asList(order1, order2, order3));

        Category category1 = new Category(null, "Hardware");
        Category category2 = new Category(null, "Eletronics");
        Category category3 = new Category(null, "Books");

        categoryRepository.saveAll(Arrays.asList(category1, category2, category3));


        Product product1 = new Product(null, "Placa mãe aorus elite B550m", "Placa mãe", 729.99, "");
        Product product2 = new Product(null, "Ryzen 5 5600G", "Processador Ryzen AMD", 899.0, "");
        Product product3 = new Product(null, "Engenharia de software ian sommerville 10ed", "livro sobre engenharia de software", 284.99, "");
        Product product4 = new Product(null, "Xiaomi redmi note 13 PRO PLUS ", "telefone celular importado", 2189.99, "");

        product1.getcategories().add(category1);
        product1.getcategories().add(category2);
        product2.getcategories().add(category1);
        product2.getcategories().add(category2);
        product3.getcategories().add(category3);
        product4.getcategories().add(category2);

        productRepository.saveAll(Arrays.asList(product1, product2, product3, product4));





    }
}
