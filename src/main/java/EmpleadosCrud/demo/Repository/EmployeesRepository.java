/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EmpleadosCrud.demo.Repository;

import EmpleadosCrud.demo.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author marti
 */
//Estas interfaces son implementadas en los servicios , en este caso quiero que me implemente los de crudRepository mas no 
public interface EmployeesRepository extends CrudRepository<Employee, Long> {

}
