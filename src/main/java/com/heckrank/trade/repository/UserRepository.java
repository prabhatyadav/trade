package com.heckrank.trade.repository;

import org.springframework.data.repository.CrudRepository;

import com.heckrank.trade.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
