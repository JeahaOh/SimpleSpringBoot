package com.example.spring_study.mvc.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by jeaha on 2023/07/08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UploadFileRequest {
    private String pathname;
    private String filename;
    private String originFilename;
    private int size;
    private String contentType;
    private String resourcePathname;
}
