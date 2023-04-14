/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.molelos;

import java.util.LinkedHashMap;

/**
 * La interfaz {@code Mapeable} puede ser implementada por cualquier clase que
 * pretenda que sus instancias puedan devolver su estado en forma de
 * {@link HashMap} donde las {@code keys} serán los nombres de los atributos y
 * los {@code values} el valor en formato String de los mismos
 *
 * @author Juan Carlos Vilarrubia
 */
public interface Mapeable {

    public LinkedHashMap<String, String> toHashMap();
}
