package ygoprocardmaker;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.DataFormat;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javax.imageio.ImageIO;
import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;
import ygoprocardmaker.data.Card;
import ygoprocardmaker.enumerate.CardAttribute;
import static ygoprocardmaker.enumerate.CardAttribute.*;
import ygoprocardmaker.enumerate.CardFormat;
import static ygoprocardmaker.enumerate.CardLevelRank.*;
import static ygoprocardmaker.enumerate.CardMonsterType.*;
import static ygoprocardmaker.enumerate.CardType.*;
import static ygoprocardmaker.enumerate.CardFormat.*;
import ygoprocardmaker.enumerate.CardMonsterType;
import ygoprocardmaker.enumerate.CardType;
import ygoprocardmaker.util.FileUtils;
import ygoprocardmaker.util.ImageUtils;

/**
 *
 * @author Simão Reis <dracostriker@hotmail.com>
 */
public class YGOProCardMakerController implements Initializable {

    // Card Info
    @FXML
    private ImageView cardPicture;

    @FXML
    private TextField cardName;

    @FXML
    private ChoiceBox<String> cardType;

    @FXML
    private ChoiceBox<String> cardSubType;

    @FXML
    private ChoiceBox<String> cardSubSubType;

    @FXML
    private ChoiceBox<String> cardAttribute;

    @FXML
    private ChoiceBox<String> cardLevelRank;

    @FXML
    private ChoiceBox<String> cardMonsterType;

    @FXML
    private TextField cardATK;

    @FXML
    private TextField cardDEF;

    @FXML
    private Label cardAttributeLabel;

    @FXML
    private Label cardLevelRankLabel;

    @FXML
    private Label cardMonsterTypeLabel;

    @FXML
    private Label cardATKDEFLabel;

    @FXML
    private Label slashLabel;

    @FXML
    private TextField cardSerial;

    @FXML
    private TextArea cardLoreEffect;

    @FXML
    private Label cardLoreEffectLabel;

    //YGOPro Info
    @FXML
    private TextField ygoproAlias;

    @FXML
    private ChoiceBox<String> ygoproArchtype;

    @FXML
    private ChoiceBox<String> ygoproSecondaryArchtype;

    @FXML
    private ChoiceBox<String> ygoproFormat;

    @FXML
    private CheckBox ygoproSTDestroy;

    @FXML
    private CheckBox ygoproBacktoHand;

    @FXML
    private CheckBox ygoproDraw;

    @FXML
    private CheckBox ygoproControl;

    @FXML
    private CheckBox ygoproLimitAttack;

    @FXML
    private CheckBox ygoproTypeRelated;

    @FXML
    private CheckBox ygoproDestroy;

    @FXML
    private CheckBox ygoproFusionRelated;

    @FXML
    private CheckBox ygoproDestroyMonster;

    @FXML
    private CheckBox ygoproBackToDeck;

    @FXML
    private CheckBox ygoproSearch;

    @FXML
    private CheckBox ygoproChangeATKDEF;

    @FXML
    private CheckBox ygoproDirectAttack;

    @FXML
    private CheckBox ygoproPropertyRelated;

    @FXML
    private CheckBox ygoproSelect;

    @FXML
    private CheckBox ygoproTunerRelated;

    @FXML
    private CheckBox ygoproBanish;

    @FXML
    private CheckBox ygoproDestroyHand;

    @FXML
    private CheckBox ygoproRecovery;

    @FXML
    private CheckBox ygoproPiercing;

    @FXML
    private CheckBox ygoproSpecialSummon;

    @FXML
    private CheckBox ygoproDamageLP;

    @FXML
    private CheckBox ygoproCounter;

    @FXML
    private CheckBox ygoproXyzRelated;

    @FXML
    private CheckBox ygoproGraveyard;

    @FXML
    private CheckBox ygoproDestroyDeck;

    @FXML
    private CheckBox ygoproPosition;

    @FXML
    private CheckBox ygoproRepeatAttack;

    @FXML
    private CheckBox ygoproToken;

    @FXML
    private CheckBox ygoproRecoveryLP;

    @FXML
    private CheckBox ygoproGamble;

    @FXML
    private CheckBox ygoproNegateEffect;

    @FXML
    private TextArea ygoproString1;

    @FXML
    private TextArea ygoproString2;

    @FXML
    private TextArea ygoproString3;

