package com.example.s531372.bearcatmarketplace;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import Model.User;


public class DataBaseUtils extends SQLiteOpenHelper {


	private static final int DATABASE_VERSION = 1;

	private static final String DATABASE_NAME = "bearcat_market";



	private static final String TABLE_NAME = "user";
	private static final String COLUMN_ID = "id";
	private static final String COLUMN_FIRST_NAME = "first_name";
	private static final String COLUMN_LAST_NAME = "last_name";
	private static final String COLUMN_PHONE_NUMBER = "phone_number";
	private static final String COLUMN_EMAIL = "email";
	private static final String COLUMN_PASSWORD = "password";
	String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_NAME + "("
			+ COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_FIRST_NAME + " TEXT,"
			+ COLUMN_LAST_NAME + " TEXT,"+ COLUMN_PHONE_NUMBER + " TEXT,"+ COLUMN_PASSWORD + " TEXT,"+ COLUMN_EMAIL + " TEXT" + ")";

	public DataBaseUtils(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		db.execSQL(CREATE_CONTACTS_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}


	long saveUser(User user) {
		long status=0;
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(COLUMN_FIRST_NAME, user.getFirstName());
		values.put(COLUMN_LAST_NAME, user.getLastName());
		values.put(COLUMN_PHONE_NUMBER, user.getPhone());
		values.put(COLUMN_EMAIL, user.getEmail());
		values.put(COLUMN_PASSWORD, user.getPassword());


		status=db.insert(TABLE_NAME, null, values);
		db.close();
		return status;
	}


	public String getUserPasswordDetails(String email) {
		String password="";
		String table = TABLE_NAME;
		String[] columns = {COLUMN_PASSWORD};
		String selection = "email =?";
		String[] selectionArgs = {email};
		String groupBy = null;
		String having = null;
		String orderBy = null;
		String limit = null;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy, limit);
		if (cursor!=null)
		{
			cursor.moveToFirst();
			password=cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD));
		}

		return password;
	}
	public boolean isUserPresent(String email) {
		String selectQuery = "SELECT  * FROM " + TABLE_NAME;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				if (email.equalsIgnoreCase(cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL))))
					return true;

			} while (cursor.moveToNext());
		}

		return false;
	}


	public int deleteEntry(int id) {
		int isDeleted=0;
		SQLiteDatabase db = this.getWritableDatabase();
		isDeleted=db.delete(TABLE_NAME, COLUMN_ID + " = ?",
				new String[] { String.valueOf(id) });
		db.close();
		return isDeleted;
	}

}
