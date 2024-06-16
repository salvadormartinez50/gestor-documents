package org.documents.dtos;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GenericAnswer implements Serializable {
    private static final long serialVersionUID = 0L;
    private final String code;
    private String message;

    public GenericAnswer(String code, String message) {
        this.code = code;
        this.message = message;
    }
}