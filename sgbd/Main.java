package sgbd;

import java.io.IOException;
import java.util.Scanner;
import sgbd.algorithms.AbstractAlgorithm;
import sgbd.algorithms.Clock;
import sgbd.algorithms.FIFO;
import sgbd.algorithms.LRU;
import sgbd.algorithms.MRU;

public class Main {

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        Scanner scanner = new Scanner(System.in);
        Boolean isRunning = true, waitingNumber = true;
        int choice = 0;
        
        System.out.println("\n==== BEM-VINDO AO GERENCIADOR DE BUFFER! ====");
       
        while(isRunning){
            System.out.println("\nEscolha uma das opções abaixo: ");
            System.out.println("1-LRU 2-MRU 3-FIFO 4-CLOCK 0-Finalizar programa");

            while(waitingNumber) {
                try {
                    choice = Integer.parseInt(scanner.next());
                    waitingNumber = false;
                } 
                catch (Exception ex) {
                    System.out.println("\nTente novamente.");
                }
            }

            switch(choice){
                case 1:
                    AbstractAlgorithm lru = new LRU();
                    
                    System.out.println("\n\n==== VOCÊ ESTÁ UTILIZANDO O ALGORITMO LRU(Least Recently Used)! ====");
                    algorithmMenu(scanner, lru);
                    break;
                    
                case 2:
                    AbstractAlgorithm mru = new MRU();
                    
                    System.out.println("\n\n==== VOCÊ ESTÁ UTILIZANDO O ALGORITMO MRU(Most Recently Used)! ====");
                    algorithmMenu(scanner, mru);
                    break;
                    
                case 3:
                    AbstractAlgorithm fifo = new FIFO();
                    
                    System.out.println("\n\n==== VOCÊ ESTÁ UTILIZANDO O ALGORITMO FIFO(First in First out)! ====");
                    algorithmMenu(scanner, fifo);
                    break;
                    
                case 4:
                    AbstractAlgorithm clock = new Clock();
                    
                    System.out.println("\n\n==== VOCÊ ESTÁ UTILIZANDO O ALGORITMO Clock! ====");
                    algorithmMenu(scanner, clock);
                    break;
                    
                case 0:
                    System.out.println("\n\n==== Tchau! Até a próxima!! ====");
                    isRunning = false;
                    break;
                    
                default:
                    System.out.println("\n==== Por favor, digite uma opção válida! ====");
                    break;
            }
        }
    }
    
    private static void algorithmMenu(Scanner scanner, AbstractAlgorithm algorithm){
        
        System.out.println("\nEscolha uma das operações abaixo: ");
        System.out.println("1-Display Cache \n2-Display Stats \n3-Fetch \n4-Evict \n0-Finalizar algoritmo");
        int choice = 0;
        
        Boolean waitingNumber = true;
                
        while(waitingNumber) {
            System.out.println("\nDigite: ");
            try {
                choice = Integer.parseInt(scanner.next());
                waitingNumber = false;
            } 
            catch (Exception ex) {
                System.out.println("\nTente novamente.");
            }
        }
        
        switch(choice){
            case 1:
                algorithm.displayCache();
                break;
            case 2:
                algorithm.displayStats();
                break;
            case 3:
                
                waitingNumber = true;
                
                while(waitingNumber) {
                    System.out.println("\nDigite a chave da linha: ");
                    try {
                        int key = Integer.parseInt(scanner.next());
                        algorithm.fetch(key);
                        waitingNumber = false;
                    } 
                    catch (Exception ex) {
                        System.out.println("\nTente novamente.");
                    }
                }
                break;
            case 4:
                algorithm.evict();
                break;
            case 0:
                System.out.println("\n==== VOCÊ SAIU DAS OPÇÕES DO ALGORITMO. ====");
                break;
            default:
                System.out.println("\nPor favor, digite uma operação válida.");
                break;
        }
    }
}
