/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author pc
 */
public class nodoHash {

    /**
     * @return the repeats
     */
    public int getRepeats() {
        return repeats;
    }

    /**
     * @param repeats the repeats to set
     */
    public void setRepeats(int repeats) {
        this.repeats = repeats;
    }

    /**
     * @return the next
     */
    public nodoHash getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(nodoHash next) {
        this.next = next;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    private nodoHash next;
    private String name;
    private int repeats;
    
    public nodoHash(String name){
        this.next = null;
        this.name = name;
        this.repeats = 0;
    }
    
    
}
