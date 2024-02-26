package com.spendwise.dto;

public class UserDTO {
    private Long user_id;
    private String name;
    private String email;
    
    
    public UserDTO() {
    }

    public UserDTO(Long user_id, String name, String email) {
        this.user_id = user_id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
      return user_id;
    }
    public void setId(Long user_id) {
      this.user_id = user_id;
    }

    public String getName() {
      return name;
    }
    public void setName(String name) {
      this.name = name;
    }

    public String getEmail() {
      return email;
    }
    public void setEmail(String email) {
      this.email = email;
    }
}
