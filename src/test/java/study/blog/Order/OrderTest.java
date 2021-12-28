package study.blog.Order;

import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.JPQLQueryFactory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class OrderTest {

    @Autowired
    EntityManager em;

    @Autowired
    private OrderRepository orderRepository;

    @BeforeEach
    public void test() {
        Order order = Order.from(Instant.now());
        em.persist(order);
    }

    @Test
    public void find() {

        QOrder $order = QOrder.order;

        JPQLQueryFactory query = new JPAQueryFactory(em);

        Order order = query
                .selectFrom($order)
                .fetchOne();

        System.out.println(order);
    }

}