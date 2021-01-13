package com.example.gestion_users.model;


import com.sun.istack.NotNull;
import jdk.Exported;
import lombok.*;


import javax.persistence.*;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="utilisateur")
//constructeurs generés par lombok
//Getter and setter generés par lombok
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class User implements Serializable {
    @Id
    @Column(name = "idU")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idU;

   @NotEmpty
    @Size(min=2, max=40)
    private String nom;

    @NotEmpty
    @Size(min=2, max=15)
    private String password;

    @NotEmpty
    @Email(message = "L'email doit être valide")
    private String email;

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinTable(
            name = "tab_NtoN",
            joinColumns = @JoinColumn(name = "idU"),
            inverseJoinColumns = @JoinColumn(name = "idR")
    )

    private Set<Role> roles = new HashSet<>();

    public long getIdU() {
        return idU;
    }

    public void setIdU(long idU) {
        this.idU = idU;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public User(String nom, String password) {
        this.nom = nom;
        this.password = password;

    }
}
