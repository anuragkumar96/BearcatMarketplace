package com.example.s531372.bearcatmarketplace;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;

import java.util.ArrayList;

import Model.ListItem;

public class FilterActivity extends Activity {
    private ListView list_view;
    public static boolean[] selectedItems={false,false,false,false,false};
    private Button btn_submit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        list_view=(ListView)findViewById(R.id.list_view);
        btn_submit=(Button)findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i=0;i<selectedItems.length;i++)
                {
                    Log.i("team","selected item postion : "+i+ " "+ "value  : "+selectedItems[i]);
                }
                Intent intent=new Intent(FilterActivity.this,TopPickUpsActivity.class);
                intent.putExtra("from","Filter");
                startActivity(intent);


            }
        });
        FilterAdapter filterAdapter=new FilterAdapter(getPreparedData(),FilterActivity.this);
        list_view.setAdapter(filterAdapter);
        // When list view item is clicked.
        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int itemIndex, long l) {
                // Get user selected item.
                Object itemObject = adapterView.getAdapter().getItem(itemIndex);
                Log.i("team","onItemClick");

                // Translate the selected item to DTO object.
                ListItem itemDto = (ListItem) itemObject;

                // Get the checkbox.
                CheckBox itemCheckbox = (CheckBox) view.findViewById(R.id.check_box);

                // Reverse the checkbox and clicked item check state.
                if(itemDto.isChecked())
                {
                    Log.i("team","itemDto.isChecked flase");
                    itemCheckbox.setChecked(false);
                    itemDto.setChecked(false);
                    selectedItems[itemIndex]=false;
                }else
                {
                    Log.i("team","itemDto.isChecked true");

                    itemCheckbox.setChecked(true);
                    itemDto.setChecked(true);
                    selectedItems[itemIndex]=true;

                }

                //Toast.makeText(getApplicationContext(), "select item text : " + itemDto.getItemText(), Toast.LENGTH_SHORT).show();
            }
        });

    }
    private ArrayList<ListItem> getPreparedData()
    {
        ArrayList<ListItem> listItems=new ArrayList<>();

        ListItem listItem=new ListItem(Utils.BIKES,R.drawable.cart);
        ListItem listItem1=new ListItem(Utils.CARS,R.drawable.cart);
        ListItem listItem2=new ListItem(Utils.BOOKS_AND_ACCESSORIES,R.drawable.cart);
        ListItem listItem3=new ListItem(Utils.ROOMS,R.drawable.cart);
        ListItem listItem4=new ListItem(Utils.HOUSE_HOLD,R.drawable.cart);
        listItems.add(listItem);
        listItems.add(listItem1);
        listItems.add(listItem2);
        listItems.add(listItem3);
        listItems.add(listItem4);

        return  listItems;

    }

    class FilterAdapter extends BaseAdapter
    {
        ArrayList<ListItem> data;
        Context context;
        CheckBox check_box;
        FilterAdapter(ArrayList<ListItem> data, Context context)
        {
            this.data=data;
            this.context=context;
        }
        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = LayoutInflater.from(context).inflate(R.layout.filter_list_item,null);
            check_box=(CheckBox)view.findViewById(R.id.check_box);
            check_box.setText(data.get(position).getName());

            return view;
        }
    }
}
