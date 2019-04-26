package ceo.springboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import ceo.springboot.domain.User;
@Component
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByusername(String username);
	List<User> findAll();
	User findBylid(Long id);
	@Modifying
	@Query(value="update user set username =: name where lid =: lid",nativeQuery =true)
	void updateById(@Param("name") String name,@Param("id") String lid);
	
}
