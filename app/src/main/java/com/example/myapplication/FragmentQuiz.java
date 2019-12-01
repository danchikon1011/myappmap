package com.example.myapplication;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProviders;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ResourceBundle;

public class FragmentQuiz extends Fragment {
ConstraintLayout bg;
    public static FragmentQuiz newInstance() {
        return new FragmentQuiz();
    }
    int count=1;
    TextView question;
    EditText answer;
    Resources rs;
    String[]ListAnswers;
    String[]ListQuestions;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_quiz_fragment, container, false);
        bg=view.findViewById(R.id.quiz_bg);
        answer=view.findViewById(R.id.editText);
        question=view.findViewById(R.id.textView);
        rs=view.getResources();
        ListAnswers=new String[]{rs.getString(R.string.Answer1),rs.getString(R.string.Answer2),rs.getString(R.string.Answer3),rs.getString(R.string.Answer4),rs.getString(R.string.Answer5),rs.getString(R.string.Answer6),rs.getString(R.string.Answer7),rs.getString(R.string.Answer8),
                rs.getString(R.string.Answer9),rs.getString(R.string.Answer10),rs.getString(R.string.Answer11)};
        ListQuestions=new String[]{rs.getString(R.string.Question1),rs.getString(R.string.Question2),rs.getString(R.string.Question3),rs.getString(R.string.Question4),rs.getString(R.string.Question5),rs.getString(R.string.Question6),rs.getString(R.string.Question7),rs.getString(R.string.Question8),
                rs.getString(R.string.Question9),rs.getString(R.string.Question10),rs.getString(R.string.Question11)};
        bg.setOnTouchListener(new OnSwipeTouchListener(getContext()) {

            //public void onSwipeRight() {

            //}
            public void onSwipeLeft() {
                Log.d("TAG", "onSwipeLeft: "+answer.getText().toString().toLowerCase());
                Log.d("TAG", "onSwipeLeft: "+ListAnswers[count-1].toLowerCase());
                if(answer.getText().toString().toLowerCase().equals(ListAnswers[count-1].toLowerCase())) {
                    count++;
                    question.setText(ListQuestions[count]);
                    answer.setText(null);
                    Log.d("TAG", "onSwipeLeft: if есть");
                }
                Log.d("TAG", "onSwipeLeft: есть");



            }


        });
        return view;

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

}
