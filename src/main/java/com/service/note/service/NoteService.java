package com.service.note.service;

import com.service.note.model.Note;
import com.service.note.repository.NoteRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class NoteService {
    @Resource private NoteRepository noteRepository;
    @Resource private MarkdownService markdownService;
    @Resource private GrammarService grammarCheckerService;

    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    public List<String> checkGrammar(Long noteId) throws IOException {
        Note note = noteRepository.findById(noteId).orElseThrow();
        return grammarCheckerService.checkGrammar(note.getContent());
    }

    public String renderNote(Long noteId) {
        Note note = noteRepository.findById(noteId).orElseThrow();
        return markdownService.renderMarkdown(note.getContent());
    }
}
