package com.junhwa.blog.goods.service;

import com.junhwa.blog.goods.model.dto.response.SearchBlogResponseDTO;
import com.junhwa.blog.goods.repository.jpa.SearchJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Service
public class SearchService {

    @Value("${application.provider.kakao.base-api-url}")
    private String BASE_URL;

    private final WebClient kakaoWebClient;

    private final SearchRestService searchRestService;
    private final SearchJpaRepository searchJpaRepository;

    public SearchBlogResponseDTO getSearchBlogs(String query, String sort, Pageable pageable){

        MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
        param.add("query", query);
        param.add("sort", sort!=null ? sort : "accuracy");
        param.add("page", String.valueOf(pageable.getPageNumber()));
        param.add("size", String.valueOf(pageable.getPageSize()));

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
