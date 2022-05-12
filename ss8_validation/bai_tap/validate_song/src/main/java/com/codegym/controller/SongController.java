package com.codegym.controller;

import com.codegym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("/list")
    public String songList(Model model,
                           @PageableDefault(value = 3) Pageable pageable){
        model.addAttribute("song",this.songService.findAll(pageable));

        return "list";
    }

}
