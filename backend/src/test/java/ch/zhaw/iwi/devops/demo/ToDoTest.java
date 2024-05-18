package ch.zhaw.iwi.devops.demo;

public class ToDoTest{
    private int id;
    private String title;
    private String description;

    public ToDoTest(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
