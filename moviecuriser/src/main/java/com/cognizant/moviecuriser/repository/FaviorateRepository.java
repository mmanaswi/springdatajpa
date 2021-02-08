package com.cognizant.moviecuriser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.moviecuriser.model.Favorities;


/**
 * 
 * @author Danish
 *
 */
@Repository
public interface FaviorateRepository extends JpaRepository<Favorities, Integer>{

	/**
	 * Gets list of movie Ids present in faviorates table
	 * @param user_id
	 * @return list of ids
	 */
	@Query(nativeQuery = true, value = "select m.id from faviorates f join movies m on f.movie_id=m.id and f.user_id=:id")
	public List<Integer> getFaviorateMovies(@Param("id")Integer user_id);
	
	
	/**
	 * Deletes one movie item on clicking delete option
	 * @param userId
	 * @param movieId
	 * @return rows affected
	 */
	@Modifying
	@Transactional
	@Query(nativeQuery = true,value = "delete from faviorates where user_id =:userId and movie_id=:movieId limit 1")
	public Integer deleteFromFaviorate(@Param("userId")Integer userId,@Param("movieId")Integer movieId);
	
}
