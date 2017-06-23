package in.arunprabhakar.bakingapp.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import in.arunprabhakar.bakingapp.fragments.SelectRecipeStepDetail;
import in.arunprabhakar.bakingapp.fragments.SelectRecipeStepDetailFragment;
import in.arunprabhakar.bakingapp.model.RecipeStepsModel;

import java.util.ArrayList;
import java.util.List;


public class RecipeStepsPagerAdapter extends FragmentStatePagerAdapter {

    List<SelectRecipeStepDetailFragment> list = new ArrayList();
    List<RecipeStepsModel> recipeStepsModelListt;

    public RecipeStepsPagerAdapter(FragmentManager fm, List<RecipeStepsModel> recipeStepsModellist) {
        super(fm);
        this.recipeStepsModelListt = recipeStepsModellist;
        for(int i=0;i<recipeStepsModellist.size();i++){
            this.list.add(SelectRecipeStepDetailFragment.newInstance(recipeStepsModellist.get(i),i));
        }

    }

    @Override
    public Fragment getItem(int position) {

        return list.get(position);
}

    @Override
    public int getCount() {
        return list.size();
    }

}