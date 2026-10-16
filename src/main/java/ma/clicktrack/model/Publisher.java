package ma.clicktrack.model;

public class Publisher {
    private Long id;
    private String name;
    private String prenom;
    private String email;
    private Categorie categorie;
    public Publisher() {}

    public Publisher(Long id, String name, String prenom, String email, Categorie categorie){
        this.id = id;
        this.name = name;
        this.prenom = prenom;
        this.email = email;
        this.categorie = categorie;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

}
