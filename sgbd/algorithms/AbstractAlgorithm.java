package sgbd.algorithms;

import java.util.Map;
import sgbd.objects.Frame;

public abstract class AbstractAlgorithm {
	
	private int cacheHit, cacheMiss;
        // The third argument for LinkedHashMap can be true for keeping access-order or false for insertion-order
	private Map<Integer, Frame> cache ;

        protected void setCache(Map<Integer, Frame> cache) {
            this.cache = cache;
        }
        
        // will be protected, now is public for testing
        public Map<Integer, Frame> getCache(){
            return cache;
        }
	
	private void incrementCacheHit() {
            cacheHit++;	
	}
	
	private void incrementCacheMiss() {
            cacheMiss++;	
	}
	
	public void displayCache() {

            int frameNumber = 1;
            for(Map.Entry<Integer, Frame> page: cache.entrySet() ){
                int key = page.getKey();
                String value = page.getValue().getLine();
                System.out.println("\n FRAME NUMBER: " + frameNumber +
                        "\nNúmero da linha: " + key +
                        "\nTexto: " + value + "\n");
                
                frameNumber++;
            }
        }	
        
	public void displayStats() {
            System.out.println("\nCache Hit: " + this.cacheHit
				+ "\nCache Miss: " + this.cacheMiss);
	}

	public void fetch(int key){
            Frame value = cache.get(key);
            if (value == null && cache.size()>=5){
                boolean theresSpace = evict();
                if(theresSpace){
                    // String newLine = loadLine(key); Será usado para ler o arquivo
                    // cache.put(key, new Frame(newLine))
                    System.out.println("\nLinha adicionada: " + cache.get(key).getLine());
                }else{
                    System.out.print("\nNão há espaço disponível!");
                }
                incrementCacheMiss();
            }else if(value == null){
                // String newLine = loadLine(key);
                // cache.put(key, new Frame(newLine));
                incrementCacheMiss();
            }
            else{
                System.out.println("\nValor encontrado: " + value.getLine());
                incrementCacheHit();
            }
        }
        
        public abstract boolean evict();
        
        protected void showRemovedPage(Frame page){
            System.out.println("Linha: " + page.getLine());
        }
}
