package study.blog;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.blog.hello.Hello;
import study.blog.hello.QHello;

import javax.persistence.EntityManager;

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
		Hello hello = new Hello();
		em.persist(hello);

		JPAQueryFactory query = new JPAQueryFactory(em);
		QHello $hello = QHello.hello;

		Hello result = query
				.selectFrom($hello)
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

}
