package com.example.gestion_users.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name="Role")
//constructeurs generés par lombok
//Getter and setter generés par lombok
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Role implements Serializable {
    @Id
    @Column(name = "idR")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idR;


    private String nomR;

    public Role(String nomR) {
        this.nomR = nomR;
    }




    @Override
    public String toString() {
        return this.nomR;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idR == null) ? 0 : idR.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Role other = (Role) obj;
        if (idR == null) {
            if (other.idR != null)
                return false;
        } else if (!idR.equals(other.idR))
            return false;
        return true;
    }
}
