package com.ebookfrenzy.fragmentexample;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ToolBarFragment extends Fragment implements SeekBar.OnSeekBarChangeListener
{
    private static int seekValue = 10;
    private static EditText editText;

    ToolbarListener activityCallback;

    public interface ToolbarListener
    {
        public void onButtonClick(int position, String text);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            activityCallback = (ToolbarListener) context;
        }catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    " must implement ToolbarListener");
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.toolbar_fragment,
                container, false);

        editText = view.findViewById(R.id.editText1);
        final SeekBar seekBar = view.findViewById(R.id.seekBar1);

        seekBar.setOnSeekBarChangeListener(this);

        final Button button = view.findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonClicked(v);
            }
        });

        return view;
    }

    public void buttonClicked (View view) {

        activityCallback.onButtonClick(seekValue,
                editText.getText().toString());
    }
        @Override
                public void onProgressChanged(SeekBar seekBar,
                                            int progress, boolean fromUser)
        {
            seekValue = progress;
        }
        @Override
                public void onStartTrackingTouch(SeekBar arg0)
        {}
        @Override
                public void onStopTrackingTouch(SeekBar arg0)
        {}

}
