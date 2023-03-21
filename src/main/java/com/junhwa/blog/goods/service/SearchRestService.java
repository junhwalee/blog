package com.junhwa.blog.goods.service;

import com.junhwa.blog.goods.model.dto.response.SearchBlogResponseDTO;
import com.junhwa.blog.property.KakaoProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@RequiredArgsConstructor
@Service
public class SearchRestService {

    @Value("${application.provider.kakao.base-api-url}")
    private String BASE_URL;

    private final KakaoProperties kakaoProperties;
//    private final WebClient webClient;

    public Mono<SearchBlogResponseDTO> getSearchBlogs(String query, Pageable pageable){

        /*MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
        param.add("query", query);
        param.add("sort", String.valueOf(pageable.getSort()));
        param.add("page", String.valueOf(pageable.getPageNumber()));
        param.add("size", String.valueOf(pageable.getPageSize()));

        return webClient.mutate()
                .baseUrl(kakaoProperties.getBaseApiUrl())
                .build()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v2/search/blog")
                        .queryParams(param)
                        .build()
                )
                .header("Authorization","KakaoAK "+kakaoProperties.getRestApiKey())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                });*/
        return null;
    }
}
