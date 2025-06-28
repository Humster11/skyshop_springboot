package org.skypro.skyshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.service.SearchService;
import org.skypro.skyshop.service.StorageService;

import java.util.*;

@ExtendWith(MockitoExtension.class)
public class SeerchServiceTest {

    @Mock
    private SearchService searchService;

    @InjectMocks
    private StorageService storageService;

    @Test
    public void StorageServiceIsNull(){
        storageService.getProduct().removeAll(storageService.getProduct());
        storageService.getArticle().removeAll(storageService.getArticle());
        Collection<SearchResult> emptyList = Collections.emptyList();
        Collection<SearchResult> ResultList = searchService.search("хлеб");
        Assertions.assertArrayEquals(emptyList.toArray(), ResultList.toArray());

    }

    @Test
    public void StorageServiceFullButNotSiutable(){
        String searchQuery = "кабачок";
        Collection<SearchResult> emptyList = Collections.emptyList();
        Collection<SearchResult> ResultList = searchService.search(searchQuery);
        Assertions.assertArrayEquals(emptyList.toArray(), ResultList.toArray());
    }

    @Test
    public void StorageServiceFullButSiutable(){
        String searchQuery = "хлеб";
        Collection<SearchResult> ResultList = searchService.search(searchQuery);
        Collection<SearchResult> ResultListCorrect = searchService.search("хлеб");
        Assertions.assertArrayEquals(ResultListCorrect.toArray(), ResultList.toArray());
    }

}
