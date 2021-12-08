/* ************************************************************************** */
/*                                                                            */
/*                                                        ::::::::            */
/*   checkNeighbours.java                               :+:    :+:            */
/*                                                     +:+                    */
/*   By: aheister <aheister@student.codam.nl>         +#+                     */
/*                                                   +#+                      */
/*   Created: 2021/12/08 06:30:12 by aheister      #+#    #+#                 */
/*   Updated: 2021/12/08 10:49:22 by aheister      ########   odam.nl         */
/*                                                                            */
/* ************************************************************************** */

public class checkNeighbours {
	public static int checkNeighbours(int x, int y){
		int[][] gridIterated = new int[rules.mapSize][rules.mapSize];
		int infectedNeighbours = 0;					
		for (int i = (x - 1) ; i < (x + 2); i++){
			for (int j = (y - 1); j < (y + 2); j++){
				if ((i >= 0 && j >= 0) && (i < rules.mapSize && j < rules.mapSize)){
					if (rules.grid[i][j] == 1){
						infectedNeighbours++;
						if (i == x && j == y)
							infectedNeighbours--;
					}
				}
			}
		}
		return(infectedNeighbours);
	}
}
