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
            "Chair","Round table","Wooden table","java","java2","cycle1","cycle2","metal chair","arm chair"

    };

    Integer[] imgid={
            R.drawable.full_product_image,
            R.drawable.kjik,
            R.drawable.erjg,
            R.drawable.download,
            R.drawable.table2,
            R.drawable.table3,
            R.drawable.javabook,
            R.drawable.java2,
            R.drawable.cycle2,
            R.drawable.cycle3,
            R.drawable.armchair,
            R.drawable.metal,


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
                else if(position == 4)
                {

                    Toast.makeText(getApplicationContext(),"Item sold",Toast.LENGTH_LONG).show();

                }
                else if(position == 5)
                {

                    Toast.makeText(getApplicationContext(),"Item sold",Toast.LENGTH_LONG).show();

                }
                else if(position == 6)
                {

                    Toast.makeText(getApplicationContext(),"Item sold",Toast.LENGTH_LONG).show();

                }
                else if(position == 7)
                {

                    Toast.makeText(getApplicationContext(),"Item sold",Toast.LENGTH_LONG).show();

                }
                else if(position == 8)
                {

                    Toast.makeText(getApplicationContext(),"Item sold",Toast.LENGTH_LONG).show();

                }
                else if(position == 9)
                {

                    Toast.makeText(getApplicationContext(),"Item sold",Toast.LENGTH_LONG).show();

                }
                else if(position == 10)
                {

                    Toast.makeText(getApplicationContext(),"Item sold",Toast.LENGTH_LONG).show();

                }
                else if(position == 11)
                {

                    Toast.makeText(getApplicationContext(),"Item sold",Toast.LENGTH_LONG).show();
                }
                else if(position == 12)
                {

                    Toast.makeText(getApplicationContext(),"Item sold",Toast.LENGTH_LONG).show();

                }


            }
        });



    }
}