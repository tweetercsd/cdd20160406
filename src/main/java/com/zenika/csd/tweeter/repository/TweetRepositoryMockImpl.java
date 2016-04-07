package com.zenika.csd.tweeter.repository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.zenika.csd.tweeter.domain.Tweet;
import com.zenika.csd.tweeter.domain.User;

/**
 * Spring Data JPA repository for the Tweet entity.
 */
@Repository
public class TweetRepositoryMockImpl implements TweetRepository {

    @Inject
    private UserRepository userRepository;
	
	
	@Override
	public List<Tweet> findAll() {

		ArrayList<Tweet> listTweet = new ArrayList<Tweet>();
		listTweet.add(genTweet(1));
		listTweet.add(genTweet(2));
		listTweet.add(genTweet(3));
		listTweet.add(genTweet(4));
		listTweet.add(genTweet(5));
		listTweet.add(genTweet(6));
		listTweet.add(genTweet(7));
		
		return listTweet;
	}

	@Override
	public List<Tweet> findAll(Sort sort) {
		ArrayList<Tweet> listTweet = new ArrayList<Tweet>();
		listTweet.add(genTweet(1));
		listTweet.add(genTweet(2));
		listTweet.add(genTweet(3));
		listTweet.add(genTweet(4));
		listTweet.add(genTweet(5));
		listTweet.add(genTweet(6));
		listTweet.add(genTweet(7));
		
		return listTweet;
	}

	@Override
	public List<Tweet> findAll(Iterable<Long> ids) {
		ArrayList<Tweet> listTweet = new ArrayList<Tweet>();
		listTweet.add(genTweet(1));
		listTweet.add(genTweet(2));
		listTweet.add(genTweet(3));
		listTweet.add(genTweet(4));
		listTweet.add(genTweet(5));
		listTweet.add(genTweet(6));
		listTweet.add(genTweet(7));
		
		return listTweet;
	}

	@Override
	public <S extends Tweet> List<S> save(Iterable<S> entities) {

		return (List<S>) entities;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Tweet> S saveAndFlush(S entity) {

		return entity;
	}

	@Override
	public void deleteInBatch(Iterable<Tweet> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tweet getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Tweet> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Tweet> S save(S entity) {
		return (entity);
	}

	@Override
	public Tweet findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Tweet entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Tweet> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Tweet> findByUserIsCurrentUser() {
		// TODO Auto-generated method stub
		return null;
	}


	public Tweet genTweet(int i){
		Tweet t = new Tweet();
		t.setId(new Long(1));
		t.setMesssage("Message tweet"+ i);
    	User admin = userRepository.findOneByLogin("admin").get();
		t.setUser(admin);
		
		return t;
	}
	
}
