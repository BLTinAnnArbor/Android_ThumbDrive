package com.ebookfrenzy.viewmodeldemo.ui.main;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ebookfrenzy.viewmodeldemo.R;
import com.ebookfrenzy.viewmodeldemo.databinding.MainFragmentBinding;

import static com.ebookfrenzy.viewmodeldemo.BR.myViewModel; // I had to add this manually !!
                                                            // else it errored
public class MainFragment extends Fragment {

    // This is necessary
       public static MainFragment newInstance() {
        return new MainFragment();
     }



    private MainViewModel mViewModel;

    public MainFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(
                inflater, R.layout.main_fragment, container, false);

        binding.setLifecycleOwner(this); // Ensures the binding instance is destroyed when the
        // fragment goes away cuz the current fragment is the lifecycle owner of it.

        return binding.getRoot(); // It is still returning the root view of the layout.

        //return inflater.inflate(R.layout.main_fragment, container, false);
    }


    //private EditText dollarText;
    //private TextView resultText;
    //private Button convertButton;

    @Override  // Called each time the Activity is created
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        // Assigning the ViewModel instance to the data binding variable.
        binding.setVariable(myViewModel, mViewModel); //myViewModel is from XML
/*
        dollarText = getView().findViewById(R.id.dollarText);
        resultText = getView().findViewById(R.id.resultText);
        convertButton = getView().findViewById(R.id.convertButton);

        // If the line below is commented out, the TextView info is lost after a rotation.
        // Commented out because onChanged() will now be responsible for updating.
        //resultText.setText(mViewModel.getResult().toString());

        // Configure an observer
        final Observer<Float> resultObserver = new Observer<Float>() {
            @Override
            public void onChanged(@Nullable final Float result) {
                resultText.setText((result.toString()));
            }
        };

        mViewModel.getResult().observe(this, resultObserver);

        // Add the listener
        convertButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){

                if(!dollarText.getText().toString().equals("")){

                    mViewModel.setAmount(dollarText.getText().toString());
                    //resultText.setText(mViewModel.getResult().toString());

                }else {
                    resultText.setText("No Value was Entered.");
                }

            }

        });

 */
    }

}
