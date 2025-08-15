import java.util.*;
class TaxCalculator{
	//console clear method
	public final static void clearConsole(){
		try{
			final String os = System .getProperty("os.name");
			if (os.contains("Windows")){
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			}
			else{
				System.out.print(" 033[HI 033[2J");
				System.out.flush();
			}
		}
		catch (final Exception e) {
			e.printStackTrace();
			//Handle any exceptions.
		}
	}
	//calculation of renttax
	public static double CalRentTax(int rent){
		rent-=100000;
		double tax = rent*0.10;
		return tax;
	}
	//calculation of bankinterest tax
	public static double CalBankInTax(int bank){
		double tax = bank*0.05;
		return tax;
	}
	//calculation of dividend tax
	public static double CalDivTax(int div){
		div-=100000;
		double tax = div*0.14;
		return tax;
	}
	//calculation of sales tax
	public static double findSalesTax(int val){
		double stax = val*0.025;
		return stax;
	}
	//calculation of VAT tax
	public static double findVAT(int val){
		double VAT = (val+findSalesTax(val))*0.15;
		return VAT;
	}
	//calculation of lease
	public static double calLeaseAmount(int amo,int rate,int year){
		int mon = year*12;
		double i = (double)rate/100;
		double lease = ((double)amo*(i/12))/(1-(1/Math.pow(1+(i/12),mon)));
		return lease;
	}
	//calculation of lease
	public static double calLeaseAmount2(int amo,int year,int rate){
		int mon = year*12;
		double i = (double)rate/100;
		double lease = (double)amo*(1-(1/Math.pow(1+(i/12),mon)))/(i/12);
		lease = Math.round(lease);
		return lease;
	}
	public static boolean promptOne(String w){
		Scanner input = new Scanner(System.in);
		boolean x = true;
		System.out.print("\nDo you want to calculate another "+w+" (Y/N) : ");
		String op3 = input.next();
		if(op3.equals("N")||op3.equals("n")){
			x = false;
		}
		return x;
	}
	public static boolean promptTwo(){
		Scanner input = new Scanner(System.in);
		boolean x = true;
		System.out.print("\nDo you want to enter the correct value again (Y/N) : ");
		String op3 = input.next();
		if(op3.equals("N")||op3.equals("n")){
			x = false;
		}
		return x;
	}
	//rent tax case
	public static void RentTax(){
		Scanner input = new Scanner(System.in);
		while(true){
			System.out.println("\n+-------------------------------------------------------+");
			System.out.println("|			RENT TAX			|");
			System.out.println("+-------------------------------------------------------+\n");
			
			System.out.print("Enter your rent\t: ");
			int rent = input.nextInt();
			
			if(rent<=100000&&rent>0){
				System.out.println("\n\tYou don't have to pay rent tax...");
				
				if(promptOne("Rent Tax")==false){
					break;
				}
			}
			else if(rent>100000&&rent>0){
				double rent_tax = CalRentTax(rent);
				System.out.printf("\n\tYou have to pay Rent Tax : %.2f\n",rent_tax);
				
				if(promptOne("Rent Tax")==false){
					break;
				}
			}
			else{
				System.out.println("\n\tInvalid Input...");
				
				if(promptTwo()==false){
					break;
				}
			}
			clearConsole();
		}
	}
	//Bank interest tax case
	public static void BankInterestTax(){
		Scanner input = new Scanner(System.in);
		while(true){
			System.out.println("\n+-------------------------------------------------------+");
			System.out.println("|		BANK INTEREST TAX			|");
			System.out.println("+-------------------------------------------------------+\n");
			
			System.out.print("Enter your bank interest per year\t: ");
			int bank = input.nextInt();
			
			if(bank>0){
				System.out.printf("\n\tYou have to pay Bank Interest Tax per year : %.2f\n",CalBankInTax(bank));
				if(promptOne("Bank Interest Tax")==false){
					break;
				}
			}
			else{
				System.out.println("\n\tInvalid Input...");
				if(promptTwo()==false){
					break;
				}
			}
			clearConsole();
		}
	}
	//Dividend Tax case
	public static void DividendTax(){
		Scanner input = new Scanner(System.in);
		while(true){
			System.out.println("\n+-------------------------------------------------------+");
			System.out.println("|			DIVIDEND TAX			|");
			System.out.println("+-------------------------------------------------------+\n");
			
			System.out.print("Enter your total dividend per year\t: ");
			int div = input.nextInt();
			
			if(div<=100000&&div>0){
				System.out.println("\n\tYou don't have to pay rent tax...");
				
				if(promptOne("Dividend Tax")==false){
					break;
				}
			}
			else if(div>100000&&div>0){
				double div_tax = CalDivTax(div);
				System.out.printf("\n\tYou have to pay Dividend Tax per year : %.2f\n",div_tax);
				
				if(promptOne("Dividend Tax")==false){
					break;
				}
			}
			else{
				System.out.println("\n\tInvalid Input...");
				
				if(promptTwo()==false){
					break;
				}
			}
			clearConsole();
		}
	}
	//Payable tax case
	public static void PayableTax(){
		Scanner input = new Scanner(System.in);
		while(true){
			System.out.println("\n+-------------------------------------------------------+");
			System.out.println("|			PAYABLE TAX			|");
			System.out.println("+-------------------------------------------------------+\n");
			
			System.out.print("Enter your employee payment per month\t: ");
			int pay = input.nextInt();
			
			double tax = 0;
			double tax1=41667*0.06;
			double tax2=41667*0.12;
			double tax3=41667*0.18;
			double tax4=41667*0.24;
			double tax5=41667*0.30;
			
			if(pay<=100000&&pay>0){
				System.out.println("\n\tYou don't have to pay payable tax...");
				if(promptOne("Income Tax")==false){
					break;
				}
			}
			else if(pay>100000&&pay<=141667){
				tax=(pay-100000)*0.06;
			}
			else if(pay>141667&&pay<=183333){
				tax=((pay-141667)*0.12)+tax1;
			}
			else if(pay>183333&&pay<=225000){
				tax=((pay-183333)*0.18)+tax1+tax2;
			}
			else if(pay>225000&&pay<=266667){
				tax=((pay-225000)*0.24)+tax1+tax2+tax3;
			}
			else if(pay>266667&&pay<=308333){
				tax=((pay-266667)*0.30)+tax4+tax3+tax2+tax1;
			}
			else if(pay>308333){
				tax=((pay-308333)*0.36)+tax1+tax2+tax3+tax4+tax5;
				//tax1=41667*0.36;
			}
			else{
				System.out.println("\n\tInvalid Input...");
			}
			
			if(pay>0){
				System.out.printf("\nYou have to pay payable tax per month : %.2f\n",tax);
				if(promptOne("Payable Tax")==false){
					break;
				}
			}
			else{
				if(promptTwo()==false){
					break;
				}
			}
			clearConsole();
		}
	}
	//Income tax case
	public static void IncomeTax(){
		Scanner input = new Scanner(System.in);
		while(true){
			System.out.println("\n+-------------------------------------------------------+");
			System.out.println("|			INCOME TAX			|");
			System.out.println("+-------------------------------------------------------+\n");
			
			System.out.print("Enter your total income per year\t: ");
			int income = input.nextInt();
			
			double tax = 0;
			double tax1=500000*0.06;
			double tax2=500000*0.12;
			double tax3=500000*0.18;
			double tax4=500000*0.24;
			double tax5=500000*0.30;
			
			if(income<=1200000&&income>0){
				System.out.println("\n\tYou don't have to pay payable tax...");
				if(promptOne("Income Tax")==false){
					break;
				}
			}
			else if(income>1200000&&income<=1700000){
				tax=(income-1200000)*0.06;
			}
			else if(income>1700000&&income<=2200000){
				tax=((income-1700000)*0.12)+tax1;
			}
			else if(income>2200000&&income<=2700000){
				tax=((income-2200000)*0.18)+tax1+tax2;
			}
			else if(income>2700000&&income<=3200000){
				tax=((income-2700000)*0.24)+tax1+tax2+tax3;
			}
			else if(income>3200000&&income<=3700000){
				tax=((income-3200000)*0.30)+tax4+tax3+tax2+tax1;
			}
			else if(income>3700000){
				tax=((income-3700000)*0.36)+tax1+tax2+tax3+tax4+tax5;
			}
			else{
				System.out.println("\n\tInvalid Input...");
				if(promptTwo()==false){
					break;
				}
			}
			
			if(income>1200000){
				System.out.printf("\nYou have to pay payable tax per month : %.2f\n",tax);
				if(promptOne("Income Tax")==false){
					break;
				}
			}
			clearConsole();
		}
	}
	//SSCLTax case
	public static void SSCLTax(){
		Scanner input = new Scanner(System.in);
		while(true){
			System.out.println("\n+-----------------------------------------------------------------------+");
			System.out.println("|		SOCIAL SECURITY CONTRIBUTION LEVY (SSCL) TAX		|");
			System.out.println("+-----------------------------------------------------------------------+\n");
			
			System.out.print("Enter your total income per year\t: ");
			int val = input.nextInt();
			
			if(val>0){
				double total = findSalesTax(val)+findVAT(val);
				System.out.printf("%nYou have to pay SSCL tax\t\t: %.2f%n",total);
				if(promptOne("SSCL Tax")==false){
					break;
				}
			}
			else{
				System.out.println("\n\tInvalid Input...");
				if(promptTwo()==false){
					break;
				}
			}
			clearConsole();
		}	
	}
	//cal lease payment case
	public static void LeasingPayment(){
		Scanner input = new Scanner(System.in);
	L1:	while(true){
			System.out.println("\n+-------------------------------------------------------+");
			System.out.println("|		CALCULATE LEASING PAYMENT		|");
			System.out.println("+-------------------------------------------------------+\n");
			
			System.out.print("Enter Lease Amount\t\t: ");
			int amo = input.nextInt();
			System.out.print("Enter annual interest rate\t: ");
			int rate = input.nextInt();
			System.out.print("Enter number of the year\t: ");
			int year = input.nextInt();
			if(amo>0&&rate>0&&year<=5){
				double lease = calLeaseAmount(amo,rate,year);
				System.out.printf("\nYour monthly installment\t: %.2f\n",lease);
				if(promptOne("Lease payment")==false){
					break;
				}
			}
			if(year>5&&rate<0){
				System.out.println("\nInvalid annual rate...Enter the correct value again\n");
				System.out.print("Enter annual interest rate\t: ");
				rate = input.nextInt();
				System.out.println("\nInvalid number of year...Enter the correct value again\n");
				System.out.print("Enter number of the year\t: ");
				year = input.nextInt();
				while(true){
					if(year<=5&&rate>0){
						double lease = calLeaseAmount(amo,rate,year);
						System.out.printf("\nYour monthly installment\t: %.2f\n",lease);
						if(promptOne("Lease payment")==false){
							break L1;
						}
						break;
					}else if(year<=5&&rate<0){
						System.out.println("\nInvalid annual rate...Enter the correct value again\n");
						System.out.print("Enter annual interest rate\t: ");
						rate = input.nextInt();
					}else if(year>5&&rate>0){
						System.out.println("\nInvalid number of year...Enter the correct value again\n");
						System.out.print("Enter number of the year\t: ");
						year = input.nextInt();
					}else{
						System.out.println("\nInvalid annual rate...Enter the correct value again\n");
						System.out.print("Enter annual interest rate\t: ");
						rate = input.nextInt();
						System.out.println("\nInvalid number of year...Enter the correct value again\n");
						System.out.print("Enter number of the year\t: ");
						year = input.nextInt();
					}
				}
				
			}
			if(year>5){
				while(true){
					System.out.println("\nInvalid number of year...Enter the correct value again\n");
					System.out.print("Enter number of the year\t: ");
					year = input.nextInt();
					if(year<=5){
						double lease = calLeaseAmount(amo,rate,year);
						System.out.printf("\nYour monthly installment\t: %.2f\n",lease);
						if(promptOne("Lease payment")==false){
							break L1;
						}
						break;
					}
				}
			}
			if(rate<0){
				while(true){
					System.out.println("\nInvalid annual rate...Enter the correct value again\n");
					System.out.print("Enter annual interest rate\t: ");
					rate = input.nextInt();
					if(rate>0){
						double lease = calLeaseAmount(amo,rate,year);
						System.out.printf("\nYour monthly installment\t: %.2f\n",lease);
						if(promptOne("Lease payment")==false){
							break L1;
						}
						break;
					}
				}
			}
			if(amo<0){
				while(true){
					System.out.println("\nInvalid amount...Enter the correct value again\n");
					System.out.print("Enter Lease Amount\t: ");
					amo = input.nextInt();
					if(amo>0){
						double lease = calLeaseAmount(amo,rate,year);
						System.out.printf("\nYour monthly installment\t: %.2f\n",lease);
						if(promptOne("Lease payment")==false){
							break L1;
						}
						break;
					}
				}
			}
			clearConsole();
		}	
	}
	public static void leaseCategories(int amo,int rate){
		double lease = calLeaseAmount(amo,rate,3);
		System.out.printf("\n\tYour monthly installment\t: %.2f",lease);
		lease = calLeaseAmount(amo,rate,4);
		System.out.printf("\n\tYour monthly installment\t: %.2f",lease);
		lease = calLeaseAmount(amo,rate,5);
		System.out.printf("\n\tYour monthly installment\t: %.2f\n",lease);
	}
	public static void searchLeaseCat(){
		Scanner input = new Scanner(System.in);
		while(true){
			System.out.println("\n+-------------------------------------------------------+");
			System.out.println("|		SEARCH LEASING CATEGORY 		|");
			System.out.println("+-------------------------------------------------------+\n");
			
			System.out.print("Enter Lease Amount\t\t: ");
			int amo = input.nextInt();
			System.out.print("Enter annual interest rate\t: ");
			int rate = input.nextInt();
			
			if(amo>0&&rate>0){
				leaseCategories(amo,rate);
				if(promptOne("Lease Categories")==false){
					break;
				}
			}
			else{
				System.out.println("\nInvalid Input...");
				if(promptTwo()==false){
					break;
				}
			}
			clearConsole();
		}
	}
	//
	public static void leaseAmount(){
		Scanner input = new Scanner(System.in);
		while(true){
			System.out.println("\n+-------------------------------------------------------+");
			System.out.println("|			FIND LEASING AMOUNT 		|");
			System.out.println("+-------------------------------------------------------+\n");
			
			System.out.print("Enter Lease Amount\t\t: ");
			int amo = input.nextInt();
			System.out.print("Enter number of year\t\t: ");
			int year = input.nextInt();
			System.out.print("Enter annual interest rate\t: ");
			int rate = input.nextInt();
			
			if(amo>0&&rate>0&&year<=5){
				double lease = calLeaseAmount2(amo,year,rate);
				System.out.printf("\nYou can get Lease Amount\t: %.2f\n",lease);
				if(promptOne("monthly installment")==false){
					break;
				}
			}
			else{
				System.out.println("\nInvalid Input...");
				if(promptTwo()==false){
					break;
				}
			}
			clearConsole();
		}
	}
	public static void main(String args[]){
		int op1 = 0;
		int op2 = 0;
		do{
			System.out.println();
			System.out.println("					 __   ______  ________ ________");
			System.out.println("					|  \\ /      \\|        |        \\");
			System.out.println("					 \\$$|  $$$$$$| $$$$$$$$\\$$$$$$$$");
			System.out.println("					|  \\| $$   \\$| $$__      | $$");
			System.out.println("					| $$| $$     | $$  \\     | $$");
			System.out.println("					| $$| $$   __| $$$$$     | $$");
			System.out.println("					| $$| $$__/  | $$_____   | $$");
			System.out.println("					| $$ \\$$    $| $$     \\  | $$");
			System.out.println("					 \\$$  \\$$$$$  \\$$$$$$$$   \\$$\n\n");
			System.out.println("  _______            __    __     _____              _        _____   _     _   _                  _______   ____    _____");
			System.out.println(" |___ ___|    /\\     \\ \\  / /    / ____|     /\\     | |      / ____| | |   | | | |          /\\    |___ ___| / __ \\  |  __ \\");
			System.out.println("    | |      /  \\     \\ \\/ /    | |         /  \\    | |     | |      | |   | | | |         /  \\      | |   | |  | | | |__) |");
			System.out.println("    | |     / /\\ \\     >  <     | |        / /\\ \\   | |     | |      | |   | | | |        / /\\ \\     | |   | |  | | |  _  /");
			System.out.println("    | |    / ____ \\   / /\\ \\    | |____   / ____ \\  | |____ | |____  | |___| | | |____   / ____ \\    | |   | |__| | | | \\ \\");
			System.out.println("    |_|   /_/    \\_\\ /_/  \\_\\    \\_____| /_/    \\_\\ |______| \\_____|  \\_____/  |______| /_/    \\_\\   |_|    \\____/  |_|  \\_\\\n\n");
			
			System.out.println("===================================================================================================================================\n\n");
			
			System.out.println("\t[01] Withholding Tax\n");
			System.out.println("\t[02] Payable Tax\n");
			System.out.println("\t[03] Income Tax\n");
			System.out.println("\t[04] Social Security Contribution Tax\n");
			System.out.println("\t[05] Leasing Payment\n");
			System.out.println("\t[06] Exit\n");
			
			Scanner input = new Scanner(System.in);
			System.out.print("Enter an option to continue -> ");
			op1 = input.nextInt();
			clearConsole();
			
			switch(op1){
				case 1:
					do{
						System.out.println("+-----------------------------------------------+");
						System.out.println("|		WITHHOLDING TAX			|");
						System.out.println("+-----------------------------------------------+\n");
						
						System.out.println("\t[01] Rent Tax\n");
						System.out.println("\t[02] Bank Interest Tax\n");
						System.out.println("\t[03] Dividend Tax\n");
						System.out.println("\t[04] Exit\n");
						
						System.out.print("Enter an option to continue -> ");
						op2 = input.nextInt();
						clearConsole();
						
						switch(op2){
							case 1:
								RentTax();
								clearConsole();
								break;
							case 2:
								BankInterestTax();
								clearConsole();
								break;
							case 3:
								DividendTax();
								clearConsole();
								break;
							case 4:							
								break;
							default:
								System.out.println("Invalid input!!");
						}
					}while(op2!=4);
					break;
				case 2:
					PayableTax();
					clearConsole();
					break;
				case 3:
					IncomeTax();
					clearConsole();
					break;
				case 4:
					SSCLTax();
					clearConsole();
					break;
				case 5:
					do{
						System.out.println("+-----------------------------------------------+");
						System.out.println("|		LEASING PAYMENT			|");
						System.out.println("+-----------------------------------------------+\n");
						
						System.out.println("\t[01] Calculate Monthly Installment\n");
						System.out.println("\t[02] Search Leasing Category\n");
						System.out.println("\t[03] Find Leasing Amount\n");
						System.out.println("\t[04] Exit\n");
						
						System.out.print("Enter an option to continue -> ");
						op2 = input.nextInt();
						clearConsole();
						
						switch(op2){
							case 1:
								LeasingPayment();
								clearConsole();
								break;
							case 2:
								searchLeaseCat();
								clearConsole();
								break;
							case 3:
								leaseAmount();
								clearConsole();
								break;
							case 4:							
								break;
							default:
								System.out.println("Invalid input!!");
						}
					}while(op2!=4);
					break;
				case 6:
					
					break;
				default:
					System.out.println("Invalid input!!");
			}
		}while(op1!=6);
	}
}
