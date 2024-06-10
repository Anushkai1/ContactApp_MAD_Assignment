package com.example.contactapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Contact[] contacts = {
            new Contact("Nimal Perera", "011-2345678", "nimal12345@co.lk", "123 Galle Rd, Colombo"),
            new Contact("Kamal Silva", "011-3456789", "kamal23456@co.lk", "456 Kandy Rd, Kandy"),
            new Contact("Sunil Jayasinghe", "011-4567890", "sunil34567@co.lk", "789 Main St, Galle"),
            new Contact("Anura Wijesinghe", "011-5678901", "anura45678@co.lk", "101 Temple Rd, Matara"),
            new Contact("Rohana Fernando", "011-6789012", "rohan56789@co.lk", "202 Beach Rd, Negombo"),
            new Contact("Mala Seneviratne", "011-7890123", "mala67890@co.lk", "303 Hill St, Nuwara Eliya"),
            new Contact("Chandana Bandara", "011-8901234", "chand78901@co.lk", "404 Lake Rd, Anuradhapura"),
            new Contact("Nisha Karunaratne", "011-9012345", "nisha89012@co.lk", "505 River Rd, Polonnaruwa"),
            new Contact("Ravi de Silva", "011-0123456", "ravi90123@co.lk", "606 Palm St, Trincomalee"),
            new Contact("Gayathri Rajapaksa", "011-1234567", "gayat01234@co.lk", "707 Forest Rd, Jaffna")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public class Contact {
        public String name;
        public String phone;
        public String email;
        public String address;

        public Contact(String name, String phone, String email, String address) {
            this.name = name;
            this.phone = phone;
            this.email = email;
            this.address = address;
        }
    }
}