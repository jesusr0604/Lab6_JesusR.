package lab6_jesusr;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Lab6_JesusR {

    static Scanner leer = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("1: Turning");
            System.out.println("2: Constante de Kaprekar");
            System.out.println("0:Salir");
            System.out.println("Ingrese su desicion");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el tamaño del arreglo: ");
                    int tam = leer.nextInt();
                    int[] numeros = new int[tam];
                    numeros = lectura(tam);
                    System.out.println("Ingrese las intrucciones: ");
                    String ins = leer.next().toUpperCase();
                    System.out.println( Instrucciones(ins, numeros));
                    break;
                case 2:
                   
                    System.out.println("Ingrese un numero de cuatro digitos"); 
                    int newnumb= leer.nextInt();
                    String Numero= ""+newnumb;
                    if (Numero.charAt(0)==Numero.charAt(1)&& Numero.charAt(1)== Numero.charAt(2)&& Numero.charAt(2) == Numero.charAt(3)){
                        System.out.println("No encontrado");
                    }
                    else{
                        kaprekar (newnumb);
                    }
                    
                    
                            
                    break;
                case 0: 
                    System.out.println("Saliendo...");
                break; 
                
                default:
                    System.out.println("No valido");
                break;
                 

            }
        } while (opcion != 0);
    }

    public static int[] lectura(int tam) {
        int[] arreglo = new int[tam];
        for (int i = 0; i < tam; i++) {

            arreglo[i] = random.nextInt(11);
        }
        imprimir(arreglo);

        return arreglo;
    }

    public static void imprimir(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("[ " + array[i] + "] ");
        }//for
        System.out.println();
    }

    public static String Instrucciones(String ins, int[] numeros) {
        String acum = "";
        int apuntador = 0;
        char let1 = 'L';
        char let2 = 'R';
        char let3 = 'X';
        for (int i = 0; i < ins.length(); i++) {
            char jamon = ins.charAt(i);
            if (jamon == let1) {
                apuntador = apuntador - 1;
            } else if (jamon == let2) {
                apuntador = apuntador + 1;
            } else if (jamon == let3) {
                acum += numeros[apuntador];
            }
        }

        return acum;
    }
    
    public static int[] arreglo1(int newnumb ){
        int tam =4;
        int div = 0;
        int res = 0;
        int a= 1000;
        int[] arreglo11= new int[tam];
        for (int i = 0; i < tam ; i++) {
            div= newnumb / a;
            res= newnumb % a;
            arreglo11 [i]= div;
            newnumb= res;
            a= a/10;
            
        }
        arreglo11 = Organizar(arreglo11);
        //Organizar3(arreglo11);
        
        return arreglo11;
    }
    
    public static int[] Organizar (int arreglo11[]){
        //Lo que hace este metodo es agarrar el arreglo ya hecho, agarra lo que hay dentro del arreglo y compara  si un numero es menor que otro se va a asignar
            int[] temporal = new int[arreglo11.length];
            String Cadena2 = "";
        int change = 0;
        for (int i = 0; i < arreglo11.length; i++) {
            int a = 19, b;
            for (int k = 0; k < arreglo11.length; k++) {
                b = arreglo11[k];
                if (b <= a) {
                    a = b;
                    change = k;
                }//if
            }//for k
            temporal[i] = a;
            arreglo11[change] = 20;
            Cadena2+= temporal[i];
        }//for i
        int res2 = Integer.parseInt(Cadena2);
       //resultado(res2);
        return temporal;
    }//organizar
    

     
      public static int[] Organizar3 (int arreglo11[]){
//En este, nos ayuda a invertir el metodo anterior, agarra los numeros y los 
         String Cadena1=""; 
                 
          int[] arreglo44 = new int[arreglo11.length];
          for (int i = arreglo11.length-1; i>=0; i--) {
            
                  arreglo44[i]=arreglo11[(arreglo11.length-1)-i];
                  Cadena1 += arreglo11[i];
           }
           int res1 = Integer.parseInt(Cadena1); 
              
          
         // resultado(res1);
          
          return arreglo44;
      }
     
     public static void kaprekar(int num){
         String Num1="";
         String Num2= "";
         
         while(num!=6174){
                   int[] hola2 = arreglo1 (num);
                    
                   int[] hola3 = Organizar3 (hola2);
                    for (int i = 0; i < 4; i++) {
                       Num1+= hola2[i];
                       Num2+= hola3[i];
                    }
                    int menor = Integer.parseInt(Num1);
                    int mayor = Integer.parseInt(Num2);
                    num= mayor-menor;
                    System.out.println(mayor +"-"+menor+ "=" + num);
         
                    Num1= "";
                    Num2="";
                    }
     }
    
    
    }

// El primero: En el primero, primero leemos cuantos numeros queremos para el array, luego se va a un metodo, en donde se generaran 4 numeros del 1-10.
//Luego de hacer eso, El usuario ingresara las intrucciones, despues de que hay instrucciones, se va al metodo de instrucciones, en donde hay un apuntador.
//Si hay una L, el apuntador se restara, si hay una R, el apuntador se sumara y si hay una X, el numero se imprime.




