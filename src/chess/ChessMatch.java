package chess;

import board.Board;
import board.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {

	private Board board;
	
	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
	}
	
	//a aplica��o n�o precisa acessar as pe�as do tipo Piece[][] da camada 
	//de tabuleiro, e sim apenas a camada de xadrez
	public ChessPiece[][] getPieces() {
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		//percorrer as pe�as do tabuleiro
		//pra cada pe�a do tabuleiro, fazer um downcasting pra ChessPiece
		for (int i=0; i<board.getRows(); i++) {
			for (int j=0; j<board.getColumns(); j++) {
				//pra cada posi��o ij do tabuleiro, a mat[i][j] vai receber
				//o board.piece(i,j), fazendo downcasting pra ChessPiece
				//pra interpretar como uma pe�a de xadrez
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return mat;
	}
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition (column, row).toPosition());
	}
	
	private void initialSetup() {
		placeNewPiece('b', 6, new Rook(board, Color.WHITE));
		placeNewPiece('e', 8, new King(board, Color.BLACK));
		placeNewPiece('e', 1, new King(board, Color.WHITE));
	}
}
