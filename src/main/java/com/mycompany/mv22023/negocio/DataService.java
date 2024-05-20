 
package com.mycompany.mv22023.negocio;

import com.mycompany.mv22023.entidad.Alumno;
import jakarta.ejb.Stateless;
import jakarta.persistence.CascadeType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;

  @Stateless
public class DataService {
     
      @PersistenceContext( unitName = "pu")
      EntityManager entityManager;
  
        public List<Alumno> getAlumnos(){
           Query query = entityManager.createQuery("SELECT e FROM Alumno e ORDER BY e.id ASC"); 
          List<Alumno> alumnos = query.getResultList();
            return alumnos;
        }
        @Transactional
        public void saveAlumno(Alumno alumno){
             entityManager.persist(alumno);
       
        }
        
       @Transactional
       public Void editAliumno(Alumno alumno){
              entityManager.merge(alumno); 
          return null;
        }     
       
    @Transactional
    public void deleteAlumno(Alumno alumno){
       Alumno alumnoEliminar = entityManager.find(Alumno.class,alumno.getId());
    }

    public void editAlumno(Alumno alumno) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Alumno> gerAlumnos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 }