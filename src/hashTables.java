/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class hashTables {
    
    nodoHash table[];
    int sizeTable; 
// ---------------------------------------------- Constructor: ------------------------------------------    
    public hashTables(int size){ // Aparecer tabla Hash 
        this.sizeTable = size;
        this.table = new nodoHash[sizeTable];
        for(int i = 0; i < sizeTable; i++){
            this.table[i] = null;
        }
    }
// ======================================================================================================
// ---------------------------------------------- Operaciones: ------------------------------------------
// ======================================================================================================
    // Basicas de la tabla:
    
    public int hashing(String key){ // O tambien conocida como funcion Hash, esta crea key en base al ascii
        int value = 0;              // Valor de llave
        int position = 1;           // Valor de posicion
        for(int i = 0; i < key.length(); i++){
            if(key.codePointAt(i) == 32){ // Recorrido de Espacio en ASCII
                value += 0;
            }else if(key.codePointAt(i) >= 48 && key.codePointAt(i) <= 57){ // Recorrido en ASCII de numeros
                value += ((key.codePointAt(i) - 47) * position);
            }else if(key.codePointAt(i) >= 65 && key.codePointAt(i) <= 90){ // Recorrido en ASCII de letras Mayusculas
                value += ((key.codePointAt(i) - 54) * position);
            }else if(key.codePointAt(i) >= 97 && key.codePointAt(i) <= 122){ // Recorrido en ASCII de letras minusculas
                value += ((key.codePointAt(i) - 60) * position);
            }
            /*
            ----------------------------------
            Tabla Ascii sobre los recorridos:
            ----------------------------------
            <> https://www.asciitable.com/
            ----------------------------------
            */
            position++; // aumentar posicion.
        }
        return (value % sizeTable); // Retorna valor amoldado a la tabla.
    }
    
    public void insertar(String name){ // Agrega un elemento a la tabla
        int position = hashing(name);  
        boolean exist = false;
        if(this.table[position] != null){ // Si la posicion no esta vacia
            nodoHash temp = this.table[position];
            if(temp.getName().equals(name)){ // verificar si esta aqui para no rellenar esa posicion
                exist = true;
            }
            while(temp.getNext() != null){    // Verificar si el nombre no esta en la lista
                temp = temp.getNext();
                if(temp.getName().equals(name)){
                    exist = true;
                }
            }
            if(!exist){
                nodoHash newH = new nodoHash(name); // Agregar en el final
                temp.setNext(newH);
                
            }
        }else{ // Si la posicion esta vacia
            nodoHash newH = new nodoHash(name); // Insertar en el no vacio encontrado
            this.table[position] = newH;
        }
        //repeats++;
    }
    
    public nodoHash search(String name){
        int position = hashing(name);
        nodoHash temp = this.table[position];
        boolean exist = false;
        if(temp != null){
            if(temp.getNext() == null){
                exist = true;
            }else{
                while(temp.getNext() != null && !exist){
                    if(temp.getName().equals(name)){
                        exist = true;
                    }else{
                        temp = temp.getNext();
                    }
                }
            }
        }
        if(exist){
            return temp;
        }else{
            return null;
        }
    }
    
// --------------------------------------------------------------------------------------------------------------

    public void vaciar(){ // Recorre destruyendo la informacion de la lista 
        for(int k = 0; k < sizeTable; k++){
            this.table[k] = null; // Replace to null
        }
    }
    
    public void impresora(){ // Mostrar en consola la lista hash, cuidado con usarlo cuando hay muchos elementos
        for(int j = 0; j < sizeTable; j++){ // Recorrido 1
            if(this.table[j] != null){
                System.out.println(this.table[j].getName());  
                if(this.table[j].getNext() != null){
                    nodoHash temp = this.table[j].getNext();
                    while(temp != null){
                        System.out.println(temp.getName());
                        temp = temp.getNext();
                    }
                }
            }
        }
    }
// ==============================================================================================================
// --------------------------------------------------------------------------------------------------------------
    // Operaciones de analisis de tamaño:
    
    public boolean EstaVacia(){
        boolean vacio = true;
        for(int k = 0; k < sizeTable; k++){
            if(this.table[k] != null){
                vacio = false;
                break;
            }
        }
        return vacio;
    }
    
    public int size(){
        return sizeTable;
    }
    
    public int sizeInUse(){
        int count = 0;
        for(int k = 0; k < sizeTable; k++){
            if(this.table[k] != null){
                count++;
            }
        }
        return count;
    }
    
    public int sizeNotUse(){
        int use = sizeInUse();
        int all = sizeTable;
        return all - use;
    }
    
    //https://tinchicus.com/2019/06/17/java-hashtable/
// --------------------------------------------------------------------------------------------------------------
    // Impresiones y vista de datos:
    
    public void impresoraV2(){ // Mostrar en consola la lista hash, cuidado con usarlo cuando hay muchos elementos
        int count = 1;
        for(int j = 0; j < sizeTable; j++){ // Recorrido 1
            if(this.table[j] != null){
                System.out.println(count + ". " + this.table[j].getName());  
                if(this.table[j].getNext() != null){
                    nodoHash temp = this.table[j].getNext();
                    while(temp != null){
                        System.out.println(count + ". " + temp.getName());
                        temp = temp.getNext();
                        count++;
                    }
                }
                count++;
            }
        }
    }
    
    public void impresoraV3(){ // Mostrar en consola la lista hash, cuidado con usarlo cuando hay muchos elementos
        int count = 1;
        for(int j = 0; j < sizeTable; j++){ // Recorrido 1
            if(this.table[j] != null){
                System.out.println(count + ". Nombre: " + this.table[j].getName() + " llave: " + hashing(this.table[j].getName()));  
                if(this.table[j].getNext() != null){
                    nodoHash temp = this.table[j].getNext();
                    while(temp != null){
                        System.out.println(count + ". Nombre: " + this.table[j].getName() + " llave: " + hashing(this.table[j].getName()));
                        temp = temp.getNext();
                        count++;
                    }
                }
                count++;
            }
        }
    }
    
    public void impresoraKeys(){
        int count = 1;
        for(int j = 0; j < sizeTable; j++){ // Recorrido 1
            if(this.table[j] != null){
                System.out.println(count + ". llave: " + hashing(this.table[j].getName()));  
                if(this.table[j].getNext() != null){
                    nodoHash temp = this.table[j].getNext();
                    while(temp != null){
                        System.out.println(count + ". llave: " + hashing(this.table[j].getName()));
                        temp = temp.getNext();
                        count++;
                    }
                }
                count++;
            }
        }
    }
    
    public void impresoraGrafica(){
        String texto = ""; 
        int count = 1;
        for(int j = 0; j < sizeTable; j++){ // Recorrido 1
            if(this.table[j] != null){
                texto += count + ". Nombre: " + this.table[j].getName() + " llave: " + hashing(this.table[j].getName()) + "\n";  
                if(this.table[j].getNext() != null){
                    nodoHash temp = this.table[j].getNext();
                    while(temp != null){
                        texto += count + ". Nombre: " + this.table[j].getName() + " llave: " + hashing(this.table[j].getName()) + "\n"; 
                        temp = temp.getNext();
                        count++;
                    }
                }
                count++;
            }
        }
        JOptionPane.showMessageDialog(null,texto); 
    }
// --------------------------------------------------------------------------------------------------------------
    // De consulta a la tabla:
    
    


// --------------------------------------------------------------------------------------------------------------
    // Pasar a otras estructuras:
    
    
}

/*
1. Restas Sucesivas.
2. Aritmética Modular.
3. Mitad del Cuadrado.
4. Truncamiento.
5. Plegamiento.
*/