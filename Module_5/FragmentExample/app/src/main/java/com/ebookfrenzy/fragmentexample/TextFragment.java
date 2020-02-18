package com.ebookfrenzy.fragmentexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class TextFragment extends Fragment
{
    private static TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.text_fragment,
                container, false);

        textView = view.findViewById(R.id.textView1);

        return view;
    }

    public void changeTextProperties(int fontSize, String text)
    {
        textView.setTextSize(fontSize);
        textView.setText((text));
    }
}
