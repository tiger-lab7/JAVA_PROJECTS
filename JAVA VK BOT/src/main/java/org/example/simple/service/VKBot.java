package org.example.simple.service;

import com.google.gson.Gson;
import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class VKBot {

    @Autowired
    private JsonReader jsonReader;

    private VkAccess vkAccess;

    public void init() throws ClientException, ApiException, IOException {

        TransportClient transportClient = HttpTransportClient.getInstance();
        VkApiClient vk = new VkApiClient(transportClient, new Gson(), 1);

        vkAccess = jsonReader.scanJson();
        UserActor userActor = new UserActor(vkAccess.userId, vkAccess.accessToken);

        vk.wall().post(userActor).message("Hello world!").execute();

        //File file = new File("C:/Users/A12/Downloads/pexels-jess-vide-4319879.jpg");
        File file = new File("C:/Users/A12/Downloads/Mq8QiaCQYcc.jpg");

       /* PhotoUpload serverResponse = vk.photos().getWallUploadServer(userActor).execute();
        WallUploadResponse uploadResponse = vk.upload().photoWall(serverResponse.getUploadUrl(), file).execute();
        List<Photo> photoList = vk.photos().saveWallPhoto(userActor, uploadResponse.getPhoto())
                .server(uploadResponse.getServer())
                .hash(uploadResponse.getHash())
                .execute();
        Photo photo = photoList.get(0);
        */
/*
        PhotosGetAllQuery photosGetAllQuery = vk.photos().getAll(userActor).;
        photosGetAllQuery.count()
        String attachId = "photo" + photo.getOwnerId() + "_" + photo.getId();
        PostResponse postResponse = vk.wall().post(userActor)
                .attachments(attachId)
                .execute();*/
    }
}
