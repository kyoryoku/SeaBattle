package sample;


import javafx.scene.image.Image;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private Text labelEnemyHP;

    @FXML
    private URL location;

    @FXML
    private AnchorPane root;

    @FXML
    private ImageView mySea;

    @FXML
    private Pane additionalPanel;

    @FXML
    private ImageView enemySea;

    @FXML
    private ImageView target;

    @FXML
    private Button buttonShoot;

    @FXML
    private Text lableMessage;

    @FXML
    void initialize() {

        //Cоздаем корабли
        Ship x4 = new Ship(4,'h');
        Ship x31 = new Ship(3,'h');
        Ship x32 = new Ship(3,'v');

        //Создаем поле
        Sea enSea = new Sea(10);
        enSea.placeShip(x4, 2, 2);
        enSea.placeShip(x31, 5, 2);
        enSea.placeShip(x32, 3, 8);

        //рисуем корабли на поле
        drawShips(enSea);

        //устанавливаем начальные метки и прячем кнопку
        lableMessage.setText("");
        buttonShoot.setVisible(false);
        labelEnemyHP.setText(Integer.toString(enSea.totalHP));

        //нажатие по полю ставит цель, или снимает
        enemySea.setOnMouseClicked(event -> {
            setTarget(event);
            if (Target.isSet) {
                showTarget();
            } else {
                hideTarget();
            }
        });

        //нажатие на кнопку производит выстрел и рисует или попадание, или промах
        buttonShoot.setOnAction(event -> {

            if (enSea.shoot()) {
                //попадание

                shipDestroed();
                hideTarget();
                labelEnemyHP.setText(Integer.toString(enSea.totalHP));
                lableMessage.setText("    УРААА! Красава! Жги еще!!     ");
            } else {
                //промах

                miss();
                hideTarget();
                lableMessage.setText("Ай бля! Не попали! Бахнем еще раз?");
            }

            //меняем сообщение на следующей кнопке
            buttonShoot.setText(TextMessage.messageInButton[TextMessage.getIndex()]);
        });

    }

    //прячем прицел
    private void hideTarget(){
        target.setLayoutX(-100);
        target.setLayoutY(-100);
        buttonShoot.setVisible(false);
        Target.isSet = false;
        lableMessage.setText("   Ну подумай, это не сложно...    ");
    }

    //рисуем прицел
    private void showTarget(){
        target.setLayoutX(Target.x);
        target.setLayoutY(Target.y);
        buttonShoot.setVisible(true);
        lableMessage.setText("        Точно сюда? Уверен?        ");
    }

    //рисуем уничтоженый кораблик
    private void shipDestroed(){
        ImageView im = new ImageView();
        im.setImage(new Image("sample/resources/ShipDestroed.png"));
        root.getChildren().addAll(im);
        im.setLayoutX(Target.x + 20);
        im.setLayoutY(Target.y + 20);
        im.setFitWidth(40);
        im.setFitHeight(40);
    }

    //рисуем промах
    private void miss(){
        ImageView im = new ImageView();
        im.setImage(new Image("sample/resources/Cross.png"));
        root.getChildren().addAll(im);
        im.setLayoutX(Target.x+20);
        im.setLayoutY(Target.y+20);
        im.setFitWidth(40);
        im.setFitHeight(40);
    }

    //рисуем корабли на поле
    private void drawShips (Sea sea){
        int x = 633;
        int y = 115;

        for (int i = 0; i<10; i++){
            for (int j = 0; j<10; j++){

                if (sea.point[i][j] == 1) {

                    ImageView im = new ImageView();
                    im.setImage(new Image("sample/resources/Ship.png"));


                    root.getChildren().addAll(im);

                    im.setLayoutX(x + j*50);
                    im.setLayoutY(y + i*50);

                    im.setFitWidth(40);
                    im.setFitHeight(40);
                }

            }
        }
    }

    //вычисляем в какую ячейку ставится цель
    private void setTarget (MouseEvent event){
        Target.j = (int)((event.getSceneX() - 90) / 50);
        Target.i = (int)((event.getSceneY() - 105) / 50);

        Target.x = Target.j * 50 + 90 - 13;
        Target.y = Target.i * 50 + 105 - 12;

        Target.isSet = !Target.isSet;
    }
}

