package com.junhwa.blog.goods.service;

import com.junhwa.blog.goods.model.dto.response.SearchBlogResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@RequiredArgsConstructor
@Service
public class SearchBlogService {

    private final WebClient kakaoWebClient;

    private final SearchKeywordService searchKeywordService;

    public SearchBlogResponseDTO getSearchBlogs(String query, String sort, Pageable pageable) throws Exception{

        MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
        param.add("query", query);
        param.add("sort", sort!=null ? sort : "accuracy");
        param.add("page", String.valueOf(pageable.getPageNumber()));
        param.add("size", String.valueOf(pageable.getPageSize()));

        searchKeywordService.increaseSearchCount(query);

        return kakaoWebClient.mutate()
                .build()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v2/search/blog")
                        .queryParams(param)
                        .build()
                )
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<SearchBlogResponseDTO>() {
                })
                .block();
    }

}
