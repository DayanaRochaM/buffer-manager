/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgbd;

import java.util.Iterator;
import java.util.Map.Entry;
import sgbd.algorithms.AbstractAlgorithm;
import sgbd.algorithms.LRU;
import sgbd.objects.Frame;

/**
 *
 * @author pucks
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        AbstractAlgorithm teste = new LRU();
        
        teste.getCache().put(1, new Frame("teste1"));
        teste.getCache().put(2, new Frame("teste2"));
        teste.getCache().put(3, new Frame("teste3"));
        teste.getCache().put(4, new Frame("teste4"));
        teste.getCache().put(5, new Frame("teste5"));
        
        teste.getCache().remove(3);
        
        teste.getCache().get(4); // acessando pra observar as mudanças na ordem da lista
        
        Iterator<Entry<Integer, Frame>> iteratorTeste = teste.getCache().entrySet().iterator();
        while(iteratorTeste.hasNext()){
            System.out.println(iteratorTeste.next().getKey());
        }
        
        System.out.println(teste.getCache().size());
        teste.getCache().get(4);
        teste.displayCache();
        teste.fetch(5);
    }
}
