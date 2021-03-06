package sgbd.algorithms;

import java.io.IOException;
import java.util.Map;
import sgbd.filemanager.ArchiveReader;
import sgbd.objects.Frame;
import java.util.List;
import java.util.ArrayList;

public abstract class AbstractAlgorithm {
	
	private int cacheHit, cacheMiss;
        // The third argument for LinkedHashMap can be true for keeping access-order or false for insertion-order
	private Map<Integer, Frame> cache ;

        protected void setCache(Map<Integer, Frame> cache) {
            this.cache = cache;
        }
        
        protected Map<Integer, Frame> getCache(){
            return cache;
        }
	
    protected List<Integer> getCacheKeysList(){
    	List<Integer> keyList = new ArrayList<>(cache.keySet());
    	return keyList;
    }
    
    protected int getCacheSize() {
    	return getCacheKeysList().size();
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

	public void fetch(int key) throws IOException{
            
            Frame value = cache.get(key);
            if (value == null && cache.size()>=5){
                boolean theresSpace = evict();
                if(theresSpace){
                    String newLine = ArchiveReader.loadLine(key); 
                    insertLine(key, newLine);
                }
                else{
                    System.out.print("\nNão há espaço disponível!");
                }
                incrementCacheMiss();
            }
            else if(value == null){
                String newLine = ArchiveReader.loadLine(key);
                insertLine(key, newLine);
                incrementCacheMiss();
            }
            else{
                System.out.println("\nValor encontrado: " + value.getLine());
                incrementCacheHit();
            }
        }
        
        public abstract boolean evict();
        
        protected void showRemovedPage(Frame page){
            System.out.println("\nLINHA EXCLUÍDA: " + page.getLine());
        }
        
        protected void insertLine(int key, String newLine){
            if( newLine != null){
                cache.put(key, new Frame(newLine));
                System.out.println("\nLINHA ADICIONADA: " + cache.get(key).getLine());
            }else{
                System.out.println("\nLINHA NÃO ENCONTRADA!");
            }
        }
}
