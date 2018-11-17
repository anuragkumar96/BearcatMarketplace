package com.example.s531372.bearcatmarketplace;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class TopPickUpsActivity extends Activity {

    ListView list;
    String[] itemname ={
            "Table",
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
        setContentView(R.layout.activity_top_pick_ups);



        CustomListAdapter adapter=new CustomListAdapter(this, itemname, imgid);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
//                String Slecteditem= itemname[+position];
//                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();
                if(position == 0)
                {
                    Intent init = new Intent(TopPickUpsActivity.this,detaildesc.class);
                    startActivity(init);
                }
                else if(position == 1)
                {
                    Intent init = new Intent(TopPickUpsActivity.this,BookActivity.class);
                    startActivity(init);
                }

                else if(position == 2)
                {
                    Intent init = new Intent(TopPickUpsActivity.this,BikeActivity.class);
                    startActivity(init);
                }

                else if(position == 3)
                {

                    Intent init = new Intent(TopPickUpsActivity.this,ChairActivity.class);
                    startActivity(init);
                }

            }
        });
    }


}
