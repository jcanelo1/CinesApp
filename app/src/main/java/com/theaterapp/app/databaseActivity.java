package com.theaterapp.app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class databaseActivity {

    public static class DatabaseHelper extends SQLiteOpenHelper {

        // User table
        private static final int USER_DATABASE_VERSION = 1;
        private static final String USER_DATABASE_NAME = "UserCredentials.db";
        private static final String USER_TABLE_NAME = "User";
        private static final String USER_COLUMN_FULLNAME = "fullname";
        private static final String USER_COLUMN_USERNAME = "username";
        private static final String USER_COLUMN_EMAIL = "email";
        private static final String USER_COLUMN_PASSWORD = "password";

        // Ticket table
        private static final int TICKET_DATABASE_VERSION = 1;
        private static final String TICKET_DATABASE_NAME = "TicketBooking.db";
        private static final String TICKET_TABLE_NAME = "Tickets";
        private static final String TICKET_COLUMN_NAME = "name";
        private static final String TICKET_COLUMN_EMAIL = "email";
        private static final String TICKET_COLUMN_QUANTITY = "quantity";
        private static final String TICKET_COLUMN_TITLE = "title";

        private Context context;

        public DatabaseHelper(Context context) {
            super(context, USER_DATABASE_NAME, null, USER_DATABASE_VERSION);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String userTableQuery = "CREATE TABLE " + USER_TABLE_NAME + " (" +
                    USER_COLUMN_FULLNAME + " TEXT," +
                    USER_COLUMN_USERNAME + " TEXT PRIMARY KEY," +
                    USER_COLUMN_EMAIL + " TEXT," +
                    USER_COLUMN_PASSWORD + " TEXT" +
                    ")";
            db.execSQL(userTableQuery);

            String ticketTableQuery = "CREATE TABLE " + TICKET_TABLE_NAME + " (" +
                    TICKET_COLUMN_NAME + " TEXT," +
                    TICKET_COLUMN_EMAIL + " TEXT," +
                    TICKET_COLUMN_QUANTITY + " INTEGER," +
                    TICKET_COLUMN_TITLE + " TEXT" +
                    ")";
            db.execSQL(ticketTableQuery);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + TICKET_TABLE_NAME);
            onCreate(db);
        }

        public boolean newUser(String fullname, String username, String email, String password) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(USER_COLUMN_FULLNAME, fullname);
            values.put(USER_COLUMN_USERNAME, username);
            values.put(USER_COLUMN_EMAIL, email);
            values.put(USER_COLUMN_PASSWORD, password);

            long result = db.insert(USER_TABLE_NAME, null, values);
            return result != -1;
        }

        public boolean inspectUser(String username, String password) {
            SQLiteDatabase db = this.getReadableDatabase();
            String[] columns = {USER_COLUMN_USERNAME};
            String selection = USER_COLUMN_USERNAME + "=? AND " + USER_COLUMN_PASSWORD + "=?";
            String[] selectionArgs = {username, password};
            Cursor cursor = db.query(USER_TABLE_NAME, columns, selection, selectionArgs, null, null, null);
            int count = cursor.getCount();
            cursor.close();
            return count > 0;
        }

        public void bookTicket(String name, String email, int quantity, String title) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(TICKET_COLUMN_NAME, name);
            values.put(TICKET_COLUMN_EMAIL, email);
            values.put(TICKET_COLUMN_QUANTITY, quantity);
            values.put(TICKET_COLUMN_TITLE, title);

            db.insert(TICKET_TABLE_NAME, null, values);
            db.close();
        }

        // Function used to save returning users
        public void saveUserInfo(String username, String password) {
            DatabaseHelper dbHelper = new DatabaseHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(USER_COLUMN_USERNAME, username);
            values.put(USER_COLUMN_PASSWORD, password);

            long newRowId = db.insert(USER_TABLE_NAME, null, values);

            if (newRowId == -1) {
                // Error occurred while inserting the data
                // Handle the error appropriately
            } else {
                // Data inserted successfully
                // Perform any necessary actions
            }

            db.close();
        }

    }

}

