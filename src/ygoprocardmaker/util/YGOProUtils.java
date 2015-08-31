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
        int code = 0;
        code |= card.issTDestroy() ? 1 : 0;
        code |= card.isDestroyMonster() ? 1 << 1 : 0;
        code |= card.isBanish() ? 1 << 2 : 0;
        code |= card.isGraveyard() ? 1 << 3 : 0;
        code |= card.isBacktoHand() ? 1 << 4 : 0;
        code |= card.isBackToDeck() ? 1 << 5 : 0;
        code |= card.isDestroyHand() ? 1 << 6 : 0;
        code |= card.isDestroyDeck() ? 1 << 7 : 0;
        code |= card.isDraw() ? 1 << 8 : 0;
        code |= card.isSearch() ? 1 << 9 : 0;
        code |= card.isRecovery() ? 1 << 10 : 0;
        code |= card.isPosition() ? 1 << 11 : 0;
        code |= card.isControl() ? 1 << 12 : 0;
        code |= card.isChangeATKDEF() ? 1 << 13 : 0;
        code |= card.isPiercing() ? 1 << 14 : 0;
        code |= card.isRepeatAttack() ? 1 << 15 : 0;
        code |= card.isLimitAttack() ? 1 << 16 : 0;
        code |= card.isDirectAttack() ? 1 << 17 : 0;
        code |= card.isSpecialSummon() ? 1 << 18 : 0;
        code |= card.isToken() ? 1 << 19 : 0;
        code |= card.isTypeRelated() ? 1 << 20 : 0;
        code |= card.isPropertyRelated() ? 1 << 21 : 0;
        code |= card.isDamageLP() ? 1 << 22 : 0;
        code |= card.isRecoveryLP() ? 1 << 23 : 0;
        code |= card.isDestroy() ? 1 << 24 : 0;
        code |= card.isSelect() ? 1 << 25 : 0;
        code |= card.isCounter() ? 1 << 26 : 0;
        code |= card.isGamble() ? 1 << 27 : 0;
        code |= card.isFusionRelated() ? 1 << 28 : 0;
        code |= card.isTunerRelated() ? 1 << 29 : 0;
        code |= card.isXyzRelated() ? 1 << 30 : 0;
        code |= card.isNegateEffect() ? 1 << 31 : 0;
        return "" + code;
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
