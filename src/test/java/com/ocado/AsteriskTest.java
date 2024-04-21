package com.ocado;


import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class AsteriskTest {
    @Test
    void isValid() throws IOException {
        String fileName = "src/test/java/com/ocado/asteriskData.json";
        String fileContents = new String(Files.readAllBytes(Paths.get(fileName)));
        assertFalse(Asterisk.verifyIAMRolePolicy(fileContents));
    }

    @Test
    void isValid2() throws IOException {
        String fileName = "src/test/java/com/ocado/asteriskData2.json";
        String fileContents = new String(Files.readAllBytes(Paths.get(fileName)));
        assertTrue(Asterisk.verifyIAMRolePolicy(fileContents));
    }

    @Test
    void IsEmpty() throws IOException {
        String fileName = "src/test/java/com/ocado/asteriskData.json";
        String fileContents = new String(Files.readAllBytes(Paths.get(fileName)));
        assertFalse(fileContents.isEmpty());
    }

    @Test
    void fileExists() throws IOException {
        String fileName = "src/test/java/com/ocado/asteriskData2.json";
        assertTrue(Files.exists(Paths.get(fileName)));
    }

    @Test
    void fileExists2() throws IOException {
        String fileName = "src/test/java/com/ocado/asteriskData2.json";
        assertFalse(Files.notExists(Paths.get(fileName)));
    }

    @Test
    void DirectoryFile() throws IOException {
        String fileName = "src/test/java/com/ocado/asteriskData2.json";
        assertFalse(Files.isDirectory(Paths.get(fileName)));
    }

    @Test
    void IsBlank() throws IOException {
        String fileName = "src/test/java/com/ocado/asteriskData.json";
        String fileContents = new String(Files.readAllBytes(Paths.get(fileName)));
        assertFalse(fileContents.isBlank());
    }

    @Test
    void RegularFile() throws IOException {
        String fileName = "src/test/java/com/ocado/asteriskData2.json";
        assertTrue(Files.isRegularFile(Paths.get(fileName)));
    }

    @Test
    void LinkFile() throws IOException {
        String fileName = "src/test/java/com/ocado/asteriskData.json";
        assertFalse(Files.isSymbolicLink(Paths.get(fileName)));
    }




}