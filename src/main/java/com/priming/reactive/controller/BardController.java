package com.priming.reactive.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ai.vertex.language_models.CodeChatModel;
import ai.vertex.VertexAiOptions;
import ai.vertex.vertexai.VertexAiVertexAiOptions;
import ai.vertex.language_models.CodeChatModel.ChatSession;
import ai.vertex.language_models.CodeChatModel.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class BardController {

    @PostMapping("/ask-bard")
    public ResponseEntity<String> askBard(@RequestBody String question) {
        try {
            String response = interactWithBard(question);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    private String interactWithBard(String question) throws IOException {
        // Initialize Vertex AI client outside of method for efficiency
        VertexAiOptions options = VertexAiOptions.newBuilder()
                .setProject("primingv1")
                .setLocation("us-central1")
                .build();
        VertexAiVertexAiOptions.configure(options);

        // Load CodeChat model
        CodeChatModel chatModel = CodeChatModel.from_pretrained("codechat-bison");

        // Set chat parameters
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("candidate_count", 1);
        parameters.put("max_output_tokens", 1024);
        parameters.put("temperature", 0.9);

        // Start chat and send question
        ChatSession chat = chatModel.start_chat();
        Response response = chat.send_message(question, parameters);

        return response.getText();
    }
}
