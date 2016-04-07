package com.zenika.csd.tweeter.service;

import com.zenika.csd.tweeter.TweeterApp;
import com.zenika.csd.tweeter.domain.Tweet;
import com.zenika.csd.tweeter.domain.User;
import com.zenika.csd.tweeter.repository.PersistentTokenRepository;
import com.zenika.csd.tweeter.repository.TweetRepository;
import com.zenika.csd.tweeter.repository.UserRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.inject.Inject;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

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
public class TweetServiceIntTest {

    @Inject
    private PersistentTokenRepository persistentTokenRepository;

    @Inject
    private TweetRepository tweeterRepository;
    
    @Inject
    private UserRepository userRepository;

    @Inject
    private TweetService tweetService;
    
    private Tweet tweet;
    
    @Before
    public void generateTweet() {
    	User admin = userRepository.findOneByLogin("admin").get();
    	tweet = new Tweet();
        tweet.setUser(admin);
        tweet.setMesssage("Message de test");
    }

    @Test
    public void testCreateTweet() {
    	Integer tweetSizeBeforeCreate = tweetService.findAll().size();
    	tweetService.save(tweet);  	
    	
    	List<Tweet> tweetList = tweetService.findAll();
    	Integer tweetSizeAfterCreate = tweetList.size();
    	
    	Tweet tweetCreated = tweetList.get(tweetSizeAfterCreate - 1);
    	   	
    	assertThat(tweetSizeAfterCreate).isEqualTo(tweetSizeBeforeCreate + 1);
    	assertThat(tweetCreated.getUser()).isEqualTo(tweet.getUser());
    	assertThat(tweetCreated.getMesssage()).isEqualTo(tweet.getMesssage());
    }

  

}
