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
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.DataFormat;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javax.imageio.ImageIO;
import netscape.javascript.JSObject;
import org.controlsfx.control.Notifications;
import org.json.JSONArray;
import org.json.JSONObject;
import ygoprocardmaker.data.Archtype;
import ygoprocardmaker.data.Card;
import static ygoprocardmaker.enumerate.CardAttribute.*;
import static ygoprocardmaker.enumerate.CardLevelRank.*;
import static ygoprocardmaker.enumerate.CardMonsterType.*;
import static ygoprocardmaker.enumerate.CardType.*;
import static ygoprocardmaker.enumerate.CardFormat.*;
import ygoprocardmaker.exception.InvalidPictureException;
import ygoprocardmaker.util.FileUtils;
import ygoprocardmaker.util.ImageUtils;
import ygoprocardmaker.util.JavaFXUtils;
import ygoprocardmaker.util.YGOProUtils;

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

    @FXML
    private TextField archtypeName;

    @FXML
    private TextField archtypeCode;

    @FXML
    private TableView<Archtype> archtypeTable;

    @FXML
    private TableColumn<Archtype, String> archtypeNameColumn;

    @FXML
    private TableColumn<Archtype, String> archtypeCodeColumn;

    @FXML
    private Button deleteArchtypeButton;

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

    // Menu
    @FXML
    private MenuItem newCmd;

    @FXML
    private MenuItem openCmd;

    @FXML
    private MenuItem saveCmd;

    @FXML
    private MenuItem saveAsCmd;

    @FXML
    private MenuItem exportCmd;

    @FXML
    private MenuItem quitCmd;

    // Internal
    private int currentCardId;

    private String currentCardType;

    private boolean hasPicture;

    final private ObservableList<Card> cardData;

    final private ObservableList<Archtype> archtypeData;

    private File setFile;

    final private static Pattern POSITIVE_INTEGER = Pattern.compile("^[0-9]*([,]{1}[0-9]{0,2}){0,1}$");

    public YGOProCardMakerController() {
        currentCardId = 1;
        currentCardType = "Monster";
        hasPicture = false;
        cardData = FXCollections.observableArrayList();
        archtypeData = FXCollections.observableArrayList();
        setFile = null;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeCardInfo();
        initializeYGOProInfo();
        initializeCardScript();
        initializeSetInfo();
        initializeCardTable();
        initializeMenu();
        cardEditorAccordion.setExpandedPane(cardInfoPane);
    }

    @FXML
    private void handleSaveCardButton() {
        if (cardChanged()) {
            saveCard(getCardById(), true);
            Notifications.create()
                    .title("Save Card")
                    .text("Card saved successfully!")
                    .show();
        }
    }

    @FXML
    private void handleNewCardButton() {
        if (cardChanged()) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("New Card");
            alert.setHeaderText(null);
            alert.setContentText("Do you wish to save before creating a new card?\n"
                    + "If you don't, changes will be lost.");
            ButtonType buttonTypeNewSave = new ButtonType("Save & New");
            ButtonType buttonTypeCancel = new ButtonType("Cancel");
            alert.getButtonTypes().setAll(buttonTypeNewSave, new ButtonType("New"), buttonTypeCancel);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == buttonTypeNewSave) {
                saveCard(getCardById(), true);
                Notifications.create()
                        .title("Save Card")
                        .text("Card saved successfully!")
                        .show();
            } else if (result.get() == buttonTypeCancel) {
                return;
            }
        }
        newCard();
        Notifications.create()
                .title("New Card")
                .text("New card created successfully!")
                .show();
    }

    @FXML
    private void handleDeleteCardButton() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Delete Card");
        alert.setHeaderText(null);
        alert.setContentText("The card will be lost!\n"
                + "Do you wish to continue?");
        ButtonType buttonTypeDelete = new ButtonType("Delete");
        alert.getButtonTypes().setAll(buttonTypeDelete, new ButtonType("Cancel"));
        if (alert.showAndWait().get() == buttonTypeDelete) {
            deleteCard();
            Notifications.create()
                    .title("Delete Card")
                    .text("Card deleted successfully!")
                    .show();
        }
    }

    @FXML
    private void handleSetPictureButton() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Set Card Picture");
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Image Files", "*.jpg", "*.jpeg", "*.png"));
        File picture = fileChooser.showOpenDialog(null);
        if (picture == null) {
            return;
        }
        try {
            setPicture(picture);
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("File Error");
            alert.setHeaderText(null);
            alert.setContentText("Couldn't open image file.");
            JavaFXUtils.setExceptionAlert(alert, ex).showAndWait();
        } catch (InvalidPictureException ex) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid Image");
            alert.setHeaderText(null);
            alert.setContentText("Image size can't be null.");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleRemovePictureButton() {
        removePicture();
    }

    @FXML
    private void handleAddArchtypeButton() {
        if (archtypeName.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid Archtype Name");
            alert.setHeaderText(null);
            alert.setContentText("Archtype name cannot not be empty.");
            alert.showAndWait();
        } else if (archtypeCode.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid Archtype Code");
            alert.setHeaderText(null);
            alert.setContentText("Archtype code cannot not be empty.");
            alert.showAndWait();
        } else if (!isPositiveInteger(archtypeCode.getText())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid Archtype Code");
            alert.setHeaderText(null);
            alert.setContentText("Archtype code must be a positive integer.");
            alert.showAndWait();
        } else {
            addArchtype();
            Notifications.create()
                    .title("Add Archtype")
                    .text("Archtype added successfully!")
                    .show();
        }
    }

    @FXML
    private void handleDeleteArchtypeButton() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Delete Archtype");
        alert.setHeaderText(null);
        alert.setContentText("Every card with this archtype, will lose it!\n"
                + "Do you wish to continue?");
        ButtonType buttonTypeDelete = new ButtonType("Delete");
        alert.getButtonTypes().setAll(buttonTypeDelete, new ButtonType("Cancel"));
        if (alert.showAndWait().get() == buttonTypeDelete) {
            deleteArchtype(archtypeData.get(archtypeTable.getSelectionModel().getSelectedIndex()));
            Notifications.create()
                    .title("Delete Archtype")
                    .text("Archtype deleted successfully!")
                    .show();
        }
    }

    @FXML
    private void handleNewSetMenuItem() {
        if (setChanged()) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("New Set");
            alert.setHeaderText(null);
            alert.setContentText("Do you wish to save before creating a new set?\n"
                    + "If you don't, changes will be lost.");
            ButtonType buttonTypeSaveNew = new ButtonType("Save & New");
            ButtonType buttonTypeCancel = new ButtonType("Cancel");
            alert.getButtonTypes().setAll(buttonTypeSaveNew, new ButtonType("New"), buttonTypeCancel);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == buttonTypeSaveNew) {
                try {
                    File set = setFile;
                    if (setFile == null) {
                        FileChooser fileChooser = new FileChooser();
                        fileChooser.setTitle("Save Card Set");
                        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("YGOProCardMakerSet (*.ygopcms)", "*.ygopcms"));
                        set = fileChooser.showSaveDialog(null);
                        if (set == null) {
                            return;
                        }
                    }
                    if (cardChanged()) {
                        saveCard(getCardById(), true);
                        Notifications.create()
                                .title("Save Card")
                                .text("Card saved successfully!")
                                .show();
                    }
                    saveSet(set);
                    Notifications.create()
                            .title("Save Set")
                            .text("Set successfully saved!")
                            .show();
                } catch (IOException ex) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("File Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Couldn't save set.");
                    JavaFXUtils.setExceptionAlert(alert, ex).showAndWait();
                    return;
                }
            } else if (result.get() == buttonTypeCancel) {
                return;
            }
        }
        newSet();
        Notifications.create()
                .title("New Set")
                .text("Set created successfully!")
                .show();
    }

    @FXML
    private void handleOpenSetMenuItem() {
        if (setChanged()) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Open Set");
            alert.setHeaderText(null);
            alert.setContentText("Do you wish to save before opening a new set?\n"
                    + "If you don't, changes will be lost.");
            ButtonType buttonTypeSaveOpen = new ButtonType("Save & Open");
            ButtonType buttonTypeCancel = new ButtonType("Cancel");
            alert.getButtonTypes().setAll(buttonTypeSaveOpen, new ButtonType("Open"), buttonTypeCancel);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == buttonTypeSaveOpen) {
                try {
                    File set = setFile;
                    if (setFile == null) {
                        FileChooser fileChooser = new FileChooser();
                        fileChooser.setTitle("Save Card Set");
                        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("YGOProCardMakerSet (*.ygopcms)", "*.ygopcms"));
                        set = fileChooser.showSaveDialog(null);
                        if (set == null) {
                            return;
                        }
                    }
                    if (cardChanged()) {
                        saveCard(getCardById(), true);
                        Notifications.create()
                                .title("Save Card")
                                .text("Card saved successfully!")
                                .show();
                    }
                    saveSet(set);
                    Notifications.create()
                            .title("Save Set")
                            .text("Set successfully saved!")
                            .show();
                } catch (IOException ex) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("File Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Couldn't save set.");
                    JavaFXUtils.setExceptionAlert(alert, ex).showAndWait();
                    return;
                }
            } else if (result.get() == buttonTypeCancel) {
                return;
            }
        }
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Card Set");
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("YGOProCardMakerSet (*.ygopcms)", "*.ygopcms"));
        File set = fileChooser.showOpenDialog(null);
        if (set == null) {
            return;
        }
        try {
            openSet(set);
            Notifications.create()
                    .title("Open Card Set")
                    .text("Set opened successfully!")
                    .show();
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("File Error");
            alert.setHeaderText(null);
            alert.setContentText("Couldn't open set.");
            JavaFXUtils.setExceptionAlert(alert, ex).showAndWait();
        }
    }

    @FXML
    private void handleSaveSetMenuItem() {
        File set;
        if (setFile == null) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save Card Set");
            fileChooser.getExtensionFilters().addAll(new ExtensionFilter("YGOProCardMakerSet (*.ygopcms)", "*.ygopcms"));
            set = fileChooser.showSaveDialog(null);
            if (set == null) {
                return;
            }
            if (!set.getPath().toLowerCase().endsWith(".ygopcms")) {
                set = new File(set.getPath() + ".ygopcms");
            }
        } else {
            set = setFile;
        }
        try {
            if (cardChanged()) {
                saveCard(getCardById(), true);
                Notifications.create()
                        .title("Save Card")
                        .text("Card saved successfully!")
                        .show();
            }
            saveSet(set);
            Notifications.create()
                    .title("Save Set")
                    .text("Set successfully saved!")
                    .show();
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("File Error");
            alert.setHeaderText(null);
            alert.setContentText("Couldn't save set.");
            JavaFXUtils.setExceptionAlert(alert, ex).showAndWait();
        }
    }

    @FXML
    private void handleSaveSetAsMenuItem() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Card Set");
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("YGOProCardMakerSet (*.ygopcms)", "*.ygopcms"));
        File set = fileChooser.showSaveDialog(null);
        if (set == null) {
            return;
        }
        if (!set.getPath().toLowerCase().endsWith(".ygopcms")) {
            set = new File(set.getPath() + ".ygopcms");
        }
        try {
            if (cardChanged()) {
                saveCard(getCardById(), true);
                Notifications.create()
                        .title("Save Card")
                        .text("Card saved successfully!")
                        .show();
            }
            saveSet(set);
            Notifications.create()
                    .title("Save Set")
                    .text("Set saved successfully!")
                    .show();
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("File Error");
            alert.setHeaderText(null);
            alert.setContentText("Couldn't save set.");
            JavaFXUtils.setExceptionAlert(alert, ex).showAndWait();
        }
    }

    @FXML
    private void handleExportSetMenuItem() {
        try {
            exportSet();
            Notifications.create()
                    .title("Export Set")
                    .text("Set exported successfully!")
                    .show();
        } catch (ClassNotFoundException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Card Database Error");
            alert.setHeaderText(null);
            alert.setContentText("SQLite JDBC is not installed.");
            JavaFXUtils.setExceptionAlert(alert, ex).showAndWait();
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Card Database Error");
            alert.setHeaderText(null);
            alert.setContentText("Couldn't install set in card database.");
            JavaFXUtils.setExceptionAlert(alert, ex).showAndWait();
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Export Error");
            alert.setHeaderText(null);
            alert.setContentText("Couldn't save image or script file.");
            JavaFXUtils.setExceptionAlert(alert, ex).showAndWait();
        }
    }

    @FXML
    private void handleQuitMenuItem() {
        System.exit(0);
    }

    private static boolean isPositiveInteger(String input) {
        Matcher matcher = POSITIVE_INTEGER.matcher(input);
        return matcher.matches();
    }

    private boolean cardChanged() {
        return true;
    }

    private boolean setChanged() {
        return true;
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
        cardPicture.setImage(new Image(getClass().getResourceAsStream("resource/pics/unknown.png")));
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
        archtypeNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        archtypeCodeColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
        archtypeTable.setItems(archtypeData);
        deleteArchtypeButton.setDisable(true);
    }

    private void initializeMenu() {
        newCmd.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));
        openCmd.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));
        exportCmd.setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN));
        saveCmd.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
        saveAsCmd.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN, KeyCombination.SHIFT_DOWN));
        quitCmd.setAccelerator(new KeyCodeCombination(KeyCode.Q, KeyCombination.CONTROL_DOWN));
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
            if (newSelection != null && newSelection.getId() != currentCardId) {
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

    private void setPicture(File picture) throws IOException, InvalidPictureException {
        BufferedImage bufferedImage = ImageIO.read(picture);
        if (bufferedImage.getHeight() == 0 || bufferedImage.getWidth() == 0) {
            throw new InvalidPictureException();
        }
        cardPicture.setImage(SwingFXUtils.toFXImage(ImageUtils.resizeImageWithHint(bufferedImage, bufferedImage.getType(), 177, 254), null));
        hasPicture = true;
    }

    private void removePicture() {
        if (hasPicture) {
            cardPicture.setImage(new Image(getClass().getResourceAsStream("resource/pics/unknown.png")));
        }
        hasPicture = false;
    }

    private Card getCardById() {
        return cardData.get(cardData.indexOf(new Card(currentCardId)));
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
                .setPicture(hasPicture ? cardPicture.getImage() : null);
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
        scriptEditor.getEngine().executeScript("editor.setValue('" + card.getScript().replace("\n", "\\n") + "', -1);");
        hasPicture = card.getPicture() != null;
        if (hasPicture) {
            cardPicture.setImage(card.getPicture());
        } else {
            cardPicture.setImage(new Image(getClass().getResourceAsStream("resource/pics/unknown.png")));
        }
    }

    private int getGreatestUnusedId() {
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

    private void newCard() {
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
        scriptEditor.getEngine().executeScript("editor.setValue('', -1);");
        cardPicture.setImage(new Image(getClass().getResourceAsStream("resource/pics/unknown.png")));
        hasPicture = false;
        Card card = new Card(getGreatestUnusedId());
        cardData.add(card);
        saveCard(card, true);
        cardTable.getSelectionModel().select(card);
    }

    private void deleteCard() {
        Card card = getCardById();
        int index = cardData.indexOf(card);
        cardData.remove(card);
        if (cardData.size() == 0) {
            newCard();
        } else {
            cardTable.getSelectionModel().select(index == cardData.size() ? cardData.size() - 1 : index);
        }
    }

    private void saveSet(File set) throws IOException {
        try (FileWriter file = new FileWriter(set)) {
            file.write(new JSONObject()
                    .put("name", setTitle.getText())
                    .put("author", setAuthor.getText())
                    .put("description", setDescription.getText())
                    .put("cards", cardData.stream().map(c -> Card.toJSON(c)).collect(Collectors.toList()))
                    .put("archtypes", archtypeData.stream().map(a -> Archtype.toJSON(a)).collect(Collectors.toList()))
                    .toString()); //.toString(2);
            file.flush();
        }
        setFile = set;
    }

    private void newSet() {
        setFile = null;
        cardData.clear();
        archtypeData.clear();
        deleteArchtypeButton.setDisable(true);
        ygoproArchtype.getItems().setAll(EMPTY);
        ygoproArchtype.getSelectionModel().selectFirst();
        ygoproSecondaryArchtype.getItems().setAll(EMPTY);
        ygoproSecondaryArchtype.getSelectionModel().selectFirst();
        newCard();
    }

    private void openSet(File set) throws IOException {
        char[] buf;
        try (FileReader file = new FileReader(set)) {
            buf = new char[(int) set.length()];
            file.read(buf);
        }
        setFile = set;
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
        archtypeData.clear();
        ygoproArchtype.getItems().clear();
        ygoproSecondaryArchtype.getItems().clear();
        JSONArray archtypes = json.getJSONArray("archtypes");
        for (int i = 0; i < archtypes.length(); i++) {
            Archtype archtype = Archtype.fromJSON(archtypes.getJSONObject(i));
            if (!archtype.getName().equals("") && isPositiveInteger(archtype.getCode())) {
                archtypeData.add(archtype);
            }
        }
        archtypeData.stream().forEach(archtype -> {
            ygoproArchtype.getItems().add(archtype.getName());
            ygoproSecondaryArchtype.getItems().add(archtype.getName());
        });
        deleteArchtypeButton.setDisable(archtypeData.isEmpty());
    }

    private void exportSet() throws ClassNotFoundException, SQLException, IOException {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:cards.cdb");
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            for (Card card : cardData) {
                stmt.executeUpdate("INSERT OR REPLACE INTO \"datas\" VALUES (\""
                        + YGOProUtils.computeSerial(card) + "\",\""
                        + YGOProUtils.computeFormat(card) + "\",\""
                        + YGOProUtils.computeAlias(card) + "\",\""
                        + YGOProUtils.computeArchtype(card, archtypeData) + "\",\""
                        + YGOProUtils.computeType(card) + "\",\""
                        + YGOProUtils.computeATK(card) + "\",\""
                        + YGOProUtils.computeDEF(card) + "\",\""
                        + YGOProUtils.computeLevelRank(card) + "\",\""
                        + YGOProUtils.computeMonsterType(card) + "\",\""
                        + YGOProUtils.computeMonsterAttribute(card) + "\",\""
                        + YGOProUtils.computeEffectCategories(card) + "\");");
                stmt.executeUpdate("INSERT OR REPLACE INTO \"texts\" VALUES (\""
                        + YGOProUtils.computeSerial(card) + "\",\""
                        + YGOProUtils.computeName(card) + "\",\""
                        + YGOProUtils.computeLoreEffect(card) + "\",\""
                        + YGOProUtils.computeString1(card) + "\",\""
                        + YGOProUtils.computeString2(card) + "\",\""
                        + YGOProUtils.computeString3(card) + "\",\""
                        + YGOProUtils.computeString4(card) + "\",\""
                        + YGOProUtils.computeString5(card) + "\",\""
                        + YGOProUtils.computeString6(card) + "\",\""
                        + YGOProUtils.computeString7(card) + "\",\""
                        + YGOProUtils.computeString8(card) + "\",\""
                        + YGOProUtils.computeString9(card) + "\",\""
                        + YGOProUtils.computeString10(card) + "\",\""
                        + YGOProUtils.computeString11(card) + "\",\""
                        + YGOProUtils.computeString12(card) + "\",\""
                        + YGOProUtils.computeString13(card) + "\",\""
                        + YGOProUtils.computeString14(card) + "\",\""
                        + YGOProUtils.computeString15(card) + "\",\""
                        + YGOProUtils.computeString16(card) + "\");");
                if (!card.getType().equals("Monster") || !card.getSubType().equals("Normal")) {
                    File script = new File("script" + File.separator + "c" + card.getSerial() + ".lua");
                    try (FileWriter file = new FileWriter(script)) {
                        file.write(card.getScript());
                        file.flush();
                    }
                }
                if (card.getPicture() != null) {
                    File picture = new File("pics" + File.separator + card.getSerial() + ".jpg");
                    BufferedImage image = SwingFXUtils.fromFXImage(card.getPicture(), null);
                    BufferedImage imageRGB = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.OPAQUE);
                    Graphics2D graphics = imageRGB.createGraphics();
                    graphics.drawImage(image, 0, 0, null);
                    ImageIO.write(imageRGB, "jpg", picture);
                    graphics.dispose();
                }
            }
            conn.commit();
            stmt.close();
            conn.close();
        } catch (SQLException | IOException ex) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex1) {
                throw ex1;
            }
            throw ex;
        } finally {
            try {
                if (stmt != null && conn != null && !stmt.isClosed() && !conn.isClosed()) {
                    stmt.close();
                }
            } catch (SQLException ex) {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException ex1) {
                    throw ex1;
                }
                throw ex;
            }
        }
    }

    private void addArchtype() {
        archtypeData.add(new Archtype(archtypeName.getText())
                .setCode(archtypeCode.getText()));
        ygoproArchtype.getItems().add(archtypeName.getText());
        ygoproSecondaryArchtype.getItems().add(archtypeName.getText());
        if (deleteArchtypeButton.isDisabled()) {
            deleteArchtypeButton.setDisable(false);
        }
    }

    private void deleteArchtype(Archtype archtype) {
        if (ygoproArchtype.getSelectionModel().getSelectedItem().equals(archtype.getName())) {
            ygoproArchtype.getSelectionModel().selectFirst();
        }
        if (ygoproSecondaryArchtype.getSelectionModel().getSelectedItem().equals(archtype.getName())) {
            ygoproSecondaryArchtype.getSelectionModel().selectFirst();
        }
        archtypeData.remove(archtype);
        ygoproArchtype.getItems().remove(archtype.getName());
        ygoproSecondaryArchtype.getItems().remove(archtype.getName());
        cardData.forEach(c -> {
            if (c.getArchtype().equals(archtype.getName())) {
                c.setArchtype("");
            }
            if (c.getSecondaryArchtype().equals(archtype.getName())) {
                c.setSecondaryArchtype("");
            }
        });
        if (archtypeData.isEmpty()) {
            deleteArchtypeButton.setDisable(true);
        }
    }
}
