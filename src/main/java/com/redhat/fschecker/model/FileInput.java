package com.redhat.fschecker.model;

import java.io.Serializable;

public class FileInput implements Serializable {

    private String content;
    private String path;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
