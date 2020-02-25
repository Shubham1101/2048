package com.example.a2048;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {

    public static final int SWIPE_THRESHOLD = 100;
    public static final int SWIPE_THRESHOLD_VELOCITY = 100;
    private GestureDetector gestureDetector;
    private static boolean flag = false;
    private static final int num[] = {2,2,2,2,2,2,2,2,2,4};
    private static int box[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    private static int score = 0;
    private static int hiscore = 0;

    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        prefs = this.getSharedPreferences("PrefsKey", Context.MODE_PRIVATE);
        editor = prefs.edit();
        gestureDetector = new GestureDetector(this);
        start();
    }

    public void start() {
        score = 0;
        tile();
        tile();
        board();
        return;
    }

    public void tile() {
        int n = new Random().nextInt(16);
        int m = new Random().nextInt(10);
        if(box[n]==0) {
            box[n] = num[m];
        }
        else {
            tile();
        }
        return;
    }

    public void board() {
        TextView t0 = findViewById(R.id.t0);
        TextView t1 = findViewById(R.id.t1);
        TextView t2 = findViewById(R.id.t2);
        TextView t3 = findViewById(R.id.t3);
        TextView t4 = findViewById(R.id.t4);
        TextView t5 = findViewById(R.id.t5);
        TextView t6 = findViewById(R.id.t6);
        TextView t7 = findViewById(R.id.t7);
        TextView t8 = findViewById(R.id.t8);
        TextView t9 = findViewById(R.id.t9);
        TextView ta = findViewById(R.id.ta);
        TextView tb = findViewById(R.id.tb);
        TextView tc = findViewById(R.id.tc);
        TextView td = findViewById(R.id.td);
        TextView te = findViewById(R.id.te);
        TextView tf = findViewById(R.id.tf);
        TextView sc = findViewById(R.id.score);
        TextView hs = findViewById(R.id.hscore);

        if(score > hiscore) {
            editor.putInt("score",score);
            editor.commit();
        }

        hiscore = prefs.getInt("score",0);

        sc.setText(""+score);
        hs.setText(""+hiscore);

        if(box[0]!=0) {
            t0.setText(""+box[0]);
            t0.setBackgroundResource(R.drawable.block);
        } else {
            t0.setText("");
            t0.setBackgroundResource(R.color.colorBackground);
        }
        if(box[1]!=0) {
            t1.setText(""+box[1]);
            t1.setBackgroundResource(R.drawable.block);
        } else {
            t1.setText("");
            t1.setBackgroundResource(R.color.colorBackground);
        }
        if(box[2]!=0) {
            t2.setText(""+box[2]);
            t2.setBackgroundResource(R.drawable.block);
        } else {
            t2.setText("");
            t2.setBackgroundResource(R.color.colorBackground);
        }
        if(box[3]!=0) {
            t3.setText(""+box[3]);
            t3.setBackgroundResource(R.drawable.block);
        } else {
            t3.setText("");
            t3.setBackgroundResource(R.color.colorBackground);
        }
        if(box[4]!=0) {
            t4.setText(""+box[4]);
            t4.setBackgroundResource(R.drawable.block);
        } else {
            t4.setText("");
            t4.setBackgroundResource(R.color.colorBackground);
        }
        if(box[5]!=0) {
            t5.setText(""+box[5]);
            t5.setBackgroundResource(R.drawable.block);
        } else {
            t5.setText("");
            t5.setBackgroundResource(R.color.colorBackground);
        }
        if(box[6]!=0) {
            t6.setText(""+box[6]);
            t6.setBackgroundResource(R.drawable.block);
        } else {
            t6.setText("");
            t6.setBackgroundResource(R.color.colorBackground);
        }
        if(box[7]!=0) {
            t7.setText(""+box[7]);
            t7.setBackgroundResource(R.drawable.block);
        } else {
            t7.setText("");
            t7.setBackgroundResource(R.color.colorBackground);
        }
        if(box[8]!=0) {
            t8.setText(""+box[8]);
            t8.setBackgroundResource(R.drawable.block);
        } else {
            t8.setText("");
            t8.setBackgroundResource(R.color.colorBackground);
        }
        if(box[9]!=0) {
            t9.setText(""+box[9]);
            t9.setBackgroundResource(R.drawable.block);
        } else {
            t9.setText("");
            t9.setBackgroundResource(R.color.colorBackground);
        }
        if(box[10]!=0) {
            ta.setText(""+box[10]);
            ta.setBackgroundResource(R.drawable.block);
        } else {
            ta.setText("");
            ta.setBackgroundResource(R.color.colorBackground);
        }
        if(box[11]!=0) {
            tb.setText(""+box[11]);
            tb.setBackgroundResource(R.drawable.block);
        } else {
            tb.setText("");
            tb.setBackgroundResource(R.color.colorBackground);
        }
        if(box[12]!=0) {
            tc.setText(""+box[12]);
            tc.setBackgroundResource(R.drawable.block);
        } else {
            tc.setText("");
            tc.setBackgroundResource(R.color.colorBackground);
        }
        if(box[13]!=0) {
            td.setText(""+box[13]);
            td.setBackgroundResource(R.drawable.block);
        } else {
            td.setText("");
            td.setBackgroundResource(R.color.colorBackground);
        }
        if(box[14]!=0) {
            te.setText(""+box[14]);
            te.setBackgroundResource(R.drawable.block);
        } else {
            te.setText("");
            te.setBackgroundResource(R.color.colorBackground);
        }
        if(box[15]!=0) {
            tf.setText(""+box[15]);
            tf.setBackgroundResource(R.drawable.block);
        } else {
            tf.setText("");
            tf.setBackgroundResource(R.color.colorBackground);
        }
        return;
    }

    public void clearboard() {
        for(int i=0; i<16; i++) {
            box[i] = 0;
        }
        return;
    }

    public void GAMEOVER() {
        for(int y=0; y<4; y++) {
            int x = y*4;
            if(box[x+0] == box[x+1])
                return;
            if(box[x+1] == box[x+2])
                return;
            if(box[x+2] == box[x+3])
                return;
        }
        for(int x=0; x<4; x++) {
            if(box[x+0] == box[x+4])
                return;
            if(box[x+4] == box[x+8])
                return;
            if(box[x+8] == box[x+12])
                return;
        }
        for(int i=0; i<16; i++) {
            if(box[i] == 0)
                return;
        }

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage("GAME OVER !!");
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                clearboard();
                board();
                start();
            }
        });
        dialog.setCancelable(false);
        dialog.create().show();

        return;
    }

    public void moveUP() {
        for(int x=0; x<4; x++) {
            if(box[0+x]==0 && box[4+x]==0 && box[8+x]==0 && box[12+x]==0) {
                continue;
            }
            if(box[0+x]==0) {
                flag = true;
                if(box[4+x]!=0 && box[8+x]==0 && box[12+x]==0) {
                    box[0+x] = box[4+x];
                    box[4+x] = 0;
                }
                if(box[4+x]==0 && box[8+x]!=0 && box[12+x]==0) {
                    box[0+x] = box[8+x];
                    box[8+x] = 0;
                }
                if(box[4+x]==0 && box[8+x]==0 && box[12+x]!=0) {
                    box[0+x] = box[12+x];
                    box[12+x] = 0;
                }
                if(box[4+x]==0 && box[8+x]!=0 && box[12+x]!=0) {
                    box[0+x] = box[8+x];
                    box[4+x] = box[12+x];
                    box[8+x] = 0;
                    box[12+x] = 0;
                }
                if(box[4+x]!=0 && box[8+x]==0 && box[12+x]!=0) {
                    box[0+x] = box[4+x];
                    box[4+x] = box[12+x];
                    box[12+x] = 0;
                }
                if(box[4+x]!=0 && box[8+x]!=0 && box[12+x]==0) {
                    box[0+x] = box[4+x];
                    box[4+x] = box[8+x];
                    box[8+x] = 0;
                }
                if(box[4+x]!=0 && box[8+x]!=0 && box[12+x]!=0) {
                    box[0+x] = box[4+x];
                    box[4+x] = box[8+x];
                    box[8+x] = box[12+x];
                    box[12+x] = 0;
                }
            }
            if(box[4+x]==0 && box[8+x]==0 && box[12+x]==0) {
                continue;
            }
            if(box[4+x]==0) {
                flag = true;
                if(box[8+x]!=0 && box[12+x]==0) {
                    box[4+x] = box[8+x];
                    box[8+x] = 0;
                }
                if(box[8+x]==0 && box[12+x]!=0) {
                    box[4+x] = box[12+x];
                    box[12+x] = 0;
                }
                if(box[8+x]!=0 && box[12+x]!=0) {
                    box[4+x] = box[8+x];
                    box[8+x] = box[12+x];
                    box[12+x] = 0;
                }
            }
            if(box[8+x]==0 && box[12+x]==0) {
                continue;
            }
            if(box[8+x]==0) {
                flag = true;
                box[8+x] = box[12+x];
                box[12+x] = 0;
            }
        }
        return;
    }

    public void onUP() {
        moveUP();
        for(int x=0; x<4; x++) {
            if((box[0+x] == box[4+x]) && (box[0+x]!=0)) {
                box[0+x] = 2*box[0+x];
                box[4+x] = 0;
                score = score + box[0+x] + box[4+x];
                flag = true;
            }
            if((box[4+x] == box[8+x]) && (box[4+x]!=0)) {
                box[4+x] = 2*box[4+x];
                box[8+x] = 0;
                score = score + box[4+x] + box[8+x];
                flag = true;
            }
            if((box[8+x] == box[12+x]) && (box[8+x]!=0)) {
                box[8+x] = 2*box[8+x];
                box[12+x] = 0;
                score = score + box[8+x] + box[12+x];
                flag = true;
            }
        }
        moveUP();
        if(flag) {
            tile();
            board();
            GAMEOVER();
            flag = false;
        }
        return;
    }

    public void moveDOWN() {
        for(int x=0; x<4; x++) {
            if(box[12+x]==0 && box[8+x]==0 && box[4+x]==0 && box[0+x]==0) {
                continue;
            }
            if(box[12+x]==0) {
                flag = true;
                if(box[8+x]!=0 && box[4+x]==0 && box[0+x]==0) {
                    box[12+x] = box[8+x];
                    box[8+x] = 0;
                }
                if(box[8+x]==0 && box[4+x]!=0 && box[0+x]==0) {
                    box[12+x] = box[4+x];
                    box[4+x] = 0;
                }
                if(box[8+x]==0 && box[4+x]==0 && box[0+x]!=0) {
                    box[12+x] = box[0+x];
                    box[0+x] = 0;
                }
                if(box[8+x]==0 && box[4+x]!=0 && box[0+x]!=0) {
                    box[12+x] = box[4+x];
                    box[8+x] = box[0+x];
                    box[4+x] = 0;
                    box[0+x] = 0;
                }
                if(box[8+x]!=0 && box[4+x]==0 && box[0+x]!=0) {
                    box[12+x] = box[8+x];
                    box[8+x] = box[0+x];
                    box[0+x] = 0;
                }
                if(box[8+x]!=0 && box[4+x]!=0 && box[0+x]==0) {
                    box[12+x] = box[8+x];
                    box[8+x] = box[4+x];
                    box[4+x] = 0;
                }
                if(box[8+x]!=0 && box[4+x]!=0 && box[0+x]!=0) {
                    box[12+x] = box[8+x];
                    box[8+x] = box[4+x];
                    box[4+x] = box[0+x];
                    box[0+x] = 0;
                }
            }
            if(box[8+x]==0 && box[4+x]==0 && box[0+x]==0) {
                continue;
            }
            if(box[8+x]==0) {
                flag = true;
                if(box[4+x]!=0 && box[0+x]==0) {
                    box[8+x] = box[4+x];
                    box[4+x] = 0;
                }
                if(box[4+x]==0 && box[0+x]!=0) {
                    box[8+x] = box[0+x];
                    box[0+x] = 0;
                }
                if(box[4+x]!=0 && box[0+x]!=0) {
                    box[8+x] = box[4+x];
                    box[4+x] = box[0+x];
                    box[0+x] = 0;
                }
            }
            if(box[4+x]==0 && box[0+x]==0) {
                continue;
            }
            if(box[4+x]==0) {
                flag = true;
                box[4+x] = box[0+x];
                box[0+x] = 0;
            }
        }
        return;
    }

    public void onDOWN() {
        moveDOWN();
        for(int x=0; x<4; x++) {
            if((box[12+x] == box[8+x]) && (box[12+x]!=0)) {
                box[12+x] = 2*box[12+x];
                box[8+x] = 0;
                score = score + box[12+x] + box[8+x];
                flag = true;
            }
            if((box[8+x] == box[4+x]) && (box[8+x]!=0)) {
                box[8+x] = 2*box[8+x];
                box[4+x] = 0;
                score = score + box[8+x] + box[4+x];
                flag = true;
            }
            if((box[4+x] == box[0+x]) && (box[4+x]!=0)) {
                box[4+x] = 2*box[4+x];
                box[0+x] = 0;
                score = score + box[4+x] + box[0+x];
                flag = true;
            }
        }
        moveDOWN();
        if(flag) {
            tile();
            board();
            GAMEOVER();
            flag = false;
        }
        return;
    }

    public void moveLEFT() {
        for(int y=0; y<4; y++) {
            int x = y*4;
            if(box[0+x]==0 && box[1+x]==0 && box[2+x]==0 && box[3+x]==0) {
                continue;
            }
            if(box[0+x]==0) {
                flag = true;
                if(box[1+x]!=0 && box[2+x]==0 && box[3+x]==0) {
                    box[0+x] = box[1+x];
                    box[1+x] = 0;
                }
                if(box[1+x]==0 && box[2+x]!=0 && box[3+x]==0) {
                    box[0+x] = box[2+x];
                    box[2+x] = 0;
                }
                if(box[1+x]==0 && box[2+x]==0 && box[3+x]!=0) {
                    box[0+x] = box[3+x];
                    box[3+x] = 0;
                }
                if(box[1+x]==0 && box[2+x]!=0 && box[3+x]!=0) {
                    box[0+x] = box[2+x];
                    box[1+x] = box[3+x];
                    box[2+x] = 0;
                    box[3+x] = 0;
                }
                if(box[1+x]!=0 && box[2+x]==0 && box[3+x]!=0) {
                    box[0+x] = box[1+x];
                    box[1+x] = box[3+x];
                    box[3+x] = 0;
                }
                if(box[1+x]!=0 && box[2+x]!=0 && box[3+x]==0) {
                    box[0+x] = box[1+x];
                    box[1+x] = box[2+x];
                    box[2+x] = 0;
                }
                if(box[1+x]!=0 && box[2+x]!=0 && box[3+x]!=0) {
                    box[0+x] = box[1+x];
                    box[1+x] = box[2+x];
                    box[2+x] = box[3+x];
                    box[3+x] = 0;
                }
            }
            if(box[1+x]==0 && box[2+x]==0 && box[3+x]==0) {
                continue;
            }
            if(box[1+x]==0) {
                flag = true;
                if(box[2+x]!=0 && box[3+x]==0) {
                    box[1+x] = box[2+x];
                    box[2+x] = 0;
                }
                if(box[2+x]==0 && box[3+x]!=0) {
                    box[1+x] = box[3+x];
                    box[3+x] = 0;
                }
                if(box[2+x]!=0 && box[3+x]!=0) {
                    box[1+x] = box[2+x];
                    box[2+x] = box[3+x];
                    box[3+x] = 0;
                }
            }
            if(box[2+x]==0 && box[3+x]==0) {
                continue;
            }
            if(box[2+x]==0) {
                flag = true;
                box[2+x] = box[3+x];
                box[3+x] = 0;
            }
        }
        return;
    }

    public void onLEFT() {
        moveLEFT();
        for(int y=0; y<4; y++) {
            int x = y*4;
            if((box[0+x] == box[1+x]) && (box[0+x]!=0)) {
                box[0+x] = 2*box[0+x];
                box[1+x] = 0;
                score = score + box[0+x] + box[1+x];
                flag = true;
            }
            if((box[1+x] == box[2+x]) && (box[1+x]!=0)) {
                box[1+x] = 2*box[1+x];
                box[2+x] = 0;
                score = score + box[1+x] + box[2+x];
                flag = true;
            }
            if((box[2+x] == box[3+x]) && (box[2+x]!=0)) {
                box[2+x] = 2*box[2+x];
                box[3+x] = 0;
                score = score + box[2+x] + box[3+x];
                flag = true;
            }
        }
        moveLEFT();
        if(flag) {
            tile();
            board();
            GAMEOVER();
            flag = false;
        }
        return;
    }

    public void moveRIGHT() {
        for(int y=0; y<4; y++) {
            int x = y*4;
            if(box[3+x]==0 && box[2+x]==0 && box[1+x]==0 && box[0+x]==0) {
                continue;
            }
            if(box[3+x]==0) {
                flag = true;
                if(box[2+x]!=0 && box[1+x]==0 && box[0+x]==0) {
                    box[3+x] = box[2+x];
                    box[2+x] = 0;
                }
                if(box[2+x]==0 && box[1+x]!=0 && box[0+x]==0) {
                    box[3+x] = box[1+x];
                    box[1+x] = 0;
                }
                if(box[2+x]==0 && box[1+x]==0 && box[0+x]!=0) {
                    box[3+x] = box[0+x];
                    box[0+x] = 0;
                }
                if(box[2+x]==0 && box[1+x]!=0 && box[0+x]!=0) {
                    box[3+x] = box[1+x];
                    box[2+x] = box[0+x];
                    box[1+x] = 0;
                    box[0+x] = 0;
                }
                if(box[2+x]!=0 && box[1+x]==0 && box[0+x]!=0) {
                    box[3+x] = box[2+x];
                    box[2+x] = box[0+x];
                    box[0+x] = 0;
                }
                if(box[2+x]!=0 && box[1+x]!=0 && box[0+x]==0) {
                    box[3+x] = box[2+x];
                    box[2+x] = box[1+x];
                    box[1+x] = 0;
                }
                if(box[2+x]!=0 && box[1+x]!=0 && box[0+x]!=0) {
                    box[3+x] = box[2+x];
                    box[2+x] = box[1+x];
                    box[1+x] = box[0+x];
                    box[0+x] = 0;
                }
            }
            if(box[2+x]==0 && box[1+x]==0 && box[0+x]==0) {
                continue;
            }
            if(box[2+x]==0) {
                flag = true;
                if(box[1+x]!=0 && box[0+x]==0) {
                    box[2+x] = box[1+x];
                    box[1+x] = 0;
                }
                if(box[1+x]==0 && box[0+x]!=0) {
                    box[2+x] = box[0+x];
                    box[0+x] = 0;
                }
                if(box[1+x]!=0 && box[0+x]!=0) {
                    box[2+x] = box[1+x];
                    box[1+x] = box[0+x];
                    box[0+x] = 0;
                }
            }
            if(box[1+x]==0 && box[0+x]==0) {
                continue;
            }
            if(box[1+x]==0) {
                flag = true;
                box[1+x] = box[0+x];
                box[0+x] = 0;
            }
        }
        return;
    }

    public void onRIGHT() {
        moveRIGHT();
        for(int y=0; y<4; y++) {
            int x = y*4;
            if((box[3+x] == box[2+x]) && (box[3+x]!=0)) {
                box[3+x] = 2*box[3+x];
                box[2+x] = 0;
                score = score + box[3+x] + box[2+x];
                flag = true;
            }
            if((box[2+x] == box[1+x]) && (box[2+x]!=0)) {
                box[2+x] = 2*box[2+x];
                box[1+x] = 0;
                score = score + box[2+x] + box[1+x];
                flag = true;
            }
            if((box[1+x] == box[0+x]) && (box[1+x]!=0)) {
                box[1+x] = 2*box[0+x];
                box[0+x] = 0;
                score = score + box[1+x] + box[0+x];
                flag = true;
            }
        }
        moveRIGHT();
        if(flag) {
            tile();
            board();
            GAMEOVER();
            flag = false;
        }
        return;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        boolean result = false;
        float diffY = e2.getY() - e1.getY();
        float diffX = e2.getX() - e1.getX();

        if(Math.abs(diffX) > Math.abs(diffY)) {
            if(Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                if(diffX > 0) {
                    onRIGHT();
                }
                else{
                    onLEFT();
                }
                result = true;
            }
        }
        else {
            if(Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
                if(diffY > 0) {
                    onDOWN();
                }
                else {
                    onUP();
                }
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
