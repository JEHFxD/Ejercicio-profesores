package com.mycompany.ejercicioarrays;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EjercicioProfesores {
    public static void main(String[]args){
        ArrayList<String>listaProfesores=new ArrayList<>();
       
        listaProfesores.add("Cristian");
        listaProfesores.add("German");
        listaProfesores.add("Hugo");
        
        ArrayList<String>listEstudiantes;
        ArrayList<ArrayList<String>>listaGeneralEstudiantes=new ArrayList<>();
        
        for (int i=0; i<listaProfesores.size(); i++){
            JOptionPane.showMessageDialog(null, "Ingrese los estudiantes "
            + "para el profesor "+listaProfesores.get(i));
            
            listEstudiantes=new ArrayList<String>();
            int cant=Integer.parseInt(JOptionPane.showInputDialog("Cantidad de estudiantes"));
            for (int j=0; j<cant;j++){
                String nombreEst=JOptionPane.showInputDialog("nombre estudiate "+(j+1));
                listEstudiantes.add(nombreEst);
            }
            listaGeneralEstudiantes.add(listEstudiantes);
        }   
        System.out.println(listaGeneralEstudiantes);
        
        ArrayList<String>listaTemporal;
        for(int i=0;i<listaGeneralEstudiantes.size();i++){
            
            listaTemporal=listaGeneralEstudiantes.get(i);
            System.out.print("Profesor: "+listaProfesores.get(i)+" = ");
            System.out.print("[");
            for (int j=0; j<listaTemporal.size(); j++){
                System.out.print(listaTemporal.get(j)+" ");
            }
            System.out.print("]\n");
        }
    }   
}
