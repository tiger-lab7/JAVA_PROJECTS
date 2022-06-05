package org.example.simple.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Component
public class JsonReader {

    public VkAccess scanJson(String... args) throws IOException {

        Gson gson = new GsonBuilder().setLenient().create();

        BufferedReader bufferedReader = new BufferedReader(new FileReader("vkAccess.json"));
        StringBuilder stringBuilder = new StringBuilder();

        try {
            while (true) {
                int n = bufferedReader.read();
                if (n == -1) break;
                stringBuilder.append((char) n);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // GSON requires to delete last -1 in the JSON String

        String jsonFile = stringBuilder.toString();

        VkAccess vkAccess = gson.fromJson(jsonFile, VkAccess.class);
        System.out.println(" Token " + vkAccess.token);

        return vkAccess;

    }
}


class VkAccess {
    public int groupId;
    public String token;
    public String userLogin;
    public String userPassword;
    public int userId;
    public String accessToken;
}
