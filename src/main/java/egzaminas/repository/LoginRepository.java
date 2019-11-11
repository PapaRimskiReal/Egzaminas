package egzaminas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import egzaminas.domain.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer>{

	
}
