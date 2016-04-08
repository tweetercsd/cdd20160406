package com.zenika.csd.tweeter.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.zenika.csd.tweeter.TweeterApp;
import com.zenika.csd.tweeter.domain.User;

/**
 * Test class for the UserResource REST controller.
 *
 * @see UserService
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TweeterApp.class)
@WebAppConfiguration
@IntegrationTest
@Transactional
public class UserServiceTuTest {

    @Mock
    private UserService mockUserService;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        
        User user1 = new User();
        user1.setLogin("user1");
        User user2 = new User();
        user2.setLogin("user2");
        List<User> followers = new ArrayList<User>();
        followers.add(user1);
        followers.add(user2);
        
        doReturn(followers).when(mockUserService).getFollowers(anyString());
    }

       

    @Test
    public void testGetFollowers() {
    	List<User> followers = mockUserService.getFollowers("user");
    	assertThat(followers.size()).isEqualTo(2);    	
    }
    
}
