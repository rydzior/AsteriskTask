package com.ocado;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Asterisk {
    public static void main(String[] args) {
        String fileName = "src/main/java/com/ocado/data.json";
        try{
            String fileContents = new String(Files.readAllBytes(Paths.get(fileName)));
            boolean isValid = verifyIAMRolePolicy(fileContents);
            System.out.println("JSON is Valid?\n" + isValid);
        }
        catch(IOException e){
            System.out.println("Error reading file" + e.getMessage());
        }
    }

    public static boolean verifyIAMRolePolicy(String fileContents){
        JSONObject jsonObject = new JSONObject(fileContents);
        JSONArray statements = jsonObject.getJSONObject("PolicyDocument").getJSONArray("Statement");
        String resource = statements.getJSONObject(0).getString("Resource");

        if(resource.equals("*"))
            return false;
        else
            return true;
    }
}