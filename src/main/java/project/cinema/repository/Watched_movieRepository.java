package project.cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import project.cinema.model.Watched_movie;
@Repository
public interface Watched_movieRepository extends JpaRepository<Watched_movie,Long>{
	List<Watched_movie> findByMovieId(Long id);
	@Modifying
	@Query("update Watched_movie set rating = :rating WHERE id = :Id")
    void setRating(@Param("Id") Long id, @Param("rating") long rating);
}
