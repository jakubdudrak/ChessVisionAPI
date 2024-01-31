package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Endpoint {

    @GetMapping("/calculateMove")
    public String calculateMove(@RequestParam(name = "move") String move) {
        if (!isValidChessMove(move)) {
            return "Invalid move. Please use standard algebraic notation.";
        }
        return "Valid move: " + move;
    }

    private boolean isValidChessMove(String move) {
        String regex = "^(?:[KQRBN][a-h]?[1-8]?x?[a-h][1-8]|[a-h]x?[a-h][1-8]|O-O(?:-O)?)$";
        return move.matches(regex);
    }
}
