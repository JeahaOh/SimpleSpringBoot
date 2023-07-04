package com.example.spring_study.mvc.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by jeaha on 2023/07/02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequest {
    private int page;
    private int size;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private int limit;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private int offset;
}
