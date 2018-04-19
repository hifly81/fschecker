package com.redhat.fschecker.model;

import java.io.Serializable;

public class FileResult implements Serializable {

    private String message;
    private String content;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
