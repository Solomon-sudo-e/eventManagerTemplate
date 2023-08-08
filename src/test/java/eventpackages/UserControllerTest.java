package eventpackages;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.reactive.server.WebTestClient;

import eventpackages.events.Entity.UserData;
import eventpackages.events.controller.UserController;
import eventpackages.events.service.UserService;

@WebFluxTest(controllers = {UserController.class})
class UserControllerTest {

	@MockBean
	UserService service;
	
	
	private UserData user1;

	private UserData user2;
	
	@BeforeEach
	void setUp(ApplicationContext context) {
		user1 = new UserData ("Manny", "3213450321", "Miami",
				"Florida", "manny.miami@gmail.com", "mascots0");
		
		user2 = new UserData("marco", "3243234565", "St augistine",
				"florida", "marco.flo@gmail.com", "taytay02");
		
		Mockito.when(service.getUser((long) 1).thenReturn(user1));
		
	}
	
	@AfterEach
	void tearDown() {
		
	}
	
	@Test
	void getCurrentUserTest(@Autowired WebTestClient client) {
		final UserData userController = client.get()
				.uri("/user/1")
				.exchange()
				.expectStatus().isOk()
				.expectBody(UserData.class)
				.returnResult()
				.getResponseBody();
		
		assertEquals(user1, userController);
	}

}
