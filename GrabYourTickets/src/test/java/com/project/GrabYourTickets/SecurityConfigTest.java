package com.project.GrabYourTickets;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders;
import org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;

@SpringBootTest
@AutoConfigureMockMvc
public class SecurityConfigTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAuthenticationWithAdminUser() throws Exception {
        mockMvc.perform(formLogin().user("admin").password("admin"))
                .andExpect(SecurityMockMvcResultMatchers.authenticated());

        mockMvc.perform(SecurityMockMvcRequestBuilders.logout())
                .andExpect(SecurityMockMvcResultMatchers.unauthenticated());
    }

    @Test
    public void testAccessWithUnauthenticatedUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users/register"))
                .andExpect(SecurityMockMvcResultMatchers.unauthenticated());
    }
}
