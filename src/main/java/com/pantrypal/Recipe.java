package com.pantrypal;

import static com.mongodb.client.model.Filters.in;

/*
 * Recipe class to store recipe information
 * This is what is shown once you clicked on the recipe list
 */
public class Recipe {
    private String recipeTitle;
    private String recipeInstructions; 
    private String recipeIngredients;
    private String mealType;
    private String recipeImageURL;
    private int recipeIndex;  //Used in order to sort recipes by time created

    Recipe() {
    }
    
    void setRecipeTitle(String recipeTitle) {
        this.recipeTitle = recipeTitle;
    }

    String getRecipeTitle() {
        return recipeTitle;
    }
    
    void setRecipeIngredients(String recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    String getRecipeIngredients() {
        return recipeIngredients;
    }

    void setRecipeInstructions(String recipeInstructions) {
        this.recipeInstructions = recipeInstructions;
    }

    String getRecipeInstructions() {
        return recipeInstructions;
    }

    void setRecipeImageURL(String recipeImageURL) {
        this.recipeImageURL = recipeImageURL;
    }

    String getRecipeImageURL() {
        return recipeImageURL;
    }

    void setMealType(String mealType) {
        //Capitalize the first letter of the mealtype
        if(mealType != null){
            this.mealType = mealType.substring(0, 1).toUpperCase() + mealType.substring(1);
        }
        else{
            this.mealType = mealType;
        }
    }

    String getMealType() {
        return mealType;
    }

    void setRecipeIndex(int recipeIndex) {
        this.recipeIndex = recipeIndex;
    }

    int getRecipeIndex() {
        return recipeIndex;
    }

}
