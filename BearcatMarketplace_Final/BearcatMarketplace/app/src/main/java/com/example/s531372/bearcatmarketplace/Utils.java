package com.example.s531372.bearcatmarketplace;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import java.util.ArrayList;
import java.util.HashMap;

import Model.Order;

public class Utils {
    public static HashMap<String,ArrayList<Order>> globalData=new HashMap<>();
    public static ArrayList<Order> cartList=new ArrayList<>();
    public static final String BIKES="Bikes";
    public static final String CARS="Cars";
    public static final String BOOKS_AND_ACCESSORIES="BooksAndAccessories";
    public static final String ROOMS="Rooms";
    public static final String HOUSE_HOLD="HouseHold";

    public static HashMap<String,ArrayList<Order>> prepareAndData()
    {
        globalData.put(BIKES,getBikes());
        globalData.put(CARS,getCars());
        globalData.put(BOOKS_AND_ACCESSORIES,getBooksAndAccessories());
        globalData.put(ROOMS,getRooms());
        globalData.put(HOUSE_HOLD,getHouseHold());
        return globalData;

    }

    public static ArrayList<Order> getAllData()
    {
        prepareAndData();
        ArrayList<Order> mList=new ArrayList<>();
        mList.addAll(globalData.get(BIKES));
        mList.addAll(globalData.get(CARS));
        mList.addAll(globalData.get(BOOKS_AND_ACCESSORIES));
        mList.addAll(globalData.get(ROOMS));
        mList.addAll(globalData.get(HOUSE_HOLD));

        return mList;
    }

    public static ArrayList<Order> getSelectedItemsData(boolean[] selectedAray)
    {
        prepareAndData();
        ArrayList<Order> mList=new ArrayList<>();
        if (selectedAray[0])
        mList.addAll(globalData.get(BIKES));
        if (selectedAray[1])
        mList.addAll(globalData.get(CARS));
        if (selectedAray[2])
        mList.addAll(globalData.get(BOOKS_AND_ACCESSORIES));
        if (selectedAray[3])
        mList.addAll(globalData.get(ROOMS));
        if (selectedAray[4])
        mList.addAll(globalData.get(HOUSE_HOLD));

        return mList;
    }
    public static ArrayList<Order> getBikes()
    {
        ArrayList<Order> mList=new ArrayList<>();
        Order order1=new Order("1","Hero","100",R.drawable.cycle2,BIKES,
                "This product is in Good condition with decent price");
        Order order2=new Order("2","Hero1","90",R.drawable.cycle3,BIKES,"This product is in Good condition with decent price");
        Order order3=new Order("3","Cycle","90",R.drawable.cycleses,BIKES,"This product is in Good condition with decent price");
        Order order4=new Order("4","Cycle1","90",R.drawable.erjg,BIKES,"This product is in Good condition with decent price");


        mList.add(order1);
        mList.add(order2);
        mList.add(order3);
        mList.add(order4);
        return mList;
    }
    public static ArrayList<Order> getCars()
    {
        ArrayList<Order> mList=new ArrayList<>();
        Order order1=new Order("1","Hundai","2200",R.drawable.hundai1,CARS,
                "This is Used car but in very Good condition and all documents available");
        Order order2=new Order("2","TATA","3000",R.drawable.tata,CARS,
                "This is Used car but in very Good condition and all documents available");
        mList.add(order1);
        mList.add(order2);
        return mList;
    }
    public static ArrayList<Order> getBooksAndAccessories()
    {
        ArrayList<Order> mList=new ArrayList<>();
        Order order1=new Order("1","java2","100",R.drawable.java2,BOOKS_AND_ACCESSORIES,
                "This is Java2 book and perfect for java lovers");
        Order order2=new Order("2","java","90",R.drawable.javabook,BOOKS_AND_ACCESSORIES,
                "This has complete Java, limited quantity available");
        Order order3=new Order("3","Drug Lord","120",R.drawable.kjik,BOOKS_AND_ACCESSORIES,
                "YEs1...it's Doug Casey and John Hunt's DRUG LORD hurryup...");
        Order order4=new Order("4","Drug Lord","120",R.drawable.book1,BOOKS_AND_ACCESSORIES,
                "Best book for iOS developers");
        mList.add(order1);
        mList.add(order2);
        mList.add(order3);
        mList.add(order4);
        return mList;
    }
    public static ArrayList<Order> getRooms()
    {
        ArrayList<Order> mList=new ArrayList<>();
        Order order1=new Order("1","room","100",R.drawable.room,ROOMS,
                "Beautiful house with furniture");
        mList.add(order1);

        return mList;
    }
    public static ArrayList<Order> getHouseHold()
    {
        ArrayList<Order> mList=new ArrayList<>();
        Order order1=new Order("1","armchair","100",R.drawable.armchair,HOUSE_HOLD,
                "This is wooden study table. This is in perfect condition.");
        Order order2=new Order("2","chair","90",R.drawable.chair1,HOUSE_HOLD,"This is wooden study table. This is in perfect condition.");
        Order order3=new Order("3","chairnew","120",R.drawable.download,HOUSE_HOLD,"This is wooden study table. This is in perfect condition.");
        Order order4=new Order("4","Table","120",R.drawable.table2,HOUSE_HOLD,"This is wooden study table. This is in perfect condition.");
        Order order5=new Order("5","Dining Table","120",R.drawable.table3,HOUSE_HOLD,"This is wooden study table. This is in perfect condition.");

        mList.add(order1);
        mList.add(order2);
        mList.add(order3);
        mList.add(order4);
        mList.add(order5);
        return mList;
    }
    static void setAlert(String message, Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(message).setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.setTitle("Warning..!");
        alert.show();
    }
}
