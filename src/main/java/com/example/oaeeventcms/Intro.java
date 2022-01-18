package com.example.oaeeventcms;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Intro {

    @Column(nullable = false)
    private String heading;
    @Column(length = 2000, nullable = false)
    private String content;
    @Column(length = 1000)
    private String quote;
    @Column(length = 1000)
    private String quoteCaption;

    public Intro(String heading, String content, String quote, String quoteCaption) {
        this.heading = heading;
        this.content = content;
        this.quote = quote;
        this.quoteCaption = quoteCaption;
    }

    public Intro() {

    }

    public String getHeading() {
        return heading;
    }

    public String getContent() {
        return content;
    }

    public String getQuote() {
        return quote;
    }

    public String getQuoteCaption() {
        return quoteCaption;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public void setQuoteCaption(String quoteCaption) {
        this.quoteCaption = quoteCaption;
    }
}
