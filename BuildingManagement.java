package com.nikoer.helloworld.data.Datas;

import org.springframework.util.Assert;

public class BuildingManagement {
       Asset things[] = new Asset[24];
       int numItems = 0;

       public void goodNight(){
           for(int i=0;i<things.length;i++){
               if (things[i] instanceof PowerSwitchable)
                   ((PowerSwitchable)things[i].powerDown);
       }
       public void add (Assert thing){
           System.out.println("Adding" +thing);
           things[numItems++] = thing;
           }
           public static void main(String[] av){
           BuildingManagement b1 = new BuildingManagement();
           b1.add(new RoomLigths(101));
           b1.add(new EmergencyLight(101));
           b1.add(new ComputerCPU(10104));
           b1.add(new ComputerMonitor(10104));
           b1.goodNight();
           }
}
}
