package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Utility;



@Repository
public interface UtilityRepository extends JpaRepository<Utility, Long>{
	/*@Query("SELECT SUM(amount) FROM medicalcenter.utility;")
	*/
}

