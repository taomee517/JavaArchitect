package org.demo.webflux.controller.reactive;

import org.demo.webflux.beans.Book;
import org.demo.webflux.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author 罗涛
 * @title BookController
 * @date 2020/12/16 14:20
 */
@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/{bookId}")
    Mono<Book> findBook(@PathVariable(value = "bookId") long id){
        Mono<Book> book = bookRepository.findById(id);
        return book;
    }
}
