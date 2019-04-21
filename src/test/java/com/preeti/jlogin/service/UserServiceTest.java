package com.preeti.jlogin.service;

import com.preeti.jlogin.model.User;
import com.preeti.jlogin.repository.RoleRepository;
import com.preeti.jlogin.repository.UserRepository;
import org.mockito.Mock;


public class UserServiceTest {
    @Mock
    private UserRepository mockUserRepository;
    @Mock
    private RoleRepository mockRoleRepository;

    private UserService userServiceUnderTest;
    private User user;

/*    @Before
    public void setUp() {
        initMocks(this);
        userServiceUnderTest = new UserService(mockUserRepository,
                mockRoleRepository);
        user = new User();
        user.setEmail("");

        Mockito.when(mockUserRepository.save(any()))
                .thenReturn(user);
        Mockito.when(mockUserRepository.findByEmail(anyString()))
                .thenReturn(user);
    }

    @Test
    public void testFindUserByEmail() {
        // Setup
        final String email = "test@test.com";

        // Run the test
        final User result = userServiceUnderTest.findUserByEmail(email);

        // Verify the results
        assertEquals(email, result.getEmail());
    }


    @Test
    public void testSaveUser() {
        // Setup
        final String email = "test@test.com";

        // Run the test
        User result = userServiceUnderTest.saveUser(User.builder().build());

        // Verify the results
        assertEquals(email, result.getEmail());
    }
*/

}
