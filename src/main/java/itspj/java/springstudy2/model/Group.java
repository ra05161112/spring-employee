package itspj.java.springstudy2.model;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "GROUPS")
public class Group {
  
  @Id
  private int id;

  /**グループ名 */
  private String name;

  /**表示順 */
  private int display;

  @ManyToMany
  @JoinColumn(insertable = false, updatable = false,name = "employeeId")
  private List<Employee> employees;
}
