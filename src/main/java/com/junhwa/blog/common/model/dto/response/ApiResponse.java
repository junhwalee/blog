package com.junhwa.blog.common.model.dto.response;

import com.junhwa.blog.goods.model.dto.response.SearchBlogResponseDTO;
import io.micrometer.core.lang.Nullable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Schema(title = "공통 응답")
public class ApiResponse<T> {

    private Integer status = HttpStatus.OK.value();

    private String message = HttpStatus.OK.name();

    private T data;

    private LocalDateTime timestamp = LocalDateTime.now();

    public ApiResponse(@Nullable T data) {
        this.data = data;
    }

    public static <T> ApiResponse<T> ok() {
        return new ApiResponse<>();
    }

}
