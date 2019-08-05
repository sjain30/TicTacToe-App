package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //2: o. 1: x


    int map[]= new int[10];

    int player;
    boolean gameover=false;

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            EditText play= findViewById(R.id.editText);

            String get= play.getText().toString();
            if(get.equals("X")||get.equals("x")){
                player=1;
            }else
                player=2;
//            play.setText("");
            play.setEnabled(false);
            if (player==2) {

                Toast.makeText(MainActivity.this, "O goes first", Toast.LENGTH_LONG).show();
            }else
                Toast.makeText(MainActivity.this, "X goes first", Toast.LENGTH_LONG).show();


        }

    };


    public void dropIn(View view)
    {

        ImageView imageview = (ImageView)view;
        int tag= Integer.parseInt(imageview.getTag().toString());
        if (map[tag+1]==0 && gameover==false) {
            imageview.setTranslationY(-1500);
            map[tag + 1] = player;
            int checker=player;
            if (player == 2) {
                imageview.setImageResource(R.drawable.tac);
                player = 1;
            } else {
                imageview.setImageResource(R.drawable.tic);
                player = 2;
            }
            imageview.animate().translationYBy(1500).setDuration(500);

            if (check(checker)) {
                String winner;
                if (checker == 2) {
                    winner = "O";
                } else {
                    winner = "X";
                }
                gameover=true;
                TextView textview = findViewById(R.id.textView);
                Button button = findViewById(R.id.button);
                textview.setText(winner + " has won!");
                textview.setVisibility(View.VISIBLE);
                button.setVisibility(View.VISIBLE);
            }
            else if (draw()){
                TextView textview = findViewById(R.id.textView);
                textview.setText("It's a draw!");
                textview.setVisibility(View.VISIBLE);
                Button button = findViewById(R.id.button);
                button.setVisibility(View.VISIBLE);
            }
        }
    }

    public void playagain(View view)
    {
        TextView textview = findViewById(R.id.textView);
        textview.setVisibility(View.INVISIBLE);

        Button button = findViewById(R.id.button);

//        EditText editText = findViewById(R.id.editText);
//        editText.setVisibility(View.VISIBLE);
//
//        char ch= editText.getText().toString().charAt(0);
//        if (ch=='x' || ch=='X'){
//            player=1;
//        }
//        else{
//            player=2;
//        }
//        editText.setVisibility(View.INVISIBLE);
//
//        Toast.makeText(this, ch+" goes first", Toast.LENGTH_LONG).show();
        button.setVisibility(View.INVISIBLE);

        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
        for(int i=0; i<gridLayout.getChildCount(); i++) {

            ImageView counter = (ImageView) gridLayout.getChildAt(i);

            counter.setImageDrawable(null);

        }

        for (int i = 0; i < map.length; i++) {
            map[i]=0;
        }
        player=2;
        gameover=false;
    }

    public boolean check(int item)
    {

        if (map[7]==item && map[8]==item &&map[9]==item){
            return true;
        }
        if (map[4]==item &&map[5]==item &&map[6]==item){
            return true;
        }
        if (map[1]==item && map[2]==item &&map[3]==item){
            return true;
        }
        if (map[7]==item && map[4]==item &&map[1]==item){
            return true;
        }
        if (map[8]==item && map[5]==item &&map[2]==item){
            return true;
        }
        if (map[9]==item && map[6]==item &&map[3]==item){
            return true;
        }
        if (map[7]==item && map[5]==item &&map[3]==item){
            return true;
        }
        if (map[9]==item && map[5]==item &&map[1]==item){
            return true;
        }
        return false;
    }

    public boolean draw()
    {
        if (map[0]==0 && map[1]!=0 &&map[2]!=0 &&map[3]!=0 &&map[4]!=0 &&map[5]!=0 &&map[6]!=0 &&map[7]!=0 && map[8]!=0 &&map[9]!=0)
            return true;
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button=findViewById(R.id.button2);
//
//        EditText editText = findViewById(R.id.editText);
//        char ch= editText.getText().toString().charAt(0);
//        if (ch=='x' || ch=='X'){
//            player=1;
//        }
//        else{
//            player=2;
//        }
//        editText.setVisibility(View.INVISIBLE);


        button.setOnClickListener(listener);

//            Toast.makeText(this, "O goes first", Toast.LENGTH_LONG).show();

    }
}
