package com.rapido.plantes.army;

public class PlanetArmy {
	
	private int horses;
	private int elephants;
	private int tanks;
	private int guns;
	
	public int getHorses() {
		return horses;
	}
	public void setHorses(int horses) {
		this.horses = horses;
	}
	public int getElephants() {
		return elephants;
	}
	public void setElephants(int elephants) {
		this.elephants = elephants;
	}
	public int getTanks() {
		return tanks;
	}
	public void setTanks(int tanks) {
		this.tanks = tanks;
	}
	public int getGuns() {
		return guns;
	}
	public void setGuns(int guns) {
		this.guns = guns;
	}
	
	public PlanetArmy(int horses, int elephants, int tanks, int guns) {
		super();
		this.horses = horses;
		this.elephants = elephants;
		this.tanks = tanks;
		this.guns = guns;
	}
	@Override
	public String toString() {
		return "PlanetArmy [horses=" + horses + ", elephants=" + elephants + ", tanks=" + tanks + ", guns="
				+ guns + "]";
	}
	

}
