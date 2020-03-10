package com.ebookfrenzy.navigationproject;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ebookfrenzy.navigationproject.ui.main.MainViewModel;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentA#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentA extends Fragment {

    private static final String TAG = "myFragmentA";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private MainViewModel mViewModel;

    public FragmentA() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentA.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentA newInstance(String param1, String param2) {
        FragmentA fragment = new FragmentA();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public interface OnFragmentInteractionListener{
        void onFragmentInteraction(Uri uri);
    }
    @Override
    public void onStart(){
        super.onStart();
        Log.i(TAG, "just called super.onStart()");
        //mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        ImageView iv = getView().findViewById(R.id.imageView);

        FragmentAArgs args = FragmentAArgs.fromBundle(getArguments());
        //Log.i(TAG, "args = "+ String.valueOf(args));

        int imageRes = args.getImageNum();  // When the default value on imageNum was 1, it crashed the app;


        //Log.i(TAG, "just called args.getImageNum()");
        //Log.i(TAG, "imageRes = "+ imageRes);

        //int test = 2131165277;

        //iv.setImageResource(imageRes);

        int imageNum = mViewModel.getImageNum();
        Log.i(TAG, "imageNum = "+ imageNum);
        iv.setImageResource(imageNum);  // This closed the app when default value was 1, 1 is not "drawable"
                                        // It doesn't close when zero (now).
        Log.i(TAG, "just called setImageResource()");

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        //mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false);
    }
}
