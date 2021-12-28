package study.blog.Order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id @GeneratedValue
    private Long id;

    private Instant requestDate;

    public Order(Instant requestDate) {
        this.requestDate = requestDate;
    }

    public static Order from(Instant requestDate) {
        return new Order(requestDate);
    }

    public static Order of(Long id, Instant requestDate) {
        return new Order(id, requestDate);
    }

}
