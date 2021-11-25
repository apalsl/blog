package study.blog.delete;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Reply {

    @Id @GeneratedValue
    private Long id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    public Reply(String content, Post post) {
        this.content = content;
        this.post = post;
    }

    public static Reply of(String content, Post post) {
        return new Reply(content, post);
    }
}
