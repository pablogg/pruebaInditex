package com.prueba.inditex.infrastructure.adapters.output.customizedexception.data.response;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {

	//private LocalDateTime Timestamp;

    private String message;

    private List<String> details;

}

