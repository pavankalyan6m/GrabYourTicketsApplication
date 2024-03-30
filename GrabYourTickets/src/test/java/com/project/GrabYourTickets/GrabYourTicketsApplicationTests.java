package com.project.GrabYourTickets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.GrabYourTickets.Controllers.UserController;
import com.project.GrabYourTickets.Entity.User;
import com.project.GrabYourTickets.Security.SecurityConfig;
import com.project.GrabYourTickets.Services.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = UserController.class)
class GrabYourTicketsApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@InjectMocks
	private UserController userController;

	@Mock
	private UserService userService;

	@MockBean
	private SecurityConfig securityConfig;

	// user controller test
	// Test for registerUser method
	@Test
	void testRegisterUser() throws Exception {
		// Create a sample user
		User user = new User();
		user.setUsername("testUser");
		user.setEmail("test@example.com");
		user.setPassword("password");

		// Mock the userService.registerUser method
		when(userService.registerUser(any(User.class))).thenReturn(user);

		// Authenticate as admin
		authenticateAsAdmin();

		// Call the registerUser method in the userController using mockMvc
		mockMvc.perform(post("/api/users/register")
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(user))
						.with(csrf())) // Include CSRF token
				.andExpect(status().isOk());

		// Verify that the userService.registerUser method was called with the correct user
		verify(userService, times(1)).registerUser(eq(user));
	}

	// Helper method to authenticate as admin
	private void authenticateAsAdmin() {
		Authentication authentication = new UsernamePasswordAuthenticationToken("admin", "admin");
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	// Helper method to convert an object to JSON string
	private static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
