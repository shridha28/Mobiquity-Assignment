/**
 * 
 */
package com.mobiquity.utility;

import com.mobiquity.exception.ApproachNotFoundException;
import com.mobiquity.solution.DynamicSolvable;
import com.mobiquity.solution.Profitable;
import com.mobiquity.solution.RecursiveSolvable;

/**Factory to return the instance of Profitable's concrete implementations
 * @author Shridha S Jalihal
 *
 */
public class ProfitableFactory {
	
	/** Method to return the instance of Profitable's concrete implementations
	 * @param type To create instance
	 * @return Profitable Instance of approach
	 * @throws ApproachNotFoundException
	 *
	 */
	 public static Profitable  getProfitable(String type) throws ApproachNotFoundException {
		 if(type.equals("RecursiveSolvable"))
			 return new RecursiveSolvable();
		 else if (type.equals("DynamicSolvable"))
			 return new DynamicSolvable();
		else
			throw new ApproachNotFoundException("Cannot create instance for the approach:"+type);
	 }
}
