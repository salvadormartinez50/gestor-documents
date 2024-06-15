package org.documents.dtos;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;

@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.ANY
)

public class GenericAnswer implements Serializable {
    private static final long serialVersionUID = 0L;
    private transient Message message = new Message();

    public GenericAnswer(String pCode, String pMessage) {
        this.message.setCode(pCode);
        this.message.setMessageInCode(pMessage);
    }
}