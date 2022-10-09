package pl.dgadecki.nullpointerexception;

public class Address {

    private String city;
    private String street;
    private Post post;

    public Address(String city, String street, Post post) {
        this.city = city;
        this.street = street;
        this.post = post;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public Post getPost() {
        return post;
    }
}
