package study.blog.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {



    @PostMapping("/books/case1")
    public void createBookByModelAttribute(BookForm form){

    }

    @PostMapping("/books/case2")
    public void createBookByRequestBody(@RequestBody BookForm form){


    }
}
