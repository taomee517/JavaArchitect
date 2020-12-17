package org.demo.webflux.repository;

import org.demo.webflux.beans.Book;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * @author 罗涛
 * @title BookRepository
 * @date 2020/12/16 14:11
 */
public interface BookRepository extends ReactiveCrudRepository<Book, Long> {
}
