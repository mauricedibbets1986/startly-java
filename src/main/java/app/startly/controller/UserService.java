package app.startly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.startly.domain.User;

@Service
@Transactional
public class UserService {
	@Autowired
	UserRepository<User> userRepository;
	
}
