package com.spendwise.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "auth")
public class Auth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auth_id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    public Auth(){
    }

    public Long getAuthId(){
      return auth_id;
    }

    public void setAuthId(Long auth_id){
      this.auth_id = auth_id;
    }

    public String getEmail(){
      return email;
    }

    public void setEmail(String email){
      this.email = email;
    }

    public String getPassword(){
      return password;
    }

    public void setPassword(String password){
      this.password = password;
    }
}
