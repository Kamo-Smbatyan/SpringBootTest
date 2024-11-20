package test.smbatyan.smbatyan.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "statistics")
public class Statistics {

    @Id
    private String id; // MongoDB's unique identifier
    private String date; // Date of the statistic entry
    private String asin; // ASIN (Amazon Standard Identification Number)
    private double orderedProductSales; // Total product sales amount
    private int unitsOrdered; // Total units ordered
    private int pageViews; // Total page views
    private int sessions; // Total sessions
    private double buyBoxPercentage; // Percentage of time the product was in the Buy Box

    // Constructors
    public Statistics() {}

    public Statistics(String date, String asin, double orderedProductSales, int unitsOrdered, int pageViews, int sessions, double buyBoxPercentage) {
        this.date = date;
        this.asin = asin;
        this.orderedProductSales = orderedProductSales;
        this.unitsOrdered = unitsOrdered;
        this.pageViews = pageViews;
        this.sessions = sessions;
        this.buyBoxPercentage = buyBoxPercentage;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public double getOrderedProductSales() {
        return orderedProductSales;
    }

    public void setOrderedProductSales(double orderedProductSales) {
        this.orderedProductSales = orderedProductSales;
    }

    public int getUnitsOrdered() {
        return unitsOrdered;
    }

    public void setUnitsOrdered(int unitsOrdered) {
        this.unitsOrdered = unitsOrdered;
    }

    public int getPageViews() {
        return pageViews;
    }

    public void setPageViews(int pageViews) {
        this.pageViews = pageViews;
    }

    public int getSessions() {
        return sessions;
    }

    public void setSessions(int sessions) {
        this.sessions = sessions;
    }

    public double getBuyBoxPercentage() {
        return buyBoxPercentage;
    }

    public void setBuyBoxPercentage(double buyBoxPercentage) {
        this.buyBoxPercentage = buyBoxPercentage;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", asin='" + asin + '\'' +
                ", orderedProductSales=" + orderedProductSales +
                ", unitsOrdered=" + unitsOrdered +
                ", pageViews=" + pageViews +
                ", sessions=" + sessions +
                ", buyBoxPercentage=" + buyBoxPercentage +
                '}';
    }
}