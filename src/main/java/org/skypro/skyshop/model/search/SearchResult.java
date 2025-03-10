package org.skypro.skyshop.model.search;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public class SearchResult {
    private final UUID id;
    private final String name;
    private final String contentType;

    public SearchResult(UUID id, String contentType, String name) {
        this.id = id;
        this.contentType = contentType;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getContentType() {
        return contentType;
    }

    public String getName() {
        return name;
    }

    @JsonIgnore
    public String fromSerhable(Searchable search){
        return contentType+" "+name;
    }
}