    @FXML
    private TextArea ygoproString4;

    @FXML
    private TextArea ygoproString5;

    @FXML
    private TextArea ygoproString6;

    @FXML
    private TextArea ygoproString7;

    @FXML
    private TextArea ygoproString8;

    @FXML
    private TextArea ygoproString9;

    @FXML
    private TextArea ygoproString10;

    @FXML
    private TextArea ygoproString11;

    @FXML
    private TextArea ygoproString12;

    @FXML
    private TextArea ygoproString13;

    @FXML
    private TextArea ygoproString14;

    @FXML
    private TextArea ygoproString15;

    @FXML
    private TextArea ygoproString16;

    // Card Script
    @FXML
    private WebView scriptEditor;

    // Set Info
    @FXML
    private TextField setTitle;

    @FXML
    private TextField setAuthor;

    @FXML
    private TextArea setDescription;

    // Card Table
    @FXML
    private TableView<Card> cardTable;

    @FXML
    private TableColumn<Card, String> nameColumn;

    @FXML
    private TableColumn<Card, String> typeColumn;

    @FXML
    private TableColumn<Card, String> subTypeColumn;

    @FXML
    private TableColumn<Card, String> subSubTypeColumn;

    @FXML
    private TableColumn<Card, String> attributeColumn;

    @FXML
    private TableColumn<Card, String> levelRankColumn;

    @FXML
    private TableColumn<Card, String> monsterTypeColumn;

    @FXML
    private TableColumn<Card, String> atkColumn;

    @FXML
    private TableColumn<Card, String> defColumn;

    @FXML
    private TableColumn<Card, String> loreEffectColumn;

    @FXML
    private TableColumn<Card, String> serialColumn;

    // GUI
    @FXML
    private Accordion cardEditorAccordion;

    @FXML
    private TitledPane cardInfoPane;

    // Internal
    private int currentCardId = 1;

    private String currentCardType = "Monster";

