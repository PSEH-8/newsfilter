package org.sapient.hiring.microservice.newsfilter;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Article {	
	private String title;
	private String description;
	private String shortDescription;
	private String url;

	private final String BLANK_SPACE = " ";
	private final String ELLIPSIS = "...";
	private final int WORDS_LIMIT = 100;
	
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

   
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
    public String getShortDescription() {
    	if (null != description) {
    		shortDescription = Stream.of(this.description.split(BLANK_SPACE)).limit(WORDS_LIMIT).collect(Collectors.joining(BLANK_SPACE));
			if(shortDescription.length() < this.description.length()) {
				shortDescription.concat(ELLIPSIS);
			}
	    }
		return shortDescription;
	}
    
	@Override
    public String toString() {
        return "Article {" +
                "title='" + getTitle() + '\'' +
                "description='" + getDescription() + '\'' +
                "url='" + getUrl() + '\'' +
                ", shortDescription=" + getShortDescription() +
                '}';
    }
	
}
