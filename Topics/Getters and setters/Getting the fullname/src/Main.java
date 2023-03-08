class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        // write your code here
        this.firstName = !firstName.equals("") ? firstName : "";
    }

    public void setLastName(String lastName) {
        // write your code here
        this.lastName = (lastName != null && !lastName.equals("")) ? lastName : "";
    }

    public String getFullName() {
        return firstName.length() + lastName.length() == 0 ? "Unknown"
                : firstName.length() == 0 ? lastName
                : lastName.length() == 0 ? firstName
                : firstName + " " + lastName; // write your code here
    }

}

