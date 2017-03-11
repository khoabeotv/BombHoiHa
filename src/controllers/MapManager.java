package controllers;

import models.ItemMapModel;
import models.Terrain;
import program.GameManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by KhoaBeo on 3/10/2017.
 */
public class MapManager extends ControllerManager {

    public void readMap(int mapLevel) {
        try {
            List<String> arrRows = new ArrayList<>();
            File file = new File("resources/Map/map-" + mapLevel + ".txt");
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String row = bufferedReader.readLine();
            while (row != null) {
                arrRows.add(row);
                row = bufferedReader.readLine();
            }
            bufferedReader.close();

            for (int i = 0; i < arrRows.size(); i++) {
                String[] r = arrRows.get(i).split(",");
                for (int j = 0; j < r.length; j++) {
                    int bit = Integer.parseInt(r[j] + "");
                    int x = j * ItemMapModel.SIZE_TILED;
                    int y = i * ItemMapModel.SIZE_TILED;
                    Terrain terrain;
                    if (bit < 2) {
                        terrain = Terrain.LAND;
                    } else {
                        terrain = Terrain.BLOCK;
                    }
                    GameController itemMapController = new ItemMapController(x, y, terrain, "Map/map-" + mapLevel + "/" + bit);
                    add(itemMapController);
                    if (terrain == Terrain.BLOCK) {
                        GameManager.arrBlocks.add(itemMapController);
                    }
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<GameController> getGameControllers() {
        return gameControllers;
    }
}
