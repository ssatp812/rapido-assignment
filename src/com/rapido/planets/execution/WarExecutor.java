package com.rapido.planets.execution;

import com.rapido.plantes.army.PlanetArmy;

public class WarExecutor {

	public boolean warExecutor(PlanetArmy kingShan, PlanetArmy alFalconeDeployed) {
		
		if(alFalconeDeployed == null) {
			System.out.println("No army deployed by AlFalcone.");
			return true;
		}

		PlanetArmy needToDeploy = new PlanetArmy(alFalconeDeployed.getHorses() / 2,
				alFalconeDeployed.getElephants() / 2, alFalconeDeployed.getTanks() / 2,
				alFalconeDeployed.getGuns() / 2);

		PlanetArmy kingShanBalance = findKingShanBalance(kingShan, needToDeploy);

		boolean flag = checkWarStatus(kingShanBalance);
		if (flag) {
			return flag;
		}

		deployAdjustMents(kingShanBalance);
		flag = checkWarStatus(kingShanBalance);
		return flag;

	}

	private void deployAdjustMents(PlanetArmy kingShanBalance) {
		int horses = kingShanBalance.getHorses();
		int elephants = kingShanBalance.getElephants();
		int tanks = kingShanBalance.getTanks();
		int guns = kingShanBalance.getGuns();

		if (guns < 0) {
			int tanksNeeded = -(guns * 2);
			if (tanks >= tanksNeeded) {
				tanks -= tanksNeeded;
			}
		}

		if (tanks < 0) {
			int eleNeeded = -(tanks * 2);
			if (elephants >= eleNeeded) {
				elephants -= eleNeeded;
			} else if (elephants > 0) {
				tanks += elephants / 2;
				int gunsNeeded = -(tanks / 2 + tanks % 2);
				guns -= gunsNeeded;
				tanks = 0;
			}
		}

		if (elephants < 0) {
			int horsesNeeded = -(elephants * 2);
			if (horses >= horsesNeeded) {
				horses -= horsesNeeded;
			} else if (horses > 0) {
				elephants += horses / 2;
				int tanksNeeded = -(elephants / 2 + elephants % 2);
				tanks -= tanksNeeded;
				elephants = 0;
			}
		}

		kingShanBalance.setHorses(horses);
		kingShanBalance.setElephants(elephants);
		kingShanBalance.setTanks(tanks);
		kingShanBalance.setGuns(guns);

	}

	private boolean checkWarStatus(PlanetArmy balance) {
		return (balance.getHorses() >= 0 && balance.getElephants() >= 0 && balance.getTanks() >= 0
				&& balance.getGuns() >= 0);
	}

	private PlanetArmy findKingShanBalance(PlanetArmy kingShan, PlanetArmy needToDeploy) {
		int horse = kingShan.getHorses() - needToDeploy.getHorses();
		int elephant = kingShan.getElephants() - needToDeploy.getElephants();
		int tanks = kingShan.getTanks() - needToDeploy.getTanks();
		int guns = kingShan.getGuns() - needToDeploy.getGuns();

		return new PlanetArmy(horse, elephant, tanks, guns);
	}

}
