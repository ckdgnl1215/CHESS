package chess.chess.Board.Elements;

import chess.chess.Board.Board;
import chess.chess.Board.Pieces.Garbage;
import chess.chess.Board.Pieces.Piece;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class BWPos extends ToggleButton {
    private int xPos, yPos;
    public Garbage garbage = new Garbage();
    private Piece piece = garbage;
    public String color;
    public boolean onFocused = false;
    public boolean onCatched = false;
    public BWPos(int xPos, int yPos, String style, String color){
        this.setText("");
        this.setLayoutX(xPos);
        this.setLayoutY(yPos);
        this.color = color;
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

    public void onSelected() {
        if(this.onFocused && !(this.piece instanceof Garbage)){
            this.onFocused = false;
        }
        if(!(this.piece instanceof Garbage) && !(this.onFocused) && !(this.onCatched)){
            Board.nowFocused.setSelected(false);
            Board.nowFocused = this;
            for (int[] newone : this.piece.getAbleToMove()) {
                    if (Board.boardMatrix[newone[0]][newone[1]].getPiece() instanceof Garbage) {
                    Board.boardMatrix[newone[0]][newone[1]].onFocus();
                }
                else {
                    Board.boardMatrix[newone[0]][newone[1]].onCatch();
                }
            }
        }
        else if(!(this.piece instanceof Garbage) && !(this.onFocused) && (this.onCatched)){
            BWPos now = Board.nowFocused;
            this.setPiece(now.getPiece());
            now.setSelected(false);
            now.setPiece(now.garbage);
            this.getPiece().setPos(this.xPos, this.yPos);
            this.setSelected(false);

        }
        else if (this.onFocused) {
            BWPos now = Board.nowFocused;
            this.setPiece(now.getPiece().setMoved());
            now.setSelected(false);
            now.setPiece(now.garbage);
            this.getPiece().setPos(this.xPos, this.yPos);
            this.setSelected(false);
        }
        else {
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
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Board.boardMatrix[i][j].deCatch();
            }
        }
    }

    public void onFocus() {
        Image image = new Image(getClass().getResource("/image/piece.png").toString());
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(25);
        imageView.setFitHeight(25);
        this.setGraphic(imageView);
        this.onFocused = true;
    }

    public void deFocus() {
        this.setGraphic(null);
        this.onFocused = false;
    }

    public void onCatch() {
        this.setBorder(new Border(new BorderStroke(
                Color.RED,                        // 테두리 색상
                BorderStrokeStyle.SOLID,         // 테두리 스타일
                new CornerRadii(5),              // 둥근 모서리
                new BorderWidths(3)              // 테두리 두께
        )));
        this.onCatched = true;
    }

    public void deCatch() {
        if(this.color.equals("white")) {
            this.setBorder(new Border(new BorderStroke(
                    Color.WHITE,                        // 테두리 색상
                    BorderStrokeStyle.SOLID,         // 테두리 스타일
                    new CornerRadii(5),              // 둥근 모서리
                    new BorderWidths(3)              // 테두리 두께
            )));
        }
        else if(this.color.equals("black")) {
            this.setBorder(new Border(new BorderStroke(
                    Color.BLACK,                        // 테두리 색상
                    BorderStrokeStyle.SOLID,         // 테두리 스타일
                    new CornerRadii(5),              // 둥근 모서리
                    new BorderWidths(3)              // 테두리 두께
            )));
        }
        this.onCatched = false;
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
                this.setGraphic(null);
                break;
        }
        return this;
    }
    public Piece getPiece() {return this.piece;}
}