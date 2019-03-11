package sgbd.algorithms;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import sgbd.objects.Frame;

public class MRU extends AbstractAlgorithm{
    
	int key, cacheSize;
	Frame removedPage;
	
    public MRU(){
         super.setCache(new LinkedHashMap<>(5, 5, true));
    }
    
    @Override
    public boolean evict() {
        
        List<Integer> allKeys = super.getCacheKeysList();
        Collections.reverse(allKeys);
        
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