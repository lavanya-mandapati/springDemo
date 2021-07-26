package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public @Data
@AllArgsConstructor
@NoArgsConstructor
class MediaDto {

    private String Id;
    private String mediaName;
    private String mediaType;
    private String mediaVisibility;
}
