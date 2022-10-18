package org.hbrs.s1.ws22.uebung1.control;

import org.hbrs.se1.ws22.uebung2.ConcreteMember;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.Assert.assertEquals;


public class TestContainer {
    @BeforeAll
    public static void init(){
        System.out.println("before tests");
        System.out.println("let's test...");
    }
    @AfterAll
    public static void init2(){
        System.out.println("...finish");
    }

    @Test
    public void TestAddMember(){
        //add some Member
        try { ConcreteMember.addMember(50);
            ConcreteMember.addMember(-50);
            ConcreteMember.addMember(210); }
        catch (ConcreteMember.ContainerException ae3)
        { System.out.println("...something it's going wrong..."); }
    }

    @Test
    public String TestAddMemberExist() {
        try{ ConcreteMember.addMember(50);}
        catch (ConcreteMember.ContainerException ame){
            return "you can't add an existed member ;)";
        }
        return "Fail!";
    }

    @Test
    public void TestDeleteMember(){
        //some Member are also added
        //delete the Member
        try{
            ConcreteMember.deleteMember(50);
            ConcreteMember.deleteMember(-50);
            ConcreteMember.deleteMember(210);
        }catch ( IndexOutOfBoundsException ibe ){
            System.out.println("test failed!!");
        }
    }
    @Test
    public void TestDeleteMemberNotExist() {
        //try to delete a not existed Member
        try {
            ConcreteMember.deleteMember(87);
        }catch (IndexOutOfBoundsException dene){
            System.out.println("test successful");
        }
    }
    @Test
    public void TestDump(){
        //add some Member
        ConcreteMember.dump();
    }
    @Test
    public void TestDumpNotExist(){
        //try to dump a not existed Member
        ConcreteMember.dump();
    }
    @Test
    public void TestSize(){
        //add some Member
        try { ConcreteMember.addMember(11); }
        catch (ConcreteMember.ContainerException e)
        { throw new RuntimeException(e); }
        try { ConcreteMember.addMember(90); }
        catch (ConcreteMember.ContainerException e)
        { throw new RuntimeException(e); }
        //geht the size
        assertEquals(2,ConcreteMember.size());
    }
}