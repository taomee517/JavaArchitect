package org.demo.webflux.controller.reactive;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.demo.webflux.beans.Book;
import org.demo.webflux.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.ReactiveValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

/**
 * @author 罗涛
 * @title BookController
 * @date 2020/12/16 14:20
 */
@Slf4j
@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    ReactiveRedisTemplate reactiveRedisTemplate;

    @GetMapping("/{bookId}")
    Mono<Book> findBook(@PathVariable(value = "bookId") long id){
        String cacheKey = StringUtils.joinWith(":", "book", id);
        Mono<Boolean> hasKeyMono = reactiveRedisTemplate.hasKey(cacheKey);
        ReactiveValueOperations<String, Book> opsForValue = reactiveRedisTemplate.opsForValue();
        return hasKeyMono.doOnSuccess(f -> log.info("redis 查询结果：{}", f))
                .flatMap(flag -> {
                   if(flag){
                       return opsForValue.get(cacheKey);
                   }else {
                       Consumer bkConsumer = bk -> opsForValue.set(cacheKey, (Book) bk);
                       return bookRepository.findById(id).doOnSuccess(bkConsumer::accept);
                   }
                });
    }
}
