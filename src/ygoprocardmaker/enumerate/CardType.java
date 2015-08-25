package ygoprocardmaker.enumerate;

import javafx.collections.ObservableList;
import ygoprocardmaker.util.CollectionsUtil;

/**
 *
 * @author Simão Reis <dracostriker@hotmail.com>
 */
public class CardType {

    public static final ObservableList<String> EMPTY = CollectionsUtil.unmodifiableList("");

    public static final ObservableList<String> CARD_TYPES = CollectionsUtil.unmodifiableList("Monster", "Ritual", "Fusion", "Spell", "Trap", "Synchro", "Xyz", "Pendulum");

    public static final ObservableList<String> MONSTER_SUB_TYPES = CollectionsUtil.unmodifiableList("Normal", "Effect", "Flip", "Toon", "Spirit", "Union", "Gemini");

    public static final ObservableList<String> NORMAL_MONSTER_SUB_SUB_TYPES = CollectionsUtil.unmodifiableList("", "Tuner");

    public static final ObservableList<String> EFFECT_MONSTER_SUB_SUB_TYPES = CollectionsUtil.unmodifiableList("", "Tuner");

    public static final ObservableList<String> FLIP_MONSTER_SUB_SUB_TYPES = CollectionsUtil.unmodifiableList("Effect", "Tuner");

    public static final ObservableList<String> RITUAL_SUB_TYPES = CollectionsUtil.unmodifiableList("", "Effect");

    public static final ObservableList<String> FUSION_SUB_TYPES = CollectionsUtil.unmodifiableList("", "Effect");

    public static final ObservableList<String> SYNCHRO_SUB_TYPES = CollectionsUtil.unmodifiableList("", "Effect", "Tuner");

    public static final ObservableList<String> TUNER_SYNCHRO_SUB_SUB_TYPES = CollectionsUtil.unmodifiableList("Effect");

    public static final ObservableList<String> XYZ_SUB_TYPES = CollectionsUtil.unmodifiableList("", "Effect", "Pendulum");

    public static final ObservableList<String> PENDULUM_XYZ_SUB_SUB_TYPES = CollectionsUtil.unmodifiableList("Effect");

    public static final ObservableList<String> PENDULUM_SUB_TYPES = CollectionsUtil.unmodifiableList("", "Effect", "Tuner");

    public static final ObservableList<String> TUNER_PENDULUM_SUB_SUB_TYPES = CollectionsUtil.unmodifiableList("Effect");

    public static final ObservableList<String> SPELL_TYPES = CollectionsUtil.unmodifiableList("Normal", "Ritual", "Quick-Play", "Continuous", "Equip", "Field");

    public static final ObservableList<String> TRAP_TYPES = CollectionsUtil.unmodifiableList("Normal", "Continuous", "Counter");

    private final String type;

    private final String subtype;

    private final String subsubtype;

    private CardType(String type, String subtype, String subsubtype) {
        this.type = type;
        this.subtype = subtype;
        this.subsubtype = subsubtype;
    }

    private CardType(String type, String subtype) {
        this(type, subtype, "");
    }

    private CardType(String type) {
        this(type, "");
    }

