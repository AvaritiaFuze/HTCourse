package com.example.mockserver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

@RestController
@RequestMapping("/app/v1")
public class MockController {

    @GetMapping("/getRequest")
    public ResponseEntity<String> handleGetRequest(@RequestParam int id, @RequestParam String name) throws InterruptedException {
        if (id <= 10) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("id must be greater than 10");
        }
        if (name.length() <= 5) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("name length must be greater than 5");
        }

        if (id > 10 && id < 50) {
            Thread.sleep(1000);
        } else {
            Thread.sleep(500);
        }

        try {
            String content = new String(Files.readAllBytes(Paths.get("getAnswer.txt")));
            content = content.replace("{id}", String.valueOf(id)).replace("{name}", name);
            return ResponseEntity.ok(content);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error reading response file");
        }
    }

    @PostMapping("/postRequest")
    public ResponseEntity<String> handlePostRequest(@RequestBody Map<String, Object> payload) {
        String name = (String) payload.get("name");
        String surname = (String) payload.get("surname");
        Integer age = payload.containsKey("age") ? (Integer) payload.get("age") : 123;

        if (name == null || name.isEmpty()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("name cannot be empty");
        }
        if (surname == null || surname.isEmpty()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("surname cannot be empty");
        }

        int ageTimesTwo = age * 2; // Вычисляем возраст вдвое

        try {
            String content = new String(Files.readAllBytes(Paths.get("postAnswer.txt")));
            content = content.replace("{name}", name)
                    .replace("{surname}", surname)
                    .replace("{age}", String.valueOf(age))
                    .replace("{ageTimesTwo}", String.valueOf(ageTimesTwo)); // Заменяем возраст вдвое
            return ResponseEntity.ok(content);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error reading response file");
        }
    }
}