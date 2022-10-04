package com.Howard.entity;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private @NonNull Long id;

   @Column(nullable = false)
   private @NonNull String firstName;
   
   @Column(nullable = false)
   private @NonNull String lastName;
   
   @Column(nullable = false,unique=true)
   private @NonNull String email;
   
   @Column(nullable = false)
   private @NonNull String password;

   @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   @JoinTable(
           name = "users_roles",
           joinColumns = @JoinColumn(
                   name = "user_id", referencedColumnName = "id"),
           inverseJoinColumns = @JoinColumn(
                   name = "role_id", referencedColumnName = "id"))
   private Collection<Role> roles;   
}