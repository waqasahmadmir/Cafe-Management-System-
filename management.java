package project;
import java.util.*;
import java.util.Collection;
import java.io.*;
import java.util.ArrayList;

public class management {
	//creating ArrayLists for product,staff,customer and for supply
	
	public static ArrayList product=new ArrayList();
	public static ArrayList customer=new ArrayList();
	public static ArrayList staff=new ArrayList();
	public static ArrayList supply=new ArrayList();
	
	// TODO Auto-generated method stub
			
	public static void main(String[] args)throws Exception { //main method
		
		File file=new File("myfile");
		
	
		if(!file.exists()) {
			try {
				file.createNewFile();
				try (ObjectOutputStream output=new ObjectOutputStream(new FileOutputStream("myfile"))){
				
					
				}
			}
			
		catch(IOException ex){
			System.out.println("IO Exception");
			
			}
		}
		
		else {
			try {
				ObjectInputStream input=new ObjectInputStream(new FileInputStream("myfile"));
				
				product.add(input.readObject());
				staff.add(input.readObject());
				customer.add(input.readObject());
				supply.add(input.readObject());
			
			}
			
			catch(FileNotFoundException ex) {
				System.out.println("file not found");
				
			}
			catch(IOException ex){
				System.out.println("IO Exception");
				
			}
		}
		
		//scanner object
		Scanner input=new Scanner(System.in);
		//try block to handle any exception
		try {
		System.out.println("enter your choice: 1)Product management  2)Staff Management  3)Customer Management  4)Supply System   5)Exit");
		int choice=input.nextInt();
		
		//choice 1 for product menu	
		if (choice==1) { 
			System.out.println("                           <PRODUCT MANAGEMENT SYSTEM>");
			 while(true) {
			       
			        try {
			        	
			        
					System.out.println("enter a choice :\n 1)Add records  2)View record 3) Search record 4)Edit Record  5)Delete Record 6)sort record  7)Exit");
					int check=input.nextInt();
					if (check==1) {
						addproduct();//calling method for adding product record
						continue;
					}
					
					else if(check==2) {
						//if we have already added some record then we can view it 
						if(product.size()>0) {
							
						viewproduct();
						}
						else {
							System.out.println("Please first add some record..");
							continue;
						}
						
						
					}
					else if(check==3) {
						//if we have already added some record then we can search it 
						if(product.size()>0) {
						searchproduct();
						}
						else {
							System.out.println("Please first add some record..");
							continue;
						}
						
					}
					else if(check==4) {
						if(product.size()>0) {
						editproduct();
						}
						else {
							System.out.println("Please first add some record..");
							continue;
						}
					
						}
					
					else if(check==5) {
						if(product.size()>0) {
						deleteproduct();
						}
						else {
							System.out.println("Please first add some record..");
							continue;
						}
					}
					else if(check==6) {
						if(product.size()>0) {
						sortproduct();
						}
						else {
							System.out.println("Please first add some record..");
							continue;
						}
					}
					else if(check==7) {
						main(args); // calling main method back to main menu
						
					}
					else {
						System.out.println("Invalid choice:");
						continue;
					}
				 }
			        //catch block for any exception
				 catch(InputMismatchException ex) {
					 exception();//calling of exception function
					 input.next();
				 }
				 }
			
		}
		//choice 2 for staff menu
		else if(choice==2) {
			System.out.println("                           <STAFF MANAGEMENT SYSTEM>");
			 while(true) {
	         try {
			System.out.println("enter a choice :\n 1)Add records 2)View record 3) Search record 4)Edit Record  5)Delete Record  6)Exit");
			int check=input.nextInt();
			if (check==1) {
				addstaff();
			}
			
			else if(check==2) {
				if(staff.size()>0) {
				
				viewstaff();}
				else {
					System.out.println("Please first add some record..");
					continue;
				}
				
			}
			else if(check==3) {
				if(staff.size()>0) {
				searchstaff();
				}
				else {
					System.out.println("Please first add some record..");
					continue;
				}
			}
			else if(check==4) {
				if(staff.size()>0) {
				editstaff();
				}
				else {
					System.out.println("Please first add some record..");
					continue;
				}
				
			}
			else if(check==5) {
				if(staff.size()>0) {
				deletestaff();
				}
				else {
					System.out.println("Please first add some record..");
					continue;
				}
			}
			else if(check==6) {
				main(args); //exiting form staff menu and back to main menu
				
			}
			else {
				System.out.println("invalid choice:");
				continue;//back to menu
			}
	         }
	         //exception block in case f any exception
	         catch(InputMismatchException ex){
	        	 exception();
	        	 input.next();
	        	 
	         }
			
		}
		}
		//choice 3 for customer menu
		else if(choice==3) {
			System.out.println("                           <CUSTOMER MANAGEMENT SYSTEM>");
			while(true) {
			 try {
					System.out.println("enter a choice :\n 1)Add records 2)View record 3) Search record 4)Edit Record  5)Delete Record  6)Exit");
					int check=input.nextInt();
					if (check==1) {
						addcust();
					}
					
					else if(check==2) {
						if(customer.size()>0) {
						viewcust();
						}
						else {
							System.out.println("Please first add some record..");
							continue;
						}
						
					}
					else if(check==3) {
						if(customer.size()>0) {
						searchcust();
						}
						else {
							System.out.println("Please first add some record..");
							continue;
						}
						
					}
					else if(check==4) {
						if(customer.size()>0) {
						editcust();
						}
						else {
							System.out.println("Please first add some record..");
							continue;
						}
						
					}
					else if(check==5) {
						if(customer.size()>0) {
						deletecust();
						}
						else {
							System.out.println("Please first add some record..");
							continue;
						}
						
					}
					else if(check==6) {
						main(args); //callig main method to go to main menu
					}
					else {
						System.out.println("invalid choice:");
						continue;
					}
			         }
			         catch(InputMismatchException ex) {//catch block in case of any exception
			        	 exception();
			        	 input.next();
			         }
			}
		
			
		}
		//choice 4 for supply system
		else if(choice==4) {
			
			//only accessible if user have already added product,customer and staff records..
			if(product.size()>0 && staff.size()>0 && customer.size()>0  ) {
			System.out.println("                           <SUPPLY MANAGEMENT SYSTEM>");
			while(true) {
				try {
					System.out.println("enter a choice :\n 1)Add supply 2)View supply 3) search supply  4)exit ");
					int check=input.nextInt();
					if (check==1) {
						addsupply();
					}
					
					else if(check==2) {
						if(supply.size()>0) {
						viewsupply();
						}
						else {
							System.out.println("Please first add some record..");
							continue;
						}
					}
					
					else if(check==3) {
						if(supply.size()>0) {
						searchsupply();
						}
						else {
							System.out.println("Please first add some record..");
							continue;
						}
					}
					else if(check==4){
						exitsupply();
						main(args);
						
					}
					else  {
						System.out.println("invalid choice:");
						continue;
					}
			         }
				//catch block in case of any exception
			         catch(InputMismatchException ex) {
			        	 exception();
			            input.next();
			        
			         }
			}
			
			}
			
			else {
				System.out.println("Please first add Prodduct,staff and customer record");
				main(args);
			}
		
		}
		//choice  to exit form the program
		else if(choice==5) {
			try {
			ObjectOutputStream output=new ObjectOutputStream(new FileOutputStream("myfile"));
			 
			
			output.writeObject(product);
			
			output.writeObject(staff);
			
			output.writeObject(customer);
			
			output.writeObject(supply);
			}
			catch(FileNotFoundException ex) {
				System.out.println("file not found");
				
			}
			catch(IOException e) {
				System.out.println("IO Exceotion");
			}
			exit();
			
			
		}
		//case for any other invalid choice
		else {
			System.out.println("invalid choice!!!");
			main(args);
		}
		
		}
		//catch block for exception
		catch(InputMismatchException ex) {
			exception();
			main(args);
		}
	
	}
	//method for adding customer record
public static void addproduct() {
		
		while (true){
			
			Scanner input=new Scanner(System.in);
			System.out.println("enter product name :");
			String name=input.nextLine();
			product.add(name); //add method to add any name  into arrayList of product
			while(true) {
			try { //try block to handle exceptions
			System.out.println("enter product price :");
			int price=input.nextInt();
			product.add(price);
			break;
			
			}
			//catch block in case of any exception occcured
			catch(InputMismatchException ex) {
				exception();
				input.next();

			}
			}
			while(true) {
			try {
			
			System.out.println("enter product quantity :");
			int quantity=input.nextInt();
			product.add(quantity);
			break;
			}
			catch(InputMismatchException ex) {
				exception();
				input.next();
				
			}
			}
		  while (true) {
			  try {
			System.out.println("enter product best use date :");
			String date=input.next();
			product.add(date);
			break;
			  }
			  catch(InputMismatchException ex) {
				 exception();
				  input.next();
			  } 
			
		  }
			//press 1 to add more records of products
		 
			System.out.println("press (1) to add more records: ");
			int y=input.nextInt();
	
			if (y==1) {
				addproduct();
			}
			else {
				break;
			}
		  
		  
		  
		  break;	
		} 
		 
}
	
//method for displaying products records 
public static void sortproduct() {
	ArrayList sortedproduct=new ArrayList();
	for(int i=0;i<product.size();i=i+4){
		sortedproduct.add(product.get(i));//appending just name of product in new list
		
	} 
	Collections.sort(sortedproduct);//sorting array
	int k=0; //for soted list
	System.out.println("                                    SORTED PRODUCT");
	System.out.println("PRODUCT NAME\t\tPRODUCT PRICE\t\tPRODUCT QUANTITY\t\tPRODUCT DATE");
	for(int j=0;j< product.size();j=j+4) {
		int ind=product.indexOf(sortedproduct.get(k)); //finding the index of name in product array
		System.out.println(sortedproduct.get(k)+"\t\t\t"+product.get(ind+1)+"\t\t\t"+product.get(ind+2)+"\t\t\t\t"+product.get(ind+3));
		
		k++; //increment for next name 
	}
}
public static void viewproduct() {
	System.out.println("PRODUCT NAME\t\tPRODUCT PRICE\t\tPRODUCT QUANTITY\t\tPRODUCT DATE");
	for(int i=0 ;i<product.size();i=i+4) { //loop till the length of array
	//viewing product record
	System.out.println(product.get(i)+"\t\t\t"+product.get(i+1)+"\t\t\t"+product.get(i+2)+"\t\t\t\t"+product.get(i+3));
	}
	
}
//method for searching any product record on the base of name.. 
public static void searchproduct() {
	  
	     Scanner input=new Scanner(System.in);
		 System.out.println("enter name of product you want to seach:");//name of product you want to search
		 String search=input.nextLine();
		 if(product.contains(search)) { //checking if required product exist in product list or not
			 int i=product.indexOf(search);
			System.out.println("PRODUCT NAME\t\tPRODUCT PRICE\t\tPRODUCT QUANTITY\t\tPRODUCT DATE");
			System.out.println(product.get(i)+"\t\t\t"+product.get(i+1)+"\t\t\t"+product.get(i+2)+"\t\t\t\t"+product.get(i+3));
		}
		else {

			System.out.println("This product not exist..."); //a message if required record not found
		}
}
//method for updating any record of products
public static void editproduct() {
	   Scanner input=new Scanner(System.in);
		System.out.println("enter name of product you want to edit:");
		String edit=input.nextLine();
		
		if (product.contains(edit)) { //checking existing of required record
			int ind=product.indexOf(edit);
			product.remove(ind); //remove function to delete record on the base of index
			product.remove(ind);
			product.remove(ind);
			product.remove(ind);
			
         // now adding new record to update
			System.out.println("enter new product name :");
			String name=input.nextLine();
			product.add(name);
			while(true) {
			try {
			System.out.println("enter new product price :");
			int price=input.nextInt();
			product.add(price);
			break;
			
			}
			catch(InputMismatchException ex) {
				exception();
				input.next();

			}
			}
			while(true) {
			try {
			
			System.out.println("enter new  product quantity :");
			int quantity=input.nextInt();
			product.add(quantity);
			break;
			}
			catch(InputMismatchException ex) {
				exception();
				input.next();
			}
			}
			while(true) {
			try {
				
			System.out.println("enter new product best use date :");
			String date=input.next();
			product.add(date);
			break;
			}
			catch(InputMismatchException ex) {
				exception(); //calling of exception function which is displaying the message for exception
			input.next();
			}
			
		}
		}
		else {
			System.out.println("This product not exist...");
		}	 
}

//method  to delete any record of products
public static void deleteproduct() {
	   Scanner input=new Scanner(System.in);
		System.out.println("enter name of product you want to delete:");
		String delete=input.nextLine();
		if (product.contains(delete)) { //checking the existing of record
		int ind=product.indexOf(delete); //finding the index of record
		
			product.remove(ind);//removing the record user want to delete by index
			product.remove(ind);
			product.remove(ind);
			product.remove(ind);
		}
		else {
			System.out.println("This product not exist ...");
		}
}

/**                        STAFF MANAGEMENT SYSTEM                         **/
//function for adding records of staff
public static void addstaff(){
	   while (true) { //infinite loop
	   Scanner input=new Scanner(System.in);
	   System.out.println("enter name of staff member :");
	   String name=input.nextLine();
	   
	   while(true) {
		   try {
			   
	   System.out.println("enter staff member ID : ");
	   int id=input.nextInt();
	   if(!staff.contains(id)) {//checking that either entered staff Id already exist or not.
		   staff.add(id);
		   staff.add(name);//adding record
		   }
		   else {
			   //if staff ID already exist 
			   System.out.println("This ID of staff already exist! try another..");
			   addstaff();//recalling to try any other ID
		   }
	   break;
		   }
		   catch(InputMismatchException ex) {//catch block to handle in case of any exception
			   exception(); //calling of exception function
			   input.next();
		   }
	   
	   }
	   
	while(true) {
		
	try {
		
	
	   System.out.println("salary of staff member :");
	   double salary=input.nextDouble();
	   staff.add(salary); //adding salary of staff member
	   break;
	}
	catch(InputMismatchException ex) { //catch block for exception
		exception();
		input.next();
	}
	}
	while(true) {
		try {
	   System.out.println("enter staff member contact number :");
	   long contact=input.nextLong();
	   staff.add(contact);
	   break;
		}
		catch(InputMismatchException ex) {
			exception();
			input.next();
		}
	}
	   System.out.println("Press (1) to add more records :"); //press 1 to add more records
	   int y=input.nextInt();
	   if (y==1) {
		   continue; //if 1 then back to loop
	   }
	   else {
		   break; //if not 1 then terminate from infinite loop
	   }
	   
	   }
	 
}


//method for display all the record of staff
public static void viewstaff(){
	   System.out.println("STAFF ID\t\tSTAFF NAME\t\tSTAFF SALARY\t\tCONTACT NO.");
	 //loop till the length of staff array with increament 4 to display the 4 attributes of each record
	   for(int i=0 ;i<staff.size();i=i+4) { 
			//getting the record of staff using .get method
			System.out.println(staff.get(i)+"\t\t\t"+staff.get(i+1)+" \t\t\t"+staff.get(i+2)+"\t\t\t"+staff.get(i+3));
	   }	

}
// method for searching any record of staff
public static void searchstaff(){
	   Scanner input=new Scanner (System.in);
	   while(true) {
		   try {
			   
	 System.out.println("enter staff ID you want to search :");//required id for searching
	   int search=input.nextInt();
	   if(staff.contains(search)) { //checking if this id exist or not
		   //finding the index of id
		  int ind=staff.indexOf(search);
		  //displaying the record against id
		  System.out.println("STAFF ID\t\tSTAFF NAME\t\tSTAFF SALARY\t\tCONTACT NO.");
			System.out.println(staff.get(ind)+"\t\t\t"+staff.get(ind+1)+"\t\t\t"+staff.get(ind+2)+"\t\t\t"+staff.get(ind+3));
			}
	   else {
		   System.out.println("this staff member does not exist!!"); //in case no record
	   }
	   break;
		   }
		   catch(InputMismatchException ex) { //catch block for exception
			   exception(); //calling of exception function
			   input.next();
		   }
	   }
	   
	  }
	   
//method for updating any staff record
public static void editstaff(){
	   Scanner input=new Scanner (System.in);
	   while (true) {
		   try {
	 //required to for updating
	   System.out.println("enter staff ID  you want to edit");
	   int edit=input.nextInt();
	   if(staff.contains(edit)) { //checking the existing of this id 
		   int ind=staff.indexOf(edit); //finding the index of required id 
		   staff.remove(ind); //deleting attributes by index
		   staff.remove(ind);
		   staff.remove(ind);
		   staff.remove(ind);
		   //Adding updated record of this id
		   while(true) {
			   try {
				   
			   System.out.println("enter new staff member ID : ");
			   int id=input.nextInt();
			   if(!staff.contains(id)) {
			   staff.add(id);
			   }
			   else {
				   System.out.println("This staff ID already exists....");
			   }
			   break;
			   }
			   catch(InputMismatchException ex) {
				   exception();
				   input.next();
			   }
		   }
			   
			   System.out.println("enter new  name of staff member :");
			   String name=input.next();
			   staff.add(name);
			   while(true) {
				   try {
					   
			   System.out.println("enter new salary of staff member :");
			   int salary=input.nextInt();
			   staff.add(salary);
			   break;
				   }
				   catch(InputMismatchException ex) {
					   exception();
					   input.next();
				   }
			   }
			  while(true) {
				  try {
					  
			   System.out.println("enter new  contact number :");
			   int contact=input.nextInt();
			   staff.add(contact);
			   break;
				  }
				   catch(InputMismatchException ex) {
					   exception();
					   input.next();
				   }
			   }
	   }
	   
		   else {
			   //case if id not found
			   System.out.println("This staff member does not exist!!!");
			    //calling main menu of staff
		   }
			   
		   break;
	   }
		   
	   catch(InputMismatchException ex) { //catch  block in case of any exception 
		   exception(); //calling of exception method
		   input.next();
	   }
	   }
}

//method for deletion of any record of staff  
public static void deletestaff(){
	   
	  Scanner input=new Scanner (System.in);
	  while(true) {
		  try {
			  
	   System.out.println("enter staff ID  you want to delete :");//id user want to delete
	   int delete=input.nextInt();
	  
	   if(staff.contains(delete)) {  //checking the existing of id
		   int ind=staff.indexOf(delete); //finding index of this entered id
		   staff.remove(ind); //removing of record on the base of index
		   staff.remove(ind);
		   staff.remove(ind);
		   staff.remove(ind);}

	   else {
		   //in case id not exist in staff array 
		   System.out.println("this staff member does not exist!!!");}
		   
	   break;
		  }
		  //catch block for exception
		  catch(InputMismatchException ex) {
			   exception();
			   input.next();
		  }
	  }

}

/**                        CUSTOMER MANAGEMENT SYSTEM                         **/
//method for adding customer records
public static void addcust(){
	while(true) {	 
	 Scanner input=new Scanner(System.in);
	 System.out.println("enter customer name :");
	 String name=input.nextLine();
	 customer.add(name);
	 
	 
	 System.out.println("enter customer address :");
	 String address=input.nextLine();
	 customer.add(address);
	  while(true) {
		  try {//try block to handle exception
	 System.out.println("enter customer contact number :");
	 long contact=input.nextLong();
	 customer.add(contact);
	 break;
		  }
      catch(InputMismatchException ex) {
			   exception();
			   input.next();
		   }
	   }
	 
	 System.out.println("enter product name customer want  :");
	 String prdct=input.next();
	 customer.add(prdct);
	 
	 System.out.println("pres (1) to add more records");
	 int y=input.nextInt();
	 //press 1 to add more customer records..
	 if(y==1) {
		 continue;
	 }
	 else {
		 break;
	 
	 }
	}
	  
  }

//method to view customer records
  public static void viewcust(){
	   System.out.println("CUSTOMER NAME\tADDRESS\t\tCONTACT NO.\t\tPRODUCT NAME");
	   for(int i=0 ;i<customer.size();i=i+4) {
			
			System.out.println(customer.get(i)+"\t\t"+customer.get(i+1)+"\t\t"+customer.get(i+2)+"\t\t"+customer.get(i+3));
			}
			
  }
  //method to search any customer record
  public static void searchcust(){
	   Scanner input=new Scanner(System.in);
	   System.out.println("enter customer name you Want to search :");
	  String search=input.next();
	  //checking either required customer exist in list or not
	  if(customer.contains(search)) {
		  int ind=customer.indexOf(search);
		  System.out.println("CUSTOMER NAME\tADDRESS\t\tCONTACT NO.\t\tPRODUCT NAME");
		  System.out.println(customer.get(ind)+"\t\t"+customer.get(ind+1)+"\t\t"+customer.get(ind+2)+"\t\t"+customer.get(ind+3));
	  }
	  else {
		  System.out.println("this customer does not exist!!!");
	  }
	 
	   
  }
  //method for updating customer records...
  public static void editcust(){
	   Scanner input=new Scanner(System.in);
	   System.out.println("enter customer name you Want to update :");
	  String edit=input.next();
	   int ind=customer.indexOf(edit);
	   if(customer.contains(edit)) {
		   customer.remove(ind);//removing attribute by index
		   customer.remove(ind);
		   customer.remove(ind);
		   customer.remove(ind);
		   
		   //now addig updated record
		   System.out.println("enter new name of customer :");
			 String name=input.next();
			 customer.add(name);
			 System.out.println("enter new product  name which customer want  :");
			 String prdct=input.next();
			 customer.add(prdct);
			 
			 System.out.println("enter new address of customer :");
			 String address=input.next();
			 customer.add(address);
			 while(true) {
				 try {
			System.out.println("enter new  customer contact number :");
			 long contact=input.nextLong();
		     customer.add(contact);
		     break;
				 }
				 catch(InputMismatchException ex) {
					   exception();
					   input.next();
				   }
			   }
	   }
	   else {
		   System.out.println("this customer does not exist!!!");
	   }
	  
	  
  }
  //method for deleting any customer record
  public static void deletecust(){
	   Scanner input=new Scanner(System.in);
	   
	   System.out.println("enter customer name you Want to delete :");
	  String delete=input.next();
	   int ind=customer.indexOf(delete); //finding index
	   if(customer.contains(delete)) {
		   customer.remove(ind); //remving by index
		   customer.remove(ind);
		   customer.remove(ind);
		   customer.remove(ind);
		   }
	   else {
		   System.out.println("this customer does not exist!!!");
	   }
	   
  }
  /**                        SUPPLY MANAGEMENT SYSTEM                         **/
  
//method for adding supply records
   public static void addsupply(){
	   Scanner input=new Scanner(System.in);
	   while(true) {
		 //entering customer name for supply
	   System.out.println("enter customer name for which supply required: ");
	   String name=input.next();
	   //checking either this customer exist in customer array or not
	   if (customer.contains(name)) { 
		   //Name of required product for customer
		   System.out.println("enter product name for which supply required: ");
		   String prdct=input.next(); 
		   //checking either this product exist in product stack or not
		   if(product.contains(prdct)) {
			   supply.add(name); //if exist then add in supply array
			   //if yes then add it to supply
			   supply.add(prdct);
			   while(true) {
				   try {
					   //entering quantity of product
			   System.out.println("enter quantity of required product: ");
			   int quantity =input.nextInt();
			   supply.add(quantity);
			   break;
				   }
				   //catch block for any exception
				   catch(InputMismatchException ex) {
					   exception();
					   input.next();
				   }
			   }
		   }
		   else {
			   // case when required product not exist
			   System.out.println("this product does not exist!!! ");
			   
		   }
	   }
	   else {
		   // case when customer with this name not exist
		   System.out.println("customer does not exist!! ");
		  
	   }
	   System.out.println("press(yes) to add more records ");//yes for more supply
	   String y=input.nextLine();
	   if(y=="yes") {
		   continue;
	   }
	   else {
		   break;
	   }
	   } //calling main menu of supply system
   }
   //method for displaying all the supplies
   public static void viewsupply(){
	   System.out.println("CUSTOMER NAME\tPRODUCT NAME\tQUANTITY\t\tPRICE\t\tUSE DATE\t\tDELIVERER NAME");
	   for(int i=0;i<supply.size();i=i+3) {
		   int ind=product.indexOf(supply.get(i+1));
		   int k=1;
		   System.out.println(supply.get(i)+"\t\t"+supply.get(i+1)+"\t\t"+supply.get(i+2)+"\t\t\t"+product.get(ind+1)+" \t\t"+product.get(ind+3)+"    \t\t"+staff.get(k));
		   k=k+4;
	   }
	  
   }
   //method for searching any supply
 public static void searchsupply(){
	 Scanner input=new Scanner(System.in);
	 //name of customer for which use want to search supply
	 System.out.println("enter customer name for which you want search supply :");
	 String search=input.next();
	 //checking the existing of customer
	 if(supply.contains(search)) {
		 //finding index of customer name 
		 int ind=supply.indexOf(search);
		 System.out.println("CUSTOMER NAME\tPRODUCT NAME\tQUANTITY\t\tPRICE\t\tUSE DATE \tDELIVERER NAME");
		   int j=1;
		   int k=1;
		   System.out.println(supply.get(ind)+"\t\t"+supply.get(ind+1)+"\t\t"+supply.get(ind+2)+"\t"+product.get(j)+"\t\t"+product.get(j+2)+"\t\t"+staff.get(k));
		 
	 }
	 else {
		 System.out.println("This customer does not exit in our customer list....");
	 }
	 
	
	   
   }
//method to exit from whole system
public static void exit() {
	
	 System.out.println("Thanks for using Programs!!!!");
	 System.exit(1);
}
   //method to exit from supply
 public static void exitsupply(){
	 
	 System.out.println("Thanks for using Programs!!!!");
 }
 //a method to display a message if any exception occur anywhere in whole program 
public static void exception() {
	
	System.out.println("Invalid input...");
	
	}

}

