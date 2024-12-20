package com.app.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "projects")
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "emps")
//added new , to be tested yet !
//@EqualsAndHashCode(callSuper = false, doNotUseGetters = true,of = "title")
public class Project extends BaseEntity {
	@Column(unique = true)
	private String title;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "start_date")
	private LocalDate startDate;
	@Column(name = "end_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate endDate;
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ProjectStatus status;
	// many-many , bi dir association between entities Project *<----->* Employee
	// Project : owning(=> the side which defines the link table) , parent , many
	@ManyToMany(cascade = CascadeType.PERSIST) // @ManyToMany : mandatory o.w Mapping Exception
	@JoinTable(name = "project_emps", 
	joinColumns = @JoinColumn(name = "project_id"), 
	inverseJoinColumns = @JoinColumn(name = "emp_id"))
	private Set<Employee> emps = new HashSet<>();

	public Project(String title, LocalDate startDate, LocalDate endDate) {
		super();
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = ProjectStatus.LAUNCHED;
	}

	public Project(String title) {
		super();
		this.title = title;
	}

	// add helper methods
	public boolean addEmp(Employee e) {
		boolean addedEmp = emps.add(e);
		boolean addedProject = e.getProjects().add(this);
		return addedEmp && addedProject;
	}

	public boolean removeEmp(Employee e)

	{
		boolean removedEmp = emps.remove(e);
		boolean removedProject = e.getProjects().remove(this);
		return removedEmp && removedProject;
	}
}
