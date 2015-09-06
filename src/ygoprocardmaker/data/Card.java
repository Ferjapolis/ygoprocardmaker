package ygoprocardmaker.data;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import org.json.JSONObject;
import ygoprocardmaker.util.ImageUtils;
import ygoprocardmaker.util.RegexUtils;

/**
 *
 * @author Simão Reis <dracostriker@hotmail.com>
 */
public class Card {

    private final int id;

    // Card Info
    private String name;

    private String type;

    private String subType;

    private String subSubType;

    private String attribute;

    private String levelRank;
    
    private String leftScale;
    
    private String rightScale;

    private String monsterType;

    private String atk;

    private String def;

    private String serial;

    private String loreEffect;

    private Image picture;

    // YGOPro Info
    private String alias;

    private String archtype;

    private String secondaryArchtype;

    private String format;

    private boolean sTDestroy;

    private boolean backtoHand;

    private boolean draw;

    private boolean control;

    private boolean limitAttack;

    private boolean typeRelated;

    private boolean destroy;

    private boolean fusionRelated;

    private boolean destroyMonster;

    private boolean backToDeck;

    private boolean search;

    private boolean changeATKDEF;

    private boolean directAttack;

    private boolean propertyRelated;

    private boolean select;

    private boolean tunerRelated;

    private boolean banish;

    private boolean destroyHand;

    private boolean recovery;

    private boolean piercing;

    private boolean specialSummon;

    private boolean damageLP;

    private boolean counter;

    private boolean xyzRelated;

    private boolean graveyard;

    private boolean destroyDeck;

    private boolean position;

    private boolean repeatAttack;

    private boolean token;

    private boolean recoveryLP;

    private boolean gamble;

    private boolean negateEffect;

    private String string1;

    private String string2;

    private String string3;

    private String string4;

    private String string5;

    private String string6;

    private String string7;

    private String string8;

    private String string9;

    private String string10;

    private String string11;

    private String string12;

    private String string13;

    private String string14;

    private String string15;

    private String string16;

    // Card Script
    private String script;

