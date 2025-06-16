package chess.chess.Board.Elements;

import chess.chess.Board.Board;
import chess.chess.Board.Pieces.Garbage;
import chess.chess.Board.Pieces.Piece;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BWPos extends ToggleButton {
    private int xPos, yPos;
    public Garbage garbage = new Garbage();
    private Piece piece = garbage;
    public boolean onFoused = false;
    public BWPos(int xPos, int yPos, String style){
        this.setText("");
        this.setLayoutX(xPos);
        this.setLayoutY(yPos);
        this.getStyleClass().add(style);
        this.xPos = xPos / 80;
        this.yPos = yPos / 80;
        this.selectedProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                onSelected();
            } else {
                onDeselected();
            }
        });
    }

    public BWPos() { }

    public void notGarbageFocused() {
        this.setStyle("-fx-border-color: red; -fx-border-width: 3;");
        this.onFoused = true;
    }

    public void onSelected() {
        if(!(this.piece instanceof Garbage)){
            Board.nowFocused.setSelected(false);
            Board.nowFocused = this;
            for (int[] newone : this.piece.getAbleToMove()) {
                BWPos target = Board.boardMatrix[newone[0]][newone[1]];
                if (target.getPiece() instanceof Garbage) {
                    target.onFocus();
                } else {
                    target.notGarbageFocused();
                }
                if (Board.boardMatrix[newone[0]][newone[1]].getPiece() instanceof Garbage) {
                    Board.boardMatrix[newone[0]][newone[1]].onFocus();
                } else {
                    Board.boardMatrix[newone[0]][newone[1]].notGarbageFocused();
                }
            }

        }
        else if (this.onFoused) {
            BWPos now = Board.nowFocused;
            this.setPiece(now.getPiece());
            now.setSelected(false);
            now.setPiece(now.garbage);
            this.getPiece().setPos(this.xPos, this.yPos);
            this.setSelected(false);
        }

        else if (!(this.getPiece() instanceof Garbage) && this.onFoused) {
            BWPos now = Board.nowFocused;
            this.setPiece(now.getPiece());
            now.setPiece(now.garbage);
            now.setSelected(false);
            this.getPiece().setPos(this.xPos, this.yPos);
            this.setSelected(false);
        }

        else {
            System.out.println();
            BWPos now = Board.nowFocused;
            now.setSelected(false);
            Board.nowFocused = this;
        }
    }

    public void onDeselected() {
        Board.nowFocused = Board.garbagePos;
        for (int[] newone : this.piece.getAbleToMove()) {
            if (Board.boardMatrix[newone[0]][newone[1]].getPiece() instanceof Garbage) {
                Board.boardMatrix[newone[0]][newone[1]].deFocus();
            }
        }
    }

    public void onFocus() {
        Image image = new Image(getClass().getResource("/image/piece.png").toString());
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(25);
        imageView.setFitHeight(25);
        this.setGraphic(imageView);
        this.onFoused = true;
    }

    public void deFocus() {
        this.setGraphic(null);
        this.setStyle("");
        this.onFoused = false;
    }

    public BWPos setPiece(Piece piece) {
        this.piece = piece;
        Image image;
        ImageView imageView;
        switch (this.piece.getClass().toString()){
            case "class chess.chess.Board.Pieces.King":
                image = new Image(getClass().getResource("/image/king.png").toString());
                imageView = new ImageView(image);
                imageView.setFitWidth(50);
                imageView.setFitHeight(50);
                this.setGraphic(imageView);
                break;
            case "class chess.chess.Board.Pieces.Queen":
                image = new Image(getClass().getResource("/image/queen.png").toString());
                imageView = new ImageView(image);
                imageView.setFitWidth(50);
                imageView.setFitHeight(50);
                this.setGraphic(imageView);
                break;
            case "class chess.chess.Board.Pieces.Rook":
                image = new Image(getClass().getResource("/image/rook.png").toString());
                imageView = new ImageView(image);
                imageView.setFitWidth(50);
                imageView.setFitHeight(50);
                this.setGraphic(imageView);
                break;
            case "class chess.chess.Board.Pieces.Bishop":
                image = new Image(getClass().getResource("/image/bishop.png").toString());
                imageView = new ImageView(image);
                imageView.setFitWidth(50);
                imageView.setFitHeight(50);
                this.setGraphic(imageView);
                break;
            case "class chess.chess.Board.Pieces.Knight":
                image = new Image(getClass().getResource("/image/knight.png").toString());
                imageView = new ImageView(image);
                imageView.setFitWidth(50);
                imageView.setFitHeight(50);
                this.setGraphic(imageView);
                break;
            case "class chess.chess.Board.Pieces.Pawn":
                image = new Image(getClass().getResource("/image/pawn.png").toString());
                imageView = new ImageView(image);
                imageView.setFitWidth(50);
                imageView.setFitHeight(50);
                this.setGraphic(imageView);
                break;
            case "class chess.chess.Board.Pieces.Garbage":
                System.out.println(3);
                this.setGraphic(null);
                break;
        }
        return this;
    }
    public Piece getPiece() {return this.piece;}

    public int getxPos() {return xPos;}
    public int getyPos() {return yPos;}

}
