package com.exercising.bookmarks.service;

import com.exercising.bookmarks.entity.Bookmark;
import com.exercising.bookmarks.repository.BookmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookmarkService {

    @Autowired
    private BookmarkRepository bookmarkRepo;

    @Autowired
    public BookmarkService(){

    };

    public List<Bookmark> getAllBookmarks(){
        return bookmarkRepo.findAll();

    };

    public List<Bookmark> getByCategory(String category){
        return bookmarkRepo.findByCategory(category);
    };

    public Bookmark saveBookmark(Bookmark bookmark){
        return bookmarkRepo.save(bookmark);
    }

    public Bookmark updateBookmark(Long id, Bookmark bookmark){
        Bookmark currentBookmark = bookmarkRepo.findById(id).orElseThrow(() -> new RuntimeException("Bookmark not found"));
        currentBookmark.setTitle(bookmark.getTitle());
        currentBookmark.setUrl(bookmark.getUrl());
        currentBookmark.setCategory(bookmark.getCategory());

        return bookmarkRepo.save(currentBookmark);
    }

    public void deleteBookmark(Long id){
        bookmarkRepo.deleteById(id);
    }



}
