package com.service.note.controller;

import com.service.note.model.Note;
import com.service.note.service.NoteService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    @Resource private NoteService noteService;

    @PostMapping
    public Note createNote(Note note) {
        return noteService.createNote(note);
    }

    @PostMapping("/{noteId}/check-grammar")
    public List<String> checkGrammar(@PathVariable Long noteId) throws IOException {
        return noteService.checkGrammar(noteId);
    }

    @PostMapping("/{noteId}/render")
    public String renderNote(@PathVariable(value = "noteId") Long noteId) {
        return noteService.renderNote(noteId);
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        String markdown = new String(file.getBytes(), StandardCharsets.UTF_8);
        Note note = new Note();
        note.setTitle(file.getOriginalFilename());
        note.setContent(markdown);
        note = noteService.createNote(note);
        return "File uploaded successfully. Note ID: " + note.getId();
    }
}
