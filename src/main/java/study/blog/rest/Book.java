package study.blog.rest;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Book {

    @Id @GeneratedValue
    private Long id;

    private String name;

    private Integer page;
}
