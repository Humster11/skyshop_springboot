package org.skypro.skyshop.service;

import org.skypro.skyshop.model.search.SearchResult;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import java.util.UUID;

@Service
public class SearchService {


    public SearchService() {

    }

    public Collection<SearchResult> search(String searchQuery) {

        StorageService storage = new StorageService();

        List<SearchResult> searchableSet = storage.getAllSearchObject().stream()
                .filter(element->element.getSearchTerm().contains(searchQuery))
                .map(element->new SearchResult(UUID.randomUUID(),element.getSearchTerm(),element.getTypeContent()))
                .collect(Collectors.toList());

        return searchableSet;
    }

}
