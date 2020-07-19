package project.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import project.cinema.model.Cinema;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema,Long> {
	@Modifying
	@Query("update Cinema set name = :name, address=:address,phone_number=:phone_number,email=:email WHERE id = :Id")
    void updateCinema(@Param("Id") Long id, @Param("name") String name,@Param("address") String address,@Param("phone_number") String phone_number,@Param("email") String email);
}
