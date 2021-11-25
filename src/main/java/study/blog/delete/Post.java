package study.blog.delete;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Post {

    @Id @GeneratedValue
    private Long id;

    private String subject;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Reply> replies = Lists.newArrayList();

    public void addReply(String content) {
        this.replies.add(Reply.of(content, this));
    }
}
