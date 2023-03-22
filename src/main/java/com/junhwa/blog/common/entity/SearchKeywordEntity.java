package com.junhwa.blog.common.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_SEARCH_KEYWORD")
public class SearchKeywordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "keyword", nullable = false)
    private String keyword;

    @Column(name = "count", nullable = false)
    private Integer count = 0;

    public void increaseCount(){
        this.count++;
    }

}
