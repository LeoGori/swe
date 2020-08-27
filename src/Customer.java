public class Customer {

    private String username;
    private String password;

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Customer){
            Customer customer = (Customer) obj;
            if(customer != null && this.username.equals(customer.username) && this.password.equals(customer.password)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return username;
    }

    public int hashCode()
    {
        String key = username+password;
        int hash = (int)key.charAt(0);
        return hash;
    }

    public Customer(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}