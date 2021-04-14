import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) throws  IOException {
        // TODO Auto-generated method stub
        
    	File file = new File("result.txt");  //生成保存结果的文件
    	                                                                   
    	FileOutputStream fop = new FileOutputStream(file);

             if (!file.exists()) {
                 file.createNewFile();
             }
        
    	
    	int x;//题目数量
    	System.out.println("请输入题目的数量：");
		Scanner scan2 = new Scanner(System.in);
		x = scan2.nextInt();
		String serialNo = "201571030306";
		
	    fop.write(serialNo.getBytes());   //写入学号 
	    fop.write("\r\n".getBytes());     //换行
	    
        for(int i=0;i<x;i++){
            int a=(int)(Math.random()*100);
            int b=(int)(Math.random()*100);
            int c=(int)(Math.random()*100);
            
            String q="";    //保存运算式
            int ans=0;
            int[] flag=new int[2];
            for(int j=0;j<2;j++){      
                int f=(int)(Math.random()*4);
                switch(f){
                case 0:
                    if(j==0){
                        q=a+"+"+b;
                    }
                    else{
                        q=q+"+"+c;
                    }
                    flag[j]=0;
                    break;
                case 1:
                    if(j==0){
                        q=a+"-"+b;
                    }
                    else{
                        q=q+"-"+c;
                    }
                    flag[j]=1;
                    break;
                case 2:
                    if(j==0){
                        q=a+"*"+b;
                    }
                    else{
                        q=q+"*"+c;
                    }
                    flag[j]=2;
                    break;
                case 3:
                    if(j==0){
                        q=a+"/"+b;
                    }
                    else{
                        q=q+"/"+c;
                    }
                    flag[j]=3;
                    break;
                }
            }
            if(flag[0]<2){
                if(flag[1]<2){
                    if(flag[0]==0){
                        ans=a+b;
                    }
                    else{
                        ans=a-b;
                    }
                    if(flag[1]==0){
                        ans+=c;
                    }
                    else{
                        ans-=c;
                    }
                }
                else{
                    if(flag[1]==2){
                        ans=b*c;
                    }
                    else{
                        if(c==0){
                            continue;
                        }
                        if(b<c || b%c!=0) {
                        	i=i-1;       //如果出现重新循环
                        	continue;   //判断结果不能为负数和非整数
                        }
                        ans=b/c;
                    }
                    if(flag[0]==0){
                        ans+=a;
                    }
                    else{
                        ans=a-ans;
                    }
                }
            }
            else{
                if(flag[0]==2){
                    ans=a*b;
                }
                else{
                    if(b==0){
                        continue;
                    }
                    if(a<b || a%b!=0) {
                    	i=i-1;       //如果出现重新循环
                    	continue;   //判断结果不能为负数和非整数
                    }
                    ans=a/b;
                }
                if(flag[1]==0){
                    ans+=c;
                }
                else if(flag[1]==1){
                    ans-=c;
                }
                else if(flag[1]==2){
                    ans*=c;
                }
                else{
                    if(c==0){
                        continue;
                    }
                    if(ans<c || ans%c!=0) {
                    	i=i-1;       //如果出现重新循环
                    	continue;   //判断结果不能为负数和非整数
                    }
                    ans/=c;
                }
            }
            
            if(ans<0) //判断结果不能为负数
            {
            	i=i-1; continue;
            }   
            
            q=q+"="+ans;           //用字符串将算式和答案连在一起
            System.out.println(q);
            fop.write(q.getBytes());    //写入表达式
            fop.write("\r\n".getBytes());   //换行
        }
	    fop.close();
    }
         
}