package com.algaworks.algafood.client.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.OffsetDateTime;

@Getter
@Setter
@ToString
public class Problem {
    private Integer status;
    private String userMessage;
    private String type;
    private String title;
    private String detail;
    private OffsetDateTime timestamp;
}
