package com.example.portfolioapp.CV;

public class CVItem
{
    private String title;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CVItem() {
    }

    public CVItem(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
