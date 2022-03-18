package chess.pieces;

import board.Board;
import board.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	private ChessMatch chessMatch;

	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	@Override
	public String toString() {
		return "K";
	}

	private boolean canMove(Position position) {
		ChessPiece piece = (ChessPiece) getBoard().piece(position);
		return piece == null || piece.getColor() != getColor();
	}

	private boolean testRookCastling(Position position) {
		ChessPiece piece = (ChessPiece) getBoard().piece(position);
		return piece != null && piece instanceof Rook && piece.getColor() == getColor() && piece.getMoveCount() == 0;
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);

		// above
		p.setValues(position.getRow() - 1, position.getColumn());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// below
		p.setValues(position.getRow() + 1, position.getColumn());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// left
		p.setValues(position.getRow(), position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// right
		p.setValues(position.getRow(), position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// above left
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// above right
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// below left
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// below right
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// special move = castling
		if (getMoveCount() == 0 && !chessMatch.isCheck()) {
			// kingside rook castling
			Position kingRook = new Position(position.getRow(), position.getColumn() + 3);
			if (testRookCastling(kingRook)) {
				Position kingSide = new Position(position.getRow(), position.getColumn() + 1);
				Position rookSide = new Position(position.getRow(), position.getColumn() + 2);
				if (getBoard().piece(kingSide) == null && getBoard().piece(rookSide) == null) {
					mat[position.getRow()][position.getColumn() + 2] = true;
				}
			}

			// queenside rook castling
			Position queenRook = new Position(position.getRow(), position.getColumn() - 4);
			if (testRookCastling(queenRook)) {
				Position queenSide = new Position(position.getRow(), position.getColumn() - 1);
				Position between = new Position(position.getRow(), position.getColumn() - 2);
				Position rookSide = new Position(position.getRow(), position.getColumn() - 3);
				if (getBoard().piece(queenSide) == null && getBoard().piece(between) == null && getBoard().piece(rookSide) == null) {
					mat[position.getRow()][position.getColumn() - 2] = true;
				}
			}
		}

		return mat;
	}
}