    public Card(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getSubType() {
        return subType;
    }

    public String getSubSubType() {
        return subSubType;
    }

    public String getAttribute() {
        return attribute;
    }

    public String getLevelRank() {
        return levelRank;
    }

    public String getLeftScale() {
        return leftScale;
    }

    public String getRightScale() {
        return rightScale;
    }

    public String getMonsterType() {
        return monsterType;
    }

    public String getAtk() {
        return atk;
    }

    public String getDef() {
        return def;
    }

    public String getSerial() {
        return serial;
    }

    public String getLoreEffect() {
        return loreEffect;
    }

    public Image getPicture() {
        return picture;
    }

    public String getAlias() {
        return alias;
    }

    public String getArchtype() {
        return archtype;
    }

    public String getSecondaryArchtype() {
        return secondaryArchtype;
    }

    public String getFormat() {
        return format;
    }

    public boolean issTDestroy() {
        return sTDestroy;
    }

    public boolean isBacktoHand() {
        return backtoHand;
    }

    public boolean isDraw() {
        return draw;
    }

    public boolean isControl() {
        return control;
    }

    public boolean isLimitAttack() {
        return limitAttack;
    }

    public boolean isTypeRelated() {
        return typeRelated;
    }

    public boolean isDestroy() {
        return destroy;
    }

    public boolean isFusionRelated() {
        return fusionRelated;
    }

    public boolean isDestroyMonster() {
        return destroyMonster;
    }

    public boolean isBackToDeck() {
        return backToDeck;
    }

    public boolean isSearch() {
        return search;
    }

    public boolean isChangeATKDEF() {
        return changeATKDEF;
    }

    public boolean isDirectAttack() {
        return directAttack;
    }

    public boolean isPropertyRelated() {
        return propertyRelated;
    }

    public boolean isSelect() {
        return select;
    }

    public boolean isTunerRelated() {
        return tunerRelated;
    }

    public boolean isBanish() {
        return banish;
    }

    public boolean isDestroyHand() {
        return destroyHand;
    }

    public boolean isRecovery() {
        return recovery;
    }

    public boolean isPiercing() {
        return piercing;
    }

    public boolean isSpecialSummon() {
        return specialSummon;
    }

    public boolean isDamageLP() {
        return damageLP;
    }

    public boolean isCounter() {
        return counter;
    }

    public boolean isXyzRelated() {
        return xyzRelated;
    }

    public boolean isGraveyard() {
        return graveyard;
    }

    public boolean isDestroyDeck() {
        return destroyDeck;
    }

    public boolean isPosition() {
        return position;
    }

    public boolean isRepeatAttack() {
        return repeatAttack;
    }

    public boolean isToken() {
        return token;
    }

    public boolean isRecoveryLP() {
        return recoveryLP;
    }

    public boolean isGamble() {
        return gamble;
    }

    public boolean isNegateEffect() {
        return negateEffect;
    }

    public String getString1() {
        return string1;
    }

    public String getString2() {
        return string2;
    }

    public String getString3() {
        return string3;
    }

    public String getString4() {
        return string4;
    }

    public String getString5() {
        return string5;
    }

    public String getString6() {
        return string6;
    }

    public String getString7() {
        return string7;
    }

    public String getString8() {
        return string8;
    }

    public String getString9() {
        return string9;
    }

    public String getString10() {
        return string10;
    }

    public String getString11() {
        return string11;
    }

    public String getString12() {
        return string12;
    }

    public String getString13() {
        return string13;
    }

    public String getString14() {
        return string14;
    }

    public String getString15() {
        return string15;
    }

    public String getString16() {
        return string16;
    }

    public String getScript() {
        return script;
    }

    public Card setName(String name) {
        this.name = name;
        return this;
    }

    public Card setType(String type) {
        this.type = type;
        return this;
    }

    public Card setSubType(String subType) {
        this.subType = subType;
        return this;
    }

    public Card setSubSubType(String subSubType) {
        this.subSubType = subSubType;
        return this;
    }

    public Card setAttribute(String attribute) {
        this.attribute = attribute;
        return this;
    }

    public Card setLevelRank(String levelRank) {
        this.levelRank = levelRank;
        return this;
    }

    public Card setLeftScale(String leftScale) {
        this.leftScale = leftScale;
        return this;
    }

    public Card setRightScale(String rightScale) {
        this.rightScale = rightScale;
        return this;
    }

    public Card setMonsterType(String monsterType) {
        this.monsterType = monsterType;
        return this;
    }

    public Card setAtk(String atk) {
        this.atk = atk;
        return this;
    }

    public Card setDef(String def) {
        this.def = def;
        return this;
    }

    public Card setSerial(String serial) {
        this.serial = serial;
        return this;
    }

    public Card setLoreEffect(String loreEffect) {
        this.loreEffect = loreEffect;
        return this;
    }

    public Card setAlias(String alias) {
        this.alias = alias;
        return this;
    }

    public Card setArchtype(String archtype) {
        this.archtype = archtype;
        return this;
    }

    public Card setSecondaryArchtype(String secondaryArchtype) {
        this.secondaryArchtype = secondaryArchtype;
        return this;
    }

    public Card setFormat(String format) {
        this.format = format;
        return this;
    }

    public Card setsTDestroy(boolean sTDestroy) {
        this.sTDestroy = sTDestroy;
        return this;
    }

    public Card setBacktoHand(boolean backtoHand) {
        this.backtoHand = backtoHand;
        return this;
    }

    public Card setDraw(boolean draw) {
        this.draw = draw;
        return this;
    }

    public Card setControl(boolean control) {
        this.control = control;
        return this;
    }

    public Card setLimitAttack(boolean limitAttack) {
        this.limitAttack = limitAttack;
        return this;
    }

    public Card setTypeRelated(boolean typeRelated) {
        this.typeRelated = typeRelated;
        return this;
    }

    public Card setDestroy(boolean destroy) {
        this.destroy = destroy;
        return this;
    }

    public Card setFusionRelated(boolean fusionRelated) {
        this.fusionRelated = fusionRelated;
        return this;
    }

    public Card setDestroyMonster(boolean destroyMonster) {
        this.destroyMonster = destroyMonster;
        return this;
    }

    public Card setBackToDeck(boolean backToDeck) {
        this.backToDeck = backToDeck;
        return this;
    }

    public Card setSearch(boolean search) {
        this.search = search;
        return this;
    }

    public Card setChangeATKDEF(boolean changeATKDEF) {
        this.changeATKDEF = changeATKDEF;
        return this;
    }

    public Card setDirectAttack(boolean directAttack) {
        this.directAttack = directAttack;
        return this;
    }

    public Card setPropertyRelated(boolean propertyRelated) {
        this.propertyRelated = propertyRelated;
        return this;
    }

    public Card setSelect(boolean select) {
        this.select = select;
        return this;
    }

    public Card setTunerRelated(boolean tunerRelated) {
        this.tunerRelated = tunerRelated;
        return this;
    }

    public Card setBanish(boolean banish) {
        this.banish = banish;
        return this;
    }

    public Card setDestroyHand(boolean destroyHand) {
        this.destroyHand = destroyHand;
        return this;
    }

    public Card setRecovery(boolean recovery) {
        this.recovery = recovery;
        return this;
    }

    public Card setPiercing(boolean piercing) {
        this.piercing = piercing;
        return this;
    }

    public Card setSpecialSummon(boolean specialSummon) {
        this.specialSummon = specialSummon;
        return this;
    }

    public Card setDamageLP(boolean damageLP) {
        this.damageLP = damageLP;
        return this;
    }

    public Card setCounter(boolean counter) {
        this.counter = counter;
        return this;
    }

    public Card setXyzRelated(boolean xyzRelated) {
        this.xyzRelated = xyzRelated;
        return this;
    }

    public Card setGraveyard(boolean graveyard) {
        this.graveyard = graveyard;
        return this;
    }

    public Card setDestroyDeck(boolean destroyDeck) {
        this.destroyDeck = destroyDeck;
        return this;
    }

    public Card setPosition(boolean position) {
        this.position = position;
        return this;
    }

    public Card setRepeatAttack(boolean repeatAttack) {
        this.repeatAttack = repeatAttack;
        return this;
    }

    public Card setToken(boolean token) {
        this.token = token;
        return this;
    }

    public Card setRecoveryLP(boolean recoveryLP) {
        this.recoveryLP = recoveryLP;
        return this;
    }

    public Card setGamble(boolean gamble) {
        this.gamble = gamble;
        return this;
    }

    public Card setNegateEffect(boolean negateEffect) {
        this.negateEffect = negateEffect;
        return this;
    }

    public Card setString1(String string1) {
        this.string1 = string1;
        return this;
    }

    public Card setString2(String string2) {
        this.string2 = string2;
        return this;
    }

    public Card setString3(String string3) {
        this.string3 = string3;
        return this;
    }

    public Card setString4(String string4) {
        this.string4 = string4;
        return this;
    }

    public Card setString5(String string5) {
        this.string5 = string5;
        return this;
    }

    public Card setString6(String string6) {
        this.string6 = string6;
        return this;
    }

    public Card setString7(String string7) {
        this.string7 = string7;
        return this;
    }

    public Card setString8(String string8) {
        this.string8 = string8;
        return this;
    }

    public Card setString9(String string9) {
        this.string9 = string9;
        return this;
    }

    public Card setString10(String string10) {
        this.string10 = string10;
        return this;
    }

    public Card setString11(String string11) {
        this.string11 = string11;
        return this;
    }

    public Card setString12(String string12) {
        this.string12 = string12;
        return this;
    }

    public Card setString13(String string13) {
        this.string13 = string13;
        return this;
    }

    public Card setString14(String string14) {
        this.string14 = string14;
        return this;
    }

    public Card setString15(String string15) {
        this.string15 = string15;
        return this;
    }

    public Card setString16(String string16) {
        this.string16 = string16;
        return this;
    }

    public Card setScript(String script) {
        this.script = script;
        return this;
    }

    public Card setPicture(Image picture) {
        this.picture = picture;
        return this;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Card other = (Card) obj;
        return this.id == other.id;
    }

    public static JSONObject toJSON(Card card) {
        JSONObject json = new JSONObject(card);
        json.put("picture", card.picture != null ? ImageUtils.toString(card.picture) : JSONObject.NULL);
        json.put("sTDestroy", card.sTDestroy);
        return json;
    }

    public static Card fromJSON(JSONObject json) {
        return new Card(json.getInt("id"))
                .setName(json.getString("name"))
                .setType(json.getString("type"))
                .setSubType(json.getString("subType"))
                .setSubSubType(json.getString("subSubType"))
                .setAttribute(json.getString("attribute"))
                .setLevelRank(json.getString("levelRank"))
                .setLeftScale(json.getString("leftScale"))
                .setRightScale(json.getString("rightScale"))
                .setMonsterType(json.getString("monsterType"))
                .setAtk(RegexUtils.isPositiveInteger(json.getString("atk")) ? json.getString("atk") : "")
                .setDef(RegexUtils.isPositiveInteger(json.getString("def")) ? json.getString("def") : "")
                .setLoreEffect(json.getString("loreEffect"))
                .setSerial(RegexUtils.isPositiveInteger(json.getString("serial")) ? json.getString("serial") : "")
                .setAlias(RegexUtils.isPositiveInteger(json.getString("alias")) ? json.getString("alias") : "")
                .setArchtype(json.getString("archtype"))
                .setSecondaryArchtype(json.getString("secondaryArchtype"))
                .setFormat(json.getString("format"))
                .setsTDestroy(json.getBoolean("sTDestroy"))
                .setBacktoHand(json.getBoolean("backtoHand"))
                .setDraw(json.getBoolean("draw"))
                .setControl(json.getBoolean("control"))
                .setLimitAttack(json.getBoolean("limitAttack"))
                .setTypeRelated(json.getBoolean("typeRelated"))
                .setDestroy(json.getBoolean("destroy"))
                .setFusionRelated(json.getBoolean("fusionRelated"))
                .setDestroyMonster(json.getBoolean("destroyMonster"))
                .setBackToDeck(json.getBoolean("backToDeck"))
                .setSearch(json.getBoolean("search"))
                .setChangeATKDEF(json.getBoolean("changeATKDEF"))
                .setDirectAttack(json.getBoolean("directAttack"))
                .setPropertyRelated(json.getBoolean("propertyRelated"))
                .setSelect(json.getBoolean("select"))
                .setTunerRelated(json.getBoolean("tunerRelated"))
                .setBanish(json.getBoolean("banish"))
                .setDestroyHand(json.getBoolean("destroyHand"))
                .setRecovery(json.getBoolean("recovery"))
                .setPiercing(json.getBoolean("piercing"))
                .setSpecialSummon(json.getBoolean("specialSummon"))
                .setDamageLP(json.getBoolean("damageLP"))
                .setCounter(json.getBoolean("counter"))
                .setXyzRelated(json.getBoolean("xyzRelated"))
                .setGraveyard(json.getBoolean("graveyard"))
                .setDestroyDeck(json.getBoolean("destroyDeck"))
                .setPosition(json.getBoolean("position"))
                .setRepeatAttack(json.getBoolean("repeatAttack"))
                .setToken(json.getBoolean("token"))
                .setRecoveryLP(json.getBoolean("recoveryLP"))
                .setGamble(json.getBoolean("gamble"))
                .setNegateEffect(json.getBoolean("negateEffect"))
                .setString1(json.getString("string1"))
                .setString2(json.getString("string2"))
                .setString3(json.getString("string3"))
                .setString4(json.getString("string4"))
                .setString5(json.getString("string5"))
                .setString6(json.getString("string6"))
                .setString7(json.getString("string7"))
                .setString8(json.getString("string8"))
                .setString9(json.getString("string9"))
                .setString10(json.getString("string10"))
                .setString11(json.getString("string11"))
                .setString12(json.getString("string12"))
                .setString13(json.getString("string13"))
                .setString14(json.getString("string14"))
                .setString15(json.getString("string15"))
                .setString16(json.getString("string16"))
                .setScript(json.getString("script"))
                .setPicture(!json.isNull("picture") ? ImageUtils.fromString(json.getString("picture")) : null);
    }

    public static boolean differ(Card card1, Card card2) {
        return !card1.name.equals(card2.name)
                || !card1.type.equals(card2.type)
                || !card1.subType.equals(card2.subType)
                || !card1.subSubType.equals(card2.subSubType)
                || !card1.attribute.equals(card2.attribute)
                || !card1.levelRank.equals(card2.levelRank)
                || !card1.leftScale.equals(card2.leftScale)
                || !card1.rightScale.equals(card2.rightScale)
                || !card1.monsterType.equals(card2.monsterType)
                || !card1.atk.equals(card2.atk)
                || !card1.def.equals(card2.def)
                || !card1.serial.equals(card2.serial)
                || !card1.loreEffect.equals(card2.loreEffect)
                || !card1.alias.equals(card2.alias)
                || !card1.archtype.equals(card2.archtype)
                || !card1.secondaryArchtype.equals(card2.secondaryArchtype)
                || !card1.format.equals(card2.format)
                || card1.sTDestroy != card2.sTDestroy
                || card1.backtoHand != card2.backtoHand
                || card1.draw != card2.draw
                || card1.control != card2.control
                || card1.limitAttack != card2.limitAttack
                || card1.typeRelated != card2.typeRelated
                || card1.destroy != card2.destroy
                || card1.fusionRelated != card2.fusionRelated
                || card1.destroyMonster != card2.destroyMonster
                || card1.backToDeck != card2.backToDeck
                || card1.search != card2.search
                || card1.changeATKDEF != card2.changeATKDEF
                || card1.directAttack != card2.directAttack
                || card1.propertyRelated != card2.propertyRelated
                || card1.select != card2.select
                || card1.tunerRelated != card2.tunerRelated
                || card1.banish != card2.banish
                || card1.destroyHand != card2.destroyHand
                || card1.recovery != card2.recovery
                || card1.piercing != card2.piercing
                || card1.specialSummon != card2.specialSummon
                || card1.damageLP != card2.damageLP
                || card1.counter != card2.counter
                || card1.xyzRelated != card2.xyzRelated
                || card1.graveyard != card2.graveyard
                || card1.destroyDeck != card2.destroyDeck
                || card1.position != card2.position
                || card1.repeatAttack != card2.repeatAttack
                || card1.token != card2.token
                || card1.recoveryLP != card2.recoveryLP
                || card1.gamble != card2.gamble
                || card1.negateEffect != card2.negateEffect
                || !card1.string1.equals(card2.string1)
                || !card1.string2.equals(card2.string2)
                || !card1.string3.equals(card2.string3)
                || !card1.string4.equals(card2.string4)
                || !card1.string5.equals(card2.string5)
                || !card1.string6.equals(card2.string6)
                || !card1.string7.equals(card2.string7)
                || !card1.string8.equals(card2.string8)
                || !card1.string9.equals(card2.string9)
                || !card1.string10.equals(card2.string10)
                || !card1.string11.equals(card2.string11)
                || !card1.string12.equals(card2.string12)
                || !card1.string13.equals(card2.string13)
                || !card1.string14.equals(card2.string14)
                || !card1.string15.equals(card2.string15)
                || !card1.string16.equals(card2.string16)
                || (card1.picture == null || card2.picture == null ? card1.picture == card2.picture : !ImageUtils.compareImages(SwingFXUtils.fromFXImage(card1.picture, null), SwingFXUtils.fromFXImage(card2.picture, null)))
                || !card1.script.equals(card2.script);
    }

    @Override
    public String toString() {
        return "Card{" + "id=" + id + ", name=" + name + ", type=" + type + ", subType=" + subType + ", subSubType=" + subSubType + ", attribute=" + attribute + ", levelRank=" + levelRank + ", leftScale=" + leftScale + ", rightScale=" + rightScale + ", monsterType=" + monsterType + ", atk=" + atk + ", def=" + def + ", serial=" + serial + ", loreEffect=" + loreEffect + ", picture=" + picture + ", alias=" + alias + ", archtype=" + archtype + ", secondaryArchtype=" + secondaryArchtype + ", format=" + format + ", sTDestroy=" + sTDestroy + ", backtoHand=" + backtoHand + ", draw=" + draw + ", control=" + control + ", limitAttack=" + limitAttack + ", typeRelated=" + typeRelated + ", destroy=" + destroy + ", fusionRelated=" + fusionRelated + ", destroyMonster=" + destroyMonster + ", backToDeck=" + backToDeck + ", search=" + search + ", changeATKDEF=" + changeATKDEF + ", directAttack=" + directAttack + ", propertyRelated=" + propertyRelated + ", select=" + select + ", tunerRelated=" + tunerRelated + ", banish=" + banish + ", destroyHand=" + destroyHand + ", recovery=" + recovery + ", piercing=" + piercing + ", specialSummon=" + specialSummon + ", damageLP=" + damageLP + ", counter=" + counter + ", xyzRelated=" + xyzRelated + ", graveyard=" + graveyard + ", destroyDeck=" + destroyDeck + ", position=" + position + ", repeatAttack=" + repeatAttack + ", token=" + token + ", recoveryLP=" + recoveryLP + ", gamble=" + gamble + ", negateEffect=" + negateEffect + ", string1=" + string1 + ", string2=" + string2 + ", string3=" + string3 + ", string4=" + string4 + ", string5=" + string5 + ", string6=" + string6 + ", string7=" + string7 + ", string8=" + string8 + ", string9=" + string9 + ", string10=" + string10 + ", string11=" + string11 + ", string12=" + string12 + ", string13=" + string13 + ", string14=" + string14 + ", string15=" + string15 + ", string16=" + string16 + ", script=" + script + '}';
    }
}
