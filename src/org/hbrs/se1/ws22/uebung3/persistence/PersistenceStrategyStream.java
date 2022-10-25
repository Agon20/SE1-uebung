package org.hbrs.se1.ws22.uebung3.persistence;

import java.io.*;
import java.util.List;

public class PersistenceStrategyStream<E> implements PersistenceStrategy<E> {

    // URL of file, in which the objects are stored
    private String location = "objects.ser";

    private ObjectOutputStream oos = null;
    private ObjectInputStream ois = null;

    private FileInputStream fis = null;
    private FileOutputStream fos = null;


    // Backdoor method used only for testing purposes, if the location should be changed in a Unit-Test
    // Example: Location is a directory (Streams do not like directories, so try this out ;-)!
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    /**
     * Method for opening the connection to a stream (here: Input- and Output-Stream)
     * In case of having problems while opening the streams, leave the code in methods load
     * and save
     */
    public void openConnection() throws PersistenceException {
        try{
            fos = new FileOutputStream(location);
            fis = new FileInputStream(location);

            oos = new ObjectOutputStream(fos);
            ois = new ObjectInputStream(fis);
        }catch (IOException e){
            throw new PersistenceException( PersistenceException.ExceptionType.ConnectionNotAvailable,"Error, File not exist");
        }


    }

    @Override
    /**
     * Method for closing the connections to a stream
     */
    public void closeConnection() throws PersistenceException {
        try {
            if (oos != null) oos.close();
            if (ois != null) ois.close();

            if (fis != null) fis.close();
            if (fos != null) fos.close();
        }catch (IOException e){
            throw new PersistenceException(PersistenceException.ExceptionType.ClosingStreamFailed,"close connection failed");
        }
    }

    @Override
    /**
     * Method for saving a list of Member-objects to a disk (HDD)
     */
    public void save(List<E> member) throws PersistenceException  {
        try {
            oos.writeObject(member);
        } catch (IOException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.SavingFailed, "...Saving failed" );
        }
    }

    @Override
    /**
     * Method for loading a list of Member-objects from a disk (HDD)
     * Some coding examples come for free :-)
     * Take also a look at the import statements above ;-!
     */
    public List<E> load() throws PersistenceException  {
        // Some Coding hints ;-)

        // ObjectInputStream ois = null;
        // FileInputStream fis = null;
        // List<...> newListe =  null;
        //
        // Initiating the Stream (can also be moved to method openConnection()... ;-)
        // fis = new FileInputStream( " a location to a file" );
        // Tipp: Use a directory (ends with "/") to implement a negative test case ;-)
        // ois = new ObjectInputStream(fis);

        // Reading and extracting the list (try .. catch committed here)
        // Object obj = ois.readObject();

        // if (obj instanceof List<?>) {
        //       newListe = (List) obj;
        // return newListe

        // and finally close the streams (guess where this could be...?)
        List<E> newListe = null;
        try {
            Object obj= ois.readObject();
            if(obj instanceof List<?>){
                newListe = (List) obj;
            }
            return newListe;
        }catch (IOException | ClassNotFoundException e){
            throw new PersistenceException(PersistenceException.ExceptionType.ReadingObjectFailed, "Reading failed" );
        }
    }
}
