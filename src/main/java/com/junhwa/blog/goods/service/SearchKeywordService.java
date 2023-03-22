package com.junhwa.blog.goods.service;

import com.junhwa.blog.common.entity.SearchKeywordEntity;
import com.junhwa.blog.goods.repository.jpa.SearchKeywordJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class SearchKeywordService {

    private final SearchKeywordJpaRepository searchKeywordJpaRepository;

    public List<SearchKeywordEntity> getTop10SearchKeywords() {
        return searchKeywordJpaRepository.findTop10ByOrderByCountDesc();
    }

    public void increaseSearchCount(String keyword) {
        Optional<SearchKeywordEntity> optionalKeyword = searchKeywordJpaRepository.findByKeyword(keyword);
        SearchKeywordEntity searchKeywordEntity;

        if (optionalKeyword.isPresent()) {
            searchKeywordEntity = optionalKeyword.get();
        } else {
            searchKeywordEntity = new SearchKeywordEntity();
            searchKeywordEntity.setKeyword(keyword);
        }

        searchKeywordEntity.increaseCount();
        searchKeywordJpaRepository.save(searchKeywordEntity);
    }
}
