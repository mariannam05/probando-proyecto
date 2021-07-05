/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

/**
 *
 * @author Sabrina Correia
 */
public class Investigacion {
    private String summary;
    private String authors;     
    private String keywords;
    private String title;

    public Investigacion(String summary, String authors, String keywords) {
        this.summary = summary;
        this.authors = authors;
        this.keywords = keywords;
    }
    
    public Investigacion(){
        
    }
    
    public String toString(){
        return ("\nTitle: "+ this.title +"\nsummary: "+ this.summary + "\nauthors: "+ this.authors + "\nkeywords: "+this.keywords+"\n");
    }

    /**
     * @return the summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     * @param summary the summary to set
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * @return the authors
     */
    public String getAuthors() {
        return authors;
    }

    /**
     * @param authors the authors to set
     */
    public void setAuthors(String authors) {
        this.authors = authors;
    }

    /**
     * @return the keywords
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * @param keywords the keywords to set
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
}
