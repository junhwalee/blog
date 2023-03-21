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
//@Table(name = "TB_BLOG")
public class BlogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "contents")
    private String contents;

    @Column(name = "url")
    private String url;

    @Column(name = "blogname")
    private String blogname;
    
    @Column(name = "thumbnail")
    private String thumbnail;
    
    @Column(name = "datetime")
    private LocalDateTime datetime;
}
