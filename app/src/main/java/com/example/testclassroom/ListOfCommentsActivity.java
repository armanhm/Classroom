package com.example.testclassroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class ListOfCommentsActivity extends AppCompatActivity {
    static String result = "" ;
    RecyclerView recyclerView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_comments);
        ArrayList <ItemComment> itemComments = new ArrayList<>() ;


        String[] s = result.split(":");
        //itemComments.addAll(Arrays.asList(s).subList(1, s.length));


        for (int i = 0; i < s.length ; i += 2) {
            ItemComment itemComment = new ItemComment(s[i],s[i+1]);
            itemComments.add(itemComment) ;
        }

        CommentsAdapter commentsAdapter = new CommentsAdapter(R.layout.item_comments,itemComments);
        recyclerView = findViewById(R.id.recyclerView_comments) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(commentsAdapter);




        String homeworkCode = getIntent().getStringExtra("homeworkCode");
        new TransferMessage().execute("commentsList:" + homeworkCode+":") ;

    }
}
