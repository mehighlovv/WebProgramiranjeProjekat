package project.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import project.cinema.model.Movie;
@Repository
public interface MovieRepository extends JpaRepository<Movie,Long>{
	@Modifying
	@Query("update Movie set rating = :rating WHERE id = :movieId")
    void setRating(@Param("movieId") Long id, @Param("rating") double rating);
}
