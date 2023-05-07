/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EmpleadosCrud.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author marti
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Estudiante")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    private String nombre;
    private String apellido;
    private String telefono;
    private String cargo;

    public Employee(String nombre, String apellido, String telefono,String cargo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.cargo =cargo;
    }

}
