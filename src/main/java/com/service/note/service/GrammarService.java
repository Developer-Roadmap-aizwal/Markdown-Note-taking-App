package com.service.note.service;

import org.languagetool.JLanguageTool;
import org.languagetool.Languages;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GrammarService {

    public List<String> checkGrammar(String text) throws IOException {
        List<String> logs = new ArrayList<>();

        JLanguageTool langTool = new JLanguageTool(Languages.getLanguageForShortCode("en")); // Initialize LanguageTool with English language

        List<org.languagetool.rules.RuleMatch> matches = langTool.check(text);

        logs.add("Input: " + text);
        logs.add("Suggestions:");
        for (org.languagetool.rules.RuleMatch match : matches) {
            logs.add("Error: " + match.getMessage());
            logs.add("Rule: " + match.getSentence().getText());
            logs.add("Suggested Replacement: " + match.getSuggestedReplacements());
        }

        return logs;
    }

}
