package org.hei.spring_td2_td3;

import jdk.jshell.Snippet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping("/welcomeparam")
    public ResponseEntity<String> welcome(@RequestParam(name = "name", required = false ) String name){
        if (name == null) {
            return new ResponseEntity<>("Le parametre n'est pas fourni",HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok("Welcome " + name);
    }
}
