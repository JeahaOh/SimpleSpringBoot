package com.example.spring_study.mvc.domain.common;

import com.example.spring_study.mvc.domain.dto.PageRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 페이지 요청 정보와 파라미터 정보.
 * Created by jeaha on 2023/07/02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestParameter<T> {
    private PageRequest pageRequest;
    private T parameter;
}
