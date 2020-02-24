package com.ebookfrenzy.navigationdemo.ui.main;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.ebookfrenzy.navigationdemo.R;

public class MainFragment extends Fragment {

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

        Button button = getView().findViewById((R.id.button));

        //Navigation class also includes a method named createNavigateOnClickListener() which provides
        // a more efficient way of setting up a listener and navigating to a destination.

        //button.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.mainToSecond, null));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                EditText userText = getView().findViewById(R.id.userText);

                MainFragmentDirections.MainToSecond action =
                        MainFragmentDirections.mainToSecond();

                action.setMessage(userText.getText().toString());
                Navigation.findNavController(view).navigate(action);
                // The above code obtains a reference to the action object, sets the message argument string
                // using the setMessage() method and then calls the navigate() method of the navigation controller,
                // passing through the action object.

                // A reference to the navigation controller instance calls navigate with arg below.
                //Navigation.findNavController(view).navigate
                        //(R.id.mainToSecond); // Resource ID of the navigation action
            }
        });
    } // onActivityCreated()
}
