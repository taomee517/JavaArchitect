package org.demo.webflux.beans;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;

/**
 * Book
 *
 * @Author: taomee
 * @Date: 2020/4/11 0011 22:32
 * @Description:
 */

@Data
@Table(value = "tb_book")
public class Book implements Serializable {

    @Id
    private Long id;

    private String name;

    private String author;
}
