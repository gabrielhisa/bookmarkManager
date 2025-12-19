package com.exercising.bookmarks.controller;


import com.exercising.bookmarks.entity.Bookmark;
import com.exercising.bookmarks.service.BookmarkService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.Date;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(BookmarkController.class) // Loads only the web layer and not the entire program, including DB / creates minimal Spring context
public class BookmarkControllerTest {

    @Autowired
    private MockMvc mockMvc; // Pre configured to work with the controller

    @Autowired
    private ObjectMapper objectMapper; // SB injects its configured ObjectMapper

    @MockBean
    private BookmarkService bookmarkService;

    @Test
    void getAllTest() throws Exception {
        // Arranging
        Bookmark bookmark1 = new Bookmark(1L, "Title1", "http://url1.com", "cat1", new Date());
        when(bookmarkService.getAllBookmarks()).thenReturn(Arrays.asList(bookmark1));

        // Asserting
        mockMvc.perform(get("/bookmarks"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title").value("Title1"));

    }

}
