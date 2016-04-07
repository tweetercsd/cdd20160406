package com.zenika.csd.tweeter.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.zenika.csd.tweeter.TweeterApp;
import com.zenika.csd.tweeter.domain.PersistentToken;
import com.zenika.csd.tweeter.domain.User;
import com.zenika.csd.tweeter.repository.PersistentTokenRepository;
import com.zenika.csd.tweeter.repository.TweetRepository;
import com.zenika.csd.tweeter.service.util.RandomUtil;

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
public class TweetTuTest {

    @Inject
    private PersistentTokenRepository persistentTokenRepository;

    @Inject
    private TweetRepository tweetRepository;

    @Inject
    private TweetService tweetService;

    @Test
    public void testSelectMessage() {

    	assertThat(!tweetRepository.findByUserIsCurrentUser().isEmpty() );
    	

    }

    @Test
    public void saveMessage() {

    	assertThat(!tweetRepository.findByUserIsCurrentUser().isEmpty() );
    	

    }

}
