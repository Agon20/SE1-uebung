package org.hbrs.se1.ws22.uebung2;

import java.util.ArrayList;

class Container {

    static ArrayList<Integer> member;
    static void Member(){
        ArrayList<Integer> member = new ArrayList<>();
        Container.member = member;
    }
}
