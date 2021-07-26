package com.example.demo.service;

import com.example.demo.Exception.IdNotFoundException;
import com.example.demo.dao.MediaRepository;
import com.example.demo.entity.Books;
import com.example.demo.entity.Media;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class MediaServiceImplementation {


    private  final MediaRepository mediaRepository;

    @Autowired
    public MediaServiceImplementation(MediaRepository themediaRepository) {
        mediaRepository = themediaRepository;
    }


    public List<Media> findAll() {
        return mediaRepository.findAll();
    }


    public Media findById(int theId) {
        Optional<Media> result = mediaRepository.findById(theId);
        Media media = null;
        if(result.isPresent())
        {
            media= result.get();
        }
        else {
            throw new IdNotFoundException("id not found "+theId);
        }
        return media;
    }


    public void save(Media theMediaId) {
        mediaRepository.save(theMediaId);
    }


    public void deleteById(int theId) {
        Media theMedia=mediaRepository.findById(theId).orElseThrow(()->(new IdNotFoundException("media not found "+theId)));
        mediaRepository.deleteById(theId);

    }
}
