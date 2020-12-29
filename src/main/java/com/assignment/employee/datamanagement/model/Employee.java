package com.assignment.employee.datamanagement.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * Employee
 */

@Entity
@Table(name = "EMPLOYEE")
@ApiModel(description="All details about the Employee. ")
@Validated
public class Employee   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  public Employee id(Long id,String firstName,String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  @Id
  @Column(name = "id")

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Employee firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Employee First Name
   * @return firstName
  **/
  @ApiModelProperty(value = "Employee First Name")
  @Column(name = "firstName", nullable = false)

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Employee lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Employee Last Name
   * @return lastName
  **/
  @ApiModelProperty(value = "Employee Last Name")
  @Column(name = "lastName", nullable = false)

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Employee employee = (Employee) o;
    return Objects.equals(this.id, employee.id) &&
        Objects.equals(this.firstName, employee.firstName) &&
        Objects.equals(this.lastName, employee.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Employee {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

