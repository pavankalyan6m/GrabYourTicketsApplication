package com.project.GrabYourTickets.Security;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.OutputStream;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(MediaType.APPLICATION_JSON);

        String message = "Unauthorized. Please log in.";
        String json = new ObjectMapper().writeValueAsString(message);

        try (OutputStream out = response.getOutputStream()) {
            out.write(json.getBytes());
        }
    }
}
