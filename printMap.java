/* ************************************************************************** */
/*                                                                            */
/*                                                        ::::::::            */
/*   printMap.java                                      :+:    :+:            */
/*                                                     +:+                    */
/*   By: aheister <aheister@student.codam.nl>         +#+                     */
/*                                                   +#+                      */
/*   Created: 2021/12/07 15:26:54 by aheister      #+#    #+#                 */
/*   Updated: 2021/12/08 11:53:38 by aheister      ########   odam.nl         */
/*                                                                            */
/* ************************************************************************** */

public class printMap {
	public static final String REDB = "\033[41m";
	public static final String GRNB = "\033[42m";
	public static final String RESET = "\033[0m";
	public static final String CLEAR = "\033[2J";
	public static void printMap(){
		System.out.print(CLEAR);
		for (int i = 0; i < rules.mapSize; i++){
			for (int j = 0; j < rules.mapSize; j++){
				if (rules.grid[i][j] == 0)
					System.out.print(GRNB + "  " + RESET);
				else if (rules.grid[i][j] == 1)
					System.out.print(REDB + "  " + RESET);
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	} 
}
