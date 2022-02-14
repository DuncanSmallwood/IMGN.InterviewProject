package IMGN.InterviewProject.Repositories.Entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
public class Company {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private String telephone_number;
    private String street_address;

    public Company(){}

    public Company(String name, String telephone_number, String street_address){
        this.name = name;
        this.telephone_number = telephone_number;
        this.street_address = street_address;
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getTelephoneNumber(){
        return telephone_number;
    }

    public String getStreetAddress(){
        return street_address;
    }

    public void setName(String newName){
        name = newName;
    }

    public void setTelephoneNumber(String newTelephoneNumber){
        telephone_number = newTelephoneNumber;
    }

    public void setStreetAddress(String newStreetAddress){
        street_address = newStreetAddress;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if(!(o instanceof Company))
            return false;
        Company other = (Company) o;
        return Objects.equals(this.id, other.id)
                && Objects.equals(this.name, other.name)
                && Objects.equals(this.telephone_number, other.telephone_number)
                && Objects.equals(this.street_address, other.street_address);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.name, this.telephone_number, this.street_address);
    }

    @Override
    public String toString(){
        return "Employee{id="+this.id+", name='"+this.id+"', telephone_number='"+this.telephone_number+"', street_address='"+this.street_address+"'}";
    }
}
