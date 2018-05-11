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

    private int id;
    private String mTitle;
    private String mContent;

    //

    public Note(String title, String content) {
        mTitle = title;
        mContent = content;
    }
}
