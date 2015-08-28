package ygoprocardmaker.util;

import java.util.List;
import ygoprocardmaker.data.Archtype;
import ygoprocardmaker.data.Card;
import ygoprocardmaker.enumerate.CardAttribute;
import ygoprocardmaker.enumerate.CardFormat;
import ygoprocardmaker.enumerate.CardMonsterType;
import ygoprocardmaker.enumerate.CardType;

/**
 *
 * @author Simão Reis <dracostriker@hotmail.com>
 */
public class YGOProUtils {

    public static String computeSerial(Card card) {
        return card.getSerial();
    }

    public static String computeName(Card card) {
        return card.getName();
    }

    public static String computeLoreEffect(Card card) {
        return card.getLoreEffect();
    }

    public static String computeFormat(Card card) {
        return "" + CardFormat.code(card.getFormat());
    }

    public static String computeAlias(Card card) {
        return card.getAlias().equals("") ? "0" : card.getAlias();
    }

    public static String computeArchtype(Card card, List<Archtype> archtypes) {
        if (archtypes.isEmpty()) {
            return "0";
        }
        String code = archtypes.get(archtypes.indexOf(new Archtype(card.getArchtype()))).getCode() + archtypes.get(archtypes.indexOf(new Archtype(card.getArchtype()))).getCode();
        if (code.equals("")) {
            return "0";
        } else {
            return code;
        }
    }

    public static String computeType(Card card) {
        return "" + CardType.code(card.getType(), card.getSubType(), card.getSubSubType());
    }

    public static String computeATK(Card card) {
        return card.getAtk().equals("") ? "0" : card.getAtk();
    }

    public static String computeDEF(Card card) {
        return card.getDef().equals("") ? "0" : card.getDef();
    }

    public static String computeLevelRank(Card card) {
        return card.getLevelRank().equals("") ? "0" : card.getLevelRank();
    }

    public static String computeMonsterType(Card card) {
        return "" + CardMonsterType.code(card.getMonsterType());
    }

    public static String computeMonsterAttribute(Card card) {
        return "" + CardAttribute.code(card.getAttribute());
    }

    public static String computeEffectCategories(Card card) {
        return "0"; //TODO
    }

    public static String computeString1(Card card) {
        return card.getString1().equals("") ? " " : card.getString1();
    }

    public static String computeString2(Card card) {
        return card.getString2().equals("") ? " " : card.getString2();
    }

    public static String computeString3(Card card) {
        return card.getString3().equals("") ? " " : card.getString3();
    }

    public static String computeString4(Card card) {
        return card.getString4().equals("") ? " " : card.getString4();
    }

    public static String computeString5(Card card) {
        return card.getString5().equals("") ? " " : card.getString5();
    }

    public static String computeString6(Card card) {
        return card.getString6().equals("") ? " " : card.getString6();
    }

    public static String computeString7(Card card) {
        return card.getString7().equals("") ? " " : card.getString7();
    }

    public static String computeString8(Card card) {
        return card.getString8().equals("") ? " " : card.getString8();
    }

    public static String computeString9(Card card) {
        return card.getString9().equals("") ? " " : card.getString9();
    }

    public static String computeString10(Card card) {
        return card.getString10().equals("") ? " " : card.getString10();
    }

    public static String computeString11(Card card) {
        return card.getString11().equals("") ? " " : card.getString11();
    }

    public static String computeString12(Card card) {
        return card.getString12().equals("") ? " " : card.getString12();
    }

    public static String computeString13(Card card) {
        return card.getString13().equals("") ? " " : card.getString13();
    }

    public static String computeString14(Card card) {
        return card.getString14().equals("") ? " " : card.getString14();
    }

    public static String computeString15(Card card) {
        return card.getString15().equals("") ? " " : card.getString15();
    }

    public static String computeString16(Card card) {
        return card.getString16().equals("") ? " " : card.getString16();
    }

}
