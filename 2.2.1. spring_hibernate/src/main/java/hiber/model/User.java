package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "first_name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "car_id")
   private Car carId;

   public User() {}
   
   public User(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
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

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public Car getCarId() {
      return carId;
   }

   public void setCarId(Car carId) {
      this.carId = carId;
   }

   @Override
   public String toString() {
      final StringBuilder sb = new StringBuilder("User - ");
      sb.append("id: ").append(id);
      sb.append(", firstName: ").append(firstName);
      sb.append(", lastName: ").append(lastName);
      sb.append(", email: ").append(email).append("\n");
      return sb.toString();
   }
}
