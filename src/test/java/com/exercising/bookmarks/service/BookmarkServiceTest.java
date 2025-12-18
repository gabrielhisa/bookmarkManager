package com.exercising.bookmarks.service;

import com.exercising.bookmarks.entity.Bookmark;
import com.exercising.bookmarks.repository.BookmarkRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // Will initialize all @Mock and @InjectMocks before each test
public class BookmarkServiceTest {

    // Creating a mock repo
    @Mock
    private BookmarkRepository bookmarkRepo; // Controlling behaviour of this object with 'when' and 'then'

    // Creating a real service and injecting the mock repo into it
    @InjectMocks
    private BookmarkService bookmarkService; // Mockito will create this object with the mock injected

    // Testing the getAllBookmarks(), does it return what it is supposed to, does it actually calls the findAll() method?
    @Test
    void getAllBookmarksTest(){

        // Creating mock list of data
        List<Bookmark> expectedBookmarks = Arrays.asList(
                new Bookmark(1L, "Spring Ref", "https://spring.com", "Dev", new Date()),
                new Bookmark(2L, "GitHub", "https://github.com", "Git", new Date())
        );

        when(bookmarkRepo.findAll()).thenReturn(expectedBookmarks);

        List<Bookmark> actualBookmarks = bookmarkService.getAllBookmarks();

        // Asserts
        assertNotNull(actualBookmarks); // Does not return null
        assertEquals(2, actualBookmarks.size()); // Returns exactly 2 items
        assertEquals(expectedBookmarks, actualBookmarks); // Returns exactly what was expected
        verify(bookmarkRepo, times(1)).findAll(); // Service calls repo exactly once
    }

    // Testing saveBookmark(), does it really save an object correctly?
    @Test
    void saveBookmarkTest(){

        // Creating mock object to save and test if the saved object was indeed saved correctly
        Bookmark inputBookmark = new Bookmark();
        inputBookmark.setTitle("New Bookmark");
        inputBookmark.setUrl("https://example.com");
        inputBookmark.setCategory("Test");
        inputBookmark.setTimeStamp(new Date());

        // Expected return
        Bookmark savedBookmark = new Bookmark();
        savedBookmark.setId(1L);  // Repository adds ID
        savedBookmark.setTitle("New Bookmark");
        savedBookmark.setUrl("https://example.com");
        savedBookmark.setCategory("Test");
        savedBookmark.setTimeStamp(inputBookmark.getTimeStamp());

        // Setting object comparison
        when(bookmarkRepo.save(inputBookmark)).thenReturn(savedBookmark);

        // Activating the method to check if it did save everything correctly
        Bookmark result = bookmarkService.saveBookmark(inputBookmark);

        // Asserts
        assertNotNull(result);
        assertEquals(1L, result.getId()); // Is the ID correct?
        assertEquals("New Bookmark", result.getTitle()); // Was the title saved correctly?
        assertEquals("https://example.com", result.getUrl());
        assertEquals("Test", result.getCategory());

        // Verifying repo interaction, does it save it only once?
        verify(bookmarkRepo, times(1)).save(inputBookmark);
    }

}
