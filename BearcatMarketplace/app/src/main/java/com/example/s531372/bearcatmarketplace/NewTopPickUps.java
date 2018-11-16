package com.example.s531372.bearcatmarketplace;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class NewTopPickUps extends Activity {

    ListView list;
    String[] itemname ={
            "Table (Sold)",
            "Book",
            "Bike",
            "Chair"

    };

    Integer[] imgid={
            R.drawable.full_product_image,
            R.drawable.kjik,
            R.drawable.erjg,
            R.drawable.download,

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_top_pick_ups);

        CustomListAdapter adapter=new CustomListAdapter(this, itemname, imgid);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
//                String Slecteditem= itemname[+position];
//                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();
                if(position == 0)
                {
                    Toast.makeText(getApplicationContext(),"Item sold",Toast.LENGTH_LONG).show();
                }
                else if(position == 1)
                {
                    Toast.makeText(getApplicationContext(),"Item sold",Toast.LENGTH_LONG).show();

                }

                else if(position == 2)
                {
                    Toast.makeText(getApplicationContext(),"Item sold",Toast.LENGTH_LONG).show();

                }

                else if(position == 3)
                {

                    Toast.makeText(getApplicationContext(),"Item sold",Toast.LENGTH_LONG).show();

                }

            }
        });



    }
}