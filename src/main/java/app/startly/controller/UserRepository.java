package app.startly.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.startly.domain.User;

@Repository
public interface UserRepository <T extends User> extends CrudRepository<T, Long>{

}
