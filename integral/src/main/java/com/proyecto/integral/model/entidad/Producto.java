package com.proyecto.integral.model.entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="productos")
public class Producto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pro_id")
    private Long id;

    @Column(name="pro_nombre")
    private String nombre;

    @Column(name="pro_precio")
    private Float precio;

    @Column(name="pro_fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fecha_registro;


    private Long cat_id ;//prox a cambiar

    @PrePersist //Se ejecuta antes de guardar en la base de datos
    @PreUpdate //Se ejecuta antes de guardar o actualizar
    private void registrarFecha(){
        this.fecha_registro = new Date();
    }




    //Getters and Setters


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Float getPrecio() {
        return precio;
    }


    public void setPrecio(Float precio) {
        this.precio = precio;
    }


    public Date getFecha_registro() {
        return fecha_registro;
    }


    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }


    public Long getCat_id() {
        return cat_id;
    }


    public void setCat_id(Long cat_id) {
        this.cat_id = cat_id;
    }

    
}
