package chess;

import board.Board;

public class ChessMatch {

	private Board board;
	
	public ChessMatch() {
		board = new Board(8, 8);
	}
	
	//a aplicação não precisa acessar as peças do tipo Piece[][] da camada 
	//de tabuleiro, e sim apenas a camada de xadrez
	public ChessPiece[][] getPieces() {
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		//percorrer as peças do tabuleiro
		//pra cada peça do tabuleiro, fazer um downcasting pra ChessPiece
		for (int i=0; i<board.getRows(); i++) {
			for (int j=0; j<board.getColumns(); j++) {
				//pra cada posição ij do tabuleiro, a mat[i][j] vai receber
				//o board.piece(i,j), fazendo downcasting pra ChessPiece
				//pra interpretar como uma peça de xadrez
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return mat;
	}
}
