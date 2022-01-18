package com.example.oaeeventcms;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Theme {

    @Column(nullable = false)
    private String templateTheme;
    @Column(nullable = false)
    private String primaryColor;
    @Column(nullable = false)
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
