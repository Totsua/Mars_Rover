package org.example;

import org.example.service.ServiceLayerImpl;
public class Main {
    public static void main(String[] args) {

        String input = "5 5";
        String input2 ="1 2 N" ;
        String input3 ="LMLMLMLMMl";


        ServiceLayerImpl serviceLayer = new ServiceLayerImpl();

        System.out.println(serviceLayer.createPlateau(input));
        System.out.println(serviceLayer.createRover(input2));
        System.out.println(serviceLayer.instructRover(input3));
        System.out.println(serviceLayer.getRover().getPosition());



    }
}