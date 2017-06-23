package in.arunprabhakar.bakingapp.model;


public class RecipeIngrediantModel {

    int recipe;
    double quantity;
    String measure,ingredient;

    public RecipeIngrediantModel( int recipe,double quantity, String measure,String ingredient) {
        this.ingredient = ingredient;
        this.measure = measure;
        this.quantity = quantity;
        this.recipe = recipe;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public int getRecipe() {
        return recipe;
    }

    public void setRecipe(int recipe) {
        this.recipe = recipe;
    }
}
