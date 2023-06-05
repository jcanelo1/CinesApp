package com.theaterapp.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BuyTicketActivity extends AppCompatActivity {

    private EditText etName, etEmail, etQuantity, etTitle;
    private Button btnBuyTicket;

    private databaseActivity.DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_ticket);

        dbHelper = new databaseActivity.DatabaseHelper(this);

        etName = findViewById(R.id.et_name);
        etEmail = findViewById(R.id.et_email);
        etQuantity = findViewById(R.id.quantity);
        etTitle = findViewById(R.id.title);
        btnBuyTicket = findViewById(R.id.btn_buy_ticket);

        btnBuyTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String quantityStr = etQuantity.getText().toString().trim();
                String title = etTitle.getText().toString().trim();

                if (name.isEmpty() || email.isEmpty() || quantityStr.isEmpty() || title.isEmpty()) {
                    Toast.makeText(BuyTicketActivity.this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    int quantity = Integer.parseInt(quantityStr);
                    dbHelper.bookTicket(name, email, quantity, title);
                    Toast.makeText(BuyTicketActivity.this, "Ticket booked successfully", Toast.LENGTH_SHORT).show();
                    // Handle successful ticket booking, e.g., navigate to ticket details activity
                }
            }
        });
    }

    public static void buyTicket(Context context, EditText etName, EditText etEmail, EditText etQuantity) {
        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String quantity = etQuantity.getText().toString().trim();

        // Perform ticket purchase logic here

        Toast.makeText(context, "Ticket purchased by " + name + " (" + email + quantity + ")", Toast.LENGTH_SHORT).show();
    }
}
