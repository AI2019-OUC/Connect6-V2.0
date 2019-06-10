package core.board;

/** Describes the classes of Piece on a Connect6 board.
 *  @author Jianliang Xu
 */
public enum PieceColor {

    /** EMPTY: no piece.
     *  BLACK, WHITE: piece colors. */
    EMPTY,
    BLACK {
        @Override
        public PieceColor opposite() {
            return WHITE;
        }

        @Override
        public boolean isPiece() {
            return true;
        }
    },
    WHITE {
        @Override
        public PieceColor opposite() {
            return BLACK;
        }

        @Override
        public boolean isPiece() {
            return true;
        }
    };

    /** Return the piece color of my opponent, if defined. */
    public PieceColor opposite() {
        throw new UnsupportedOperationException();
    }

    /** Return true iff I denote a piece rather than an empty square. */
    public boolean isPiece() {
        return false;
    }

    /** Return the standard one-character denotation of this piece ('b', 'w',
     *  or '-'). */
    public String shortName() {
        return this == BLACK ? "b" : this == WHITE ? "w" : "-";
    }

    @Override
    public String toString() {
        return capitalize(super.toString().toLowerCase());
    }

    /** Return WORD with first letter capitalized. */
    public static String capitalize(String word) {
        return Character.toUpperCase(word.charAt(0)) + word.substring(1);
    }
}
