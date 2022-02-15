package com.jonasermert;


/*
 * Jonas Ermert
 * 1.0
 */

import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class Email {

    public Scanner s = new Scanner(System.in);

        private String fname;
        private String lname;
        private String department;
        private String email;
        private String password;
        private int mailCapacity = 500;
        private String alter_email;

        public Email(String fname, String lname) {
            this.fname = fname;
            this.lname = lname;
            System.out.println("New Employee:" + this.fname + " " + this.lname);
        }

    public Email(String fname, String lname, String department, String email, String password, int mailCapacity, String alter_email) {
        // this.s = s;
        this.fname = fname;
        this.lname = lname;
        this.department = department;
        this.email = email;
        this.password = password;
        this.mailCapacity = mailCapacity;
        this.alter_email = alter_email;
    }

    private String generateMail(){
            return this.fname.toLowerCase() + "." + this.lname.toLowerCase() + "@" + this.department.toLowerCase() + ".company";
    }

    private String chooseDepartmentCodes() {

            System.out.println("Department codes \n1 for Sales \n2 for Development \n3 for Accounting and \n0 for Exit");
            boolean flag = false;

            do {
                System.out.println("Enter Department Code");
                int choice = s.nextInt();
                switch (choice) {
                    case 1:
                        return "Sales";

                    case 2:
                        return "Development";

                    case 3:
                        return "Account";

                    case 0:
                        return "Exit";

                    default:
                        System.out.println("Invalid choice please choose again");
                }
            } while (!flag);

            return null;

        }

        private String generateRandomPassword(int length) {
            Random r = new Random();
            String CapitalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String SmallChars = "abcdefghijklmnopqrstuvwxyz";
            String numbers = "0123456789";
            String symbols = "!_@#+§$%?&";
            String values = CapitalChars + SmallChars + numbers + symbols;
            String password = "";

            for (int i = 0; i < length; i++) {
                password = password + values.charAt(r.nextInt(values.length()));
            }

            return password;
        }

        public void changePassword() {
            boolean flag = false;

            do {
                System.out.println("Do you want to change your password? (Y/N)");
                char answer = s.next().charAt(0);

                if (answer == 'Y' || answer == 'y') {
                    flag = true;
                    System.out.println("Enter your current password:");
                    String temp = s.next();

                    if (temp.equals(this.password)) {
                        System.out.println("Enter new password:");
                        this.password = s.next();
                        System.out.println("Password changed");
                    }
                    else {
                        System.out.println("Incorrect password");
                    }
                } else if(answer == 'N' || answer == 'n') {
                    flag = true;
                    System.out.println("Canceled");
                } else {
                    System.out.println("Enter valid choice");
                }
            } while(!flag);
        }


    public void set_mailCap() {
        System.out.println("Current capacity = " + this.mailCapacity + "mb");
        System.out.print("Enter new capacity: ");
        this.mailCapacity = s.nextInt();
        System.out.println("MAILBOX CAPACITY CHANGED SUCCESSFULLY!");

    }

    // Set the alternate email
    public void alternate_email() {
        System.out.print("Enter new alternate email: ");
        this.alter_email = s.next();
        System.out.println("ALTERNATE EMAIL SET SUCCESSFULLY!");
    }

    public void getInfo() {
        System.out.println("NAME: " + this.fname + " " + this.lname);
        System.out.println("DEPARTMENT: " + this.dept);
        System.out.println("EMAIL: " + this.email);
        System.out.println("PASSWORD: " + this.password);
        System.out.println("MAILBOX CAPACITY: " + this.mailCapacity + "mb");
        System.out.println("ALTER EMAIL: " + this.alter_email);
    }

    public void storefile() {
        try {
            FileWriter in = new FileWriter("C:\\Users\\Dell\\Desktop\\Info.txt");
            in.write("First Name: "+this.fname);
            in.append("Last Name: "+this.lname);
            in.append("Email: "+this.email);
            in.append("Password: "+this.password);
            in.append("Capacity: "+this.mailCapacity);
            in.append("Alternate mail: "+this.alter_email);
            in.close();
            System.out.println("Stored..");
        }catch (Exception e){System.out.println(e);}
    }

    public void read_file() {
        try {
            FileReader f1 = new
                    FileReader("C:\\Users\\Jonas\\Desktop\\Info.txt");
            int i;
            while ((i = f1.read()) != -1) {
                System.out.print((char) i);
            }
            f1.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();

    }

    /*
    public Scanner getS() {
        return s;
    }

    public void setS(Scanner s) {
        this.s = s;
    }
    */

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getlname() {
        return lname;
    }

    public void setlname(String lname) {
        this.lname = lname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMailCapacity() {
        return mailCapacity;
    }

    public void setMailCapacity(int mailCapacity) {
        this.mailCapacity = mailCapacity;
    }

    public String getAlter_email() {
        return alter_email;
    }

    public void setAlter_email(String alter_email) {
        this.alter_email = alter_email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email1 = (Email) o;
        return mailCapacity == email1.mailCapacity && Objects.equals(s, email1.s) && Objects.equals(fname, email1.fname) && Objects.equals(lname, email1.lname) && Objects.equals(department, email1.department) && Objects.equals(email, email1.email) && Objects.equals(password, email1.password) && Objects.equals(alter_email, email1.alter_email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(s, fname, lname, department, email, password, mailCapacity, alter_email);
    }

    @Override
    public String toString() {
        return "Email{" +
                "s=" + s +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", department='" + department + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", mailCapacity=" + mailCapacity +
                ", alter_email='" + alter_email + '\'' +
                '}';
    }
}
