/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EmpleadosCrud.demo.Services;

import EmpleadosCrud.demo.Model.Employee;
import EmpleadosCrud.demo.Repository.EmployeesRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author marti
 */
//estos sevicios los inyecto en el Rest
@Service
public class EmployeeService implements EmployeesRepository {

    @Autowired
    EmployeesRepository Emr;

    @Override
    public <S extends Employee> S save(S entity) {
        return Emr.save(entity);
    }

    @Override
    public <S extends Employee> Iterable<S> saveAll(Iterable<S> entities) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Optional<Employee> findById(Long id) {
        return Emr.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public long count() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteById(Long id) {
        Emr.deleteById(id);
    }

    @Override
    public void delete(Employee entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteAll(Iterable<? extends Employee> entities) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Employee> findAll() {
        return (List<Employee>) Emr.findAll();
    }

    @Override
    public Iterable<Employee> findAllById(Iterable<Long> ids) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<String> findNamel() {
        List<String> lista = new ArrayList<>();
        List<Employee> lista2 = (List<Employee>) Emr.findAll();
        for (int i = 0; i < lista2.size(); i++) {
            lista.add(lista2.get(i).getNombre());
        }
        return lista;
    }

}
