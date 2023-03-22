package com.junhwa.blog.goods.controller;

import com.junhwa.blog.common.entity.SearchKeywordEntity;
import com.junhwa.blog.common.model.dto.response.ApiResponse;
import com.junhwa.blog.goods.model.dto.response.SearchBlogResponseDTO;
import com.junhwa.blog.goods.service.SearchBlogService;
import com.junhwa.blog.goods.service.SearchKeywordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/search")
@Tag(name = "검색", description = "검색 API")
public class SearchController {

    private final SearchBlogService searchBlogService;
    private final SearchKeywordService searchKeywordService;

    @Operation(summary = "블로그 검색", description = "다음 블로그 서비스에서 질의어로 게시물을 검색합니다.")
    @Parameters({
            @Parameter(in = ParameterIn.QUERY, name = "sort", description = "결과 문서 정렬 방식", example = "accuracy"),
            @Parameter(in = ParameterIn.QUERY, name = "page", description = "결과 페이지 번호", example = "1"),
            @Parameter(in = ParameterIn.QUERY, name = "size", description = "한 페이지에 보여질 문서 수", example = "10")
    })
    @GetMapping("/blog")
    public ApiResponse<SearchBlogResponseDTO> getSearchBlogs(
            @Parameter(in = ParameterIn.QUERY, name = "query", description = "질의어", example = "집짓기", required = true) @RequestParam String query,
            @Parameter(hidden = true) String sort,
            @Parameter(hidden = true) @PageableDefault(page = 1, size = 10) Pageable pagealbe
    ) throws Exception {
        return new ApiResponse<>(searchBlogService.getSearchBlogs(query,sort,pagealbe));
    }

    @Operation(summary = "인기 검색어 목록", description = "사용자들이 많이 검색한 순서대로, 최대 10개의 검색 키워드를 제공합니다.")
    @GetMapping("/blog/popular-keyword")
    public ApiResponse<List<SearchKeywordEntity>> getPopularKeyword() throws Exception {
        return new ApiResponse<>(searchKeywordService.getTop10SearchKeywords());
    }
}