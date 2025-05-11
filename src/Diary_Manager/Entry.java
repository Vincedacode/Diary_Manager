package Diary_Manager;

import java.io.Serializable;
import java.time.LocalDate;

public class Entry implements Serializable {
    protected LocalDate date;
    protected String title;
    protected String content;

    public Entry(LocalDate date, String title, String content) {
        if (title == null || title.isEmpty())
            throw new IllegalArgumentException("Title cannot be empty!");
        if (content == null || content.isEmpty())
            throw new IllegalArgumentException("Content cannot be empty!");

        this.date = date;
        this.title = title;
        this.content = content;
    }





    public LocalDate getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return
                "[" + date + "]" +
                title + '\n' +
                  content + '\n'
                ;
    }
}
