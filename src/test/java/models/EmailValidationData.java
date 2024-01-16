package models;

public class EmailValidationData {

private String name;
private String email;
private String textArea;

    public EmailValidationData(String name, String email, String textArea) {
        this.name = name;
        this.email = email;
        this.textArea = textArea;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTextArea(String textArea) {
        this.textArea = textArea;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getTextArea() {
        return textArea;
    }
}
