package com.junhwa.blog.goods.repository.jpa;

import com.junhwa.blog.common.entity.BlogEntity;
import com.junhwa.blog.goods.repository.jpa.custom.SearchRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
public interface SearchJpaRepository extends JpaRepository <BlogEntity,Long>
//        , SearchRepositoryCustom
{
}
