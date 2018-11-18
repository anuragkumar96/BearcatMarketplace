package Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;

import java.util.ArrayList;
import java.util.List;

import Model.Order;

public class Database extends SQLiteOpenHelper {

    private static final String DB_Name="BearCAT.db";
    private static final int DB_Version=1;


    public Database(Context context) {

         super(context, DB_Name, null, DB_Version);
    }

    public List<Order> getCarts(){

        SQLiteDatabase db=getReadableDatabase();
        SQLiteQueryBuilder qb=new SQLiteQueryBuilder();

        String [] sqlselect={"ProductName","ProductID","Price"};
        String sqlTable="OrderDetails";
        qb.setTables(sqlTable);
        Cursor c =qb.query(db,sqlselect,null,null,null,null,null);
        final List<Order> result=new ArrayList<>();
        if(c.moveToFirst())
        {
            do{
                result.add(new Order(c.getString(c.getColumnIndex("ProductID")),

                        c.getString(c.getColumnIndex("ProductName")),

                        c.getString(c.getColumnIndex("Price"))
                        ));


            }while (c.moveToNext());
        }
return result;
    }

    public void addToCart(Order order){

SQLiteDatabase db=getReadableDatabase();
String query=String.format("INSERT INTO OrderDetail(ProductID,ProductName,Price) VALUES('%s','%s','%s');",
                      order.getProductID(),order.getProductName(),order.getPrice());

             db.execSQL(query);

    }


    public void cleanCart(){

        SQLiteDatabase db=getReadableDatabase();
        String query=String.format("DELETE FROM OrderDetail");

        db.execSQL(query);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
