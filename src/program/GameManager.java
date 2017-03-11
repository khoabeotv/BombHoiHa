package program;

import controllers.ControllerManager;
import controllers.GameController;
import controllers.MapManager;
import controllers.PlayerController;
import models.PlayerModel;
import views.PlayerView;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by KhoaBeo on 3/9/2017.
 */
public class GameManager {

    public static final ControllerManager controllerManager = new ControllerManager();
    public static final List<GameController> arrBlocks = new ArrayList<>();
    private ControllerManager mapManager;
    private GameController playerController;

    public GameManager() {
        mapManager = new MapManager();
        ((MapManager) mapManager).readMap(1);

        playerController = new PlayerController(
                new PlayerModel(0, 50),
                new PlayerView(),
                arrBlocks
        );
    }

    public void run() {
        mapManager.run();
        controllerManager.run();
    }

    public void draw(Graphics graphics) {
        mapManager.draw(graphics);
        controllerManager.draw(graphics);
    }

    public GameController getPlayerController() {
        return playerController;
    }
}