package com.example.foodhungry;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    int c1=0, c2=0, c3=0, c4=0, c5=0, c6=0, c7=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Counters TextViews
        TextView count1 = findViewById(R.id.count1);
        TextView count2 = findViewById(R.id.count2);
        TextView count3 = findViewById(R.id.count3);
        TextView count4 = findViewById(R.id.count4);
        TextView count5 = findViewById(R.id.count5);
        TextView count6 = findViewById(R.id.count6);
        TextView count7 = findViewById(R.id.count7);

        // Buttons +/-
        Button plus1 = findViewById(R.id.plus1);
        Button plus2 = findViewById(R.id.plus2);
        Button plus3 = findViewById(R.id.plus3);
        Button plus4 = findViewById(R.id.plus4);
        Button plus5 = findViewById(R.id.plus5);
        Button plus6 = findViewById(R.id.plus6);
        Button plus7 = findViewById(R.id.plus7);

        Button minus1 = findViewById(R.id.minus1);
        Button minus2 = findViewById(R.id.minus2);
        Button minus3 = findViewById(R.id.minus3);
        Button minus4 = findViewById(R.id.minus4);
        Button minus5 = findViewById(R.id.minus5);
        Button minus6 = findViewById(R.id.minus6);
        Button minus7 = findViewById(R.id.minus7);

        // ===== PLUS LISTENERS =====
        plus1.setOnClickListener(v -> { c1++; count1.setText(String.valueOf(c1)); });
        plus2.setOnClickListener(v -> { c2++; count2.setText(String.valueOf(c2)); });
        plus3.setOnClickListener(v -> { c3++; count3.setText(String.valueOf(c3)); });
        plus4.setOnClickListener(v -> { c4++; count4.setText(String.valueOf(c4)); });
        plus5.setOnClickListener(v -> { c5++; count5.setText(String.valueOf(c5)); });
        plus6.setOnClickListener(v -> { c6++; count6.setText(String.valueOf(c6)); });
        plus7.setOnClickListener(v -> { c7++; count7.setText(String.valueOf(c7)); });

        // ===== MINUS LISTENERS =====
        minus1.setOnClickListener(v -> { if(c1>0){c1--; count1.setText(String.valueOf(c1));} });
        minus2.setOnClickListener(v -> { if(c2>0){c2--; count2.setText(String.valueOf(c2));} });
        minus3.setOnClickListener(v -> { if(c3>0){c3--; count3.setText(String.valueOf(c3));} });
        minus4.setOnClickListener(v -> { if(c4>0){c4--; count4.setText(String.valueOf(c4));} });
        minus5.setOnClickListener(v -> { if(c5>0){c5--; count5.setText(String.valueOf(c5));} });
        minus6.setOnClickListener(v -> { if(c6>0){c6--; count6.setText(String.valueOf(c6));} });
        minus7.setOnClickListener(v -> { if(c7>0){c7--; count7.setText(String.valueOf(c7));} });

        // ===== CONFIRM ORDER BUTTON =====
        Button btnConfirmOrder = findViewById(R.id.btnConfirmOrder);
        btnConfirmOrder.setOnClickListener(v -> {
            int totalOrders = c1+c2+c3+c4+c5+c6+c7;
            if(totalOrders>0){
                Toast.makeText(HomeActivity.this,
                        "Your " + totalOrders + " orders are confirmed!",
                        Toast.LENGTH_SHORT).show();

                // Reset counters
                c1=c2=c3=c4=c5=c6=c7=0;
                count1.setText("0"); count2.setText("0"); count3.setText("0");
                count4.setText("0"); count5.setText("0"); count6.setText("0"); count7.setText("0");
            } else {
                Toast.makeText(HomeActivity.this,
                        "No items in your cart!",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // ===== LOGOUT BUTTON =====
        Button btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });
    }
}
