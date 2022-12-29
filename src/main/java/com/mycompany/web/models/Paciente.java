package com.mycompany.web.models;

import java.io.Serializable;

public class Paciente implements Serializable {
        private int id;
        private String dni,nombre,apellido,edad,contacto;

        public Paciente(){
    
        }
    
        public int getId(){
            return id;
        }
    
        public void setId(int nuevoId){
            this.id = nuevoId;
        }
        
        public String getDni(){
            return dni;
        }

        public void setDni(String nuevoDni){
            this.dni = nuevoDni;
        }

        public String getNombre(){
            return nombre;
        }
    
        public void setNombre(String nuevoNombre){
            this.nombre = nuevoNombre;
        }
    
        public String getApellido(){
            return apellido;
        }
    
        public void setApellido(String nuevoApellido){
            this.apellido = nuevoApellido;
        }
    
        public String getEdad(){
            return edad;
        }
    
        public void setEdad(String nuevaEdad){
            this.edad = nuevaEdad;
        }
        
        public String getContacto(){
            return contacto;
        }
    
        public void setContacto(String nuevoContacto){
            this.contacto = nuevoContacto;
        }

        
    }

