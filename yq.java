package yq;
import java.io.*;

public class yq {
    public static void main(String[] args) {
        System.out.println("yq yq_in.txt");
        String in_path = "D:\\shiyan2\\src\\yq\\yq_in.txt";
        String out_path = "D:\\shiyan2\\src\\yq\\yq_out.txt";
        try {
            //读文件流
            FileInputStream fin = new FileInputStream(in_path);
            InputStreamReader reader = new InputStreamReader(fin,"GBK");
            BufferedReader bufferedReader = new BufferedReader(reader);
            //写文件流
            FileOutputStream fout = new FileOutputStream(out_path);
            OutputStreamWriter writer = new OutputStreamWriter(fout,"GBK");
            BufferedWriter buffwriter = new BufferedWriter(writer);
            //处理txt
            String temp = "";
            String title = "";
            while((temp = bufferedReader.readLine()) != null){
                //待明确地区不记录
                if(temp.contains("待明确地区")) continue;
                //分割字符串中省份与其他信息
                String head = temp.substring(0,2);
                String msg = temp.substring(3);
                if (title.equals(head) != true) {
                    //单独输出省份
                    if(title != ""){
                        //System.out.println(title);
                        buffwriter.write("\r\n");
                    }
                    buffwriter.write(head.substring(0,2) + "\r\n");
                    title = head;
                }
                //输出剩余信息
                buffwriter.write(msg.trim() + "\r\n");
                buffwriter.flush();
            }
            //结束
            fin.close();
            fout.close();
            reader.close();
            writer.close();
            bufferedReader.close();
            buffwriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

