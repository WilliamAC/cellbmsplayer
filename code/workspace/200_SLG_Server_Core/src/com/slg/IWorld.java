package com.slg;

public interface IWorld {
	public IPlayer getPlayer(int uid);
	
	public IPlayer getPlayer(String name);
	
	public int addPlayer(IPlayer newplayer);
}
