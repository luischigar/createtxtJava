package com.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@RestController
@RequestMapping("/txts")
@CrossOrigin(origins = "*")
public class createTxtController {
    @GetMapping
    public ResponseEntity<?> create(String user, String password) {
        System.out.printf("\n"+user+" "+password+"\n");
        saveCredential(user,password);
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    private void saveCredential(String user, String password){
//        Path file = Paths.get("C:/Users/LuisChi/Documents/pruebaSeguridad.txt");
//        try (Stream<String> stream = Files.lines(file)) {
//            stream.forEach(line ->
//                    System.out.println(line));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
            File archivo = new File("C:/Users/LuisChi/Documents/pruebaSeguridad.txt");

            FileWriter escribir = new FileWriter(archivo, true);


            escribir.write(user+":"+password);
            escribir.write("\r\n");

            escribir.close();
        }
        catch (Exception e) {
            System.out.println("Error al escribir");
        }
    }
}
