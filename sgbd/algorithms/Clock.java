package sgbd.algorithms;

import java.util.LinkedHashMap;
import sgbd.objects.Frame;

public class Clock extends AbstractAlgorithm{
    
	int actualFrame = -1,  key, cacheSize;
	Frame removedPage;
	
    public Clock(){
        super.setCache(new LinkedHashMap<>(5, 5, false));
    }

    @Override
    public boolean evict() {
    	
    	cacheSize = super.getCacheSize();
        
        if(cacheSize > 0) {
        	calculateActualPosition();
        	key = super.getCacheKeysList().get(actualFrame);
        	removedPage = super.getCache().get(key);
        	super.getCache().remove(key);
            super.showRemovedPage(removedPage);
        }
        
        return true;
    }
    
    private void calculateActualPosition() {
    	int cacheSize = super.getCacheSize();
    	
    	if(actualFrame+1 < cacheSize) {
    		actualFrame++;
    	}else {
    		actualFrame = 0;
    	}
    }
}
