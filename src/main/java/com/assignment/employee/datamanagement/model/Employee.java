package com.assignment.employee.datamanagement.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "EMPLOYEE")
@ApiModel(description="All details about the Employee. ")
@Validated
public class Employee {
	@JsonProperty("id")
	private Long id = null;
	@JsonProperty("firstName")
	private String firstName = null;
	@JsonProperty("lastName")
	private String lastName = null;

	public Employee() {
	}

	public Employee id(Long id) {
		this.id = id;
		return this;
	}

	@ApiModelProperty("")
	@Id
	@Column(name = "id")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Employee firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	@ApiModelProperty("Employee First Name")
	@Column(name = "firstName", nullable = false)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Employee lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	@ApiModelProperty("Employee Last Name")
	@Column(name = "lastName", nullable = false)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass() == o.getClass()) {
			Employee employee = (Employee)o;
			return Objects.equals(this.id, employee.id) && Objects.equals(this.firstName, employee.firstName) && Objects.equals(this.lastName, employee.lastName);
		} else {
			return false;
		}
	}

	public int hashCode() {
		return Objects.hash(new Object[]{this.id, this.firstName, this.lastName});
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Employee {\n");
		sb.append("    id: ").append(this.toIndentedString(this.id)).append("\n");
		sb.append("    firstName: ").append(this.toIndentedString(this.firstName)).append("\n");
		sb.append("    lastName: ").append(this.toIndentedString(this.lastName)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	private String toIndentedString(Object o) {
		return o == null ? "null" : o.toString().replace("\n", "\n    ");
	}
}


