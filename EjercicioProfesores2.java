package com.mycompany.ejercicioarrays;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EjercicioProfesores2 {
    
    ArrayList<String> listaProfesores;
    ArrayList<String> listaEstudiantes;
    ArrayList<ArrayList<String>> listaGeneralEstudiantes;
    
    public EjercicioProfesores2(){
        listaProfesores=new ArrayList<>();
        listaGeneralEstudiantes=new ArrayList<>();
    }
     public void iniciar() { //Menú para escoger la opción que el usuario desea consultar
        int opcion = 0;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("1. Registrar Profesores\n2. Registrar Estudiantes\n3. Consultar la lista de profesores y estudiantes\n4. Consultar el profesor por nombre\n5. Consultar la cantidad de estudiantes por profesor\n6. Consultar estudiante por nombre\n7. Terminar.\n"));
            switch (opcion) {
                case 1:
                    registrarProfesores();
                    break;
                case 2:
                    registrarEstudiantes();
                    break;
                case 3:
                    consultarListaProfesoresYEstudiantes();
                    break;
                case 4:
                    consultaProfesorPorNombre();
                    break;
                case 5:
                    consultaCantidadEstudiantesPorProfesor();
                    break;
                case 6:
                    consultarEstudiante();
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida, ingrese una opción válida ");
            }
        } while (opcion!=7);
    }

    public void iniciar(){
        registrarProfesores();
        registrarEstudiantes();
        consultarListaProfesoresyEstudiantes();
        consultarProfesorPorNombre();
        consultarCantidadEstudiantesPorProfesor();
        consultarEstudiante();
    }
    private void registrarProfesores(){ //Bloque de codigo para ingresar a los profesores y si hay un profesor que se registró con anterioridad
        System.out.println("\n<<<< Registro de Profesores >>>>");
        int cant=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de profesores"));
        
        for (int i = 0; i <cant ; i++){
            
            String nombreProfesor=JOptionPane.showInputDialog("nombre Profesor "+(i+1));
            if (!listaProfesores.contains(nombreProfesor))
                listaProfesores.add(nombreProfesor);
            else
                JOptionPane.showMessageDialog(null, "El profesor " +nombreProfesor+ " ya se encuentra registrado en la lista");
        }
        System.out.println("Registro de profesores Exitoso!\n");
    }
    private void registrarEstudiantes(){//Bloque de codigo para ingresar a los estudiantes y si hay un estudiante que se registró con anterioridad
        System.out.println("\n<<<< Registro de Estudiantes >>>>");
        for (int i = 0; i<listaProfesores.size(); i++){
            
            JOptionPane.showInputDialog(null,"Ingrese los estudiantes"+
                     " para el profesor "+listaProfesores.get(i));
            
            listaEstudiantes=new ArrayList<String>();
            
            int cant=Integer.parseInt(JOptionPane.showInputDialog("Cantidad de estudiantes"));
            
            for (int j=0; j<cant ; j++){
                
                String nombreEst=JOptionPane.showInputDialog("nombre estudiante "+(j+1));
                if (!listEstudiantes.contains(nombreEst))
                    listaEstudiantes.add(nombreEst);
                else
                    JOptionPane.showMessageDialog(null, "El estudiante "+nombreEst+ "ya se encuentra en la lista");
            }
            listaGeneralEstudiantes.add(listaEstudiantes);
        }
        System.out.println("Registro de estudiantes Exitoso\n");
    }
    private void consultarListaProfesoresYEstudiantes() {// Bloque de un codigo que mostrará los profesores y estudiantes registrados o si por el contario no hay ninguno registrado
        System.out.println("\n<<<< Lista de Profesores y Estudiantes >>>>");
        ArrayList<String> listaTemporal;

        if (listaProfesores.size() > 0) {
            if (listaGeneralEstudiantes.size() > 0) {
                for (int i = 0; i < listaGeneralEstudiantes.size(); i++) {
                    listaTemporal=listaGeneralEstudiantes.get(i);

                    System.out.print("Profesor: "+listaProfesores.get(i)+" = ");
                    System.out.print("[");
                    for (int j = 0; j < listaTemporal.size(); j++) {
                        System.out.print(listaTemporal.get(j));
                        if (j<listaTemporal.size()-1) {
                            System.out.print(", ");
                        }
                    }
                    System.out.print("]\n");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El profesor "+listaProfesores.get(0)+" no tiene estudiantes, registre un estudiante antes");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay profesores registrados, registre primero un profesor");
        }
    }
    private void consultaProfesorPorNombre() {//Bloque de codigo que permite al usuario consultar por el nombre de profesor ingresado
        System.out.println("\n<<<< Consulta de Profesor >>>>  \n");
        String nombre=JOptionPane.showInputDialog("Ingrese el nombre del profesor");

        if (listaProfesores.contains(nombreProfesor)) {
            System.out.print("Profesor: "+nombreProfesor+" = ");
            int posicion=listaProfesores.indexOf(nombreProfesor);
            if (posicion < listaGeneralEstudiantes.size()) {
                System.out.print("[");

                ArrayList<String> listaEstudiantesTemporal=listaGeneralEstudiantes.get(posicion);

                for (int j = 0; j < listaEstudiantesTemporal.size(); j++) {
                    System.out.print(listaEstudiantesTemporal.get(j));
                    if (j<listaEstudiantesTemporal.size()-1) {
                        System.out.print(", ");
                    }
                }
                System.out.println("]");
            } else {
                System.out.println("El profesor no tiene alumnos registrados");
            }
        } else {
            System.out.println("No se encuentra el profesor "+nombreProfesor+"\n");
        }
    }
    private void consultaCantidadEstudiantesPorProfesor() {//Permite al usuario consultar la cantidad de estudiantes que tiene cada profesor
        System.out.println("\n<<<< Consulta cantidad de estudiantes de Profesores >>>>  \n");
        String nombre=JOptionPane.showInputDialog("Ingrese el nombre del profesor para saber la cantidad de estudiantes asociados");

        if (listaProfesores.contains(nombre)) {
            int posicion=listaProfesores.indexOf(nombreProfesor);
            if (posicion < listaGeneralEstudiantes.size()) {

                ArrayList<String> listaEstudiantesTemporal=listaGeneralEstudiantes.get(posicion);
                System.out.println("La cantidad de estudiantes asociados al profesor "+nombreProfesor+" es "+listaEstudiantesTemporal.size());
            } else {
                System.out.println("El profesor "+nombreProfesor+" no tiene estudiantes.");
            }
        } else {
            System.out.println("No se encuentra el profesor "+nombreProfesor+"\n");
        }
    }
    private void consultarEstudiante() {//Permite al usuario consultar los estudiantes registrados
        System.out.println("\n<<<< Consulta de Estudiante >>>>  \n");
        ArrayList<String> listTemporal;

        String nombre=JOptionPane.showInputDialog("Ingrese el nombre del estudiante a consultar");

        if (listEstudiantes.size() > 0) {
            for (int i = 0; i < listaGeneralEstudiantes.size(); i++) {
                listTemporal=listaGeneralEstudiantes.get(i);
                if (listTemporal.contains(nombreEst)) {
                    for (int j = 0; j < listTemporal.size(); j++) {
                        if (listTemporal.get(j).equalsIgnoreCase(nombreEst)) {
                            System.out.println("Encuentra al nombre: "+nombreEst+" pertenece al grupo de "+listaProfesores.get(i));
                        }
                    }
                } else {
                    System.out.println("No se encuentra el nombre en el grupo de "+listaProfesores.get(i));
                }
            }
        } else {
            System.out.println("No hay estudiantes registrados, hay que registrar uno estudiantes primero.");
        }
    }
    
}
