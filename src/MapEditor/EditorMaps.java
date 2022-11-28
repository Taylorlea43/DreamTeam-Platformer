package MapEditor;

import Level.Map;
import Maps.GameCompleteMap;
import Maps.Level1;
import Maps.Level10;
import Maps.Level1Complete;
import Maps.Level2;
import Maps.Level3;
import Maps.Level4;
import Maps.Level5;
import Maps.Level6;
import Maps.Level7;
import Maps.Level8;
import Maps.Level9;
import Maps.LevelComplete;
import Maps.TestMap;
import Maps.TitleScreenMap;
import Screens.GameWonScreen;

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
				add("Level10");
				add("TitleScreen");
				add("GameWon");
				add("TutorialComplete");
				add("Level1Complete");
				add("Level2Complete");
				add("Level3Complete");
				add("Level4Complete");
				add("Level5Complete");
				add("Level6Complete");
				add("Level7Complete");
				add("Level8Complete");
				add("Level9Complete");
				add("Level10Complete");
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
		case "Level10":
			return new Level10();
		case "TitleScreen":
			return new TitleScreenMap();
		case "GameWon":
			return new GameCompleteMap();
		case "TutorialComplete":
			return new Level1Complete();
		case "Level1Complete":
			return new Level1Complete();
		case "Level2Complete":
			return new Level1Complete();
		case "Level3Complete":
			return new Level1Complete();
		case "Level4Complete":
			return new Level1Complete();
		case "Level5Complete":
			return new Level1Complete();
		case "Level6Complete":
			return new Level1Complete();
		case "Level7Complete":
			return new Level1Complete();
		case "Level8Complete":
			return new Level1Complete();
		case "Level9Complete":
			return new Level1Complete();
		case "Level10Complete":
			return new Level1Complete();
		default:
			throw new RuntimeException("Unrecognized map name");
		}
	}
}
