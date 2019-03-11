package sgbd.algorithms;

import sgbd.objects.Frame;
import java.util.LinkedHashMap;

public class LRU extends AbstractAlgorithm{
    
	int key, cacheSize;
	Frame removedPage;
	
    public LRU(){
        super.setCache(new LinkedHashMap<>(5, 5, true));
    }
    
    @Override
    public boolean evict() {
        
    	cacheSize = super.getCacheSize();
    	
        if(cacheSize > 0) {
        	key = super.getCacheKeysList().get(0);
	    	removedPage = super.getCache().get(key);
	    	super.getCache().remove(key);
	        super.showRemovedPage(removedPage);
        }
        
        return true;
    }
}
   