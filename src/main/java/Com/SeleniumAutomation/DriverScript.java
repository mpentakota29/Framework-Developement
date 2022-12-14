package Com.SeleniumAutomation;
import static Com.SeleniumAutomation.CommonFunctions.suitename;
import static Com.SeleniumAutomation.ReportFunctions.iteratorCnt;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DriverScript extends CommonFunctions implements Runnable 

{
	
	static WebDriver Webdriver;
	
	
//@SuppressWarnings("static-access")
public DriverScript(org.openqa.selenium.WebDriver WebDriver, String Path) throws IOException
{
		
		// TODO Auto-generated constructor stub
		this.Path = Path;
		CommonFunctions.WebDriver = WebDriver;
		

}

public void run()
  
 
    {
    	try {
			readSuitePath(Path);
		} catch (FileNotFoundException e)
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }


	public static int finval;
	public static int rowcount;
	public static int rowcount1;
	public static int colval;
	public static int colcount;
	public static int colcount1;
	public static int Rowval;
	public static String CellData;
	public static String CellData2;
	public static String NumVal;
	public static Sheet sheet;
	public static Sheet sheet1;
	public static int flag;
	public static String Strparameters;
	public static java.util.Date odate;
	public static String blankcell;
	public static int count;
	public static boolean CellValue;
	public static boolean blnResult = true;
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
	public static int x;
	public static int newcol = 0;
	public static boolean stop;
	public static String failvalue = null;
	public static int failcount = 0;
	public static String WDirectory = "key";
	public static Properties prop;
	public static Properties mobileprop;
	public static String docker;
    public static boolean dockerlaunch;
    public static boolean dockerChromeFirefoxedgelaunch = false;
    public static boolean dockerChromeFirefoxlaunch = false;
    public static boolean dockerChromelaunch = false;
    public static String browser;
    public static String parameter;
    public static boolean LocalLaunch = false;
	
	
	
   
	
			
			
		
	 //		try {
//				LAUNCHFIREFOXDOCKER(parameters);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//	

	
	
	 String Path;   
         
		
				
			
        		
			
			
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		
		
		//startDockerGrid();
		DriverScript ds = new DriverScript(driver2,"AmazonSuite");
		DriverScript ds2 = new DriverScript(driver,"FlipkartSuite");

	    
		Thread th  = new Thread(ds2);
		//Thread.sleep(6000);
		Thread th2  = new Thread(ds);
		
		th.start();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		th2.start();
		
		//readSuitePath("AmazonSuite");
		
	 }

	public static void readSuitePath(String FilePath) throws IOException, Exception,FileNotFoundException
	
	
	
	{
		
		//WebDriver driver = init_driver("chrome");
	     
		Thread.sleep(20000);

		//String suitepath =
	//	selectfile();
		//Readenvironmentalfile(envfilepath);
		//Readtestsuitefile(suitepath);
		
		 final long MSEC_SINCE_EPOCH = System.currentTimeMillis();
	        String workingDirectory = new java.io.File(".").getCanonicalPath();
	        String dir = workingDirectory;
	        String Estatus;
	        String esuite;
	        String suiteExecutionFile = dir + "\\SuiteFiles\\" + FilePath +".xlsx";
	        
	        
	        FileInputStream fs = new FileInputStream(suiteExecutionFile);
	        
	        Workbook wbs = new XSSFWorkbook(fs);
	        Sheet ssheet = wbs.getSheetAt(0);
	        int rc = ssheet.getLastRowNum();
	        int valr;
	        Cell cell1 = ssheet.getRow(1).getCell(3);
	        Cell cell2 = ssheet.getRow(1).getCell(4);
	        
	        
	        Cell cell3 = ssheet.getRow(1).getCell(5);
	        Cell cell4 = ssheet.getRow(1).getCell(6);
	        
            String Estatus1 = cell1.getStringCellValue();
            String Estatus2 = cell2.getStringCellValue();
            String Estatus3 = cell3.getStringCellValue();
            String Estatus4 = cell4.getStringCellValue();
            
           
	        if(Estatus1.trim().equalsIgnoreCase("Docker"))
        	{
	        	
	         dockerlaunch = true;
	         if(Estatus2.trim().equalsIgnoreCase("YES")&&Estatus3.trim().equalsIgnoreCase("YES")&&Estatus4.trim().equalsIgnoreCase("YES")) 
	         {
	        	 
	           dockerChromeFirefoxedgelaunch = true;
	        
	        	
	         }
	         
	         else if(Estatus2.trim().equalsIgnoreCase("YES")&&Estatus4.trim().equalsIgnoreCase("YES")) 
	       
	         {
	        	 
	           dockerChromeFirefoxlaunch = true;
	        	 
	        	 
	         }
	         
	         else if(Estatus2.trim().equalsIgnoreCase("YES")) 
	         {
	        	 
	           dockerChromelaunch = true;
	        	 
	         }
	    
	        	
        		
        	}
	        else if(Estatus1.trim().equalsIgnoreCase("Local")) 
	        {
	        	
		         LocalLaunch = true;
		         if(Estatus2.trim().equalsIgnoreCase("YES")&&Estatus3.trim().equalsIgnoreCase("YES")&&Estatus4.trim().equalsIgnoreCase("YES")) 
		         {
		        	dockerChromeFirefoxedgelaunch = true;
		        	 
		        	 
		         }
		         
		         else if(Estatus2.trim().equalsIgnoreCase("YES")&&Estatus4.trim().equalsIgnoreCase("YES")) 
		         {
		        	 dockerChromeFirefoxlaunch = true;
		        	 
		        	 
		         }
		         
		         else if(Estatus2.trim().equalsIgnoreCase("YES")) 
		         {
		        	 dockerChromelaunch = true;
		        	 
		    
	        	
	        }
	        for (valr = 1; valr <= rc; valr++) 
	        {
	        	
	            Row rs = ssheet.getRow(valr);
	            if (rs != null) {
	        
	                Cell cell = ssheet.getRow(valr).getCell(1);
	                Estatus = cell.getStringCellValue();
	                
	                if (Estatus.trim().equalsIgnoreCase("YES")) 
	                {
	                	
	                    cell = ssheet.getRow(valr).getCell(0);
	                    esuite = cell.getStringCellValue();
	                    getEnvironmentDetails(esuite, dir);
	                }
	                
	               
	            }
	        
	        
	       
	        
	     
	      
			readObjRepositoryFile();
			readMobileObjRepositoryFile();
			
		
			
			   
	        
	        
			Thread.sleep(10000);
		
	        
			  
	       
			
	        
	        
	      
	           ReportFunctions.tsID =0;
	    
	           
	           
	           ReportFunctions.tcID=0;
	           ReportFunctions.tstpID=0;
	           iteratorCnt=0;
	           hmap.remove(updstpstatus);
	           TCpasscount = 0;
	           TCfailcount = 0;
	           casecount =0;
	        }
	        
	      
	        
	        wbs.close();
	        
	        }
	}

	public static void readObjRepositoryFile()
	{
    final String propFile = System.getProperty("user.dir")+ "//Resources//Object_Repository.properties";
	File file = new File(propFile);
	FileInputStream fileInput = null;
	try {
		fileInput = new FileInputStream(file);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	 prop = new Properties();
	try {
		prop.load(fileInput);
	} catch (IOException e) {
		e.printStackTrace();
	}
    }
	
	public static void readMobileObjRepositoryFile() 
	{
	    final String mobpropFile = System.getProperty("user.dir")+ "//Resources//Mobile_Object_Repository.properties";
		File mobfile = new File(mobpropFile);
		FileInputStream mobfileInput = null;
		try {
			mobfileInput = new FileInputStream(mobfile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		mobileprop = new Properties();
		try {
			mobileprop.load(mobfileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
	    }
	   public static void getEnvironmentDetails(String runsuitename, String dir) throws Exception {
	        Tsuitename = runsuitename;
	        String suitepath = dir + "\\TestSuites\\" + runsuitename+".xlsx";
	        if (suitename == null) {
	            suitename = "suitename";
	        }
	        hmap.put(suitename, Tsuitename);
	        FOLDERSTRUCTURE(runsuitename);
	        Readenvironmentalfile(envfilepath);
	        Readtestsuitefile(suitepath);

	    }

	

	public static void Initializationscript(String testcasepath) throws Throwable {
		try {
			Strparameters = "";
			count = 1;
			String FilePath = testcasepath;
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = new XSSFWorkbook(fs);
			sheet = wb.getSheetAt(0);
			Cell cell = null;
			// wb.setMissingCellPolicy(Row.CREATE_NULL_AS_BLANK);
			rowcount = sheet.getLastRowNum();
			colcount = sheet.getRow(rowcount).getLastCellNum();
			int Rowval = 0;
			int colval = 0;
			try {
				/*
				 * Below Do while, loops until it found cell with string "keyword" and stores
				 * the row value in finval variable
				 */
				do {
					for (colval = 0; colval <= colcount - 1; colval++)
					{
						Row ro = sheet.getRow(Rowval);

						if (ro != null)

						{
						   cell = sheet.getRow(Rowval).getCell(colval);
							int cel_Type = cell.getCellType();
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_NUMERIC:
								if
								(DateUtil.isCellDateFormatted(sheet.getRow(Rowval).getCell(colval))) {
									odate = cell.getDateCellValue();
                                    break;
								} else {
									NumVal = String.valueOf((int) cell.getNumericCellValue()).trim();
								}
								break;
							case Cell.CELL_TYPE_STRING:
								CellData = cell.getStringCellValue().trim();
								break;
							case Cell.CELL_TYPE_BLANK:
								blankcell = "";
								break;
							case Cell.CELL_TYPE_BOOLEAN:
								CellValue = cell.getBooleanCellValue();
								break;

							default:
								break;
							}

						}
							// if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
							//CellData = cell.getStringCellValue();
							//CellData.trim();
							// System.out.println(CellData);
							if (cell.getRichStringCellValue().getString().trim().toUpperCase().equals("KEYWORD")) {
								finval = Rowval + 1;
								Rowval = rowcount + 1;
								// System.out.println(finval);
								break;
							}
							// }
						}
					
				
					Rowval = Rowval + 1;
				} while (rowcount + 1 > Rowval);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			int currentrow = finval;
			/*
			 * Below while, loops until it reaches end of file
			 */
			while (rowcount + 1 > currentrow) {
				/*
				 * Below for loop, itirates through all columns and reads each cell data
				 */
				for (colval = 0; colval <= colcount - 1; colval++) {
					try {
						Row r1 = sheet.getRow(currentrow);
						if (r1 != null) {
							cell = sheet.getRow(currentrow).getCell(colval);
							int cel_Type = cell.getCellType();
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_NUMERIC:
								if (DateUtil.isCellDateFormatted(sheet.getRow(currentrow).getCell(colval))) {
									odate = cell.getDateCellValue();
									// System.out.println(sdf.format(odate));
									flag = 1;

								} else {
									NumVal = String.valueOf((int) cell.getNumericCellValue()).trim();
									flag = 2;
								}
								break;
							case Cell.CELL_TYPE_STRING:
								CellData = cell.getStringCellValue().trim();
								flag = 3;
								break;
							case Cell.CELL_TYPE_BLANK:
								blankcell = "";
								flag = 4;
								break;
							case Cell.CELL_TYPE_BOOLEAN:
								CellValue = cell.getBooleanCellValue();
								flag = 5;
								break;

							default:
								break;
							}

						}
						if (flag == 1) {
							Strparameters = Strparameters + "->" + sdf.format(odate).trim();
						} else if (flag == 2) {
							Strparameters = Strparameters + "->" + NumVal.trim();
						} else if (flag == 3) {

							Strparameters = Strparameters + "->" + CellData.trim();
							if (count == 1) {
								Strparameters = Strparameters.replace("->", "");
							}
							count = count + 1;
						} else if (flag == 4) {
							Strparameters = Strparameters + blankcell;
						} else if (flag == 5) {
							Strparameters = Strparameters + "->" + CellValue;
						}
					} catch (Exception e) {
						// System.out.println(e.getMessage());
					}
				}
				/*
				 * Strparameters stores 4 column values of each row
				 */
				String[] parameters = Strparameters.split("->");

				if (Tstep == null) {
					Tstep = "Tstep";
				}
				hmap.put(Tstep, parameters[0]);
				if (parameters[0].contains("#")) {
					Strparameters = "";
					count = 1;
					currentrow = currentrow + 1;
				} else {
					if (parameters[0].contains("$")) {
						parameters[0] = parameters[0].replace("$", "").trim();
						String args[] = parameters[0].split("ELSE");
						if (blnResult == false) {
							if (args[1].contains("&")) {
								String finval1[] = args[1].split("&");
								int ub = finval1.length;
								/*
								 * Below for loop read the report line from input sheet and replaces variables
								 * with actual values from HashMap and also changes '&' symbol to '*' to change
								 * variable colour to green in reports This loop is for failed Report
								 */
								for (int w = 1; w <= ub - 1; w++) {
									if (hmap.containsKey(finval1[w])) {
										String oval = hmap.get(finval1[w]);
										oval = " " + oval + " ";
										args[1] = args[1].replace(finval1[w], oval);
										args[1] = args[1].replace("&", "*");
									}
								}
							}
							if (failvalue.contains("'")) {
								failvalue = failvalue.replace("'", "");
							}
							if (failvalue.contains(",")) {
								failvalue = failvalue.replace(",", "");
							}
							if (args[1].contains("'")) {
								args[1] = args[1].replace("'", "");
							}
							if (args[1].contains(",")) {
								args[1] = args[1].replace(",", "");
							}
							if (parameters[0].contains("'")) {
								parameters[0] = parameters[0].replace("'", "");
							}
							if (parameters[0].contains(",")) {
								parameters[0] = parameters[0].replace(",", "");
							}
							ReportFunctions.LogRepoter("Fail", parameters[0],
									args[1] + " " + "-" + " " + "Unable to find " + " " + failvalue);
							failcount = 0;
							// ReportFunctions.LogRepoter("Fail", parameters[0], args[1]);
							stop = false;
							  if(ExecutionMode.equalsIgnoreCase("MOBILE")) {
                              } else {
                              	CLOSEALLBROWSERS(driver);
                              }
							break;
						} else {
							if (args[0].contains("&")) {
								String finval[] = args[0].split("&");
								int ub = finval.length;
								/*
								 * Below for loop read the report line from input sheet and replaces variables
								 * with actual values from HashMap and also changes '&' symbol to '*' to change
								 * variable colour to green in reports This loop is for Pass Report
								 */
								for (int w = 1; w <= ub - 1; w++) {
									if (hmap.containsKey(finval[w])) {
										String oval = hmap.get(finval[w]);
										oval = " " + oval + " ";
										args[0] = args[0].replace(finval[w], oval);
										args[0] = args[0].replace("&", "*");
									}
								}
							}
							if (args[0].contains("'")) {
								args[0] = args[0].replace("'", "");
							}
							if (args[0].contains(",")) {
								args[0] = args[0].replace(",", "");
							}
							if (parameters[0].contains("'")) {
								parameters[0] = parameters[0].replace("'", "");
							}
							if (parameters[0].contains(",")) {
								parameters[0] = parameters[0].replace(",", "");
							}
//                            
							ReportFunctions.LogRepoter("Pass", parameters[0], args[0]);
							failcount = 0;
						}

						Strparameters = "";
						count = 1;
						currentrow = currentrow + 1;

					} else {
						if (Strparameters.toUpperCase().contains("SKIP")) {
							Strparameters = "";
							count = 1;
							currentrow = currentrow + 1;
						} else {
							if (stop == true) {

							} else {
								blnResult = Invokekeyword(parameters[0], Strparameters);
							}
							if (blnResult == false) {
								// failvalue = parameters[2];
								if (failcount == 0) {
									failvalue = parameters[1];
									// hmap.put(failvalue, parameters[2],);
									failcount = failcount + 1;
								}
								if (Tsuitename.toUpperCase().contains("SANITY")) {
								} else {
									// Strparameters = "";
									// count = 1;
									// currentrow = currentrow + 1;
									stop = true;
									// break;
								}
							}
							Strparameters = "";
							count = 1;
							currentrow = currentrow + 1;
						}
					}
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		 if (muldatastatus.equals("Yes")) {
	            String temp = null;
	            MulInitializationscript(testcasepath);
	        }

	}
	public static void MulInitializationscript(String testcasepath) throws Throwable {
        try {

            Strparameters = "";
            count = 1;
            Boolean skipflag = false;
            String FilePath = testcasepath;
            FileInputStream fs = new FileInputStream(FilePath);
            Workbook wb = new XSSFWorkbook(fs);
            sheet = wb.getSheetAt(0);
            sheet1 = wb.getSheetAt(1);
            // wb.setMissingCellPolicy(Row.CREATE_NULL_AS_BLANK);
            // rowcount = sheet.getLastRowNum();
            rowcount = sheet.getPhysicalNumberOfRows();
            Row r = sheet.getRow(rowcount - 1);
            colcount = r.getLastCellNum();
            //  colcount = sheet.getRow(rowcount).getLastCellNum();
            // rowcount1 = sheet1.getLastRowNum();
            rowcount1 = sheet1.getPhysicalNumberOfRows();
            Row r5 = sheet1.getRow(rowcount1 - 1);
            colcount1 = r5.getLastCellNum();
            //colcount1 = sheet1.getRow(rowcount1).getLastCellNum();
            int Rowval = 0;
            int colval = 0;
            int Rowval1;
            /*
                Below for loop gets total row count in multiple sheet
             */
            for (Rowval1 = 1; Rowval1 <= rowcount1; Rowval1++) {
                /*
                Below Do while, loops until it found cell with string "keyword"
                and stores the row value in finval variable
                 */
                do {
                    Cell cell1 = sheet1.getRow(Rowval1).getCell(0);
                    Tcasename = cell1.getStringCellValue();
                    hmap.put(Tcase, Tcasename);
                    for (colval = 0; colval <= colcount - 1; colval++) {
                        Row ro = sheet.getRow(Rowval);
                        if (ro != null) {
                            Cell cell = sheet.getRow(Rowval).getCell(colval);
                            //int cel_Type = cell.getCellType();
                            // if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                            CellData = cell.getStringCellValue();
                            CellData.trim();
                            //System.out.println(CellData);
                            if (cell.getRichStringCellValue().getString().trim().equals("Keyword")) {
                                finval = Rowval + 1;
                                Rowval = rowcount + 1;
                                //System.out.println(finval);
                                break;
                            }
                            //}
                        }
                    }
                    Rowval = Rowval + 1;
                } while (rowcount + 1 > Rowval);

                int currentrow = finval;

                while (rowcount + 1 > currentrow) {
                    /*
                Below  for loop, itirates through all columns and reads each cell data
                     */
                    for (colval = 0; colval <= colcount - 2; colval++) {
                        Row r1 = sheet.getRow(currentrow);
                        if (r1 != null) {
                            Cell cell = sheet.getRow(currentrow).getCell(colval);
                            int cel_Type = cell.getCellType();
                            switch (cell.getCellType()) {
                                case Cell.CELL_TYPE_NUMERIC:
                                    if (DateUtil.isCellDateFormatted(sheet.getRow(currentrow).getCell(colval))) {
                                        odate = cell.getDateCellValue();
                                        //  System.out.println(sdf.format(odate));
                                        flag = 1;

                                    } else {
                                        NumVal = String.valueOf((int) cell.getNumericCellValue());
                                        flag = 2;
                                    }
                                    break;
                                case Cell.CELL_TYPE_STRING:
                                    CellData = cell.getStringCellValue().trim();
                                    flag = 3;
                                    break;
                                case Cell.CELL_TYPE_BLANK:
                                    blankcell = "";
                                    flag = 4;
                                    break;
                                case Cell.CELL_TYPE_BOOLEAN:
                                    CellValue = cell.getBooleanCellValue();
                                    flag = 5;
                                    break;

                                default:
                                    break;
                            }

                        }
                        if (flag == 1) {
                            Strparameters = Strparameters + "->" + sdf.format(odate).trim();
                        } else if (flag == 2) {
                            Strparameters = Strparameters + "->" + NumVal.trim();
                        } else if (flag == 3) {

                            Strparameters = Strparameters + "->" + CellData.trim();
                            if (count == 1) {
                                Strparameters = Strparameters.replace("->", "");
                            }
                            count = count + 1;
                        } else if (flag == 4) {
                            Strparameters = Strparameters + blankcell;
                        } else if (flag == 5) {
                            Strparameters = Strparameters + "->" + CellValue;
                        }
                    }
                    try {
                        /*
                Below  piece of code read data from multiple sheet and append to Strparameters
                         */
                        Cell cell2 = sheet.getRow(currentrow).getCell(2);
                        if (cell2.getCellType() == cell2.CELL_TYPE_BLANK) {
                        } else {
                            Cell cell1 = sheet1.getRow(Rowval1).getCell(newcol + 1);
                            if (cell1.getCellType() == cell2.CELL_TYPE_NUMERIC) {
                                CellData = String.valueOf((int) cell1.getNumericCellValue());
                                Strparameters = Strparameters.trim() + "->" + CellData.trim();
                                newcol = newcol + 1;
                            } else {
                                CellData = cell1.getStringCellValue();
                                Strparameters = Strparameters.trim() + "->" + CellData.trim();
                                newcol = newcol + 1;
                                if (CellData.toUpperCase().equalsIgnoreCase("SKIP")) {
                                    skipflag = true;
                                }
                            }
                        }
                    } catch (Exception e) {

                        //e.printStackTrace();
                        // System.out.println(e.getMessage());
                    }

                    String[] parameters = Strparameters.split("->");
                    if (Tstep == null) {
                        Tstep = "Tstep";
                    }
                    hmap.put(Tstep, parameters[0]);
                    if ((Tcasename.contains("#")) || (Strparameters.contains("#"))) {
                        Strparameters = "";
                        count = 1;
                        currentrow = currentrow + 1;
                    } else {
                        if (parameters[0].contains("$")) {
                            parameters[0] = parameters[0].replace("$", "").trim();
                            String args[] = parameters[0].split("ELSE");
                            if (blnResult == false) {
                                if (args[1].contains("&")) {
                                    String finval[] = args[1].split("&");
                                    int ub = finval.length;
                                    /*
                                Below for loop read the report line from input sheet and replaces variables with actual values
                                from HashMap and also changes '&' symbol to '*' to change variable colour to green in reports
                                * This loop is for Fail Report
                                     */
                                    for (int w = 1; w <= ub - 1; w++) {
                                        if (hmap.containsKey(finval[w])) {
                                            String oval = hmap.get(finval[w]);
                                            oval = " " + oval + " ";
                                            args[1] = args[1].replace(finval[w], oval);
                                            args[1] = args[1].replace("&", "*");
                                        }
                                    }
                                }
                                if (failvalue.contains("'")) {
                                    failvalue = failvalue.replace("'", "");
                                }
                                if (failvalue.contains(",")) {
                                    failvalue = failvalue.replace(",", "");
                                }
                                if (parameters[0].contains("'")) {
                                    parameters[0] = parameters[0].replace("'", "");
                                }
                                if (parameters[0].contains(",")) {
                                    parameters[0] = parameters[0].replace(",", "");
                                }
                                if (args[1].contains("'")) {
                                    args[1] = args[1].replace("'", "");
                                }
                                if (args[1].contains(",")) {
                                    args[1] = args[1].replace(",", "");
                                }

                                ReportFunctions.LogRepoter("Fail", parameters[0], args[1] + " " + "-" + " " + "Unable to find " + " " + failvalue);
                                failcount = 0;
                                //  ReportFunctions.LogRepoter("Fail", parameters[0], args[1]);
                                stop = false;
                                if(ExecutionMode.equalsIgnoreCase("MOBILE"))
                                {
                                } else {
                                	CLOSEALLBROWSERS(driver);
                                }
                                
                                break;
                            } else {
                                if (args[0].contains("&")) {
                                    String finval[] = args[0].split("&");
                                    int ub = finval.length;
                                    /*
                                Below for loop read the report line from input sheet and replaces variables with actual values
                                from HashMap and also changes '&' symbol to '*' to change variable colour to green in reports
                                * This loop is for Pass Report
                                     */
                                    for (int w = 1; w <= ub - 1; w++) {
                                        if (hmap.containsKey(finval[w])) {
                                            String oval = hmap.get(finval[w]);
                                            oval = " " + oval + " ";
                                            args[0] = args[0].replace(finval[w], oval);
                                            args[0] = args[0].replace("&", "*");
                                        }
                                    }
                                }

                                if (args[0].contains("'")) {
                                    args[0] = args[0].replace("'", "");
                                }
                                if (args[0].contains(",")) {
                                    args[0] = args[0].replace(",", "");
                                }
                                if (parameters[0].contains("'")) {
                                    parameters[0] = parameters[0].replace("'", "");
                                }
                                if (parameters[0].contains(",")) {
                                    parameters[0] = parameters[0].replace(",", "");
                                }

                                ReportFunctions.LogRepoter("Pass", parameters[0], args[0]);
                                failcount = 0;
                            }

                            Strparameters = "";
                            count = 1;
                            currentrow = currentrow + 1;
                        } else {
                            if (skipflag == true) {
                                Strparameters = "";
                                count = 1;
                                skipflag = false;
                                currentrow = currentrow + 1;
                            } else {
                                if (stop == true) {

                                } else {

                                    blnResult = Invokekeyword(parameters[0], Strparameters);
                                }
                                if (blnResult == false) {
                                    stop = true;
//                            if (Tsuitename.toUpperCase().contains("SANITY")) {
//                            } else {
                                    if (failcount == 0) {
                                        failvalue = parameters[1];
                                        failcount = failcount + 1;
                                    }
                                    // break;
//                            }
                                }
                                Strparameters = "";
                                count = 1;

                                currentrow = currentrow + 1;
                            }
                        }
                    }
                }
                // x = x + 1;
                //Tcasename = Tcasename + "_" + x;
                //hmap.put(Tcase, Tcasename);
                // Tcasename = Tcasename.replace("_" + x, "");
                newcol = 0;
                Strparameters = "";
                count = 1;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

	

}
