package ygoprocardmaker.enumerate;

import javafx.collections.ObservableList;
import ygoprocardmaker.util.CollectionsUtil;

/**
 *
 * @author Simão Reis <dracostriker@hotmail.com>
 */
public class CardMonsterType {

    public static final ObservableList<String> MONSTER_TYPES = CollectionsUtil.unmodifiableList("Warrior", "Spellcaster", "Fairy", "Fiend", "Zombie", "Machine", "Aqua", "Pyro", "Rock", "Winged-beast", "Plant", "Insect", "Thunder", "Dragon", "Beast", "Beast-Warrior", "Dinosaur", "Fish", "Sea Serpent", "Reptile", "Psychic", "Divine-beast", "Creator God", "Wyrm");

    public static int code(String attribute) {
        switch (attribute) {
            case "Warrior":
                return 1;
            case "Spellcaster":
                return 2;
            case "Fairy":
                return 4;
            case "Fiend":
                return 8;
            case "Zombie": 
                return 16;
            case "Machine":
                return 32;
            case "Aqua":
                return 64;
            case "Pyro":
                return 128;
            case "Rock":
                return 256;
            case "Winged-beast":
                return 512;
            case "Plant":
                return 1024;
            case "Insect":
                return 2048;
            case "Thunder":
                return 4096;
            case "Dragon":
                return 8192;
            case "Beast": 
                return 16384;
            case "Beast-Warrior":
                return 32768;
            case "Dinosaur":
                return 65536;
            case "Fish":
                return 131072;
            case "Sea Serpent":
                return 262144;
            case "Reptile":
                return 524288;
            case "Psychic":
                return 1048576;
            case "Divine-beast": 
                return 2097152;
            case "Creator God":
                return 4194304;
            case "Wyrm":
                return 8388608;
            default:
                return 0;
        }
    }

    public static String attribute(int code) {
        switch (code) {
            case 1:
                return "Warrior";
            case 2:
                return "Spellcaster";
            case 4:
                return "Fairy";
            case 8:
                return "Fiend";
            case 16: 
                return "Zombie";
            case 32:
                return "Machine";
            case 64:
                return "Aqua";
            case 128:
                return "Pyro";
            case 256:
                return "Rock";
            case 512:
                return "Winged-beast";
            case 1024:
                return "Plant";
            case 2048:
                return "Insect";
            case 4096:
                return "Thunder";
            case 8192:
                return "Dragon";
            case 16384: 
                return "Beast";
            case 32768:
                return "Beast-Warrior";
            case 65536:
                return "Dinosaur";
            case 131072:
                return "Fish";
            case 262144:
                return "Sea Serpent";
            case 524288:
                return "Reptile";
            case 1048576:
                return "Psychic";
            case 2097152: 
                return "Divine-beast";
            case 4194304:
                return "Creator God";
            case 8388608:
                return "Wyrm";
            default:
                throw new IllegalArgumentException();
        }
    }

}
