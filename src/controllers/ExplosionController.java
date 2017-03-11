package controllers;

import models.GameModel;
import models.ItemMapModel;
import program.GameManager;
import views.ExplosionView;

/**
 * Created by KhoaBeo on 3/11/2017.
 */
public class ExplosionController extends GameController {

    public ExplosionController(int x, int y, String url) {
        super(
                new GameModel(x, y, ItemMapModel.SIZE_TILED, ItemMapModel.SIZE_TILED),
                new ExplosionView(url)
                );
        GameManager.controllerManager.add(this);
    }
}
