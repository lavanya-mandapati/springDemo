package com.example.demo.controller;


import com.example.demo.entity.Books;
import com.example.demo.entity.Media;
import com.example.demo.service.MediaServiceImplementation;
import org.springframework.stereotype.Controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/media")
public class MediaController {
    private MediaServiceImplementation mediaServiceImplementation;
    private List<Media> mediaList;

    public MediaController(MediaServiceImplementation themediaServiceImplementation)
    {
      mediaServiceImplementation=themediaServiceImplementation;
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel)
    {
        Media media=new Media();
        theModel.addAttribute("media",media);
        return "media-form";
    }
    @PostMapping("/save")
    public String saveMedia(@ModelAttribute("media") Media theMedia)
    {
        mediaServiceImplementation.save(theMedia);
        return "redirect:/";
    }
   @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("mediaId")int theId,Model theModel)
    {
        Media theMedia=mediaServiceImplementation.findById(theId);
        theModel.addAttribute("media",theMedia);
        return "media-form";
    }
    @GetMapping("/getList")
    public String getList(Model theModel)
    {
       mediaList=mediaServiceImplementation.findAll();
        theModel.addAttribute("media",mediaList);
        return "media-list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("Id")int theId)
    {
        mediaServiceImplementation.deleteById(theId);
        return "redirect:/";
    }
}
