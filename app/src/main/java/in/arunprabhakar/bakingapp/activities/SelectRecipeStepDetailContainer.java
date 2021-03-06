package in.arunprabhakar.bakingapp.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import in.arunprabhakar.bakingapp.R;
import in.arunprabhakar.bakingapp.fragments.SelectRecipeStepDetail;
import in.arunprabhakar.bakingapp.fragments.SelectRecipeStepDetailFragment;
import in.arunprabhakar.bakingapp.model.RecipeStepsModel;

import java.util.List;

public class SelectRecipeStepDetailContainer extends AppCompatActivity {


    String TAG = getClass().getSimpleName();

    public RecipeStepsModel recipeStepsModel;
    public int position=-1;
    public long [] currentPosition = new long[SelectRecipeStep.listRecipeStepss.size()];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_recipe_step_detail_container);

        if(savedInstanceState!=null){
            Log.d(TAG,"savedInstanceState!=null");
            recipeStepsModel = (RecipeStepsModel) savedInstanceState.getSerializable("step");
            currentPosition = savedInstanceState.getLongArray("currentPosition");
        }else{
            Log.d(TAG,"savedInstanceState==null");
            recipeStepsModel = (RecipeStepsModel) getIntent().getExtras().getSerializable("step");
            for(int i=0;i<SelectRecipeStep.listRecipeStepss.size();i++){
                currentPosition[i] = -1;
            }
        }
        position = getIntent().getExtras().getInt("position");

        attachFragment(recipeStepsModel,position);

    }

    public void attachFragment(RecipeStepsModel recipeStepsModel,int position){
        Fragment recipeStepDetail = SelectRecipeStepDetail.newInstance(recipeStepsModel.getRecipe(),position);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_body, recipeStepDetail);
        fragmentTransaction.commit();
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("step", recipeStepsModel);
        outState.putLongArray("currentPosition",currentPosition);
    }
}
