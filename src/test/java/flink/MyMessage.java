package flink;

import java.util.Date;

/**
 * Created by lyl
 * Date 2018/11/25
 */
public class MyMessage {
    public String name;
    public int score;
    public long currentTimeStamp;

    public MyMessage(){}

    public static MyMessage fromString( String s ){
        String[] tokens = s.split( "," );
        if(tokens.length != 3) throw new RuntimeException( "Invalid record: " + s );

        try{
            MyMessage message = new MyMessage();
            message.name = tokens[0];
            message.score = Integer.parseInt(tokens[1]);
            message.currentTimeStamp = Long.parseLong(tokens[2]);
            return message;
        }catch(NumberFormatException e){
            throw new RuntimeException("Invalid record: " + s);
        }
    }

    public String toString(){
        return String.format("%s,%d,%dl", name, score, currentTimeStamp);
    }
}
