package com.example.picpay_project.service;

import com.example.picpay_project.domain.users.User;
import com.example.picpay_project.dto.NotificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {
    @Autowired
    private RestTemplate restTemplate;

    public void sendNotification(User user, String message) throws Exception {
        String email = user.getEmail();
        NotificationDTO notificationRequest = new NotificationDTO(email,message);

//        var url = "https://run.mocky.io/v3/54dc2cf1-3add-45b5-b5a9-6bf7e7f1f4a6";
//        ResponseEntity<String> notificationResponse = restTemplate.postForEntity(url,notificationRequest,String.class);
//
//        if(!(notificationResponse.getStatusCode()== HttpStatus.OK)){
//            System.out.println("Erro ao enviar a mensagem");
//            throw new Exception("Serviço de notificação está fora de ar");
//        }
        System.out.println("Notificação enviada");
    }
}
