package com.telephone.coursetable.Webinfo;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.telephone.coursetable.GuetTools.ImageActivity;
import com.telephone.coursetable.GuetTools.WebLinksActivity;
import com.telephone.coursetable.Library.LibraryActivity;
import com.telephone.coursetable.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GuetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GuetFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GuetFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GuetFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GuetFragment newInstance(String param1, String param2) {
        GuetFragment fragment = new GuetFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        view.findViewById(R.id.fragment_guet_music).setOnClickListener(this::JumpMusic);
        view.findViewById(R.id.fragment_guet_map).setOnClickListener(this::JumpMap);
        view.findViewById(R.id.fragment_guet_maph).setOnClickListener(this::JumpMapH);
        view.findViewById(R.id.fragment_guet_phone).setOnClickListener(this::JumpPhone);
        view.findViewById(R.id.fragment_guet_calendar).setOnClickListener(this::JumpCalendartext);
        view.findViewById(R.id.fragment_guet_chat_group).setOnClickListener(this::JumpGroup);
        view.findViewById(R.id.fragment_guet_link).setOnClickListener(this::JumpLink);
        view.findViewById(R.id.fragment_guet_lib).setOnClickListener(this::JumpLib);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_guet, container, true);
    }
    public void JumpMusic(View view){
        startActivity(new Intent(getActivity(),GUET_Music.class));
    }
    public void JumpMap(View view){//金鸡岭地图
        ImageActivity.initmap(getActivity(),R.drawable.guet_jjl_map,"金鸡岭校区");
    }
    public void JumpMapH(View view){//花江地图
        ImageActivity.initmap(getActivity(),R.drawable.guet_map,"花江校区");
    }
    public void JumpPhone(View view){
        startActivity(new Intent(getActivity(),Guetphonenums.class));
    }
    public void JumpCalendartext(View view){
        ImageActivity.initmap(getActivity(),R.drawable.calendar_2020_2021,"教学日历");
    }
    public void JumpGroup(View view){
        WebLinksActivity.start(getActivity(),true);    }
    public void JumpLink(View view){
        WebLinksActivity.start(getActivity(),false);
    }
    public void JumpLib(View view){
        startActivity(new Intent(getActivity(), LibraryActivity.class));
    }
}