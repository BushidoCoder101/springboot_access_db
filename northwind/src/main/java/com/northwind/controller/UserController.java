// // src/main/java/com/northwind/controller/UserController.java
// package com.northwind.controller;

// import io.swagger.v3.oas.annotations.Operation;
// import io.swagger.v3.oas.annotations.tags.Tag;
// import org.springframework.security.core.annotation.AuthenticationPrincipal;
// import org.springframework.security.oauth2.core.oidc.user.OidcUser;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// @Tag(name = "User", description = "Endpoints for authenticated user details")
// public class UserController {

//     @Operation(summary = "Get Authenticated User", description = "Returns details of the currently authenticated user via Google OAuth2")
//     @GetMapping("/user")
//     public OidcUser getUser(@AuthenticationPrincipal OidcUser oidcUser) {
//         return oidcUser;
//     }
// }
