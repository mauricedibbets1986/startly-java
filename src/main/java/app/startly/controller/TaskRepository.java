package app.startly.controller;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import app.startly.domain.*;

public interface TaskRepository extends CrudRepository<Task, Long> {
	@Query(value = "SELECT * FROM 'task' WHERE userId = ?1", nativeQuery = true)
	Iterable <Task> findByUserId(long id);
}
