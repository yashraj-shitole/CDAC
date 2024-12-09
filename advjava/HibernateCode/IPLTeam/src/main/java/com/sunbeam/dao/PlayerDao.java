package com.sunbeam.dao;

import com.sunbeam.entities.Player;
import java.util.*;

public interface PlayerDao {
	
	String addPlayer(Player player, Long teamId);
	List<Player> getAllPlayers();

}
