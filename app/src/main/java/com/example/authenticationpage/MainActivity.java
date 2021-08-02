package com.example.authenticationpage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"LEVI'S", "PETER ENGLAND", "UNITED COLORS OF BENETTON", "U.S.POLO ASSN.", "NETPLAY", "JOHN PLAYERS", "DNMX",};
    String mDescription[] = {"Rs.2199", "Rs.2499", "Rs.1699", "Rs.1999", "Rs.1499", "Rs.1299", "Rs.1099"};
    int images[] = {R.drawable.levis, R.drawable.peterengland, R.drawable.ucb, R.drawable.uspolo, R.drawable.netplay, R.drawable.johnplayers, R.drawable.dnmx};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter( this, mTitle, mDescription, images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
                    Toast.makeText(MainActivity.this, "Rs.2199", Toast.LENGTH_SHORT).show();
                }
                if(position == 1) {
                    Toast.makeText(MainActivity.this, "Rs.2499", Toast.LENGTH_SHORT).show();
                }
                if(position == 2) {
                    Toast.makeText(MainActivity.this, "Rs.1699", Toast.LENGTH_SHORT).show();
                }
                if(position == 3) {
                    Toast.makeText(MainActivity.this, "Rs.1999", Toast.LENGTH_SHORT).show();
                }
                if(position == 4) {
                    Toast.makeText(MainActivity.this, "Rs.1499", Toast.LENGTH_SHORT).show();
                }
                if(position == 5) {
                    Toast.makeText(MainActivity.this, "Rs.1299", Toast.LENGTH_SHORT).show();
                }
                if(position == 6) {
                    Toast.makeText(MainActivity.this, "Rs.1099", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void Logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();



    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter (Context c, String title[], String description[], int imgs[]) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image) ;
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);
            return row;
        }
    }
}