package org.example.plophci;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class HomeApplication extends Application {
    @FXML
    private VBox vBox;
    @FXML
    private HBox hbox;
    @FXML
    private CheckBox checkBox;
    @FXML
    private TextArea textArea;
    private boolean skillsPlanAdded = false;
    private boolean studentProfileAdded = false;
    private boolean benchmarkAdded = false;
    private boolean scoreSnapshotsAdded = false;
    private boolean scoresSummaryAdded = false;
    private boolean scoreComparisonAdded = false;
    private boolean scoreSummaryAdded = false;
    private boolean studentReportAdded = false;
    private boolean starTestRecordAdded = false;

    private boolean annualProgAdded = false;

    private boolean starDiagnosticAdded = false;
    private boolean bellCurveAdded = false;
    private boolean generalSummaryAdded = false;
    private boolean interpretiveOverviewAdded = false;
    private boolean tableOfScoresAdded = false;
    private boolean testsAdministerdAdded = false;







    private static final String TEXT_DISPLAYED = "Woodcock Johnson:\n" +
            "\n" +
            "A Comprehensive battery of standardized tests and clusters designed to evaluate cognitive abilities and academic achievement across the domains of reading, written language, mathematics, and academic knowledge.\n" +
            "\n" +
            "STAR:\n" +
            "\n" +
            "Computer-adaptive achievement tests that measure reading and math skills. As a student takes the assessment, the assessment alters the following questions based on student’s previous responses. Through the adjustment of difficulty per item, based on what the student has shown they can or cannot do, student achievement is measured.\n" +
            "\n" +
            "AIMSWEB PLUS:\n" +
            "\n" +
            "Online assessment, Data Management and Reporting System that provides national/local performance along with developmental norms in tracking the initial assessment along with progress monitoring of math/reading skills. aimswebPlus is used for benchmarking, universal screening and diagnosing strengths and weaknesses in reading/math. It provides teachers with differentiated instructional support based on student scores and Lexile equivalencies for reading instruction/Quantile equivalency for math.\n" +
            "\n" +
            "CMAS:\n" +
            "\n" +
            "The state of Colorado has the end of year standardized test called, Colorado Measures of Academic Success (CMAS). Colorado Measures of Academic Success (CMAS) measures student achievement and growth for English language arts and mathematics to all students in grades 3-8, Science in grade 5, grade 8, and grade 11.\n" +
            "\n" +
            "Observations:\n" +
            "\n" +
            "Observations conducted by multiple educational experts help the IEP team understand the student’s whole educational experience. Observers look at the instruction being delivered, how it is being delivered and how the student is receiving that delivery. The observers can see how the student performs in one class vs. others, big groups vs. small, etc. The observers look at the students’ social behaviors and how he/she interacts with peers, adults and does by his/herself.\n" +
            "\n" +
            "IEP Goal Progress:\n" +
            "\n" +
            "To determine how a student is performing, the IEP team must look at progress monitoring of each iep goal from the previous IEP. This allows the team to determine if the student should continue working on the previous year’s IEP goals or if new ones should be written. If a new goal is to be written, documented progress should be considered.\n" +
            "\n" +
            "Social Developmental History:\n" +
            "\n" +
            "A social developmental history is collected from the student’s guardian to help the IEP team understand the student as a whole. Outside diagnoses, trauma history, family history and more are documented.\n" +
            "\n" +
            "FBA/BIP Synopsis:\n" +
            "\n" +
            "A functional behavioral assessment is conducted when students are displaying consistent negative behaviors at school. This allows the team to collect more data on the behavior and reason behind the behavior. If decided a Behavior Intervention is to be put in place, the IEP team will utilize the data from the Functional Behavior Assessment to create a plan for the school staff to follow (Behavioral Intervention Plan).\n" +
            "\n" +
            "Last Evaluation Summary:\n" +
            "\n" +
            "Summary from the last re-evaluation.\n" +
            "\n" +
            "Additional Valuable Information: ";
    Image testsAdministered;
    Image tableOfScores;
    Image interpretiveOverview;
    Image generalSummary;
    Image bellCurve;
    Image starDiagnostic;
    Image annualProg;
    Image starTestRecord;
    Image studentReport;
    Image scoreSummary;
    Image scoreComposition;
    Image skillsPlan;
    Image studentProfile;
    Image individualBenchmark;
    Image scoreSnapshot;
    Image scoresSummary;


    private double previousSceneHeight = 600;
    private double previousSceneWidth = 1015;


    @Override
    public void start(Stage stage) throws IOException {
//        Image customIcon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("JavaPics/greenSocietyIcon.png")));
//        stage.getIcons().add(customIcon);
        stage.initStyle(StageStyle.DECORATED);
        launchHomePage(stage);

    }

    public void switchHome(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        saveCurrentSceneDimensions(stage);
        launchHomePage(stage);
    }

    private void launchHomePage(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HomeApplication.class.getResource("fxmlFiles/greenSociety.fxml"));
        Parent root = fxmlLoader.load();
        String css = Objects.requireNonNull(this.getClass().getResource("CssFiles/home.css")).toExternalForm();
        Scene scene = new Scene(root, previousSceneWidth, previousSceneHeight);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.setTitle("Present Levels of Academic Achievement And Functional Performance");
        stage.show();
    }

    @FXML
    private void handleCheckBox(ActionEvent event) {
        if (checkBox.isSelected()) {
            textArea.appendText(TEXT_DISPLAYED);
        } else {
            textArea.clear();
        }
    }

    @FXML
    private void switchTestsAdministered(ActionEvent event) {
        try {
            InputStream stream = getClass().getResourceAsStream("JavaPics/HCI/testsAdministered.png");
            testsAdministered = new Image(stream);
            if (!testsAdministerdAdded) {

                ImageView imageView = new ImageView(testsAdministered);
                imageView.setFitWidth(600);
                imageView.setFitHeight(200);

                TextArea textArea = hbox.getChildren().isEmpty() ? createTextArea() : (TextArea) hbox.getChildren().get(1);
                textArea.setPrefWidth(900);
                textArea.setPrefHeight(200);
                textArea.setEditable(true);
                textArea.setWrapText(true);

                Button clearButton = new Button("Clear Data");
                clearButton.setStyle("-fx-background-color: #ff6f00; -fx-text-fill: #030303; -fx-font-weight: bold;");

                CheckBox checkBox = new CheckBox("Include Header Recommendations");

                Label label = new Label("PLOP: Woodcock Johnson: Tests Administered");

                HBox hBoxContainer = new HBox();

                hBoxContainer.getChildren().addAll(clearButton, checkBox, label);
                hBoxContainer.setMargin(clearButton, new Insets(0, 0, 0, 15));
                hBoxContainer.setMargin(checkBox, new Insets(0, 0, 0, 50));
                hBoxContainer.setMargin(label, new Insets(0, 0, 0, 40));

                clearButton.setOnAction(e -> {
                    imageView.setImage(null);

                });

                checkBox.setOnAction(e -> {
                    if (checkBox.isSelected()) {
                        textArea.appendText("Woodcock Johnson:\n" +
                                "\n" +
                                "A Comprehensive battery of standardized tests and clusters designed to evaluate cognitive abilities and academic achievement across the domains of reading, written language, mathematics, and academic knowledge.");
                    } else {
                        textArea.clear();
                    }
                });

                vBox.getChildren().add(hBoxContainer);

                HBox sectionContainer = new HBox();

                sectionContainer.getChildren().addAll(imageView, textArea);
                vBox.getChildren().add(sectionContainer);
                testsAdministerdAdded = true;
            }

        } catch (Exception e) {
            System.err.println("Failed to load image: " + e.getMessage());
        }
    }

    @FXML
    private void switchTableOfScores(ActionEvent event) {
        try {
            InputStream stream = getClass().getResourceAsStream("JavaPics/HCI/tableOfScores.png");
            tableOfScores = new Image(stream);
            if (!tableOfScoresAdded) {

                ImageView imageView = new ImageView(tableOfScores);
                imageView.setFitWidth(400);
                imageView.setFitHeight(600);

                TextArea textArea = hbox.getChildren().isEmpty() ? createTextArea() : (TextArea) hbox.getChildren().get(1);
                textArea.setPrefWidth(900);
                textArea.setPrefHeight(200);
                textArea.setEditable(true);
                textArea.setWrapText(true);

                Button clearButton = new Button("Clear Data");
                clearButton.setStyle("-fx-background-color: #ff6f00; -fx-text-fill: #030303; -fx-font-weight: bold;");

                CheckBox checkBox = new CheckBox("Include Header Recommendations");

                Label label = new Label("PLOP: Woodcock Johnson: Table of Scores");

                HBox hBoxContainer = new HBox();

                hBoxContainer.getChildren().addAll(clearButton, checkBox, label);
                hBoxContainer.setMargin(clearButton, new Insets(0, 0, 0, 15));
                hBoxContainer.setMargin(checkBox, new Insets(0, 0, 0, 50));
                hBoxContainer.setMargin(label, new Insets(0, 0, 0, 40));

                clearButton.setOnAction(e -> {
                    imageView.setImage(null);

                });

                checkBox.setOnAction(e -> {
                    if (checkBox.isSelected()) {
                        textArea.appendText("Woodcock Johnson:\n" +
                                "\n" +
                                "A Comprehensive battery of standardized tests and clusters designed to evaluate cognitive abilities and academic achievement across the domains of reading, written language, mathematics, and academic knowledge.");
                    } else {
                        textArea.clear();
                    }
                });

                vBox.getChildren().add(hBoxContainer);

                HBox sectionContainer = new HBox();

                sectionContainer.getChildren().addAll(imageView, textArea);
                vBox.getChildren().add(sectionContainer);
                tableOfScoresAdded = true;
            }

        } catch (Exception e) {
            System.err.println("Failed to load image: " + e.getMessage());
        }
    }

    @FXML
    private void switchInterpretiveOverview(ActionEvent event) {
        try {
            InputStream stream = getClass().getResourceAsStream("JavaPics/HCI/interpretiveOverview.png");
            interpretiveOverview = new Image(stream);
            if (!interpretiveOverviewAdded) {

                ImageView imageView = new ImageView(interpretiveOverview);
                imageView.setFitWidth(600);
                imageView.setFitHeight(850);

                TextArea textArea = hbox.getChildren().isEmpty() ? createTextArea() : (TextArea) hbox.getChildren().get(1);
                textArea.setPrefWidth(900);
                textArea.setPrefHeight(200);
                textArea.setEditable(true);
                textArea.setWrapText(true);

                Button clearButton = new Button("Clear Data");
                clearButton.setStyle("-fx-background-color: #ff6f00; -fx-text-fill: #030303; -fx-font-weight: bold;");

                CheckBox checkBox = new CheckBox("Include Header Recommendations");

                Label label = new Label("PLOP: Woodcock Johnson: Interpretive Overview");

                HBox hBoxContainer = new HBox();

                hBoxContainer.getChildren().addAll(clearButton, checkBox, label);
                hBoxContainer.setMargin(clearButton, new Insets(0, 0, 0, 15));
                hBoxContainer.setMargin(checkBox, new Insets(0, 0, 0, 50));
                hBoxContainer.setMargin(label, new Insets(0, 0, 0, 40));

                clearButton.setOnAction(e -> {
                    imageView.setImage(null);

                });

                checkBox.setOnAction(e -> {
                    if (checkBox.isSelected()) {
                        textArea.appendText("Woodcock Johnson:\n" +
                                "\n" +
                                "A Comprehensive battery of standardized tests and clusters designed to evaluate cognitive abilities and academic achievement across the domains of reading, written language, mathematics, and academic knowledge.");
                    } else {
                        textArea.clear();
                    }
                });

                vBox.getChildren().add(hBoxContainer);

                HBox sectionContainer = new HBox();

                sectionContainer.getChildren().addAll(imageView, textArea);
                vBox.getChildren().add(sectionContainer);
                interpretiveOverviewAdded = true;
            }

        } catch (Exception e) {
            System.err.println("Failed to load image: " + e.getMessage());
        }
    }

    @FXML
    private void switchGeneralSummary(ActionEvent event) {
        try {
            InputStream stream = getClass().getResourceAsStream("JavaPics/HCI/generalSummary.png");
            generalSummary = new Image(stream);
            if (!generalSummaryAdded) {

                ImageView imageView = new ImageView(generalSummary);
                imageView.setFitWidth(600);
                imageView.setFitHeight(300);

                TextArea textArea = hbox.getChildren().isEmpty() ? createTextArea() : (TextArea) hbox.getChildren().get(1);
                textArea.setPrefWidth(900);
                textArea.setPrefHeight(200);
                textArea.setEditable(true);
                textArea.setWrapText(true);

                Button clearButton = new Button("Clear Data");
                clearButton.setStyle("-fx-background-color: #ff6f00; -fx-text-fill: #030303; -fx-font-weight: bold;");

                CheckBox checkBox = new CheckBox("Include Header Recommendations");

                Label label = new Label("PLOP: Woodcock Johnson: General Summary");

                HBox hBoxContainer = new HBox();

                hBoxContainer.getChildren().addAll(clearButton, checkBox, label);
                hBoxContainer.setMargin(clearButton, new Insets(0, 0, 0, 15));
                hBoxContainer.setMargin(checkBox, new Insets(0, 0, 0, 50));
                hBoxContainer.setMargin(label, new Insets(0, 0, 0, 40));

                clearButton.setOnAction(e -> {
                    imageView.setImage(null);

                });

                checkBox.setOnAction(e -> {
                    if (checkBox.isSelected()) {
                        textArea.appendText("Woodcock Johnson:\n" +
                                "\n" +
                                "A Comprehensive battery of standardized tests and clusters designed to evaluate cognitive abilities and academic achievement across the domains of reading, written language, mathematics, and academic knowledge.");
                    } else {
                        textArea.clear();
                    }
                });

                vBox.getChildren().add(hBoxContainer);

                HBox sectionContainer = new HBox();

                sectionContainer.getChildren().addAll(imageView, textArea);
                vBox.getChildren().add(sectionContainer);
                generalSummaryAdded = true;
            }

        } catch (Exception e) {
            System.err.println("Failed to load image: " + e.getMessage());
        }
    }

    @FXML
    private void switchBellCurve(ActionEvent event) {
        try {
            InputStream stream = getClass().getResourceAsStream("JavaPics/HCI/bellCurve.png");
            bellCurve = new Image(stream);
            if (!bellCurveAdded) {

                ImageView imageView = new ImageView(bellCurve);
                imageView.setFitWidth(550);
                imageView.setFitHeight(400);

                TextArea textArea = hbox.getChildren().isEmpty() ? createTextArea() : (TextArea) hbox.getChildren().get(1);
                textArea.setPrefWidth(900);
                textArea.setPrefHeight(200);
                textArea.setEditable(true);
                textArea.setWrapText(true);

                Button clearButton = new Button("Clear Data");
                clearButton.setStyle("-fx-background-color: #ff6f00; -fx-text-fill: #030303; -fx-font-weight: bold;");

                CheckBox checkBox = new CheckBox("Include Header Recommendations");

                Label label = new Label("PLOP: Woodcock Johnson: Bell Curve Visual");

                HBox hBoxContainer = new HBox();

                hBoxContainer.getChildren().addAll(clearButton, checkBox, label);
                hBoxContainer.setMargin(clearButton, new Insets(0, 0, 0, 15));
                hBoxContainer.setMargin(checkBox, new Insets(0, 0, 0, 50));
                hBoxContainer.setMargin(label, new Insets(0, 0, 0, 40));

                clearButton.setOnAction(e -> {
                    imageView.setImage(null);

                });

                checkBox.setOnAction(e -> {
                    if (checkBox.isSelected()) {
                        textArea.appendText("Woodcock Johnson:\n" +
                                "\n" +
                                "A Comprehensive battery of standardized tests and clusters designed to evaluate cognitive abilities and academic achievement across the domains of reading, written language, mathematics, and academic knowledge.");
                    } else {
                        textArea.clear();
                    }
                });

                vBox.getChildren().add(hBoxContainer);

                HBox sectionContainer = new HBox();

                sectionContainer.getChildren().addAll(imageView, textArea);
                vBox.getChildren().add(sectionContainer);
                bellCurveAdded = true;
            }

        } catch (Exception e) {
            System.err.println("Failed to load image: " + e.getMessage());
        }
    }

    @FXML
    private void switchStarDiagnostic(ActionEvent event) {
        try {
            InputStream stream = getClass().getResourceAsStream("JavaPics/HCI/starDiagnostic.png");
            starDiagnostic = new Image(stream);
            if (!starDiagnosticAdded) {

                ImageView imageView = new ImageView(starDiagnostic);
                imageView.setFitWidth(600);
                imageView.setFitHeight(650);

                TextArea textArea = hbox.getChildren().isEmpty() ? createTextArea() : (TextArea) hbox.getChildren().get(1);
                textArea.setPrefWidth(900);
                textArea.setPrefHeight(200);
                textArea.setEditable(true);
                textArea.setWrapText(true);

                Button clearButton = new Button("Clear Data");
                clearButton.setStyle("-fx-background-color: #ff6f00; -fx-text-fill: #030303; -fx-font-weight: bold;");

                CheckBox checkBox = new CheckBox("Include Header Recommendations");

                Label label = new Label("PLOP: Star Assessment: Star Diagnostic Report");

                HBox hBoxContainer = new HBox();

                hBoxContainer.getChildren().addAll(clearButton, checkBox, label);
                hBoxContainer.setMargin(clearButton, new Insets(0, 0, 0, 15));
                hBoxContainer.setMargin(checkBox, new Insets(0, 0, 0, 50));
                hBoxContainer.setMargin(label, new Insets(0, 0, 0, 40));

                clearButton.setOnAction(e -> {
                    imageView.setImage(null);

                });

                checkBox.setOnAction(e -> {
                    if (checkBox.isSelected()) {
                        textArea.appendText("STAR:\n" +
                                "\n" +
                                "Computer-adaptive achievement tests that measure reading and math skills. As a student takes the assessment, the assessment alters the following questions based on student’s previous responses. Through the adjustment of difficulty per item, based on what the student has shown they can or cannot do, student achievement is measured.");
                    } else {
                        textArea.clear();
                    }
                });

                vBox.getChildren().add(hBoxContainer);

                HBox sectionContainer = new HBox();

                sectionContainer.getChildren().addAll(imageView, textArea);
                vBox.getChildren().add(sectionContainer);
                starDiagnosticAdded = true;
            }

        } catch (Exception e) {
            System.err.println("Failed to load image: " + e.getMessage());
        }
    }

    @FXML
    private void switchStarAnnualProgress(ActionEvent event) {
        try {
            InputStream stream = getClass().getResourceAsStream("JavaPics/HCI/annualProg.png");
            annualProg = new Image(stream);
            if (!annualProgAdded) {

                ImageView imageView = new ImageView(annualProg);
                imageView.setFitWidth(700);
                imageView.setFitHeight(650);

                TextArea textArea = hbox.getChildren().isEmpty() ? createTextArea() : (TextArea) hbox.getChildren().get(1);
                textArea.setPrefWidth(900);
                textArea.setPrefHeight(200);
                textArea.setEditable(true);
                textArea.setWrapText(true);

                Button clearButton = new Button("Clear Data");
                clearButton.setStyle("-fx-background-color: #ff6f00; -fx-text-fill: #030303; -fx-font-weight: bold;");

                CheckBox checkBox = new CheckBox("Include Header Recommendations");

                Label label = new Label("PLOP: Star Assessment: Star Annual Progress Report");

                HBox hBoxContainer = new HBox();

                hBoxContainer.getChildren().addAll(clearButton, checkBox, label);
                hBoxContainer.setMargin(clearButton, new Insets(0, 0, 0, 15));
                hBoxContainer.setMargin(checkBox, new Insets(0, 0, 0, 50));
                hBoxContainer.setMargin(label, new Insets(0, 0, 0, 40));

                clearButton.setOnAction(e -> {
                    imageView.setImage(null);

                });

                checkBox.setOnAction(e -> {
                    if (checkBox.isSelected()) {
                        textArea.appendText("STAR:\n" +
                                "\n" +
                                "Computer-adaptive achievement tests that measure reading and math skills. As a student takes the assessment, the assessment alters the following questions based on student’s previous responses. Through the adjustment of difficulty per item, based on what the student has shown they can or cannot do, student achievement is measured.");
                    } else {
                        textArea.clear();
                    }
                });

                vBox.getChildren().add(hBoxContainer);

                HBox sectionContainer = new HBox();

                sectionContainer.getChildren().addAll(imageView, textArea);
                vBox.getChildren().add(sectionContainer);
                annualProgAdded = true;
            }

        } catch (Exception e) {
            System.err.println("Failed to load image: " + e.getMessage());
        }
    }

    @FXML
    private void switchTestRecord(ActionEvent event) {
        try {
            InputStream stream = getClass().getResourceAsStream("JavaPics/HCI/starTestRecord.png");
            starTestRecord = new Image(stream);
            if (!starTestRecordAdded) {

                ImageView imageView = new ImageView(starTestRecord);
                imageView.setFitWidth(700);
                imageView.setFitHeight(300);

                TextArea textArea = hbox.getChildren().isEmpty() ? createTextArea() : (TextArea) hbox.getChildren().get(1);
                textArea.setPrefWidth(900);
                textArea.setPrefHeight(200);
                textArea.setEditable(true);
                textArea.setWrapText(true);

                Button clearButton = new Button("Clear Data");
                clearButton.setStyle("-fx-background-color: #ff6f00; -fx-text-fill: #030303; -fx-font-weight: bold;");

                CheckBox checkBox = new CheckBox("Include Header Recommendations");

                Label label = new Label("PLOP: Star Assessment: Test Record");

                HBox hBoxContainer = new HBox();

                hBoxContainer.getChildren().addAll(clearButton, checkBox, label);
                hBoxContainer.setMargin(clearButton, new Insets(0, 0, 0, 15));
                hBoxContainer.setMargin(checkBox, new Insets(0, 0, 0, 50));
                hBoxContainer.setMargin(label, new Insets(0, 0, 0, 40));

                clearButton.setOnAction(e -> {
                    imageView.setImage(null);

                });

                checkBox.setOnAction(e -> {
                    if (checkBox.isSelected()) {
                        textArea.appendText("STAR:\n" +
                                "\n" +
                                "Computer-adaptive achievement tests that measure reading and math skills. As a student takes the assessment, the assessment alters the following questions based on student’s previous responses. Through the adjustment of difficulty per item, based on what the student has shown they can or cannot do, student achievement is measured.");
                    } else {
                        textArea.clear();
                    }
                });

                vBox.getChildren().add(hBoxContainer);

                HBox sectionContainer = new HBox();

                sectionContainer.getChildren().addAll(imageView, textArea);
                vBox.getChildren().add(sectionContainer);
                starTestRecordAdded = true;
            }

        } catch (Exception e) {
            System.err.println("Failed to load image: " + e.getMessage());
        }
    }

    @FXML
    private void switchStudentReport(ActionEvent event) {
        try {
            InputStream stream = getClass().getResourceAsStream("JavaPics/HCI/studentReport.png");
            studentReport = new Image(stream);
            if (!studentReportAdded) {

                ImageView imageView = new ImageView(studentReport);
                imageView.setFitWidth(700);
                imageView.setFitHeight(850);

                TextArea textArea = hbox.getChildren().isEmpty() ? createTextArea() : (TextArea) hbox.getChildren().get(1);
                textArea.setPrefWidth(900);
                textArea.setPrefHeight(200);
                textArea.setEditable(true);
                textArea.setWrapText(true);

                Button clearButton = new Button("Clear Data");
                clearButton.setStyle("-fx-background-color: #ff6f00; -fx-text-fill: #030303; -fx-font-weight: bold;");

                CheckBox checkBox = new CheckBox("Include Header Recommendations");

                Label label = new Label("PLOP: CMAS: Student Report");

                HBox hBoxContainer = new HBox();

                hBoxContainer.getChildren().addAll(clearButton, checkBox, label);
                hBoxContainer.setMargin(clearButton, new Insets(0, 0, 0, 15));
                hBoxContainer.setMargin(checkBox, new Insets(0, 0, 0, 50));
                hBoxContainer.setMargin(label, new Insets(0, 0, 0, 40));

                clearButton.setOnAction(e -> {
                    imageView.setImage(null);

                });

                checkBox.setOnAction(e -> {
                    if (checkBox.isSelected()) {
                        textArea.appendText("CMAS:\n" +
                                "\n" +
                                "The state of Colorado has the end of year standardized test called, Colorado Measures of Academic Success (CMAS). Colorado Measures of Academic Success (CMAS) measures student achievement and growth for English language arts and mathematics to all students in grades 3-8, Science in grade 5, grade 8, and grade 11. ");
                    } else {
                        textArea.clear();
                    }
                });

                vBox.getChildren().add(hBoxContainer);

                HBox sectionContainer = new HBox();

                sectionContainer.getChildren().addAll(imageView, textArea);
                vBox.getChildren().add(sectionContainer);
                studentReportAdded = true;
            }

        } catch (Exception e) {
            System.err.println("Failed to load image: " + e.getMessage());
        }
    }

    @FXML
    private void switchScoreSummary(ActionEvent event) {
        try {
            InputStream stream = getClass().getResourceAsStream("JavaPics/HCI/scoreSummary.png");
            scoreSummary = new Image(stream);
            if (!scoreSummaryAdded) {

                ImageView imageView = new ImageView(scoreSummary);
                imageView.setFitWidth(650);
                imageView.setFitHeight(700);

                TextArea textArea = hbox.getChildren().isEmpty() ? createTextArea() : (TextArea) hbox.getChildren().get(1);
                textArea.setPrefWidth(900);
                textArea.setPrefHeight(200);
                textArea.setEditable(true);
                textArea.setWrapText(true);

                Button clearButton = new Button("Clear Data");
                clearButton.setStyle("-fx-background-color: #ff6f00; -fx-text-fill: #030303; -fx-font-weight: bold;");

                CheckBox checkBox = new CheckBox("Include Header Recommendations");

                Label label = new Label("PLOP: CMAS: Score Summary");

                HBox hBoxContainer = new HBox();

                hBoxContainer.getChildren().addAll(clearButton, checkBox, label);
                hBoxContainer.setMargin(clearButton, new Insets(0, 0, 0, 15));
                hBoxContainer.setMargin(checkBox, new Insets(0, 0, 0, 50));
                hBoxContainer.setMargin(label, new Insets(0, 0, 0, 40));

                clearButton.setOnAction(e -> {
                    imageView.setImage(null);

                });

                checkBox.setOnAction(e -> {
                    if (checkBox.isSelected()) {
                        textArea.appendText("CMAS:\n" +
                                "\n" +
                                "The state of Colorado has the end of year standardized test called, Colorado Measures of Academic Success (CMAS). Colorado Measures of Academic Success (CMAS) measures student achievement and growth for English language arts and mathematics to all students in grades 3-8, Science in grade 5, grade 8, and grade 11. ");
                    } else {
                        textArea.clear();
                    }
                });

                vBox.getChildren().add(hBoxContainer);

                HBox sectionContainer = new HBox();

                sectionContainer.getChildren().addAll(imageView, textArea);
                vBox.getChildren().add(sectionContainer);
                scoreSummaryAdded = true;
            }

        } catch (Exception e) {
            System.err.println("Failed to load image: " + e.getMessage());
        }
    }

    @FXML
    private void switchScoreComposition(ActionEvent event) {
        try {
            InputStream stream = getClass().getResourceAsStream("JavaPics/HCI/scoreComposition.png");
            scoreComposition = new Image(stream);
            if (!scoreComparisonAdded) {

                ImageView imageView = new ImageView(scoreComposition);
                imageView.setFitWidth(350);
                imageView.setFitHeight(350);

                TextArea textArea = hbox.getChildren().isEmpty() ? createTextArea() : (TextArea) hbox.getChildren().get(1);
                textArea.setPrefWidth(900);
                textArea.setPrefHeight(200);
                textArea.setEditable(true);
                textArea.setWrapText(true);

                Button clearButton = new Button("Clear Data");
                clearButton.setStyle("-fx-background-color: #ff6f00; -fx-text-fill: #030303; -fx-font-weight: bold;");

                CheckBox checkBox = new CheckBox("Include Header Recommendations");

                Label label = new Label("PLOP: CMAS: Score Comparison");

                HBox hBoxContainer = new HBox();

                hBoxContainer.getChildren().addAll(clearButton, checkBox, label);
                hBoxContainer.setMargin(clearButton, new Insets(0, 0, 0, 15));
                hBoxContainer.setMargin(checkBox, new Insets(0, 0, 0, 50));
                hBoxContainer.setMargin(label, new Insets(0, 0, 0, 40));

                clearButton.setOnAction(e -> {
                    imageView.setImage(null);

                });

                checkBox.setOnAction(e -> {
                    if (checkBox.isSelected()) {
                        textArea.appendText("CMAS:\n" +
                                "\n" +
                                "The state of Colorado has the end of year standardized test called, Colorado Measures of Academic Success (CMAS). Colorado Measures of Academic Success (CMAS) measures student achievement and growth for English language arts and mathematics to all students in grades 3-8, Science in grade 5, grade 8, and grade 11. ");
                    } else {
                        textArea.clear();
                    }
                });

                vBox.getChildren().add(hBoxContainer);

                HBox sectionContainer = new HBox();

                sectionContainer.getChildren().addAll(imageView, textArea);
                vBox.getChildren().add(sectionContainer);
                scoreComparisonAdded = true;
            }

        } catch (Exception e) {
            System.err.println("Failed to load image: " + e.getMessage());
        }
    }

    @FXML
    private void switchSkillsPlan(ActionEvent event) {
        try {
            InputStream stream = getClass().getResourceAsStream("JavaPics/HCI/skillsPlan.png");
            skillsPlan = new Image(stream);

            if (!skillsPlanAdded) {

                ImageView imageView = new ImageView(skillsPlan);
                imageView.setFitWidth(700);
                imageView.setFitHeight(600);

                TextArea textArea = hbox.getChildren().isEmpty() ? createTextArea() : (TextArea) hbox.getChildren().get(1);
                textArea.setPrefWidth(900);
                textArea.setPrefHeight(200);
                textArea.setEditable(true);
                textArea.setWrapText(true);

                Button clearButton = new Button("Clear Data");
                clearButton.setStyle("-fx-background-color: #ff6f00; -fx-text-fill: #030303; -fx-font-weight: bold;");

                CheckBox checkBox = new CheckBox("Include Header Recommendations");

                Label label = new Label("PLOP: aimswebPlus: Skills Plan Report");

                HBox hBoxContainer = new HBox();

                hBoxContainer.getChildren().addAll(clearButton, checkBox, label);
                hBoxContainer.setMargin(clearButton, new Insets(0, 0, 0, 15));
                hBoxContainer.setMargin(checkBox, new Insets(0, 0, 0, 50));
                hBoxContainer.setMargin(label, new Insets(0, 0, 0, 40));

                clearButton.setOnAction(e -> {
                    imageView.setImage(null);

                });

                checkBox.setOnAction(e -> {
                    if (checkBox.isSelected()) {
                        textArea.appendText("AIMSWEB PLUS:\n" +
                                "\n" +
                                "Online assessment, Data Management and Reporting System that provides national/local performance along with developmental norms in tracking the initial assessment along with progress monitoring of math/reading skills. aimswebPlus is used for benchmarking, universal screening and diagnosing strengths and weaknesses in reading/math. It provides teachers with differentiated instructional support based on student scores and Lexile equivalencies for reading instruction/Quantile equivalency for math. ");
                    } else {
                        textArea.clear();
                    }
                });

                vBox.getChildren().add(hBoxContainer);

                HBox sectionContainer = new HBox();

                sectionContainer.getChildren().addAll(imageView, textArea);
                vBox.getChildren().add(sectionContainer);
                skillsPlanAdded = true;
            }

        } catch (Exception e) {
            System.err.println("Failed to load image: " + e.getMessage());
        }
    }

    @FXML
    private void switchStudentProfile(ActionEvent event) {

        try {
            InputStream stream = getClass().getResourceAsStream("JavaPics/HCI/studentProfile.png");
            studentProfile = new Image(stream);

            if (!studentProfileAdded) {

                ImageView imageView = new ImageView(studentProfile);
                imageView.setFitWidth(700);
                imageView.setFitHeight(600);

                TextArea textArea = hbox.getChildren().isEmpty() ? createTextArea() : (TextArea) hbox.getChildren().get(1);
                textArea.setPrefWidth(900);
                textArea.setPrefHeight(200);
                textArea.setEditable(true);
                textArea.setWrapText(true);

                Button clearButton = new Button("Clear Data");
                clearButton.setStyle("-fx-background-color: #ff6f00; -fx-text-fill: #030303; -fx-font-weight: bold;");

                CheckBox checkBox = new CheckBox("Include Header Recommendations");

                Label label = new Label("PLOP: aimswebPlus: Student Profile");

                HBox hBoxContainer = new HBox();

                hBoxContainer.getChildren().addAll(clearButton, checkBox, label);
                hBoxContainer.setMargin(clearButton, new Insets(0, 0, 0, 15));
                hBoxContainer.setMargin(checkBox, new Insets(0, 0, 0, 50));
                hBoxContainer.setMargin(label, new Insets(0, 0, 0, 40));

                clearButton.setOnAction(e -> {
                    imageView.setImage(null);

                });

                checkBox.setOnAction(e -> {
                    if (checkBox.isSelected()) {
                        textArea.appendText("AIMSWEB PLUS:\n" +
                                "\n" +
                                "Online assessment, Data Management and Reporting System that provides national/local performance along with developmental norms in tracking the initial assessment along with progress monitoring of math/reading skills. aimswebPlus is used for benchmarking, universal screening and diagnosing strengths and weaknesses in reading/math. It provides teachers with differentiated instructional support based on student scores and Lexile equivalencies for reading instruction/Quantile equivalency for math. ");
                    } else {
                        textArea.clear();
                    }
                });

                vBox.getChildren().add(hBoxContainer);

                HBox sectionContainer = new HBox();

                sectionContainer.getChildren().addAll(imageView, textArea);
                vBox.getChildren().add(sectionContainer);
                studentProfileAdded = true;
            }

        } catch (Exception e) {
            System.err.println("Failed to load image: " + e.getMessage());
        }
    }


    @FXML
    private void switchBenchmark(ActionEvent event) {
        try {
            InputStream stream = getClass().getResourceAsStream("JavaPics/HCI/individualBenchmark.png");
            individualBenchmark = new Image(stream);

            if (!benchmarkAdded) {

                ImageView imageView = new ImageView(individualBenchmark);                imageView.setFitWidth(350);
                textArea.setPrefWidth(900);
                textArea.setPrefHeight(200);

                TextArea textArea = hbox.getChildren().isEmpty() ? createTextArea() : (TextArea) hbox.getChildren().get(1);
                textArea.setPrefWidth(900);
                textArea.setPrefHeight(200);
                textArea.setEditable(true);
                textArea.setWrapText(true);

                Button clearButton = new Button("Clear Data");
                clearButton.setStyle("-fx-background-color: #ff6f00; -fx-text-fill: #030303; -fx-font-weight: bold;");

                CheckBox checkBox = new CheckBox("Include Header Recommendations");

                Label label = new Label("PLOP: aimswebPlus: Individual Benchmark");

                HBox hBoxContainer = new HBox();

                hBoxContainer.getChildren().addAll(clearButton, checkBox, label);
                hBoxContainer.setMargin(clearButton, new Insets(0, 0, 0, 15));
                hBoxContainer.setMargin(checkBox, new Insets(0, 0, 0, 50));
                hBoxContainer.setMargin(label, new Insets(0, 0, 0, 40));

                clearButton.setOnAction(e -> {
                    imageView.setImage(null);

                });

                checkBox.setOnAction(e -> {
                    if (checkBox.isSelected()) {
                        textArea.appendText("AIMSWEB PLUS:\n" +
                                "\n" +
                                "Online assessment, Data Management and Reporting System that provides national/local performance along with developmental norms in tracking the initial assessment along with progress monitoring of math/reading skills. aimswebPlus is used for benchmarking, universal screening and diagnosing strengths and weaknesses in reading/math. It provides teachers with differentiated instructional support based on student scores and Lexile equivalencies for reading instruction/Quantile equivalency for math. ");
                    } else {
                        textArea.clear();
                    }
                });

                vBox.getChildren().add(hBoxContainer);

                HBox sectionContainer = new HBox();

                sectionContainer.getChildren().addAll(imageView, textArea);
                vBox.getChildren().add(sectionContainer);
                benchmarkAdded = true;
            }

        } catch (Exception e) {
            System.err.println("Failed to load image: " + e.getMessage());
        }
    }

    @FXML
    private void switchScoreSnapshot(ActionEvent event) {
        try {
            InputStream stream = getClass().getResourceAsStream("JavaPics/HCI/scoreSnapshot.png");
            scoreSnapshot = new Image(stream);
            if (!scoreSnapshotsAdded) {

                ImageView imageView = new ImageView(scoreSnapshot);
                textArea.setPrefWidth(900);
                textArea.setPrefHeight(200);

                TextArea textArea = hbox.getChildren().isEmpty() ? createTextArea() : (TextArea) hbox.getChildren().get(1);
                textArea.setPrefWidth(900);
                textArea.setPrefHeight(200);
                textArea.setEditable(true);
                textArea.setWrapText(true);

                Button clearButton = new Button("Clear Data");
                clearButton.setStyle("-fx-background-color: #ff6f00; -fx-text-fill: #030303; -fx-font-weight: bold;");

                CheckBox checkBox = new CheckBox("Include Header Recommendations");

                Label label = new Label("PLOP: aimswebPlus Score Snapshots");

                HBox hBoxContainer = new HBox();

                hBoxContainer.getChildren().addAll(clearButton, checkBox, label);
                hBoxContainer.setMargin(clearButton, new Insets(0, 0, 0, 15));
                hBoxContainer.setMargin(checkBox, new Insets(0, 0, 0, 50));
                hBoxContainer.setMargin(label, new Insets(0, 0, 0, 40));

                clearButton.setOnAction(e -> {
                    imageView.setImage(null);

                });

                checkBox.setOnAction(e -> {
                    if (checkBox.isSelected()) {
                        textArea.appendText("AIMSWEB PLUS:\n" +
                                "\n" +
                                "Online assessment, Data Management and Reporting System that provides national/local performance along with developmental norms in tracking the initial assessment along with progress monitoring of math/reading skills. aimswebPlus is used for benchmarking, universal screening and diagnosing strengths and weaknesses in reading/math. It provides teachers with differentiated instructional support based on student scores and Lexile equivalencies for reading instruction/Quantile equivalency for math. ");
                    } else {
                        textArea.clear();
                    }
                });

                vBox.getChildren().add(hBoxContainer);

                HBox sectionContainer = new HBox();

                sectionContainer.getChildren().addAll(imageView, textArea);
                vBox.getChildren().add(sectionContainer);
                scoreSnapshotsAdded = true;
            }

        } catch (Exception e) {
            System.err.println("Failed to load image: " + e.getMessage());
        }
    }

    @FXML
    private void switchScoresSummary(ActionEvent event) {
        try {
            InputStream stream = getClass().getResourceAsStream("JavaPics/HCI/scoresSummary.png");
            scoresSummary = new Image(stream);

            if (!scoresSummaryAdded) {

                ImageView imageView = new ImageView(scoresSummary);
                textArea.setPrefWidth(900);
                textArea.setPrefHeight(200);

                TextArea textArea = hbox.getChildren().isEmpty() ? createTextArea() : (TextArea) hbox.getChildren().get(1);
                textArea.setPrefWidth(900);
                textArea.setPrefHeight(200);
                textArea.setEditable(true);
                textArea.setWrapText(true);

                Button clearButton = new Button("Clear Data");
                clearButton.setStyle("-fx-background-color: #ff6f00; -fx-text-fill: #030303; -fx-font-weight: bold;");

                CheckBox checkBox = new CheckBox("Include Header Recommendations");

                Label label = new Label("PLOP: aimswebPlus Score Summary");

                HBox hBoxContainer = new HBox();

                hBoxContainer.getChildren().addAll(clearButton, checkBox, label);
                hBoxContainer.setMargin(clearButton, new Insets(0, 0, 0, 15));
                hBoxContainer.setMargin(checkBox, new Insets(0, 0, 0, 50));
                hBoxContainer.setMargin(label, new Insets(0, 0, 0, 40));

                clearButton.setOnAction(e -> {
                    imageView.setImage(null);

                });

                checkBox.setOnAction(e -> {
                    if (checkBox.isSelected()) {
                        textArea.appendText("AIMSWEB PLUS:\n" +
                                "\n" +
                                "Online assessment, Data Management and Reporting System that provides national/local performance along with developmental norms in tracking the initial assessment along with progress monitoring of math/reading skills. aimswebPlus is used for benchmarking, universal screening and diagnosing strengths and weaknesses in reading/math. It provides teachers with differentiated instructional support based on student scores and Lexile equivalencies for reading instruction/Quantile equivalency for math. ");
                    } else {
                        textArea.clear();
                    }
                });

                vBox.getChildren().add(hBoxContainer);

                HBox sectionContainer = new HBox();

                sectionContainer.getChildren().addAll(imageView, textArea);
                vBox.getChildren().add(sectionContainer);
                scoresSummaryAdded = true;
            }

        } catch (Exception e) {
            System.err.println("Failed to load image: " + e.getMessage());
        }
    }

    private TextArea createTextArea() {
        TextArea textArea = new TextArea();
        textArea.setPrefWidth(900);
        textArea.setPrefHeight(200);
        textArea.setEditable(true);
        return textArea;
    }


    private void saveCurrentSceneDimensions(Stage stage) {
        Scene currentScene = stage.getScene();
        if (currentScene != null) {
            previousSceneWidth = currentScene.getWidth();
            previousSceneHeight = currentScene.getHeight();
        }
    }


    public static void main(String[] args) {
        launch();
    }
}