/* ************************************************************************** */
/*                                                                            */
/*                                                        ::::::::            */
/*   iterateGrid.java                                   :+:    :+:            */
/*                                                     +:+                    */
/*   By: aheister <aheister@student.codam.nl>         +#+                     */
/*                                                   +#+                      */
/*   Created: 2021/12/07 15:58:44 by aheister      #+#    #+#                 */
/*   Updated: 2021/12/08 11:35:29 by aheister      ########   odam.nl         */
/*                                                                            */
/* ************************************************************************** */

public class iterateGrid {
	public static void iterateGrid(){
		int	infectedNeighbours = 0;
		int	currentState = 0;
		int[][] gridIterated = new int[rules.mapSize][rules.mapSize];
		for (int i = 0; i < rules.mapSize; i++){
			for (int j = 0; j < rules.mapSize; j++){
				currentState = rules.grid[i][j];
				infectedNeighbours = checkNeighbours.checkNeighbours(i, j);
				if (currentState == 0 && infectedNeighbours >= rules.thresInfect)
					gridIterated[i][j] = 1;
				else if (currentState == 1 && infectedNeighbours >= rules.thresRecover)
					gridIterated[i][j] = 0;
				else
					gridIterated[i][j] = currentState;
			}
		}
		for (int i = 0; i < rules.mapSize; i++){
			for (int j = 0; j < rules.mapSize; j++){
				rules.grid[i][j] = gridIterated[i][j];
			}
		}
	}
}