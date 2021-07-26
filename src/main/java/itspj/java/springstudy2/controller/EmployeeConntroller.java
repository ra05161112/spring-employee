package itspj.java.springstudy2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import itspj.java.springstudy2.model.Employee;
import itspj.java.springstudy2.model.EmployeeRepository;
import itspj.java.springstudy2.model.GroupRepository;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class EmployeeConntroller {
  
  
  private final EmployeeRepository eRep;  
  private final GroupRepository gRep;

  /**ログイン画面表示 */
  @GetMapping("/")
  public String getLogin(){
    return "employee/login";
  }

  /**従業員リスト表示 */
  @GetMapping("/index")
  public String index(Model model) {
    model.addAttribute("employee", eRep.findAll());
    return "employee/index";
  }

  /**詳細表示 編集 */
  @GetMapping("/{id}/show")
  public String show(@PathVariable int id, Model model) {
    model.addAttribute("employeelist", eRep.findById(id));
    return "employee/show";
  }

  /**ユーザー情報更新 */
  @PostMapping("/{id}/show")
  public String edit(@Validated @ModelAttribute Employee employee, BindingResult result, @PathVariable int id,Model model) {
    if(result.hasErrors()){
      model.addAttribute("empId", id);
      return "employee/show";
    }
    employee.setId(id);
    eRep.save(employee);
    return "redirect:/index";
  }
}
