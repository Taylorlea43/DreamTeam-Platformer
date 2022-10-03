package MapEditor;

import Level.Map;
import Maps.Level1;
import Maps.Level2;
import Maps.Level3;
import Maps.TitleScreenMap;

import java.util.ArrayList;

public class EditorMaps {
    public static ArrayList<String> getMapNames() {
        return new ArrayList<String>() {{
            add("TestMap");
            add("Level2");
            add("Level3");
            add("TitleScreen");
        }};
    }

    public static Map getMapByName(String mapName) {
        switch(mapName) {
            case "TestMap":
                return new Level1();
            case "Level2":
                return new Level2();
            case "Level3":
                return new Level3();
            case "TitleScreen":
                return new TitleScreenMap();
           
            default:
                throw new RuntimeException("Unrecognized map name");
        }
    }
}
