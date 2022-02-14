package IMGN.InterviewProject.Repositories.Entities;

import java.util.Arrays;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Employee {
    @Id @GeneratedValue
    private Long id;
    @ManyToOne
    private Company company_id;
    private String name;
    private String mobile_number;
    private String email;
    @Lob
    private byte[] profile_picture_blob;

    public Employee(){}

    public Employee(Company company_id,
             String name,
             String mobile_Number,
             String email,
             byte[] profile_picture_blob){
        this.company_id = company_id;
        this.name = name;
        this.mobile_number = mobile_Number;
        this.email = email;
        this.profile_picture_blob = new byte[profile_picture_blob.length];
        System.arraycopy(profile_picture_blob, 0, this.profile_picture_blob, 0, profile_picture_blob.length);
    }

    public Long getId(){
        return id;
    }

    public Company getCompanyId(){
        return company_id;
    }

    public String getName(){
        return name;
    }

    public String getMobileNumber(){
        return mobile_number;
    }

    public String getEmail(){
        return email;
    }

    public byte[] getProfilePictureBlob(){
        return profile_picture_blob;
    }

    public void setCompanyId(Company newCompany){
        this.company_id = newCompany;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public void setMobileNumber(String newMobileNumber){
        this.mobile_number = newMobileNumber;
    }

    public void setEmail(String newEmail){
        this.email = newEmail;
    }

    public void setProfilePictureBlob(byte[] newProfilePictureBlob){
        this.profile_picture_blob = new byte[newProfilePictureBlob.length];
        System.arraycopy(newProfilePictureBlob, 0, this.profile_picture_blob, 0, newProfilePictureBlob.length);
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (!(o instanceof Employee))
            return false;
        Employee other = (Employee) o;
        return Objects.equals(this.id, other.id)
                && Objects.equals(this.company_id, other.company_id)
                && Objects.equals(this.name, other.name)
                && Objects.equals(this.mobile_number, other.mobile_number)
                && Objects.equals(this.email, other.email)
                && Arrays.equals(this.profile_picture_blob, other.profile_picture_blob);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.company_id.hashCode(), this.name, this.mobile_number, this.email, Arrays.hashCode(profile_picture_blob));
    }

    @Override
    public String toString(){
        return "Employee{id="+this.id+", company_id="+this.company_id.getId()+", name='"+this.name+"', mobile_numeber='"+this.mobile_number+"', email='"+this.email+"', profile_picture_blob='"+Arrays.toString(profile_picture_blob)+"'}";
    }
}
