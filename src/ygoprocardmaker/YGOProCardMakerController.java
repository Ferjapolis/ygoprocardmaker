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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
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
import javafx.stage.Stage;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;
import netscape.javascript.JSObject;
import org.controlsfx.control.Notifications;
import org.json.JSONArray;
import org.json.JSONObject;
import ygoprocardmaker.data.Archtype;
import ygoprocardmaker.data.Card;
import static ygoprocardmaker.enumerate.CardAttribute.*;
import static ygoprocardmaker.enumerate.CardMonsterType.*;
import static ygoprocardmaker.enumerate.CardType.*;
import static ygoprocardmaker.enumerate.CardFormat.*;
import ygoprocardmaker.exception.InvalidFieldException;
import ygoprocardmaker.exception.InvalidPictureException;
import ygoprocardmaker.util.FileUtils;
import ygoprocardmaker.util.ImageUtils;
import ygoprocardmaker.util.JavaFXUtils;
import ygoprocardmaker.util.RegexUtils;
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
    private TextField cardLevelRank;

    @FXML
    private TextField cardLeftScale;

    @FXML
    private TextField cardRightScale;

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
    private Label cardPendulumScaleLabel;

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
    private TextField extensionName;

    @FXML
    private TextField extensionCode;

    @FXML
    private ChoiceBox<String> baseArchtypes;

    @FXML
    private TableView<Archtype> archtypeTable;

    @FXML
    private TableColumn<Archtype, String> archtypeNameColumn;

    @FXML
    private TableColumn<Archtype, String> archtypeCodeColumn;

    @FXML
    private Button deleteArchtypeButton;

    @FXML
    private Button extensionArchtypeButton;

    @FXML
    private Label archtypeBaseLabel;

    @FXML
    private Label extensionNameLabel;

    @FXML
    private Label extensionCodeLabel;

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
    private TableColumn<Card, String> leftScaleColumn;

    @FXML
    private TableColumn<Card, String> rightScaleColumn;

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
            try {
                saveCard(getCardById(), true);
            } catch (InvalidFieldException ex) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Save Card");
                alert.setHeaderText(null);
                alert.setContentText(ex.getMessage());
                alert.showAndWait();
                return;
            }
            Notifications.create()
                    .title("Save Card")
                    .text("Card saved successfully!")
                    .show();
        }
    }

    @FXML
    private void handleOpenCardButton() {
        if (cardChanged()) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Open Card");
            alert.setHeaderText(null);
            alert.setContentText("Do you wish to save before opening another card?\n"
                    + "If you don't, changes will be lost.");
            ButtonType buttonTypeOpenSave = new ButtonType("Save & Open");
            ButtonType buttonTypeCancel = new ButtonType("Cancel");
            alert.getButtonTypes().setAll(buttonTypeOpenSave, new ButtonType("Open"), buttonTypeCancel);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == buttonTypeOpenSave) {
                try {
                    saveCard(getCardById(), true);
                } catch (InvalidFieldException ex) {
                    alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Save Card");
                    alert.setHeaderText(null);
                    alert.setContentText(ex.getMessage());
                    alert.showAndWait();
                    return;
                }
                Notifications.create()
                        .title("Save Card")
                        .text("Card saved successfully!")
                        .show();
            } else if (result.get() == buttonTypeCancel) {
                return;
            }
        }
        if (openCard(cardTable.getSelectionModel().getSelectedItem())) {
            Notifications.create()
                    .title("Open Card")
                    .text("Card opened successfully!")
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
                try {
                    saveCard(getCardById(), true);
                } catch (InvalidFieldException ex) {
                    alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Save Card");
                    alert.setHeaderText(null);
                    alert.setContentText(ex.getMessage());
                    alert.showAndWait();
                    return;
                }
                Notifications.create()
                        .title("Save Card")
                        .text("Card saved successfully!")
                        .show();
            } else if (result.get() == buttonTypeCancel) {
                return;
            }
        }
        try {
            newCard();
        } catch (InvalidFieldException ex) { // will never happen
        }
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
            try {
                deleteCard();
            } catch (InvalidFieldException ex) { // will never happen
            }
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
        fileChooser.setInitialDirectory(new File("."));
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
        } else if (!RegexUtils.isPositiveInteger(archtypeCode.getText())) {
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
        if (archtypeTable.getSelectionModel().getSelectedItem() == null) {
            return;
        }
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Delete Archtype");
        alert.setHeaderText(null);
        alert.setContentText("Every card with this archtype, will lose it!\n"
                + "Do you wish to continue?");
        ButtonType buttonTypeDelete = new ButtonType("Delete");
        alert.getButtonTypes().setAll(buttonTypeDelete, new ButtonType("Cancel"));
        if (alert.showAndWait().get() == buttonTypeDelete) {
            deleteArchtype(archtypeData.get(archtypeData.indexOf(archtypeTable.getSelectionModel().getSelectedItem())));
            Notifications.create()
                    .title("Delete Archtype")
                    .text("Archtype deleted successfully!")
                    .show();
        }
    }

    @FXML
    private void handleExtensionArchtypeButton() {
        if (baseArchtypes.getValue() == null || baseArchtypes.getValue().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid Base Archtype Name");
            alert.setHeaderText(null);
            alert.setContentText("Select an existing base archtype.");
            alert.showAndWait();
        } else if (extensionName.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid Extension Archtype Name");
            alert.setHeaderText(null);
            alert.setContentText("Extension Archtype name cannot not be empty.");
            alert.showAndWait();
        } else if (extensionCode.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid Extension Archtype Code");
            alert.setHeaderText(null);
            alert.setContentText("Extension Archtype code cannot not be empty.");
            alert.showAndWait();
        } else if (!RegexUtils.isPositiveInteger(extensionCode.getText())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid Extension Archtype Code");
            alert.setHeaderText(null);
            alert.setContentText("Extension Archtype code must be a positive integer.");
            alert.showAndWait();
        } else {
            addExtensionArchtype();
            Notifications.create()
                    .title("Add Archtype")
                    .text("Archtype added successfully!")
                    .show();
        }
    }

    @FXML
    private void handleNewSetMenuItem() {
        try {
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
                            fileChooser.setInitialDirectory(new File("."));
                            fileChooser.getExtensionFilters().addAll(new ExtensionFilter("YGOProCardMakerSet (*.ygopcms)", "*.ygopcms"));
                            set = fileChooser.showSaveDialog(null);
                            if (set == null) {
                                return;
                            }
                        }
                        if (cardChanged()) {
                            alert = new Alert(AlertType.CONFIRMATION);
                            alert.setTitle("New Set");
                            alert.setHeaderText(null);
                            alert.setContentText("Do you wish to save the current card before saving the set?\n"
                                    + "If you don't, changes will be lost.");
                            ButtonType buttonTypeSaveExport = new ButtonType("Save & Export");
                            alert.getButtonTypes().setAll(buttonTypeSaveExport, new ButtonType("Export"), buttonTypeCancel);
                            result = alert.showAndWait();
                            if (result.get() == buttonTypeSaveExport) {
                                try {
                                    saveCard(getCardById(), true);
                                    Notifications.create()
                                            .title("Save Card")
                                            .text("Card saved successfully!")
                                            .show();
                                } catch (InvalidFieldException ex) {
                                    alert = new Alert(AlertType.WARNING);
                                    alert.setTitle("Save Card");
                                    alert.setHeaderText(null);
                                    alert.setContentText(ex.getMessage());
                                    alert.showAndWait();
                                    return;
                                }
                            } else if (result.get() == buttonTypeCancel) {
                                return;
                            }
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
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("File Error");
            alert.setHeaderText(null);
            alert.setContentText("Couldn't create new set.");
            JavaFXUtils.setExceptionAlert(alert, ex).showAndWait();
            return;
        }
        newSet();
        Notifications.create()
                .title("New Set")
                .text("Set created successfully!")
                .show();
    }

    @FXML
    private void handleOpenSetMenuItem() {
        try {
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
                            fileChooser.setInitialDirectory(new File("."));
                            fileChooser.getExtensionFilters().addAll(new ExtensionFilter("YGOProCardMakerSet (*.ygopcms)", "*.ygopcms"));
                            set = fileChooser.showSaveDialog(null);
                            if (set == null) {
                                return;
                            }
                        }
                        if (cardChanged()) {
                            alert = new Alert(AlertType.CONFIRMATION);
                            alert.setTitle("Open Set");
                            alert.setHeaderText(null);
                            alert.setContentText("Do you wish to save the current card before saving the set?\n"
                                    + "If you don't, changes will be lost.");
                            ButtonType buttonTypeSaveExport = new ButtonType("Save & Export");
                            alert.getButtonTypes().setAll(buttonTypeSaveExport, new ButtonType("Export"), buttonTypeCancel);
                            result = alert.showAndWait();
                            if (result.get() == buttonTypeSaveExport) {
                                try {
                                    saveCard(getCardById(), true);
                                    Notifications.create()
                                            .title("Save Card")
                                            .text("Card saved successfully!")
                                            .show();
                                } catch (InvalidFieldException ex) {
                                    alert = new Alert(AlertType.WARNING);
                                    alert.setTitle("Save Card");
                                    alert.setHeaderText(null);
                                    alert.setContentText(ex.getMessage());
                                    alert.showAndWait();
                                    return;
                                }
                            } else if (result.get() == buttonTypeCancel) {
                                return;
                            }
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
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("File Error");
            alert.setHeaderText(null);
            alert.setContentText("Couldn't open set.");
            JavaFXUtils.setExceptionAlert(alert, ex).showAndWait();
            return;
        }
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Card Set");
        fileChooser.setInitialDirectory(new File("."));
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
        if (cardChanged()) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Save Set");
            alert.setHeaderText(null);
            alert.setContentText("Do you wish to save the current card before saving the set?\n"
                    + "If you don't, changes will be lost.");
            ButtonType buttonTypeSaveExport = new ButtonType("Save & Export");
            ButtonType buttonTypeCancel = new ButtonType("Cancel");
            alert.getButtonTypes().setAll(buttonTypeSaveExport, new ButtonType("Export"), buttonTypeCancel);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == buttonTypeSaveExport) {
                try {
                    saveCard(getCardById(), true);
                    Notifications.create()
                            .title("Save Card")
                            .text("Card saved successfully!")
                            .show();
                } catch (InvalidFieldException ex) {
                    alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Save Card");
                    alert.setHeaderText(null);
                    alert.setContentText(ex.getMessage());
                    alert.showAndWait();
                    return;
                }
            } else if (result.get() == buttonTypeCancel) {
                return;
            }
        }
        File set;
        if (setFile == null) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save Card Set");
            fileChooser.setInitialDirectory(new File("."));
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
        if (cardChanged()) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Save Set");
            alert.setHeaderText(null);
            alert.setContentText("Do you wish to save the current card before saving the set?\n"
                    + "If you don't, changes will be lost.");
            ButtonType buttonTypeSaveExport = new ButtonType("Save & Export");
            ButtonType buttonTypeCancel = new ButtonType("Cancel");
            alert.getButtonTypes().setAll(buttonTypeSaveExport, new ButtonType("Export"), buttonTypeCancel);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == buttonTypeSaveExport) {
                try {
                    saveCard(getCardById(), true);
                    Notifications.create()
                            .title("Save Card")
                            .text("Card saved successfully!")
                            .show();
                } catch (InvalidFieldException ex) {
                    alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Save Card");
                    alert.setHeaderText(null);
                    alert.setContentText(ex.getMessage());
                    alert.showAndWait();
                    return;
                }
            } else if (result.get() == buttonTypeCancel) {
                return;
            }
        }
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Card Set");
        fileChooser.setInitialDirectory(new File("."));
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("YGOProCardMakerSet (*.ygopcms)", "*.ygopcms"));
        File set = fileChooser.showSaveDialog(null);
        if (set == null) {
            return;
        }
        if (!set.getPath().toLowerCase().endsWith(".ygopcms")) {
            set = new File(set.getPath() + ".ygopcms");
        }
        try {
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
        if (cardChanged()) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Export Set");
            alert.setHeaderText(null);
            alert.setContentText("Do you wish to save the current card before exporting?\n"
                    + "If you don't, changes will not be exported.");
            ButtonType buttonTypeSaveExport = new ButtonType("Save & Export");
            ButtonType buttonTypeCancel = new ButtonType("Cancel");
            alert.getButtonTypes().setAll(buttonTypeSaveExport, new ButtonType("Export"), buttonTypeCancel);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == buttonTypeSaveExport) {
                try {
                    saveCard(getCardById(), true);
                    Notifications.create()
                            .title("Save Card")
                            .text("Card saved successfully!")
                            .show();
                } catch (InvalidFieldException ex) {
                    alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Save Card");
                    alert.setHeaderText(null);
                    alert.setContentText(ex.getMessage());
                    alert.showAndWait();
                    return;
                }
            } else if (result.get() == buttonTypeCancel) {
                return;
            }
        }
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

    @FXML
    private void handleAboutMenuItem() {
        Alert alert = new Alert(null);
        alert.setTitle("About");
        alert.setHeaderText(null);
        alert.setContentText("YGOProCardMaker\n\nCreate, manage and export custom YGOPro cards.\n\nAuthor: DracoStriker\nSource: https://github.com/DracoStriker/ygoprocardmaker");
        alert.getButtonTypes().setAll(new ButtonType("Close"));
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(this.getClass().getResource("resource/pics/icon.png").toString()));
        alert.showAndWait();
    }

    private boolean cardChanged() {
        Card card = getCardById();
        boolean isSpellTrap = currentCardType.equals("Spell") || currentCardType.equals("Trap");
        return !cardName.getText().equals(card.getName())
                || !cardType.getValue().equals(card.getType())
                || !cardSubType.getValue().equals(card.getSubType())
                || (isSpellTrap ? false : !cardSubSubType.getValue().equals(card.getSubSubType()))
                || (isSpellTrap ? false : !cardAttribute.getValue().equals(card.getAttribute()))
                || (isSpellTrap ? false : !cardLevelRank.getText().equals(card.getLevelRank()))
                || (isSpellTrap ? false : !cardLeftScale.getText().equals(card.getLeftScale()))
                || (isSpellTrap ? false : !cardRightScale.getText().equals(card.getRightScale()))
                || (isSpellTrap ? false : !cardMonsterType.getValue().equals(card.getMonsterType()))
                || (isSpellTrap ? false : !cardATK.getText().equals(card.getAtk()))
                || (isSpellTrap ? false : !cardDEF.getText().equals(card.getDef()))
                || !cardSerial.getText().equals(card.getSerial())
                || !cardLoreEffect.getText().equals(card.getLoreEffect())
                || !ygoproAlias.getText().equals(card.getAlias())
                || !ygoproArchtype.getValue().equals(card.getArchtype())
                || !ygoproSecondaryArchtype.getValue().equals(card.getSecondaryArchtype())
                || !ygoproFormat.getValue().equals(card.getFormat())
                || ygoproSTDestroy.isSelected() != card.issTDestroy()
                || ygoproBacktoHand.isSelected() != card.isBacktoHand()
                || ygoproDraw.isSelected() != card.isDraw()
                || ygoproControl.isSelected() != card.isControl()
                || ygoproLimitAttack.isSelected() != card.isLimitAttack()
                || ygoproTypeRelated.isSelected() != card.isTypeRelated()
                || ygoproDestroy.isSelected() != card.isDestroy()
                || ygoproFusionRelated.isSelected() != card.isFusionRelated()
                || ygoproDestroyMonster.isSelected() != card.isDestroyMonster()
                || ygoproBackToDeck.isSelected() != card.isBackToDeck()
                || ygoproSearch.isSelected() != card.isSearch()
                || ygoproChangeATKDEF.isSelected() != card.isChangeATKDEF()
                || ygoproDirectAttack.isSelected() != card.isDirectAttack()
                || ygoproPropertyRelated.isSelected() != card.isPropertyRelated()
                || ygoproSelect.isSelected() != card.isSelect()
                || ygoproTunerRelated.isSelected() != card.isTunerRelated()
                || ygoproBanish.isSelected() != card.isBanish()
                || ygoproDestroyHand.isSelected() != card.isDestroyHand()
                || ygoproRecovery.isSelected() != card.isRecovery()
                || ygoproPiercing.isSelected() != card.isPiercing()
                || ygoproSpecialSummon.isSelected() != card.isSpecialSummon()
                || ygoproDamageLP.isSelected() != card.isDamageLP()
                || ygoproCounter.isSelected() != card.isCounter()
                || ygoproXyzRelated.isSelected() != card.isXyzRelated()
                || ygoproGraveyard.isSelected() != card.isGraveyard()
                || ygoproDestroyDeck.isSelected() != card.isDestroyDeck()
                || ygoproPosition.isSelected() != card.isPosition()
                || ygoproRepeatAttack.isSelected() != card.isRepeatAttack()
                || ygoproToken.isSelected() != card.isToken()
                || ygoproRecoveryLP.isSelected() != card.isRecoveryLP()
                || ygoproGamble.isSelected() != card.isGamble()
                || ygoproNegateEffect.isSelected() != card.isNegateEffect()
                || !ygoproString1.getText().equals(card.getString1())
                || !ygoproString2.getText().equals(card.getString2())
                || !ygoproString3.getText().equals(card.getString3())
                || !ygoproString4.getText().equals(card.getString4())
                || !ygoproString5.getText().equals(card.getString5())
                || !ygoproString6.getText().equals(card.getString6())
                || !ygoproString7.getText().equals(card.getString7())
                || !ygoproString8.getText().equals(card.getString8())
                || !ygoproString9.getText().equals(card.getString9())
                || !ygoproString10.getText().equals(card.getString10())
                || !ygoproString11.getText().equals(card.getString11())
                || !ygoproString12.getText().equals(card.getString12())
                || !ygoproString13.getText().equals(card.getString13())
                || !ygoproString14.getText().equals(card.getString14())
                || !ygoproString15.getText().equals(card.getString15())
                || !ygoproString16.getText().equals(card.getString16())
                || (card.getPicture() == null ? hasPicture : !ImageUtils.compareImages(SwingFXUtils.fromFXImage(cardPicture.getImage(), null), SwingFXUtils.fromFXImage(card.getPicture(), null)))
                || !scriptEditor.getEngine().executeScript("editor.getValue();").equals(card.getScript());
    }

    private boolean setChanged() throws IOException {
        if (setFile == null) {
            return false;
        }
        char[] buf;
        try (FileReader file = new FileReader(setFile)) {
            buf = new char[(int) setFile.length()];
            file.read(buf);
        }
        JSONObject json = new JSONObject(new String(buf));
        List<Archtype> savedArchtypes = new ArrayList<>();
        JSONArray archtypes = json.getJSONArray("archtypes");
        for (int i = 0; i < archtypes.length(); i++) {
            Archtype archtype = Archtype.fromJSON(archtypes.getJSONObject(i));
            if (!archtype.getName().equals("") && RegexUtils.isPositiveInteger(archtype.getCode())) {
                savedArchtypes.add(archtype);
            }
        }
        List<Card> savedCards = new ArrayList<>();
        JSONArray cards = json.getJSONArray("cards");
        for (int i = 0; i < cards.length(); i++) {
            savedCards.add(Card.fromJSON(cards.getJSONObject(i)));
        }
        if (!setTitle.getText().equals(json.getString("name"))
                || !setAuthor.getText().equals(json.getString("author"))
                || !setDescription.getText().equals(json.getString("description"))) {
            return true;
        }
        if (savedArchtypes.size() != archtypeData.size()) {
            return true;
        }
        for (Archtype archtype : savedArchtypes) {
            Archtype other = archtypeData.get(archtypeData.indexOf(archtype));
            if (other == null || Archtype.differ(archtype, other)) {
                return true;
            }
        }
        for (Card card : savedCards) {
            Card other = cardData.get(cardData.indexOf(card));
            if (other == null || Card.differ(card, other)) {
                return true;
            }
        }
        return false;
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
        cardMonsterType.getItems().setAll(MONSTER_TYPES);
        cardMonsterType.getSelectionModel().selectFirst();
        cardPendulumScaleLabel.setDisable(true);
        cardLeftScale.setDisable(true);
        cardRightScale.setDisable(true);
        cardPicture.setImage(new Image(getClass().getResourceAsStream("resource/pics/unknown.png")));
    }

    private void initializeYGOProInfo() {
        ygoproArchtype.getItems().setAll(EMPTY);
        ygoproArchtype.getSelectionModel().selectFirst();
        ygoproSecondaryArchtype.getItems().setAll(EMPTY);
        ygoproSecondaryArchtype.getSelectionModel().selectFirst();
        ygoproFormat.getItems().setAll(FORMATS);
        ygoproFormat.getSelectionModel().select("OCG/TCG");
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
        baseArchtypes.setDisable(true);
        extensionName.setDisable(true);
        extensionCode.setDisable(true);
        archtypeBaseLabel.setDisable(true);
        extensionNameLabel.setDisable(true);
        extensionCodeLabel.setDisable(true);
        extensionArchtypeButton.setDisable(true);
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
        leftScaleColumn.setCellValueFactory(new PropertyValueFactory<>("leftScale"));
        rightScaleColumn.setCellValueFactory(new PropertyValueFactory<>("rightScale"));
        monsterTypeColumn.setCellValueFactory(new PropertyValueFactory<>("monsterType"));
        atkColumn.setCellValueFactory(new PropertyValueFactory<>("atk"));
        defColumn.setCellValueFactory(new PropertyValueFactory<>("def"));
        loreEffectColumn.setCellValueFactory(new PropertyValueFactory<>("loreEffect"));
        serialColumn.setCellValueFactory(new PropertyValueFactory<>("serial"));
        cardTable.setItems(cardData);
        Card card = new Card(currentCardId);
        cardData.add(card);
        try {
            saveCard(card, false);
        } catch (InvalidFieldException ex) { // will never happen
        }
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
        cardPendulumScaleLabel.setDisable(!currentCardType.equals("Pendulum"));
        cardLeftScale.setDisable(!currentCardType.equals("Pendulum"));
        cardRightScale.setDisable(!currentCardType.equals("Pendulum"));
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
        cardPendulumScaleLabel.setDisable(!currentCardType.equals("Pendulum") && !newSubCardType.equals("Pendulum"));
        cardLeftScale.setDisable(!currentCardType.equals("Pendulum") && !newSubCardType.equals("Pendulum"));
        cardRightScale.setDisable(!currentCardType.equals("Pendulum") && !newSubCardType.equals("Pendulum"));
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

    private void saveCard(Card card, boolean loaded) throws InvalidFieldException {
        if (!RegexUtils.isPositiveInteger(cardATK.getText())) {
            throw new InvalidFieldException("ATK field must have have a integer number.");
        }
        if (!RegexUtils.isPositiveInteger(cardDEF.getText())) {
            throw new InvalidFieldException("DEF field must have have a integer number.");
        }
        if (!RegexUtils.isPositiveInteger(cardLevelRank.getText())) {
            throw new InvalidFieldException("Level/Rank field must have have a integer number.");
        }
        if (!RegexUtils.isPositiveInteger(cardLeftScale.getText())) {
            throw new InvalidFieldException("Pendulum Left Scale field must have have a integer number.");
        }
        if (!RegexUtils.isPositiveInteger(cardLevelRank.getText())) {
            throw new InvalidFieldException("Pendulum Right Scale field must have have a integer number.");
        }
        if (!RegexUtils.isPositiveInteger(cardSerial.getText())) {
            throw new InvalidFieldException("Serial field must have have a integer number.");
        }
        if (!RegexUtils.isPositiveInteger(cardSerial.getText())) {
            throw new InvalidFieldException("Alias field must have have a integer number.");
        }
        card.setName(cardName.getText())
                .setType(cardType.getValue())
                .setSubType(cardSubType.getValue())
                .setSubSubType(cardSubSubType.getValue())
                .setAttribute(cardAttribute.getValue())
                .setLevelRank(cardLevelRank.getText())
                .setLeftScale(cardLeftScale.getText())
                .setRightScale(cardRightScale.getText())
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

    private boolean openCard(Card card) {
        if (card == null) {
            return false;
        }
        currentCardId = card.getId();
        cardName.setText(card.getName());
        cardType.setValue(card.getType());
        cardSubType.setValue(card.getSubType());
        cardSubSubType.setValue(card.getSubSubType());
        cardAttribute.setValue(card.getAttribute());
        cardLevelRank.setText(card.getLevelRank());
        cardLeftScale.setText(card.getLeftScale());
        cardRightScale.setText(card.getRightScale());
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
        cardTable.getSelectionModel().select(card);
        return true;
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

    private void newCard() throws InvalidFieldException {
        cardName.setText("");
        cardType.setValue("Monster");
        cardSubType.setValue("Normal");
        cardSubSubType.setValue("");
        cardAttribute.setValue("EARTH");
        cardLevelRank.setText("");
        cardLeftScale.setText("");
        cardRightScale.setText("");
        cardMonsterType.setValue("Warrior");
        cardATK.setText("");
        cardDEF.setText("");
        cardLoreEffect.setText("");
        cardSerial.setText("");
        ygoproAlias.setText("");
        ygoproArchtype.setValue("");
        ygoproSecondaryArchtype.setValue("");
        ygoproFormat.setValue("OCG/TCG");
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
        openCard(card);
    }

    private void deleteCard() throws InvalidFieldException {
        Card card = getCardById();
        int index = cardData.indexOf(card);
        cardData.remove(card);
        if (cardData.size() == 0) {
            newCard();
        } else {
            openCard(cardData.get(index == cardData.size() ? cardData.size() - 1 : index));
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
        baseArchtypes.setDisable(true);
        extensionName.setDisable(true);
        extensionCode.setDisable(true);
        archtypeBaseLabel.setDisable(true);
        extensionNameLabel.setDisable(true);
        extensionCodeLabel.setDisable(true);
        extensionArchtypeButton.setDisable(true);
        baseArchtypes.getItems().clear();
        ygoproArchtype.getItems().setAll(EMPTY);
        ygoproArchtype.getSelectionModel().selectFirst();
        ygoproSecondaryArchtype.getItems().setAll(EMPTY);
        ygoproSecondaryArchtype.getSelectionModel().selectFirst();
        try {
            newCard();
        } catch (InvalidFieldException ex) { // will never happen
        }
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
        archtypeData.clear();
        baseArchtypes.getItems().clear();
        ygoproArchtype.getItems().clear();
        ygoproArchtype.getItems().setAll(EMPTY);
        ygoproSecondaryArchtype.getItems().clear();
        ygoproSecondaryArchtype.getItems().setAll(EMPTY);
        JSONArray archtypes = json.getJSONArray("archtypes");
        for (int i = 0; i < archtypes.length(); i++) {
            Archtype archtype = Archtype.fromJSON(archtypes.getJSONObject(i));
            if (!archtype.getName().equals("") && RegexUtils.isPositiveInteger(archtype.getCode())) {
                archtypeData.add(archtype);
            }
        }
        archtypeData.stream().forEach(archtype -> {
            ygoproArchtype.getItems().add(archtype.getName());
            ygoproSecondaryArchtype.getItems().add(archtype.getName());
            if (Integer.parseInt(archtype.getCode()) <= 0xFFF) {
                baseArchtypes.getItems().add(archtype.getName());
            }
        });
        deleteArchtypeButton.setDisable(archtypeData.isEmpty());
        baseArchtypes.setDisable(baseArchtypes.getItems().isEmpty());
        extensionName.setDisable(baseArchtypes.getItems().isEmpty());
        extensionCode.setDisable(baseArchtypes.getItems().isEmpty());
        archtypeBaseLabel.setDisable(baseArchtypes.getItems().isEmpty());
        extensionNameLabel.setDisable(baseArchtypes.getItems().isEmpty());
        extensionCodeLabel.setDisable(baseArchtypes.getItems().isEmpty());
        extensionArchtypeButton.setDisable(baseArchtypes.getItems().isEmpty());
        cardData.clear();
        JSONArray cards = json.getJSONArray("cards");
        for (int i = 0; i < cards.length(); i++) {
            cardData.add(Card.fromJSON(cards.getJSONObject(i)));
        }
        openCard(cardData.get(0));
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
                    BufferedImage image = SwingFXUtils.fromFXImage(card.getPicture(), null);
                    BufferedImage imageRGB = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.OPAQUE);
                    Graphics2D graphics = imageRGB.createGraphics();
                    graphics.drawImage(image, 0, 0, null);
                    ImageWriter jpgWriter = ImageIO.getImageWritersByFormatName("jpg").next();
                    ImageWriteParam jpgWriteParam = jpgWriter.getDefaultWriteParam();
                    jpgWriteParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
                    jpgWriteParam.setCompressionQuality(1.0f);
                    FileImageOutputStream outputStream = new FileImageOutputStream(new File("pics" + File.separator + card.getSerial() + ".jpg")); //For example, FileImageOutputStream
                    jpgWriter.setOutput(outputStream);
                    IIOImage outputImage = new IIOImage(imageRGB, null, null);
                    jpgWriter.write(null, outputImage, jpgWriteParam);
                    jpgWriter.dispose();
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
                .setCode("" + (Integer.parseInt(archtypeCode.getText()) & 0xFFF)));
        ygoproArchtype.getItems().add(archtypeName.getText());
        ygoproSecondaryArchtype.getItems().add(archtypeName.getText());
        baseArchtypes.getItems().add(archtypeName.getText());
        if (deleteArchtypeButton.isDisabled()) {
            deleteArchtypeButton.setDisable(false);
        }
        if (baseArchtypes.isDisabled()) {
            baseArchtypes.setDisable(false);
        }
        if (extensionName.isDisabled()) {
            extensionName.setDisable(false);
        }
        if (extensionCode.isDisabled()) {
            extensionCode.setDisable(false);
        }
        if (extensionArchtypeButton.isDisabled()) {
            extensionArchtypeButton.setDisable(false);
        }
        if (archtypeBaseLabel.isDisabled()) {
            archtypeBaseLabel.setDisable(false);
        }
        if (extensionNameLabel.isDisabled()) {
            extensionNameLabel.setDisable(false);
        }
        if (extensionCodeLabel.isDisabled()) {
            extensionCodeLabel.setDisable(false);
        }
        archtypeName.setText("");
        archtypeCode.setText("");
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
        if (Integer.parseInt(archtype.getCode()) <= 0xFFF) {
            baseArchtypes.getItems().remove(archtype.getName());
        }
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
        if (baseArchtypes.getItems().isEmpty()) {
            extensionName.setText("");
            extensionCode.setText("");
            baseArchtypes.setDisable(true);
            extensionName.setDisable(true);
            extensionCode.setDisable(true);
            extensionArchtypeButton.setDisable(true);
            archtypeBaseLabel.setDisable(true);
            extensionNameLabel.setDisable(true);
            extensionCodeLabel.setDisable(true);
        }
    }

    private void addExtensionArchtype() {
        String name = extensionName.getText() + " " + baseArchtypes.getValue();
        archtypeData.add(new Archtype(name)
                .setCode("" + (((Integer.parseInt(extensionCode.getText()) & 0xF) << 12) | (Integer.parseInt(archtypeData.get(archtypeData.indexOf(new Archtype(baseArchtypes.getValue()))).getCode()) & 0xFFF))));
        ygoproArchtype.getItems().add(name);
        ygoproSecondaryArchtype.getItems().add(name);
    }
}
