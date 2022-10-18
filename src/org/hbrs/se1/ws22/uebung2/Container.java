package org.hbrs.se1.ws22.uebung2;

import java.util.ArrayList;

/*
 * @author aazemi2s
 */

class Container {

    //bei ArrayList<Integer> kriege ich diese Probleme nicht :/
    static ArrayList<Member> member;
    static void Member(){
        ArrayList<Member> member = new ArrayList<>();
        Container.member = member;
    }
}
