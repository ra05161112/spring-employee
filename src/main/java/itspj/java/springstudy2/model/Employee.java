package itspj.java.springstudy2.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "EMPLOYEES")
public class Employee {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  /**従業員名 Max100*/
  private String name;

  /** ふりがな　　Max100*/
  private String furigana;

  /**ログインID　Max100 */
  private String loginId;

  /** パスワード　Max255*/
  private String password;

  /**Email　Max255 */
  private String email;

  /**グループ名　多対多　Null可 */
  @ManyToMany
  @JoinColumn(insertable = false, updatable = false,name = "groupId")
  private List<Group> groups;

  /**管理者フラグ */
  private boolean frg;

}
