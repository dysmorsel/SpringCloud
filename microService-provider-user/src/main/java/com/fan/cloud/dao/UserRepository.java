package com.fan.cloud.dao;

import com.fan.cloud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author School-PC
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long>{
}
