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
    @Column(nullable = false)
    private String subtitleColor;

    public Theme(String templateTheme, String primaryColor, String accentColor, String subtitleColor) {
        this.templateTheme = templateTheme;
        this.primaryColor = primaryColor;
        this.accentColor = accentColor;
        this.subtitleColor = subtitleColor;
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

    public String getSubtitleColor() {
        return subtitleColor;
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

    public void setSubtitleColor(String subtitleColor) {
        this.subtitleColor = subtitleColor;
    }
}
