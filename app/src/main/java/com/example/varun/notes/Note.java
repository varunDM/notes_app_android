package com.example.varun.notes;

/**
 * Created by varun on 10-05-2018.
 */

public class Note {

    public static final String TABLE_NAME = "notes";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_CONTENT = "content";
    public static final String COLUMN_TIMESTAMP = "timestamp";

    public int getId() {
        return id;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmContent() {
        return mContent;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    private int id;
    public String mTitle;
    public String mContent;
    private String timestamp;

    // Create Table Query
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_TITLE + " TEXT,"
            + COLUMN_CONTENT + " TEXT,"
            + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"
            + ")";

    public Note() {

    }

    public Note(int id, String title, String content, String timestamp) {
        this.mTitle = title;
        this.mContent = content;
        this.id = id;
        this.timestamp = timestamp;
    }

    public Note(String title, String content) {
        mTitle = title;
        mContent = content;
    }
}
