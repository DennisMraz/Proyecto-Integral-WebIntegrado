package com.proyecto.integral.model.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cli_id")
    private Long id;
    @Column(name = "cli_nombres")
    private String nombres;
    @Column(name = "cli_apellidos")
    private String apellidos;
    @Column(name = "cli_correo")
    private String correo;
    @Column(name = "cli_fecha_registro")
    @Temporal(TemporalType.DATE) // Tipo de atributo (Tiempo)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaRegistro;


    @PrePersist // Antes que guarde, se ejecuta este método
    // Coloca la fecha del servidor
    public void colocarFecha() {
        // createdAt=new Date(); //Coloca la fecha del servidor

        if (fechaRegistro == null) {
            fechaRegistro = new Date();
        }
    }

    //Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public Date getFechaRegistro() {
        return fechaRegistro;
    }
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    
}
