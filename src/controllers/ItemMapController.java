package controllers;

import models.ItemMapModel;
import models.Terrain;
import views.GameView;

/**
 * Created by KhoaBeo on 3/10/2017.
 */
public class ItemMapController extends GameController {

    public ItemMapController(int x, int y, Terrain terrain, String url) {
        super(new ItemMapModel(x, y, terrain), new GameView(url));
    }

    @Override
    public void run() {

    }
}
