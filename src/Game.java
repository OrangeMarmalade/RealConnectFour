import java.util.Scanner;

public class Game {
	Scanner sc = new Scanner(System.in).useDelimiter("\\s");
	boolean isP1Turn = true;
	Board gameBoard;
	
	public void play() {
		Value val;
		
		while (true) {
			val = (isP1Turn ? (Value.X) : (Value.O));
			gameBoard.displayBoard();
			
			System.out.println("Player " + (isP1Turn == true ? 1 : 2) + "'s Turn to Play:" );
			int col;
			while (true){
				try {
					System.out.println("Enter column number (1 - 7)");
					col = sc.nextInt() - 1;
					if (!gameBoard.putPieceColumn(val, col)) {
						continue;
					}
					break;
				} catch (Exception e) {
					System.out.println("Input correct Number!");
					sc.next();
				}
			}
			
			if (gameBoard.checkWin(val,  col)) {
				gameBoard.displayBoard();
				System.out.println("Player " + (isP1Turn == true ? 1 : 2) + " Win!" );
				break;
			}
			isP1Turn = !isP1Turn;
			
		}
	}
	
	public Game() {
		gameBoard = new Board();
	}
	public static void main (String[] args) {
		
		Game playGame = new Game();
		playGame.play();
	}

}
