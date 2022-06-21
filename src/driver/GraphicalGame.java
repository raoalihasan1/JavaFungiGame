package driver;
import board.*;
import cards.*;
import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.event.EventHandler;

public class GraphicalGame extends Application {

  private static Player p1, p2;

  public static void startGame(){
    p1 = new Player();
    p2 = new Player();
    Board.initialisePiles();
		Board.setUpCards();
		Board.getForestCardsPile().shufflePile();
    for (int i=0; i<8;i++){
			Board.getForest().add(Board.getForestCardsPile().drawCard());
		}
    p1.addCardtoHand(Board.getForestCardsPile().drawCard());
    p1.addCardtoHand(Board.getForestCardsPile().drawCard());
    p1.addCardtoHand(Board.getForestCardsPile().drawCard());
		p2.addCardtoHand(Board.getForestCardsPile().drawCard());
    p2.addCardtoHand(Board.getForestCardsPile().drawCard());
    p2.addCardtoHand(Board.getForestCardsPile().drawCard());
  }

  public void start(Stage gameStage){
    gameStage.setTitle("Official - The Fungi Game");
    VBox vBox = new VBox(35);
    vBox.setStyle("-fx-background-color: #181818;");
    VBox vBox2 = new VBox(35);
    vBox2.setStyle("-fx-background-color: #181818;");
    Scene gameScene = new Scene(vBox, 1250, 700);
    Scene newGame = new Scene(vBox2, 1250, 700);
    Text textHeading = new Text("The Fungi Game");
    textHeading.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 45));
    textHeading.setFill(Color.WHITE);
    Button startGame = new Button("New Game");
    startGame.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 27.5));
    startGame.setMinWidth(350);
    startGame.setMinHeight(65);
    startGame.setStyle("-fx-background-color: #383838; -fx-text-fill: #FFF;");
    startGame.setOnAction(event -> scene2(gameStage, vBox2, newGame));
    Button exitGame = new Button("Exit Game");
    exitGame.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 27.5));
    exitGame.setMinWidth(350);
    exitGame.setMinHeight(65);
    exitGame.setStyle("-fx-background-color: #383838; -fx-text-fill: #FFF;");
    exitGame.setOnAction(event -> gameStage.close());
    vBox.getChildren().addAll(textHeading, startGame, exitGame);
    vBox.setAlignment(Pos.CENTER);
    gameStage.setScene(gameScene);
    gameStage.show();
  }

  public void scene2(Stage gameStage, VBox vBox2, Scene newGame){
    Text textHeading = new Text("Introduction");
    textHeading.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 45));
    textHeading.setFill(Color.WHITE);
    vBox2.setMargin(textHeading, new Insets(95, 0, 0, 0));
    Label gameRules1 = new Label("You Stand In The Middle Of A Forest And Take In A Deep Breath Of Fresh Air.");
    Label gameRules2 = new Label("You Can Feel That Today Must Be Your Lucky Day. Over The Last Week");
    Label gameRules3 = new Label("Sunshine And Rain Have Taken Turns To Create The Perfect Environment");
    Label gameRules4 = new Label("For A Luscious Harvest Of Savoury Mushrooms. Advice From The Local");
    Label gameRules5 = new Label("Populace Is Also Giving You A Boost Of Confidence. Equipped With A Large");
    Label gameRules6 = new Label("Basket, You Started Early In The Day - Before Dawn Under The Glow Of");
    Label gameRules7 = new Label("Moonlight. You Even Packed A Pan, Some Butter And Cider So That The");
    Label gameRules8 = new Label("Reward Come Nightfall Will Be A Feast Around Your Campfire Of All The");
    Label gameRules9 = new Label("Savoury Mushrooms You Have Garnered");
    Label gameRules10 = new Label("It Is Going To Be A Beautiful Day!");
    gameRules1.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 18));
    gameRules2.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 18));
    gameRules3.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 18));
    gameRules4.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 18));
    gameRules5.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 18));
    gameRules6.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 18));
    gameRules7.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 18));
    gameRules8.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 18));
    gameRules9.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 18));
    gameRules10.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 18));
    gameRules1.setTextFill(Color.WHITE);
    gameRules2.setTextFill(Color.WHITE);
    gameRules3.setTextFill(Color.WHITE);
    gameRules4.setTextFill(Color.WHITE);
    gameRules5.setTextFill(Color.WHITE);
    gameRules6.setTextFill(Color.WHITE);
    gameRules7.setTextFill(Color.WHITE);
    gameRules8.setTextFill(Color.WHITE);
    gameRules9.setTextFill(Color.WHITE);
    gameRules10.setTextFill(Color.WHITE);
    gameRules1.setStyle("-fx-line-spacing: 7.5px");
    gameRules2.setStyle("-fx-line-spacing: 7.5px");
    gameRules3.setStyle("-fx-line-spacing: 7.5px");
    gameRules4.setStyle("-fx-line-spacing: 7.5px");
    gameRules5.setStyle("-fx-line-spacing: 7.5px");
    gameRules6.setStyle("-fx-line-spacing: 7.5px");
    gameRules7.setStyle("-fx-line-spacing: 7.5px");
    gameRules8.setStyle("-fx-line-spacing: 7.5px");
    gameRules9.setStyle("-fx-line-spacing: 7.5px");
    gameRules10.setStyle("-fx-line-spacing: 7.5px");
    vBox2.setMargin(gameRules1, new Insets(0, -100, 20, -100));
    vBox2.setMargin(gameRules2, new Insets(-40, -100, 20, -100));
    vBox2.setMargin(gameRules3, new Insets(-40, -100, 20, -100));
    vBox2.setMargin(gameRules4, new Insets(-40, -100, 20, -100));
    vBox2.setMargin(gameRules5, new Insets(-40, -100, 20, -100));
    vBox2.setMargin(gameRules6, new Insets(-40, -100, 20, -100));
    vBox2.setMargin(gameRules7, new Insets(-40, -100, 20, -100));
    vBox2.setMargin(gameRules8, new Insets(-40, -100, 20, -100));
    vBox2.setMargin(gameRules9, new Insets(-40, -100, 20, -100));
    vBox2.setMargin(gameRules10, new Insets(-40, -100, 0, -100));
    Button newGameStart = new Button("Start");
    newGameStart.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 27.5));
    newGameStart.setMinWidth(350);
    newGameStart.setMinHeight(65);
    newGameStart.setStyle("-fx-background-color: #383838; -fx-text-fill: #FFF;");
    newGameStart.setOnAction(event -> game(gameStage, p1));
    Button returnToMain = new Button("Return");
    returnToMain.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 27.5));
    returnToMain.setMinWidth(350);
    returnToMain.setMinHeight(65);
    returnToMain.setStyle("-fx-background-color: #383838; -fx-text-fill: #FFF;");
    returnToMain.setOnAction(event -> start(gameStage));
    newGameStart.setTranslateX(-200);
    returnToMain.setTranslateX(200);
    newGameStart.setTranslateY(-10);
    returnToMain.setTranslateY(-110);
    vBox2.getChildren().addAll(textHeading, gameRules1, gameRules2, gameRules3, gameRules4, gameRules5, gameRules6, gameRules7, gameRules8, gameRules9, gameRules10, newGameStart, returnToMain);
    vBox2.setAlignment(Pos.CENTER);
    GraphicalGame.startGame();
    gameStage.setScene(newGame);
  }

  public void gamePaused(Player currentPlayer, Stage gameStage){
    VBox vBox = new VBox(25);
    vBox.setStyle("-fx-background-color: #181818;");
    Scene gameScene = new Scene(vBox, 1250, 700);
    Text currentScoreP1 = new Text("Player 1 Points: " + p1.getScore());
    currentScoreP1.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 25));
    currentScoreP1.setFill(Color.WHITE);
    Text currentScoreP2 = new Text("Player 2 Points: " + p2.getScore());
    currentScoreP2.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 25));
    currentScoreP2.setFill(Color.WHITE);
    Button resumeGame = new Button("Resume Game");
    resumeGame.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 22.5));
    resumeGame.setMinWidth(350);
    resumeGame.setMinHeight(50);
    resumeGame.setStyle("-fx-background-color: #383838; -fx-text-fill: #FFF;");
    resumeGame.setOnAction(event -> game(gameStage, currentPlayer));
    Button exitGame = new Button("Exit Game");
    exitGame.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 22.5));
    exitGame.setMinWidth(350);
    exitGame.setMinHeight(50);
    exitGame.setStyle("-fx-background-color: #383838; -fx-text-fill: #FFF;");
    exitGame.setOnAction(event -> gameStage.close());
    vBox.getChildren().addAll(currentScoreP1, currentScoreP2, resumeGame, exitGame);
    vBox.setAlignment(Pos.CENTER);
    gameStage.setScene(gameScene);
  }

  public void changePlayer(Player currentPlayer, Stage gameStage){
    if(Board.getForest().size() > 0){
      Board.updateDecayPile();
    }
    if(Board.getForestCardsPile().pileSize() > 0){
      Board.getForest().add(Board.getForestCardsPile().drawCard());
      game(gameStage, switchPlayer(currentPlayer));
    }
  }

  public void game(Stage gameStage, Player currentPlayer){

    GridPane gridPane = new GridPane();
    gridPane.setStyle("-fx-background-color: #181818;");

    Scene gameStarted = new Scene(gridPane, 1250, 700);
    gameStage.setScene(gameStarted);

    displayCards(currentPlayer, gridPane, p1.getScore(), p2.getScore(), gameStage);

    Label gameForest = new Label("The Forest:");
    gameForest.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 18));
    gameForest.setTextFill(Color.WHITE);
    gameForest.setTranslateY(167.5);
    gameForest.setTranslateX(40);
    gridPane.getChildren().addAll(gameForest);

    Label playerTurn = new Label();
    playerTurn.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 18));
    playerTurn.setTextFill(Color.WHITE);
    playerTurn.setTranslateX(40);
    gridPane.getChildren().addAll(playerTurn);

    Button pauseGame = new Button("Pause Game");
    pauseGame.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 14));
    pauseGame.setTranslateX(1110);
    pauseGame.setMinWidth(130);
    pauseGame.setMaxWidth(130);
    pauseGame.setMinHeight(40);
    pauseGame.setStyle("-fx-background-color: #383838; -fx-text-fill: #FFF;");
    pauseGame.setOnAction(event -> gamePaused(currentPlayer, gameStage));

    Label pileSizeLeft = new Label("Cards Remaining: " + Board.getForestCardsPile().pileSize());
    pileSizeLeft.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 17));
    pileSizeLeft.setTextFill(Color.WHITE);
    pileSizeLeft.setTranslateX(520);
    gridPane.getChildren().addAll(pileSizeLeft);

    Button option1 = new Button("Take From Forest");
    option1.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 15));
    option1.setTranslateX(40);
    option1.setMinWidth(200);
    option1.setMaxWidth(200);
    option1.setMinHeight(40);
    option1.setStyle("-fx-background-color: #383838; -fx-text-fill: #FFF;");

    Button option2 = new Button("Take From Decay");
    option2.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 15));
    option2.setTranslateX(270);
    option2.setMinWidth(200);
    option2.setMaxWidth(200);
    option2.setMinHeight(40);
    option2.setStyle("-fx-background-color: #383838; -fx-text-fill: #FFF;");

    Button option3 = new Button("Cook Mushrooms");
    option3.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 15));
    option3.setTranslateX(520);
    option3.setMinWidth(200);
    option3.setMaxWidth(200);
    option3.setMinHeight(40);
    option3.setStyle("-fx-background-color: #383838; -fx-text-fill: #FFF;");

    Button option4 = new Button("Sell Mushrooms");
    option4.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 15));
    option4.setTranslateX(40);
    option4.setMinWidth(200);
    option4.setMaxWidth(200);
    option4.setMinHeight(40);
    option4.setStyle("-fx-background-color: #383838; -fx-text-fill: #FFF;");

    Button option5 = new Button("Put Pan Down");
    option5.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 15));
    option5.setTranslateX(270);
    option5.setMinWidth(200);
    option5.setMaxWidth(200);
    option5.setMinHeight(40);
    option5.setStyle("-fx-background-color: #383838; -fx-text-fill: #FFF;");

    Label p2Title = new Label("Player 2: Hand  -  Stick Count: " + p2.getStickNumber() + "  -  Points: " + p2.getScore());
    p2Title.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 18));
    p2Title.setTextFill(Color.WHITE);
    p2Title.setTranslateX(40);

    Label p1Title = new Label("Player 1: Hand - Stick Count: " + p1.getStickNumber() + "  -  Points: " + p1.getScore());
    p1Title.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 18));
    p1Title.setTextFill(Color.WHITE);
    p1Title.setTranslateX(40);

    if(currentPlayer == p1){
      option1.setTranslateY(460);
      option2.setTranslateY(460);
      option3.setTranslateY(460);
      option4.setTranslateY(515);
      option5.setTranslateY(515);
      playerTurn.setTranslateY(415);
      playerTurn.setText("Player 1 Turn");
      p1Title.setTranslateY(-58.25);
      pileSizeLeft.setTranslateY(515);
      pauseGame.setTranslateY(-55);
      p2Title.setText("Player 2: Points - " + p2.getScore());
      p2Title.setTranslateY(595);
      pauseGame.setTranslateY(590);
      gridPane.getChildren().addAll(pauseGame, p1Title, p2Title, option1, option2, option3, option4, option5);
    } else {
      option1.setTranslateY(40);
      option2.setTranslateY(40);
      option3.setTranslateY(40);
      option4.setTranslateY(90);
      option5.setTranslateY(90);
      pileSizeLeft.setTranslateY(90);
      playerTurn.setTranslateY(-5);
      playerTurn.setText("Player 2 Turn");
      p1Title.setText("Player 1: Points - " + p1.getScore());
      p1Title.setTranslateY(-60);
      p2Title.setTranslateY(400);
      pauseGame.setTranslateY(590);
      gridPane.getChildren().addAll(pauseGame, p1Title, p2Title, option1, option2, option3, option4, option5);
    }

    option1.setOnAction(event -> {
      playerTurn.setVisible(false);
      ArrayList<Button> positionOfCard = new ArrayList<Button>();
      option1.setVisible(false);
      option2.setVisible(false);
      option3.setVisible(false);
      option4.setVisible(false);
      option5.setVisible(false);
      pileSizeLeft.setVisible(false);
      int x = 40-250;
      for(int i = 1; i <= Board.getForest().size(); i++){
        Button positionOfCardButton = new Button(String.valueOf(i));
        positionOfCard.add(positionOfCardButton);
      }
      Label selectCard = new Label();
      selectCard.setText("Select Position of Card From The Forest:");
      selectCard.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 20));
      selectCard.setTextFill(Color.web("#fff"));
      selectCard.setTranslateX(40);
      if(currentPlayer == p1){
        selectCard.setTranslateY(420);
      } else {
        selectCard.setTranslateY(20);
      }
      gridPane.getChildren().add(selectCard);
      for(int i = 0; i < positionOfCard.size(); i++){
        final int y = i;
        positionOfCard.get(i).setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 13));
        positionOfCard.get(i).setStyle("-fx-background-color: #383838; -fx-text-fill: #FFF;");
        positionOfCard.get(i).setTranslateX(x + 250);
        if(currentPlayer == p1){
          positionOfCard.get(i).setTranslateY(475);
        } else {
          positionOfCard.get(i).setTranslateY(75);
        }
        positionOfCard.get(i).setMinWidth(65);
        positionOfCard.get(i).setMaxWidth(65);
        positionOfCard.get(i).setMinHeight(40);
        positionOfCard.get(i).setOnAction(e -> {
          if(currentPlayer.takeCardFromTheForest(y + 1)){
            if(Board.getForestCardsPile().pileSize() > 0){
              Board.getForest().add(Board.getForestCardsPile().drawCard());
              changePlayer(currentPlayer, gameStage);
            }
          } else {
            game(gameStage, currentPlayer);
          }
        });
        x += 80;
        gridPane.getChildren().add(positionOfCard.get(i));
      }
    });

    option2.setOnAction(event -> {
      if(currentPlayer.takeFromDecay()){
        changePlayer(currentPlayer, gameStage);
      } else {
        game(gameStage, currentPlayer);
      }
    });

    option3.setOnAction(event -> {
      playerTurn.setVisible(false);
      ArrayList<Button> positionOfCard = new ArrayList<Button>();
      ArrayList<Card> cardToCook = new ArrayList<Card>();
      option1.setVisible(false);
      option2.setVisible(false);
      option3.setVisible(false);
      option4.setVisible(false);
      option5.setVisible(false);
      pileSizeLeft.setVisible(false);
      int x = 40-250;
      for(int i = 1; i <= currentPlayer.getHand().size(); i++){
        Button positionOfCardButton = new Button(String.valueOf(i));
        positionOfCard.add(positionOfCardButton);
      }
      Label selectCard = new Label();
      selectCard.setText("Choose The Mushrooms From Your Hand To Cook:");
      selectCard.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 20));
      selectCard.setTextFill(Color.web("#fff"));
      selectCard.setTranslateX(40);
      if(currentPlayer == p1){
        selectCard.setTranslateY(430);
      } else {
        selectCard.setTranslateY(10);
      }
      gridPane.getChildren().add(selectCard);
      for(int i = 0; i < positionOfCard.size(); i++){
        final int y = i;
        positionOfCard.get(i).setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 15));
        positionOfCard.get(i).setStyle("-fx-background-color: #383838; -fx-text-fill: #FFF;");
        positionOfCard.get(i).setTranslateX(x + 250);
        if(currentPlayer == p1){
          positionOfCard.get(i).setTranslateY(475);
        } else {
          positionOfCard.get(i).setTranslateY(55);
        }
        positionOfCard.get(i).setMinWidth(60);
        positionOfCard.get(i).setMaxWidth(60);
        positionOfCard.get(i).setMinHeight(40);
        positionOfCard.get(i).setOnAction(e -> {
          positionOfCard.get(y).setStyle("-fx-background-color: #00FF00; -fx-text-fill: #FFF;");
          cardToCook.add(currentPlayer.getHand().getElementAt(y));
        });
        x += 75;
        gridPane.getChildren().add(positionOfCard.get(i));
      }
      Button cookTheMushrooms = new Button("Cook Mushrooms");
      cookTheMushrooms.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 15));
      cookTheMushrooms.setStyle("-fx-background-color: #383838; -fx-text-fill: #FFF;");
      cookTheMushrooms.setTranslateX(40);
      if(currentPlayer == p1){
        cookTheMushrooms.setTranslateY(530);
      } else {
        cookTheMushrooms.setTranslateY(110);
      }
      cookTheMushrooms.setMinWidth(200);
      cookTheMushrooms.setMaxWidth(200);
      cookTheMushrooms.setMinHeight(40);
      cookTheMushrooms.setOnAction(e -> {
        if(currentPlayer.cookMushrooms(cardToCook)){
          changePlayer(currentPlayer, gameStage);
        } else {
          game(gameStage, currentPlayer);
        }
      });
      gridPane.getChildren().add(cookTheMushrooms);
    });

    option4.setOnAction(event -> {
      int mushroomsInHand = 0;
      for(int i = 0; i < currentPlayer.getHand().size(); i++){
        if(currentPlayer.getHand().getElementAt(i).getType().equals(CardType.DAYMUSHROOM) || currentPlayer.getHand().getElementAt(i).getType().equals(CardType.NIGHTMUSHROOM)){
          mushroomsInHand++;
        }
      }
      if(mushroomsInHand == 0){
        game(gameStage, currentPlayer);
      }
      playerTurn.setVisible(false);
      option1.setVisible(false);
      option2.setVisible(false);
      option3.setVisible(false);
      option4.setVisible(false);
      option5.setVisible(false);
      pileSizeLeft.setVisible(false);
      ArrayList<String> cardNames = new ArrayList<String>();
      ArrayList<Button> cardButtons = new ArrayList<Button>();
      for(int i = 0; i < currentPlayer.getHand().size(); i++){
        boolean alreadyInArrayList = false;
        for(int s = 0; s < cardNames.size(); s++){
          if(cardNames.get(s).equals(currentPlayer.getHand().getElementAt(i).getName())){
            alreadyInArrayList = true;
            break;
          }
        }
        if(alreadyInArrayList == false && (currentPlayer.getHand().getElementAt(i).getType().equals(CardType.DAYMUSHROOM) || currentPlayer.getHand().getElementAt(i).getType().equals(CardType.NIGHTMUSHROOM))){
          cardNames.add(currentPlayer.getHand().getElementAt(i).getName());
        }
      }
      for(int i = 0; i < cardNames.size(); i++){
        Button positionOfCardButton = new Button(cardNames.get(i).toUpperCase());
        cardButtons.add(positionOfCardButton);
      }
      Label selectCard = new Label();
      selectCard.setText("Choose The Mushroom Type From Your Hand To Sell:");
      selectCard.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 20));
      selectCard.setTextFill(Color.web("#fff"));
      selectCard.setTranslateX(40);
      if(currentPlayer == p1){
        selectCard.setTranslateY(420);
      } else {
        selectCard.setTranslateY(0);
      }
      gridPane.getChildren().add(selectCard);
      int x = 40-250;
      for(int i = 0; i < cardButtons.size(); i++){
        final int y = i;
        cardButtons.get(i).setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 13));
        cardButtons.get(i).setStyle("-fx-background-color: #383838; -fx-text-fill: #FFF;");
        cardButtons.get(i).setTranslateX(x + 250);
        if(currentPlayer == p1){
          cardButtons.get(i).setTranslateY(475);
        } else {
          cardButtons.get(i).setTranslateY(50);
        }
        cardButtons.get(i).setMinWidth(125);
        cardButtons.get(i).setMaxWidth(125);
        cardButtons.get(i).setMinHeight(40);
        cardButtons.get(i).setOnAction(e -> {
          for(int k = 0; k < cardButtons.size(); k++){
            cardButtons.get(k).setVisible(false);
          }
          String cardToSellType = cardNames.get(y);
          int countOfMushrooms = 0;
          for(int j = 0; j < currentPlayer.getHand().size(); j++){
            if(currentPlayer.getHand().getElementAt(j).getName().equals(cardToSellType)){
              if(currentPlayer.getHand().getElementAt(j).getType().equals(CardType.DAYMUSHROOM)){
                countOfMushrooms++;
              } else if(currentPlayer.getHand().getElementAt(j).getType().equals(CardType.NIGHTMUSHROOM)) {
                countOfMushrooms += 2;
              } else {
                game(gameStage, currentPlayer);
              }
            }
          }
          if(countOfMushrooms < 2){
            game(gameStage, currentPlayer);
          }
          selectCard.setText("Choose The Number Of " + cardToSellType.substring(0, 1).toUpperCase() + cardToSellType.substring(1) + " To Sell:");
          TextField numToSell = new TextField();
          numToSell.setPromptText("Number Of Mushroom Type To Sell:");
          numToSell.setTranslateX(40);
          numToSell.setMinWidth(422.5);
          numToSell.setMaxWidth(422.5);
          numToSell.setMinHeight(40);
          numToSell.setFocusTraversable(false);
          numToSell.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 14));
          Button submitNum = new Button("SELL " + cardToSellType.toUpperCase());
          submitNum.setMinWidth(250);
          submitNum.setMaxWidth(250);
          submitNum.setMinHeight(40);
          submitNum.setFocusTraversable(false);
          submitNum.setTranslateX(480);
          submitNum.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 15));
          submitNum.setStyle("-fx-background-color: #383838; -fx-text-fill: #FFF;");
          gridPane.getChildren().addAll(numToSell, submitNum);
          if(currentPlayer == p1){
            submitNum.setTranslateY(475);
            numToSell.setTranslateY(475);
          } else {
            submitNum.setTranslateY(50);
            numToSell.setTranslateY(50);
          }
          submitNum.setOnAction(sellMushroom -> {
            int numOfMushroomToSell = 0;
            try {
              numOfMushroomToSell = Integer.valueOf(numToSell.getText());
            } catch(NumberFormatException error){
              game(gameStage, currentPlayer);
            }
            if(currentPlayer.sellMushrooms(cardToSellType, numOfMushroomToSell)){
              changePlayer(currentPlayer, gameStage);
            } else {
              game(gameStage, currentPlayer);
            }
          });
        });
        x += 135;
        gridPane.getChildren().add(cardButtons.get(i));
      }
    });

    option5.setOnAction(event -> {
      if(currentPlayer.putPanDown()){
        changePlayer(currentPlayer, gameStage);
      } else {
        game(gameStage, currentPlayer);
      }
    });

  }

  public void winnerScene(String winner, Stage gameStage){
    VBox vBox = new VBox(50);
    vBox.setStyle("-fx-background-color: #181818;");
    Scene gameScene = new Scene(vBox, 1250, 700);
    Text winnerHeading = new Text(winner);
    winnerHeading.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 30));
    winnerHeading.setFill(Color.WHITE);
    Button newGame = new Button("Return To Home");
    newGame.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 30));
    newGame.setMinWidth(350);
    newGame.setMinHeight(65);
    newGame.setMaxWidth(350);
    newGame.setMaxHeight(65);
    newGame.setStyle("-fx-background-color: #383838; -fx-text-fill: #FFF;");
    newGame.setOnAction(event -> start(gameStage));
    Button exitGame = new Button("Exit Game");
    exitGame.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 30));
    exitGame.setMinWidth(350);
    exitGame.setMinHeight(65);
    exitGame.setMaxWidth(350);
    exitGame.setMaxHeight(65);
    exitGame.setStyle("-fx-background-color: #383838; -fx-text-fill: #FFF;");
    exitGame.setOnAction(event -> gameStage.close());
    vBox.getChildren().addAll(winnerHeading, exitGame);
    vBox.setAlignment(Pos.CENTER);
    gameStage.setScene(gameScene);
  }
  public void displayCards(Player currentPlayer, GridPane gridPane, int p1Score, int p2Score, Stage gameStage){
    if(Board.getForestCardsPile().pileSize() <= 0){
      String winner;
      if(p1Score > p2Score){
        winner = "        Player 1 Points: " + p1Score + "\n\n         Player 2 Points: " + p2Score + "\n\n   Player 1 Wins By "+(p1Score-p2Score)+" Points!";
      } else if(p1Score < p2Score){
        winner = "        Player 1 Points: " + p1Score + "\n\n         Player 2 Points: " + p2Score + "\n\n   Player 2 Wins By "+(p2Score-p1Score)+" Points!";
      } else {
        winner = "          Player 1 Points: " + p1Score + "\n\n          Player 2 Points: " + p2Score + "\n\n  The Game Has Ended In A Tie!";
      }
      winnerScene(winner, gameStage);
    }
    try{
      int n = 40;
      if(currentPlayer == p1){
        if(p1.getHand().size() > 0){
          int x = 40;
          for(int i = 0; i < p1.getHand().size(); i++){
            Image mushroomImage = new Image(new FileInputStream("img/" + p1.getHand().getElementAt(i).getName() + ".jpg"));
            ImageView imageView = new ImageView(mushroomImage);
            imageView.setTranslateX(x);
            imageView.setTranslateY(45);
            Label position = new Label("("+(i+1)+") - " + p1.getHand().getElementAt(i).getType());
            position.setFont(Font.font("Edwardian Script ITC", 9));
            position.setTextFill(Color.WHITE);
            position.setTranslateY(142.5);
            position.setTranslateX(x);
            gridPane.getChildren().addAll(imageView, position);
            x += 122.5;
          }
        }
      } else {
        if(p2.getHand().size() > 0){
          int y = 40;
          for(int i = 0; i < p2.getHand().size(); i++){
            Image mushroomImage = new Image(new FileInputStream("img/" + p2.getHand().getElementAt(i).getName() + ".jpg"));
            ImageView imageView = new ImageView(mushroomImage);
            imageView.setTranslateX(y);
            imageView.setTranslateY(502.5);
            Label position = new Label("("+(i+1)+") - " + p2.getHand().getElementAt(i).getType());
            position.setFont(Font.font("Edwardian Script ITC", 9));
            position.setTextFill(Color.WHITE);
            position.setTranslateY(600);
            position.setTranslateX(y);
            gridPane.getChildren().addAll(imageView, position);
            y += 122.5;
          }
        }
      }
      if(Board.getForest().size() > 0){
        for (int i = 0; i < Board.getForest().size(); i++){
          Image mushroomImage = new Image(new FileInputStream("img/" + Board.getForest().getElementAt(i).getName() + ".jpg"));
          ImageView imageView = new ImageView(mushroomImage);
          imageView.setTranslateX(n);
          imageView.setTranslateY(275);
          gridPane.getChildren().addAll(imageView);
          n += 122.5;
        }
        int a = 40;
        for (int i = 0; i < Board.getForest().size(); i++){
          Label position;
          int Index = Board.getForest().size() - i;
          if(Board.getForest().getElementAt(i).getType().equals(CardType.NIGHTMUSHROOM)){
            position = new Label("("+Index+") - NIGHTMUSHROOM");
            position.setTranslateX(a);
            position.setFont(Font.font("Edwardian Script ITC", 8.5));
          } else {
            position = new Label("("+Index+")");
            position.setTranslateX(a+40);
            position.setFont(Font.font("Edwardian Script ITC", 9));
          }
          position.setTextFill(Color.WHITE);
          position.setTranslateY(372.5);
          gridPane.getChildren().addAll(position);
          a += 122.5;
        }
      }
      Label decayPileElements = new Label("Decay Pile:\n");
      decayPileElements.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 16));
      decayPileElements.setTextFill(Color.WHITE);
      decayPileElements.setTranslateY(197.5);
      decayPileElements.setTranslateX(n+20);
      gridPane.getChildren().addAll(decayPileElements);
      if(Board.getDecayPile().size() > 0){
        int k = 0;
        for(Card c: Board.getDecayPile()){
          Label Element = new Label(c.getName().toUpperCase());
          Element.setFont(Font.font("Edwardian Script ITC", 14));
          Element.setTextFill(Color.WHITE);
          Element.setTranslateY(230+k);
          Element.setTranslateX(n+20);
          gridPane.getChildren().addAll(Element);
          k += 20;
        }
      }
      if(currentPlayer == p1){
        Label p1Display = new Label("Player 1: Display\n");
        p1Display.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 16));
        p1Display.setTextFill(Color.WHITE);
        p1Display.setTranslateY(400);
        p1Display.setTranslateX(n+20);
        gridPane.getChildren().addAll(p1Display);
        if(p1.getDisplay().size() > 0){
          int k = 0;
          for(int i = 0; i < p1.getDisplay().size(); i++){
            Label Element = new Label(p1.getDisplay().getElementAt(i).getName().toUpperCase());
            Element.setFont(Font.font("Edwardian Script ITC", 14));
            Element.setTextFill(Color.WHITE);
            Element.setTranslateY(430+k);
            Element.setTranslateX(n+20);
            gridPane.getChildren().addAll(Element);
            k += 20;
          }
        }
      } else {
        Label p2Display = new Label("Player 2: Display\n");
        p2Display.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 16));
        p2Display.setTextFill(Color.WHITE);
        p2Display.setTranslateY(-58.25);
        p2Display.setTranslateX(n+20);
        gridPane.getChildren().addAll(p2Display);
        if(p2.getDisplay().size() > 0){
          int k = 0;
          for(int i = 0; i < p2.getDisplay().size(); i++){
            Label Element = new Label(p2.getDisplay().getElementAt(i).getName().toUpperCase());
            Element.setFont(Font.font("Edwardian Script ITC", 14));
            Element.setTextFill(Color.WHITE);
            Element.setTranslateY(-28.25+k);
            Element.setTranslateX(n+20);
            gridPane.getChildren().addAll(Element);
            k += 20;
          }
        }
      }
    } catch(FileNotFoundException e){
      System.out.println("Error: The Card Images Are Not In The Files Specified In The Code!");
    }
  }

  public Player switchPlayer(Player p){
    if(p == p1){
      return p2;
    } else {
      return p1;
    }
  }

}
