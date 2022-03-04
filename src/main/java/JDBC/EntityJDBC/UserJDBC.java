package JDBC.EntityJDBC;

public class UserJDBC {
    private int idUser;
    private String firstName;
    private String lastName;

    public UserJDBC(){

    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserJDBC userJDBC = (UserJDBC) o;

        if (idUser != userJDBC.idUser) return false;
        if (!firstName.equals(userJDBC.firstName)) return false;
        return lastName.equals(userJDBC.lastName);
    }

    @Override
    public int hashCode() {
        int result = idUser;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserJDBC{" +
                "idUser=" + idUser +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
