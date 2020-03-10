package com.ebookfrenzy.navigationproject.ui.main;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.ebookfrenzy.navigationproject.R;

public class MainFragment extends Fragment {

    private static final String TAG = "MainFragment";

    private MainViewModel mViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        Button buttonA, buttonB, buttonC;

        // later, create an array of buttons, and loop thru them?

        buttonA = getView().findViewById(R.id.button_a);
        buttonB = getView().findViewById(R.id.button_b);
        buttonC = getView().findViewById(R.id.button_c);

    /*
        buttonA.setTag();
        buttonB.setTag();
        buttonC.setTag();

     */

        buttonA.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                // doAction(view.getTag();  // Put code below into doAction()
                MainFragmentDirections.MainToFragA action = MainFragmentDirections.mainToFragA();
                ImageView imageA = getView().findViewById(R.id.imageViewA); //
                imageA.setTag(R.drawable.android_image_5);
                Log.i(TAG, "just called imageA.setTag()");
                int id_A = getDrawableId(imageA);


                //action.setImageNum(id_A);
                // Since the above line doesn't work, I'll send it to MainViewModel
                mViewModel.setImageNum(id_A);

                Log.i(TAG, "mViewModel.getImageNum() "+ mViewModel.getImageNum());






                //action.setSendImage(id_A);
                Log.i(TAG, "just called mViewModel.setImageNum(id_A)");

                Navigation.findNavController(view).navigate(R.id.mainToFragA);
                Log.i(TAG, "just called findNavContoller(view).navigate()");
            }
        });


    } // onActivityCreated()

    private int getDrawableId(ImageView iv) {
        Log.i(TAG, "in getDrawableId()");
        return  (Integer) iv.getTag();
    }

} // class MainFragment
