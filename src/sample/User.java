package sample;

public abstract class User
{
    abstract void setFirstName(String firstName);
    abstract void setLastName(String lastName);
    abstract void setEmail(String email);
    abstract void setPhone(String phone);
    abstract void setUsername(String username);
    abstract void setPassword(String password);
    abstract void setAddress(String address);
    abstract void setCity(String city);
    abstract void setCountry(String country);

    abstract void getFirstname();
    abstract void getLastName();
    abstract void getEmail();
    abstract void getPhone();
    abstract void getUsername();
    abstract void getPassword();
    abstract void getAddress();
    abstract void getCity();
    abstract void getCountry();
}
