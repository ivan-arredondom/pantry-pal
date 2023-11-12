package com.pantrypal;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

class mainPage extends Page {


    paneHeader paneHeader;
    paneFooter paneFooter;
    private Button addButton;
    // private boolean initialized;

    public mainPage(int width, int height) {
        super(width, height);
        // initialized = true;;

        // DELETE ONCE WE NO LONGER NEED TO LOAD DUMMY RECIPES
        IntializeRecipeList.uploadRecipes();
        
    }
    //second constructor to prevent loading recipes everytime
     public mainPage(int width, int height, boolean initialized) {
        super(width, height);
        // initialized = true;
        // IntializeRecipeList.uploadRecipes()
        //IntializeRecipeList.uploadRecipes();
        
    }

    public void addListeners() {
        addButton.setOnAction(e -> {
            // SET TO RECORDING STAGE
            StageController stgController = StageController.getInstance();
            stgController.changeTo("RecordPage");
//            Stage stage = (Stage) this.getScene().getWindow();
//            stage.setScene(new RecordPage(width, height).getScene());
            System.out.println("RecordPage_");
        });
        // add buttons that don't change page
    }

    public Button getAddButton() {
        return this.addButton;
    }

    @Override
    protected void createView() {

        paneHeader = new paneHeader();
        
        // Populate list initially for testing --- REMOVE AFTER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        // for(int i=0; i < 20; i++){
        //     Recipe recipe = new Recipe();
        //     recipe.setRecipeTitle(("Recipe " + i));
        //     recipeTitleListView.getChildren().add(new RecipeTitleView(recipe));
        // }

        // if(initialized){
            // IntializeRecipeList.uploadRecipes();
            // initialized = false;
            System.out.println("CALLED");
        // }

       

        ScrollPane scroll = new ScrollPane(RecipeTitleListView.getInstance());
        scroll.setPrefSize(1000, 1000);
        scroll.setFitToWidth(true);
        scroll.setFitToHeight(true);

        paneFooter = new paneFooter();
        VBox mainContent = new VBox();
        mainContent.minHeight(1000);
        mainContent.minWidth(1000);
        mainContent.setSpacing(15);
        mainContent.setAlignment(Pos.CENTER);
        mainContent.getChildren().add(scroll);
        // mainContent.getChildren().add(RecipeTitleListView.getInstance());

        paneHeader.setTitleInMiddle(new Text("PantryPal: The best Recipe manager"));
        this.borderPane.setTop(paneHeader);
        this.borderPane.setCenter(mainContent);
        this.borderPane.setBottom(paneFooter);

        this.addButton = paneFooter.creatButton("addButton", "-fx-background-color: #FFEBD7; " +
                "-fx-text-fill: #8B4513; " +
                "-fx-border-color: #8B4513; " +
                "-fx-border-radius: 20; " +
                "-fx-background-radius: 20; " +
                "-fx-padding: 5 15 5 15;");

        paneFooter.setButton(this.addButton);

        this.borderPane.setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, #FFE4B5, #FFDEAD, #FFE4B5, #FFDEAD); " +
                "-fx-border-color: #DEB887; " +
                "-fx-border-width: 10; " +
                "-fx-border-radius: 15; " +
                "-fx-background-radius: 15;");
        addListeners();


    }
}