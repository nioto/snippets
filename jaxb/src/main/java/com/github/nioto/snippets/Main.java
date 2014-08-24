package com.github.nioto.snippets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void write( Company company, FileOutputStream out )
    throws Exception  {
    	JAXBContext contextObj = JAXBContext.newInstance(Company.class);  
    	Marshaller marshallerObj = contextObj.createMarshaller();  
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        
        marshallerObj.marshal(company,  out );
    }
    public static Company read ( FileInputStream in)
    throws Exception  {
        JAXBContext jaxbContext = JAXBContext.newInstance(Company.class);  
   
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
        Company company = (Company) jaxbUnmarshaller.unmarshal(in);  
        
        return company;        
    }
    
    public static void main( String[] args )
    throws Exception  {
        Employee mark = new Employee("Mark", "Smith", 44);
        Employee john = new Employee("John", "House", 23);
        List<Employee> emp = new ArrayList<Employee>();
        emp.add( mark );
        emp.add( john );
        
        Company company = new Company(1, "Acme Inc.");
        company.setEmployees(emp);

        File file = new File( new File(System.getProperty("java.io.tmpdir") ), "out.xml");
        String filepath = file.getAbsolutePath() ;
        System.out.println( "Writing to file : " + filepath );
        FileOutputStream out = new FileOutputStream( filepath );
        
        write(company, out);
        
        Company company2 = read( new FileInputStream(filepath));
        
        System.out.println( company2 );
        System.out.println( company.equals( company2 ));
        
    }
}
