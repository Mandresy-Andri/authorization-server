//package com.company.authorizationservice.controller;
//
//import org.springframework.http.*;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.oauth2.common.OAuth2AccessToken;
//import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//
//import java.util.Base64;
//
//
//
//@RestController
//public class OAuthController {
//
//    @Autowired
//    private DefaultTokenServices tokenServices;
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Value("${oauth2.server.url}")
//    private String oauth2ServerUrl;
//
//    @Value("${oauth2.client.id}")
//    private String clientId;
//
//    @Value("${oauth2.client.secret}")
//    private String clientSecret;
//
//
//    @CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
//    @PostMapping("/accessToken")
//    @ResponseBody
//    public ResponseEntity<OAuth2AccessToken> getAccessToken(@RequestParam String username,@RequestParam  String password,@RequestParam  String scope) {
//
//        String authHeader = clientId + ":" + clientSecret;
//        String encodedAuthHeader = Base64.getEncoder().encodeToString(authHeader.getBytes());
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//        headers.add("Authorization", "Basic " + encodedAuthHeader);
//
//        String body = "username=" + username + "&password=" + password + "&grant_type=password&scope=" + scope;
//
//        HttpEntity<String> request = new HttpEntity<>(body, headers);
//
//        ResponseEntity<OAuth2AccessToken> response = restTemplate.postForEntity(oauth2ServerUrl, request, OAuth2AccessToken.class);
//
//        if (response.getStatusCode() == HttpStatus.OK) {
//            return ResponseEntity.ok(response.getBody());
//        } else {
//            return ResponseEntity.status(response.getStatusCode()).build();
//        }
//    }
//}
//
