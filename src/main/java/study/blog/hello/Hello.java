package study.blog.hello;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;

@Entity
@Getter @Setter
public class Hello {

    @Id @GeneratedValue
    private Long id;

    private Instant requestDate;
}
