package problems1to50;

import java.util.HashSet;
import java.util.Set;

public class SudokuSolver37 {
	char[][] boardCopy = new char[9][9];
	boolean isSolved = false;
    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
        copyArray(boardCopy, board);
        /*for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }*/
        
    }
    
    public void helper(char[][] board, int row, int col) {
    	System.out.println("row: "+row+", col: "+col);//+", dontModify: "+dontModify[row][col]);
        if(isSolved) {
        	copyArray(board, boardCopy);
        	System.out.println("THE END");
            return;
        }
        
        if(row == 9) {
        	copyArray(board, boardCopy);
            isSolved = true;
            return;
        } else {
            //for every cell,
            if(board[row][col] != '.') {
                if(col == 8) {
                    helper(board, row+1, 0);
                } else {
                    helper(board, row, col+1); 
                }
			} else {
				for (int i = 49; i <= 57 && !isSolved; i++) {
					// choose one int from candidate and verify if its valid
//					System.out.println("Inserting: " + ((char) i) + " at row " + row + ", col " + col);
					board[row][col] = ((char) i);
					// if its valid, proceed.
					if ((isValidRow(board, row) && isValidCol(board, col) && isValidBox(board, row, col))) {
//						System.out.println("All three checks ok.");
						if (col == 8) {
							helper(board, row + 1, 0);
						} else {
							helper(board, row, col + 1);
						}
					}
//					System.out.println("Atleast one condition failed.");
				}
				if(!isSolved) {
					board[row][col] = '.';
				}
				
			}
        }
            
    }
    
    private void copyArray(char[][] src, char[][] tar) {
		// TODO Auto-generated method stub
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				tar[i][j] = src[i][j];
			}
		}
	}

	private boolean isValidBox(char[][] board, int row, int col) {
        
        int sI = (row/3)*3;
        int sJ = (col/3)*3;
        Set<Character> set = new HashSet<Character>();
        boolean res = true;
        for(int i = 0; i<3; i++) {
        	if(!res) {
        		break;
        	}
            for(int j=0; j<3; j++) {
                if((int)board[sI+i][sJ+j] == 46) {
                    continue;
                }
                if(set.contains(board[sI+i][sJ+j])) {
                    res = false;
                    break;
                }
                set.add(board[sI+i][sJ+j]);
            }
        }
        //System.out.println("isValidBox: row: "+row+", col: "+col+" is: "+res);
        return res;
    }
    
    private boolean isValidCol(char[][] board, int colNum) {
        Set<Character> set = new HashSet<Character>();
        boolean res = true;
        for(int i = 0; i<9; i++) {
            if((int)board[i][colNum] == 46) {
                continue;
            }
            if(set.contains(board[i][colNum])) {
                res = false;
                break;
            }
            set.add(board[i][colNum]);
        }
        //System.out.println("isValidCol: col: "+colNum+" is: "+res);
        return res;
    }
    
    private boolean isValidRow(char[][] board, int rowNum) {
        Set<Character> set = new HashSet<Character>();
        boolean res = true;
        for(int i = 0; i<9; i++) {
            if((int)board[rowNum][i] == 46) {
                continue;
            }
            if(set.contains(board[rowNum][i])) {
                res = false;
                break;
            }
            set.add(board[rowNum][i]);
        }
        //System.out.println("isValidRow: row: "+rowNum+" is: "+res);
        return res;
    }
}
