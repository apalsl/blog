package study.blog.delete;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long save(Post post) {
        return postRepository.save(post).getId();
    }

    @Transactional
    public void delete(Post post) {
        postRepository.delete(post);
    }
}
