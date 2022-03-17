package board;

public class Piece {
	
	// é protected pois ela não deve ser visível na camada de xadrez
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
