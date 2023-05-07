/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EmpleadosCrud.demo.Rest;

import EmpleadosCrud.demo.Model.Employee;
import EmpleadosCrud.demo.Services.EmployeeService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author martin
 */
@Slf4j // para usar el log
@RestController
@RequestMapping("/empleados/")
public class EmployeeRest {

    @Autowired
    EmployeeService Ems;

    @GetMapping()
    //metodo get es porque voy a retornar algo
    private ResponseEntity<List<Employee>> getAllEmployees() {

        return ResponseEntity.ok(Ems.findAll());
    }

    @GetMapping("/getAll")
    //metodo get es porque voy a retornar algo
    private ResponseEntity<List<String>> getAllName() {

        return ResponseEntity.ok(Ems.findNamel());
    }
// metodo con java funcional utilizando Map
//        @GetMapping("/getAll")
//    //metodo get es porque voy a retornar algo
//    private ResponseEntity<List<String>> getAllName() {
//        List<String> lista;
//       
//        return ResponseEntity.ok(lista =Ems.findAll().stream()
//        .map(p ->p.getNombre())
//        .collect(Collectors.toList()));
//    }

    @PostMapping
    //este es como un metodo para crear nuevo empleado, RequestBody es para que siempre que alguien de un post obligatoriamente debe mandar una persona
    private ResponseEntity<Employee> SaveEmployee(@RequestBody Employee employee) {
        Employee newEmployee = Ems.save(employee);
        try {
            //aqui es para mandarle la persona guardada como respuesta
            return ResponseEntity.created(new URI("/empleados/" + newEmployee.getCodigo())).body(newEmployee);
        } catch (URISyntaxException ex) {
            //aca por si hay algun error
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    //eliminar
    @DeleteMapping("delete/{id}")
    private ResponseEntity<Boolean> DeleteEmployee(@PathVariable(name = "id") long id) {

        //optional es un tipo de variable que puede tener un valor o puede ser nullo
        Optional<Employee> employeeFind = Ems.findById(id);
        if (employeeFind.isPresent()) {
            //Realizamos el Delete
            Ems.deleteById(id);
            return ResponseEntity.ok(true);
        } else {

            return ResponseEntity.ok(false);

        }

    }

    //actualizar empleado
    @PutMapping("update/{id}")
    public ResponseEntity<Employee> updatePost(@RequestBody Employee employe, @PathVariable(name = "id") long id) {
        Optional<Employee> employee = Ems.findById(id);
        Employee e = employee.get();
        if (employee.isPresent()) {
            //Realizamo el update
            //ahoraa actualizo llos datos y le paso como parametro los que estan como parametro
            //primero obtengo el objeto

            e.setNombre(employe.getNombre());
            e.setApellido(employe.getApellido());
            e.setTelefono(employe.getTelefono());
            e.setCargo(employe.getCargo());
            //ahora guardo el objeto
            Employee employees = Ems.save(e);
            return ResponseEntity.ok(employees);
        } else {
            return ResponseEntity.ok(e);

        }

    }

    @GetMapping("find/{id}")
    //metodo get es porque voy a retornar algo
    private ResponseEntity<Employee> getEmployee(Employee employe, @PathVariable(name = "id") long id) {
        Optional<Employee> employee = Ems.findById(id);
        Employee e = employee.get();
        if (employee.isPresent()) {
            // empleado registrado en bd
            return ResponseEntity.ok(e);
        } else {
            return ResponseEntity.ok(e);

        }

    }
}
