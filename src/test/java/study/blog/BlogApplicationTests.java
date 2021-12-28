package study.blog;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.blog.Order.Order;
import study.blog.Order.QOrder;
import study.blog.hello.Hello;
import study.blog.hello.QHello;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
@Transactional
class BlogApplicationTests {

	@Autowired
	EntityManager em;

	@Test
	void contextLoads() {

		Instant instant = LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.MAX).toInstant(ZoneOffset.UTC);
		Instant instant2 = LocalDateTime.of(LocalDate.now(), LocalTime.MAX).toInstant(ZoneOffset.UTC);

		Instant now =Instant.now();


		Hello hello = new Hello();
		hello.setRequestDate(Instant.now());

		em.persist(hello);

		JPAQueryFactory query = new JPAQueryFactory(em);
		QHello $hello = QHello.hello;


		BooleanBuilder builder = new BooleanBuilder();


		builder.and($hello.requestDate.loe(instant2));

		Hello result = query
				.selectFrom($hello)
				.where(builder)
				.fetchOne();

		assertThat(result).isEqualTo(hello);
		assertThat(hello.getId()).isEqualTo(result.getId());

	}


	@Test
	void reduce() {
		final List<String> names = Arrays.asList("Sehoon", "Songwoo", "Chan", "Youngsuk", "Dajung");
		final List<Integer> ints = Arrays.asList(1,2,3,4,5,6,7,8,9,10);


		//java 7
		String LongerEliment1  = "";
		for (String name : names) {
			if(("hoone".length() <= name.length()) && (LongerEliment1.length() <= name.length())) {
				LongerEliment1 = name;
			}
		}

		System.out.println("java 7 "+LongerEliment1);

		Optional<String> reduce = names.stream().reduce((s, s2) -> s + s2);
		System.out.println(reduce.get());

		//java 8 Lambda
		String LongerEliment2 = names.stream()
				.reduce("hoone", (name1, name2) ->
						name1.length() >= name2.length() ? name1 : name2);
		System.out.println("java 8 "+LongerEliment2);
	}

	@Test
	void DateFormat_Test() {

	}

}
