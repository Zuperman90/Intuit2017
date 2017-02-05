import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IntuitChallenge {
	double income = 0.0;
    double expense = 0.0;
    double amt = 0;
    boolean paycheckFound = false;
    static int paycheckCount = 0;
    static int expenseExceed = 0;
    static int otherScore = 0;
    
    /**
     * checks expenses of the user.
     *
     * @throws ArithmeticException If an arithmetic error occurs.
     */
	void expenseCheck(String[] data){
		String vendor = data[2];
		try{
			if(vendor.equalsIgnoreCase("paycheck") || vendor.contains("paycheck")){
	    		paycheckFound = true;
	    		paycheckCount++;
	    		if(expense > income){ //Poor finacial planning if expenses > income
	    			expenseExceed++; //taking of count of times this happens
	    		}
	    		expense = 0;	
	    		income = Double.parseDouble(data[3]);
	    	} else{
	    		if(paycheckFound)
	    			expense = expense + Math.abs(Double.parseDouble(data[3])); //adding monthly expenses
	    	}
		}catch (Exception e){
			
		}
	}
	
	/**
	 * Checks for the occurance of other parameters and assigns weightage for each
	 *
	 * @throws FTPConnectionException If an I/O error occurs.
	 */
	
	void otherCheck(String[] data){
		String vendor = data[2];
		if(vendor.equalsIgnoreCase("wedding") || vendor.contains("Wedding")){
			otherScore = otherScore + 3; //assigns high weightage if some wedding related transaction is done
		}
		if(vendor.equalsIgnoreCase("movie") || vendor.contains("Movie")){
			otherScore = otherScore + 2;
		}
		if(vendor.equalsIgnoreCase("restaurant") || vendor.contains("Restaurant")){
			otherScore = otherScore + 1;
		}
		if(vendor.equalsIgnoreCase("concert") || vendor.contains("Concert")){
			otherScore = otherScore + 1;
		}
		if(vendor.equalsIgnoreCase("wine") || vendor.contains("Wine")){
			otherScore = otherScore + 2;
		}
		
	}
	/**
	 * Prints the output if the current relationship isnt progressing well!
	 *
	 * @throws 
	 * @throws 
	 */
	
	void printBreakUp(String authid){
		
		System.out.println("=============User ID: "+authid+" ================");
    	System.out.println("Less likelihood of current relationship.");
    	System.out.println("Reason: Poor finacial planning!");
    	System.out.println("Monthly expenses exceeded income in more than half the duration given.");
    	System.out.println("==============================================");
    	System.out.println();
	}
	/**
	 * Prints the output if the current relationship is progressing well!
	 *
	 * @throws 
	 * @throws 
	 */
	
	void printGoodProgress(String authid){
		System.out.println("=============User ID: "+authid+" ================");
    	System.out.println("Good likelihood of current relationship.");
    	System.out.println("Reason: Good finacial planning!");
    	System.out.println("Reason: Couple Earned good score in other parameters");
    	System.out.println("Eg: Eating out, Movies, Wedding planner etc.");
    	System.out.println("==============================================");
	}
	/**
	 * The main function of the program
	 *
	 * @throws FileNotFound If an I/O error occurs.
	 * @throws FTPLoginException If the operation did not succeed.
	 */

    public static void main(String[] args) {

        String path="";
    	//String csvFile = "C:\\Users\\Ajith\\Downloads\\rit-challenge-master\\rit-challenge-master\\transaction-data\\user-0.csv";
        //path = "C:\\Users\\Ajith\\Downloads\\rit-challenge-master\\rit-challenge-master\\transaction-data";
        String line = "";
        String cvsSplitBy = ",";
        String authid="", date , vendor, location;
        double finPlanningRatio = 0.0;
        int fileCount = 0;
        IntuitChallenge obj = new IntuitChallenge();
        
        
        System.out.println("Enter the abs path to the folder name (with slashes escaped)");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
			path = br.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        
        File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
		    if (file.isFile() && file.getName().contains("csv")) {
		    	try {
		            FileReader fileReader =   new FileReader(file);
		            BufferedReader bufferedReader =   new BufferedReader(fileReader);
		            while ((line = bufferedReader.readLine()) != null) {
		                String[] data = line.split(cvsSplitBy);
		                authid = data[0];
		                //calculating expense for a month
		                obj.expenseCheck(data);
		                obj.otherCheck(data);
		            }
		            System.out.println("File Name "+file.getName());
		            if(paycheckCount!=0){
	                	finPlanningRatio = expenseExceed/paycheckCount;
	                }
	                
	                if(finPlanningRatio > 0.5){
	                	obj.printBreakUp(authid);
	                	continue;
	                }
	                if(otherScore > 50){
	                	obj.printGoodProgress(authid);
	                }
		            /*System.out.println("finPlanningRatio: "+finPlanningRatio);
	                System.out.println("otherScore: "+otherScore);*/
	                expenseExceed = 0;
	                paycheckCount = 0;
	                otherScore = 0;
	                System.out.println();
		    	} catch (Exception e){
		    		System.out.println("Hello");
		    	}
		    }
		}
    }

}
