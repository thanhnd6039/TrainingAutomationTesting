package cucumber.test_data_types;

public class Customer {

    public String firstName;
    public String lastName;
    public String companyName;
    public int age;
    public String emailAddress;
    public Address address;
    public PhoneNumber phoneNumber;

    public class Address {
        public String streetAddress;
        public String city;
        public String postCode;
        public String state;
        public String country;
        public String county;
    }

    public class PhoneNumber {
        public String home;
        public String mob;
    }
}
