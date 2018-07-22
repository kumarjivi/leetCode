package problems151to200;

/***
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
 * islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of
 * the grid are all surrounded by water.
 * 
 * @author jivi
 *
 */
public class NumberOfIslands200 {

	public static void main(String[] args) {
		char[][] arr = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '0', '0', '0' } };
		System.out.println(numIslands(arr));
	}

	public static int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1' && !visited[i][j]) {
					helper(grid, visited, i, j);
					count++;
				}
			}
		}
		return count;
	}

	private static void helper(char[][] grid, boolean[][] visited, int i, int j) {
		if (!visited[i][j]) {
			visited[i][j] = true;
			// check top
			if (i > 0 && grid[i - 1][j] == '1') {
				helper(grid, visited, i - 1, j);
			}

			// check left
			if (j > 0 && grid[i][j - 1] == '1') {
				helper(grid, visited, i, j - 1);
			}

			// check right
			if (j < grid[0].length - 1 && grid[i][j + 1] == '1') {
				helper(grid, visited, i, j + 1);
			}

			// check bottom
			if (i < grid.length - 1 && grid[i + 1][j] == '1') {
				helper(grid, visited, i + 1, j);
			}
		}
	}

}
