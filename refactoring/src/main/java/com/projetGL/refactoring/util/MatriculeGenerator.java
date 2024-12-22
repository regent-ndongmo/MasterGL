package com.projetGL.refactoring.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class MatriculeGenerator {

    public static String generateMatricule(String prefix) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String timestamp = LocalDateTime.now().format(formatter);
        String uniqueId = UUID.randomUUID().toString().substring(0, 6).toUpperCase();
        return prefix + timestamp + uniqueId;
    }

}
