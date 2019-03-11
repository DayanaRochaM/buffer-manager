package sgbd.algorithms;

import java.util.LinkedHashMap;
import sgbd.objects.Frame;

public class FIFO extends AbstractAlgorithm{
	
	int key, cacheSize;
	Frame removedPage;
	
    public FIFO(){
         super.setCache(new LinkedHashMap<>(5, 5, false));
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
