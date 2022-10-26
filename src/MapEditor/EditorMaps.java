package MapEditor;

import Level.Map;
import Maps.Level1;
import Maps.Level2;
import Maps.Level3;
import Maps.Level4;
import Maps.Level5;
import Maps.Level6;
import Maps.Level7;
import Maps.Level8;
import Maps.Level9;
import Maps.TestMap;
import Maps.TitleScreenMap;

import java.util.ArrayList;

public class EditorMaps {
	public static ArrayList<String> getMapNames() {
		return new ArrayList<String>() {
			{
				add("TestMap");
				add("Level1");
				add("Level2");
				add("Level3");
				add("Level4");
				add("Level5");
				add("Level6");
				add("Level7");
				add("Level8");
				add("Level9");
				add("TitleScreen");
			}
		};
	}

	public static Map getMapByName(String mapName) {
		switch (mapName) {
		case "TestMap":
			return new TestMap(); 
		case "Level1":
			return new Level1();
		case "Level2":
			return new Level2();
		case "Level3":
			return new Level3();
		case "Level4":
			return new Level4();
		case "Level5":
			return new Level5();
		case "Level6":
			return new Level6();
		case "Level7":
			return new Level7();
		case "Level8":
			return new Level8();
		case "Level9":
			return new Level9();
		case "TitleScreen":
			return new TitleScreenMap();

		default:
			throw new RuntimeException("Unrecognized map name");
		}
	}
}
