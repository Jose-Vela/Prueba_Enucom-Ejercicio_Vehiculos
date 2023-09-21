package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner teclado = new Scanner(System.in);
    static ArrayList<Vehiculo> vehiculos = new ArrayList<>();

    public static void main(String[] args) {
        String opcion;

        do {
            System.out.println("\n\n1 - Agregar vehiculo");
            System.out.println("2 - Mostrar información del vehículo más barato");
            System.out.println("3 - Mostrar todos los vehículos");
            System.out.println("4 - Salir");
            System.out.println("\nElija una de las opciones anteriores...");

            opcion=teclado.nextLine();

            switch (opcion){
                case "1": agregarVehiculo(); break;
                case "2": mostrarMasBarato(); break;
                case "3": mostrarTodosLosVehiculos(); break;
            }
        } while (!opcion.equals("4"));
        System.exit(0);
    }

    private static void mostrarTodosLosVehiculos() {
        if(!vehiculos.isEmpty()){
            String marca, modelo;
            float precio;

            for(int i = 0; i< vehiculos.size(); i++) {
                marca = vehiculos.get(i).getMarca();
                modelo = vehiculos.get(i).getModelo();
                precio = vehiculos.get(i).getPrecio();

                System.out.println(i+1 + " - Marca: " + marca + ", Modelo: " + modelo + ", Precio:" + precio);
            }
            teclado.nextLine();
        }
    }

    private static void mostrarMasBarato() {
        if(!vehiculos.isEmpty()){
            int indiceMasBarato = calcularVehiculoMasBarato();
            String marca = vehiculos.get(indiceMasBarato).getMarca();
            String modelo = vehiculos.get(indiceMasBarato).getModelo();
            float precio = vehiculos.get(indiceMasBarato).getPrecio();

            System.out.println("Marca: " + marca + ", Modelo: " + modelo + ", Precio:" + precio);
            teclado.nextLine();
        }
    }

    private static void agregarVehiculo() {
        String marca, modelo;
        float precio;

        System.out.print("\nMarca: ");
        marca = teclado.nextLine();
        System.out.print("Modelo: ");
        modelo = teclado.nextLine();
        System.out.print("Precio: ");
        precio = teclado.nextFloat();
        teclado.nextLine();

        vehiculos.add(new Vehiculo(marca, modelo, precio));
    }

    private static int calcularVehiculoMasBarato() {
        int indice = 0;
        float precioMasBarato = vehiculos.get(0).getPrecio();
        for(int i = 1; i < vehiculos.size(); i++) {
            if (vehiculos.get(i).getPrecio() < precioMasBarato) {
                precioMasBarato = vehiculos.get(i).getPrecio();
                indice = i;
            }
        }
        return indice;
    }
}