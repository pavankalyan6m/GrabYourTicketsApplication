package com.project.GrabYourTickets.Repositories;

import com.project.GrabYourTickets.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{
}
