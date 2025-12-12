package com.exercising.bookmarks.controller;

import com.exercising.bookmarks.entity.Bookmark;
import com.exercising.bookmarks.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookmarks")
public class BookmarkController {

    @Autowired
    private BookmarkService service;

    @GetMapping // Simple return when accessing /bookmarks
    public List<Bookmark> getAll(){
        return service.getAllBookmarks();
    }

    @GetMapping("/{category}") // Get with category filter
    public List<Bookmark> getByCategory(String category){
        return service.getByCategory(category);
    }

    @PostMapping
    public Bookmark create(@RequestBody Bookmark bookmark){ // @RequestBody will pick up the JSON part in the HTTP request and 'translate' it to a Bookmark object
        return service.saveBookmark(bookmark);
    }

    @PutMapping("/{id}")
    public Bookmark update(@PathVariable Long id, @RequestBody Bookmark bookmark){
        return service.updateBookmark(id, bookmark);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.deleteBookmark(id);
    }





}
