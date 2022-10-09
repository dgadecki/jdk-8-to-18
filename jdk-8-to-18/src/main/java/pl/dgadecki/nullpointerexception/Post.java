package pl.dgadecki.nullpointerexception;

public class Post {

    private String postCode;
    private String city;
    private String country;

    public Post (String postCode, String city, String country) {
        this.postCode = postCode;
        this.city = city;
        this.country = null;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
