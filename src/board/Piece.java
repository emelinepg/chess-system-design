package board;

public class Piece {
	
	// � protected pois ela n�o deve ser vis�vel na camada de xadrez
	protected Position position; 
	
	private Board board;
	
	public Piece() {
	}

	public Piece(Board board) {
		this.board = board;
	}

	protected Board getBoard() {
		return board;
	}
}
