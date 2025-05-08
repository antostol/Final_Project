package org.example;

import java.util.List;
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

    public OnlineDealer(String name, int phoneNumber, List<Car> inventory, String website, String returnPolicy, double rating) {
        super(name, phoneNumber, inventory);
        this.website = website;
        this.returnPolicy = returnPolicy;
        this.rating = rating;
    }

    /**
     * Compares online dealer o1 to online dealer o2 based off their rating
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return 0 if their rating is equal
     *         -1 if the rating of the first dealership is lower than the second
     *         1 if the rating of the first dealership is high than the second
     */
    @Override
    public int compare(Dealership o1, Dealership o2) {
        try {
            OnlineDealer d1 = (OnlineDealer) o1;
            OnlineDealer d2 = (OnlineDealer) o2;

            return Double.compare(d1.getRating(), d2.getRating());
        } catch (ClassCastException e) {
            System.out.println("Error: Both dealerships must be online dealers in order to be compared");
            return 0;
        }
    }

    /**
     * Rates online dealerships based off their rating
     * @return Great if online dealer rating is higher than 4
     *         Average if online dealer rating is between 3 and 4
     *         Terrible if online dealer rating is lower than 3
     */
    public String getRatingCategory() {
        if (this.getRating() < 0 || this.getRating() > 5) {
            return "Invalid rating";
        }

        if (this.getRating() > 4) {
            return "Great";
        } else if (this.getRating() > 3 && this.getRating() <= 4) {
            return "Average";
        }
        return "Low";
    }

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