    final private ObservableList<Card> cardData = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeCardInfo();
        initializeYGOProInfo();
        initializeCardScript();
        initializeSetInfo();
        initializeCardTable();
        cardEditorAccordion.setExpandedPane(cardInfoPane);
    }

    private void initializeCardInfo() {
        cardType.getItems().setAll(CARD_TYPES);
        cardType.getSelectionModel().selectFirst();
        cardType.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            currentCardType = cardType.getItems().get(newValue.intValue());
            setCardSubTypes();
        });
        cardSubType.getItems().setAll(MONSTER_SUB_TYPES);
        cardSubType.getSelectionModel().selectFirst();
        cardSubType.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.intValue() < 0) {
                setCardSubSubTypes();
            } else {
                setCardSubSubTypes(cardSubType.getItems().get(newValue.intValue()));
            }
        });
        cardSubSubType.getItems().setAll(NORMAL_MONSTER_SUB_SUB_TYPES);
        cardSubSubType.getSelectionModel().selectFirst();
        cardAttribute.getItems().setAll(ATTRIBUTES);
        cardAttribute.getSelectionModel().selectFirst();
        cardLevelRank.getItems().setAll(LEVEL_RANKS);
        cardLevelRank.getSelectionModel().select(4);
        cardMonsterType.getItems().setAll(MONSTER_TYPES);
        cardMonsterType.getSelectionModel().selectFirst();
        BufferedImage bufferedImage;
        try {
            bufferedImage = ImageIO.read(new File(FileUtils.getApplicationPath() + File.separator + "textures" + File.separator + "unknown.png"));
        } catch (IOException ex) {
            Alert dialog = new Alert(Alert.AlertType.ERROR);
            dialog.setHeaderText("Couldn't open file!");
            dialog.setContentText("Check if another process is using the file.");
            dialog.showAndWait();
            System.exit(0);
            return;
        }
        cardPicture.setImage(SwingFXUtils.toFXImage(bufferedImage, null));
    }

    private void initializeYGOProInfo() {
        ygoproArchtype.getItems().setAll(EMPTY);
        ygoproArchtype.getSelectionModel().selectFirst();
        ygoproSecondaryArchtype.getItems().setAll(EMPTY);
        ygoproSecondaryArchtype.getSelectionModel().selectFirst();
        ygoproFormat.getItems().setAll(FORMATS);
        ygoproFormat.getSelectionModel().selectFirst();
    }

    private void initializeCardScript() {
        scriptEditor.getEngine().load("file:///" + FileUtils.getApplicationPath() + File.separator + "ace" + File.separator + "index.html");
        ((JSObject) scriptEditor.getEngine().executeScript("window")).setMember("java", new Object() {
            public void paste() {
                String content = (String) Clipboard.getSystemClipboard().getContent(DataFormat.PLAIN_TEXT);
                if (content != null) {
                    scriptEditor.getEngine().executeScript("editor.onPaste(\"" + content.replace("\n", "\\n") + "\");");
                }
            }
        });
    }

    private void initializeSetInfo() {
    }

    private void initializeCardTable() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        subTypeColumn.setCellValueFactory(new PropertyValueFactory<>("subType"));
        subSubTypeColumn.setCellValueFactory(new PropertyValueFactory<>("subSubType"));
        attributeColumn.setCellValueFactory(new PropertyValueFactory<>("attribute"));
        levelRankColumn.setCellValueFactory(new PropertyValueFactory<>("levelRank"));
        monsterTypeColumn.setCellValueFactory(new PropertyValueFactory<>("monsterType"));
        atkColumn.setCellValueFactory(new PropertyValueFactory<>("atk"));
        defColumn.setCellValueFactory(new PropertyValueFactory<>("def"));
        loreEffectColumn.setCellValueFactory(new PropertyValueFactory<>("loreEffect"));
        serialColumn.setCellValueFactory(new PropertyValueFactory<>("serial"));
        cardTable.setItems(cardData);
        cardTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                openCard(newSelection);
            }
        });
        Card card = new Card(currentCardId);
        cardData.add(card);
        saveCard(card, false);
    }

    private void setCardSubTypes() {
        switch (currentCardType) {
            case "Monster":
                cardSubType.getItems().setAll(MONSTER_SUB_TYPES);
                break;
            case "Ritual":
                cardSubType.getItems().setAll(RITUAL_SUB_TYPES);
                break;
            case "Fusion":
                cardSubType.getItems().setAll(FUSION_SUB_TYPES);
                break;
            case "Synchro":
                cardSubType.getItems().setAll(SYNCHRO_SUB_TYPES);
                break;
            case "Xyz":
                cardSubType.getItems().setAll(XYZ_SUB_TYPES);
                break;
            case "Pendulum":
                cardSubType.getItems().setAll(PENDULUM_SUB_TYPES);
                break;
            case "Spell":
                cardSubType.getItems().setAll(SPELL_TYPES);
                break;
            case "Trap":
                cardSubType.getItems().setAll(TRAP_TYPES);
                break;
            default:
                throw new IllegalArgumentException();
        }
        cardSubType.getSelectionModel().selectFirst();
        boolean isSpellTrap = currentCardType.equals("Spell") || currentCardType.equals("Trap");
        cardAttribute.setDisable(isSpellTrap);
        cardLevelRank.setDisable(isSpellTrap);
        cardMonsterType.setDisable(isSpellTrap);
        cardATK.setDisable(isSpellTrap);
        cardDEF.setDisable(isSpellTrap);
        cardAttributeLabel.setDisable(isSpellTrap);
        cardLevelRankLabel.setDisable(isSpellTrap);
        cardMonsterTypeLabel.setDisable(isSpellTrap);
        cardATKDEFLabel.setDisable(isSpellTrap);
        slashLabel.setDisable(isSpellTrap);
        if (currentCardType.equals("Xyz")) {
            cardLevelRankLabel.setText("Rank:");
        } else {
            cardLevelRankLabel.setText("Level:");
        }
    }

    private void setCardSubSubTypes() {
        if (currentCardType.equals("Monster")) {
            cardSubSubType.setDisable(false);
            cardSubSubType.getItems().setAll(NORMAL_MONSTER_SUB_SUB_TYPES);
        } else {
            cardSubSubType.setDisable(true);
            cardSubSubType.getItems().setAll(EMPTY);
        }
        if (currentCardType.equals("Normal") && currentCardType.equals("Monster")) {
            cardLoreEffectLabel.setText("Lore:");
        } else {
            cardLoreEffectLabel.setText("Effect:");
        }
        cardSubSubType.getSelectionModel().selectFirst();
    }

    private void setCardSubSubTypes(String newSubCardType) {
        if (newSubCardType.equals("Normal") && currentCardType.equals("Monster")) {
            cardSubSubType.setDisable(false);
            cardSubSubType.getItems().setAll(NORMAL_MONSTER_SUB_SUB_TYPES);
        } else if (newSubCardType.equals("Effect") && currentCardType.equals("Monster")) {
            cardSubSubType.setDisable(false);
            cardSubSubType.getItems().setAll(EFFECT_MONSTER_SUB_SUB_TYPES);
        } else if (newSubCardType.equals("Flip") && currentCardType.equals("Monster")) {
            cardSubSubType.setDisable(false);
            cardSubSubType.getItems().setAll(FLIP_MONSTER_SUB_SUB_TYPES);
        } else if (newSubCardType.equals("Tuner") && currentCardType.equals("Synchro")) {
            cardSubSubType.setDisable(false);
            cardSubSubType.getItems().setAll(TUNER_SYNCHRO_SUB_SUB_TYPES);
        } else if (newSubCardType.equals("Pendulum") && currentCardType.equals("Xyz")) {
            cardSubSubType.setDisable(false);
            cardSubSubType.getItems().setAll(PENDULUM_XYZ_SUB_SUB_TYPES);
        } else if (newSubCardType.equals("Tuner") && currentCardType.equals("Pendulum")) {
            cardSubSubType.setDisable(false);
            cardSubSubType.getItems().setAll(TUNER_PENDULUM_SUB_SUB_TYPES);
        } else {
            cardSubSubType.setDisable(true);
            cardSubSubType.getItems().setAll(EMPTY);
        }
        if (newSubCardType.equals("Normal") && currentCardType.equals("Monster")) {
            cardLoreEffectLabel.setText("Lore:");
        } else {
            cardLoreEffectLabel.setText("Effect:");
        }
        cardSubSubType.getSelectionModel().selectFirst();
    }

    @FXML
    private void setPicture() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Set Card Picture");
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Image Files", "*.jpg", "*.jpeg", "*.png"));
        File selectedFile = fileChooser.showOpenDialog(null);
        BufferedImage bufferedImage;
        try {
            bufferedImage = ImageIO.read(selectedFile);
        } catch (IOException ex) {
            Alert dialog = new Alert(Alert.AlertType.ERROR);
            dialog.setHeaderText("Couldn't open file!");
            dialog.setContentText("Check if another process is using the file.");
            dialog.showAndWait();
            return;
        }
        if (bufferedImage.getHeight() == 0 || bufferedImage.getWidth() == 0) {
            Alert dialog = new Alert(Alert.AlertType.WARNING);
            dialog.setHeaderText("Invalid image size!");
            dialog.setContentText("Empty image.");
            dialog.showAndWait();
            return;
        }
        cardPicture.setImage(SwingFXUtils.toFXImage(ImageUtils.resizeImageWithHint(bufferedImage, bufferedImage.getType(), 177, 254), null));
    }

    private Card getCardById() {
        return cardData.get(cardData.indexOf(new Card(currentCardId)));
    }

    @FXML
    private void saveCard() {
        saveCard(getCardById(), true);
    }

    private void saveCard(Card card, boolean loaded) {
        card.setName(cardName.getText())
                .setType(cardType.getValue())
                .setSubType(cardSubType.getValue())
                .setSubSubType(cardSubSubType.getValue())
                .setAttribute(cardAttribute.getValue())
                .setLevelRank(cardLevelRank.getValue())
                .setMonsterType(cardMonsterType.getValue())
                .setAtk(cardATK.getText())
                .setDef(cardDEF.getText())
                .setLoreEffect(cardLoreEffect.getText())
                .setSerial(cardSerial.getText())
                .setAlias(ygoproAlias.getText())
                .setArchtype(ygoproArchtype.getValue())
                .setSecondaryArchtype(ygoproSecondaryArchtype.getValue())
                .setFormat(ygoproFormat.getValue())
                .setsTDestroy(ygoproSTDestroy.isSelected())
                .setBacktoHand(ygoproBacktoHand.isSelected())
                .setDraw(ygoproDraw.isSelected())
                .setControl(ygoproControl.isSelected())
                .setLimitAttack(ygoproLimitAttack.isSelected())
                .setTypeRelated(ygoproTypeRelated.isSelected())
                .setDestroy(ygoproDestroy.isSelected())
                .setFusionRelated(ygoproFusionRelated.isSelected())
                .setDestroyMonster(ygoproDestroyMonster.isSelected())
                .setBackToDeck(ygoproBackToDeck.isSelected())
                .setSearch(ygoproSearch.isSelected())
                .setChangeATKDEF(ygoproChangeATKDEF.isSelected())
                .setDirectAttack(ygoproDirectAttack.isSelected())
                .setPropertyRelated(ygoproPropertyRelated.isSelected())
                .setSelect(ygoproSelect.isSelected())
                .setTunerRelated(ygoproTunerRelated.isSelected())
                .setBanish(ygoproBanish.isSelected())
                .setDestroyHand(ygoproDestroyHand.isSelected())
                .setRecovery(ygoproRecovery.isSelected())
                .setPiercing(ygoproPiercing.isSelected())
                .setSpecialSummon(ygoproSpecialSummon.isSelected())
                .setDamageLP(ygoproDamageLP.isSelected())
                .setCounter(ygoproCounter.isSelected())
                .setXyzRelated(ygoproXyzRelated.isSelected())
                .setGraveyard(ygoproGraveyard.isSelected())
                .setDestroyDeck(ygoproDestroyDeck.isSelected())
                .setPosition(ygoproPosition.isSelected())
                .setRepeatAttack(ygoproRepeatAttack.isSelected())
                .setToken(ygoproToken.isSelected())
                .setRecoveryLP(ygoproRecoveryLP.isSelected())
                .setGamble(ygoproGamble.isSelected())
                .setNegateEffect(ygoproNegateEffect.isSelected())
                .setString1(ygoproString1.getText())
                .setString2(ygoproString2.getText())
                .setString3(ygoproString3.getText())
                .setString4(ygoproString4.getText())
                .setString5(ygoproString5.getText())
                .setString6(ygoproString6.getText())
                .setString7(ygoproString7.getText())
                .setString8(ygoproString8.getText())
                .setString9(ygoproString9.getText())
                .setString10(ygoproString10.getText())
                .setString11(ygoproString11.getText())
                .setString12(ygoproString12.getText())
                .setString13(ygoproString13.getText())
                .setString14(ygoproString14.getText())
                .setString15(ygoproString15.getText())
                .setString16(ygoproString16.getText())
                .setScript(loaded ? (String) scriptEditor.getEngine().executeScript("editor.getValue();") : "")
                .setPicture(cardPicture.getImage());
        cardData.set(cardData.indexOf(card), card);
    }

    private void openCard(Card card) {
        currentCardId = card.getId();
        cardName.setText(card.getName());
        cardType.setValue(card.getType());
        cardSubType.setValue(card.getSubType());
        cardSubSubType.setValue(card.getSubSubType());
        cardAttribute.setValue(card.getAttribute());
        cardLevelRank.setValue(card.getLevelRank());
        cardMonsterType.setValue(card.getMonsterType());
        cardATK.setText(card.getAtk());
        cardDEF.setText(card.getDef());
        cardLoreEffect.setText(card.getLoreEffect());
        cardSerial.setText(card.getSerial());
        ygoproAlias.setText(card.getAlias());
        ygoproArchtype.setValue(card.getArchtype());
        ygoproSecondaryArchtype.setValue(card.getSecondaryArchtype());
        ygoproFormat.setValue(card.getFormat());
        ygoproSTDestroy.setSelected(card.issTDestroy());
        ygoproBacktoHand.setSelected(card.isBacktoHand());
        ygoproDraw.setSelected(card.isDraw());
        ygoproControl.setSelected(card.isControl());
        ygoproLimitAttack.setSelected(card.isLimitAttack());
        ygoproTypeRelated.setSelected(card.isTypeRelated());
        ygoproDestroy.setSelected(card.isDestroy());
        ygoproFusionRelated.setSelected(card.isFusionRelated());
        ygoproDestroyMonster.setSelected(card.isDestroyMonster());
        ygoproBackToDeck.setSelected(card.isBackToDeck());
        ygoproSearch.setSelected(card.isSearch());
        ygoproChangeATKDEF.setSelected(card.isChangeATKDEF());
        ygoproDirectAttack.setSelected(card.isDirectAttack());
        ygoproPropertyRelated.setSelected(card.isPropertyRelated());
        ygoproSelect.setSelected(card.isSelect());
        ygoproTunerRelated.setSelected(card.isTunerRelated());
        ygoproBanish.setSelected(card.isBanish());
        ygoproDestroyHand.setSelected(card.isDestroyHand());
        ygoproRecovery.setSelected(card.isRecovery());
        ygoproPiercing.setSelected(card.isPiercing());
        ygoproSpecialSummon.setSelected(card.isSpecialSummon());
        ygoproDamageLP.setSelected(card.isDamageLP());
        ygoproCounter.setSelected(card.isCounter());
        ygoproXyzRelated.setSelected(card.isXyzRelated());
        ygoproGraveyard.setSelected(card.isGraveyard());
        ygoproDestroyDeck.setSelected(card.isDestroyDeck());
        ygoproPosition.setSelected(card.isPosition());
        ygoproRepeatAttack.setSelected(card.isRepeatAttack());
        ygoproToken.setSelected(card.isToken());
        ygoproRecoveryLP.setSelected(card.isRecoveryLP());
        ygoproGamble.setSelected(card.isGamble());
        ygoproNegateEffect.setSelected(card.isNegateEffect());
        ygoproString1.setText(card.getString1());
        ygoproString2.setText(card.getString2());
        ygoproString3.setText(card.getString3());
        ygoproString4.setText(card.getString4());
        ygoproString5.setText(card.getString5());
        ygoproString6.setText(card.getString6());
        ygoproString7.setText(card.getString7());
        ygoproString8.setText(card.getString8());
        ygoproString9.setText(card.getString9());
        ygoproString10.setText(card.getString10());
        ygoproString11.setText(card.getString11());
        ygoproString12.setText(card.getString12());
        ygoproString13.setText(card.getString13());
        ygoproString14.setText(card.getString14());
        ygoproString15.setText(card.getString15());
        ygoproString16.setText(card.getString16());
        scriptEditor.getEngine().executeScript("editor.setValue('" + card.getScript().replace("\n", "\\n") + "');");
        if (card.getPicture() != null) {
            cardPicture.setImage(card.getPicture());
        }
    }

    private int getLowestUnusedId() {
        if (cardData == null || cardData.isEmpty()) {
            return 1;
        }
        int greatest = Integer.MIN_VALUE;
        for (Card card : cardData) {
            if (card.getId() > greatest) {
                greatest = card.getId();
            }
        }
        return greatest + 1;
    }

    @FXML
    private void newCard() {
        currentCardId = getLowestUnusedId();
        cardName.setText("");
        cardType.setValue("Monster");
        cardSubType.setValue("Normal");
        cardSubSubType.setValue("");
        cardAttribute.setValue("EARTH");
        cardLevelRank.setValue("4");
        cardMonsterType.setValue("Warrior");
        cardATK.setText("");
        cardDEF.setText("");
        cardLoreEffect.setText("");
        cardSerial.setText("");
        ygoproAlias.setText("");
        ygoproArchtype.setValue("");
        ygoproSecondaryArchtype.setValue("");
        ygoproFormat.setValue("OCG");
        ygoproSTDestroy.setSelected(false);
        ygoproBacktoHand.setSelected(false);
        ygoproDraw.setSelected(false);
        ygoproControl.setSelected(false);
        ygoproLimitAttack.setSelected(false);
        ygoproTypeRelated.setSelected(false);
        ygoproDestroy.setSelected(false);
        ygoproFusionRelated.setSelected(false);
        ygoproDestroyMonster.setSelected(false);
        ygoproBackToDeck.setSelected(false);
        ygoproSearch.setSelected(false);
        ygoproChangeATKDEF.setSelected(false);
        ygoproDirectAttack.setSelected(false);
        ygoproPropertyRelated.setSelected(false);
        ygoproSelect.setSelected(false);
        ygoproTunerRelated.setSelected(false);
        ygoproBanish.setSelected(false);
        ygoproDestroyHand.setSelected(false);
        ygoproRecovery.setSelected(false);
        ygoproPiercing.setSelected(false);
        ygoproSpecialSummon.setSelected(false);
        ygoproDamageLP.setSelected(false);
        ygoproCounter.setSelected(false);
        ygoproXyzRelated.setSelected(false);
        ygoproGraveyard.setSelected(false);
        ygoproDestroyDeck.setSelected(false);
        ygoproPosition.setSelected(false);
        ygoproRepeatAttack.setSelected(false);
        ygoproToken.setSelected(false);
        ygoproRecoveryLP.setSelected(false);
        ygoproGamble.setSelected(false);
        ygoproNegateEffect.setSelected(false);
        ygoproString1.setText("");
        ygoproString2.setText("");
        ygoproString3.setText("");
        ygoproString4.setText("");
        ygoproString5.setText("");
        ygoproString6.setText("");
        ygoproString7.setText("");
        ygoproString8.setText("");
        ygoproString9.setText("");
        ygoproString10.setText("");
        ygoproString11.setText("");
        ygoproString12.setText("");
        ygoproString13.setText("");
        ygoproString14.setText("");
        ygoproString15.setText("");
        ygoproString16.setText("");
        scriptEditor.getEngine().executeScript("editor.setValue('');");
        BufferedImage bufferedImage;
        try {
            bufferedImage = ImageIO.read(new File(FileUtils.getApplicationPath() + File.separator + "textures" + File.separator + "unknown.png"));
            cardPicture.setImage(SwingFXUtils.toFXImage(bufferedImage, null));
        } catch (IOException ex) {
            Alert dialog = new Alert(Alert.AlertType.ERROR);
            dialog.setHeaderText("Couldn't open file!");
            dialog.setContentText("Check if another process is using the file.");
            dialog.showAndWait();
        }
        Card card = new Card(currentCardId);
        cardData.add(card);
        saveCard(card, true);
        cardTable.getSelectionModel().select(card);
    }

    @FXML
    private void deleteCard() {
        Card card = getCardById();
        int index = cardData.indexOf(card);
        cardData.remove(card);
        cardTable.getSelectionModel().select(index == cardData.size() ? cardData.size() - 1 : index);
        if (cardData.size() == 0) {
            newCard();
        } else {
            openCard(cardTable.getSelectionModel().getSelectedItem());
        }
    }

    @FXML
    private void saveSet() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Card Set");
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("YGOProCardMakerSet (*.ygopcms)", "*.ygopcms"));
        File set = fileChooser.showSaveDialog(null);
        if (!set.getPath().toLowerCase().endsWith(".ygopcms")) {
            set = new File(set.getPath() + ".ygopcms");
        }
        try (FileWriter file = new FileWriter(set)) {
            file.write(new JSONObject()
                    .put("name", setTitle.getText())
                    .put("author", setAuthor.getText())
                    .put("description", setDescription.getText())
                    .put("cards", cardData.stream().map(c -> Card.toJSON(c)).collect(Collectors.toList()))
                    .toString()); //.toString(2);
            file.flush();
        } catch (Exception ex) {
            Alert dialog = new Alert(Alert.AlertType.ERROR);
            dialog.setHeaderText("Couldn't save file!");
            dialog.setContentText("Check if file exists.");
            dialog.showAndWait();
        }
    }

    @FXML
    private void openSet() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Card Set");
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("YGOProCardMakerSet (*.ygopcms)", "*.ygopcms"));
        File set = fileChooser.showOpenDialog(null);
        char[] buf;
        try (FileReader file = new FileReader(set)) {
            buf = new char[(int) set.length()];
            file.read(buf);
        } catch (Exception ex) {
            Alert dialog = new Alert(Alert.AlertType.ERROR);
            dialog.setHeaderText("Couldn't open file!");
            dialog.setContentText("Check if file exists.");
            dialog.showAndWait();
            return;
        }
        JSONObject json = new JSONObject(new String(buf));
        setTitle.setText(json.getString("name"));
        setAuthor.setText(json.getString("author"));
        setDescription.setText(json.getString("description"));
        cardData.clear();
        JSONArray cards = json.getJSONArray("cards");
        for (int i = 0; i < cards.length(); i++) {
            cardData.add(Card.fromJSON(cards.getJSONObject(i)));
        }
        openCard(cardData.get(0));
        cardTable.getSelectionModel().select(0);
    }

    @FXML
    public void installSet() {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:cards.cdb");
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            for (Card card : cardData) {
                stmt.executeUpdate("INSERT OR REPLACE INTO \"datas\" VALUES (\""
                        + card.getSerial() + "\",\""
                        + CardFormat.code(card.getFormat()) + "\",\""
                        + (card.getAlias().equals("") ? "0" : card.getAlias()) + "\",\""
                        + "0" + "\",\""
                        + CardType.code(card.getType(), card.getSubType(), card.getSubSubType()) + "\",\""
                        + card.getAtk() + "\",\""
                        + card.getDef() + "\",\""
                        + Integer.parseInt(card.getLevelRank()) + "\",\""
                        + CardMonsterType.code(card.getMonsterType()) + "\",\""
                        + CardAttribute.code(card.getAttribute()) + "\",\""
                        + "0" + "\");");
                stmt.executeUpdate("INSERT OR REPLACE INTO \"texts\" VALUES (\""
                        + card.getSerial() + "\",\""
                        + card.getName() + "\",\""
                        + card.getLoreEffect() + "\",\""
                        + (card.getString1().equals("") ? " " : card.getString1()) + "\",\""
                        + (card.getString2().equals("") ? " " : card.getString2()) + "\",\""
                        + (card.getString3().equals("") ? " " : card.getString3()) + "\",\""
                        + (card.getString4().equals("") ? " " : card.getString4()) + "\",\""
                        + (card.getString5().equals("") ? " " : card.getString5()) + "\",\""
                        + (card.getString6().equals("") ? " " : card.getString6()) + "\",\""
                        + (card.getString7().equals("") ? " " : card.getString7()) + "\",\""
                        + (card.getString8().equals("") ? " " : card.getString8()) + "\",\""
                        + (card.getString9().equals("") ? " " : card.getString9()) + "\",\""
                        + (card.getString10().equals("") ? " " : card.getString10()) + "\",\""
                        + (card.getString11().equals("") ? " " : card.getString11()) + "\",\""
                        + (card.getString12().equals("") ? " " : card.getString12()) + "\",\""
                        + (card.getString13().equals("") ? " " : card.getString13()) + "\",\""
                        + (card.getString14().equals("") ? " " : card.getString14()) + "\",\""
                        + (card.getString15().equals("") ? " " : card.getString15()) + "\",\""
                        + (card.getString16().equals("") ? " " : card.getString16()) + "\");");
                if (!card.getType().equals("Monster") || !card.getSubType().equals("Normal")) {
                    File script = new File("script" + File.separator + "c" + card.getSerial() + ".lua");
                    try (FileWriter file = new FileWriter(script)) {
                        file.write(card.getScript());
                        file.flush();
                    }
                }
                File picture = new File("pics" + File.separator + card.getSerial() + ".jpg");
                BufferedImage image = SwingFXUtils.fromFXImage(card.getPicture(), null);
                BufferedImage imageRGB = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.OPAQUE);
                Graphics2D graphics = imageRGB.createGraphics();
                graphics.drawImage(image, 0, 0, null);
                ImageIO.write(imageRGB, "jpg", picture);
                graphics.dispose();
            }
            conn.commit();
            stmt.close();
            conn.close();
            Alert dialog = new Alert(Alert.AlertType.INFORMATION);
            dialog.setHeaderText("Set installed successfully!");
            dialog.setContentText("");
            dialog.showAndWait();
        } catch (ClassNotFoundException ex) {
            Alert dialog = new Alert(Alert.AlertType.ERROR);
            dialog.setHeaderText("SQLite JDBC is not installed!");
            dialog.setContentText("Install sqlite-jdbc-<version>.jar\nin lib folder.");
            dialog.showAndWait();
        } catch (SQLException | NumberFormatException | IOException ex) {
            Alert dialog = new Alert(Alert.AlertType.ERROR);
            dialog.setHeaderText("Error in card database!");
            dialog.setContentText("");
            dialog.showAndWait();
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex1) {
                dialog = new Alert(Alert.AlertType.ERROR);
                dialog.setHeaderText("Rollback error!");
                dialog.setContentText("");
                dialog.showAndWait();
            }
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {
                Alert dialog = new Alert(Alert.AlertType.ERROR);
                dialog.setHeaderText("Error while canceling card database operation!");
                dialog.setContentText("");
                dialog.showAndWait();
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException ex1) {
                    dialog = new Alert(Alert.AlertType.ERROR);
                    dialog.setHeaderText("Error while closing card database!");
                    dialog.setContentText("");
                    dialog.showAndWait();
                }
            }
        }
    }

    @FXML
    public void uninstallSet() {
    }
}