    public static int code(String type, String subtype, String subsubtype /*, String subsubsubtype */) {
        if (type.equals("Monster") && subtype.equals("Normal") && subsubtype.equals("")) {
            return 17;
        } else if (type.equals("Monster") && subtype.equals("Normal") && subsubtype.equals("Tuner")) {
            return 4113;
        } else if (type.equals("Monster") && subtype.equals("Effect") && subsubtype.equals("")) {
            return 33;
        } else if (type.equals("Monster") && subtype.equals("Effect") && subsubtype.equals("Tuner")) {
            return 4129;
        } else if (type.equals("Monster") && subtype.equals("Spirit")) {
            return 545;
        } else if (type.equals("Monster") && subtype.equals("Union")) {
            return 1057;
        } else if (type.equals("Monster") && subtype.equals("Flip") && subsubtype.equals("Effect")) {
            return 2097185;
        } else if (type.equals("Monster") && subtype.equals("Flip") && subsubtype.equals("Tuner") /* && subsubsubtype.equals("Effect") */) {
            return 2101281;
        } else if (type.equals("Monster") && subtype.equals("Toon")) {
            return 4194337;
        } else if (type.equals("Monster") && subtype.equals("Gemini")) {
            return 2081;
        } else if (type.equals("Fusion") && subtype.equals("")) {
            return 65;
        } else if (type.equals("Fusion") && subtype.equals("Effect")) {
            return 97;
        } else if (type.equals("Ritual") && subtype.equals("")) {
            return 129;
        } else if (type.equals("Ritual") && subtype.equals("Effect")) {
            return 161;
        } else if (type.equals("Synchro") && subtype.equals("")) {
            return 8193;
        } else if (type.equals("Synchro") && subtype.equals("Effect")) {
            return 8225;
        } else if (type.equals("Synchro") && subtype.equals("Tuner") /* && subsubtype.equals("Effect") */) {
            return 12321;
        } else if (type.equals("Xyz") && subtype.equals("")) {
            return 8388609;
        } else if (type.equals("Xyz") && subtype.equals("Effect")) {
            return 8388641;
        } else if (type.equals("Xyz") && subtype.equals("Pendulum") /* && subsubtype.equals("Effect") */) {
            return 25165857;
        } else if (type.equals("Pendulum") && subtype.equals("")) {
            return 16777233;
        } else if (type.equals("Pendulum") && subtype.equals("Effect")) {
            return 16777249;
        } else if (type.equals("Pendulum") && subtype.equals("Tuner") /* && subsubtype.equals("Effect") */) {
            return 16781345;
        } else if (type.equals("Spell") && subtype.equals("Normal")) {
            return 2;
        } else if (type.equals("Spell") && subtype.equals("Ritual")) {
            return 130;
        } else if (type.equals("Spell") && subtype.equals("Quick-Play")) {
            return 65538;
        } else if (type.equals("Spell") && subtype.equals("Continuous")) {
            return 131074;
        } else if (type.equals("Spell") && subtype.equals("Equip")) {
            return 262146;
        } else if (type.equals("Spell") && subtype.equals("Field")) {
            return 524290;
        } else if (type.equals("Trap") && subtype.equals("Normal")) {
            return 4;
        } else if (type.equals("Trap") && subtype.equals("Continuous")) {
            return 131076;
        } else if (type.equals("Trap") && subtype.equals("Counter")) {
            return 1048580;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static CardType type(int code) {
        switch (code) {
            case 17:
                return new CardType("Monster", "Normal");
            case 4113:
                return new CardType("Monster", "Normal", "Tuner");
            case 33:
                return new CardType("Monster", "Effect");
            case 4129:
                return new CardType("Monster", "Effect", "Tuner");
            case 545:
                return new CardType("Monster", "Spirit");
            case 1057:
                return new CardType("Monster", "Union");
            case 2097185:
                return new CardType("Monster", "Flip", "Effect");
            case 2101281:
                return new CardType("Monster", "Flip", "Tuner");
            case 4194337:
                return new CardType("Monster", "Toon");
            case 2081:
                return new CardType("Monster", "Gemini");
            case 65:
                return new CardType("Fusion");
            case 97:
                return new CardType("Fusion", "Effect");
            case 129:
                return new CardType("Ritual");
            case 161:
                return new CardType("Ritual", "Effect");
            case 8193:
                return new CardType("Synchro");
            case 8225:
                return new CardType("Synchro", "Effect");
            case 12321:
                return new CardType("Synchro", "Tuner", "Effect");
            case 8388609:
                return new CardType("Xyz");
            case 8388641:
                return new CardType("Xyz", "Effect");
            case 25165857:
                return new CardType("Xyz", "Pendulum", "Effect");
            case 16777233:
                return new CardType("Pendulum");
            case 16777249:
                return new CardType("Pendulum", "Effect");
            case 16781345:
                return new CardType("Pendulum", "Tuner", "Effect");
            case 2:
                return new CardType("Spell", "Normal");
            case 130:
                return new CardType("Spell", "Ritual");
            case 65538:
                return new CardType("Spell", "Quick-Play");
            case 131074:
                return new CardType("Spell", "Continuous");
            case 262146:
                return new CardType("Spell", "Equip");
            case 524290:
                return new CardType("Spell", "Field");
            case 4:
                return new CardType("Trap", "Normal");
            case 131076:
                return new CardType("Spell", "Continuous");
            case 1048580:
                return new CardType("Spell", "Counter");
            default:
                throw new IllegalArgumentException();
        }
    }

    public String getType() {
        return type;
    }

    public String getSubtype() {
        return subtype;
    }

    public String getSubsubtype() {
        return subsubtype;
    }
}
