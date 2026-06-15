package org.example.music.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.music.model.Song;
import org.example.music.service.ISongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/songs")
@RequiredArgsConstructor
public class SongController {

    private final ISongService songService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("songs", songService.findAll());
        return "list";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        songService.delete(id);
        return "redirect:/songs";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("song", new Song());
        return "form";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("song") Song song,
                       BindingResult bindingResult,
                       Model model) {

        if (bindingResult.hasErrors()) {
            return "form";
        }

        songService.save(song);
        return "redirect:/songs";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id,
                               Model model) {

        model.addAttribute("song", songService.findById(id));
        return "form";
    }
}