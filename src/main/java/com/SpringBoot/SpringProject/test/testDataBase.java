package com.SpringBoot.SpringProject.test;

import com.SpringBoot.SpringProject.entities.*;
import com.SpringBoot.SpringProject.entities.enums.OrderStatus;
import com.SpringBoot.SpringProject.repositories.*;
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
    @Autowired
    private OrderItemRepository  orderItemRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(null, "Kauan Araujo", "araujo@gmail", "9909099", "0000001");
        User user2 = new User(null, "Jose Generic", "jose@gmail", "8808088", "0000002");
        User user3 = new User(null, "Pedro Generic", "pedro@gmail", "7707077", "0000003");

        userRepository.saveAll(Arrays.asList(user1, user2, user3));

        Order order1 = new Order(null, Instant.now(), OrderStatus.WAITING_PAYMENT);
        Order order2 = new Order(null, Instant.now(), OrderStatus.PAID);
        Order order3 = new Order(null, Instant.now(), OrderStatus.DELIVERED);

        order1.setUser(user1);
        order2.setUser(user3);
        order3.setUser(user1);

        orderRepository.saveAll(Arrays.asList(order1, order2, order3));

        user1.getOrders().add(order1);
        user1.getOrders().add(order3);
        user3.getOrders().add(order2);


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

        userRepository.saveAll(Arrays.asList(user1, user2, user3));

        OrderItem orderItem1 = new OrderItem(order1, product1, product1.getPrice(), 1);
        OrderItem orderItem2 = new OrderItem(order1, product2, product2.getPrice(), 1);
        OrderItem orderItem3 = new OrderItem(order2, product3, product3.getPrice(), 2);
        OrderItem orderItem4 = new OrderItem(order3, product4, product4.getPrice(), 4);

        orderItemRepository.saveAll(Arrays.asList(orderItem1, orderItem2, orderItem3, orderItem4));







    }
}
