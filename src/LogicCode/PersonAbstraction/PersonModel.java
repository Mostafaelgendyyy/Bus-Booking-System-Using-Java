package LogicCode.PersonAbstraction;

public abstract class PersonModel {
    private int Id;
    private String name;
    private String Email;
    private String password;
    private String username;

    public PersonModel() {
        this.name = "";
        this.Email = "";
        this.password = "";
        this.username="";
    }

    public PersonModel(int id, String n, String mail, String Pass, String username) {
        this.Id=id;
        this.name = n;
        this.Email = mail;
        this.password = Pass;
        this.username=username;
    }
    public PersonModel(String n, String mail,String Pass,String username) {
        this.name = n;
        this.Email = mail;
        this.password = Pass;
        this.username=username;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String GetPersonData() {
        return
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", Email='" + Email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' ;
    }
}
