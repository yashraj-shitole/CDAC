package com.sunbeam.daos;

import java.util.*;

import com.sunbeam.entities.Movies;



public interface MoviesDao extends AutoCloseable{

	//TODO movies dao
	
	
	ArrayList<Movies> displayAllMovies() throws Exception; 
	
	
	
	
}
