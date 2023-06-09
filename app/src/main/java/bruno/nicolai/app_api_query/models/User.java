package bruno.nicolai.app_api_query.models;

import java.util.Comparator;

public class User {

    public enum SortOrder {
        DEFAULT,
        ASCENDING,
        DESCENDING
    }

    private static SortOrder currentSortOrder = SortOrder.DEFAULT;;

    public static SortOrder getSortOrder() {
        return currentSortOrder;
    }

    public static void setSortOrder(SortOrder sortOrder) {
        currentSortOrder = sortOrder;
    }

    private int id;
    private String name, userName, email, phone, website;

    private Address address;
    private Company company;

    public User(int id, String name, String userName, String email, String phone, String website) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.website = website;
    }

    public User(int id, String name, String userName, String email, String phone, String website, Address address, Company company) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.website = website;
        this.address = address;
        this.company = company;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + this.name + '\'' +
                ", id=" + this.id +
                ", email='" + this.email + '\'' +
                '}';
    }

    public static class UserNameComparator implements Comparator<User> {
        @Override
        public int compare(User user1, User user2) {
            return user1.getName().compareToIgnoreCase(user2.getName());
        }
    }

}
