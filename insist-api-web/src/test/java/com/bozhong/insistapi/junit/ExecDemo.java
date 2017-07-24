package com.bozhong.insistapi.junit;

class ExecDemo {
        public static void main(String args[]){ 
                Runtime r = Runtime.getRuntime(); 
                Process p = null; 
                try{ 
                        p = r.exec("wkhtmltopdf http://localhost:8080/admin/pdf.htm?appId=9 C:\\1.pdf");
                } catch (Exception e) { 
                        System.out.println("Error executing notepad."); 
                } 
        } 
}