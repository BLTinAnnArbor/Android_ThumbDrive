package com.ebookfrenzy.btest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //not needed with safe args
                //NavHostFragment.findNavController(FirstFragment.this)
                //.navigate(R.id.action_FirstFragment_to_SecondFragment);
                FirstFragmentDirections.ActionFirstFragmentToSecondFragment action =
                        FirstFragmentDirections.actionFirstFragmentToSecondFragment();
                ImageView image = getView().findViewById(R.id.firstFragImage);
                image.setTag(R.drawable.android_image_5);
                int id2 = getDrawableId(image);
                action.setPassImage(id2);
                Navigation.findNavController(view).navigate(action);
            }
        });

        view.findViewById(R.id.button_first2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirstFragmentDirections.ActionFirstFragmentToSecondFragment action =
                        FirstFragmentDirections.actionFirstFragmentToSecondFragment();
                ImageView image = getView().findViewById(R.id.firstFragImage2);
                image.setTag(R.drawable.android_image_6);
                int id2 = getDrawableId(image);
                action.setPassImage(id2);
                Navigation.findNavController(view).navigate(action);
            }
        });
        view.findViewById(R.id.button_first3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirstFragmentDirections.ActionFirstFragmentToSecondFragment action =
                        FirstFragmentDirections.actionFirstFragmentToSecondFragment();
                ImageView image = getView().findViewById(R.id.firstFragImage2);
                image.setTag(R.drawable.android_image_7);
                int id2 = getDrawableId(image);
                action.setPassImage(id2);
                Navigation.findNavController(view).navigate(action);
            }
        });
    }

    private int getDrawableId(ImageView iv) {
        return (Integer) iv.getTag();
    }
}
