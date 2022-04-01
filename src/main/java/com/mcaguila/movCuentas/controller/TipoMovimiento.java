package com.mcaguila.movCuentas.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cuenta)")

//Clase Cuenta
public class TipoMovimiento {
	  private int idMov;
	  private String nombreMov;
	  private String operacion;
	  

//Constructor por defecto
public TipoMovimiento() {
}

//Constructor con parámetros
public TipoMovimiento(int idMov, String nombreMov,String operacion) {                         
    this.idMov = idMov;
    this.nombreMov = nombreMov;
    this.operacion = operacion;

}
}
