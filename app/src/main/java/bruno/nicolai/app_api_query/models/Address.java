package bruno.nicolai.app_api_query.models;

public class Address {

    private String street, suite, city, zipcode;

    private Geo geo;


    public Address(String street, String suite, String city, String zip, Geo geo) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zip;
        this.geo = geo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

}