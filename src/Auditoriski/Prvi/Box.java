package Auditoriski.Prvi;

public class Box<T> {
    private T content;
    private String description;

    public Box(){

    }

    public Box(T content, String description) {
        this.content = content;
        this.description = description;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return content + " " + description;
    }
}
