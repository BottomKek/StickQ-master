package com.mygdx.game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.Random;

public class BattleActivity extends AppCompatActivity {

    Button button;
    Button button2;
    Button button3;
    Button button4;
    TextView textView;
    TextView textView2;

    private Random rand = new Random();
    private Enemy enemy = new Enemy(rand.nextInt(21) + 30, rand.nextInt(21) + 30, rand.nextInt(21) + 30, rand.nextInt(21) + 30);
    private PlayerCharacter player = new PlayerCharacter(50, 45, 30, 30, 40);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);


        ImageView imageView2 = (ImageView) findViewById(R.id.enemy2);



        Glide.with(this).load("https://thumbs.gfycat.com/AnotherCourageousBluemorphobutterfly-small.gif").into(imageView2);

        button = (Button) findViewById(R.id.attackButton);
        button2 = (Button) findViewById(R.id.magicButton);
        button3 = (Button) findViewById(R.id.examineButton);
        button4 = (Button) findViewById(R.id.runButton);
        textView = (TextView) findViewById(R.id.textView5);
        textView2 = (TextView) findViewById(R.id.textView7);

        button.setText("Attack");
        button2.setText("Magic");
        button3.setText("Examine");
        button4.setText("Run");


        textView.setText("Your Stats - \nHP: " + player.getHealth() + "\nATK: " + player.getAttack() + "\nDEF: " + player.getDefense() + "\nMAG: " + player.getMagic() + "\nSPD: " + player.getSpeed());
        textView2.setText("Enemy Stats - \nHP: " + enemy.getHealth() + "\nATK: ???" + "\nDEF: ???" + "\nMAG: 0" + "\nSPD: ???");



    }


    /*
    int turnSelectOutput;
    public int turnSelect(Button one, Button two, Button three, Button four) {
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnSelectOutput = 1;

            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });turnSelectOutput = 2;
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnSelectOutput = 3;
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnSelectOutput = 4;
            }
        });
        return turnSelectOutput;
    }
    */

    public void attackTurn (View v){
        int calcOutput = calculations(1);
        if (calcOutput == -1){
            Toast.makeText(BattleActivity.this,
                    "YOU LOST!", Toast.LENGTH_SHORT).show();
        }
        else if (calcOutput == 0){
            Toast.makeText(BattleActivity.this,
                    "YOU RAN AWAY!", Toast.LENGTH_SHORT).show();
        }
        else if (calcOutput == 1) {
            Toast.makeText(BattleActivity.this,
                    "YOU WON!", Toast.LENGTH_SHORT).show();
        }
        else {
            textView.setText("Your Stats - \nHP: " + player.getHealth() + "\nATK: " + player.getAttack() + "\nDEF: " + player.getDefense() + "\nMAG: " + player.getMagic() + "\nSPD: " + player.getSpeed());
        }
    }

    public void magicTurn (View v){
        int calcOutput = calculations(2);
        if (calcOutput == -1){
            Toast.makeText(BattleActivity.this,
                    "YOU LOST!", Toast.LENGTH_SHORT).show();
        }
        else if (calcOutput == 0){
            Toast.makeText(BattleActivity.this,
                    "YOU RAN AWAY!", Toast.LENGTH_SHORT).show();
        }
        else if (calcOutput == 1) {
            Toast.makeText(BattleActivity.this,
                    "YOU WON!", Toast.LENGTH_SHORT).show();
        }
        else {
            textView.setText("Your Stats - \nHP: " + player.getHealth() + "\nATK: " + player.getAttack() + "\nDEF: " + player.getDefense() + "\nMAG: " + player.getMagic() + "\nSPD: " + player.getSpeed());
        }
    }

    public void examineTurn (View v){
        int calcOutput = calculations(3);
        if (calcOutput == -1){
            Toast.makeText(BattleActivity.this,
                    "YOU LOST!", Toast.LENGTH_SHORT).show();
        }
        else if (calcOutput == 0){
            Toast.makeText(BattleActivity.this,
                    "YOU RAN AWAY!", Toast.LENGTH_SHORT).show();
        }
        else if (calcOutput == 1) {
            Toast.makeText(BattleActivity.this,
                    "YOU WON!", Toast.LENGTH_SHORT).show();
        }
        else {
            textView.setText("Your Stats - \nHP: " + player.getHealth() + "\nATK: " + player.getAttack() + "\nDEF: " + player.getDefense() + "\nMAG: " + player.getMagic() + "\nSPD: " + player.getSpeed());
        }
    }

    public void runAwayTurn (View v){
        int calcOutput = calculations(4);
        if (calcOutput == -1){
            Toast.makeText(BattleActivity.this,
                    "YOU LOST!", Toast.LENGTH_SHORT).show();
        }
        else if (calcOutput == 0){
            Toast.makeText(BattleActivity.this,
                    "YOU RAN AWAY!", Toast.LENGTH_SHORT).show();
        }
        else if (calcOutput == 1) {
            Toast.makeText(BattleActivity.this,
                    "YOU WON!", Toast.LENGTH_SHORT).show();
        }
        else {
            textView.setText("Your Stats - \nHP: " + player.getHealth() + "\nATK: " + player.getAttack() + "\nDEF: " + player.getDefense() + "\nMAG: " + player.getMagic() + "\nSPD: " + player.getSpeed());
        }
    }

    public int calculations (int output){
        int playerDamage;
        int enemyDamage;
        if (output == 1) {
            playerDamage = damageCalc(player.getAttack(), enemy.getDefense(), rand.nextInt(11) + 5);
            enemyDamage = damageCalc(enemy.getAttack(), player.getDefense(), rand.nextInt(11));
            if (enemy.getSpeed() > player.getSpeed()){
                player.setHealth(player.getHealth() - enemyDamage);
                if (player.getHealth() <= 0){
                    return -1;
                }
                else {
                    enemy.setHealth(enemy.getHealth() - playerDamage);
                    if (enemy.getHealth() <= 0){
                        return 1;
                    }
                }
            }
            else {
                enemy.setHealth(enemy.getHealth() - playerDamage);
                if (enemy.getHealth() <= 0){
                    return 1;
                }
                else {
                    player.setHealth(player.getHealth() - enemyDamage);
                    if (player.getHealth() <= 0){
                        return -1;
                    }
                }
            }
        }

        if (output == 2){
            enemyDamage = damageCalc(enemy.getAttack(), player.getDefense(), rand.nextInt(11));
            if (enemy.getSpeed() > player.getSpeed()) {
                player.setHealth(player.getHealth() - enemyDamage);
                if (player.getHealth() <= 0) {
                    return -1;
                }
                else {
                    player.setHealth(player.getHealth() + 10);
                    player.setMagic(player.getMagic() - 10);
                }
            }
            else {
                player.setHealth(player.getHealth() + 10);
                player.setMagic(player.getMagic() - 10);
                player.setHealth(player.getHealth() - enemyDamage);
                if (player.getHealth() <= 0) {
                    return -1;
                }
            }
        }

        if (output == 3){
            enemyDamage = damageCalc(enemy.getAttack(), player.getDefense(), rand.nextInt(11));
            textView2.setText("Enemy Stats - \nHP: " + enemy.getHealth() + "\nATK: " + enemy.getAttack() + "\nDEF: " + enemy.getDefense() + "\nMAG: 0"  + "\nSPD: " + enemy.getSpeed());
            player.setHealth(player.getHealth() - enemyDamage);
            if (player.getHealth() <= 0) {
                return -1;
            }
        }

        if (output == 4){
            enemyDamage = damageCalc(enemy.getAttack(), player.getDefense(), rand.nextInt(11));
            if (player.getSpeed() >= enemy.getSpeed()){
                return 0;
            }
            else {
                player.setHealth(player.getHealth() - enemyDamage);
                if (player.getHealth() <= 0) {
                    return -1;
                }
            }
        }

        return 2;
    }

    public int damageCalc (int attackStat, int enemyDefense, int attackPower) {
        return (attackStat * attackPower) / enemyDefense;
    }


}
