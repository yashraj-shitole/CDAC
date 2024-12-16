package com.sunbeam.iplteam.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.iplteam.pojos.IPLTeam;



public interface TeamDao extends JpaRepository<IPLTeam, Long> {

	

}
