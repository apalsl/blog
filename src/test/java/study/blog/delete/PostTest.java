package study.blog.delete;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class PostTest {

    @Autowired
    EntityManager em;

    @Autowired
    PostRepository postRepository;

    @Autowired
    ReplyRepository replyRepository;

//    @Autowired
//    PostService postService;

    @BeforeEach
    void createDefaultPost() {
        Post post = new Post();
        post.setSubject("TestPost");

        for (int i = 0; i < 100; i++) {
            post.addReply(String.valueOf(i));
        }

        postRepository.save(post);
    }


    @Test
    void createTest2() {
        Post post = new Post();
        post.setSubject("TestPost");

        for (int i = 0; i < 100; i++) {
            post.addReply(String.valueOf(i));
        }

        postRepository.save(post);
    }


    @Test
    void findAll() {
        List<Post> all = postRepository.findAll();

        assertThat(all.size()).isEqualTo(0);
    }

    @Test
    void deletePost() {
        Post post = postRepository.findAll().get(0);

        assertThat(post.getReplies().size()).isEqualTo(100);

        postRepository.delete(post);
        postRepository.flush();
    }


    @Test
    void createPost() {
        Post post = new Post();
        post.setSubject("test post");

        em.persist(post);

        Post save = postRepository.save(post);

        Post savedPost = postRepository.findById(save.getId())
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));

        assertThat(savedPost.getSubject()).isEqualTo(post.getSubject());

        postRepository.delete(savedPost);
    }

    @Test
    void createPosAndAddReply() {
        Post post = new Post();
        post.setSubject("TestPost");
        post.addReply("reply1");

        Post save = postRepository.save(post);

        Post savedPost = postRepository.findById(save.getId())
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));

        assertThat(savedPost.getReplies().size()).isEqualTo(1);
        assertThat(savedPost.getReplies().get(0).getContent()).isEqualTo("reply1");
    }

}