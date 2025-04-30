package org.example;

import java.util.Objects;

public class OnlineDealer extends Dealership {
    private String website;
    private String returnPolicy;
    private double rating;

    public OnlineDealer() {
        this.website = "Unknown";
        this.returnPolicy = "Unknown";
        this.rating = 0;
    }

    public OnlineDealer(String website, String returnPolicy, double rating) {
        this.website = website;
        this.returnPolicy = returnPolicy;
        this.rating = rating;
    }

    public OnlineDealer(String name, int phoneNumber, int inventory, String website, String returnPolicy, double rating) {
        super(name, phoneNumber, inventory);
        this.website = website;
        this.returnPolicy = returnPolicy;
        this.rating = rating;
    }

    @Override
    public int compare(Dealership o1, Dealership o2) {}

    public static String getRatingCategory() {}

    @Override
    public String toString() {
        return "Online Dealer\n" +
                "Website: " + website + "\n" +
                "Return Policy: " + returnPolicy + "\n" +
                "Rating: " + rating + "\n" +
                super.toString().replace("Dealership", "");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OnlineDealer that = (OnlineDealer) o;
        return Double.compare(rating, that.rating) == 0 && Objects.equals(website, that.website) && Objects.equals(returnPolicy, that.returnPolicy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), website, returnPolicy, rating);
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getReturnPolicy() {
        return returnPolicy;
    }

    public void setReturnPolicy(String returnPolicy) {
        this.returnPolicy = returnPolicy;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
