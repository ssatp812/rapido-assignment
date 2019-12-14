/**
 * 
 */
package com.rapido.planets.main;

import java.util.Scanner;

import com.rapido.planets.execution.WarExecutor;
import com.rapido.plantes.army.PlanetArmy;

public class PlanetWarMain {
	
	private static final PlanetArmy kingShan = new PlanetArmy(100, 50, 10, 5);
	private static final PlanetArmy alFalcone = new PlanetArmy(300, 200, 40, 20);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		System.out.println("****** War begins ******");
		System.out.println("King Shan Army details : "+kingShan.toString());
		System.out.println("AlFalcone Army details : "+alFalcone.toString());
		PlanetArmy alFalconeDeployed = deployAlFalconeArmy();
		boolean flag = new WarExecutor().warExecutor(kingShan, alFalconeDeployed);
		if(flag) {
			System.out.println("King Shan won the war !!!!");
		} else {
			System.out.println("King Shan lost the war !!!!");
		}
		System.out.println("****** War ended ******");

	}

	private static PlanetArmy deployAlFalconeArmy() {
		Scanner sc = null;
		try {
		sc = new Scanner(System.in);
		System.out.println("Deploy army for AlFalcone : \n");
		// Get horse
		System.out.println("Horse : ");
		int horse = sc.nextInt();
		// Get elephant
		System.out.println("Elephant : ");
		int elephant = sc.nextInt();
		// Get Tanks
		System.out.println("AT : ");
		int at = sc.nextInt();
		// Get horse
		System.out.println("SG : ");
		int sg = sc.nextInt();
		
		
		PlanetArmy alFalconeDeployed = new PlanetArmy(horse, elephant, at, sg);
		// Invalid input. Try again.
		if(!validateFalconeDeploy(alFalconeDeployed)) {
			System.out.println("Al Falcone can't deploy all the army.");
			return null;
		}
		System.out.println("AlFalcone deployed army : "+alFalconeDeployed.toString());
		return alFalconeDeployed;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if(sc != null)
				sc.close();
		}
	}

	private static boolean validateFalconeDeploy(PlanetArmy alFalconeDeployed) {
		return (alFalconeDeployed.getElephants() < alFalcone.getElephants()
				&& alFalconeDeployed.getHorses() < alFalcone.getHorses()
				&& alFalconeDeployed.getTanks() < alFalcone.getTanks()
				&& alFalconeDeployed.getGuns() < alFalcone.getGuns());
	}

}
