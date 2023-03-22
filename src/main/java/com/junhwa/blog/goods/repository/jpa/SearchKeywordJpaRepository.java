package com.junhwa.blog.goods.repository.jpa;

import com.junhwa.blog.common.entity.SearchKeywordEntity;
import com.junhwa.blog.goods.repository.jpa.custom.SearchKeywordRepositoryCustom;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SearchKeywordJpaRepository extends JpaRepository <SearchKeywordEntity,Long>
//        , SearchKeywordRepositoryCustom
{
    Optional<SearchKeywordEntity> findByKeyword(String keyword);
    List<SearchKeywordEntity> findTop10ByOrderByCountDesc();

}
