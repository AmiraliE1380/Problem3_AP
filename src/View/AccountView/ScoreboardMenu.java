package View.AccountView;

import Controller.Account;
import Model.Player;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collection;

public class ScoreboardMenu extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Ebi's chess");
        ObservableList<Player> players = FXCollections.observableArrayList(Account.getInstance().getPlayersBasedOnScore());

        TableView<Player> table = new TableView<>();
        table.setItems(players);
        addColumns(table);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table);

        primaryStage.setScene(new Scene(vBox));
        primaryStage.show();
    }

    private void addColumns(TableView table){
        TableColumn<Player, String> nameColumn = constructColumn("Username", "username");
        TableColumn<Player, String> scoreColumn = constructColumn("Total Score", "score");
        TableColumn<Player, String> winsColumn = constructColumn("Wins", "numOfWins");
        TableColumn<Player, String> drawsColumn = constructColumn("Draws", "numOfDraws");
        TableColumn<Player, String> loosesColumn = constructColumn("Looses", "numOfLooses");
        TableColumn<Player, String> rivalForfeitsColumn = constructColumn("Rival Forfeits", "numOfRivalForfeits");
        TableColumn<Player, String> ownForfeitsColumn = constructColumn("Own Forfeits", "numOfOwnForfeits");

        table.getColumns().addAll(nameColumn, scoreColumn, winsColumn, drawsColumn, loosesColumn,
                rivalForfeitsColumn, ownForfeitsColumn);
    }

    private TableColumn<Player, String> constructColumn(String columnName, String propertyName) {
        TableColumn<Player, String> column = new TableColumn<>(columnName);
        column.setMinWidth(100);
        column.setCellValueFactory(new PropertyValueFactory<>(propertyName));
        return column;
    }
}
