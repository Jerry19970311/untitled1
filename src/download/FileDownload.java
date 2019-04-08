package download;

import bean.NewsItem;
import com.google.gson.Gson;

import java.io.*;

public class FileDownload implements Downloadable{
    //protected String based;//基本路径（精确到source，也就是面向同一新闻网站）
    /*public FileDownload(String based){
        this.based=based;
    }*/
    @Override
    public void download(String dir,String path,NewsItem newsItem){
        //String dir=this.based+"/"+getDateIn8bits(newsItem.getPublish_time())+"/"+newsItem.getType()+"/";
        //System.out.println("dir:"+dir);
        forDir(dir);
        //String path=dir+newsItem.getSource()+"-"+newsItem.getId();
        String text=getStringFromNewsItem(newsItem);
        BufferedWriter writer;
        try {
            writer=forFile(path);
            writer.write(text);
            writer.flush();
            writer.close();
            newsItem.setText_path(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void downloadText(String dir,String path,String text){
        try {
            BufferedWriter writer=forFile(path+".txt");
            char[] buffer=text.toCharArray();
            writer.write(buffer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void forDir(String dir){
        File file=new File(dir);
        if(!file.exists()){
            System.out.println("Creating dir");
            file.mkdirs();
        }
    }
    public BufferedWriter forFile(String path) throws IOException {
        File file=new File(path);
        file.createNewFile();
        FileOutputStream fileOutputStream=new FileOutputStream(file,true);
        OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream);
        BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);
        return bufferedWriter;
    }

    public String getStringFromNewsItem(NewsItem newsItem){
        return getJsonFromNewsItem(newsItem);
    }

    public String getJsonFromNewsItem(NewsItem newsItem){
        Gson gson=new Gson();
        return gson.toJson(newsItem);
    }
}
