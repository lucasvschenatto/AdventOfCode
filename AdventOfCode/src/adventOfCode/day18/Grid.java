package adventOfCode.day18;

public class Grid {
	protected int[][] light;

	public Grid(int x, int y) {
		light = new int[x][y];
	}

	public void turnOn(int x, int y) {
		light[x][y] = 1;
	}

	public void turnOff(int x, int y) {
		light[x][y] = 0;
	}

	public void toogle(int x, int y) {
		light[x][y] = (light[x][y] == 0) ? 1 : 0;
	}

	public int countLightsOn() {
		int count = 0;
		for (int i = 0; i < light.length; i++)
			for (int j = 0; j < light[i].length; j++)
				count = count + light[i][j];
		return count;
	}
}