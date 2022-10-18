package org.hbrs.se1.ws22.uebung2;

public class ConcreteMember implements Member{

    public static void createMember(){
        Container.Member();
    }

    public static void addMember(int ID) throws ContainerException {
        while(Container.member.listIterator().hasNext()){
            if(Container.member.listIterator().next() == ID){
                throw new ContainerException();
            }
        }
        Container.member.add(ID);
    }
    public static void deleteMember(int ID) throws IndexOutOfBoundsException{
        Container.member.remove(ID);
    }
    public static void dump(){
        while(Container.member.listIterator().hasNext()){
            System.out.println("Member (ID = " + Container.member.listIterator().next() + ")");
        }
    }
    public static int size(){
        return Container.member.size();
    }

    @Override
    public Integer getID() {
        return null;
    }

    public static class ContainerException extends Exception {
    }
}
