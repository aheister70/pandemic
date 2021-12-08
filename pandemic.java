/* ************************************************************************** */
/*                                                                            */
/*                                                        ::::::::            */
/*   pandemic.java                                      :+:    :+:            */
/*                                                     +:+                    */
/*   By: aheister <aheister@student.codam.nl>         +#+                     */
/*                                                   +#+                      */
/*   Created: 2021/12/04 12:56:39 by aheister      #+#    #+#                 */
/*   Updated: 2021/12/08 12:20:54 by aheister      ########   odam.nl         */
/*                                                                            */
/* ************************************************************************** */

// TODOiftime
//	- extend the errors with a check on valid input (type, amount, doubles etc)
//  - learn about private and public and make the program safe

import java.io.IOException;

public class pandemic {
	public static void main(String[] args) {
		if (args.length < 5){
			System.out.print("Wrong format of input");
			System.exit(1);
		}
		//parse input to integers
		rules.mapSize = Integer.parseInt(args[0]);
		rules.iterations = Integer.parseInt(args[1]);
		rules.thresInfect = Integer.parseInt(args[2]);
		rules.thresRecover = Integer.parseInt(args[3]);
		String coord = args[4];
		// clean up of input
		coord = coord.replaceAll("\\p{Ps}", "").replaceAll(">,<", " ").replaceAll("[<]", "").replaceAll("[>]", "").replaceAll("\\p{Pe}", "");
		// split coordinates into substrings by split on space
		String[] coordSplit = coord.split(" ", 0);
		int amount = coordSplit.length;
		int[][] coordinates = new int[amount][2];
		// parse input to integers and store in 2D array
		for (int i = 0; i < coordSplit.length; i++){
			String[] group = coordSplit[i].split(",", 0);
			for (int j = 0; j < group.length; j++){
				coordinates[i][j] = Integer.parseInt(group[j]);
			}
		}
		// fill initial grid with infected persons on given coordinates
		rules.grid = new int[rules.mapSize][rules.mapSize];
		for (int x = 0; x < amount; x++){
			for (int i = 0; i < rules.mapSize; i++){
				for (int j = 0; j < rules.mapSize; j++){
					if (i + 1 == coordinates[x][1] && j + 1 == coordinates[x][0])
						rules.grid[i][j] = 1;
					else if (rules.grid[i][j] != 1)
						rules.grid[i][j] = 0;
				}
			}
		}
		printMap.printMap();
		// start iterations: each return of the user prints the grid of one iteration
		for (int i = 0; i < rules.iterations; i++){
			System.out.println("Press return for iteration " + (i + 1) + " of " + rules.iterations);
			try {
				System.in.read();
				iterateGrid.iterateGrid();
				printMap.printMap();
			}
			catch (IOException e){
				System.out.println("Error reading from user");
			}
		}
	}
}