package com.example.oaeeventcms;

import javax.persistence.Embeddable;

@Embeddable
public class Theme {

    private String templateTheme;
    private String primaryColor;
    private String accentColor;

    public Theme(String templateTheme, String primaryColor, String accentColor) {
        this.templateTheme = templateTheme;
        this.primaryColor = primaryColor;
        this.accentColor = accentColor;
    }

    public Theme() {

    }

    public String getTemplateTheme() {
        return templateTheme;
    }

    public String getPrimaryColor() {
        return primaryColor;
    }

    public String getAccentColor() {
        return accentColor;
    }

    public void setTemplateTheme(String templateTheme) {
        this.templateTheme = templateTheme;
    }

    public void setPrimaryColor(String primaryColor) {
        this.primaryColor = primaryColor;
    }

    public void setAccentColor(String accentColor) {
        this.accentColor = accentColor;
    }
}
