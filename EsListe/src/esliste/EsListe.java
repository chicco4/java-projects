package esliste;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author federico.scaggiante
 */
public class EsListe {
	public static void main(String[] args) throws FileNotFoundException {
		//ES1();
		//ES2();
		//ES3();
		//ES4();
		ES5();
	}
	public static void ES1(){
		ListaConcatenata a=new ListaConcatenata();
		System.out.println(a.toString());
		System.out.println(a.size());
		String[] b={"aa","bb","cc"};
		ListaConcatenata c=new ListaConcatenata(b);
		System.out.println(c.toString());
		System.out.println(c.size());
	}
	public static void ES2(){
		String[] b={"aa","bb","cc"};
		ListaConcatenata c=new ListaConcatenata(b);
		System.out.println(c.toString());
		System.out.println(c.size());
		c.addHead("dd");
		System.out.println(c.toString());
		System.out.println(c.size());
		c.addTail("ee");
		System.out.println(c.toString());
		System.out.println(c.size());
		c.removeHead();
		System.out.println(c.toString());
		System.out.println(c.size());
		c.removeTail();
		System.out.println(c.toString());
		System.out.println(c.size());
	}
	public static void ES3(){
		String[] b={"aa","bb","cc"};
		ListaConcatenata c=new ListaConcatenata(b);
		System.out.println(c.toString());
		System.out.println(c.size());
		System.out.println(c.get(1));
		c.set(1,"dd");
		System.out.println(c.toString());
		System.out.println(c.size());
		c.add(1,"ee");
		System.out.println(c.toString());
		System.out.println(c.size());
		c.remove(1);
		System.out.println(c.toString());
		System.out.println(c.size());
	}
	public static void ES4(){
		//inutile metodo
	}
	public static void ES5() throws FileNotFoundException{
		try{
                File inFile = new File("input.txt");
		Scanner inScan=new Scanner(inFile);
		String b=inScan.nextLine();
		ListaConcatenata c=new ListaConcatenata();
		int q=0;
		for(int i=0;i<b.length();i++){
			if(b.charAt(i)==','||b.charAt(i)==' '||b.charAt(i)==';'){
				c.addTail(b.substring(q,i));
				q=i+1;
			}
			if(b.charAt(i)=='.'){
					c.addTail(b.substring(q,i));
					q=i+1;
			}else{
				if(i+1==b.length()){
					c.addTail(b.substring(q,i+1));
				}
			}
		}
		System.out.println(c.toString());
                }catch(java.io.FileNotFoundException e){
                    System.out.println("File not Found");
                }
	}
}	
