
public class Board {
	
	Cell[][] grid = new Cell[6][7];
	
	int[] colHeight = new int[7];
	
	public Board() {
		grid = new Cell[6][7];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				grid[i][j] = new Cell();
			}
		}
	}
	
	public void resetBoard() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				grid[i][j] = new Cell();
			}
		}
	}
	
	
	public boolean putPieceColumn(Value val, int colNum) {
		if (colHeight[colNum] == 6) {
			return false;
		} else {
			int rowCount = 5 - colHeight[colNum];
			
			grid[rowCount][colNum].setVal(val);
			colHeight[colNum] = colHeight[colNum] + 1;
			return true;
		}
	}
	
	public boolean checkWin(Value val, int colNum) {
		int row = 6 - colHeight[colNum];
		
		
		return (checkCrossBRTL(val, row, colNum) || checkCrossBLTR(val, row, colNum) || checkHor(val, row, colNum) || checkVert(val, row, colNum));
		
		
	}
	
	public boolean checkCrossBRTL(Value val, int row, int colNum) {
		int totalConsec = 1 + checkCrossBR(val, row + 1, colNum + 1) + checkCrossTL(val, row-1, colNum-1);
		return ((totalConsec >= 4) ? true : false);
	}
	
	public int checkCrossBR(Value val, int row, int colNum) {
		if ((row > 5) || (colNum > 6)) {
			return 0;
		}
		if (grid[row][colNum].getVal() != val) {
			return 0;
		} else {
			return 1 + checkCrossBR(val, row+1, colNum+1);
		}
	}
	
	public int checkCrossTL(Value val, int row, int colNum) {
		if ((row < 0) || (colNum < 0)) {
			return 0;
		}
		if (grid[row][colNum].getVal() != val) {
			return 0;
		} else {
			return 1 + checkCrossTL(val, row-1, colNum-1);
		}
		
	}
	public void displayBoard() {
		
		for (int i = 0; i < grid.length; i ++) {
			for (int j = 0; j < grid[0].length; j++) {
				Cell temp = grid[i][j];
				switch (temp.getVal()) {
					case X: 
						System.out.print(" " + "[X]");
						break;
					case O:
						System.out.print(" " + "[O]");
						break;
					default:
						System.out.print(" " + "[ ]");
						break;
				}
			}
			System.out.println();
		}
		
	}
	
	
	// from bottom left to top right
	public boolean checkCrossBLTR(Value val, int row, int colNum) {
		int totalConsec = 1 + checkCrossBL(val, row+1, colNum-1) + checkCrossTR(val, row-1, colNum+1);
		
		return ((totalConsec >= 4) ? true : false);
	}
	
	public int checkCrossBL(Value val, int row, int colNum) {
		if ((row > 5) || (colNum < 0)) {
			return 0;
		}
		if (grid[row][colNum].getVal() != val) {
			return 0;
		} else {
			return 1 + checkCrossBL(val, row+1, colNum-1);
		}
	}
	
	public int checkCrossTR(Value val, int row, int colNum) {
		if ((row < 0) || (colNum > 6)) {
			return 0;
		}
		if (grid[row][colNum].getVal() != val) {
			return 0;
		} else {
			return 1 + checkCrossTR(val, row-1, colNum+1);
		}
	}
	
	public boolean checkVert(Value val, int row, int colNum) {
		int totalConsec = checkVerU(val, row - 1, colNum) + checkVerD(val, row + 1, colNum) + 1;
		return ((totalConsec >= 4) ? true : false);
	}
	public int checkVerU(Value val, int row, int colNum) {
		if (row < 0) {
			return 0;
		}
		if (grid[row][colNum].getVal() != val) {
			return 0;
		} else {
			return 1 + checkVerU(val, row - 1, colNum);
		}
	}
	public int checkVerD(Value val, int row, int colNum) {
		if (row > 5) {
			return 0;
		}
		if (grid[row][colNum].getVal() != val) {
			return 0;
		} else {
			return 1 + checkVerD(val, row + 1, colNum);
		}
	}
	
	
	public boolean checkHor( Value val, int row, int colNum) {
		int totalConsec = checkHorL(val, row, colNum-1) + checkHorR(val, row, colNum+1) + 1;
		return ((totalConsec >= 4) ? true : false);
	
	}
	public int checkHorL(Value val, int row, int colNum) {
		if (colNum < 0) {
			return 0;
		}
		if (grid[row][colNum].getVal() != val) {
			return 0;
		} else {
			return 1 + checkHorL(val, row, colNum-1);
		}
	}
	public int checkHorR(Value val, int row, int colNum) {
		if (colNum > 6) {
			return 0;
		}
		if (grid[row][colNum].getVal() != val) {
			return 0;
		} else {
			return 1 + checkHorR(val, row, colNum+1);
		}
	}

}
